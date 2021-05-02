package ufps.world;
import ufps.util.*;
import java.util.Iterator;
import javax.swing.JPanel;
import ufps.Util.Arbol2;
/**@author ANDRES*/
public class SimuArbbin {
Arbol2<Integer> miArbol=new Arbol2<Integer>();
    public boolean inserta(Integer dato)
    {
        return (this.miArbol.insertar(dato));
    }
    public String borrar(Integer dato)
    {
        Integer x=this.miArbol.borrar(dato);
        if (x==null)
            return ("Dato no existente en el arbol");
       return ("Dato borrado: "+x.toString());
    }
    
    public String preOrden()
    {
    Iterator<Integer> it=this.miArbol.preOrden();
    return (recorrido(it, "Recorrido PreOrden"));
    }
    
    public String inOrden()
    {
    Iterator<Integer> it=this.miArbol.inOrden();
    return (recorrido(it, "Recorrido InOrden"));
    }
    
    public String posOrden()
    {
    Iterator<Integer> it=this.miArbol.posOrden();
    return (recorrido(it, "Recorrido PosOrden"));
    }
    
    public String imprimirPorNivels()
    {
    Iterator<Integer> it=this.miArbol.impNiveles();
    return (recorrido(it, "Impresión por niveles"));
    }
    
    public String darHojas()
    {
    Iterator<Integer> it=this.miArbol.getHojas();
    return (recorrido(it, "Hojas"));
    }
    
    public String darPadre(Integer hijo)
    {
    if(this.miArbol.getRaiz().getInfo().equals(hijo))
        return ("raiz sin padre");
    Integer padre=this.miArbol.padre(hijo);
    if (padre==null)
        return ("No existe el Dato: "+hijo.toString());
    return ("Padre del: "+hijo+"\n es : "+padre.toString());
    }
    
    public String esta(Integer dato)
    {
    boolean siEsta=this.miArbol.buscar(dato);
    String c="El dato:"+dato.toString()+"\n";
    c+=siEsta?"Si se encontro en el arbol":"No se encontro en el arbol";
    return (c);
    }
    private String recorrido(Iterator<Integer> it, String msg)
    {
    String c=msg+"\n";
    while(it.hasNext())
        c+="\t"+it.next().toString()+"\n";
    return(c);
    }
    
    public void podarArbol()
    {
        this.miArbol.podar();
    }
    
    public javax.swing.JTree darTree()
    {
        return (this.miArbol.darJTree());
    }
    
    public JPanel getDibujo() {
        return this.miArbol.getDibujo();
    }
    
}