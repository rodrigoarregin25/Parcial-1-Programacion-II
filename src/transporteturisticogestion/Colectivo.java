
package transporteturisticogestion;

public class Colectivo extends Vehiculo{
    private int cantidadPisos;

    public Colectivo(String patente, String marca, int capacidadPasajeros, int anioFabricacion, int cantidadPisos) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setCantidadPisos(cantidadPisos);
    }

    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) { 
        if (cantidadPisos != 1 && cantidadPisos != 2){
            throw new IllegalArgumentException("La cantidad de pisos debe ser 1 o 2 unicamente.");
            
        }    
        this.cantidadPisos = cantidadPisos;
    }
    
    @Override
    public void realizarServicio(){
        System.out.println(" ");
        System.out.println("=== EXCURSION EN COLECTIVO ===");
        System.out.println("Recorrido turistico por Circuito Chico");
        System.out.println("Visita a puntos panoramicos");
        System.out.println("Duracion: 4 horas");
        System.out.println("Colectivo realizando servicio");
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Colectivo");
        System.out.println("Cantidad de pisos: " + cantidadPisos);
}
    
    
}
