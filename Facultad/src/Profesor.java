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
    
@Override
    public String toString(){
        return "Nombre: "+nombre+"\n"+
                "Apellido: "+apellido+"\n"+
                "Nro Legajo: "+legajo+"\n"+
                "Sueldo básico: "+basico+"\n"+
                "Anios de antiguedad: "+antiguedad;
    }

    public double calcularSueldo(double basico){
        double sueldo=basico+antiguedad*(basico*10)/100;
        return sueldo;
    }
}
