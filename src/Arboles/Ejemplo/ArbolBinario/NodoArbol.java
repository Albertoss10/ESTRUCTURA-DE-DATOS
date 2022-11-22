package Arboles.Ejemplo.ArbolBinario;

class NodoArbol {

    private int dato;
    private NodoArbol izquierdo, derecho;

    public NodoArbol(int dato) {
        this.dato = dato;
        this.izquierdo = this.derecho = null;
    }

    public NodoArbol(int dato, NodoArbol izquierdo, NodoArbol derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }

}

