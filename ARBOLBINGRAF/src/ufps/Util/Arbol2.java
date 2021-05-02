package ufps.Util;
/*** @author ANDRES */
public class Arbol2 <G> extends Arbol1<G>{
    public Arbol2(){
        super();
    }
    public boolean insertar(G dato)
    {
     NodoG<G> cc=this.buscar(dato)?null:insertar(this.raiz, dato);
     if(cc!=null)
     this.setRaiz(cc);
     return (cc!=null);
    }
    private NodoG<G> insertar(NodoG<G> c, G dato)
    {
     if(c==null)
     return(new NodoG<G>(dato,null, null));
     int compara=((Comparable)c.getInfo()).compareTo(dato);
     if(compara>0)  // datodelarbol es menor que dato
      c.setIzq(insertar(c.getIzq(), dato));
     else
        if(compara<0) // datodelarbol es mayor que dato
          c.setDer(insertar(c.getDer(), dato));
     else// datodelarbol es igual que dato
        {
          System.err.println("Error dato duplicado:"+dato.toString());
          //return null;
        }
   return c;
}
    public G borrar(G x){
    if(!this.buscar(x)){
    return null;
    }
     NodoG<G> z=borrar(this.raiz,x);
     this.setRaiz(z);
    return x;
    }
private NodoG<G> borrar(NodoG<G> c, G x){
    if (c==null)
     return null;
     int compara=((Comparable)c.getInfo()).compareTo(x);
    if(compara>0)
     c.setIzq(borrar(c.getIzq(), x));
     else
     if(compara<0)
     c.setDer(borrar(c.getDer(), x));
      else{
     System.out.println("Encontro el dato:"+x.toString());
     if(c.getIzq()!=null && c.getDer()!=null){
     NodoG<G> cambiar=buscarMin(c.getDer());
     G aux=cambiar.getInfo();
    cambiar.setInfo(c.getInfo());
    c.setInfo(aux);
    c.setDer(borrar(c.getDer(),x));
    System.out.println("2 ramas");
}
 else{
 c=(c.getIzq()!=null)? c.getIzq():c.getDer();
 System.out.println("Entro cuando le faltan ramas ");
 }
}
 return c;
}
private NodoG<G> buscarMin(NodoG<G> c)
{
for(; c.getIzq()!=null; c=c.getIzq());
return(c);
}
public boolean buscar(G x){
return(buscar(this.raiz, x));
}
private boolean buscar(NodoG<G> c, G x)
{
if (c==null)
return (false);
int compara=((Comparable)c.getInfo()).compareTo(x);
if(compara>0)
return(buscar(c.getIzq(),x));
else
if(compara<0)
return(buscar(c.getDer(),x));
else
return (true);
 }
}