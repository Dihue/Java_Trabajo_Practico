import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Carrera implements iInformacion {
	// Atributos
	private String nombre;
	private LinkedList<Materia> materias;

	// Métodos propios
	public void agregarMateria(Materia materia) {
		materias.add(materia);
	}

	public void eliminarMateria(String nombreMateria) {
		Iterator<Materia> iterador = materias.iterator();
		while (iterador.hasNext()) {
			String materiaEliminar = iterador.next().getNombre();
			if (materiaEliminar.equalsIgnoreCase(nombreMateria)) {
				iterador.remove();
				System.out.println(nombreMateria.toUpperCase() + " fue eliminada");
			}
		}
	}

	public void encontrarMateria(String nombreMateria) {
		for (Materia materia: materias) {
			if (materia.getNombre().equalsIgnoreCase(nombreMateria)) {
				System.out.println("Materia encontrada\n");
			}
		}
	}

	// Constructor
	public Carrera(String nombre) {
		this.nombre = nombre;
		this.materias = new LinkedList<>();
	}

	public Carrera(String nombre, LinkedList<Materia> materias) {
		this.nombre = nombre;
		this.materias = materias;
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LinkedList<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(LinkedList<Materia> materias) {
		this.materias = materias;
	}


	// Salida para todos los datos
	@Override
	public String toString() {
		return "\n\t|-> " + nombre + "\n" +
			"\t\tMaterias: "  + materias;
	}

	// Métodos de la Interface
	@Override
	public int verCantidad() {
		return materias.size();
	}

	@Override
	public String listarContenido() {
		String [] contenido = new String[verCantidad()];
		for (int i = 0; i < verCantidad(); i++) {
			contenido[i] = materias.get(i).getNombre();
		}
		Arrays.sort(contenido);
		return Arrays.toString(contenido);
	}
}
