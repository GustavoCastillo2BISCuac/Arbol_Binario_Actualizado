package ufps.Util;

/*** @author ANDRES */
public class NodoG <G>{
    private G info;
    private NodoG<G> izq, der;
    public NodoG() {
    }
    public NodoG(G x, NodoG<G> i, NodoG<G> d) {
        
        this.info=x;
        this.izq=i;
        this.der=d;
        
    }
    public NodoG(G x) {
        
        this.info=x;
        this.izq=this.der=null;
        
    }
    public G getInfo() {
        
        return this.info;
        
    }
    public NodoG<G> getIzq() {
        
        return this.izq;
        
    }
    public NodoG<G> getDer() {
        
        return this.der;
        
    }
    public void setIzq(NodoG<G> i) {
        
        this.izq=i;
        
    }
    public void setDer(NodoG<G> d) {
        
        this.der=d;
        
    }
    public void setInfo(G d) {
        
        this.info=d;
        
    }

    String getDato() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}