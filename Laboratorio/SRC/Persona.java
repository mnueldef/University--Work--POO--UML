public abstract class Persona {
    private final String documento; // Inmutable, nunca cambia
    private String nombre;

    public Persona(String documento, String nombre) {
        if (documento == null || documento.trim().isEmpty()) {
            throw new IllegalArgumentException("El documento es obligatorio.");
        }
        this.documento = documento;
        this.nombre = nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Métodos abstractos para polimorfismo puro (Sección 2 y 6)
    public abstract int getDiasMaximosPrestamo();
    public abstract int getEquiposMaximos();
}