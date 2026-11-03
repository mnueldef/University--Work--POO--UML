import java.util.ArrayList;
// Clase que muestra el inventario
public class ReporteInventario {
    private ArrayList<Equipo> equipos;

    // Constructor
    public ReporteInventario(ArrayList<Equipo> equipos) {


        this.equipos = equipos;


    }

    // Mostrar todos los equipos
    public void mostrarInventario() {
        System.out.println("\n===== INVENTARIO DEL LABORATORIO =====");
        for (Equipo equipo : equipos) {
            System.out.println("Código: " + equipo.getCodigo());
            System.out.println("Marca: " + equipo.getMarca());
            if (equipo.isDisponible()) {
                System.out.println("Estado: Disponible");
            } else {
                System.out.println("Estado: Prestado");
            }
            System.out.println("--------------------------------");


        }


    }


}