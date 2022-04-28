package Practica_2_PilasColas;

public class Pila {
    private NodoPila cima;
    private int numElementos;

    public Pila() {
        cima = null;
        numElementos = 0;
    }

    public boolean vacia() {
        return cima == null;
    }

    public void apilar(Asignatura dato) {
        NodoPila nuevo = new NodoPila(dato, cima);
        cima = nuevo;
        numElementos++;
    }

    public Asignatura desapilar() {
        Asignatura valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = null;
        } else {
            valor = cima.getDato();
            cima = cima.getSiguiente();
            numElementos--;
        }
        return valor;
    }

    public Asignatura getCima() {
        Asignatura valor;
        if (this.vacia()) {
            System.out.println("Error, la pila está vacía");
            valor = null;
        } else valor = cima.getDato();
        return valor;
    }

    public void quitarCima() {
        if (this.vacia())
            System.out.println("Error, la pila está vacía");
        else {
            cima = cima.getSiguiente();
            numElementos--;
        }
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void mostrar() {
        NodoPila auxiliar = cima;
        System.out.println("Asignaturas:");
        while (auxiliar != null) {
            System.out.print("\t");
            auxiliar.getDato().mostrar();
            auxiliar = auxiliar.getSiguiente();
        }
    }
}
