package Practica_3_Listas;

import java.util.LinkedList;
import java.util.Iterator;

public class AlumnoBib {
    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;

    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<>();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevaEvaluacion(Evaluacion evaluacion) {
        expediente.add(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterator<Evaluacion> it = expediente.iterator();

        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public LinkedList<Evaluacion> asignaturasAprobadas() {
        LinkedList<Evaluacion> aprobadas = new LinkedList<>();
        Iterator<Evaluacion> it = expediente.iterator();
        if(!expediente.isEmpty()){
            while(it.hasNext()){
                Evaluacion evaluacion = it.next();
                if(evaluacion.getNota() >= 5){
                    aprobadas.add(evaluacion);
                }
            }
        }

        return aprobadas;
    }

    public double mediaAprobadas() {
        LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();
        Iterator<Evaluacion> it = aprobadas.iterator();
        double notaMedia = 0.0;

        if(!aprobadas.isEmpty()){
            while(it.hasNext()){
                Evaluacion evaluacion = it.next();
                notaMedia += evaluacion.getNota();
            }
            notaMedia /= aprobadas.size();
        }

        return notaMedia;
    }

    public int getNumAprobadas() {
        return asignaturasAprobadas().size();
    }

    public void mostrar() {
        LinkedList<Evaluacion> aprobadas = asignaturasAprobadas();
        Iterator<Evaluacion> it = expediente.iterator();
        int numEvaluaciones = expediente.size();
        int numAsigAprobadas = getNumAprobadas();
        double mediaAsigAprobadas = mediaAprobadas();

        System.out.printf("%s. Matricula: %d\n",nombre,matricula);
        if(!expediente.isEmpty()){
            while (it.hasNext()){
                System.out.print("\t");
                it.next().mostrar();
            }
            System.out.println(numEvaluaciones + " evaluaciones y " + numAsigAprobadas + " aprobadas con calificación media " + mediaAsigAprobadas);
        } else {
            System.out.println("No ha realizado ninguna evaluación.");
        }
    }
}
