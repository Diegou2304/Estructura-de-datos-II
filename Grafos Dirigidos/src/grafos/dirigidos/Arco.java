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
public class Arco 
{
private Vertice verticeD;
private float costo;
private Arco prox;  
public Arco(Vertice verD,float precio, Arco proxA) {
verticeD=verD;
costo=precio;
prox=proxA;
} 
public void setCosto(float c){    costo=c;   }
public float getCosto(){     return costo;   }
public void setVerticeD(Vertice ptr){     verticeD=ptr;       }
public Vertice getVerticeD(){     return verticeD;      }
public void setProx(Arco p){     prox=p;   } 
public Arco getProx(){     return prox;   }

}