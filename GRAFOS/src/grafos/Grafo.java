/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos;

import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author Diego U
 */
public class Grafo {

    private static int max = 50;
    private int M[][];
    private int n;

    public Grafo() {
        M = new int[max][max];
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                M[i][j] = 0;
            }
        }
        n
                = -
1;
        marca = new boolean[max + 1];
    }

    public void crearVertice() {
        if (n == max) {
            JOptionPane.showMessageDialog(null, "Numero de vertice igual a" + max + 1);
            return;
        }
        n++;
    }

    public int cantVertices() {
        return n + 1;
    }

    public boolean esVerticeValido(int v) {
        return (v >= 0 && v <= n);
    }

    public void insertarArco(int u, int v) {
        if (!esVerticeValido(u) || !esVerticeValido(v)) {
            JOptionPane.showMessageDialog(null, "No es un vertice valido");
            return;
        }
        M[u][v] = 1;
        M[v][u] = 1;
    }

    public void eliminarArco(int u, int v) {
        if (!esVerticeValido(u) || !esVerticeValido(v)) {
            return;     //No existe el vertice u o el vertice v.        
        }
        M[u][v] = 0;
        M[v][u] = 0;
    }
    private boolean marca[];

    private void desmarcarTodos() {
        for (int i = 0; i <= n; i++) {
            marca[i] = false;
        }
    }

    private void marcar(int u) {
        if (esVerticeValido(u)) {
            marca[u] = true;
        }
    }

    private void desmarcar(int u) {
        if (esVerticeValido(u)) {
            marca[u] = false;
        }
    }

    private boolean esMarcado(int u) {   //Devuelve true, si el vertice u está marcado.
        return marca[u];
    }

    public int getArco(int i, int j) {
        return M[i][j];
    }

    public void DFS(int vi, JTextArea jta) {  //Recorrido en profundidad.
        if (!esVerticeValido(vi)) {
            return;  //Validación. v no existe en el Grafo.
        }
        desmarcarTodos();
        jta.append("DFS \n");
        dfs(vi, jta);
    }

    private void dfs(int v, JTextArea jta) {  //mask function 
        jta.append(String.valueOf(v) + " ");
        marcar(v);
        for (int i = 0; i <= n; i++) {   //for (cada w adyacente a v)
            if (M[v][i] > 0) {
                int w = i;
                if (!esMarcado(w)) {
                    dfs(w, jta);
                }
            }
        }
    }

    public void BFS(int v, JTextArea jta) {  //Recorrido en anchura
        if (!esVerticeValido(v)) {
            return;  //Validación v no existe en el Grafo 
        }
        desmarcarTodos();
        LinkedList<Integer> C = new LinkedList<>();  //cola = vacía
        C.add(v);     //Inserta v a la cola (al final de la list)
        marcar(v);
        jta.append("BFS\n");
        do {
            int e = C.pop();       //Obtiene el 1er elemento de la cola.
            jta.append(String.valueOf(e) + " ");
            for (int i = 0; i <= n; i++) {   //for (cada w adyacente a e)
                if (M[e][i] > 0) {
                    int w = i;
                    if (!esMarcado(w)) {
                        C.add(w);
                        marcar(w);
                    }
                }
            }
        } while (!C.isEmpty());
    }
} //end class