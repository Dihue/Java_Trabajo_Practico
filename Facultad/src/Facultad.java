import java.util.List;

public class Facultad implements iInformacion {
    // Atributos
    private String nombre;
    private List<Carrera> carreras;

    // Métodos propios
    public void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public void eliminarCarrera(String nombreCarrera){
        for (Carrera carrera : carreras){
            if (carrera.getNombre().equals(nombreCarrera)){
                carreras.remove(carrera);
            }
        }
    }

    public void eliminarEstudiante(Estudiante estudianteParaEliminar){
        for (Carrera carrera: carreras) {
            for (Materia materia: carrera.getMaterias()) {
                for (Estudiante estudiante: materia.getEstudiantes()) {
                    if (estudiante == estudianteParaEliminar) {
                        materia.eliminarEstudiante(estudiante.getNombre());
                    }
                }
            }
        }
    }

    // Constructor
    public Facultad(String nombre, List<Carrera> carreras) {
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

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }

    // Salida para todos los datos
    @Override
    public String toString() {
        return "Facultad: " + nombre + "\n" +
            "\tCarreras: " + carreras;
    }

    // Métodos de la Interface
    @Override
    public int verCantidad() {
        return 0;
    }

    @Override
    public String listarContenido() {
        return null;
    }
}
