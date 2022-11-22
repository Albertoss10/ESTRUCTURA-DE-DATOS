package Arboles.Ejemplo.ArbolBinarioBusqueda;

public class ArbolBinarioBusqueda {

	private NodoArbol raiz;
	private int numElementos;

	public ArbolBinarioBusqueda() {
		raiz = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return raiz == null;
	}


	/**
	 * Busca la clave en la lista. Si la encuentra devuelve el alumno asociado a dicha clave,
	 * y si no la encuentra devuelve NULL.
	 */
	public Alumno getElemento(int clave) {
		return this.getElementoRec(raiz, clave);
	}

	private Alumno getElementoRec(NodoArbol nodo, int clave) {
		Alumno resul=null;
		if (nodo != null) {
			 if (clave == nodo.getClave()) resul= nodo.getDato();  // Encontrado
		       else if (clave < nodo.getClave())// Subárbol izquierdo
		       	 resul=this.getElementoRec(nodo.getIzquierdo(), clave);
		         else // Subárbol derecho
					resul=this.getElementoRec(nodo.getDerecho(), clave);
		 }
		return resul;
	}


	/**
	 * Inserta el alumno en la posición que le corresponde según la clave
	 */
	public boolean insertar(Alumno dato) {
		int previousNumElementos = numElementos;
		raiz = this.insertarRec(raiz, dato);
		return (previousNumElementos < numElementos);
	}

	private NodoArbol insertarRec(NodoArbol nodo, Alumno dato) {
		if (nodo == null) {
			nodo = new NodoArbol(dato);   // Crear nuevo nodo
			numElementos++;
		} else if (dato.getMatricula() < nodo.getClave()) {    // Subárbol izquierdo
			NodoArbol nuevoIzq = this.insertarRec(nodo.getIzquierdo(), dato);
			nodo.setIzquierdo(nuevoIzq);
		} else if (dato.getMatricula() > nodo.getClave()) {    // Subárbol derecho
			NodoArbol nuevoDer = this.insertarRec(nodo.getDerecho(), dato);
			nodo.setDerecho(nuevoDer);
		} else {
			System.out.println("Error inserción. La clave " + dato.getMatricula() + " ya existe");
		}
		return nodo;
	}


	/**
	 * Determina si la clave recibida como parámetro existe en la lista.
	 */
	public boolean contiene(int clave) {
		return this.getElemento(clave) != null;
	}

	/**
	 * Elimina de la lista el alumno con número de matrícula clave,
	 * en caso de existir.
	 */
	public boolean borrar(int clave) {
		int previousNumElementos = numElementos;
		raiz = this.borrarRec(raiz, clave);
		return (numElementos < previousNumElementos);
	}

	private NodoArbol borrarRec(NodoArbol nodo, int clave) {
		if (nodo == null) {
			System.out.println("la clave buscada no existe");
		} else if (nodo.getClave() > clave) {  // Buscar en subarbol izquierdo
			NodoArbol nuevoIzq = this.borrarRec(nodo.getIzquierdo(), clave);
			nodo.setIzquierdo(nuevoIzq);
		} else if (nodo.getClave() < clave) {  // Buscar en subarbol derecho
			NodoArbol nuevoDer = this.borrarRec(nodo.getDerecho(), clave);
			nodo.setDerecho(nuevoDer);
		} else {  // Borrar elemento en nodo
			if (nodo.getIzquierdo() == null && nodo.getDerecho() == null) {
				nodo = null;  // Caso 1
			} else if (nodo.getDerecho() == null) {  // Caso 2
				nodo = nodo.getIzquierdo();
			} else if (nodo.getIzquierdo() == null) {  // Caso 2
				nodo = nodo.getDerecho();
			} else {    // Caso 3
				NodoArbol nuevoIzq = this.cambiarPorMenor(nodo, nodo.getIzquierdo());
				nodo.setIzquierdo(nuevoIzq);
			}
			numElementos--;
		}
		return nodo;
	}

