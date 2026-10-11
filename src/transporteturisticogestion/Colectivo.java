
package transporteturisticogestion;

/**
 * Representa un colectivo destinado a fines turisticos.
 * Hereda los atributos y comportamientos de 'Vehiculo' e incorpora el atributo propio 'cantidadPisos'
 */
public class Colectivo extends Vehiculo{
    private int cantidadPisos;

    /**
     * Se inicializa un colectivo, tomando los atributos de super
     * 
     * @param patente identificador del colectivo
     * @param marca marca del colectivo
     * @param capacidadPasajeros capacidad permitida de pasajeros
     * @param anioFabricacion año de fabricacion del colectivo
     * @param cantidadPisos cantidad de pisos del colectivo
     * @throws IllegalArgumentException si alguno de los datos no es valido
     */
    public Colectivo(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setCantidadPisos(cantidadPisos);
    }

    /**
     * Obtiene la cantidad de pisos del colectivo.
     * @return la cantidad de pisos del colectivo
     */
    public int getCantidadPisos() {
        return cantidadPisos;
    }

    /**
     * Se establece la cantidad de pisos del colectivo con previas validaciones.
     * 
     * @param cantidadPisos cantidad de pisos que se desea asignar
     * @throws IllegalArgumentException si la cantidad de pisos no es 1 o 2
     */
    public void setCantidadPisos(int cantidadPisos) { 
        if (cantidadPisos != 1 && cantidadPisos != 2){
            throw new IllegalArgumentException("La cantidad de pisos debe ser 1 o 2 unicamente.");
            
        }    
        this.cantidadPisos = cantidadPisos;
    }
    
    /**
     * Se realiza un servicio turistico en colectivo, mostrando el recorrido y duracion.
     */
    @Override
    public void realizarServicio(){
        System.out.println(" ");
        System.out.println("=== EXCURSION EN COLECTIVO ===");
        System.out.println("Recorrido turistico por Circuito Chico");
        System.out.println("Visita a puntos panoramicos");
        System.out.println("Duracion: 4 horas");
        System.out.println("Colectivo realizando servicio");
    }
    
    /**
     * Muestra los datos generales heredados de Vehiculo y agrega el tipo de vehiculo y su cantidad de pisos.
     */
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Colectivo");
        System.out.println("Cantidad de pisos: " + cantidadPisos);
}
    
    
}
