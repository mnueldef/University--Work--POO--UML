public class Proyector extends Equipo {
    // Atributo propio del proyector
    private int lumenes;

    // Constructor
    public Proyector(String codigo, String marca, int lumenes) {
        super(codigo, marca);
        this.lumenes = lumenes;


    }



    // Método para obtener los lúmene

    public int getLumenes() {
        return lumenes;
    }
    // Método para obtener la multa diaria


    @Override
    public double getMultaPorDia() {
        return 20000;
    }


}