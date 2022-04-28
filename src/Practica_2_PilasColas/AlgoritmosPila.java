package Practica_2_PilasColas;

public class AlgoritmosPila {

    public Asignatura asignaturaNotaMáxima(Pila asignaturas) {
        Asignatura resultado = null;
        Asignatura aux;

        if (!asignaturas.vacia()) {
            aux = asignaturas.desapilar();
            if (asignaturas.getNumElementos() == 0) {
                resultado = aux;
            } else if (aux.getCalificacion() < asignaturaNotaMáxima(asignaturas).getCalificacion()) {
                resultado = asignaturaNotaMáxima(asignaturas);
            } else {
                resultado = aux;
            }
            asignaturas.apilar(aux);
        }
        return resultado;
    }

    public double notaMínima(Pila asignaturas) {
        double resultado = 0;
        Asignatura asignatura;

        if (!asignaturas.vacia()) {
            asignatura = asignaturas.desapilar();
            if (asignaturas.getNumElementos() == 0) {
                resultado = asignatura.getCalificacion();
            } else if (asignatura.getCalificacion() < notaMínima(asignaturas)) {
                resultado = asignatura.getCalificacion();
            } else {
                resultado = notaMínima(asignaturas);
            }
            asignaturas.apilar(asignatura);
        }
        return resultado;
    }


    public void mostrarAprobadas(Pila asignaturas) {
        Asignatura asignatura;

        if (!asignaturas.vacia()) {
            asignatura = asignaturas.desapilar();
            if (asignatura.getCalificacion() >= 5) {
                System.out.print("\t");
                asignatura.mostrar();
            }
            mostrarAprobadas(asignaturas);
            asignaturas.apilar(asignatura);
        }
    }
}
