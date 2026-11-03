public abstract class Persona {
    // Atributos privados
   private final String documento;
    private String nombre;
    // Constructor
    public Persona(String documento, String nombre) {
        this.documento = documento;
        this.nombre = nombre;


    }
    // Método para obtener el documento

    public String getDocumento() {
        return documento;


    }
    // Método para obtener el nombre

    public String getNombre() {

        return nombre;


    }


    // Método para cambiar el nombre


    public void setNombre(String nombre) {


        this.nombre = nombre;


    }
    // Método abstracto para conocer los días máximos de préstamo
    public abstract int getDiasMaximosPrestamo();
    // Método abstracto para conocer el máximo de equipos permitidos
    public abstract int getMaximoEquipos();


}