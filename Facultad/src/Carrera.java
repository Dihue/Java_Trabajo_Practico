import java.util.List;

public class Carrera implements iInformacion {
	// Atributos
	private String nombre;
	private List<Materia> materias;

	// Métodos propios

	public void agregarMateria(Materia materia) {
		materias.add(materia);
	}

	public void eliminarMateria(String nombreMateria) {
		for (Materia materia: materias) {
			if (materia.getNombre().equals(nombreMateria)) {
				materias.remove(materia);
			}
		}
	}

	public void encontrarMateria(String nombreMateria) {
		for (Materia materia: materias) {
			if (materia.getNombre().equals(nombreMateria)) {
				System.out.println("Materia encontrada");
			}
		}
	}

	// Constructor
	public Carrera(String nombre, List<Materia> materias) {
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

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	// Salida para todos los datos
	@Override
	public String toString() {
		return "\n|--> " + nombre + "\n" +
			"\tMaterias: "  + materias;
	}

	// Métodos de la Interface
	@Override
	public int verCantidad() {
		return materias.size();
	}

	@Override
	public String listarContenido() {
		String contenido = "";
		for (int i = 0; i < materias.size(); i++) {
			contenido += materias.get(i).getNombre() + "\n";
		}
		return contenido;
	}
}
