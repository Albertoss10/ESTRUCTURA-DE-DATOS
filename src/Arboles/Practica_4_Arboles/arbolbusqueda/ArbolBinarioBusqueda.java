package Arboles.Practica_4_Arboles.arbolbusqueda;

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
		if (nodo == null) {    // No encontrado
			return null;
		} else if (clave == nodo.getClave()) {    // Encontrado
			return nodo.getDato();
		} else if (clave < nodo.getClave()) {     // Subárbol izquierdo
			return this.getElementoRec(nodo.getIzquierdo(), clave);
		} else {        // Subárbol izquierdo
			return this.getElementoRec(nodo.getDerecho(), clave);
		}
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
			nodo = null;
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

	// ------------------------------------------------------------------------
	// TODO 3.2
	public ListaOrdinalAlumnos aLista() {
		return aListaRec(raiz, new ListaOrdinalAlumnos());
	}
	private ListaOrdinalAlumnos aListaRec(NodoArbol nodo, ListaOrdinalAlumnos alumnos){

		if(nodo != null){
			aListaRec(nodo.getIzquierdo(), alumnos);
			alumnos.insertar(nodo.getDato());
			aListaRec(nodo.getDerecho(), alumnos);
		}

		return alumnos;
	}

	// ------------------------------------------------------------------------
	// TODO 3.3
	public Alumno getCalificacionMaxima(int minimaMat, int maximaMat) {
		return getCalificacionMaximaRec(raiz, null, minimaMat,maximaMat);
	}
	private Alumno getCalificacionMaximaRec(NodoArbol nodo, Alumno alumnoMax, int minimaMat, int maximaMat){
		if(nodo != null){
			if(nodo.getClave() >= minimaMat){
				alumnoMax = getCalificacionMaximaRec(nodo.getIzquierdo(), alumnoMax, minimaMat,maximaMat);
			}
			if(nodo.getClave() >= minimaMat && nodo.getClave() <= maximaMat){
				if(alumnoMax == null){
					alumnoMax = nodo.getDato();
				}else if(nodo.getDato().getCalificacion() > alumnoMax.getCalificacion()){
					alumnoMax = nodo.getDato();
				}
			}
			if(nodo.getClave() <= maximaMat){
				alumnoMax = getCalificacionMaximaRec(nodo.getDerecho(), alumnoMax, minimaMat,maximaMat);
			}
		}
		return alumnoMax;
	}

	// ------------------------------------------------------------------------
	// TODO 3.4
	public double getCalificacionMedia(int minimaMat, int maximaMat) {
		int numNodos = calcularNumNodos(raiz, 0, minimaMat, maximaMat);
		if(numNodos == 0){
			return 0.0;
		} else {
			return getCalificacionMediaRec(raiz, 0.0, minimaMat, maximaMat) / numNodos;
		}
	}
	private double getCalificacionMediaRec(NodoArbol nodo, double suma, int minimaMat, int maximaMat){
		if(nodo != null){
			if(nodo.getClave() >= minimaMat){
				suma = getCalificacionMediaRec(nodo.getIzquierdo(), suma, minimaMat,maximaMat);
			}
			if(nodo.getClave() >= minimaMat && nodo.getClave() <= maximaMat){
				suma += nodo.getDato().getCalificacion();
			}
			if(nodo.getClave() <= maximaMat){
				suma = getCalificacionMediaRec(nodo.getDerecho(), suma, minimaMat,maximaMat);
			}
		}
		return suma;
	}
	private int calcularNumNodos(NodoArbol nodo,int numNodos, int minimaMat, int maximaMat){
		if(nodo != null){
			if(nodo.getClave() >= minimaMat){
				numNodos = calcularNumNodos(nodo.getIzquierdo(),numNodos,minimaMat,maximaMat);
			}
			if(nodo.getClave() >= minimaMat && nodo.getClave() <= maximaMat){
				numNodos++;
			}
			if(nodo.getClave() <= maximaMat){
				numNodos = calcularNumNodos(nodo.getDerecho(),numNodos,minimaMat,maximaMat);
			}
		}

		return numNodos;
	}

	// ------------------------------------------------------------------------
	// TODO 3.5
	public boolean esEquilibrado() {
		return esEquilibradoRec(raiz);
	}
	private boolean esEquilibradoRec(NodoArbol nodo){
		int alturaIzq, alturaDer;

		if (nodo == null) {
			return true;
		}
		alturaIzq = altura(nodo.getIzquierdo());
		alturaDer = altura(nodo.getDerecho());

		if (Math.abs(alturaIzq - alturaDer) <= 1 && esEquilibradoRec(nodo.getIzquierdo()) && esEquilibradoRec(nodo.getDerecho())){
			return true;
		}

		return false;
	}
	private int altura(NodoArbol nodo) {
		if (nodo == null) {
			return 0;
		}
		return 1 + Math.max(altura(nodo.getIzquierdo()), altura(nodo.getDerecho()));
	}
}
