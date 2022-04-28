package Practica_3_Listas;

public class ListaOrdinal {

	private NodoListaOrdinal inicio, fin;
	private int numElementos;

	public ListaOrdinal() {
		inicio = null;
		fin = null;
		numElementos = 0;
	}

	public boolean vacia() {
		return inicio == null;
	}

	/**
	 * Inserta el dato en la última posición de la lista
	 */
	public void insertar(Evaluacion dato) {
		NodoListaOrdinal nuevo = new NodoListaOrdinal(dato, null);
		if (this.vacia()) {
			inicio = nuevo;
		} else {
			fin.setSiguiente(nuevo);
		}
		fin = nuevo;
		numElementos++;
	}


	/**
	 * Busca el dato que ocupa la posición recibida como parámetro,
	 * en caso de existir.
	 */
	public Evaluacion getElemento(int posicion) {
		NodoListaOrdinal actual;
		if ((posicion > numElementos - 1) || (posicion < 0)) {
			System.out.println("No existe la posición " + posicion);
			return null;
		} else {
			actual = inicio;
			for (int i = 0; i < posicion; i++) {
				actual = actual.getSiguiente();
			}
			return actual.getDato();
		}
	}

	/**
	 * Borra el primer elemento de la lista cuyo dato coincide con el
	 * parámetro recibido.
	 */
	public void borrar(Evaluacion dato) {
		NodoListaOrdinal actual = inicio;
		NodoListaOrdinal anterior = null;
		boolean borrado = false;
		while (actual != null && !borrado) {
			if (actual.getDato() == dato) {  // Borrar actual
				if (actual != inicio) {
					anterior.setSiguiente(actual.getSiguiente());
				} else {
					inicio = actual.getSiguiente();
				}
				if (actual == fin) {  // se borra el último
					fin = anterior;
				}
				numElementos--;
				borrado = true;
			} else {
				anterior = actual;
				actual = actual.getSiguiente();
			}
		}
	}

	/**
	 * Devuelve la primera posición en la que se encuentra el dato,
	 * en caso de existir. En caso contrario, devuelve -1
	 */

	public int posicion(Evaluacion dato) {
		NodoListaOrdinal actual = inicio;
		int pos = 0;
		while (actual != null && actual.getDato() != dato) {
			actual = actual.getSiguiente();
			pos++;
		}
		if (actual != null) {
			return pos;
		} else {
			return -1;
		}
	}

	/**
	 * Determina si el dato recibido como parámetro existe en la lista.
	 */
	public boolean contiene(Evaluacion dato) {
		return this.posicion(dato) >= 0;
	}
	public int getNumElementos() {
		return numElementos;
	}
	public IteradorListaOrdinal getIterador() {
		return new IteradorListaOrdinal(inicio);
	}
	public int numConvocatorias(String nombreAsignatura) {
		NodoListaOrdinal actual = inicio;
		int contadorConvocatorias = 0;

		while(actual != null){
			if(actual.getDato().getNombreAsignatura().equals(nombreAsignatura) && actual.getDato().getNota() >= 0.0){
				contadorConvocatorias++;
			}
			actual = actual.getSiguiente();
		}

		return contadorConvocatorias;
	}
}
