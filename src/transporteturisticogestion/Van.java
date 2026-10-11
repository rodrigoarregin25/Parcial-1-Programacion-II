
package transporteturisticogestion;

public class Van extends Vehiculo {
    private boolean aireAcondicionado;

    public Van(String patente, String marca, int capacidadPasajeros, int anioFabricacion, boolean aireAcondicionado) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        this.aireAcondicionado = aireAcondicionado;
    }

    public boolean isAireAcondicionado() {
        return aireAcondicionado;
    }

    public void setAireAcondicionado(boolean aireAcondicionado) {
        this.aireAcondicionado = aireAcondicionado;
    }

    @Override
    public void realizarServicio(){
        System.out.println(" ");
        System.out.println("=== EXCURSION EN VAN ===");
        System.out.println("Traslado a Puerto Pañuelo");
        System.out.println("Traslado adicional al puerto para excursiones lacustres");
        System.out.println("Duracion: 40 minutos");
        System.out.println("Van realizando servicio");
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Van");
        System.out.println("Tiene Aire: " + aireAcondicionado);
}
    
}
