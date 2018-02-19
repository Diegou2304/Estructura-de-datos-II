/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesm.vias;
import javax.swing.JTextArea;
/**
 *
 * @author Diego U
 */
public class ArbolM 
{
    //variable
    public Nodo raiz;
   //constructor
    public ArbolM()
    {
        raiz = null;  
    }
    
    //metodos
    ////privados
    private boolean esHoja(Nodo P)
    {
        for(int i=1; i<=P.M; i++)
        {
        if(P.getHijo(i) != null)
        return false;
        }
        return true;
    }
    @SuppressWarnings("static-access")
    private int getHijoDesc(Nodo P, int x) //Toda esta funcion nos devuelve el hijo correspondiente al cual deberia tocarle el nuevo elemento.
  {
                
   
        int i=1;
        while(i < P.M)
        {
        if(x < P.getElem(i))
        {return i;}
        if(x == P.getElem(i))
        {return -1;}
        i++;
        }
        return P.M;
    }
       private void Recorrer(Nodo P, int i)
    {
        
        int num1 = P.getElem(i); 
        int num2=0;
        int c = P.CantOcupados();
        while(i <= c)
        {
            if(P.Ocupado(i+1))
            {
                num2 = P.getElem(i+1);
            }
            P.setElem(num1,i+1);
            num1 = num2;
            i++;
        }
    }
    private void InsertaOrd(Nodo P, int x)
    {
        for(int i = 1; i<P.M; i++)
        {
            if(P.Vacio(i))
            {
               
                P.setElem(x,i);
                return;
            }
            else
            {
                if(x==P.getElem(i))
                {
                    return;
                }
                else
                {
                    if(x < P.getElem(i))
                    {
                        
                        Recorrer(P,i);
                        P.setElem(x,i);
                        return;
                    }
                }
            }
        }
    }
 
    ////publicos
    public void Insertar(int x)
    {
    if(raiz == null)
    {
        raiz = new Nodo();
        raiz.setElem(x,1);
    }
    else
    {
        Nodo P = raiz; Nodo AP=null; int i = 0;
        while(P != null)
        {
            AP = P;
            if(!P.Lleno())
            {
                InsertaOrd(P, x);
                return;
            }
            i=getHijoDesc(P, x);
            if(i == -1)
            {
                return; 
            }
            P = P.getHijo(i);
        }
        Nodo Q = new Nodo();
        Q.setElem(x,1);
        AP.setHijo(Q,i);
    }
}
    
    private void InOrden(Nodo P,JTextArea jta)
    {
    if(P == null)
    {
        return;
    }
    else
        {
        if(esHoja(P))
        { 
            int i = 1; 
            while(i<=P.CantOcupados()) 
            {
                
             jta.append(String.valueOf(P.getElem(i)+ " "));
                  i++;
            }
        }
        else
        {
            for(int i=1; i<=P.M-1; i++)
            {
                InOrden(P.getHijo(i), jta);
                jta.append(String.valueOf(P.getElem(i)+ " "));
            }
            InOrden(P.getHijo(P.M),jta);
        }
    }
}
    public void InOrden(JTextArea jta)
    {
        
        InOrden(this.raiz,jta);
      
    }
}
        
    



    
