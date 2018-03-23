/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbolesavl;

/**
 *
 * @author Diego U
 */
public class NodoBinAVL{
    
    private NodoBinAVL hijoIzq;
    private int elemento;
    private NodoBinAVL hijoDer;
    private int factorEquilibrio;
    public NodoBinAVL(int e) {
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
    public void setHI(NodoBinAVL izq){
        hijoIzq = izq;
    }
    
    public void setElem(int e) {
        elemento = e;
    }
    
    public void setHD(NodoBinAVL der) {
        hijoDer = der;
    }
    
    public NodoBinAVL getHI() {
        return hijoIzq;
    }   
    
    public int getElem() {
    return elemento;
    }
    
    public NodoBinAVL getHD() {
        return hijoDer;
    }
    
}//end class