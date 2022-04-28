package Practica_3_Listas;

public class Pruebas {

    public static void main(String[] args) {
        System.out.println("********** PRUEBAS **********");

        ListaOrdinal lista1 = new ListaOrdinal();
        Evaluacion ed1 = new Evaluacion("ED", "Junio 19", 4.5);
        Evaluacion ed2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion ed3 = new Evaluacion("ED", "Junio 20", 7.4);
        Evaluacion algebra = new Evaluacion("Algebra", "Junio 18", 6.4);

        lista1.insertar(ed1);
        lista1.insertar(ed2);
        lista1.insertar(ed3);
        lista1.insertar(algebra);

        IteradorListaOrdinal it = lista1.getIterador();
        while (it.hasNext()) {
            it.next().mostrar();
        }

        System.out.println("--------------------------------");
        System.out.println("Convocatorias en ED: " + lista1.numConvocatorias("ED"));
        System.out.println("Convocatorias en Algebra: " + lista1.numConvocatorias("Algebra"));
        System.out.println("Convocatorias en Fundamentos de Programación: " + lista1.numConvocatorias("Fundamentos de Programación"));

        Alumno alumno1 = new Alumno("Felipe García Gómez", 1253);
        Alumno alumno2 = new Alumno("Alicia Blázquez Martín", 5622);
        alumno1.nuevaEvaluacion(ed1);
        alumno1.nuevaEvaluacion(ed2);
        alumno1.nuevaEvaluacion(ed3);
        alumno1.nuevaEvaluacion(algebra);

        System.out.println("\n------------Asignaturas aprobadas por " + alumno1.getNombre() + " ------------");
        IteradorListaOrdinal italum1 = alumno1.asignaturasAprobadas().getIterador();
        while (italum1.hasNext()) {
            italum1.next().mostrar();
        }


        System.out.println("\n------------Asignaturas aprobadas por " + alumno2.getNombre() + " ------------");
        IteradorListaOrdinal italum2 = alumno2.asignaturasAprobadas().getIterador();
        while (italum2.hasNext()) {
            italum2.next().mostrar();
        }


        System.out.println("\n------------ MOSTRAR LOS ALUMNOS ------------");
        alumno1.mostrar();
        alumno2.mostrar();


        //Hecho con LinkedList<>
        AlumnoBib alumnoBib1 = new AlumnoBib("Eduardo Parra Martín", 8765);
        AlumnoBib alumnoBib2 = new AlumnoBib("Sonia Torres Pardo", 2345);
        alumnoBib1.nuevaEvaluacion(ed1);
        alumnoBib1.nuevaEvaluacion(ed2);
        alumnoBib1.nuevaEvaluacion(ed3);
        alumnoBib1.nuevaEvaluacion(algebra);

        System.out.println("\n------------ MOSTRAR LOS ALUMNOS BIBLIOTECA ------------");
        alumnoBib1.mostrar();
        alumnoBib2.mostrar();


        //Hecho con Lista Calificadas
        Alumno alumno3 = new Alumno("Pedro Jimenez del Pozo", 8510);
        Evaluacion fp = new Evaluacion("Fundamentos de Programación", "Enero 19", 8.8);
        alumno3.nuevaEvaluacion(fp);

        ListaCalificada lista2 = new ListaCalificada();
        lista2.insertar(alumno3);
        lista2.insertar(alumno1);
        lista2.insertar(alumno2);
        IteradorListaCalificada itcalif = lista2.getIterador();

        System.out.println("\n------------ ALUMNOS EN LA LISTA ------------");
        while (itcalif.hasNext()) {
            itcalif.next().mostrar();
        }


        lista2.borrarMenores(6000);
        IteradorListaCalificada itMenores = lista2.getIterador();
        System.out.println("\n------------ Borramos las claves menores a 6000 ------------");
        while (itMenores.hasNext()) {
            itMenores.next().mostrar();
        }


        lista2.borrarMenores(9000);
        IteradorListaCalificada itMayores = lista2.getIterador();
        System.out.println("\n------------ Borramos las claves menores a 9000 ------------");
        while (itMayores.hasNext()) {
            itMayores.next().mostrar();
        }

        lista2.insertar(alumno3);
        lista2.insertar(alumno1);
        lista2.insertar(alumno2);
        lista2.borrarMayores(7000);
        IteradorListaCalificada itCalificada = lista2.getIterador();

        System.out.println("\n------ Metemos todos los alumnos y borramos las claves mayores a 7000 ------");
        while (itCalificada.hasNext()) {
            itCalificada.next().mostrar();
        }

        GrupoAlumnos grupo1 = new GrupoAlumnos("GX11");

        grupo1.nuevoAlumno(alumno1);
        grupo1.nuevoAlumno(alumno2);
        grupo1.nuevoAlumno(alumno3);

        System.out.println("\n------------ CREADO EL GRUPO GX11 ------------");
        System.out.println("El grupo " + grupo1.getNombre() + " tiene " + grupo1.getNumAlumnos() + " alumnos");
        System.out.println("------------ Grupo GX11. Alumno con matrícula 8510 ------------");

        if(grupo1.getAlumno(8510) != null){
            grupo1.getAlumno(8510).mostrar();
        }else{
            System.out.println("No existe ningún alumno con esa matrícula.");
            System.out.println("----------------------------------------");
        }

        System.out.println("Porcentaje de aprobados en ED del grupo GX11: " + grupo1.porcentajeAprobados("ED"));
    }
}