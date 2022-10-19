import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Facultad implements iInformacion {
    // Atributos
    private String nombre;
    private LinkedList<Carrera> carreras;

    // Métodos propios
    public void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public void eliminarCarrera(String nombreCarrera){
        Iterator<Carrera> iterador = carreras.iterator();
        while (iterador.hasNext()) {
            String carreraEliminar = iterador.next().getNombre();
            if (carreraEliminar.equalsIgnoreCase(nombreCarrera)) {
                iterador.remove();
                System.out.println(nombreCarrera.toUpperCase() + " fue eliminada");
            }
        }
    }

    public void eliminarEstudianteFacultad(int estudianteParaEliminar){
        for (Carrera carrera: carreras) {
            for (Materia materia: carrera.getMaterias()) {
                for (Estudiante estudiante: materia.getEstudiantes()) {
                    if (estudiante.getLegajo() == estudianteParaEliminar) {
                        materia.eliminarEstudiante(estudiante.getNombre());
                    }
                }
            }
        }
    }

    // Constructores
    public Facultad(String nombre) {
        this.nombre = nombre;
        this.carreras = new LinkedList<>();
    }

    public Facultad(String nombre, LinkedList<Carrera> carreras) {
        this.nombre = nombre;
        this.carreras = carreras;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Carrera> getCarreras() {
        return carreras;
    }
    public void setCarreras(LinkedList<Carrera> carreras) {
        this.carreras = carreras;
    }

    // Salida para todos los datos
    @Override
    public String toString() {
        return "Facultad: " + nombre + "\n" +
            "|-> Carreras: " + carreras;
    }

    // Métodos de la Interfaz
    @Override
    public int verCantidad() {
        return carreras.size();
    }

    @Override
    public String listarContenido() {
        String [] contenido = new String[verCantidad()];
        for (int i = 0; i < verCantidad(); i++) {
            contenido[i] = carreras.get(i).getNombre();
        }
        Arrays.sort(contenido);
        return Arrays.toString(contenido);
    }
}
