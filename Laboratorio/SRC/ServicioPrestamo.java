import java.util.ArrayList;

// Clase que administra los préstamos
public class ServicioPrestamos {
    private AlmacenamientoPrestamos almacenamiento;
    private ReglaMulta reglaMulta;
    private Aviso aviso;
    private double totalMultas;


    // Constructo
    public ServicioPrestamos(AlmacenamientoPrestamos almacenamiento,

                             ReglaMulta reglaMulta, Aviso aviso) {

        this.almacenamiento = almacenamiento;
        this.reglaMulta = reglaMulta;
        this.aviso = aviso;
        this.totalMultas = 0;

    }
    // Prestar un solo equipo

    public Prestamo prestar(Persona persona, Equipo equipo) {

        ArrayList<Equipo> equipos = new ArrayList<>();
        equipos.add(equipo);
        return prestar(persona, equipos);
    }

    // Prestar varios equipos
    public Prestamo prestar(Persona persona, ArrayList<Equipo> equipos) {

        if (equipos == null || equipos.isEmpty()) {

            System.out.println("Debe seleccionar al menos un equipo.");

            return null;
        }

        int cantidad = 0;

        for (Prestamo p : almacenamiento.obtenerPrestamos()) {

            if (p.getPersona() == persona && !p.isDevuelto()) {

                cantidad += p.getEquipos().size();

            }

        }

        if (cantidad + equipos.size() > persona.getMaximoEquipos()) {

            System.out.println("La persona superó el límite de equipos.");

            return null;

        }

        for (Equipo equipo : equipos) {

            if (!equipo.isDisponible()) {

                System.out.println("El equipo " + equipo.getCodigo()

                        + " no está disponible.");

                return null;

            }

        }

        Prestamo prestamo = new Prestamo(persona, equipos);

        almacenamiento.guardar(prestamo);

        for (Equipo equipo : equipos) {

            equipo.cambiarDisponibilidad(false);

        }

        aviso.notificar(persona, "Préstamo realizado correctamente.");

        System.out.println("Préstamo realizado. Número: "

                + prestamo.getNumero());

        return prestamo;

    }

    // Registrar la devolución

    public void devolver(Prestamo prestamo, int diasUsados) {

        if (prestamo == null || prestamo.isDevuelto()) {

            System.out.println("Este préstamo no es válido o ya fue devuelto.");

            return;

        }

        prestamo.devolver(diasUsados);

        for (Equipo equipo : prestamo.getEquipos()) {

            equipo.cambiarDisponibilidad(true);

        }

        double multa = reglaMulta.calcularMulta(prestamo);

        totalMultas += multa;

        aviso.notificar(prestamo.getPersona(),

                "Devolución realizada. Multa: $" + multa);

        System.out.println("Multa del préstamo: $" + multa);

    }
    // Consultar el total de multas

    public double getTotalMultas() {

        return totalMultas;

    }

}