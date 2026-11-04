import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("┌──────────────────────────────────────────────────────────────────────────────┐");
System.out.println("│                                                                              │");
System.out.println("│   ██████╗  ██████╗  ██████╗     ██╗      █████╗ ██████╗                      │");
System.out.println("│   ██╔══██╗██╔═══██╗██╔═══██╗    ██║     ██╔══██╗██╔══██╗                     │");
System.out.println("│   ██████╔╝██║   ██║██║   ██║    ██║     ███████║██████╔╝                     │");
System.out.println("│   ██╔═══╝ ██║   ██║██║   ██║    ██║     ██╔══██║██╔══██╗                     │");
System.out.println("│   ██║     ╚██████╔╝╚██████╔╝    ███████╗██║  ██║██████╔╝                     │");
System.out.println("│   ╚═╝      ╚═════╝  ╚═════╝     ╚══════╝╚═╝  ╚═╝╚═════╝                      │");
System.out.println("│                                                                              │");
System.out.println("│             S I S T E M A   D E   G E S T I Ó N   D E   P R É S T A M O S    │");
System.out.println("│                                                                              │");
System.out.println("│                                                                              │");
System.out.println("└──────────────────────────────────────────────────────────────────────────────┘\n");

        // PASO 1: Crear objetos (2 Portátiles, 1 Proyector, 1 Tablet, 1 Estudiante, 1 Docente)
        // ------------------------------------------------------------------
        System.out.println(" 1.) Creación de Equipos y Personas ---");
        
        // implementar portatil
        Portatil portatil1 = new Portatil("POR-01", "Dell", 16, "C-001", 65);
        Portatil portatil2 = new Portatil("POR-02", "Lenovo", 8, "C-002", 90);

        // Crear proyector y tablet
        Proyector proyector = new Proyector("PROY-01", "Epson", 3500);
        Tablet tablet = new Tablet("TAB-01", "Samsung");

        // Crear personas
        Estudiante estudiante = new Estudiante("1001", "Valeria Gómez", "Ingeniería de Sistemas");
        Docente docente = new Docente("2001", "Carlos Pérez", "Facultad de Ingeniería");

        System.out.println("Equipos y personas creados exitosamente.\n");

        // Configuración del servicio de préstamos con regla estándar y servicio de avisos/almacenamiento
        // (Ajusta el nombre de tus clases de aviso/almacenamiento en memoria si varían ligeramente)
        ReglaMulta reglaEstandar = new ReglaMultaEstandar(); 
        ServicioPrestamos servicio = new ServicioPrestamos(reglaEstandar);


        // PASO 2: Realizar préstamos válidos
        // ------------------------------------------------------------------
        System.out.println(" 2.) Préstamos iniciales válidos ");
        System.out.println("> La estudiante presta un portátil:");
        servicio.prestar(estudiante, portatil1);

        System.out.println("\n> El docente presta el proyector y la tablet:");
        servicio.prestar(docente, Arrays.asList(proyector, tablet));
        System.out.println();

     
        // PASO 3: Intentos de préstamos inválidos (Deben ser rechazados)
        // ------------------------------------------------------------------
        System.out.println(" 3.) Pruebas de rechazo de préstamos ");
        System.out.println("> Intentando que la estudiante preste otro portátil (Supera su límite de 1 equipo):");
        servicio.prestar(estudiante, portatil2);

        System.out.println("\n> Intentando que el docente preste un portátil ocupado:");
        servicio.prestar(docente, portatil1);
        System.out.println();


        // PASO 4: Imprimir inventario actual
        // ------------------------------------------------------------------
        System.out.println("4.) Reporte de Inventario");
        List<Equipo> inventario = Arrays.asList(portatil1, portatil2, proyector, tablet);
        ReporteInventario reporte = new ReporteInventario();
        reporte.imprimirInventario(inventario); 
        System.out.println();


        // PASO 5: Devoluciones
        // ------------------------------------------------------------------
        System.out.println(" 5.) Devoluciones de préstamos (Regla Estándar)");
        System.out.println("> Estudiante devuelve a los 5 días (2 días de retraso):");
        double multaEstudiante = servicio.devolver(estudiante, portatil1, 5);
        System.out.println("Multa calculada para estudiante: $" + multaEstudiante);

        System.out.println("\n> Docente devuelve a los 8 días (A tiempo, 0 retraso):");
        double multaDocente = servicio.devolver(docente, Arrays.asList(proyector, tablet), 8);
        System.out.println("Multa calculada para docente: $" + multaDocente);
        System.out.println();


        // PASO 6: Cambiar a regla de Semana Universitaria y repetir préstamo tardío
        // ------------------------------------------------------------------
        System.out.println(" 6.) Préstamo y devolución en Semana Universitaria ");
        ReglaMulta reglaSemanaU = new ReglaMultaSemanaUniversitaria();
        ServicioPrestamos servicioSemanaU = new ServicioPrestamos(reglaSemanaU);

        System.out.println("> La estudiante presta de nuevo el portátil:");
        servicioSemanaU.prestar(estudiante, portatil1);

        System.out.println("\n> Estudiante devuelve a los 5 días en Semana Universitaria (Multa al 50%):");
        double multaSemanaU = servicioSemanaU.devolver(estudiante, portatil1, 5);
        System.out.println("Multa calculada (Semana U): $" + multaSemanaU);
        System.out.println();

        // PASO 7: Imprimir total de multas acumuladas e inventario final
        // ------------------------------------------------------------------
        System.out.println(" 7.) Resumen final e Inventario");
        double totalMultas = multaEstudiante + multaDocente + multaSemanaU;
        System.out.println("TOTAL GENERAL DE MULTAS COBRADAS: $" + totalMultas + "\n");

        System.out.println("Inventario Final del Laboratorio:");
        reporte.imprimirInventario(inventario);

        System.out.println("\n*************************************************");
        System.out.println("        FIN DEL ESCENARIO DE PRUEBAS              ");
        System.out.println("*************************************************");
    }
}  


//INTEGRANTES DEL GRUPO:
// Manuel david Fernandez
//JUAN JOSE ZAPATA GUTIERREZ