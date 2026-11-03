public class Portatil extends Equipo {
    // Atributos propios del portátil
    private int memoriaRAM;
    private Cargador cargador;
    // Constructor
    public Portatil(String codigo, String marca, int memoriaRAM,
                    String serialCargador, int vatiosCargador) {
        super(codigo, marca);
        this.memoriaRAM = memoriaRAM;
        // El cargador se crea junto con el portátil
        this.cargador = new Cargador(serialCargador, vatiosCargador);


    }
    // Método para obtener la memoria RAM

    public int getMemoriaRAM() {
        return memoriaRAM;


    }
    // Método para obtener el cargador
    public Cargador getCargador() {
        return cargador;
    }
  
    // Método para obtener la multa diaria
    @Override
    public double getMultaPorDia() {
        return 15000;
    }
}