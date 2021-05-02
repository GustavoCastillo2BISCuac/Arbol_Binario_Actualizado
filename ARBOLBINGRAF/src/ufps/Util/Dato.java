package ufps.Util;
/** @author ANDRES */
public class Dato <G>{
  private G info;
Dato(G info) {
            this.info=info;
   }
public G getInfo() {
  return(this.info);
}
public void setInfo(G info) {
   this.info=info;
  }
}