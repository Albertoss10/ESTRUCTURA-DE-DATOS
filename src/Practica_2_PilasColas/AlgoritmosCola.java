package Practica_2_PilasColas;

public class AlgoritmosCola {

    public void mostrarGrupo(Cola grupo) {
        if(!grupo.vacia()){
            System.out.println("El grupo contiene " + grupo.getNumElementos() + " alumnos");

            for (int x = 0; x < grupo.getNumElementos(); x++) {
                Alumno alumno = grupo.desencolar();
                System.out.printf("%s. %s\n", (x + 1), alumno.getNombre());
                grupo.encolar(alumno);
            }
        } else {
            System.out.println("La cola esta vacía");
        }
    }

    public Cola alumnosAprobados(Cola grupo) {
        Cola aprobados = new Cola();

        if( grupo != null){
            for (int x = 0; x < grupo.getNumElementos(); x++) {
                Alumno alumno = grupo.desencolar();
                if (alumno.getCalificacionMedia() >= 5) {
                    aprobados.encolar(alumno);
                }
                grupo.encolar(alumno);
            }
            aprobados.mostrar();
        }

        return aprobados;
    }

    public double calificaciónMedia(Cola grupo) {
        double resultado = 0;

        if(grupo != null){
            for (int x = 0; x < grupo.getNumElementos(); x++) {
                Alumno alumno = grupo.desencolar();
                resultado += alumno.getCalificacionMedia();
                grupo.encolar(alumno);
            }
            resultado /= grupo.getNumElementos();
        }

        return resultado;
    }
}
