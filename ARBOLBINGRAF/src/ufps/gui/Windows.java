package ufps.gui;
import javax.swing.JOptionPane;
/**@author ANDRES*/
public class Windows {
    public Windows(){
}
public  <G> void imprimirError(G msg1, String msg2)
{
    JOptionPane.showMessageDialog(null, msg1.toString(),msg2,0);
}
public  <G> void imprimirAdvertencia(G msg1, String msg2)
{
   JOptionPane.showMessageDialog(null, msg1.toString(),msg2,2);
}
public  <G> void imprimir(G msg1, String msg2)
{
   JOptionPane.showMessageDialog(null, msg1.toString(),msg2,1);
}
public  static  void main(String arg[])
{
     Windows x=new Windows();
     int a=x.leerInt("lea entero");
     x.imprimirError("Error", "Titulo-Ventana");
     x.imprimirAdvertencia("Advertencia", "Titulo-Ventana");
     x.imprimir("Dato Digitado:"+a, "Titulo-Ventana");
System.exit(0); 
}
public   int leerInt(String msg)
{
return(Integer.parseInt(JOptionPane.showInputDialog(msg)));
}
public   double leerDouble(String msg)
{
return(Double.parseDouble(JOptionPane.showInputDialog(msg)));
}
public   long leerLong(String msg)
{
return(Long.parseLong(JOptionPane.showInputDialog(msg)));
}
public   String leerCadena(String msg)
{
return(JOptionPane.showInputDialog(msg));
}
public   char leerChar(String msg)
{
String a=JOptionPane.showInputDialog(msg);
char b[]= a.toCharArray();
return(b[0]);
}
public   byte leerByte(String msg)
{
return(Byte.parseByte(JOptionPane.showInputDialog(msg)));
}
  public   float leerFloat(String msg){
  return(Float.parseFloat(JOptionPane.showInputDialog(msg)));
 }
}