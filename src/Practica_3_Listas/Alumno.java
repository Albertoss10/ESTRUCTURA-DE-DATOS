package Practica_3_Listas;

public class Alumno {

	private String nombre;
	private int matricula;
	private ListaOrdinal expediente;

	public Alumno(String nombre, int matricula) {
		this.nombre = nombre;
		this.matricula = matricula;
		expediente = new ListaOrdinal();
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
		expediente.insertar(evaluacion);
	}

	public boolean estaAprobado(String nombreAsig) {
		boolean aprobado = false;
		IteradorListaOrdinal it = expediente.getIterador();
		while (it.hasNext() && !aprobado) {
			Evaluacion evaluacion = it.next();
			if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
					evaluacion.getNota() >= 5.0) {
				aprobado = true;
			}
		}
		return aprobado;
	}

	public ListaOrdinal asignaturasAprobadas() {
		ListaOrdinal aprobadas = new ListaOrdinal();
		IteradorListaOrdinal it = expediente.getIterador();

		if(!expediente.vacia()){
			while(it.hasNext()){
				Evaluacion evaluacion = it.next();
				if(evaluacion.getNota() >= 5){
					aprobadas.insertar(evaluacion);
				}
			}
		}

		return aprobadas;
	}

	public double mediaAprobadas() {
		ListaOrdinal aprobadas = asignaturasAprobadas();
		IteradorListaOrdinal it = aprobadas.getIterador();
		double notaMedia = 0.0;

		if(!aprobadas.vacia()){
			while(it.hasNext()){
				Evaluacion evaluacion = it.next();
				notaMedia += evaluacion.getNota();
			}
			notaMedia /= aprobadas.getNumElementos();
		}

		return notaMedia;
	}

	public int getNumAprobadas() {
		return asignaturasAprobadas().getNumElementos();
	}

	public void mostrar() {
		int numEvaluaciones = expediente.getNumElementos();
		int numAsigAprobadas = getNumAprobadas();
		double mediaAsigAprobadas = mediaAprobadas();

		System.out.printf("%s. Matricula: %d\n",nombre,matricula);
		if(!expediente.vacia()){
			IteradorListaOrdinal it = expediente.getIterador();
			while (it.hasNext()){
				System.out.print("\t");
				it.next().mostrar();
			}
			System.out.println(numEvaluaciones + " evaluaciones y " + numAsigAprobadas + " asignaturas aprobadas con calificación media " + mediaAsigAprobadas);
		} else {
			System.out.println("No ha realizado ninguna evaluación.");
		}
		System.out.println("----------------------------------------");
	}
}


