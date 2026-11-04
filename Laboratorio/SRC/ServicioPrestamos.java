import java.util.ArrayList;
import java.util.List;

public class ServicioPrestamos {

    private ReglaMulta reglaMulta;
    private List<Prestamo> prestamosActivos;

    // Constructor que recibe la estrategia de multa (Principio de Inversión de Dependencias - SOLID)
    public ServicioPrestamos(ReglaMulta reglaMulta) {
        this.reglaMulta = reglaMulta;
        this.prestamosActivos = new ArrayList<>();
    }

    // Permite cambiar la regla de multa dinámicamente (ej. Semana Universitaria)
    public void setReglaMulta(ReglaMulta reglaMulta) {
        this.reglaMulta = reglaMulta;
    }

    
    // SOBRECARGA 1: Prestar una lista de equipos
    //***********************************************
    public Prestamo prestar(Persona persona, List<Equipo> equipos) {
        // Regla 5: Un préstamo sin equipos no es válido
        if (equipos == null || equipos.isEmpty()) {
            System.out.println(" Error: No se puede realizar un préstamo sin equipos.");
            return null;
        }

        // Regla 3: Comprobar que TODOS los equipos solicitados estén disponibles
        for (Equipo equipo : equipos) {
            if (!equipo.isDisponible()) {
                System.out.println(" Préstamo rechazado: El equipo '" + equipo.getCodigo() + 
                                   "' (" + equipo.getMarca() + ") ya se encuentra prestado.");
                return null;
            }
        }

        // Regla 4: Verificar no superar el máximo de equipos permitido para la persona
        int equiposActuales = contarEquiposActivosDe(persona);
        int totalDespuesDePrestamo = equiposActuales + equipos.size();

        if (totalDespuesDePrestamo > persona.getEquiposMaximos()) {
            System.out.println(" Préstamo rechazado: " + persona.getNombre() + 
                               " superaría su límite de " + persona.getEquiposMaximos() + 
                               " equipo(s). (Tiene " + equiposActuales + " activos e intenta llevar " + equipos.size() + ").");
            return null;
        }

        // Cambiar estado de los equipos a no disponible
        for (Equipo equipo : equipos) {
            equipo.setDisponible(false);
        }

        // Crear y guardar el préstamo
        Prestamo nuevoPrestamo = new Prestamo(persona, equipos);
        prestamosActivos.add(nuevoPrestamo);

        // Regla 9: Aviso por consola
        System.out.println(" Préstamo registrado #" + nuevoPrestamo.getNumero() + 
                           " a " + persona.getNombre() + " (" + equipos.size() + " equipo(s)).");

        return nuevoPrestamo;
    }

    
    // SOBRECARGA 2: Prestar un solo equipo (delega a la lista)
    // ***********************************************
    public Prestamo prestar(Persona persona, Equipo equipo) {
        List<Equipo> lista = new ArrayList<>();
        lista.add(equipo);
        return prestar(persona, lista);
    }

  
    // DEVOLUCIÓN 1: Devolver por objeto Préstamo
    // ***********************************************
    public double devolver(Prestamo prestamo, int diasUsados) {
        if (prestamo == null || prestamo.isDevuelto()) {
            System.out.println("El préstamo ya fue devuelto o no existe.");
            return 0.0;
        }

        // Marcar días y estado en el préstamo
        prestamo.devolver(diasUsados);

        // Liberar la disponibilidad de los equipos prestados
        for (Equipo equipo : prestamo.getEquipos()) {
            equipo.setDisponible(true);
        }

        // Sacar de préstamos activos
        prestamosActivos.remove(prestamo);

        // Calcular multa usando la regla inyectada
        double multa = reglaMulta.calcularMulta(prestamo);

        // Regla 9: Aviso por consola
        System.out.println(" Devolución registrada para el Préstamo #" + prestamo.getNumero() + 
                           " de " + prestamo.getPersona().getNombre() + ".");
        
        return multa;
    }

    // ------------------------------------------------------------------
    // DEVOLUCIÓN 2 (Sobrecarga para el Main): Devolver por Persona y Equipos
    // ------------------------------------------------------------------
    public double devolver(Persona persona, List<Equipo> equipos, int diasUsados) {
        Prestamo p = buscarPrestamoActivo(persona, equipos);
        if (p != null) {
            return devolver(p, diasUsados);
        }
        System.out.println(" No se encontró un préstamo activo coincidente para la devolución.");
        return 0.0;
    }

    public double devolver(Persona persona, Equipo equipo, int diasUsados) {
        List<Equipo> lista = new ArrayList<>();
        lista.add(equipo);
        return devolver(persona, lista, diasUsados);
    }

    // ------------------------------------------------------------------
    // Métodos auxiliares privados
    // ------------------------------------------------------------------
    private int contarEquiposActivosDe(Persona persona) {
        int contador = 0;
        for (Prestamo p : prestamosActivos) {
            if (p.getPersona().getDocumento().equals(persona.getDocumento())) {
                contador += p.getEquipos().size();
            }
        }
        return contador;
    }

    private Prestamo buscarPrestamoActivo(Persona persona, List<Equipo> equipos) {
        for (Prestamo p : prestamosActivos) {
            if (p.getPersona().getDocumento().equals(persona.getDocumento())) {
                if (p.getEquipos().containsAll(equipos)) {
                    return p;
                }
            }
        }
        return null;
    }
}