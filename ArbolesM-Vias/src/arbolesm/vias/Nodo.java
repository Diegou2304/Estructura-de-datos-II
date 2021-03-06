/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesm.vias;

/**
 *
 * @author Diego U
 */
public class Nodo {
//variables

    public static int M = 4; //vias
    private int Elemento[];
    private Nodo Hijo[];
    private boolean Estado[];
//constructor

    public Nodo()//posible constructor con M no estatico, pensarlo
    {
        Elemento = new int[M - 1];
        Estado = new boolean[M - 1];
        Hijo = new Nodo[M];
        for (int i = 0; i < M - 1; i++) {
            Estado[i] = false;
            Hijo[i] = null;
        }
        Hijo[M - 1] = null;
    }
//getters

    public int getElem(int i) {
        return Elemento[i - 1];
    }

    public Nodo getHijo(int i) {
        return Hijo[i - 1];
    }
//setters

    public void setElem(int x, int i) {
        Elemento[i - 1] = x;
        Estado[i - 1] = true;
    }

    public void setHijo(Nodo P, int i) {
        Hijo[i - 1] = P;
    }

    public void setVacio(int i) {
        Estado[i - 1] = false;
    }
//metodos

    public boolean Ocupado(int i) {
        return Estado[i - 1];
    }

    public boolean Vacio(int i) {
        return !Estado[i - 1];
    }

    public int CantVacias() {
        int c = 0;
        for (int i = 0; i < Estado.length; i++) {
            if (Estado[i] == false) {
                c++;
            }
        }
        return c;
    }

    public int CantOcupados() {
        return (M - 1) - CantVacias();
    }

    public boolean Lleno() {
        return (CantVacias() == 0);
    }
    public boolean BuscarElemento(int x)
    {
         for(int i=1;i<=this.CantOcupados();i++)
        {
           if(this.getElem(i)==x)
           {
               return true;
           }
            
        }
         return false;
    }
    public int SumaE()
    {
        int suma=0;
        for(int i=1;i<=M-1;i++)
        {
            suma+=this.getElem(i);
            
        }
        return suma;
    }
    public boolean NodosIguales(Nodo P)
    {
        if(P.CantOcupados()==this.CantOcupados())
        {
            for (int i = 1; i <= P.CantOcupados(); i++) 
            {
                if(P.getElem(i)!=this.getElem(i))
                {
                    return false;
                }
                
            }
            return true;
        }
        else
        {
            return false;
        }
    }
    public int ElementoMayor()
    {
        int elem=this.getElem(1);
        for (int i = 2; i <= this.CantOcupados(); i++) 
        {
            if(elem<this.getElem(i))
            {
                elem=this.getElem(i);
            }
            
            
        }
        return elem;
    }
} //end class Nodo
