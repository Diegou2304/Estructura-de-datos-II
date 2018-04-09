/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos.dirigidos;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Diego U
 */
public class Grafo {

    private Vertice primeroV;

    public Grafo() {
        primeroV = null;
    }

    public Vertice crearVertice(Vertice proxV, String nomb, Arco priA) {
        Vertice p = new Vertice(proxV, nomb, priA);
        if (p == null) {
            JOptionPane.showMessageDialog(null, "No existe espacio de memoria");
        }
        return p;
    }

    public Arco crearArco(Vertice verD, float precio, Arco proxA) {
        Arco q = new Arco(verD, precio, proxA);
        if (q == null) {
            JOptionPane.showMessageDialog(null, "No existe espacio de memoria");
        }
        return q;
    }

    public Vertice buscarVertice(String nom) {
        Vertice p = primeroV;
        while (p != null) {
            if (p.getNombre().equals(nom)) {
                return p;
            } else {
                p = p.getProx();
            }
        }
        return null;
    }

    public void insertarArco(String A, String B, float cost) {
        Vertice pa = buscarVertice(A);
        Vertice pb = buscarVertice(B);
        if (pa == null) {
            pa = primeroV = crearVertice(primeroV, A, null);
        }
        if (pb == null) {
            pb = primeroV = crearVertice(primeroV, B, null);
        }
        pa.setPrimero(crearArco(pb, cost, pa.getPrimero()));
    }

    public void imprimir(JTextArea ta) {
        Vertice p = primeroV;
        Arco q;
        while (p != null) {
            q = p.getPrimero();
            while (q != null) {
                ta.append(p.getNombre() + "--> " + q.getVerticeD().getNombre() + " " + String.valueOf(q.getCosto()));  
                ta.append("\n");
                q = q.getProx();
            }
            
            p = p.getProx();
        }
    }
    public float peso()
    {
        float weight=0;
        Vertice p = primeroV;
        Arco q;
        while (p != null) {
            q = p.getPrimero();
            while (q != null) {
                weight=weight+q.getCosto();
                q = q.getProx();
            }
            
            p = p.getProx();
        }
        return weight;
    }
    public int ArcosSalientes(String vertice)
    {
        int narcos=0; //:v//
        Vertice p=this.buscarVertice(vertice);
        Arco q=p.getPrimero();//Nos devuelve el primer arco del vertice
        while(q!=null)
        {
            narcos++;
            q=q.getProx();
        }
        
        return narcos;
      
    }
} //end class
