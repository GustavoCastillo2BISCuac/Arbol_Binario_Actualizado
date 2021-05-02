package ufps.Util;
/*** @author ANDRES */
public class Nodo <G> implements java.io.Serializable{
    private G info;
    private Nodo<G> sig;
    Nodo() {
        this.info=null;
        this.sig=null;
        
    }
    Nodo(G info, Nodo<G> sig) {
        this.info=info;
        this.sig=sig;
    }
    G getInfo() {
        return this.info;
    }
    Nodo<G> getSig() {
        return this.sig;
    }
    void setInfo(G nuevo) {
        this.info=nuevo;
    }
    void setSig(Nodo<G> nuevo) {
        this.sig=nuevo;
    }
}