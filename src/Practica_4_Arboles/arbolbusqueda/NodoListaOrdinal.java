package Practica_4_Arboles.arbolbusqueda;

public class NodoListaOrdinal {

	private Alumno dato;
	private NodoListaOrdinal siguiente;

	public NodoListaOrdinal(Alumno dato, NodoListaOrdinal siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public NodoListaOrdinal getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaOrdinal siguiente) {
		this.siguiente = siguiente;
	}

	public Alumno getDato() {
		return dato;
	}

	public void setDato(Alumno dato) {
		this.dato = dato;
	}
}
