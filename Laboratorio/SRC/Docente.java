public class Docente extends Persona {
    // Atributo propio del docente
    private String dependencia;
    // Constructor
    public Docente(String documento, String nombre, String dependencia) {
        super(documento, nombre);
        this.dependencia = dependencia;
    }
    // Método para obtener la dependencia
    public String getDependencia() {
        return dependencia;
    }
    // Método para establecer los días máximos de préstamo
    @Override
    public int getDiasMaximosPrestamo() {
        return 10;
    }

    // Método para establecer el máximo de equipos permitidos
    @Override
    public int getMaximoEquipos() {
        return 3;
    }
}