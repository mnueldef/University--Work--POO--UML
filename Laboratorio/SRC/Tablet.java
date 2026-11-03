public class Tablet extends Equipo {

    // Constructor


    public Tablet(String codigo, String marca) {


        super(codigo, marca);


    }

    // Método para obtener la multa diaria


    @Override


    public double getMultaPorDia() {


        return 8000;


    }


}