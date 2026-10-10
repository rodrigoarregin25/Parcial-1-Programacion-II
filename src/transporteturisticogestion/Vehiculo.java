
package transporteturisticogestion;

public abstract class Vehiculo {
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        if (patente == null || patente.isBlank()){
            throw new IllegalArgumentException("La patente no puede estar vacia");
        }
        this.patente = patente;
        
        if (capacidadPasajeros <= 0){
            throw new IllegalArgumentException("");
        }
        this.capacidadPasajeros = capacidadPasajeros;
        
        this.marca = marca;
        
        if (anioFabricacion < 1990){
            throw new IllegalArgumentException("");
        }
        this.anioFabricacion = anioFabricacion;
    }

    
    public String getPatente() {
        return patente;
    }

    public String getMarca() {
        return marca;
    }

    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setPatente(String patente) {
        if (patente == null || patente.isBlank()){
            throw new IllegalArgumentException("La patente no puede estar vacia");
        }
       
        this.patente = patente;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCapacidadPasajeros(int capacidadPasajeros) {
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }
    
}
