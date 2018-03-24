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
        n= -1;
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
    private int cantidadMarcados()
    {
        int acumulador=0;
        for (int i = 0; i <= this.cantVertices(); i++) 
        {
            if(marca[i]!=false)
            {
                acumulador++;
            }
        }
        return acumulador;
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
    
    public int CantidadArco(int u)
    {
        int acumulador=0;
        
        for (int i = 0; i <= this.cantVertices(); i++) 
        {
            if(M[u][i]>0)
            {
                acumulador++;
            }
            
        }
        return acumulador;
        
    }
    public void MostrarAdyacentes(int u, JTextArea jta)
    {
        jta.append("Vertices adyacentes de: " + String.valueOf(u));
        jta.append("\n");
        for (int i = 0; i < this.cantVertices(); i++) 
        {
            if(M[u][i]>0)
            {
                jta.append(String.valueOf(i)+" ");
            }
            
        }
        
        
    }
   
    public boolean esConexo(int v)
    {
        int suma=0;
        
        for (int i = v; i < this.cantVertices(); i++) 
        {
            for (int j = 0; j < this.cantVertices(); j++) 
            {
                if(i!=j && M[i][j]==1)
                {
                   suma+=1;
                }       
                
            }
        }
        return suma>=(this.cantVertices()-1)*2;
        
    }
     public boolean esConexoRecursivo(int v) {  //Recorrido en profundidad.
        if (!esVerticeValido(v)) {
            return false;  //Validación. v no existe en el Grafo.
        }
        desmarcarTodos();
        
        return esConexoRecursivoP(v)==this.cantVertices();
    }

    private int esConexoRecursivoP(int v)//Basicamente recorremos el arbol en profundidad y solo verificamos que se halla recorrido todos los vertices 
    {
       
        
        //mask function 
        int acum=0;
        marcar(v);//Marcamos el primero
        for (int i = 0; i <= n; i++) {   //for (cada w adyacente a v)
            if (M[v][i] >0) {
                int w = i;
                if (!esMarcado(w))//Verificamos para no volverlo a contar 
                {
                    acum+=esConexoRecursivoP(w);
                }
            }
        }
        return acum+1;
        
    }
    public int CantidadIslas()
    {
        int x;
        this.desmarcarTodos();
        if(CantidadIslas(0)==0) return 1;
        else
        {
       return CantidadIslas(0);//Empezamos de 0 porque no importa donde empecemos
        }
    }
    //Tenemos que tener en cuenta que cuando se crea el vertice nace una isla ya depende si esta esta con arco o no
    private int CantidadIslas(int v)
    {
        if(!this.esVerticeValido(v))
        {
            return 0;
        }
        if(this.esMarcado(v)) 
        {
            return CantidadIslas(v+1);
        }
        if(!this.esConexoRecursivo(v))
        {
            
            return 1+CantidadIslas(v+1);
        }
        else
        {
           return 0;
        }
        
    }
    
} //end class
