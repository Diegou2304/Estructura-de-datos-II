/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesm.vias;

import javax.swing.JTextArea;

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
    private void PostOrden(JTextArea jta)
    {
        PostOrden(this.raiz,jta);
        
    }
    public void PostOrden(Nodo P, JTextArea jta)
    {
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
}
