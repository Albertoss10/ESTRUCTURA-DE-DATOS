package Arboles.Ejemplo;

import java.util.ArrayDeque;

public class Arbol {
    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(int dato) {
        raiz = new NodoArbol(dato);
    }

    public Arbol(int dato, Arbol izquierdo, Arbol derecho) {
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
    public boolean contiene(int dato) {
        return this.contieneRec(raiz, dato);
    }

    private boolean contieneRec(NodoArbol nodo, int dato) {
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

    /* 2 SE PIDE:
Codificar un nuevo método en la clase Arbol
public boolean contieneEnHoja(int dato)
que determine si el dato recibido como parámetro se encuentra en un nodo hoja del  árbol o no.
*/

    public boolean contieneEnHoja(int dato) {
        return contieneEnHojaRec(raiz, dato);
    }
    public boolean contieneEnHojaRec(NodoArbol nodo, int dato) {
        boolean resul = false;
        if (nodo != null) {
            if (nodo.getDato() == dato) {
                resul = (nodo.getDerecho() == null && nodo.getIzquierdo() == null);
            } else {
                resul = contieneEnHojaRec(nodo.getIzquierdo(), dato) || contieneEnHojaRec(nodo.getDerecho(), dato);
            }
        }
        return resul;
    }

    /*  3 SE PIDE:
     Codificar un nuevo método en la clase Arbol
     public int numHojas()
     que calcule cuántos nodos hojas tiene el árbol.
 */
    public int numHojas() {
        return numHojasRec(raiz);
    }
    public int numHojasRec(NodoArbol nodo) {
        int resul=0;
        if (nodo != null) {
            if (nodo.getDerecho() == null && nodo.getIzquierdo() == null){
                resul = 1;
            }
        } else {
            resul = numHojasRec(nodo.getIzquierdo()) + numHojasRec(nodo.getDerecho());
        }
        return resul;
    }

/* 4
SE PIDE:
Codificar un nuevo método en la clase Arbol
public int sumaDatosImparesDosHijos()
que devuelva la suma de los valores de los nodos que cumplen dos condiciones:
-	Tienen valor impar.
-	Tienen dos hijos.

 */

    public int sumaDatosImparesDosHijos() {
        return sumaDatosImparesDosHijosRec(raiz);
    }
    private int sumaDatosImparesDosHijosRec(NodoArbol nodo) {
        int resul=0;
        if (nodo != null) {
            if ((nodo.getDato() % 2 != 0) && (nodo.getIzquierdo() != null) && (nodo.getDerecho() != null)) {
                resul = nodo.getDato() + sumaDatosImparesDosHijosRec(nodo.getIzquierdo()) + sumaDatosImparesDosHijosRec(nodo.getDerecho());
            } else {
                resul = sumaDatosImparesDosHijosRec(nodo.getIzquierdo()) + sumaDatosImparesDosHijosRec(nodo.getDerecho());
            }
        }
        return  resul;
    }
    /* 5
    SE PIDE:
    Codificar un nuevo método en la clase Arbol
    public boolean igual(Arbol arbol)
    que determine si el árbol recibido como parámetro es exactamente igual que el árbol  con el que se invoca el método (el que recibe el mensaje).

     */
    public boolean igual(Arbol arbol) {
        return igualRec(this.raiz, arbol.raiz);
    }
    private boolean igualRec(NodoArbol nodo1, NodoArbol nodo2) {
        boolean resul=false;
        if (nodo1 == null && nodo2 == null) {
            resul = true;
        } else if (nodo1 == null || nodo2 == null) {
            resul = false;
        } else {
            resul = nodo1.getDato() == nodo2.getDato() && igualRec(nodo1.getIzquierdo(), nodo2.getIzquierdo()) &&
                    igualRec(nodo1.getDerecho(), nodo2.getDerecho());
        }
        return  resul;
    }
/* 6
SE PIDE:
Codificar un nuevo método en la clase Arbol
public int sumaDatosNivel(int nivel)
que devuelva la suma de los valores de todos los nodos que se encuentran en el nivel  recibido como parámetro.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite la realización de un único recorrido en el árbol.


 */

    public int sumaDatosNivel(int nivel) {
        int resul=0;
        if (nivel >= 1) {
            resul= sumaDatosNivelRec(raiz, nivel, 1);
        }
        return resul;
    }
    private int sumaDatosNivelRec(NodoArbol nodo, int nivel, int nivActual) {
        int resul=0;
        if (nodo != null) {
            if (nivActual == nivel) {
                resul= nodo.getDato();
            } else { // nivActual < nivel
                resul= sumaDatosNivelRec(nodo.getIzquierdo(), nivel, nivActual + 1) + sumaDatosNivelRec(nodo.getDerecho(), nivel, nivActual + 1);
            }
        }
        return resul;
    }


/* 7
SE PIDE:
Codificar un nuevo método en la clase Arbol
public void altura()
que calcule la altura del árbol, es decir, la profundidad máxima de sus nodos.
OBSERVACIONES:
-	Si el árbol está vacío, este método devuelve el valor 0.
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite la realización de un único recorrido en el árbol.


 */

    public int altura() {
        return alturaRec(raiz, 1);
    }
    private int alturaRec(NodoArbol nodo, int nivel) {
        int resul = 0;
        if (nodo != null) {
            if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) resul = nivel;
            else {
                int alturaIz, alturaDer;
                alturaIz = alturaRec(nodo.getIzquierdo(), nivel + 1);
                alturaDer = alturaRec(nodo.getDerecho(), nivel + 1);
                if (alturaDer > alturaIz) resul = alturaDer;
                else resul = alturaIz; // alturaIz >= alturaDer
            }
        }
        return resul;
    }

    public int altura1() {
        return alturaRec1(raiz);
    }
    private int alturaRec1(NodoArbol nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIz, alturaDer;
            alturaIz = alturaRec1(nodo.getIzquierdo());
            alturaDer = alturaRec1(nodo.getDerecho());
            if (alturaDer > alturaIz) {
                return alturaDer + 1;
            } else {
                return alturaIz + 1;
            }
        }
    }

/* 8
SE PIDE:
Codificar un nuevo método en la clase Arbol
public void completar2Hijos()
que transforme el árbol, de forma que todos los nodos sean o bien hojas, o bien nodos  con dos hijos, incluyendo en él una serie de nodos adicionales. Estos nodos adicionales  contendrán un valor igual al nivel en el que están.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite la realización de un único recorrido en el árbol.

 */

