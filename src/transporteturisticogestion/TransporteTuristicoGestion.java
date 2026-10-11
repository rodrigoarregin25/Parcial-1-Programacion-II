
package transporteturisticogestion;

import java.util.ArrayList;
import java.util.Scanner;


public class TransporteTuristicoGestion {


    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        
        
        listaVehiculos.add(new Colectivo(
                "AA123BB", "Mercedes Benz", 45, 2020, 2));

        listaVehiculos.add(new Colectivo(
                "AB456CD", "Scania", 50, 2022, 1));

        listaVehiculos.add(new Van(
                "AC789EF", "Renault", 15, 2021, true));

        listaVehiculos.add(new Van(
                "AD321GH", "Toyota", 12, 2019, false));

        listaVehiculos.add(new Lancha(
                "LAN001", "Yamaha", 8, 2023, "NAFTA"));

        listaVehiculos.add(new Lancha(
                "LAN002", "Mercury", 10, 2022, "ELECTRICO"));
        
        
        int opcion = 0;
        

        do {
            System.out.println("\n=== TRANSPORTE TURISTICO ===");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Mostrar todos los vehiculos");
            System.out.println("3. Realizar servicios turisticos");
            System.out.println("4. Buscar vehiculo por patente");
            System.out.println("5. Filtrar por capacidad");
            System.out.println("6. Ordenar por año descendente");
            System.out.println("7. Ordenar por capacidad descendente");
            System.out.println("8. Salir");

            try {
                System.out.print("Ingrese una opcion: ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Vehiculo a ingresar: ");
                        System.out.println("1. Colectivo");
                        System.out.println("2. Van");
                        System.out.println("3. Lancha");
                        
                        int tipoVehiculo;
                        while(true){
                            try{
                                System.out.print("Ingrese tipo de vehiculo. Si no recuerda los tipos, ingrese 0: ");
                                tipoVehiculo = Integer.parseInt(scanner.nextLine());
                                
                                if (tipoVehiculo == 0){
                                    System.out.println("1. Colectivo");
                                    System.out.println("2. Van");
                                    System.out.println("3. Lancha");
                                    continue;
                                    
                                }
                                
                                if (tipoVehiculo < 1 || tipoVehiculo >3 ){
                                    System.out.println("ERROR. Debe ingresar un tipo de vehiculo correcto.");
                                    continue;
                                }
                                
                                break;
                                
                            } catch(NumberFormatException e){
                                System.out.println("ERROR. Debe ingresar un numero entero.");
                            }
                                        
                        }
                        
                        //while patente
                        String patente;
                        boolean patenteExiste;
                        
                        while (true){
                            System.out.print("Ingrese patente: ");
                            patente = scanner.nextLine();
                            if (patente.isBlank()){
                                System.out.println("ERROR: La patente no puede estar vacia.");
                                continue;
                            }
                            
                            if (patente.trim().length() != 6 && patente.trim().length() != 7) {
                                System.out.println("ERROR. La patente debe tener 6 o 7 caracteres.");
                                continue;
                            }

                            patenteExiste = false;

                            for (Vehiculo vehiculo : listaVehiculos){
                                if (vehiculo.getPatente().equals(patente.trim().toUpperCase())){
                                    patenteExiste = true;
                                    break;
                                }
                            }

                            if(patenteExiste){
                                System.out.println("Error: entrada duplicada. Debe ingresar una patente diferente");
                                continue;
                            }
                            
                            break;
                        }
                        //-------------------------------
                        
                        //while marca
                        String marca;
                        
                        while (true){
                            System.out.print("Ingrese marca: ");
                            marca = scanner.nextLine();
                            if (marca.isBlank()){
                                System.out.println("ERROR: La marca no puede estar vacia.");
                                continue;
                            }
                            break;
                        }                        
                       
                        //-------------------------------
                        
                        //while cantidad pasajeros
                        int capacidadPasajeros;
                        
                        while (true){
                            try{
                                System.out.print("Ingrese capacidad de pasajeros: ");                            
                                capacidadPasajeros = Integer.parseInt(scanner.nextLine());
                                
                                if (capacidadPasajeros <= 0){
                                    System.out.println("ERROR. La capacidad de pasajeros debe ser mayor a cero. ");
                                    continue;
                                }
                                
                                break;
                            } catch(NumberFormatException e){
                                System.out.println("ERROR. Debe ingresar un numero entero.");
                            }   
                        }
                        //-----------------------------
                        
                        //while anio
                       
                        int anioFabricacion;
                        
                        while (true){
                            
                            try{
                                System.out.print("Ingrese año de fabricacion: ");                            
                                anioFabricacion = Integer.parseInt(scanner.nextLine());
                                
                                if (anioFabricacion < 1990){
                                    System.out.println("ERROR. El año de fabricacion no puede ser menor a 1990. ");
                                    continue;
                                }
                                
                                if (anioFabricacion > java.time.Year.now().getValue()){
                                    System.out.println("ERROR. El año de fabricacion no puede mayor al actual. ");
                                    continue;
                                }
                                
                                break;
                                
                            } catch(NumberFormatException e){
                                System.out.println("ERROR. Debe ingresar un numero entero.");
                            }   
                        }
                        //-------------------------------
                        
                        //while pisos
                        
                        if(tipoVehiculo == 1){
                            
                            int cantidadPisos;
                            
                            while(true){
                                try{
                                    System.out.print("Ingrese cantidad de pisos: ");
                                    cantidadPisos = Integer.parseInt(scanner.nextLine());
                                    
                                    if (cantidadPisos != 1 && cantidadPisos != 2){
                                        System.out.println("ERROR. La cantidad de pisos debe ser 1 o 2.");
                                        continue;
                                    }
                                    
                                    break;
                                    
                                } catch(NumberFormatException e){
                                System.out.println("ERROR. Debe ingresar un numero entero.");
                                }
                            }
                            
                            //-----------------------

                            Colectivo colectivo = new Colectivo(
                            patente,
                            marca,
                            capacidadPasajeros,
                            anioFabricacion,
                            cantidadPisos                                    
                            );
                            
                            listaVehiculos.add(colectivo);
                            System.out.println("Colectivo agregado correctamente.");
                        }
                        
                        else if(tipoVehiculo == 2){
                            boolean aireAcondicionado;
                            while(true){
                                try{                           
                                    System.out.println("La van cuenta con aire acondicionado? 1: SI - 2: NO");
                                    int tieneAire = Integer.parseInt(scanner.nextLine());

                                    if (tieneAire == 1){
                                        aireAcondicionado = true;                                
                                    } else if(tieneAire == 2){
                                        aireAcondicionado = false;
                                    } else{
                                        System.out.println("ERROR. Debe ingresar 1 o 2 para definir el aire acondicionado");
                                        continue;
                                    }
                                    break;
                                    
                                } catch (NumberFormatException e){
                                    System.out.println("ERROR. Debe ingresar un numero entero.");
                                }
                            }
                            Van van = new Van(
                                patente,
                                marca,
                                capacidadPasajeros,
                                anioFabricacion,
                                aireAcondicionado
                            );
                            
                            listaVehiculos.add(van);
                            System.out.println("Van agregada correctamente");
                        }
                        
                        
                        else if (tipoVehiculo == 3){
                            String tipoMotor;
                            while (true){
                                System.out.println("Ingrese el tipo de motor de la lancha: ");
                                tipoMotor = scanner.nextLine().trim().toUpperCase();
                                
                                if (!tipoMotor.equals("NAFTA") &&
                                    !tipoMotor.equals("DIESEL") &&
                                    !tipoMotor.equals("ELECTRICO")) {
                                    System.out.println("ERROR. Tipo de motor invalido.");
                                    continue;
                                }
                                break;
                            }

                            Lancha lancha = new Lancha(
                                patente,
                                marca,
                                capacidadPasajeros,
                                anioFabricacion,
                                tipoMotor
                            );
                            
                            listaVehiculos.add(lancha);
                            System.out.println("Lancha agregada correctamente.");         
                        }
                        
                        break;

                    case 2:
                        System.out.println("Mostrar vehiculos");
                        break;

                    case 3:
                        System.out.println("Realizar servicios");
                        break;

                    case 4:
                        System.out.println("Buscar por patente");
                        break;

                    case 5:
                        System.out.println("Filtrar por capacidad");
                        break;

                    case 6:
                        System.out.println("Ordenar por año");
                        break;

                    case 7:
                        System.out.println("Ordenar por capacidad");
                        break;

                    case 8:
                        System.out.println("Saliendo del sistema...");
                        break;

                    default:
                        System.out.println("Opcion invalida");
                }

            } catch (NumberFormatException e) {
                System.out.println("Error: debe ingresar un numero.");
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }

        } while (opcion != 8);
        
                
    }
    
}
