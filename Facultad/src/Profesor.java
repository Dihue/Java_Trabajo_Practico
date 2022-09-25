public class Profesor extends Persona{
    double basico;
    int antiguedad;

    public Profesor(String nombre, String apellido, int legajo) {
        super(nombre, apellido, legajo);
    }

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
}
