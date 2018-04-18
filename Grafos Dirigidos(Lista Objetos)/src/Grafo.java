
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
         boolean k=true;
          desmarcarTodos();
          
         for (int i = 0; i < this.LVertices.dim(); i++) {
             Vertice v=(Vertice)this.LVertices.getElem(i);
             
             for (int j = 0; j < this.LVertices.dim(); j++) {
                 Vertice w=(Vertice)this.LVertices.getElem(i);
                 if(!existeCamino(v,w))
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
        if(vi.nombre.equals(vd.nombre) && this.buscarVerticeD(vi, vd)) return true;
         
        vi.marcado=true;
        Arco a;
        for (int i = 0; i < vi.LArcos.dim(); i++) {
            a = (Arco) vi.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
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

}  //end class