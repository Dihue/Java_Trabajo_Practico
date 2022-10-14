public class Profesor extends Persona{
    // Atributos
    private double basico;
    private int antiguedad;

    // Constructor
    public Profesor(String nombre, String apellido, int legajo, double basico, int antiguedad) {
        super(nombre, apellido, legajo);
        this.basico = basico;
        this.antiguedad = antiguedad;
    }

    // Getters y Setters
    public double getBasico() {
        return basico;
    }

    public void setBasico(double basico) {
        this.basico = basico;
    }


    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
@Override
    public String toString(){
        return " | " + apellido + ", " + nombre +
            " - Nro Legajo: "+ legajo + "\n" +
            "Sueldo básico: "+basico + "\n" +
            "Años de antigüedad: "+ antiguedad;
    }

    public double calcularSueldo(double basico){
        double sueldo = basico + antiguedad * (basico * 10) / 100;
        return sueldo;
    }

}
