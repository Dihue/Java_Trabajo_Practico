public class Estudiante extends Persona{

    Estudiante(String nombre, String apellido, int legajo) {
        super(nombre, apellido, legajo);

    }

    @Override
    public String toString() {
        return " | " + apellido + ", " + nombre +
                " - Legajo: " + legajo + " | ";
    }
}
