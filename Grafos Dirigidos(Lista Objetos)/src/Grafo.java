
import javax.swing.*;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Grafo
{
    private Lista LVertices;
    
    public Grafo() {
        LVertices = new Lista();
    }
    
    public void crearVertice(String nomV){
        LVertices.insertarUlt(new Vertice(nomV));
    }
    //Retorna null si no lo encontro el vertice

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
         
     public int CantidadVerticesFlotantes()
     {
         Vertice v;
         int cant=0;
         for (int i = 0; i < this.LVertices.dim(); i++) {
             v=(Vertice)this.LVertices.getElem(i);
             if(this.CantidadArcosEntrantes(v)==0 && v.LArcos.dim()==0)
             {
                 
                 cant++;
             }
             
             
         }
         return cant;
     }
     //Siemopre esta devolviendo 0
     public int CantidadArcosEntrantes(Vertice v)
     {
          int arconen=0;
         
         Vertice ve;
         Arco Arc;
         for (int i = 0; i < LVertices.dim(); i++) {
         ve=(Vertice)LVertices.getElem(i);
         if(!ve.nombre.equals(v))
            {  
                for (int j = 0; j < ve.LArcos.dim(); j++) {
                    Arc=(Arco)ve.LArcos.getElem(j);
                    if(String.valueOf(Arc.getNombreVertD()).equals(v.nombre))
                    {
                        
                        arconen++;
                        break;

                    }

                }
            }
         }
        return arconen;
         
         
     }
     public boolean esArbolBinario()
     {
         //Tengo que desmarcar cada vez que :v ponemos un nuevo nodo
         Vertice v;
         desmarcarTodos();
         if(CantidadVerticesFlotantes()==1 && this.LVertices.dim()==1) return true;
         desmarcarTodos();
         if (CantidadVerticesFlotantes()>=1) return false;
         
         for (int i = 0; i < this.LVertices.dim(); i++) {
            desmarcarTodos();    
             v=(Vertice)this.LVertices.getElem(i);
            
             if(!esArbolBinario(v))
                {
                    
                   return false;
                }
             
             
         }
         return true;

     }
     
     public boolean esSubGrafo(Grafo F)
     {
         //Hay un problema, cuando hay un vertice flotante que no es el principal lo acepta como sub grafo
         this.ordenarVerticesAlf();
         F.ordenarVerticesAlf();
         F.desmarcarTodos();
         this.desmarcarTodos();
         Vertice v;
         if(CantidadVerticesFlotantes()==1 && this.LVertices.dim()==1 && F.CantidadVerticesFlotantes()==1 && F.LVertices.dim()==1) return true;
              desmarcarTodos();
          if (F.CantidadVerticesFlotantes()>=1) return false;
         for (int i = 0; i <F.LVertices.dim(); i++) {
             v=(Vertice)F.LVertices.getElem(i);
             if(!v.marcado)
             {
                 
              
                if(!esSubGrafo(v))
                {
                    return false;
                }
                
             }
         }
         return true;
     }
     //El truco es empezar con el vertice del supuesto subgrafo
     private boolean esSubGrafo(Vertice C)
     {
         //Buscamos el vertice de inicio en el grafo, si no existe retornamos false
         Vertice vg=this.buscarVertice(C.nombre);
         if(vg==null) return false;
         vg.ordenarArcosAlf();
         C.ordenarArcosAlf();
         C.marcado=true;
         Arco arc,arc2;
         
         for (int i = 0; i <C.LArcos.dim(); i++) {
             arc=(Arco)C.LArcos.getElem(i);
             arc2=(Arco)vg.LArcos.getElem(i);
             if(arc==null || arc2==null) return false;
             if(arc.getNombreVertD().equals(arc2.getNombreVertD()))
             {
                 
                  if(this.buscarVertice(arc.getNombreVertD()).marcado) continue;
                 this.buscarVertice(arc.getNombreVertD()).marcado=false;
                 if(esSubGrafo(this.buscarVertice(arc.getNombreVertD())))
                 {
                     return true;
                 }
             }
             else
             {
                 return false;
             }
         }
         return true;
         
         
     }
     
     private boolean esArbolBinario(Vertice v)
     {
        
         
        v.marcado=true;
        Arco a;
        if(v.LArcos.dim()>2 || this.CantidadArcosEntrantes(v)>1) return false;
        
        for (int i = 0; i < v.LArcos.dim(); i++) {
            a = (Arco) v.LArcos.getElem(i);
            Vertice w = buscarVertice(a.getNombreVertD());
            if(!w.marcado)
            {
                
               if(!esArbolBinario(w))
               {
                   
                   return false; 
               }
            }
            else
            {
                 return false;
            }
            
        }
        return true;
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
  //Importante usar las marcas para que no existan caminos infinitos
    private int cantidadCaminos(Vertice vi, Vertice  vd)
    {
        int caminos=0;
        Arco arc;
        Vertice v;
        vi.ordenarArcosAlf();
        
        vi.marcado=true;
        //Si el vertice de inicio no tiene arcos, retornamos 0 porque si no tiene arcos, no hay como llegue a algun nodo
        if(vi.LArcos.dim()==0) return 0;
        //Recorremos los arcos del vertice inicio
        for (int i = 0; i < vi.LArcos.dim(); i++) 
        {
            arc=(Arco)vi.LArcos.getElem(i);
            
            v=this.buscarVertice(arc.getNombreVertD());
            //Directamente, si un elemetno del arco del vertice de inicio no es igual al vertice de destino, llamamos la funcion de nuevo
            if(!vd.nombre.equals(v.nombre) && !v.marcado )
            {
                
                caminos+=cantidadCaminos(v,vd);
                v.marcado=false;
                
            }
            //En caso de que exista el arco dentro, entonces tenemos que aumentar en 1 el numero de caminos porque significa que tiene una 
            //Conexion directa con el vertice de destino+//No llamamos la funcion recursivamente, porque no nos importa sus arcos salientes
            if(vd.nombre.equals(v.nombre)) 
             caminos++;
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
    public void dijstra(String v,String vdestino,JTextArea jta)
    {
        Vertice vi=this.buscarVertice(v);
        Vertice vd=this.buscarVertice(vdestino);
        InicializarPrevios();
        InicializarDistancia();
        desmarcarTodos();
        dijstra(vi,vd,jta);
    }
    
  public void MostrarCaminos(String v, String vd, JTextArea jta)
  {
      desmarcarTodos();
      Vertice vi=this.buscarVertice(v);
      Vertice vf=this.buscarVertice(vd);
      List<Vertice> lista=new LinkedList();
      lista.add(vi);
      MostrarCaminos(vi,vf,jta,lista);
  }
  private void MostrarCaminos(Vertice v, Vertice vd, JTextArea jta,List<Vertice> lista)
  {
      if(v.nombre.equals(vd.nombre))
      {
          for (int i = 0; i <lista.size(); i++) {
              jta.append(lista.get(i).nombre+" ");
          }
          jta.append("\n");
      }
      else
      {
      
        v.marcado=true;
        Arco a;
        for (int i = 0; i < v.LArcos.dim(); i++) {
              a = (Arco) v.LArcos.getElem(i);

              Vertice w = buscarVertice(a.getNombreVertD());
              if(!w.marcado)
              { 
                  lista.add(w);
                  MostrarCaminos(w,vd,jta,lista);
                  lista.remove(w);
                  w.marcado=false;

              }

            }
      
      }
      
  }
    
    

    
    
    //Dijstra llena todos los caminos posibles dado un nodo vertice
    private void dijstra(Vertice vi,Vertice vd,JTextArea jta)
    {
        Vertice actual,adyacente;
        float peso;
        Arco arc;
        PriorityQueue< Vertice > Q = new PriorityQueue<Vertice>();
        //La distancia que hay entre el mismo nodo de inicio siempre es cero porque ya se encuentra ahi
        vi.distancia=0;
        Q.add(vi);
        while(!Q.isEmpty())
        {
            //no estraemos solamente tomamos el valor del primer elemento
            actual=Q.element();
            //Lo removemos :v
            Q.remove();
            
            if(actual.marcado) continue;//Si el vertice actual ya fue isitado ebtonces sigo sacando elemetnos de la cola
            actual.marcado=true;//Marcamos como visitado
            //Recorremos todos los vertices adyacentes del actual
            for (int i = 0; i <actual.LArcos.dim(); i++) {
                arc=(Arco)actual.LArcos.getElem(i);
                adyacente=this.buscarVertice(arc.getNombreVertD());
                peso=arc.getCosto();
                //Si el adyacente a este no esta marcado estonces hacemos la relajacion
                if(!adyacente.marcado)
                {
                    relajacion(actual,adyacente,peso,Q);
                }
            }
            
        }
        float costo=0;
        ImprimirCaminoMasCorto(vd,jta,costo);
        costo=GetCostoCaminoMasCorto(vd,costo);
        jta.append("\n");
       jta.append("El camino mas corto tiene un costo de:"+String.valueOf(costo));
    }
    private float GetCostoCaminoMasCorto(Vertice vd,float costo)
    {
        int suma=0;
         if(vd.previo!="null")
            suma+=GetCostoCaminoMasCorto(this.buscarVertice(vd.previo),costo);
       
        return vd.distancia;
        
    }
    private void ImprimirCaminoMasCorto(Vertice vd,JTextArea jta,float costo)
    {
        if(vd.previo!="null")
            ImprimirCaminoMasCorto(this.buscarVertice(vd.previo),jta,costo);
        jta.append(vd.nombre+" ");
        costo+=vd.distancia;
    }
    //Este metodo simplemente actualiza las distancia entre el vertice actual y su adyacente, despues mete el adyacente a la cola de prioridad
    private void relajacion(Vertice actual, Vertice adyacente, float peso,PriorityQueue<Vertice> Q)
    {
        //Si la distancia del origen al vertice actual + peso de su arista es menor a la distancia del origen al vertice adyacente
        //El peso, es el costo que tiene el vertice adyacente al actual
        if( actual.distancia + peso < adyacente.distancia ){
            adyacente.distancia = actual.distancia + peso;  //relajamos el vertice actualizando la distancia
            adyacente.previo = actual.nombre; //a su vez actualizamos el vertice previo
            Q.add(adyacente); //agregamos adyacente a la cola de prioridad

        
        }
    }
    private void InicializarPrevios()
    {
        Vertice v;
        for (int i = 0; i < this.LVertices.dim(); i++) {
            v=(Vertice)this.LVertices.getElem(i);
            v.previo="null";
        }
    }
    //Inicializa la distancia de todos los vertices en infinito
    private void InicializarDistancia()
    {
         Vertice v;
        for (int i = 0; i < this.LVertices.dim(); i++) {
            v=(Vertice)this.LVertices.getElem(i);
            v.distancia=Float.POSITIVE_INFINITY;
        }
        
    }

}  //end class