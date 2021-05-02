package ufps.Util;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Iterator;
import javax.swing.JPanel;
import javax.swing.JPanel;
/**@author ANDRES */
public class Arbol1<G> {
    protected NodoG<G> raiz;
    public Arbol1(NodoG<G> raiz) {
        this.raiz = raiz;
    }
    public Arbol1() {
        this.raiz = null;
    }
    public NodoG<G> getRaiz() {
        return this.raiz;
    }
    public void setRaiz(NodoG<G> c) {
        this.raiz = c;
    }
    public Iterator<G> preOrden() {
        ListS<G> l = new ListS<G>();
        preOrden(this.getRaiz(), l);
        return (l.iterator());
    }
    private void preOrden(NodoG<G> c, ListS<G> l) {
        if (c != null) {
            l.addFin(c.getInfo());
            preOrden(c.getIzq(), l);
            preOrden(c.getDer(), l);
        }
    }
    public Iterator<G> inOrden() {
        ListS<G> l = new ListS<G>();
        inOrden(this.getRaiz(), l);
        return (l.iterator());
    }
    private void inOrden(NodoG<G> c, ListS<G> l) {
        if (c != null) {
            inOrden(c.getIzq(), l);
            l.addFin(c.getInfo());
            inOrden(c.getDer(), l);
        }
    }
    public Iterator<G> posOrden() {
        ListS<G> l = new ListS<G>();
        posOrden(this.getRaiz(), l);
        return (l.iterator());
    }
    private void posOrden(NodoG<G> c, ListS<G> l) {
        if (c != null) {
            posOrden(c.getIzq(), l);
            posOrden(c.getDer(), l);
            l.addFin(c.getInfo());
        }
    }
    public int cardinalidad() {
        return (cardinalidad(this.getRaiz()));
    }
    private int cardinalidad(NodoG<G> c) {
        if (c == null) {
            return 0;
        }
        return (cardinalidad(c.getIzq()) + 1 + cardinalidad(c.getDer()));
    }
    public Arbol1<G> clonar() {
        Arbol1<G> g = new Arbol1<G>();
        g.setRaiz(clonar(this.getRaiz()));
        return (g);
    }
    private NodoG<G> clonar(NodoG<G> c) {
        if (c == null) {
            return c;
        } else {
            NodoG<G> aux = new NodoG<G>(c.getInfo(), clonar(c.getIzq()), clonar(c.getDer()));
            return aux;
        }
    }
    public String Luca() {
        return (Luca(this.raiz));
    }
    private String Luca(NodoG<G> c) {
        if (c == null) {
            return ("a");
        }
        return ("b" + Luca(c.getIzq()) + Luca(c.getDer()));
    }
    public String preOrden_Iterativo() {
        return (preOrden_Iterativo(this.raiz));
    }
    public String preOrden_Iterativo(NodoG<G> c) {

        Pila<NodoG> p = new Pila<NodoG>();
        String cc = "";
        while (c != null) {
            p.push(c);
            cc += c.getInfo().toString() + "-";
            c = c.getIzq();
        }
        while (!p.esVacio()) {
            c = p.pop();
            c = c.getDer();
            while (c != null) {
                cc += c.getInfo().toString() + "-";
                p.push(c);
                c = c.getIzq();
            }
        }
        return (cc);
    }
    public String inOrden_Iterativo() {
        return (inOrden_Iterativo(this.raiz));
    }
    public String inOrden_Iterativo(NodoG<G> c) {
        Pila<NodoG> m = new Pila<NodoG>();
        String cc = "";
        while (c != null) {
            m.push(c);
            c = c.getIzq();
        }
        while (!m.esVacio()) {
            c = m.pop();
            cc += c.getInfo().toString() + "-";
            c = c.getDer();
            while (c != null) {
                m.push(c);
                c = c.getIzq();
            }
        }
        return (cc);
    }
    public Iterator<G> impNiveles() {
        ListS<G> l = new ListS<G>();
        if (!this.esVacio()) {
            Cola<NodoG> c = new Cola<NodoG>();
            c.enColar(this.getRaiz());
            NodoG<G> x = null;
            while (!c.esVacio()) {
                x = c.deColar();
                l.addFin(x.getInfo());
                if (x.getIzq() != null) {
                    c.enColar(x.getIzq());
                }
                if (x.getDer() != null) {
                    c.enColar(x.getDer());
                }
            }
        }
        return (l.iterator());
    }
    public void podar() {
        podar(this.raiz);
    }
    private void podar(NodoG<G> x) {
        if (x == null) {
            return;
        }
        if (this.esHoja(x.getIzq())) {
            x.setIzq(null);
        }
        if (this.esHoja(x.getDer())) {
            x.setDer(null);
        }
        podar(x.getIzq());
        podar(x.getDer());
    }
    protected boolean esHoja(NodoG<G> x) {
        return (x != null && x.getIzq() == null && x.getDer() == null);
    }
    public G padre(G info) {
        if (info == null || this.raiz == null) {
            return null;
        }
        NodoG<G> x = padre(this.raiz, info);
        if (x == null) {
            return null;
        }
        return (x.getInfo());
    }
    private NodoG<G> padre(NodoG<G> x, G info) {
        if (x == null) {
            return null;
        }
        if ((x.getIzq() != null && x.getIzq().getInfo().equals(info)) || (x.getDer() != null && x.getDer().getInfo().equals(info))) {
            return (x);
        }
        NodoG<G> y = padre(x.getIzq(), info);
        if (y == null) {
            return (padre(x.getDer(), info));
        } else {
            return (y);
        }
    }
    public boolean esVacio() {
        return (this.raiz == null);
    }
    public Iterator<G> getHojas() {
        ListS<G> l = new ListS<G>();
        getHojas(this.raiz, l);
        return (l.iterator());
    }
    private void getHojas(NodoG<G> c, ListS<G> l) {
        if (c != null) {
            if (this.esHoja(c)) {
                l.addFin(c.getInfo());
            }
            getHojas(c.getIzq(), l);
            getHojas(c.getDer(), l);
        }
    }
    public boolean esta(G info) {
        return (esta(this.raiz, info));
    }
    private boolean esta(NodoG<G> c, G info) {
        if (c == null) {
            return (false);
        }
        if (c.getInfo().equals(info)) {
            return (true);
        }
        return (esta(c.getIzq(), info) || esta(c.getDer(), info));
    }
    protected DefaultMutableTreeNode crearJtree(NodoG<G> c, String msg) {
        if (esHoja(c)) {
            return (new DefaultMutableTreeNode(msg + c.getInfo().toString()));
        }
        DefaultMutableTreeNode x = new DefaultMutableTreeNode(msg + c.getInfo().toString());
        if (c.getIzq() != null) {
            x.add(crearJtree(c.getIzq(), "Izq->"));
        }
        if (c.getDer() != null) {
            x.add(crearJtree(c.getDer(), "Der->"));
        }
        return x;
    }
    public JTree darJTree() {
        DefaultMutableTreeNode x = new DefaultMutableTreeNode("ARBOL-VACIO");
        if (this.esVacio()) {
            return (new JTree(x));
        }
        return (new JTree(crearJtree(this.raiz, "Raiz(T)->")));
    }
    public Arbol1<G> crearArbol(G Pre[], G In[]) {
        if (!validarPreIn(Pre, In)) {
            return (new Arbol1<G>());
        }
        NodoG<G> rr = crearRaizArbol(Pre, In);
        return (new Arbol1<G>(rr));
    }
    private NodoG<G> crearRaizArbol(G Pre[], G In[]) {
        NodoG<G> nuevo;
        Object DerechosPre[] = new Object[Pre.length];
        Object IzquierdosPre[] = new Object[Pre.length];
        Object DerechosIn[] = new Object[In.length];
        Object IzquierdosIn[] = new Object[In.length];
        int contador = 0, con1 = 0, indiceEncontrado, con2 = 0;;
        if (Pre[0] != null && In[0] != null) {
            nuevo = new NodoG<G>();
            nuevo.setInfo(Pre[0]);
            while (contador < In.length && !In[contador].equals(Pre[0])) {
                IzquierdosIn[contador] = In[contador];
                contador++;
            }
            if (contador == In.length) {
                return (null);
            }
            indiceEncontrado = contador;
            //IzquierdosIn[contador]= null;
            if (In[contador] != null) {
                contador++;
                while (contador < In.length && In[contador] != null) {
                    DerechosIn[con1] = In[contador];
                    contador++;
                    con1++;
                }
            }
            contador = 1;
            con1 = 0;
            while (contador != Pre.length && Pre[contador] != null) {
                if (contador <= indiceEncontrado) {
                    IzquierdosPre[con1] = Pre[contador];
                    con1++;
                } else {
                    DerechosPre[con2] = Pre[contador];
                    con2++;
                }
                contador++;
            }
            nuevo.setIzq(crearRaizArbol((G[]) IzquierdosPre, (G[]) IzquierdosIn));
            nuevo.setDer(crearRaizArbol((G[]) DerechosPre, (G[]) DerechosIn));
            return nuevo;
        }
        return null;
    }
    private boolean validarPreIn(G Pre[], G In[]) {
        if (Pre.length != In.length) {
            return false;
        }
        if (!validarRepetido(Pre)) {
            return false;
        }
        if (!validarRepetido(In)) {
            return false;
        }
        return (true);
    }
    private boolean validarRepetido(G v[]) {
        int con = 0;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                if (v[i].equals(v[j])) {
                    con++;
                }
            }
            if (con > 1) {
                return (false);
            }
            con = 0;
        }
        return (true);
    }
    public JPanel getDibujo() {
        return new ArbolExpresionGrafico(this);
    }
}