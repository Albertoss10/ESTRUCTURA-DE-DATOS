package Practica_2_PilasColas;

public class NodoCola {
    private Alumno dato;
    private NodoCola siguiente;

    public NodoCola(Alumno dato, NodoCola sig) {
        this.dato = dato;
        this.siguiente = sig;
    }

    public NodoCola getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoCola siguiente) {
        this.siguiente = siguiente;
    }
    public Alumno getDato() {
        return dato;
    }
    public void setDato(Alumno dato) {
        this.dato = dato;
    }
}
