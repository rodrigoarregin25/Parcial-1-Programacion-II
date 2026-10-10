
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
        System.out.println("Lancha realizando servicio");
    }  
}
