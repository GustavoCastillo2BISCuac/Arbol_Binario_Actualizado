package ufps.Util;
import java.util.Iterator;
/**@author ANDRE */
public class IteratorLD<G> implements Iterator<G>{
    private NodoM<G> posicion;
    IteratorLD(NodoM<G> posicion) {
     this.posicion=posicion;
}
@Override
public boolean hasNext() {
   return (posicion!=null);
 }
@Override
public void remove()
 {}
public G next() {
 if(!this.hasNext()) {
 System.err.println("Error no hay mas elementos");
 return null;
 }
  NodoM<G> actual=posicion;
   posicion=posicion.getSig();
  return(actual.getInfo());
  }
}