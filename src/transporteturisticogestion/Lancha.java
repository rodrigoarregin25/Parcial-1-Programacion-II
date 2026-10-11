
package transporteturisticogestion;

public class Lancha extends Vehiculo{
    private String tipoMotor;

    public Lancha(String patente, String marca, int capacidadPasajeros, int anioFabricacion, String tipoMotor) {
        super(patente, marca, capacidadPasajeros, anioFabricacion);
        setTipoMotor(tipoMotor);
    }

    public String getTipoMotor() {
        return tipoMotor;
    }

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
    
    @Override
    public void realizarServicio(){
        System.out.println(" ");
        System.out.println("=== EXCURSION EN LANCHA ===");
        System.out.println("Recorrido por Isla Victoria");
        System.out.println("Navegacion por el lago");
        System.out.println("Duracion: 6 horas");
        System.out.println("Lancha realizando servicio");
    }
    
    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo: Lancha");
        System.out.println("Tipo de motor: " + tipoMotor);
}
}
