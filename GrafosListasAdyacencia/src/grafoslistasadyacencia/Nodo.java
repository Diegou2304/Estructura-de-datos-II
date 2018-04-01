/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafoslistasadyacencia;

import java.util.Collections;
import java.util.LinkedList;

/**
 *
 * @author Diego U
 */
public class Nodo {
    public int cabecera;
    public  LinkedList<Integer> listaAdyacentes;
    private boolean marca;        
    
    
    
    Nodo(int a)
    {
        marca=false;
        cabecera=a;
        listaAdyacentes=new LinkedList();
        
    }
    public void OrdenarListaAdyacentes()
    {
        Collections.sort(listaAdyacentes);
    }
    public boolean GetMarca()
    {
        return marca;
    }
    public void Desmarcar()
    {
        marca=false;
        
    }
    public boolean Existe(int u)
    {
        return listaAdyacentes.contains(u);//Funcion que verifica que el elemento exista en la lista
    }
    public void Marcar()
    {
        marca=true;
    }
   
    
    
    
    
    
}
