public abstract class Equipo {
    // Atributos privados
    private String codigo;
    private String marca;
    private boolean disponible;
    // Constructor
    public Equipo(String codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
        this.disponible = true;

    }

    // Método para obtener el código

    public String getCodigo() {
        return codigo;
    }

    // Método para obtener la marca

    public String getMarca() {
        return marca;
    }
    // Método para consultar la disponibilidad
    public boolean isDisponible() {

        return disponible;

    }
    // Método para cambiar el estado del equipo
    // Solo puede utilizarse desde clases del mismo paquete
    void cambiarDisponibilidad(boolean disponible) {
        this.disponible = disponible;
    }

    // Método abstracto para conocer la multa diaria
    public abstract double getMultaPorDia();


}