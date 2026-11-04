public class Estudiante extends Persona {
    private String programaAcademico;

    public Estudiante(String documento, String nombre, String programaAcademico) {
        super(documento, nombre);
        this.programaAcademico = programaAcademico;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public int getDiasMaximosPrestamo() {
        return 3; // Máximo 3 días de préstamo para estudiantes
    }

    @Override
    public int getEquiposMaximos() {
        return 1; // Máximo 1 equipo a la vez
    }
}