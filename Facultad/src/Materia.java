import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Materia implements iInformacion {
	// Atributos
	private String nombre;
	private Profesor titular;
	private LinkedList<Estudiante> estudiantes;

	// Métodos propios
	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}

	public void eliminarEstudiante(String nombreEstudiante) {
		Iterator<Estudiante> iterador = estudiantes.iterator();
		while (iterador.hasNext()) {
			String estudianteEliminar = iterador.next().getNombre();
			if (estudianteEliminar.equalsIgnoreCase(nombreEstudiante)) {
				iterador.remove();
				System.out.println(nombreEstudiante.toUpperCase() + " fue eliminado");
			}
		}
	}

	public void modificarTitular(Profesor profesor) {
		setTitular(profesor);
	}

	// Constructor
	public Materia(String nombre) {
		this.nombre = nombre;
		this.estudiantes = new LinkedList<>();
	}

	public Materia(String nombre, Profesor titular, LinkedList<Estudiante> estudiantes) {
		this.nombre = nombre;
		this.titular = titular;
		this.estudiantes = estudiantes;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Profesor getTitular() {
		return titular;
	}

	public void setTitular(Profesor titular) {
		this.titular = titular;
	}

	public LinkedList<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	// Salida para todos los datos
	@Override
	public String toString() {
		return "\n\t\t|-> " + nombre + "\n" +
			"\t\t\tTitular: "  + titular + "\n" +
			"\t\t\tEstudiantes: " + estudiantes;
	}

	// Métodos de la Interface
	@Override
	public int verCantidad() {
		return estudiantes.size();
	}

	@Override
	public String listarContenido() {
		String[] contenido = new String[estudiantes.size()];
		for (int i = 0; i < estudiantes.size(); i++) {
			contenido[i] = estudiantes.get(i).getApellido() + " " + estudiantes.get(i).getNombre();
		}
		Arrays.sort(contenido);
		return Arrays.toString(contenido);
	}
}