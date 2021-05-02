package ufps.Util;
import java.util.Iterator;
/**@author ANDRES */
public class ListS<G> implements Iterable<G>{
    private Nodo<G> cab;
    private int size;
    public ListS() {
        this.cab=null;
        this.size=0;
    }
    public void addInicio(G x){
        this.cab=new Nodo<G>(x, this.cab);
        this.size++;
    }
    public void addFin(G x) {
        if(this.cab==null)
            this.addInicio(x);
        else {
            try {
                Nodo<G> ult=this.getPos(this.size-1);
                ult.setSig(new Nodo<G>(x, null));
                this.size++;
            }catch(UFPSException e) {
                System.err.println(e.getMessage());
            }
        }
    }
    public void addOrdenado(G info) {
        if (this.esVacia())
            this.addInicio(info);
        else {
            Nodo<G> x=this.cab;
            Nodo<G> y=x;
                while(x!=null) {
                    Comparable comparador=(Comparable)info;
                    int rta=comparador.compareTo(x.getInfo());
                    if(rta<0)
                        break;
                    y=x;
                    x=x.getSig();
                }
            if(x==y)
                this.addInicio(info);
            else {
                y.setSig(new Nodo<G>(info, x));
                this.size++;
            }
        }
    }
    public void set(int i, G dato){
        try{
            Nodo<G> t=this.getPos(i);
            t.setInfo(dato);
        }catch(UFPSException e) {
            
            System.err.println(e.getMessage());
        }
    }
    public G get(int i) {
        try {
            Nodo<G> t=this.getPos(i);
            return (t.getInfo());
        }catch(UFPSException e) {
            System.err.println(e.getMessage());
        }
        return(null);
    }
    private Nodo<G> getPos(int i) throws UFPSException {
        
        if(this.esVacia() || i>this.size  || i<0)
            throw new UFPSException("El indice solicitado no existe en la Lista Simple");
        
        Nodo<G> t=this.cab;
        while(i>0) {
            t=t.getSig();
            i--;
        }
        return(t);
    }
    public G remove(int i) {
        
        if(this.esVacia())
            return null;
        
        Nodo<G> t=this.cab;
        if(i==0)
            this.cab=this.cab.getSig();
        else {
            try {
                Nodo<G> y=this.getPos(i-1);
                t=y.getSig();
                y.setSig(t.getSig());
            }catch(UFPSException e) {
                System.err.println(e.getMessage());
            }
        }
        t.setSig(null);
        this.size--;
        return(t.getInfo());
    }
    public void removeAll(){
           this.cab=null; 
           this.size=0;
    }
    public boolean esVacia() {
        return(this.cab==null);
    }
    public void Invertir() {
        Nodo<G> a,p;
        a=p=null;
        while(this.cab!=null) {
            a=this.cab;
            this.cab=this.cab.getSig();
            a.setSig(p);
            p=a;
        }
        this.cab=a;
    }
    public int getSize() {
        return (this.size);
    }
    @Override
    public String toString() {
        if (this.esVacia())
            return ("Lista Vacia");
        String r="";
        for(Nodo<G> x=this.cab;x!=null;x=x.getSig())
            r+=x.getInfo().toString()+"->";
        return(r);
    }
    public int indexOf(G info) {
        int i=0;
        for(Nodo<G> x=this.cab;x!=null;x=x.getSig()) {
            if(x.getInfo().equals(info))
                return (i);
            i++;
        }
        return (-1);
    }
    @Override
    public Iterator<G> iterator() {
        
        return new IteratorLS<G>(this.cab);
        
    }
    public G[] toArray() {
        if(this.esVacia())
            return (null);
        Object vector[]=new Object[this.size];
        int i=0;
        Iterator<G> it=this.iterator();
        while(it.hasNext())
            vector[i++]=it.next();
        return((G[])vector);
    }
    public boolean containTo(G info) {
        return (this.indexOf(info)!=-1);
    }
    public boolean concat(ListS lista2) {
        if(!this.esVacia()) {
            for(Iterator<G> l= lista2.iterator(); l.hasNext(); )
                this.addFin(l.next());
        }else return false;
        return true;
    }
}