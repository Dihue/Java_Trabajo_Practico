import java.util.Arrays;
import java.util.List;

public class Materia implements iInformacion {
	// Atributos
	private String nombre;
	private Profesor titular;
	private final List<Estudiante> estudiantes;

	// Métodos propios
	public void agregarEstudiante(Estudiante estudiante) {
		estudiantes.add(estudiante);
	}

	public void eliminarEstudiante(String nombre) {
		estudiantes.removeIf(estudiante -> estudiante.getNombre().equals(nombre));
	}

	public void modificarTitular(Profesor profesor) {
		setTitular(profesor);
	}

	// Constructor
	public Materia(String nombre, Profesor titular, List<Estudiante> estudiantes) {
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

	public List<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	// Salida para todos los datos
	@Override
	public String toString() {
		return "\n\t|--> " + nombre + "\n" +
			"\t\tTitular: "  + titular + "\n" +
			"\t\tEstudiantes: " + estudiantes;
	}

	// Métodos de la Interface
	@Override
	public int verCantidad() {
		return estudiantes.size();
	}

	@Override
	public String listarContenido() {
		String[] arregloContenido = new String[estudiantes.size()];
		for (int i = 0; i < estudiantes.size(); i++) {
			arregloContenido[i] = estudiantes.get(i).getNombre() + " " + estudiantes.get(i).getApellido();
		}
		return Arrays.toString(arregloContenido);
	}
}
