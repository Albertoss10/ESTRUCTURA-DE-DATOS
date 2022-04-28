package Practica_4_Arboles.arbolbinario;

class NodoArbol {

    private char dato;
    private NodoArbol izquierdo, derecho;

    public NodoArbol(char dato) {
        this.dato = dato;
        this.izquierdo = this.derecho = null;
    }

    public NodoArbol(char dato, NodoArbol izquierdo, NodoArbol derecho) {
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
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
