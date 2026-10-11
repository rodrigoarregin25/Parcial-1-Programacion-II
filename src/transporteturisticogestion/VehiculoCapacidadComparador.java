
package transporteturisticogestion;

import java.util.Comparator;

/**
 * Clase encargada de comparar vehiculos segun su capacidad de pasajeros.
 * Implementa la interfaz Comparator para establecer un orden descendente.

 */
public class VehiculoCapacidadComparador implements Comparator<Vehiculo> {
    
    /**
     * Inicializa un comparador para ordenar vehiculos por capacidad de pasajeros.
     */
    public VehiculoCapacidadComparador(){
        
    }
    /**
     * Compara dos vehiculos segun su capacidad de pasajeros, estableciendo un orden de mayor a menor.
     * 
     * @param v1 primer vehiculo a comparar
     * @param v2 segundo vehiculo a comparar
     * @return valor negativo si v1 tiene mayor capacidad que v2, cero si ambos tienen la misma capacidad y positivo si v1 tiene menor capacidad que v2
     */
    @Override
    public int compare(Vehiculo v1, Vehiculo v2){
        return Integer.compare(
            v2.getCapacidadPasajeros(),
            v1.getCapacidadPasajeros()
        );
    } 
}
