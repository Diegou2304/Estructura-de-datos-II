/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoslistasadyacencia;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Diego U
 */
public class GrafoL{
    private LinkedList<Nodo> listaCabeceras;
    private int n;
    
    GrafoL()
    {
        n=-1;//Esto simboliza la cantidad de vertices
        listaCabeceras=new LinkedList();
    }
    public void CrearVertice()
    {
        n++;
        listaCabeceras.add(new Nodo(n));
    }
    private boolean esVerticeValido(int a)
    {
        
        return (a>=0 && a<=n);
    }
    public int cantVertices()
    {
        return n+1;
    }
    
    public void InsertarArco(int u, int v)
    {
        if(esVerticeValido(u) && esVerticeValido(v))
        {
            if(!listaCabeceras.get(u).Existe(u) && !listaCabeceras.get(v).Existe(v))
            {
                listaCabeceras.get(u).listaAdyacentes.add(v);
                listaCabeceras.get(u).OrdenarListaAdyacentes();
                
                listaCabeceras.get(v).listaAdyacentes.add(u);
                 listaCabeceras.get(v).OrdenarListaAdyacentes();
                
            }
            else
            {
                System.out.println("Arco no valido");
            }
        }
        else
        {
            System.out.println("Arco no valido");
        }
        
        
        
   }
    private void DesmarcarTodos()
    {
        for (int i = 0; i < listaCabeceras.size(); i++) 
        {
            listaCabeceras.get(i).Desmarcar();
            
        }
        
    }
    private boolean esMarcado(int u)
    {
        return listaCabeceras.get(u).GetMarca();
        
    }
    //Creo que esta funcion nos devuelve 1 o 0 dependiendo si existe arco entre los dos vertices
    public boolean getArco(int u, int v)
    {
        return listaCabeceras.get(u).Existe(v) && listaCabeceras.get(v).Existe(u); 
    }
    public void DFS(int verticeInicio)
    {
        if(!esVerticeValido(verticeInicio)) return;
        this.DesmarcarTodos();
        dfs(verticeInicio);
    }
    private void dfs(int verticeInicio)
    {
        Nodo aux;
        
        aux=listaCabeceras.get(verticeInicio);
        System.out.print(aux.cabecera+" ");
        aux.Marcar();
        
        for (int i = 0; i <aux.listaAdyacentes.size() ; i++) 
        {
            if(!listaCabeceras.get(aux.listaAdyacentes.get(i)).GetMarca())
            {
                dfs(aux.listaAdyacentes.get(i));
            }
            
        }
        
        
    }
    public void BFS(int verticeInicio)
    {
       DesmarcarTodos();
      
       Queue<Nodo> x=new LinkedList();
      x.add(listaCabeceras.get(verticeInicio));
      
      listaCabeceras.get(verticeInicio).Marcar();
      Nodo aux=null;
      while(!x.isEmpty())
      {
          aux=x.poll();
          System.out.print(aux.cabecera+" ");
          
          for (int i = 0; i < aux.listaAdyacentes.size(); i++) 
          {
              if(!esMarcado(aux.listaAdyacentes.get(i)))
              {
                  x.add(listaCabeceras.get(aux.listaAdyacentes.get(i)));
                  listaCabeceras.get(aux.listaAdyacentes.get(i)).Marcar();
              }
              
          }
          
          
      }
      
      
   }

           
       
        
        
        
    
    
        
        
        
        
        
    
}
