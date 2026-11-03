public class Estudiante extends Persona {
    // atributo propio del estudiante
    private String programaAcademico;
    // Constructor
    public Estudiante(String documento, String nombre, String programaAcademico) {
        super(documento, nombre);
        this.programaAcademico = programaAcademico;
    }

    // Método para obtener el programa académico

    public String getProgramaAcademico() {
        return programaAcademico;


    }

    // Método para establecer los días máximos de préstamo

    @Override


    public int getDiasMaximosPrestamo() {
        return 3;
    }
    // Método para establecer el máximo de equipos permitidos
    @Override
    public int getMaximoEquipos() {
        return 1;


    }
}