    public void completar2Hijos() {
        completar2HijosRec(raiz, 1);
    }
    private void completar2HijosRec(NodoArbol nodo, int nivel) {
        if (nodo != null) {
            if (nodo.getIzquierdo() != null && nodo.getDerecho() != null) {
                completar2HijosRec(nodo.getIzquierdo(), nivel + 1);
                completar2HijosRec(nodo.getDerecho(), nivel + 1);
            } else if (nodo.getIzquierdo() != null) {
                // Derecho null, izquierdo no
                nodo.setDerecho(new NodoArbol(nivel + 1, null, null));
                completar2HijosRec(nodo.getIzquierdo(), nivel + 1);
            } else if (nodo.getDerecho() != null) {
                // Izquierdo null, derecho no
                nodo.setIzquierdo(new NodoArbol(nivel + 1, null, null));
                completar2HijosRec(nodo.getDerecho(), nivel + 1);
            } // Si ambos hijos son null, no hacer nada
        } // Si nodo es null, no hacer nada
    }

    /* 9
    SE PIDE:
Codificar un nuevo método en la clase Arbol
public void sumarHojasNivel(int maxNivel)
que realice la suma de las claves de los nodos hoja que estén por encima de un nivel  dado como argumento (maxNivel).
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar
-	Sólo se permite la realización de un único recorrido en el árbol.

     */
    public int sumaHojasNivel(int maxNivel) {
        int resul=0;
        if (maxNivel > 1) {
            resul= sumaHojasNivelRec(maxNivel, raiz, 1);
        }
        return resul;
    }
    private int sumaHojasNivelRec(int maxNivel, NodoArbol nodo, int nivel) {
        int resul=0;
        if ((nodo != null) || (nivel < maxNivel)) {
            if ((nodo.getDerecho() == null) && (nodo.getIzquierdo() == null)) { // Nodo hoja
                resul = nodo.getDato();
            } else {
                resul = sumaHojasNivelRec(maxNivel, nodo.getDerecho(), nivel + 1) + sumaHojasNivelRec(maxNivel, nodo.getIzquierdo(), nivel + 1);
            }
        }
        return resul;
    }
    /* 10
    SE PIDE:

Codificar un nuevo método en la clase Arbol

public void invertir()

Que invierta el árbol, de forma que, para cada uno de los nodos, el hijo izquierdo pase a ser el hijo derecho y viceversa.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar

     */


    public void invertir() {
        raiz = this.invertir(raiz);
    }
    private NodoArbol invertir(NodoArbol nodo) {
        if (nodo != null) {
            NodoArbol aux = nodo.getIzquierdo();
            nodo.setIzquierdo(this.invertir(nodo.getDerecho()));
            nodo.setDerecho(this.invertir(aux));
        }
        return nodo;
    }
    private void invertirMio(NodoArbol nodo){
        if(nodo != null){
            NodoArbol aux = nodo.getIzquierdo();
            nodo.setIzquierdo(nodo.getDerecho());
            nodo.setDerecho(aux);
            invertirMio(nodo.getIzquierdo());
            invertirMio(nodo.getDerecho());
        }
    }

    /* 11
SE PIDE:

Codificar un nuevo método en la clase Arbol

public boolean esUnivaluado()

que compruebe si todos los nodos del árbol tienen el mismo valor.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.


     */
    public boolean esUnivaluado() {
        boolean resul= false;
        if (raiz == null) {
            resul= true;
        } else {
            resul= this.esUnivaluado(raiz, raiz.getDato());
        }
        return resul;
    }

    private boolean esUnivaluado(NodoArbol nodo, int dato) {
        boolean resultado = true;
        if (nodo != null) {
            resultado = dato == nodo.getDato() &&
                    this.esUnivaluado(nodo.getIzquierdo(), dato) &&
                    this.esUnivaluado(nodo.getDerecho(), dato);
        }
        return resultado;
    }
    public boolean esUnivaluadoMio(NodoArbol nodo, int dato){
        boolean mismo = true;
        if(nodo != null){
            if(nodo.getDato() != dato){
                mismo = false;
            } else {
                mismo = esUnivaluadoMio(nodo.getIzquierdo(),dato);
                if(mismo){
                    mismo = esUnivaluadoMio(nodo.getDerecho(),dato);
                }
            }
        }

        return mismo;
    }
}

