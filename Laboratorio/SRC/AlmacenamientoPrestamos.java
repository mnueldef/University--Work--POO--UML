import java.util.ArrayList;
// Interfaz para almacenar préstamos
public interface AlmacenamientoPrestamos {
    // Guardar un préstamo
    void guardar(Prestamo prestamo);

    // Obtener todos los préstamos
    ArrayList<Prestamo> obtenerPrestamos();


}