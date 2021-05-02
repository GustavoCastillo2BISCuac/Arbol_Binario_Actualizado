package ufps.Util;
import java.util.Iterator;
/**@author ANDRES */
public class IteratorLCD<G> implements Iterator<G>{
    private NodoM<G> cab, posicion;
    IteratorLCD(NodoM<G> cab) {
    this.cab=cab;
    this.posicion=this.cab.getSig();
}
    @Override
public void remove()
 {}
    @Override
public boolean hasNext() {
  return (this.posicion!=this.cab);
}
    @Override
public G next() {
    if(!this.hasNext())
    return (null);
    this.posicion=this.posicion.getSig();
    return(this.posicion.getAnt().getInfo());
  }
}