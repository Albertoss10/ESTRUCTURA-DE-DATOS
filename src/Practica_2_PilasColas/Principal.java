package Practica_2_PilasColas;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Practica ED Pilas y Colas de: " + "------Alberto Saiz Serrano---------");
        System.out.println("Numero Matricula: " + "bs0128");
        Principal pruebas = new Principal();

        Pila asignaturas = pruebas.prepararPila();
        pruebas.pruebasPila(asignaturas);

        Cola grupo = pruebas.prepararCola();
        pruebas.pruebasCola(grupo);
    }

    public Pila prepararPila() {
        Pila asignaturas = new Pila();
        Asignatura ffi = new Asignatura("Fundamentos Físicos de la Informática", 3.50);
        Asignatura ed = new Asignatura("Estructuras de Datos", 6.35);
        Asignatura aes = new Asignatura("Aspectos Éticos y Sociales", 7.70);
        Asignatura fs = new Asignatura("Fundamentos de seguridad", 6.75);
        asignaturas.apilar(ffi);
        asignaturas.apilar(ed);
        asignaturas.apilar(aes);
        asignaturas.apilar(fs);

        return asignaturas;
    }

    public void pruebasPila(Pila asignaturas) {
        AlgoritmosPila algoritmoPila = new AlgoritmosPila();

        if (!asignaturas.vacia()) {
            asignaturas.mostrar();
            System.out.println("Calificación mínima: " + algoritmoPila.notaMínima(asignaturas));
            System.out.print("Asignatura con calificación máxima: \n\t");
            algoritmoPila.asignaturaNotaMáxima(asignaturas).mostrar();
            System.out.println("Asignaturas Aprobadas:");
            algoritmoPila.mostrarAprobadas(asignaturas);
            System.out.println("\n");
        } else {
            System.out.println("La pila esta vacía.");
        }
    }

    public Cola prepararCola() {
        Cola grupo = new Cola();
        Alumno a1 = new Alumno("Felipe Arias Gonzalez", "aa1253");
        Alumno a2 = new Alumno("Manuel Garcia Sacedón", "ax0074");
        Alumno a3 = new Alumno("Margarita Lopez Medina", "mj7726");
        Alumno a4 = new Alumno("Estela Sanchez Arellano", "bc2658");
        Asignatura ed = new Asignatura("Estructuras de Datos", 6.35);
        Asignatura fs = new Asignatura("Fundamentos de seguridad", 6.75);
        a1.anadirAsignatura(ed);
        ed = new Asignatura("Estructuras de Datos", 4.35);
        a2.anadirAsignatura(ed);
        ed = new Asignatura("Estructuras de Datos", 7.5);
        a3.anadirAsignatura(ed);
        ed = new Asignatura("Estructuras de Datos", 2.5);
        a4.anadirAsignatura(ed);
        Asignatura algebra = new Asignatura("Álgebra", 5);
        a4.anadirAsignatura(algebra);
        a4.anadirAsignatura(fs);
        grupo.encolar(a1);
        grupo.encolar(a2);
        grupo.encolar(a3);
        grupo.encolar(a4);

        return grupo;
    }

    public void pruebasCola(Cola grupo) {
        AlgoritmosCola algoritmoCola = new AlgoritmosCola();
        Cola aprobados;

        if (!grupo.vacia()) {
            algoritmoCola.mostrarGrupo(grupo);
            System.out.println("Calificación media del grupo: " + algoritmoCola.calificaciónMedia(grupo));
            System.out.println("\nAlumnos aprobados:");
            aprobados = algoritmoCola.alumnosAprobados(grupo);
            System.out.println("\nCalificación media de aprobados: " + algoritmoCola.calificaciónMedia(aprobados));
        } else {
            System.out.println("La cola esta vacía.");
        }
    }
}
