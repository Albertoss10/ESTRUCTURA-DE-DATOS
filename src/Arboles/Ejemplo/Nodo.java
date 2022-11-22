package Arboles.Ejemplo;

class Nodo {

    private NodoArbol dato;
    private Nodo siguiente;

    public Nodo(NodoArbol dato, Nodo siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }

    public NodoArbol getDato() {
        return dato;
    }

    public void setDato(NodoArbol dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }


}

