public class ReglaMultaEstandar implements ReglaMulta {
    @Override
    public double calcularMulta(Prestamo prestamo) {
        // Multiplica la multa por día de los equipos por los días de retraso
        return prestamo.calcularDiasRetraso() * prestamo.obtenerMultaDiariaTotal();
    }
}