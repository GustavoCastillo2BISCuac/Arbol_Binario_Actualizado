package ufps.Util;
import java.util.Iterator;
/**@author ANDRES */
public class ListD<G> implements Iterable<G>{
    private NodoM<G> cab;
	private int size;
 public ListD()
    {
    this.cab=null;
    this.size=0;
}
public void addInicio(G x)
        {
            if (this.cab==null)
            this.cab=new NodoM<G>(x,null,null);
            else{
      this.cab=new NodoM<G>(x, this.cab, null);
      this.cab.getSig().setAnt(this.cab);
    }
            this.size++;
   }
public void addFin(G x)
{
   if(this.cab==null)
   this.addInicio(x);
   else{
   NodoM<G> ult;
   try {
    ult = this.getPos(this.size - 1);
    ult.setSig(new NodoM<G>(x, null, ult));
    this.size++;
   } catch (UFPSException ex) {
    System.err.println(ex.getMessage());
   }
 }
}
public boolean esVacio()
{
   return(this.cab==null);
}
public G remove(int i)
{
   try {
      NodoM<G> x;
     x = this.getPos(i);
     if(x==this.cab)
{
    this.cab=this.cab.getSig();
}
   else {
    x.getAnt().setSig(x.getSig());
   if(x.getSig()!=null)//SI NO ES EL ULTIMO NODO
    x.getSig().setAnt(x.getAnt());
        }
x.setAnt(null);
x.setSig(null);
this.size--;
return(x.getInfo());
      }catch (UFPSException ex) {
        System.err.println(ex.getMessage());
     }
return(null);
}
public void removeAll()
{
  this.cab=null;
  this.size=0;
}
        public G get(int i)
{
   NodoM<G> t;
     try {
    t = this.getPos(i);
    return (t.getInfo());
   } catch (UFPSException ex) {
    System.err.println(ex.getMessage());
    }
return (null);
}
public int getSize()
  {
    return this.size;
  }
private NodoM<G> getPos(int i) throws UFPSException{
     if(i>this.size || this.cab==null || i<0)
     throw new UFPSException("Error indice no valido en una Lista Doble Enlazada");
     NodoM<G> t=this.cab;
    while(i>0){
     i--;
t=t.getSig();    }
  return(t);
}
public String toString()
{
String c="";
for(NodoM<G> x=this.cab;x!=null;x=x.getSig())
 c+=x.getInfo().toString()+"-";
return(c);
}
public int indexOf(G info)
{
            int i=0;
  for(NodoM<G> x=this.cab;x!=null;x=x.getSig())
  {
   if(x.getInfo().equals(info))
   return (i);
                i++;
            }
   return (-1);
}
    @Override
      public Iterator<G> iterator()
      {
          
          return(new IteratorLD<G>(this.cab));
      }
public void addOrdenado(G info)
{ 
Comparable x=(Comparable)(info);
if(this.esVacio()|| x.compareTo(this.cab.getInfo())<=0)
{
    System.out.println("La lista esta vacia");
  this.addInicio(info);
}else{
       NodoM<G> nuevo=new NodoM<G>(info, null, null);
       NodoM<G> p=this.cab;
      for( ; p!= null && x.compareTo(p.getInfo()) >= 0; p = p.getSig());
 if(p==null)
this.addFin(info);
else {
nuevo.setAnt(p.getAnt());
nuevo.setSig(p);
p.setAnt(nuevo);
nuevo.getAnt().setSig(nuevo);
this.size++;
                    }
                }
        }
        public Object[] toArray()
        {
            if(this.esVacio())
                return (null);
            Object vector[]=new Object[this.size];
            Iterator<G> it=this.iterator();
            int i=0;
            while(it.hasNext())
                vector[i++]=it.next();
            return(vector);
        }
        public boolean concat(ListD lista2){
            
            if(!this.esVacio()){
                
                for(IteratorLD<G> l= (IteratorLD<G>) lista2.iterator(); l.hasNext(); )
                    this.addFin(l.next());
            }else return false;
            return true;
        }
        public boolean containTo(G info)
        {
            return (this.indexOf(info)!=-1);
        }
    public void set(int i, G dato){
        
  try{
NodoM<G> t=this.getPos(i);
      if (t==null)
{
     System.err.println("Posici�n:"+ i +",no existe o Lista Vac�a");
}
                
                t.setInfo(dato);
                
        }catch(UFPSException e)
        {
            System.err.println(e.getMessage());
        }
    }
}