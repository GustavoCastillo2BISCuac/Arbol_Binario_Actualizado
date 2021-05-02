package ufps.Util;
/**@author ANDRES */
public class Pila<G>{
    private ListCD<G> miLista;
    public Pila() {
        this.miLista=new ListCD<G>();
    }
    public void push(G info) {
        this.miLista.addInicio(info);
    }
    public G pop() {
        return (this.miLista.remove(0));
    }
    public boolean esVacio() {
        return(this.miLista.esVacio());
    }
    public int getSize(){
        return (this.miLista.getSize());
    }
}