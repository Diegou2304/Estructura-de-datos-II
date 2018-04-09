/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grafos.dirigidos;

/**
 *
 * @author Diego U
 */
public class Vertice {
private Vertice prox;  
private String nombre;  
private Arco primeroA;
public Vertice(Vertice proxV,String nomb,Arco priA){
prox=proxV;
nombre=nomb;   
primeroA=priA;
}
public void setNombre(String nom){     nombre=nom;      }
public String getNombre(){      return nombre;     }
public void setProx(Vertice proxV){       prox=proxV;     }
public Vertice getProx(){      return prox;     }
public void setPrimero(Arco priA) {      primeroA=priA;   }
public Arco getPrimero() {      return primeroA;     }  
}
