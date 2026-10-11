
package transporteturisticogestion;

public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        setPatente(patente);
        setCapacidadPasajeros(capacidadPasajeros);
        setAnioFabricacion(anioFabricacion);
        setMarca(marca);
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

    public final void setPatente(String patente) {
       if (patente == null) {
           throw new IllegalArgumentException("La patente no puede ser null");
        }

        patente = patente.trim().toUpperCase();

        if (patente.isEmpty()) {
            throw new IllegalArgumentException("La patente no puede estar vacía");
        }

        if (patente.length() != 6 && patente.length() != 7) {
            throw new IllegalArgumentException("La patente debe tener 6 o 7 caracteres");
        }
       
        this.patente = patente;
    }

    public final void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacia");
        }
        this.marca = marca;
    }

    public final void setCapacidadPasajeros(int capacidadPasajeros) {
        if (capacidadPasajeros <= 0){
            throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor a cero");
        }
        this.capacidadPasajeros = capacidadPasajeros;
    }

    public final void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 1990 || anioFabricacion > java.time.Year.now().getValue()){
            throw new IllegalArgumentException("El anio de fabricacion no es valido.");
        }
        this.anioFabricacion = anioFabricacion;
    }
    
    
    public abstract void realizarServicio();
    
    public void mostrarInformacion(){
         System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Capacidad: " + capacidadPasajeros);
        System.out.println("Año: " + anioFabricacion);
    }
    
    @Override
    public int compareTo(Vehiculo nuevoVehiculo){ //punto 6
        return Integer.compare(
                nuevoVehiculo.anioFabricacion,
                this.anioFabricacion
        );
    }
    
}
