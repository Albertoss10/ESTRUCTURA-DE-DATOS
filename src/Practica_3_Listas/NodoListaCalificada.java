package Practica_3_Listas;

public class NodoListaCalificada {

	private Alumno dato;
	private NodoListaCalificada siguiente;

	public NodoListaCalificada(Alumno dato, NodoListaCalificada siguiente) {
		this.dato = dato;
		this.siguiente = siguiente;
	}

	public NodoListaCalificada getSiguiente() {
		return siguiente;
	}

	public void setSiguiente(NodoListaCalificada siguiente) {
		this.siguiente = siguiente;
	}

	public Alumno getDato() {
		return dato;
	}

	public void setDato(Alumno dato) {
		this.dato = dato;
	}

	public int getClave() {
		return dato.getMatricula();
	}
}
