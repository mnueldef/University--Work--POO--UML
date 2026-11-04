import java.util.List;

public class ReporteInventario {

    public ReporteInventario() {
        // Constructor vacío explícito
    }

    public void imprimirInventario(List<Equipo> equipos) {
        System.out.println("\n========== REPORTE DE INVENTARIO ==========");
        for (Equipo equipo : equipos) {
            String estado = equipo.isDisponible() ? "DISPONIBLE" : "PRESTADO";
            System.out.println("- [" + estado + "] " + equipo.getMarca() + " (Código: " + equipo.getCodigo() + ")");
        }
        System.out.println("===========================================");
    }
}