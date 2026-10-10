
package transporteturisticogestion;

import java.util.*;

public class VehiculoCapacidadComparador implements Comparator<Vehiculo> {  //punto 7
    
    @Override
    public int compare(Vehiculo v1, Vehiculo v2){
        return Integer.compare(
            v2.getCapacidadPasajeros(),
            v1.getCapacidadPasajeros()
        );
    } 
}
