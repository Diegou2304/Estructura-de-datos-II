
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
      
    
}  //end class