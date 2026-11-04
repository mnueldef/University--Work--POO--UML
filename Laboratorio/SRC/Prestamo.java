import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private static int contadorConsecutivo = 1;
    
    private int numeroPrestamo;
    private Persona persona;
    private List<Equipo> equipos;
    private int diasUsados;

    public Prestamo(Persona persona, List<Equipo> equipos) {
        this.numeroPrestamo = contadorConsecutivo++;
        this.persona = persona;
        this.equipos = new ArrayList<>(equipos);
        this.diasUsados = 0;
    }

    public int getNumeroPrestamo() {
        return numeroPrestamo;
    }

    public Persona getPersona() {
        return persona;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public int getDiasUsados() {
        return diasUsados;
    }

    public void setDiasUsados(int diasUsados) {
        this.diasUsados = diasUsados;
    }

    // --- MÉTODOS REQUERIDOS PARA LA REGLA DE MULTAS ---

    public int calcularDiasRetraso() {
        if (persona == null) {
            return 0;
        }
        int diasMaximos = persona.getDiasMaximosPrestamo();
        int retraso = this.diasUsados - diasMaximos;
        return Math.max(0, retraso);
    }

    public double obtenerMultaDiariaTotal() {
        double totalMultaDiaria = 0.0;
        if (equipos != null) {
            for (Equipo equipo : equipos) {
                totalMultaDiaria += equipo.getMultaPorDia();
            }
        }
        return totalMultaDiaria;
    }
    // ... tus otros atributos ...
    private boolean devuelto = false; // Atributo para controlar si ya se devolvió

    // 1. Soluciona: getNumero() is undefined
    public int getNumero() {
        return this.numeroPrestamo; // O la variable donde guardes el id/consecutivo
    }

    // 2. Soluciona: isDevuelto() is undefined
    public boolean isDevuelto() {
        return this.devuelto;
    }

    // 3. Soluciona: devolver(int) is undefined
    public void devolver(int diasUsados) {
        this.diasUsados = diasUsados;
        this.devuelto = true;
    }
}