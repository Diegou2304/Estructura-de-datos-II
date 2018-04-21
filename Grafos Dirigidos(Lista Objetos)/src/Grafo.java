
import javax.swing.*;
import java.util.LinkedList;

public class Grafo
{
    private Lista LVertices;
    
    public Grafo() {
        LVertices = new Lista();
    }
    
    public void crearVertice(String nomV){
        LVertices.insertarUlt(new Vertice(nomV));
    }

    public Vertice buscarVertice(String nomV)
    {
        Vertice vertice;
        int i=0;
        while (i<LVertices.dim())
        {
            vertice =(Vertice)LVertices.getElem(i);
            if (vertice.getNombre().equals(nomV))
                 return vertice;
             i++;
        }
          return null;
    }
    
    public void insertarArco(String X,String Y, float co)
    {
        Vertice vo = buscarVertice(X);
        Vertice vd = buscarVertice(Y);
        vo.insertarArco(new Arco(vd, co));        
    }
            
    public void imprimir(JTextArea jta){
        int i = 0; Vertice v; Arco a;
        while (i < LVertices.dim())
        {
            v = (Vertice)LVertices.getElem(i);
            int j=0; 
            while (j<v.LArcos.dim())
            {
                jta.append(v.getNombre());
                jta.append("-->");
                a = (Arco)v.LArcos.getElem(j); //Muestra el arco donde apunto
                jta.append(a.getNombreVertD() + "  " + a.getCosto());
                jta.append("\n");
                j++;
            }
                i++;                    
        }
    }     
     public void ArcosSalientes(String vo,JTextArea jta)
     {
         Vertice v;
         Arco arc;
         v=this.buscarVertice(vo);
         if(v!=null)
         {
             
             for (int i = 0; i < v.LArcos.dim(); i++) 
             {
                 jta.append(vo+"-->");
                 arc=(Arco)v.LArcos.getElem(i);
                 jta.append(String.valueOf(arc.getNombreVertD()));
                 jta.append("\n");
                 //:v//
             }
             
             
             
         }
         
         
         
     }
     public void ArcosEntrantes(String v, JTextArea jta)
     {
         int arconen=0;
         jta.append("Arcos Entrantes de:"+v);
         jta.append("\n");
         Vertice ve;
         Arco Arc;
         for (int i = 0; i < LVertices.dim(); i++) {
         ve=(Vertice)LVertices.getElem(i);
         if(!ve.nombre.equals(v))
            {  
                for (int j = 0; j < ve.LArcos.dim(); j++) {
                    Arc=(Arco)ve.LArcos.getElem(j);
                    if(String.valueOf(Arc.getNombreVertD()).equals(v))
                    {
                        jta.append(v+"<---"+String.valueOf(ve.nombre)+"\n");
                        arconen++;
                        break;

                    }

                }
            }
         }
         jta.append("\n");
         jta.append("Cantidad de arcos entrantes:"+String.valueOf(arconen));
         
         
         
     }
     public void MostrarVertices(JTextArea jta)
     {
        Vertice v;
         
         for (int i = 0; i < this.LVertices.dim(); i++) {
         v=(Vertice)LVertices.getElem(i);
             jta.append(v.nombre+" ");
         
         }
         
         
         
     }
     public boolean esConexo()
     {
         //Solo tenia que ordenar los vertices, cosa que olvide hacer
         this.ordenarVerticesAlf();
          
         for (int i = 0; i < this.LVertices.dim(); i++) {
             
             Vertice v=(Vertice)this.LVertices.getElem(i);
            
             for (int j = 0; j < this.LVertices.dim(); j++) {
                
                 Vertice w=(Vertice)this.LVertices.getElem(j);
                 if(i!=j)
                 {
                    if(!existeCamino(v.getNombre(),w.getNombre()))
                    {

                        return false;
                    }
                 }
                 
             }
             
            
             
         }
         
         
         return true;
         
     }
    
     public boolean iguales(Grafo g1)
     {
         
         if(this.LVertices.dim()!=g1.LVertices.dim()) return false;
         
         
        desmarcarTodos();
        ordenarVerticesAlf();
        g1.ordenarVerticesAlf();
        
        return Iguales(g1);
         
         
     }
     
