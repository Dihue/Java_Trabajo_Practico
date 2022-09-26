public class Estudiante extends Persona{

    Estudiante(String nombre, String apellido, int legajo) {
        super(nombre, apellido, legajo);

    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+"\n"+
                "Apellido: "+apellido+"\n"+
                "Nro Legajo: "+legajo;
    }
}
