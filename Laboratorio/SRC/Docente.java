public class Docente extends Persona {
    private String dependencia;

    public Docente(String documento, String nombre, String dependencia) {
        super(documento, nombre);
        this.dependencia = dependencia;
    }

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    @Override
    public int getDiasMaximosPrestamo() {
        return 10; // Máximo 10 días de préstamo para docentes
    }

    @Override
    public int getEquiposMaximos() {
        return 3; // Máximo 3 equipos a la vez
    }
}