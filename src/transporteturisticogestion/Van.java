
package transporteturisticogestion;

/**
 * Representa una van destinada a fines turisticos.
 * Hereda los atributos y comportamientos de 'Vehiculo' e incorpora el atributo propio 'aireAcondicionado'
 */
public class Van extends Vehiculo {
    private boolean aireAcondicionado;

    /**
     * Se inicializa una van, tomando los atributos de super
     * 
     * @param patente identificador de la van
     * @param marca marca de la van
     * @param capacidadPasajeros capacidad permitida de pasajeros
     * @param anioFabricacion año de fabricacion de la van
     * @param aireAcondicionado representa si la van tiene o no aire acondicionado
     * @throws IllegalArgumentException si alguno de los datos no es valido
     */
    public Van(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    /**
     * Indica si la van cuenta con aire acondicionado.
     * @return true si tiene aire acondicionado, false si no tiene
     */
    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    /**
     * Establece el valor del atributo.
     * @param aireAcondicionado nuevo valor que se desea asignar
     */
    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    /**
     * Se realiza un servicio turistico en van, mostrando el recorrido y duracion.
     */
    @Override
    public void realizarServicio(){
        System.out.println(" ");
        System.out.println("=== EXCURSION EN VAN ===");
        System.out.println("Traslado a Puerto Pañuelo");
        System.out.println("Traslado adicional al puerto para excursiones lacustres");
        System.out.println("Duracion: 40 minutos");
        System.out.println("Van realizando servicio");
    }
    
    /**
     * Muestra los datos generales heredados de Vehiculo y agrega el tipo de vehiculo y si tiene o no aire acondicionado.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Van");
        System.out.println("Tiene Aire: " + (aireAcondicionado ? "Si" : "No"));
}  
}
