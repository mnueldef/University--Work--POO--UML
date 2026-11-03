public class Cargador {
    // Atributos privados
    private String serial;
    private int vatios;
    // Constructor
    public Cargador(String serial, int vatios) {
        this.serial = serial;
        this.vatios = vatios;
    }
    // Método para obtener el serial
    public String getSerial() {
        return serial;
    }
    // Método para obtener los vatios
    public int getVatios() {
        return vatios;
    }
}