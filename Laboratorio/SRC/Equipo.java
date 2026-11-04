public abstract class Equipo {
    private String codigo;
    private String marca;
    private boolean disponible;

    public Equipo(String codigo, String marca) {
        this.codigo = codigo;
        this.marca = marca;
        this.disponible = true; // Todo equipo inicia disponible
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMarca() {
        return marca;
    }

    public boolean isDisponible() {
        return disponible;
    }

    // El estado de disponibilidad solo cambia cuando el sistema presta o recibe el equipo
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    // Método abstracto para polimorfismo de tarifas de multas (Sección 3 y 6)
    public abstract double getMultaPorDia();
}