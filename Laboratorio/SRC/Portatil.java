public class Portatil extends Equipo {
    private int memoriaRAM;
    private Cargador cargador; // Composición: El cargador se crea junto con el portátil

    public Portatil(String codigo, String marca, int memoriaRAM, String serialCargador, int vatiosCargador) {
        super(codigo, marca);
        this.memoriaRAM = memoriaRAM;
        // El cargador no existe por fuera del portátil (Composición)
        this.cargador = new Cargador(serialCargador, vatiosCargador);
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public Cargador getCargador() {
        return cargador;
    }

    @Override
    public double getMultaPorDia() {
        return 15000.0; // Multa por día para portátiles
    }
}