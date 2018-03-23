/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesm.vias;

import javax.swing.JTextArea;
import java.util.Queue; //Esto sirve para las colas
import java.util.LinkedList;
import java.util.Stack;
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
   
    public void SumaNiveles(JTextArea jta)
    {
        Queue<Nodo> colap=new LinkedList();
        Queue<Nodo> colah=new LinkedList();
        colap.add(raiz);
        Nodo aux=null;
        int s=0;
        while(!colap.isEmpty())
        {
            aux=colap.poll();
            s+=aux.SumaE();
            for (int i = 1; i <= aux.M; i++) 
            {
                if(aux.getHijo(i)!=null)
                {
                    colah.add(aux.getHijo(i));
                }
            }
            
            
            if(colap.isEmpty())
            {
                jta.append(String.valueOf(s)+"\n");
                s=0;
                colap=colah;
                colah=new LinkedList();
                
            }
            
            
            
        }
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
    //Recursivo lo recorre el arbol como deberia, pero existe un problema con los saltos de linea
    private void RecorridoNivelesArribaAbajo(Nodo P,JTextArea jta)
    {
        if(P==null) return ;
        else
        {
            if(P==this.raiz)//Esto lo hacemos porque la raiz siempre la muestra
            {
                for (int i = 1; i <= P.CantOcupados(); i++) 
                {
                   
                    jta.append(P.getElem(i)+"  ");
                }
                // jta.append("\n");
            }
            
           
           
                Nodo aux=null;

                if(!esHoja(P))//Si no es hoja estonces me muestra todos los hijos y sus elementos
                {
                    for (int i = 1; i <= P.M; i++) //Ahora si no es raiz significa que tiene hijos, entoncs lo que hacemoes e
                    {   
                        aux=P.getHijo(i);
                        if(aux!=null)//Para evitar errores
                        {
                            for (int j = 1; j <= aux.CantOcupados(); j++)//Insertamos todos los elementos de los hijos del nodo padre
                            {
                            
                            jta.append(aux.getElem(j)+" ");

                            }
                        
                        }
                        jta.append(" ");
                     
                    }
                     for (int i = 1; i <= P.M; i++) 
                {
                    RecorridoNivelesArribaAbajo(P.getHijo(i),jta);//aqui la cola se llena con
                    
                }
                }
              //  if(aux!=null) jta.append("\n");
                
                
              
                
               
            
            
}
       
        
    }
    public void RecorridoNivelesArribaAbajo(JTextArea jta)
    {
         RecorridoNivelesArribaAbajo(this.raiz,jta);
    }
    
   
    public void RecorridoNivelesArribaAbajoIterativo(JTextArea jta)
    {
         Queue<Nodo> colaA=new LinkedList();
         Queue <Nodo> colaB=new LinkedList();
         Nodo aux=null;
         
         colaA.add(raiz);
         while(!colaA.isEmpty())
         {
             aux=colaA.poll();
             for (int i = 1; i <= aux.CantOcupados(); i++) 
             {
                 jta.append(String.valueOf(aux.getElem(i))+" ");
                 
             }
             
             for (int i = 1; i <= aux.M; i++) 
             {
                 if(aux.getHijo(i)!=null)
                 {
                     colaB.add(aux.getHijo(i));
                 }
                 
             }
             if(colaA.isEmpty())
             {
                 colaA=colaB;
                 colaB=new LinkedList();
                 jta.append("\n");
                 
             }
             
         }
         
         
         
         

        
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
    
    public void ParesPorNivel( JTextArea jta)
    {        
           
             Queue<Nodo> colaA=new LinkedList();
         Queue <Nodo> colaB=new LinkedList();
         Nodo aux=null;
         
         colaA.add(raiz);
         while(!colaA.isEmpty())
         {
             aux=colaA.poll();
             for (int i = 1; i <= aux.CantOcupados(); i++) 
             {
                 if(aux.getElem(i)%2==0)
                 {
             
                 jta.append(String.valueOf(aux.getElem(i))+" ");
                 }
             }
             
             for (int i = 1; i <= aux.M; i++) 
             {
                 if(aux.getHijo(i)!=null)
                 {
                     colaB.add(aux.getHijo(i));
                 }
                 
             }
             if(colaA.isEmpty())
             {
                 colaA=colaB;
                 colaB=new LinkedList();
                 jta.append("\n");
                 
             }
            
            
            
      
                
                
           
            
     }
        
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
    public void RecorridoNivelAbajoArriba(JTextArea jta)
    {
         Stack<Integer> pilaResultante=new Stack();
        Queue<Nodo> colaHijo=new LinkedList();
        Queue<Nodo> colaPadre=new LinkedList();
        Nodo aux=null;
        colaPadre.add(raiz);
        while(!colaPadre.isEmpty())
        {
            aux=colaPadre.poll();//Obtenemos un padre
            for (int i = 1; i <= aux.CantOcupados(); i++) 
            {
                pilaResultante.add(aux.getElem(i));
            }
            //Ahora llenamos la cola de hijos
            for (int i = 1; i <= aux.M; i++) 
            {
                if(aux.getHijo(i)!=null)
                {
                    colaHijo.add(aux.getHijo(i));
                }
            }
            if(colaPadre.isEmpty())
            {
                pilaResultante.add(null);
                colaPadre=colaHijo;
                colaHijo=new LinkedList();
                
            }
        }
        
        int j;
        while (!pilaResultante.empty())
        {
            if(pilaResultante.peek()==null){
                
                pilaResultante.pop();
                jta.append("\n");
            }
            else
            {
                jta.append(String.valueOf(pilaResultante.pop()+" "));
            }
            
           
          
            
        }
        
        
        
    }
    
    public void  MayorElementoNivelIterativo(JTextArea jta)
    {
        int mayor=0;
        Queue<Nodo> colaResultante=new LinkedList();
          Queue<Nodo> colaSuperior=new LinkedList();
          Queue<Nodo> colaInferior=new LinkedList();
    Nodo P=null;
    Nodo aux=null;
    colaSuperior.add(raiz);
    P=colaSuperior.peek();
        
    jta.append(String.valueOf(P.ElementoMayor())+" ");
    jta.append("\n");
            
        
    
    //1.- empezar con una cola con la raiz.
    //2.- buscar el mayor e imprimirlo 3.- tengo que llenar la cola inferior con los hijos de la raiz
    while(!colaSuperior.isEmpty() )
    {
        P=colaSuperior.poll();
        while(P!=null)
        {
            for (int i = 1; i <= P.M; i++) 
            {
                if(P.getHijo(i)!=null)
                {
                 colaInferior.add(P.getHijo(i));
                colaResultante.add(P.getHijo(i));
                }
            
            }
            P=colaSuperior.poll();
        }
        colaSuperior=new LinkedList();
        colaSuperior=colaResultante;
        colaResultante=new LinkedList();
        
       
        int MayorAnterior;
        int resultante=0;
        
        Nodo aux2=null;
        while(colaInferior.peek()!=null)
        {
            aux2=colaInferior.peek();
            
            
            if(aux2!=null)//Estos dos fi iguales porque me da error de exepcion por un null
            {
                
                MayorAnterior=colaInferior.poll().ElementoMayor();
                aux2=colaInferior.peek();
                if(MayorAnterior<0) resultante=MayorAnterior-1;
                if(aux2!=null)
                {
                    
                   
                    mayor=colaInferior.poll().ElementoMayor();
                    if(mayor<0) resultante=mayor-1;
                    if(MayorAnterior>mayor)
                    {
                        resultante=MayorAnterior;
                    }
                    else
                    {
                        resultante=mayor;
                    }
                }
                else
                {
                    if(MayorAnterior>resultante)
                    {
                        resultante=MayorAnterior;
                    }
                    
                }
                
            }
            
               if(colaInferior.peek()==null)
               {
                jta.append(String.valueOf(resultante));
                jta.append("\n");
               }
                
            
            
            
            
            
            
        }
       
    //   colaInferior=new LinkedList();
            
        
     }
    
    
 }
        public void MayorElementoporNivel(JTextArea jta)
        {
            Queue <Nodo> colap=new LinkedList();
            Queue <Nodo> colah=new LinkedList();
            Nodo aux=null;
            int mayor;
            colap.add(raiz);
            int auxiliar;
            int mayoranterior=colap.peek().ElementoMayor();
            
            
            
            while(!colap.isEmpty())
            {
               
                aux=colap.poll();
                mayor=aux.ElementoMayor();
                if(mayor<mayoranterior)
                { 
                    
                    mayor=mayoranterior;
                    
                }
                mayoranterior=mayor;
                
                
                
                
                for (int i = 1; i <= aux.M; i++) 
                {
                    if(aux.getHijo(i)!=null)
                    {
                       colah.add(aux.getHijo(i));
                    }
                    
                }
                if(colap.isEmpty())
                {
                    jta.append(String.valueOf(mayor));
                    jta.append("\n");
                    colap=colah;
                    colah= new LinkedList();
                    if(colap.peek()!=null)
                    {
                    mayoranterior=colap.peek().ElementoMayor();
                    }
                    
                }
                
                
            }
                   
            
            
            
        }
     public void ParesApartirdeunNivel(JTextArea jta, int x) {
        jta.setText("");
        Queue<Nodo> ColaA = new LinkedList();
        Queue<Nodo> ColaB = new LinkedList();
        ParesApartirdeunNivel(this.raiz, x, ColaA);
        jta.setText("");
        Nodo P = null, q;
        while (!ColaA.isEmpty()) {
            P = ColaA.poll();
            for (int i = 1; i <= P.CantOcupados(); i++) {
                if (P.getElem(i) % 2 == 0) {
                    jta.append(String.valueOf(P.getElem(i)) + " ");
                }
            }
            for (int i = 1; i <= P.M; i++) {
                q = P.getHijo(i);
                if (q != null) {
                    ColaB.add(q);
                }
            }

            if (ColaA.isEmpty()) {
                ColaA = ColaB;
                ColaB = new LinkedList();
                jta.append("\n");
            }
        }
    }

    private void ParesApartirdeunNivel(Nodo P, int x, Queue<Nodo> Cola) {
        if (P == null) {
            return;
        }
        if (x == 1) {
            Cola.add(P);

        } else {
            for (int i = 1; i <= P.M; i++) {
                ParesApartirdeunNivel(P.getHijo(i), x - 1, Cola);
            }
        }
}   
    
    
    
}
