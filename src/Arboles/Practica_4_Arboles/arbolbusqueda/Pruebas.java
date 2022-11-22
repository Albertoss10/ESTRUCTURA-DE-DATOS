package Arboles.Practica_4_Arboles.arbolbusqueda;

public class Pruebas {

	// Pruebas ------------------------------------------------------------
	public static void main(String[] args) {
		System.out.println("-------------- Arbol binario de busqueda ------------");

		Alumno alumno1 = new Alumno("Felipe Garcia",1253,5.3);
		Alumno alumno2 = new Alumno("Adriana Torres",2345,7.0);
		Alumno alumno3 = new Alumno("Alicia Blazquez Martín",5622,10.0);
		Alumno alumno4 = new Alumno("Diego Perez Gonzalez",8135,8.0);
		Alumno alumno5 = new Alumno("Mar Hernando Lopez",8217,6.3);
		Alumno alumno6 = new Alumno("Pedro Jimenez del Pozo",8510,3.0);
		Alumno alumno7 = new Alumno("Eduardo Parra Martín",8765,6.7);

		ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();
		arbol.insertar(alumno3);
		arbol.insertar(alumno6);
		arbol.insertar(alumno2);
		arbol.insertar(alumno1);
		arbol.insertar(alumno7);
		arbol.insertar(alumno4);
		arbol.insertar(alumno5);

		ListaOrdinalAlumnos alumnos = arbol.aLista();
		alumnos.mostrar();

		System.out.println("---------------------------------------------");
		System.out.print("El alumno con la calificación máxima cuya matrícula esta comprendida entre 5000 y 8500 es: ");
		if(arbol.getCalificacionMaxima(5000,8500) != null){
			arbol.getCalificacionMaxima(5000,8500).mostrar();
		} else {
			System.out.println("null");
		}
		System.out.println("La calificación media de los alumnos cuya matrícula esta comprendida entre 5000 y 8500 es: " + arbol.getCalificacionMedia(5000,8500));


		System.out.println("---------------------------------------------");
		System.out.print("El alumno con la calificación máxima cuya matrícula esta comprendida entre 500 y 100 es: ");
		if(arbol.getCalificacionMaxima(500,1000) != null){
			arbol.getCalificacionMaxima(500,1000).mostrar();
		} else {
			System.out.println("null");
		}
		System.out.println("La calificación media de los alumnos cuya matrícula esta comprendida entre 5000 y 8500 es: " + arbol.getCalificacionMedia(500,1000));

		System.out.println("\n¿El árbol es equilibrado? " + arbol.esEquilibrado() + "\n");
		arbol.borrar(1253);
		System.out.println("Se ha borrado al alumno con matrícula 1253. Nueva lista de alumnos:");
		ListaOrdinalAlumnos listaNueva = arbol.aLista();
		listaNueva.mostrar();
		System.out.println("\n¿El árbol es equilibrado? " + arbol.esEquilibrado());
	}
}