     private boolean Iguales(Grafo g1)
     {
         Vertice v1,v2;
         Arco arc1,arc2;
         for (int i = 0; i < this.LVertices.dim(); i++) 
         {
             v1=(Vertice)this.LVertices.getElem(i);
             v2=(Vertice)g1.LVertices.getElem(i);
             
             if(!v2.nombre.equals(v1.nombre))
                 return false;
             v1.ordenarArcosAlf();
             v2.ordenarArcosAlf();
             for (int j = 0; j <v1.LArcos.dim(); j++) 
             {
                 arc1=(Arco)v1.LArcos.getElem(j);
                 arc2=(Arco)v2.LArcos.getElem(j);
                 if(!arc1.getNombreVertD().equals(arc2.getNombreVertD()))
                 {
                     return false;
                 }
             }
             
         }
         return true;
         
         
         
         
     }
     public int  CantidadIslas()
     {
         Vertice v;
         int islas=0;
         this.desmarcarTodos();
         for (int i = 0; i < this.LVertices.dim(); i++) {
             v=(Vertice)this.LVertices.getElem(i);
             if(!v.marcado)
             {
                 CantidadIslas(v);
                 islas++;
                 
             }
         }
         return islas;
     }
     private void CantidadIslas(Vertice v)
     {
        
        v.marcado=true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if(!w.marcado)
            CantidadIslas(w);
        }
         
     }
         
     private Vertice nextVertice(String v)
     {
         Vertice f;
         for (int i = 0; i < this.LVertices.dim(); i++) {
             f=(Vertice)this.LVertices.getElem(i);
             if(f.nombre.equals(v))
             {
                 f=(Vertice)this.LVertices.getElem(i+1);
                 return f;
                 
             }
         }
         return null;
     }
    //TAREA
     //MOSTRAR LOS CAMINOS DE X A Y TODOS LOS CAMINOS POSIBLES
     //A,B
             //A,D,F
     
     
     //MOSTRAR EL CAMINO MAS CORTO SI HAY EMPATE MOSTRAMOS EL QUE QUEREMOS, MOSTRAMOS EL COSTO Y LOS GRAFOS POR DONDE PASA
    public void desmarcarTodos() 
    {
       for(int i=0;i<this.LVertices.dim();i++){
          Vertice v=(Vertice)this.LVertices.getElem(i);
          v.marcado=false;
       }
    }
    public void ordenarVerticesAlf() {
      Vertice aux; Vertice v1; Vertice v2;
      for(int i=0;i<LVertices.dim();i++){
        for(int j=0;j<LVertices.dim()-1;j++){
            v1=(Vertice)LVertices.getElem(j);
            v2=(Vertice)LVertices.getElem(j+1);
            if(v1.getNombre().compareTo(v2.getNombre())>0){             
                aux=(Vertice)LVertices.getElem(j);                
                LVertices.setElem(v2, j);
                LVertices.setElem(aux, j+1);                                                   
        
            }      
        }  
      }
      for(int i=0;i<LVertices.dim();i++){
        Vertice v=(Vertice)LVertices.getElem(i);
        v.ordenarArcosAlf();
      }          
    }   
    
    public void DFS(String A, JTextArea jta){
        jta.append("DFS: ");
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice a = buscarVertice(A);
        dfs(a,  jta);
        jta.append("\n");
    }

    private void dfs(Vertice v, JTextArea jta){
        
        
            
        
        jta.append(v.getNombre() + " ");
        v.marcado=true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if(!w.marcado)
            dfs(w, jta);
            }
        
        
    }
    
    
    public void BFS(String s,JTextArea jta)
    {  
         
       desmarcarTodos();
       ordenarVerticesAlf();
       Arco a;
       Vertice v = buscarVertice(s), w;
       Lista C=new Lista();
       
       //C=new LinkedList<Vertice>();
       C.insertarUlt(v);//Insertamos en la lista los vertices esta lista tiene vertices entonces    
       v.marcado=true;
       jta.append("BFS: ");
       do{
           v =(Vertice)C.getElem(0);
           C.eliminarPri();
           jta.append(v.getNombre() + " ");
           for (int i = 0; i < v.LArcos.dim(); i++) { 
               a = (Arco) v.LArcos.getElem(i);
               w = buscarVertice(a.getNombreVertD());
               if (!w.marcado) {
                   C.insertarUlt(w);
                   w.marcado=true;
               }
           }
       }while (!C.vacia());   
       jta.append("\n");
    } 
    public boolean existeCamino(String x, String y)
    {
        Arco a;
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice vi = buscarVertice(x);
        Vertice vd=buscarVertice(y);
        
        
        

        
        
            
            
        return existeCamino(vi,vd);
    }
    private boolean existeCamino(Vertice vi, Vertice  vd)
    {
        //Me faltaba >:v el nombre vi 
        
        
         
        vi.marcado=true;
        Arco a;
        for (int i = 0; i < vi.LArcos.dim(); i++) {
            a = (Arco) vi.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if(w.nombre.equals(vd.nombre)) return true;
            if(!w.marcado)
            {
                
                if(existeCamino(w,vd))
                {
                    return true;
                }
                
                
            }
            
        }
        
        
            return false;
       
    }
        
        
        
       public void caminosExistentes(JTextArea jta,String vo, String vd)
       {
           desmarcarTodos();
           ordenarVerticesAlf();
           Vertice vi=this.buscarVertice(vo);
           Vertice vf=this.buscarVertice(vd);
           Vertice w;
           if(existeCamino(vo, vd))
               {
                   
                   for (int i = 0; i < vi.LArcos.dim(); i++) 
                    {
                        Arco arc=(Arco)vi.LArcos.getElem(i);
                        w=this.buscarVertice(arc.getNombreVertD());
               
                        desmarcarTodos();
                        jta.append(vo+"-");
                        jta.append(w.nombre+"-");
                        caminosExistentes(jta,w,vf);
                         jta.append(vf.nombre);
                        jta.append("\n");
                       
               
               
               
                    }
           
                   
                   
               }
           
           
           
       }
       private void caminosExistentes(JTextArea jta,Vertice vi, Vertice vf)
       {
           
           for (int i = 0; i < vi.LArcos.dim(); i++) {
             Arco arc=(Arco)vi.LArcos.getElem(i);
             Vertice aux=buscarVertice(arc.getNombreVertD());
             if(existeCamino(aux.nombre,vf.nombre))
             {
                 jta.append(aux.getNombre()+"-");
                 caminosExistentes(jta,aux,vf);
             }
               
           }
           
           
       }
    

    private boolean buscarVerticeD(Vertice vi,Vertice vd)
{
            Arco a;
            for (int i = 0; i < vi.LArcos.dim(); i++) {
                a=(Arco)vi.LArcos.getElem(i);
                if(a.getNombreVertD().equals(vi.nombre))
                {
                    return true;
                }
                
            }
            return false;
           
 }     
    
  public int cantidadCaminos(String x, String y)
    {
        Arco a;
        desmarcarTodos();
        ordenarVerticesAlf();
        Vertice vi = buscarVertice(x);
        vi.ordenarArcosAlf();
        Vertice vd=buscarVertice(y);
        
        vd.ordenarArcosAlf();
        

        
        
            
            
        return cantidadCaminos(vi,vd);
    }
    //public subgrafo(grafo g1)
  //public bool unicocamino(string x, string y)
  //public int cantidadCaminos(string x, string y
