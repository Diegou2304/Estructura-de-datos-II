/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Diego U
 */
import javax.swing.JTextArea;

public class ArbolBinario {
    
    private NodoBin raiz;
    
    public ArbolBinario() {
        raiz = null;
    }
    public NodoBin getRaiz(){
        return raiz;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean esHoja(NodoBin p){
        return p.getHI()==null && p.getHD()==null;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean incompleto(NodoBin p)
    {
        if((p.getHI()==null && p.getHD()!=null) || (p.getHI()!=null && p.getHD()==null))
        {
            return true;
        }
        return false;
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
    public void insertar(int x){ 
        NodoBin q=new NodoBin(x);
        if(raiz==null){//cuando el arbol esta vacio 
            raiz=q;
            return;
        }
        NodoBin p=raiz;
        NodoBin ap=null;
        while(p!=null){ 
            ap=p;
            if(x<p.getElem()){
                p=p.getHI();
            }
            else{
                if(x>p.getElem()){
                    p=p.getHD();
                }
                else{
                    return;
                }
            }  
        }
        if(x<ap.getElem()){
            ap.setHI(q);
        }
        else{
            ap.setHD(q);
        } 
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void preOrden(NodoBin p,JTextArea jta){
        if(p!=null){
            jta.append(Integer.toString(p.getElem())+"   ");
            preOrden(p.getHI(),jta);
            preOrden(p.getHD(),jta);
        }
    }
    public void preOrden(JTextArea jta){
        
        preOrden(raiz,jta);
        
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     private void inOrden(NodoBin p,JTextArea jta){
        if(p!=null){
            inOrden(p.getHI(),jta);
            jta.append(Integer.toString(p.getElem())+"   ");
            inOrden(p.getHD(),jta);
        }
    }
    public void inOrden(JTextArea jta){
        jta.setText("");
        inOrden(raiz,jta);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void postOrden(NodoBin p,JTextArea jta){
        if(p!=null){
            postOrden(p.getHI(),jta);
            postOrden(p.getHD(),jta);
            jta.append(Integer.toString(p.getElem())+"   ");
        }
    }
    public void postOrden(JTextArea jta){
        jta.append("postOrden: ");
        postOrden(raiz,jta);
        jta.append("\n");
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int suma(NodoBin p){
        if(p==null){
            return 0;
        }
        else{
            if(esHoja(p)){
                return p.getElem();
            }
            else{
                int ai=suma(p.getHI());   
                int ad=suma(p.getHD());
                return ai+ad+p.getElem();
            }
        }
    }
    public int suma(){
        return suma(raiz);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int cant(NodoBin p){
        if(p==null){
            return 0;
        }
        else{
            if(esHoja(p)){
                return 1;
            }
            else{
                int ai=cant(p.getHI());
                int ad=cant(p.getHD());
                return ai+ad+1;
            }
        }
    }
    public int cant(){
        return cant(raiz);
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private int altura(NodoBin p){
        if(p==null){
            return 0;
        }
        else{
            if(esHoja(p)){
                return 1;
            }
            else{
                int ai=altura(p.getHI());
                int ad=altura(p.getHD());
                if(ai>ad){
                    return ai+1;
                }
                else{
                    return ad+1;
                }
            }
        }
    }
    public int altura(){
       return altura(raiz);
     }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private boolean existe(NodoBin p,int x){
        if(p==null){
            return false;
        }
        else{
            boolean ai=existe(p.getHI(),x);
            boolean ad=existe(p.getHD(),x);

            if(ai==true || ad==true){
                return true;
            }
            else{
                return p.getElem()==x;
            }
        }
        
    }
    public boolean existe(int x){
        return existe(raiz,x);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private boolean hermanos(NodoBin p,int x,int y){
       if(!esHoja(p) && !incompleto(p))
        {
            boolean ai=hermanos(p.getHI(),x,y);
            boolean ad=hermanos(p.getHD(),x,y);
            if( ai==true|| ad==true){
              return true;
            }  
            else{
                if((p.getHI().getElem()==x && p.getHD().getElem()==y )|| (p.getHI().getElem()==y && p.getHD().getElem()==x)){
                    return true;
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }
    public boolean hermanos(int x, int y){
        return hermanos(raiz,x,y);
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////     
    public NodoBin buscar(NodoBin a,int x){
        NodoBin p=a;
        while(p!=null){
            if(x==p.getElem()){
                return p;
            }
            else{
                if(x< p.getElem()){
                    p=p.getHI();
                }
                else{
                    if(x>p.getElem()){
                        p=p.getHD();
                    }
                }
            }
        }
        return null;//retorna null lo cual significa que no lo encontro
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private void mostrarPares(NodoBin p,JTextArea jta){
       if(p!=null){
            if(p.getElem() % 2==0){
                jta.append(Integer.toString(p.getElem())+"   ");
            }
            mostrarPares(p.getHI(),jta);
            mostrarPares(p.getHD(),jta);
        }
   }
   public void mostrarPares(JTextArea jta){
        jta.append("preOrden Pares: ");
        mostrarPares(raiz,jta);
        jta.append("\n");
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private NodoBin devolverPadre(NodoBin p, int x){//profe
       if(p==null || esHoja(p)){
           return null;
       }
       
       if(p.getHI()!=null){
           if(p.getHI().getElem()==x){
               return p;
           }
       }
       if(p.getHD()!=null){
            if(p.getHD().getElem()==x){
               return p;
           }
       }
       
       NodoBin ai=devolverPadre(p.getHI(),x);
       NodoBin ad=devolverPadre(p.getHD(),x);
       
       if(ai!=null){
           return ai;
       }
       else{
           return ad;
       }
   }
   public NodoBin devolverPadre(int x){
       if(existe(x) && x!=raiz.getElem()){
           return devolverPadre(raiz,x);
       }
       return null;
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public NodoBin devolverHermano(int x){
       if(existe(x) && x!=raiz.getElem() && !incompleto(devolverPadre(x))){
           NodoBin p=devolverPadre(x);
           if(p.getHD().getElem()==x){
               return p.getHI();
           }
           else{
               return p.getHD();
           }
       }
      return null; 
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public NodoBin devolverTio(int x){
       if(existe(x) && x!=raiz.getElem() ){
           NodoBin p=devolverPadre(x);
           return devolverHermano(p.getElem());
       }
      return null; 
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public NodoBin devolverAbuelo(int x){
         if(existe(x) && x!=raiz.getElem() ){
           NodoBin p=devolverPadre(x);
           return devolverPadre(p.getElem());
       }
      return null; 
    }   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean primos(int x,int y){
        if(existe(x)&& existe(y) && x!=raiz.getElem() && y!=raiz.getElem() && !hermanos(x,y)){
            if( devolverAbuelo(x).getElem()==devolverAbuelo(y).getElem() ){
                return true;
            }
        }
    return false;
    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
   public void mostrarDescendientes(int x,JTextArea jta){
       NodoBin q=buscar(raiz,x);
       preOrden(q,jta);
   }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
//   public Cola amplitud(){
//       NodoBin a=raiz;
//       Cola cola,colaAux;
//       NodoBin  aux;
//       if(a!=null){//si contiene nodos
//           cola=new Cola();//creo una cola
//           colaAux=new Cola();//creo una cola aux
//           cola.meter(a);//inserto el valor del nodo raiz
//           while(!cola.vacia()){
//               aux=cola.sacar();
//               
//               colaAux.meter(aux);
//               
//               if(aux.getHI()!=null){
//                   cola.meter(aux.getHI());
//               }
//               if(a.getHD()!=null){
//                   cola.meter(aux.getHD());
//               }
//           }
//       return colaAux;
//       }
//       return null;
//   }
   
//////////////////////////////////////////////////////////////////////////////////////////////////////////////   
public boolean EsListaIzquierda()
{
    return EsListaIzquierda(this.raiz);
}
private boolean EsListaIzquierda(NodoBin P)// :V Este es algún ejercicio del practico 1
{
    
    boolean k=false;
  if(P==null) return k;
  else
  {
      if(esHoja(P))
      {
          k=true;
          return k;
          
      }
          
      else
      {
          if(this.raiz==P)
          {
              if(P.getHI()==null) 
              {
                  k=false;
                  return k;
              }
              else
              {
                  return EsListaIzquierda(P.getHI());
              }
              
          }
          else
          {
              if(P.getHD()!= null)//Significa que tienen un hijo izquierdo
              {
                  k=false;
                  return k;
              }
              else
              {
                  if(P.getHI()!=null)
                  {
                       return EsListaIzquierda(P.getHI());
                      
                  }
                  else
                  {
                      k=true;
                      return k;
                  }
              }
              
              
          }
          
              
              
      }
              
  }
  
    
}
public boolean EsListaDerecha()
{
    return EsListaDerecha(this.raiz);
}

private boolean EsListaDerecha(NodoBin P)
{
     
    boolean k=false;
  if(P==null) return k;
  else
  {
      if(esHoja(P))
      {
          k=true;
          return k;
          
      }
          
      else
      {
          if(this.raiz==P)
          {
              if(P.getHD()==null) 
              {
                  k=false;
                  return k;
              }
              else
              {
                  return EsListaDerecha(P.getHD());
              }
              
          }
          else
          {
              if(P.getHI()!= null)//Significa que tienen un hijo derecho
              {
                  k=false;
                  return k;
              }
              else
              {
                  if(P.getHD()!=null)
                  {
                       return EsListaDerecha(P.getHD());
                      
                  }
                  else
                  {
                      k=true;
                      return k;
                  }
              }
              
              
          }
          
              
              
      }
              
  }
  
    
}
public void Podar()//Este método permite eliminar todas los elementos que se encuentran en el ultimo nivel 
{
    Podar(this.raiz);
}
private void Podar(NodoBin P)
{
    int altura=this.altura();
    //Según yo tenemos que ir hasta nivel-1 asi el puntero esta en el padre y de ahi eliminamos el elemento
    NodoBin AP;//Este nodo siempre va a apuntar al padre de algún nodo
    if(P==null) return;
    else
    {
        if(this.raiz==P && esHoja(P))//Si es igual a la raiz y además es hoja, entonces eliminamos
        {
            P=null;//Con esto nos aseguramos que toda la referencia de memoria se vuelva nula
        }
        else
        {
            if(altura==P.)
            
            
            
            
            Podar(P.getHI());
            
            Podar(P.getHD());
        }
        
        
    }
    
    
    
    
}
}//end class