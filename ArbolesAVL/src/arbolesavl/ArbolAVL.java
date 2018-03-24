/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesavl;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JTextArea;

/**
 *
 * @author Diego U
 */
public class ArbolAVL 
{
    private NodoBinAVL raiz; 
    
    public void ArbolAVL()
    {
        raiz=null;
    }
    public NodoBinAVL getRaiz()
    {
        return raiz;
    }
    //Como es recursiva revisa que cada nodo despues de insertar este balanceado sino lo balancea y devuelve un mismo nodo
    private NodoBinAVL InsertarBalanceado(int d, NodoBinAVL P)
    {
        //Lo insertamos normalmente
       if(P==null) P=new NodoBinAVL(d);
      
        if(P.getElem()>d)
        {
             P.setHI(InsertarBalanceado(d,P.getHI()));

        }
        else if(P.getElem()<d)
        {
            //Le mando insertar balanceado porque asi en caso que este desbalanceado devuelva un nuevo nodo con las operaciones respectivas
            //para seguir balanceando
           P.setHD(InsertarBalanceado(d,P.getHD()));
        }
        int balanceo=this.FactorBalance(P);
        if(balanceo>1 && this.FactorBalance(P.getHI())==1)
        {
            return this.RotacionDerecha(P);
        }
       if(balanceo<-1 && this.FactorBalance(P.getHD())==-1)
       {
           return this.RotacionIzquierda(P);
       }
       if(balanceo==2 && this.FactorBalance(P.getHI())==-1)
       {
           return this.RotacionIzquierdaDerecha(P);
       }
       if(balanceo==-2 && this.FactorBalance(P.getHD())==1)
       {
           return this.RotacionDerechaIzquierda(P);
       }
       
        
       
           
        return P;
        
    }
    private NodoBinAVL RotacionDerecha(NodoBinAVL P)
    {
        NodoBinAVL aux;
        aux=P.getHI();
        
        P.setHI(aux.getHD());
        aux.setHD(P);
        return aux;
    }
    private NodoBinAVL RotacionIzquierda(NodoBinAVL P)
    {
        //Esto es facil haz la prueba de escritorio :v
         NodoBinAVL aux;
        aux=P.getHD();
        
        P.setHD(aux.getHI());
        aux.setHI(P);
        return aux;
       
        
    }
    private NodoBinAVL RotacionDerechaIzquierda(NodoBinAVL P)
    {
        //Aqui dada una raiz rotamos su hijo derecho primero
        //para que nos quede como una lista despues rotamos toda la raiz
        //Y le mandamos para que retorne la nueva raiz
        P.setHD(this.RotacionDerecha(P.getHD()));//aqui ponemos set para que el subarbol rotado a la derecha ya este listo para hacer el giro a la izquierda
        return this.RotacionIzquierda(P);
        
        
    }
    private NodoBinAVL RotacionIzquierdaDerecha(NodoBinAVL P)
    {
        //Misma explicacon que con derecha izquierda solo que invertido
        P.setHI(this.RotacionIzquierda(P.getHI()));
        return this.RotacionDerecha(P);
        
        
    }
    public int Altura()
    {
        return Altura(this.raiz);
    }
    private boolean esHoja(NodoBinAVL P)
    {
        if(P.getHD()==null && P.getHI()==null)
        {
            return true;
        }
        return false;
    }
    private int Altura(NodoBinAVL P)
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
            int s=Altura(P.getHD());
            int j=Altura(P.getHI());
            if(s>=j) return s+1;
            else
            {
                return j+1;
            }
            }
        }
        
        
    }
  
    private int FactorBalance(NodoBinAVL P)
    {
        return Altura(P.getHI())-Altura(P.getHD());
    }
    public void InsertarBalanceado(int d)
    {
              
        //Igualamos a la raiz para que cuando se balancee no se pierda
        this.raiz=InsertarBalanceado(d,this.raiz);
        
    }
    public void Niveles(JTextArea jta)
    {
        Queue<NodoBinAVL> colapadre=new LinkedList();
        Queue<NodoBinAVL> colahijo=new LinkedList();
        NodoBinAVL aux=null;
        
        colapadre.add(raiz);
        while(!colapadre.isEmpty())
        {
            aux=colapadre.poll();
            jta.append(String.valueOf(aux.getElem())+" ");
            if(aux.getHI()!=null)
            {
                
                colahijo.add(aux.getHI());
                
            }
            if(aux.getHD()!=null)
            {
                colahijo.add(aux.getHD());
            }
            if(colapadre.isEmpty())
            {
                jta.append("\n");
                colapadre=colahijo;
                colahijo=new LinkedList();
                
            }
            
        }
        
        
    }
    public void PreOrden(JTextArea jta)
    {
        PreOrden(jta,this.raiz);
    }
    private void PreOrden(JTextArea jta,NodoBinAVL P)
    {
        if(P==null) return;
        jta.append(P.getElem()+" ");
        PreOrden(jta,P.getHI());
        PreOrden(jta,P.getHD());
    }
    
}
