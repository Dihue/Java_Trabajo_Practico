import java.util.List;

public class Facultad {
    String nombre;
    List<Carrera> carreras;

    public void agregarCarrera(Carrera carrera){
        carreras.add(carrera);
    }

    public void eliminarCarrera(String nombreCarrera){
        for (Carrera carrera:carreras){
            if (carrera.getNombre().equals(nombreCarrera)){
                carreras.remove(carrera);
            }
        }
    }

    public void eliminarEstudiante(String nombreEstudiante){
        for{

        }
    }


}
