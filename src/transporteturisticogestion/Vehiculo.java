
package transporteturisticogestion;

/**
 * Clase abstracta que representa un vehiculo destinado a servicios turisticos.
 * Cuenta con los atributos y validaciones comunes que heredaran los vehiculos creados.
 * 
 * Implementa 'Comparable' para ordenar por año de fabricacion.
 */
public abstract class Vehiculo implements Comparable<Vehiculo> {
    private String patente;
    private String marca;
    private int capacidadPasajeros;
    private int anioFabricacion;

    /**
     * Inicializa un vehiculo con atributos comunes.
     * Se utilizan los setters para validar previamente los datos.
     * 
     * @param patente identificador unico de vehiculo
     * @param marca marca del vehiculo
     * @param capacidadPasajeros cantidad de pasajeros permitida
     * @param anioFabricacion año de fabricacion del vehiculo
     * @throws IllegalArgumentException si alguno de los datos es invalido
     */
    public Vehiculo(String patente, String marca, int capacidadPasajeros, int anioFabricacion) {
        setPatente(patente);
        setCapacidadPasajeros(capacidadPasajeros);
        setAnioFabricacion(anioFabricacion);
        setMarca(marca);
    }

    /**
     * Obtiene la patente del vehiculo.
     * 
     * @return patente del vehiculo
     */
    public String getPatente() {
        return patente;
    }

    /**
     * Obtiene la marca del vehiculo.
     * 
     * @return la marca del vehiculo
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Obtiene la capacidad de pasajeros del vehiculo.
     * 
     * @return la capacidad maxima de pasajeros permitida
     */
    public int getCapacidadPasajeros() {
        return capacidadPasajeros;
    }

    /**
     * Obtiene el año de fabricacion del vehiculo.
     * 
     * @return el año de fabricacion del vehiculo
     */
    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    /**
     * Se establece la patente del vehiculo con previas validaciones.
     * Se eliminan espacios con .trim y se convierte a mayuscula con .toUpperCase.
     * Se valida que la patente tenga 6 o 7 caracteres.
     * 
     * @param patente patente que se agregara
     * @throws IllegalArgumentException si la patente es nula, esta vacia o no respeta cantidad de caracteres
     */
    public final void setPatente(String patente) {
       if (patente == null) {
           throw new IllegalArgumentException("La patente no puede ser null");
        }

        patente = patente.trim().toUpperCase().replace(" ", "");

        if (patente.isEmpty()) {
            throw new IllegalArgumentException("La patente no puede estar vacía");
        }

        if (patente.length() != 6 && patente.length() != 7) {
            throw new IllegalArgumentException("La patente debe tener 6 o 7 caracteres");
        }
       
        this.patente = patente;
    }

    /**
     * Se establece la marca del vehiculo con previas validaciones.
     * Se valida que la marca no sea nula o vacia.
     * 
     * @param marca marca del vehiculo
     * @throws IllegalArgumentException si la marca es nula o esta vacia
     */
    public final void setMarca(String marca) {
        if (marca == null || marca.isBlank()) {
            throw new IllegalArgumentException("La marca no puede estar vacia");
        }
        this.marca = marca;
    }

    /**
     * Se establece la capacidad de pasajeros del vehiculo con previas validaciones.
     * Se valida que la capacidad se mayor a cero.
     * 
     * @param capacidadPasajeros cantidadde pasajeros permitida
     * @throws IllegalArgumentException si la capacidad es menor o igual a cero
     */
    public final void setCapacidadPasajeros(int capacidadPasajeros) {
        if (capacidadPasajeros <= 0){
            throw new IllegalArgumentException("La capacidad de pasajeros debe ser mayor a cero");
        }
        this.capacidadPasajeros = capacidadPasajeros;
    }

    /**
     * Se establece el año de fabricacion del vehiculo con previas validaciones.
     * 
     * @param anioFabricacion año de fabricacion del vehiculo
     * @throws IllegalArgumentException si el año es menor a 1990 o mayor al actual
     */
    public final void setAnioFabricacion(int anioFabricacion) {
        if (anioFabricacion < 1990 || anioFabricacion > java.time.Year.now().getValue()){
            throw new IllegalArgumentException("El año de fabricacion no es valido.");
        }
        this.anioFabricacion = anioFabricacion;
    }
    
    /**
     * Define el servicio turistico que realizara cada tipo de vehiculo.
     * Se implementa en las clases hijas.
     */
    public abstract void realizarServicio();
    
    /**
     * Permite mostrar la informacion del vehiculo. 
     */
    public void mostrarInformacion(){
        System.out.println("Patente: " + patente);
        System.out.println("Marca: " + marca);
        System.out.println("Capacidad pasajeros: " + capacidadPasajeros + " personas");
        System.out.println("Año: " + anioFabricacion);
    }
    
    /**
     * Compara dos vehiculos por su año de fabricacion, estableciendo un orden descendente.
     * 
     * @param nuevoVehiculo vehiculo con el cual se realiza la comparacion
     * @return valor negativo si el otro vehiculo es mas reciente, cero si ambos tienen el mismo año y positivo si el actual es mas reciente
     */
    @Override
    public int compareTo(Vehiculo nuevoVehiculo){
        return Integer.compare(
                nuevoVehiculo.anioFabricacion,
                this.anioFabricacion
        );
    }
    
}
