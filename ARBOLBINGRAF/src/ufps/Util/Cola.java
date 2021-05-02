package ufps.Util;
/**@author ANDRES */
public class Cola <G>{
    private ListCD<G> miLista=new ListCD<G>();
    public Cola() {
    }
    public void enColar(G info)
    {
        this.miLista.addFin(info);
    }
    public G deColar()
    {
        return(this.miLista.remove(0));
    }
    public int getSize()
    {
        return(this.miLista.getSize());
    }
    public boolean esVacio()
    {
    return (this.miLista.esVacio());
    }
}