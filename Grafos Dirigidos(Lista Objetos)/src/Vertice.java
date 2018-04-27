
//Tuvimos que heredad de la clase Comparable para usar la cola de prioridad
public class Vertice implements Comparable<Vertice>
{
        String nombre;
        public Lista LArcos;
        boolean marcado;
        float distancia;//Distancia mas corta desde vertice inicial a vertice con ID
        String previo;//Esto almacena el id del vertice anterior sirve para la impresion
        
        public Vertice(String nom) {
            this.nombre = nom;
            this.LArcos = new Lista();
            this.marcado=false;
            this.distancia=Float.POSITIVE_INFINITY;
            this.previo="null";
        }      
        
        public void setNombre(String nom) {
            this.nombre = nom;
        }

        public String getNombre() {
            return this.nombre;
        }

        public int getCantArcos() {
            return LArcos.dim();
        }
        
        /*public void marcar(){
           this.marcado=true;
        }        
        
        public boolean estado()
        {
          return this.marcado;
        }*/                
        
        //Inserta el arco q ya viene creado
        public void insertarArco(Arco arco) {
            LArcos.insertarUlt(arco);
        }
        public int compareTo( Vertice other){              //es necesario definir un comparador para el correcto funcionamiento del PriorityQueue
            if( this.distancia > other.distancia ) return 1;
            if( this.distancia == other.distancia ) return 0;
            return -1;
}

        public void eliminarArco(String nombreVD) {
            int i = 0;
            Arco a;
            while (i < LArcos.dim())
            {
                a = (Arco)LArcos.getElem(i);
                if (a.getNombreVertD() == nombreVD){
                    LArcos.eliminar(i);
                }
                i++;
            }
        }    
        
        

        public void ordenarArcosAlf() {
          Arco aux; Arco a1; Arco a2;
          for(int i=0;i<LArcos.dim();i++){
            for(int j=0;j<LArcos.dim()-1;j++){
                a1=(Arco)LArcos.getElem(j);
                a2=(Arco)LArcos.getElem(j+1);
                if(a1.getNombreVertD().compareTo(a2.getNombreVertD())>0){             
                    aux=(Arco)LArcos.getElem(j);                
                    LArcos.setElem(a2, j);
                    LArcos.setElem(aux, j+1);                                                   
                }      
            }  
          }
        }
    
        
 }//end class