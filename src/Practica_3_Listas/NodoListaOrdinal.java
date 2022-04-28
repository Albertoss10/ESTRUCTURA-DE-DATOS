package Practica_3_Listas;

public class NodoListaOrdinal {

	private Evaluacion dato;
	private NodoListaOrdinal siguiente;

	public NodoListaOrdinal(Evaluacion dato, NodoListaOrdinal siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public NodoListaOrdinal getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaOrdinal siguiente) {
		this.siguiente = siguiente;
	}

	public Evaluacion getDato() {
		return dato;
	}

	public void setDato(Evaluacion dato) {
		this.dato = dato;
	}
}
