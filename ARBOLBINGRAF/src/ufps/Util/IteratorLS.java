package ufps.Util;
import java.util.Iterator;
/**@author ANDRES */
public class IteratorLS<G> implements Iterator<G>{
    private Nodo<G> posicion;
    IteratorLS(Nodo<G> posicion) {
 this.posicion=posicion;
 }
@Override
public void remove()
 {}
@Override
public boolean hasNext(){
  return (posicion!=null);
 }
@Override
public G next() {
 if(!this.hasNext()) {
 System.err.println("Error no hay mas elementos");
return null;
 }
   Nodo<G> actual=posicion;
   posicion=posicion.getSig();
  return(actual.getInfo());
 }
}