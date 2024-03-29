package Arboles.Practica_4_Arboles.arbolbinario;

public class Pila {
    private Nodo cima;
    private int numElementos;

    public Pila() {
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void apilar(NodoArbol dato) {
        Nodo nuevo = new Nodo(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    public NodoArbol desapilar() {
        NodoArbol valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = null;
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public NodoArbol getCima() {
        NodoArbol valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = null;
        } else valor = cima.getDato();
        return valor;
    }

    public void quitarCima() {
        if (this.vacia())
            System.out.println("Error, la pila está vacía");
        else {
            cima = cima.getSiguiente();
            numElementos--;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        Nodo auxiliar = cima;
        System.out.println("Contenido de la pila:");
        while (auxiliar != null) {
            System.out.println(auxiliar.getDato());
            auxiliar = auxiliar.getSiguiente();
        }
        System.out.println("FIN");
    }
}