package ufps.Util;
import java.util.Iterator;
/**@author ANDRES */
public class ListCD<G> implements Iterable<G>{
    private NodoM<G> cab;
    private int size=0;
    public ListCD() {
        this.cab=new NodoM<G> (null,null,null);
        this.cab.setSig(cab);
        cab.setAnt(cab);
    }
    public void addInicio(G dato){
        NodoM<G> x=new NodoM<G> (dato, cab.getSig(), cab);
        cab.setSig(x);
        x.getSig().setAnt(x);
        this.size++;
    }
public void addFin(G dato){
   NodoM<G>x=new NodoM<G>(dato, cab, cab.getAnt());
    cab.getAnt().setSig(x);
    cab.setAnt(x);
    this.size++;
}
        public G remove(int i){
            try{
                NodoM<G> x=this.getPos(i);
                x.getSig().setAnt(x.getAnt());
                x.getAnt().setSig(x.getSig());
                x.setSig(null);
                x.setAnt(null);
                this.size--;
                return(x.getInfo());
            }catch(UFPSException ex) {
            System.err.println(ex.getMessage());
            }
return(null);
}
    public G get(int i){
        try {
                NodoM<G> x=this.getPos(i);
                return(x.getInfo());
            }catch (UFPSException ex) {
                System.err.println(ex.getMessage());
            }
            return (null);
        }
private NodoM<G> getPos(int i)throws UFPSException{
    if(i<0||i>=this.size)
       throw new UFPSException("Error indice no valido en una Lista Circular Doblemente Enlazada");
    NodoM<G> x=cab.getSig();
    for( ; i-->0; x=x.getSig());
    return x;
}
    public void removeAll(){
        this.cab.setSig(cab);
        this.cab.setAnt(cab);
        this.size=0;
    }
    public boolean esVacio(){
        return(cab==cab.getAnt());
    }
    public int getSize()
    {
        return (this.size);
        
    }
    public int indexOf(G dato)    
    {
    int i=0;
    for(NodoM<G> x=this.cab.getSig();x!=this.cab;x=x.getSig())
    {
      if(x.getInfo().equals(dato))
       return(i);
            i++;
        }
    return (-1);
    }
   public Iterator<G> iterator()
   {
   return (new IteratorLCD<G>(this.cab));
   }
   public void addOrdenado(G info) {
    Comparable x=(Comparable) info;
     if(this.esVacio()|| x.compareTo(this.cab.getSig().getInfo())<=0) {
    this.addInicio(info);
     }
     else{
     NodoM<G> nuevo=new NodoM<G>(info, null, null);
     NodoM<G> p=this.cab.getSig();
     for( ; p.getSig()!= this.cab && x.compareTo(p.getInfo()) >= 0; p = p.getSig());
     if(p.getSig()== this.cab && x.compareTo(p.getInfo()) >= 0)
     {
    this.addFin(info);
    }
                    else {
                        
                        nuevo.setAnt(p.getAnt());
                        nuevo.setSig(p);
                        p.setAnt(nuevo);
                        nuevo.getAnt().setSig(nuevo);
                        this.size++;
                        
                    }
                
                
                }
	}
        public boolean concat(ListCD lista2){
            
            if(!this.esVacio()){
                
                for(IteratorLCD<G> l= (IteratorLCD<G>) lista2.iterator(); l.hasNext(); )
                    this.addFin(l.next());
                
            }else return false;
            
            return true;
        }
    public void set(int i, G dato){
        try{
NodoM<G> t=this.getPos(i);
t.setInfo(dato);
        }catch(UFPSException e)
        {
            System.err.println(e.getMessage());
        }
    }
    public G[] toArray()
    {
         if(this.esVacio())
                return (null);
        Object vector[]=new Object[this.size];
        Iterator<G> it=this.iterator();
        int i=0;
   while(it.hasNext())
    vector[i++]=it.next();
   return((G[])vector);
  }
public String toString()
{
String c="";
for(NodoM<G> x=this.cab.getSig();x.getInfo()!=null;x=x.getSig())
   c+=x.getInfo().toString()+"-";
return(c);
}
   public boolean containTo(G info)
    {
    return (this.indexOf(info)!=-1);
 }
}