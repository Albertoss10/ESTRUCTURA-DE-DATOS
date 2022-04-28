package Practica_4_Arboles.arbolbinario;

import java.util.ArrayDeque;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(char dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(char dato, Arbol izquierdo, Arbol derecho) {
        NodoArbol nodoIzq = null;
        NodoArbol nodoDer = null;
        if (izquierdo != null) {
            nodoIzq = izquierdo.raiz;
        }
        if (derecho != null) {
            nodoDer = derecho.raiz;
        }
        raiz = new NodoArbol(dato, nodoIzq, nodoDer);
    }

    /**
     * Recorrido en preorden
     */
    public void preOrden() {
        System.out.print("Preorden: ");
        this.preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.getDato() + "  ");
            this.preOrdenRec(nodo.getIzquierdo());
            this.preOrdenRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en orden central
     */
    public void ordenCentral() {
        System.out.print("Orden Central: ");
        this.ordenCentralRec(raiz);
        System.out.println();
    }

    private void ordenCentralRec(NodoArbol nodo) {
        if (nodo != null) {
            this.ordenCentralRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato() + "  ");
            this.ordenCentralRec(nodo.getDerecho());
        }
    }

    /**
     * Recorrido en postorden
     */
    public void postOrden() {
        System.out.print("Postorden: ");
        this.postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(NodoArbol nodo) {
        if (nodo != null) {
            this.postOrdenRec(nodo.getIzquierdo());
            this.postOrdenRec(nodo.getDerecho());
            System.out.print(nodo.getDato() + "  ");
        }
    }

    /**
     * Recorrido en amplitud con una cola de nodos del árbol
     */
    public void amplitud() {
        Cola cola = new Cola();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.encolar(raiz);
            while (!cola.vacia()) {
                NodoArbol nodo = cola.desencolar();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.encolar(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.encolar(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Recorrido en amplitud con una cola proporcionada por la clase ArrayDeque
     */
    public void amplitud2() {
        ArrayDeque<NodoArbol> cola = new ArrayDeque<NodoArbol>();
        System.out.print("Amplitud: ");
        if (raiz != null) {
            cola.add(raiz);
            while (!cola.isEmpty()) {
                NodoArbol nodo = cola.remove();
                System.out.print(nodo.getDato() + "  ");
                if (nodo.getIzquierdo() != null) {
                    cola.add(nodo.getIzquierdo());
                }
                if (nodo.getDerecho() != null) {
                    cola.add(nodo.getDerecho());
                }
            }
        }
        System.out.println();
    }

    /**
     * Ejemplo: método que recorre el árbol para determinar si contiene un dato.
     */
    public boolean contiene(char dato) {
        return this.contieneRec(raiz, dato);
    }

    private boolean contieneRec(NodoArbol nodo, char dato) {
        // Búsqueda por preorden
        boolean resul;
        if (nodo == null) {
            resul = false;
        } else if (nodo.getDato() == dato) {
            resul = true;
        } else {
            resul = this.contieneRec(nodo.getIzquierdo(), dato);
            if (!resul) {
                resul = this.contieneRec(nodo.getDerecho(), dato);
            }
        }
        return resul;
    }


    public int suma() {
        return this.sumaRec(raiz);
    }

    private int sumaRec(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        } else {
            return nodo.getDato() + this.sumaRec(nodo.getIzquierdo()) + this.sumaRec(nodo.getDerecho());
        }
    }


    public void preOrdenNivel() {
        System.out.println("Preorden con niveles: ");
        preOrdenNivelRec(raiz, 1);
    }

    private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            System.out.println(nodo.getDato() + " en el nivel " + nivel);
            preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
            preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
        }
    }

    // ------------------------------------------------------------------------
    // 2.3
    private int pasarAEntero(char c) {
        return Character.getNumericValue(c);
    }

    private boolean esOperador(char c) {
        switch (c) {
            case '+':
            case '-':
            case '*':
            case '/':
                return true;
            default:
                return false;
        }
    }

    private boolean esDigito(char c) {
        return (c >= '0' && c <= '9');
    }

    // ------------------------------------------------------------------------
    // TODO 2.3
    public Arbol(String cadena) {
        Pila nodos = new Pila();
        NodoArbol caracter = null;
        char c;
        char [] cadenaArray = cadena.toCharArray();

        if(cadenaArray.length > 0){
            for(int x = 0; x < cadenaArray.length; x++){
                c = cadenaArray[x];
                if(esDigito(c)){
                    caracter = new NodoArbol(c);
                    nodos.apilar(caracter);
                } else if(esOperador(c)){
                    caracter = new NodoArbol(c);
                    if(!nodos.vacia()){
                        caracter.setDerecho(nodos.desapilar());
                        if(!nodos.vacia()){
                            caracter.setIzquierdo(nodos.desapilar());
                        }
                    }
                    nodos.apilar(caracter);
                }
            }
            raiz = caracter;
        }

    }

    // ------------------------------------------------------------------------
    // TODO 2.4
    public void mostrarExpresion() {
        this.mostrarExpresionRec(raiz);
        System.out.println();
    }
    private void mostrarExpresionRec(NodoArbol nodo){
        if(nodo != null){
            if(nodo.getIzquierdo() != null && nodo.getDerecho() != null && nodo != raiz){
                System.out.print("(");
            }
            this.mostrarExpresionRec(nodo.getIzquierdo());
            System.out.print(nodo.getDato());
            this.mostrarExpresionRec(nodo.getDerecho());
            if(nodo.getIzquierdo() != null && nodo.getDerecho() != null && nodo != raiz){
                System.out.print(")");
            }
        }
    }

    // ------------------------------------------------------------------------
    // TODO 2.5
    public void calcularValor(){
        System.out.println(calcularValorRec(raiz) + "\n");
    }
    private double calcularValorRec(NodoArbol nodo) {
        double resultado = 0.0;

        if(nodo != null){
            resultado = this.calcularValorRec(nodo.getIzquierdo());
            if(esOperador(nodo.getDato())){
                switch (nodo.getDato()){
                    case '+':
                        resultado = calcularValorRec(nodo.getIzquierdo()) + calcularValorRec(nodo.getDerecho());
                        break;
                    case '-':
                        resultado = calcularValorRec(nodo.getIzquierdo()) - calcularValorRec(nodo.getDerecho());
                        break;
                    case '*':
                        resultado = calcularValorRec(nodo.getIzquierdo()) * calcularValorRec(nodo.getDerecho());
                        break;
                    case '/':
                        resultado = calcularValorRec(nodo.getIzquierdo()) / calcularValorRec(nodo.getDerecho());
                        break;
                }
            } else if (esDigito(nodo.getDato())){
                resultado = pasarAEntero(nodo.getDato());
            }
        }

        return resultado;
    }
}
