package ufps.Util;
/** @author ANDRES */
public class NodoM<G> implements java.io.Serializable{
    private NodoM<G> ant;
    private NodoM<G> sig;
    private G info;
    public NodoM() {
    }
    NodoM(G info, NodoM<G> sig, NodoM<G> ant) {
        this.info=info;
        this.sig=sig;
        this.ant=ant;
    }
    void setInfo(G info) {
            this.info = info;
    }
    G getInfo() {
        return(this.info);
    }
    NodoM<G> getSig() {
        return (this.sig);
    }
    void setSig(NodoM<G> sig) {
        this.sig=sig;
    }
    NodoM<G> getAnt() {
        return (this.ant);
    }
    void setAnt(NodoM<G> ant) {
        
        this.ant=ant;
        
    }
}