public abstract class Persona {
    // Atributos
    String nombre;
    String apellido;
    int legajo;

    // Constructor
    Persona(String nombre, String apellido, int legajo){
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public void modificarDatos(String nombre, String apellido, int legajo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
    }

}
