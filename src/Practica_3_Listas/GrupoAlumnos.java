package Practica_3_Listas;

public class GrupoAlumnos {

	private String nombre;
	private ListaCalificada listaAlumnos;

	public GrupoAlumnos(String nombre) {
		this.nombre = nombre;
		listaAlumnos = new ListaCalificada();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void nuevoAlumno(Alumno alumno) {
		if(alumno != null){
			listaAlumnos.insertar(alumno);
		}
	}

	public int getNumAlumnos() {
		return listaAlumnos.getNumElementos();
	}

	public Alumno getAlumno(int matricula) {
		Alumno alumno = null;

		if(listaAlumnos.contiene(matricula)){
			alumno = listaAlumnos.getElemento(matricula);
		}

		return alumno;
	}

	public double porcentajeAprobados(String nombreAsignatura) {
		IteradorListaCalificada it = listaAlumnos.getIterador();
		int totalAlumnos = listaAlumnos.getNumElementos();
		int aprobados = 0;
		double porcentaje = 0.0;
		while(it.hasNext()){
			if(it.next().estaAprobado(nombreAsignatura)){
				aprobados++;
			}
		}

		if(aprobados != 0){
			porcentaje = (aprobados * 100.0) / totalAlumnos;
		}

		return porcentaje;
	}
}