	private NodoArbol cambiarPorMenor(NodoArbol nodoBorrar, NodoArbol nodoMenor) {
		if (nodoMenor.getDerecho() != null) {   // Seguir en subárbol derecho
			NodoArbol nuevoDer = this.cambiarPorMenor(nodoBorrar, nodoMenor.getDerecho());
			nodoMenor.setDerecho(nuevoDer);
			return nodoMenor;
		} else {  // Encontrado nodo menor inmediato
			nodoBorrar.setDato(nodoMenor.getDato()); // Cambiar datos de nodos
			return nodoMenor.getIzquierdo();  // Devolver subarbol izquierdo de menor inmediato
		}
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void preOrdenNivel() {
		System.out.println("Preorden con niveles: ");
		preOrdenNivelRec(raiz, 1);
	}

	private void preOrdenNivelRec(NodoArbol nodo, int nivel) {
		if (nodo != null) {
			System.out.println("Clave " + nodo.getClave() + ". En el nivel " + nivel);
			preOrdenNivelRec(nodo.getIzquierdo(), nivel + 1);
			preOrdenNivelRec(nodo.getDerecho(), nivel + 1);
		}
	}
/* 12
Codificar un nuevo método en la clase Arbol
public void mostrarClavesDescendente()
que muestre por pantalla las claves de todos los nodos, pero en orden descendente.

 */
	public void mostrarClavesDescendente() {
		System.out.println("Recorrido descendente");
		mostrarClavesDescendenteRec(raiz);
	}
	private void mostrarClavesDescendenteRec(NodoArbol nodo) {
		if (nodo != null) {
			mostrarClavesDescendenteRec(nodo.getDerecho());
			System.out.print(nodo.getClave() + " ");
			mostrarClavesDescendenteRec(nodo.getIzquierdo());
		}
	}
	private void mostrarClavesDescendenteMio(NodoArbol nodo){
		if(nodo != null){
			mostrarClavesDescendenteRec(nodo.getDerecho());
			System.out.print(nodo.getDato() + " ");
			mostrarClavesDescendenteRec(nodo.getIzquierdo());
		}
	}

/* 13
Codificar un nuevo método en la clase Arbol
public void mostrarClavesUnHijo()
que muestre por pantalla las claves de los nodos que tienen un solo hijo. Además, el  listado
 de claves deberá aparecer en orden descendente.

 */

	public void mostrarClavesUnHijo() {
		System.out.println("Claves con un hijo, descendente");
		mostrarClavesUnHijoRec(raiz);
	}
	private void mostrarClavesUnHijoRec(NodoArbol nodo) {
		if (nodo != null) {
			mostrarClavesUnHijoRec(nodo.getDerecho());
			if ((nodo.getIzquierdo() == null && nodo.getDerecho() != null) || (nodo.getDerecho() == null && nodo.getIzquierdo() != null)) {
				System.out.print(nodo.getClave() + " ");
			}
			mostrarClavesUnHijoRec(nodo.getIzquierdo());
		}
	}
	private void mostrarClavesUnHijoMio(NodoArbol nodo){
		if(nodo != null){
			mostrarClavesUnHijoMio(nodo.getDerecho());
			if(nodo.getIzquierdo() != null && nodo.getDerecho() == null ||nodo.getIzquierdo() == null && nodo.getDerecho() != null){
				System.out.print(nodo.getDato() + " ");
			}
			mostrarClavesUnHijoMio(nodo.getIzquierdo());
		}
	}

/* 14
Codificar un nuevo método en la clase Arbol
public void mostrarClavesEntreDos(int c1, int c2)
que reciba como parámetro dos claves y muestre por pantalla la lista de claves cuyos  valores
 se encuentran comprendidos entre dichas claves (sin incluirlas). Dicho listado  aparecerá
 en orden ascendente.
 OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite la realización de un único recorrido en el árbol.
-	Se penalizarán las soluciones que, aunque correctas, no optimicen el proceso.


 */
public void mostrarClavesEntreDosA(int c1, int c2) {
	System.out.println("Claves entre " + c1 + " y " + c2);
	if (c1 < c2) {
		mostrarClavesEntreDosRecA(raiz, c1, c2);
	} else {
		mostrarClavesEntreDosRecA(raiz, c2, c1);
	}
}
	private void mostrarClavesEntreDosRecA(NodoArbol nodo, int menor, int mayor) {
		// Recorrido en orden central
		if (nodo != null) {
			mostrarClavesEntreDosRecA(nodo.getIzquierdo(), menor, mayor);
			if (nodo.getClave() > menor && nodo.getClave() < mayor) {
				System.out.print(nodo.getClave() + " ");
			}
			mostrarClavesEntreDosRecA(nodo.getDerecho(), menor, mayor);
		}
	}
	private void mostrarClavesEntreDosMio(NodoArbol nodo, int menor, int mayor){
		if(nodo != null){
			if(nodo.getClave() > mayor){
				mostrarClavesEntreDosMio(nodo.getIzquierdo(), menor, mayor);
			}
			if(nodo.getClave()  > menor && nodo.getClave() < mayor){
				System.out.print(nodo.getDato() + " ");
			}
			if(nodo.getClave() < menor){
				mostrarClavesEntreDosMio(nodo.getDerecho(), menor, mayor);
			}
		}
	}


/* 15
SE PIDE:
Codificar un nuevo método en la clase Arbol
public boolean comprobarSiEnHoja(int clave)
que determine si una clave, que recibe como parámetro, se encuentra o no en una  hoja.
En caso de que no se encuentre en el árbol, o se encuentre en un nodo que no es  hoja,
el método devolverá false.

 */

	public boolean comprobarSiEnHoja(int clave) {
		return comprobarSiEnHojaRec(raiz, clave);
	}
	private boolean comprobarSiEnHojaRec(NodoArbol nodo, int clave) {
		boolean resul=false;
		if (nodo != null) {
			if (nodo.getClave() == clave) {
				resul= nodo.getIzquierdo() == null && nodo.getDerecho() == null;
			} else if (nodo.getClave() > clave) { // Buscar a la izquierda
				resul= comprobarSiEnHojaRec(nodo.getIzquierdo(), clave);
			} else { // Buscar a la derecha
				resul= comprobarSiEnHojaRec(nodo.getDerecho(), clave);
			}
		}
		return  resul;
	}



	private boolean comprobarSiEnHojaMio(NodoArbol nodo, int clave){
		boolean resul = false;
		if(nodo != null){
			if(nodo.getClave() < clave){
				resul = comprobarSiEnHojaMio(nodo.getDerecho(), clave);
			} else if(nodo.getClave() > clave){
				resul = comprobarSiEnHojaMio(nodo.getIzquierdo(), clave);
			} else {
				resul = (nodo.getIzquierdo() == null && nodo.getDerecho() == null);
			}
		}

		return resul;
	}


/* 16
Codificar un nuevo método en la clase Arbol
public int antecesoresComunes(int c1, int c2)
que devuelva el número de antecesores comunes a dos claves que se pasan como  argumento.
 Se considerará que ambas claves siempre se encuentran en el árbol (no  comprobar).
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite la realización de un único recorrido en el árbol.

 */
	public int antecesoresComunes(int c1, int c2) {
		int resul=0;
		if (c1 < c2) {
			resul= antecesoresComunesRec(raiz, c1, c2);
		} else {
			resul= antecesoresComunesRec(raiz, c2, c1);
		}
		return resul;
	}
	private int antecesoresComunesRec(NodoArbol nodo, int menor, int mayor) {
		int resul = 0;
		if (nodo != null) {
			if (nodo.getClave() > mayor) {
				resul= 1 + antecesoresComunesRec(nodo.getIzquierdo(), menor, mayor);
			} else if (nodo.getClave() < menor) {
				resul= 1 + antecesoresComunesRec(nodo.getDerecho(), menor, mayor);
			} else if (nodo.getClave() > menor && nodo.getClave() < mayor) {
				resul= 1;
			} else {
				resul= 0;
			}
		}
		return  resul;
	}
	private int antecesoresComunesMio(NodoArbol nodo, int menor, int mayor){
		int resul = 0;
		if(nodo != null){
			if(nodo.getClave() > mayor){
				resul = 1 + antecesoresComunesMio(nodo.getIzquierdo(), menor, mayor);
			} else if(nodo.getClave() < menor){
				resul = 1 + antecesoresComunesMio(nodo.getDerecho(), menor, mayor);
			} else if(nodo.getClave() > menor && nodo.getClave() < mayor){
				resul = 1;
			} else {
				resul = 0;
			}
		}

		return resul;
	}





/* 17
SE PIDE:
Codificar un nuevo método en la clase Arbol
public int diferenciaNiveles(int c1, int c2)
que, recibiendo como argumentos dos claves c1 y c2 que siempre van a pertenecer al  árbol
(donde c1 es menor que c2), devuelva como resultado la diferencia entre los  niveles en los
que aparecen dichas claves.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	No se tendrán en cuenta soluciones que no optimicen la búsqueda en un árbol  binario
 de búsqueda.

 */
public int diferenciaNiveles(int c1, int c2) {
	int resul=0;
	int alturaC1 = alturaClave(raiz, c1);
	int alturaC2 = alturaClave(raiz, c2);
	if (alturaC1 > alturaC2) {
		resul = alturaC1 - alturaC2;
	} else {
		resul = alturaC2 - alturaC1;
	}
	return resul;
}
	private int alturaClave(NodoArbol nodo, int dato) {
	int resul=0;
	if(nodo != null){
		if (nodo.getClave() == dato)
			resul= 1;
		else if (nodo.getClave() > dato) {
			resul= 1 + alturaClave(nodo.getIzquierdo(), dato);
		} else {
			resul=1 + alturaClave(nodo.getDerecho(), dato);
		}
	}

	return resul;
	}






/* 18
SE PIDE:
A. Dibujar el árbol binario de búsqueda correspondiente al siguiente recorrido en  preorden:
25, 15, 7, 5, 10, 17, 30, 28, 40, 35
B. Codificar un nuevo método en la clase Arbol
public int mayorDiferencia()
que, a partir de un árbol binario de búsqueda, devuelva como resultado la mayor
diferencia que existe entre dos claves cualesquiera del árbol
OBSERVACIONES:
-	Si el árbol estuviera vacío o tuviera un único nodo, el método devolverá 0 como  resultado.
-	Solo se tendrán en cuenta las soluciones que optimicen la localización de las claves
en un árbol binario de búsqueda

 */

	public int mayorDiferencia() {
		return claveMayor(raiz) - claveMenor(raiz);
	}
	private int claveMenor(NodoArbol nodo) {
		int resul=0;
		if (nodo != null) {
			if (nodo.getIzquierdo() == null) {
				resul = nodo.getClave();
			} else {
				resul = claveMenor(nodo.getIzquierdo());
			}
		}
		return resul;
	}
	private int claveMayor(NodoArbol nodo) {
		int resul = 0;
		if (nodo != null) {
			if (nodo.getDerecho() == null) {
				resul = nodo.getClave();
			} else {
				resul = claveMayor(nodo.getDerecho());
			}
		}
		return resul;
	}





	/* 19
	SE PIDE:
Codificar un nuevo método en la clase Arbol
public int eliminarSucesores(int clave)
que si existe la clave que recibe como argumento, elimine del árbol todos los nodos
sucesores del nodo que contenga dicha clave, devolviendo como resultado el número  de
nodos eliminados.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite visitar cada nodo del árbol una única vez.
-	Una vez finalizado el proceso, el resto del árbol deberá mantener intacta tanto
su estructura como la información contenida en él.
-	Se penalizarán aquellas soluciones que recorran más nodos de los necesarios.

	 */

	public int eliminarSucesores(int clave) {
		int resul=0;
		NodoArbol nodo = buscarClave(raiz, clave);
		if (nodo != null) {
			resul = numElementos(nodo.getIzquierdo()) + numElementos(nodo.getDerecho());
			nodo.setIzquierdo(null);
			nodo.setDerecho(null);
		}
	 return resul;
	}

	private NodoArbol buscarClave(NodoArbol nodo, int clave) {
		NodoArbol resul = null;
		if (nodo != null) {
			if (nodo.getClave() == clave) {
				resul = nodo;
			} else if (nodo.getClave() > clave) {
				resul = buscarClave(nodo.getIzquierdo(), clave);
			} else {
				resul = buscarClave(nodo.getDerecho(), clave);
			}
		}
		return resul;
	}
	private int numElementos(NodoArbol nodo) {
		int resul=0;
		if (nodo != null) {
			resul = 1 + numElementos(nodo.getIzquierdo()) + numElementos(nodo.getDerecho());
		}
		return resul;
	}

/* 20
SE PIDE: Codificar en Java el siguiente método en la clase Arbol:
public Alumno getElementoMasCercano(int clave)

Este método deberá devolver el alumno del árbol con la clave más cercana a la clave
especificada como argumento, recorriéndolo recursivamente. Si el árbol está vacío este
 método devolverá null.
OBSERVACIONES:
-	No se permite la utilización de ninguna estructura de datos auxiliar.
-	Sólo se permite visitar cada nodo del árbol una única vez.
-	Una vez finalizado el proceso, el resto del árbol deberá mantener intacta tanto  su estructura como la información contenida en él.
-	Se penalizarán aquellas soluciones que recorran más nodos de los necesarios.

 */

	public Alumno getElementoMasCercano(int clave) {

		return getElementoMasCercano(this.raiz, clave);

	}

	private Alumno getElementoMasCercano(NodoArbol nodo, int clave) {
		Alumno res = null;
		if (nodo != null) {
			int distanciaClaves = nodo.getDato().getMatricula() - clave;
			if (distanciaClaves < 0) {
				res = getElementoMasCercano(nodo.getDerecho(), clave);
			} else if (distanciaClaves > 0) {
				res = getElementoMasCercano(nodo.getIzquierdo(), clave);
			} else {
				res = nodo.getDato();
			}
			
			if (res == null || Math.abs(distanciaClaves) < Math.abs(res.getMatricula() - clave)) {
				res = nodo.getDato();
			}
		}
		return res;
	}

}






