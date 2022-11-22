package Arboles.Ejemplo.ArbolBinario;

public class Cola {
    private Nodo primero, ultimo;
    private int numElementos;

    public Cola() {
        primero = null;
        ultimo = null;
        numElementos = 0;
    }

    /**
     * Determina si la cola está vacía o no
     */
    public boolean vacia() {   // Comprueba si la cola está vacía
        return primero == null;
    }

    /**
     * Coloca el dato al final de la cola, si es posible.
     */
    public void encolar(NodoArbol dato) {    // Coloca el elemento v al final de la cola
        Nodo nuevo;
        nuevo = new Nodo(dato, null);
        if (!this.vacia()) {
            ultimo.setSiguiente(nuevo);
        } else {
            primero = nuevo;
        }
        ultimo = nuevo;
        numElementos++;
    }

    /**
     * Elimina el primer elemento de la cola y lo devuelve, si es posible.
     */
    public NodoArbol desencolar() {
        NodoArbol resul = null;
        if (this.vacia()) {
            System.out.println("Error al desencolar, la cola está vacía");
        } else {
            resul = primero.getDato();
            primero = primero.getSiguiente();
            if (primero == null) {  // La cola se queda vacía
                ultimo = null;
            }
            numElementos--;
        }
        return resul;
    }

    /**
     * Devuelve el primer elemento de la cola sin eliminarlo, si es posible.
     */
    public NodoArbol getPrimero() {
        NodoArbol resul;
        if (!this.vacia()) {
            resul = primero.getDato();
        } else {
            System.out.println("Error, la cola está vacía");
            resul = null;
        }
        return resul;
    }

    /**
     * Devuelve el número de elementos que contiene la cola
     */
    public int tamaño() {
        return numElementos;
    }



}
