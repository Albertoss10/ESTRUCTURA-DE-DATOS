package Practica_2_PilasColas;

public class Alumno {

    private String nombre;
    private String matricula;
    private double calificacionMedia;
    private int numAsignaturas;
    Pila asignaturas;

    public Alumno(String nombre, String matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.calificacionMedia = 0;
        this.numAsignaturas = 0;
        this.asignaturas = new Pila();
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getCalificacionMedia() {
        return calificacionMedia;
    }
    public int getNumAsignaturas() {
        return numAsignaturas;
    }

    public void anadirAsignatura(Asignatura asignatura) {
        if(asignatura != null){
            this.asignaturas.apilar(asignatura);
            this.numAsignaturas++;
            this.calificacionMedia = ((calificacionMedia * (numAsignaturas - 1)) + asignatura.getCalificacion()) / numAsignaturas;
        }
    }

    public void mostrarAlumno() {
        if (numAsignaturas == 0) {
            System.out.println("No está matriculado en ninguna asignatura.");
        } else {
            System.out.println(nombre + ". Matr: " + matricula + " (" + calificacionMedia + ")");
            asignaturas.mostrar();
        }
    }
}
