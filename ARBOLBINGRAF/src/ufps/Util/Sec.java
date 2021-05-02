package ufps.Util;
/**@author ANDRES */
public class Sec<G>{
    private G vector[];
    private int cant=0;
    public Sec(int n) {
        if (n<=0)
         throw new RuntimeException("Error en el programa!");
        Object r[]=new Object[n];
        this.vector=(G[])r;
    }
    public G get(int i) {
     if (i<0 || i>this.cant)
      throw new RuntimeException("Indíces fuera de rango!");
      return (this.vector[i]);
    }
    public void set(int i, G elemNuevo) {
     if (i<0 || i>this.cant)
       throw new RuntimeException("Indíces fuera de rango!");
       this.vector[i]=elemNuevo;
    }
    public void insertar(G elem) {
     if(this.cant>=this.vector.length)
       throw new RuntimeException("No hay más espacio!");
       this.vector[this.cant++]=elem;
    }
    @Override
    public String toString() {
        String msg="";
        for(int i=0;i<this.cant;i++)
        msg+=this.vector[i].toString()+"\t";
        return (msg);
    }
    public boolean existeUnObjeto(G elem) {
        for(int i=0;i<this.cant;i++)
         if(this.vector[i].equals(elem))
         return true;
        return false;
    }
    public int length() {
        return this.cant;
    }
    public int getCapacidad()
    {
        return this.vector.length;
    }
}