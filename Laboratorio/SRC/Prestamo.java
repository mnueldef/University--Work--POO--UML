import java.util.ArrayList;


// Clase que representa un préstamo


public class Prestamo {

    private static int contador = 1;
    private int numero;
    private Persona persona;
    private ArrayList<Equipo> equipos;
    private int diasUsados;
    private int diasRetraso;
    private boolean devuelto;
    
    // Constructor
    public Prestamo(Persona persona, ArrayList<Equipo> equipos) {
        this.numero = contador;
        contador++;
        this.persona = persona;
        this.equipos = equipos;
        this.diasUsados = 0;
        this.diasRetraso = 0;
        this.devuelto = false;
    }
   
    // Obtener número
    public int getNumero() {

        return numero;

    }
    // Obtener persona
    public Persona getPersona() {
        return persona;


    }

    // Obtener equipos

    public ArrayList<Equipo> getEquipos() {
        return equipos;
    }

    // Registrar devolución
    public void devolver(int diasUsados) {
        this.diasUsados = diasUsados;
        this.diasRetraso = diasUsados - persona.getDiasMaximosPrestamo();
        if (diasRetraso < 0) {
            diasRetraso = 0;
        }
        this.devuelto = true;
    }
    // Calcular multa del préstamo
    public double calcularMulta() {
        double total = 0;
        for (Equipo equipo : equipos) {
          total += equipo.getMultaPorDia() * diasRetraso;
        }
        return total;
    }

    // Consultar si el préstamo fue devuelto
    public boolean isDevuelto() {
        return devuelto;
    }
}