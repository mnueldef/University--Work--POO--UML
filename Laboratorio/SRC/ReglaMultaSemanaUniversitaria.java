public class ReglaMultaSemanaUniversitaria implements ReglaMulta {
    @Override
    public double calcularMulta(Prestamo prestamo) {
        // En semana universitaria la multa es a la mitad
        return (prestamo.calcularDiasRetraso() * prestamo.obtenerMultaDiariaTotal()) / 2.0;
    }
}