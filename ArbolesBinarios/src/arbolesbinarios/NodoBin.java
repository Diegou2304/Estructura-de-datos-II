/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesbinarios;

/**
 *
 * @author Diego U
 */
public class NodoBin {
    
    private NodoBin hijoIzq;
    private int elemento;
    private NodoBin hijoDer;
    private int factorEquilibrio;
    public NodoBin(int e) {
        hijoIzq=null;
        elemento = e;
        hijoDer=null;
        factorEquilibrio=0;
    }
    
    public void setFE(int i)
    {
        factorEquilibrio=i;
        
    }
    public int getFE()
    {
        return factorEquilibrio;
    }
    public void EliminarHI()
    {
        hijoIzq=null;
    }
    public void EliminarHD()
    {
        hijoDer=null;
    }
    public void setHI(NodoBin izq){
        hijoIzq = izq;
    }
    
    public void setElem(int e) {
        elemento = e;
    }
    
    public void setHD(NodoBin der) {
        hijoDer = der;
    }
    
    public NodoBin getHI() {
        return hijoIzq;
    }   
    
    public int getElem() {
    return elemento;
    }
    
    public NodoBin getHD() {
        return hijoDer;
    }
    
}//end class