//public bool verificarSiesArbol2()  
  
  /*En resumen lo que hace esta funcion es, sumar recursivamente por nodo la cantidad de caminos que tiene cada uno hasta llegar a un nodo destino
  
  */
    private int cantidadCaminos(Vertice vi, Vertice  vd)
    {
        int caminos=0;
        Arco arc;
        Vertice v;
        vi.ordenarArcosAlf();
        
        
        //Si el vertice de inicio no tiene arcos, retornamos 0 porque si no tiene arcos, no hay como llegue a algun nodo
        if(vi.LArcos.dim()==0) return 0;
        //Recorremos los arcos del vertice inicio
        for (int i = 0; i < vi.LArcos.dim(); i++) 
        {
            arc=(Arco)vi.LArcos.getElem(i);
            
            v=this.buscarVertice(arc.getNombreVertD());
            //Directamente, si un elemetno del arco del vertice de inicio no es igual al vertice de destino, llamamos la funcion de nuevo
            if(!vd.nombre.equals(v.nombre))
            {
                caminos+=cantidadCaminos(v,vd);
            }
            //En caso de que exista el arco dentro, entonces tenemos que aumentar en 1 el numero de caminos porque significa que tiene una 
            //Conexion directa con el vertice de destino+//No llamamos la funcion recursivamente, porque no nos importa sus arcos salientes
            if(vd.nombre.equals(v.nombre)) caminos++;
        }
       
       return caminos;
    }
    
    public boolean unicoCamino(String x, String y)
    {
        if(this.cantidadCaminos(buscarVertice(x),buscarVertice(y))==1)
                {
                    return true;
                    
                }
        else
        {
            return false;
        }
    }
    

}  //end class