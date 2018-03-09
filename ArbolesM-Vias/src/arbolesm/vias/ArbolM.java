/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesm.vias;

import javax.swing.JTextArea;
import java.util.Queue; //Esto sirve para las colas
import java.util.LinkedList;

/**
 * :v :v :v :v :v :v :v :v :v :v :v :v :v :v :v :v :v
 *
 * @author Diego U
 */
public class ArbolM {

    //variable
    public Nodo raiz;
    //constructor

    public ArbolM() {
        raiz = null;
    }

    //metodos
    ////privados
    private boolean esHoja(Nodo P)//Recore el vector de los hijos de una raiz, si no tiene hijos osea si todo el vector hijos esta llenado con
    //nulos signfica que es hoja
    {

        for (int i = 1; i <= P.M; i++) {
            if (P.getHijo(i) != null) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("static-access")
    
    private int getHijoDesc(Nodo P, int x) //Toda esta funcion nos devuelve el hijo correspondiente al cual deberia tocarle el nuevo elemento.
    {

        int i = 1;
        while (i < P.M) {
            if (x < P.getElem(i)) {
                return i;
            }
            if (x == P.getElem(i)) {
                return -1;
            }
            i++;
        }
        return P.M;
    }

    private void Recorrer(Nodo P, int i)//Simplemente recorre todos los elementos a la derecha de una posicion espe
    {

        int num1 = P.getElem(i);
        int num2 = 0;
        int c = P.CantOcupados();
        while (i <= c) {
            if (P.Ocupado(i + 1)) {
                num2 = P.getElem(i + 1);
            }
            P.setElem(num1, i + 1);
            num1 = num2;
            i++;
        }
    }

    private void InsertaOrd(Nodo P, int x) {
        for (int i = 1; i < P.M; i++) {
            if (P.Vacio(i)) {

                P.setElem(x, i);
                return;
            } else {
                if (x == P.getElem(i)) {
                    return;
                } else {
                    if (x < P.getElem(i)) {

                        Recorrer(P, i);
                        P.setElem(x, i);
                        return;
                    }
                }
            }
        }
    }

    ////publicos
    public void Insertar(int x) {
        if (raiz == null)//Sii todo esta vacio, simplemente lo inserta
        {
            raiz = new Nodo();
            raiz.setElem(x, 1);
        } else {
            Nodo P = raiz;
            Nodo AP = null;
            int i = 0;
            while (P != null)//Mientras  la raiz no sea nula
            {
                AP = P;
                if (!P.Lleno())//Si no esta lleno, entonces lo insertamos ordenadamente
                {
                    InsertaOrd(P, x);
                    return;
                }
                i = getHijoDesc(P, x);//En caso que la raiz este llena, nos devuelve la posicion de la rama a la cual el nuevo elemento pertenece
                if (i == -1)//Significa que el elemento que se quiere inertar ya existe,
                {
                    return;
                }
                P = P.getHijo(i);
            }
            Nodo Q = new Nodo();

            Q.setElem(x, 1);//Inserta el hijo en el vector del nodo
            AP.setHijo(Q, i);//Como AP apunta a la raiz, entonces le inserta el hijo en su correspondiente rama
        }
    }
    //raiz,izquierda,derecha
    private void PreOrden(Nodo P, JTextArea jta) {
        if (P == null) 
        {
            return;
        } else 
        {
            if (esHoja(P)) 
            {
                int i = 1;
                while (i <= P.CantOcupados()) 
                {

                    jta.append(String.valueOf(P.getElem(i) + " "));
                    i++;
                }
            } else 
            {
                for (int i = 1; i <= P.M - 1; i++) 
                {

                    jta.append(String.valueOf(P.getElem(i) + " "));
                    PreOrden(P.getHijo(i), jta);
                }
                PreOrden(P.getHijo(P.M), jta);

            }
        }

    }

    public void PreOrden(JTextArea jta) {
        PreOrden(this.raiz, jta);

    } //:V :v :v :v :V :v :V :v :v :v : :v :V :v :v :V :V :V :V :V :V :v vV. :V :V :V :V :v v :V 

    private void InOrden(Nodo P, JTextArea jta) {
        if (P == null) {
            return;
        } else {
            if (esHoja(P)) {
                int i = 1;
                while (i <= P.CantOcupados()) {

                    jta.append(String.valueOf(P.getElem(i) + " "));
                    i++;
                }
            } else {
                for (int i = 1; i <= P.M - 1; i++) {
                    InOrden(P.getHijo(i), jta);
                    jta.append(String.valueOf(P.getElem(i) + " "));
                }
                InOrden(P.getHijo(P.M), jta);
            }
        }
    }

    public void InOrden(JTextArea jta) {

        InOrden(this.raiz, jta);

    }
    public void PostOrden(JTextArea jta)
    {
        PostOrden(this.raiz,jta);
        
    }
    private void PostOrden(Nodo P, JTextArea jta)
    {
        if (P == null) {//Si la raiz es nula. entonces no hace nada
            return;
        } else {
            if (esHoja(P)) {
                int i = 1;
                while (i <= P.CantOcupados()) {

                    jta.append(String.valueOf(P.getElem(i) + " "));
                    i++;
                }
            } else {
                 
                for (int i = 1; i <= P.M - 1; i++) {
                    
                    PostOrden(P.getHijo(i), jta);
                   
                    
                }
                PostOrden(P.getHijo(P.M), jta);
                for(int i=1;i<P.M;i++)
                {
                    jta.append(String.valueOf(P.getElem(i) + " "));
                }
            }
        }
        
        
        
    }
    public int Altura()//A diferencia de las otras funciones esta funcion nos tiene que devolver un resultado de un proceso no mostrarnos el principio
    {
        return Altura(this.raiz);//
    }
    private int Altura(Nodo P)
    {
        if(P==null)//Si no existe el arbol
        {
            return 0;
            
        }
        else
        {
            if(esHoja(P))
            {
                return 1;
            }
            else
            {
                int acu=0;
                int d;
                for(int i=1;i<=P.M;i++)
                {
                    d=Altura(P.getHijo(i));//Obtenemos el hijo correspondiente de la raiz
                    
                    if(acu<d)
                    {
                        acu=d;
                    }
                   
                 
                }
                return acu+1;
                
            }
        }
    }
    private int SumaElementos(Nodo P)
    {
        if(P==null) return 0;
        else
        {
            if(esHoja(P))
            {
                return P.SumaE();
            }
            else
            {
                int s=0;
                for(int i=1;i<=P.M;i++)
                {
                    s+=SumaElementos(P.getHijo(i));
                    
                }
                return s+P.SumaE();            }
            
        }
        
        
    }
    public int SumaElementos()
    {
        return SumaElementos(this.raiz);
    }
    private boolean Existe(Nodo P,int x)
    {
       /* if(P==null) return false;
        
        else
        {
           if(P.BuscarElemento(x))//Si el elemento existe
           {
               return true;
           }
           else
           {
               if(!esHoja(P))
               {
                   for(int i=1;i<=P.M;i++)
                   {
                      if(Existe(P.getHijo(i),x))
                       {
                           return true;
                       }
                   }
                  
               }
              
               return false;
           }
            
            
            
        }*/
        if(P==null) return false;
        else
        {
            if(esHoja(P)) return P.BuscarElemento(x);
            else
            {
                int k=this.getHijoDesc(P,x); //Este lo utilizamos para ir por una sola ruta
                if(k==-1) return true;
                else
                {
                    return Existe(P.getHijo(k),x);
                }
            }
            
        }
        
        
    }
    public boolean Existe(int x)
    {
        return Existe(this.raiz,x);
    }
    private void Nivel(Nodo P,JTextArea jta,int x)//x representa el nivel
    {
        if(this.Altura()<x) return;
        //Vamoa bajando el nivel hasta encontrar que el nivel es 1, como el deseado
        if(P==null)
        {
            
            return;
        }
        if(x==1)
        {
            for (int i = 1; i <= P.CantOcupados(); i++) 
            {
                jta.append(P.getElem(i)+" ");
                
            }
        }
       else
        {
             for (int i = 1; i <= P.M; i++) 
            {
                Nivel(P.getHijo(i),jta,x-1);
            
            }
        }  
        
        
        
        
    }
    //Hacer suma de nivel, le mandamos el nivel y le mandamos la suma de solo ese nivel
    public void Nivel(int x,JTextArea jta)
    {
        Nivel(this.raiz,jta,x);
    }
    private int SumaNivel(Nodo P, int nivel)
    {
        if(P==null) return 0;
        else
        {
           
            if(nivel==1)//Este es el caso mas sencillo
            {
               
                
                return P.SumaE();//Esa funcion suma todos los elementos del nodo
            }
            else
            {
                 int suma=0;
                 for (int i = 1; i <=P.M; i++) 
                 {
                     suma+=SumaNivel(P.getHijo(i),nivel-1);
                    
                 }
                return suma;
                
                
            }
        }
        
    
    }
    public int SumaNivel(int x)
    {
        return SumaNivel(this.raiz,x);
    }
    public Nodo BuscarNodo(int x)
    {
        return BuscarNodo(this.raiz,x);
    }
    private Nodo BuscarNodo(Nodo P,int x)
    {
        if(P==null) return null;
        else
        { //Ahora tenemos que buscar el caso mas sencillo
           int k;
           k=this.getHijoDesc(P, x);//Buscamos el hijo descendiente
           //Si devuelve -1 significa que el elemento ya se encuentra en el nodo
           if(k==-1) 
           {
               return P;
           }
          else
           {
            return BuscarNodo(P.getHijo(k),x);           
           }
        }
    
    
    }
    private int CantidadNodos(Nodo P)
    {
        if(P==null) return 0;
        else
        {
            if(esHoja(P))
            {
                return 1;
            }
            else
            {
                int cantidad=0;
                //Usamos cantidad P.M para recorrer todos los hijos
                for (int i = 1; i <= P.M; i++) 
                {
                    cantidad+=CantidadNodos(P.getHijo(i));
                    
                }
                return cantidad+1;
            }
            
        }
        
        
        
    }
    public int CantidadNodos( )
    {
        return CantidadNodos(this.raiz);
    }
    private void SumaNiveles(Nodo P, JTextArea jta)//Incompleto
    {
        if(P==null) return ;
        else
        {
            jta.append(String.valueOf(P.SumaE()));
            jta.append("\n");    
           
          int suma=0;
          Nodo AP;
          //Con este for recorremos todos los hijos que tenga la raiz
            for (int i = 1; i < P.M; i++) 
            {
                AP=P.getHijo(i);
                suma+=AP.SumaE();
                
            }
           
            
             
            
        }
        
    }
    public void SumaNiveles(JTextArea jta)
    {
        SumaNiveles(this.raiz,jta);
        
    }
    //Ejercicio 4.
    //Este es el recorrido tradicional de arriba hacia abajo
    private Queue RecorridoNivelesIzquierdaDerecha(Nodo P)
    {
        Queue<Integer> cola=new LinkedList();//Declaracion de la cola tipo nodo
        if(P==null) return null;
        else
        {
            for (int i = 1; i <= P.CantOcupados(); i++) 
                {
                    cola.add(P.getElem(i));//Añadimos a la cola todos los elementos
                    
                }
          
            if(esHoja(P))//Verificamos que el nodo sea hoja
            {
                return cola;
                
            }
            else
            {
                Nodo aux;
                Queue<Integer> cola2=new LinkedList();
                for (int i = 1; i <= P.M; i++) //Ahora si no es raiz significa que tiene hijos, entoncs lo que hacemoes e
                {   
                    
                    cola2=RecorridoNivelesIzquierdaDerecha(P.getHijo(i));
                    if(cola2!=null)
                    {
                        while(cola2.isEmpty()!=true)
                        {
                            cola.add(cola2.poll());
                            
                        }
                        
                    }
                    
                }
                return cola;
            }
            
        }
        
        
    }
    public void RecorridoNivelesIzquierdaDerecha(JTextArea jta)
    {
        Queue<Integer> cola=new LinkedList();
        
        cola=RecorridoNivelesIzquierdaDerecha(this.raiz);
        while(cola.isEmpty()!=true)
        {
            jta.append(cola.poll()+" ");
        }
        jta.append("\n");
    }
    private Queue RecorridoNivelesArribaAbajo(Nodo P,JTextArea jta)
    {
        //PRIMERO ESTE ALGORITMO ESTABA PENSADO PARA DEVOLVER UNA COLA ENTERA CON TODOS LOS ELEMENTOS EN ORDEN PARA SACAR LOS ELEMENTOS DE LA COLA
        //Y MOSTRARLOS, AL CAMBIARLO HAY ALGUNAS COSAS QUE NO DEBERIAN ESTAR PERO ESO ES PROBLEMA PARA DESPUES
         Queue<Integer> cola=new LinkedList();//Declaracion de la cola tipo nodo
        if(P==null) return null;
        else
        {
            if(P==this.raiz)//Esto lo hacemos porque la raiz siempre la muestra
            {
                for (int i = 1; i <= P.CantOcupados(); i++) 
                {
                    cola.add(P.getElem(i));//Añadimos a la cola todos los elementos
                    jta.append(cola.poll()+"  ");
                }
                 jta.append("\n");
            }
           
           
                Nodo aux;
                Queue<Integer> cola2=new LinkedList();
                if(!esHoja(P))
                {
                    for (int i = 1; i <= P.M; i++) //Ahora si no es raiz significa que tiene hijos, entoncs lo que hacemoes e
                    {   
                        aux=P.getHijo(i);
                        if(aux!=null)//Para evitar errores
                        {
                            for (int j = 1; j <= aux.CantOcupados(); j++)//Insertamos todos los elementos de los hijos del nodo padre
                            {
                            cola.add(aux.getElem(j));
                            jta.append(cola.poll()+" ");

                            }
                        }
                        jta.append(" ");
                    }
                }
                jta.append("\n");
                for (int i = 1; i <= P.M; i++) 
                {
                    cola2=RecorridoNivelesArribaAbajo(P.getHijo(i),jta);//aqui la cola se llena con
                    if(cola2!=null)
                    {
                        while(cola2.isEmpty()!=true)
                        {
                        cola.add(cola2.poll());
                        jta.append(cola.poll()+" ");
                        }
                    }
                }
                
                return cola;
            
            
        }
    }
    public void RecorridoNivelesArribaAbajo(JTextArea jta)
    {
         RecorridoNivelesArribaAbajo(this.raiz,jta);
    }
  //Ejercicio 4
    //Verificar que dos arboles M vias sean iguales
    //Esta Funcion principalmente lleva a todos los nodos a un analisis individual
    private boolean ArbolesIguales(Nodo P1, Nodo P2)
    {
        
        //Primero tenemos que verificar que las raices existan
        if(P1==null && P2==null) return true;
        if(P1==null && P2!=null || P1!=null && P2==null) return false;
        
        else if(P1.NodosIguales(P2))//Verificamos que los nodos sean iguales
            {
                for (int i = 1; i <= P1.M; i++) //Esto lo hacemos para ir a verificar a cada hijo
                {
                    if(!ArbolesIguales(P1.getHijo(i),P2.getHijo(i)))//Esto se encarga de comparar cada nodo hijo recursivamente asi que no nos preocupamos
                    {
                        return false;
                        
                    }
                    
                }
                                
            return true;
            }
        return false;
        
    }

    
    
    public boolean ArbolesIguales(ArbolM arbol)
    {
        return ArbolesIguales(this.raiz,arbol.raiz);
    }
   
    
    //Este es el ejercico numero 6
    
    private void ParesPorNivel(Nodo P, JTextArea jta)
    {
        if(P==null) return;
        else
        {
            
            
        
        
        }
           
            
            
            
            
      
                
                
           
            
     }
        
        
        
    
    public void ParesPorNivel(JTextArea jta)
    {
        ParesPorNivel(this.raiz,jta);
    }
    //Este es el ejercicio 8
    private int NivelElemento(Nodo P, int elemento)
    {
        
        if (P==null) 
        {
            return -1;
        }
        
            if(esHoja(P))
            {
                if(P.BuscarElemento(elemento)) return 1;
                else
                {
                    return -1;
                }
            }
            else
            {
                int k=this.getHijoDesc(P, elemento);
                if(k==-1) return 1;
                else
                {
                    int h=NivelElemento(P.getHijo(k),elemento);
                    if(h==-1)
                    {
                        return -1;
                    }
                    else
                    {
                        return h+1;
                    }
                }
            }
        
        
        
        
    }
    public int NivelElemento(int x)
    {
        return NivelElemento(this.raiz,x);
    }
    
    
    private void ElementoMayorNivel(Nodo P, int altura,JTextArea jta)
    {
        //Esto nos muestra solo en el caso que sea igual a la raiz
        if(P==null) return;//No hace nada
        
        
        
    }
    public void ElementoMayorNivel(JTextArea jta)
    {
        ElementoMayorNivel(this.raiz,this.Altura(),jta);
        
    }
    
    
    
    
}
