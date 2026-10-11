
package transporteturisticogestion;

/**
 * Representa una lancha destinada a fines turisticos.
 * Hereda los atributos y comportamientos de 'Vehiculo' e incorpora el atributo propio 'tipoMotor'
 */
public class Lancha extends Vehiculo{
    private String tipoMotor;

    /**
     * Se inicializa una lancha, tomando los atributos de super
     * 
     * @param patente identificador de la lancha
     * @param marca marca de la lancha
     * @param capacidadPasajeros capacidad permitida de pasajeros
     * @param anioFabricacion año de fabricacion de la lancha
     * @param tipoMotor tipo de motor de la lancha
     * @throws IllegalArgumentException si alguno de los datos no es valido
     */
    public Lancha(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setTipoMotor(tipoMotor);
    }

    /**
     * Obtiene el tipo de motor de la lancha.
     * @return el tipo de motor de la lancha
     */
    public String getTipoMotor() {
        return tipoMotor;
    }

    /**
     * Se establece el tipo de motor con previas validaciones.
     * Valida que no sea nulo ni vacio y que corresponda a NAFTA, DIESEL o ELECTRICO.
     * 
     * @param tipoMotor tipo de motor de la lancha
     * @throws IllegalArgumentException si el motor es nulo, vacio o no es del tipo permitido
     */
    public void setTipoMotor(String tipoMotor) {
        if (tipoMotor == null || tipoMotor.isBlank()) {
            throw new IllegalArgumentException("El tipo de motor  no puede estar vacio");
        }
        
        tipoMotor = tipoMotor.trim().toUpperCase();
        
        if (!tipoMotor.equals("NAFTA") &&
            !tipoMotor.equals("DIESEL") &&
            !tipoMotor.equals("ELECTRICO")){
            throw new IllegalArgumentException("Motor invalido");
        }
        
        this.tipoMotor = tipoMotor;
    }
    
    /**
     * Se realiza un servicio turistico en lancha, mostrando el recorrido y duracion.
     */
    @Override
    public void realizarServicio(){
        System.out.println(" ");
        System.out.println("=== EXCURSION EN LANCHA ===");
        System.out.println("Recorrido por Isla Victoria");
        System.out.println("Navegacion por el lago");
        System.out.println("Duracion: 6 horas");
        System.out.println("Lancha realizando servicio");
    }
    
    /**
     * Muestra los datos generales heredados de Vehiculo y agrega el tipo de vehiculo y su tipo de motor.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Lancha");
        System.out.println("Tipo de motor: " + tipoMotor);
}
}
