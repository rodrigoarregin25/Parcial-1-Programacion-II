package transporteturisticogestion;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

/**
 * Sistema de gestion de transporte turistico
 * Permite registrar, consultar, buscar y ordenar vehiculos mediante un menu de opciones. A su vez, permite realizar servicios turisticos.
 * 
 * Se utiliza un ArrayList para guardar los vehiculos.
 */
public class TransporteTuristicoGestion {

    /**
     * Evita la creacion de instancias de la clase principal.
     */
    private TransporteTuristicoGestion() {
    }
    
    /**
     * Inicio del programa.
     * Se inicializa una lista de vehiculos a modo de prueba para que se cuente con datos.
     * 
     * @param args argumentos de la linea de comandos
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
/*
        listaVehiculos.add(new Colectivo(
                "AA123BZ", "Mercedes Benz", 45, 2020, 2));

        listaVehiculos.add(new Colectivo(
                "AE456CD", "Scania", 50, 2022, 1));

        listaVehiculos.add(new Van(
                "AC780EF", "Renault", 15, 2021, true));

        listaVehiculos.add(new Van(
                "AD321GH", "Toyota", 12, 2019, false));

        listaVehiculos.add(new Lancha(
                "LAN021", "Yamaha", 8, 2023, "NAFTA"));

        listaVehiculos.add(new Lancha(
                "LAN072", "Mercury", 10, 2022, "ELECTRICO"));
*/
        int opcion = 0;

        do {
            System.out.println("\n=== TRANSPORTE TURISTICO ===");
            System.out.println("1. Agregar vehiculo");
            System.out.println("2. Mostrar todos los vehiculos");
            System.out.println("3. Realizar servicios turisticos");
            System.out.println("4. Buscar vehiculo por patente");
            System.out.println("5. Mostrar vehiculos con capacidad mayor a un valor ingresado");
            System.out.println("6. Ordenar por año descendente");
            System.out.println("7. Ordenar por capacidad descendente");
            System.out.println("8. Salir");

            try {
                System.out.println(" ");
                System.out.print("Ingrese una opcion: ");
                System.out.print(" ");
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        agregarVehiculo(scanner, listaVehiculos);
                        break;

                    case 2:
                        mostrarVehiculos(listaVehiculos);
                        break;

                    case 3:
                        realizarServicio(scanner, listaVehiculos);
                        break;

                    case 4:
                        buscarPorPatente(scanner, listaVehiculos);
                        break;

                    case 5:
                        buscarPorCapacidad(scanner, listaVehiculos);
                        break;

                    case 6:
                        ordenarPorAnio(listaVehiculos);
                        break;

                    case 7:
                        ordenarPorCapacidad(listaVehiculos);
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

    /**
     * Permite registrar un nuevo vehiculo del tipo colectivo, vans o lanchas.
     * Se validan los datos ingresados y se evitan patentes duplicadas.
     * 
     * @param scanner lector de datos ingresados por consola
     * @param listaVehiculos lista de los vehiculos registrado
     */
    
    private static void agregarVehiculo(
            Scanner scanner,
            ArrayList<Vehiculo> listaVehiculos) {
        System.out.println("Vehiculo a ingresar: ");
        System.out.println("1. Colectivo");
        System.out.println("2. Van");
        System.out.println("3. Lancha");

        int tipoVehiculo;
        while (true) {
            try {
                System.out.print("Ingrese tipo de vehiculo. Si no los recuerda ingrese 0, o ingrese 9 para volver al menu): ");
                tipoVehiculo = Integer.parseInt(scanner.nextLine());

                if (tipoVehiculo == 9) {
                    break;
                }

                if (tipoVehiculo == 0) {
                    System.out.println("1. Colectivo");
                    System.out.println("2. Van");
                    System.out.println("3. Lancha");
                    continue;

                }

                if (tipoVehiculo < 1 || tipoVehiculo > 3) {
                    System.out.println("ERROR. Debe ingresar un tipo de vehiculo correcto.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("ERROR. Debe ingresar un numero entero.");
            }
        }

        if (tipoVehiculo == 9) {
            System.out.println(" ");
            System.out.println("Volviendo al menu principal...");
            return;
        }

        //Bucle while para validar y registrar la patente del vehiculo. 
        String patente;
        boolean patenteExiste;

        while (true) {
            System.out.print("Ingrese patente: ");
            patente = scanner.nextLine();
            if (patente.isBlank()) {
                System.out.println("ERROR. La patente no puede estar vacia.");
                continue;
            }

            if (patente.trim().length() != 6 && patente.trim().length() != 7) {
                System.out.println("ERROR. La patente debe tener 6 o 7 caracteres.");
                continue;
            }

            patenteExiste = false;

            //Se valida que la patente no este previamente registada en la lista
            for (Vehiculo vehiculo : listaVehiculos) {
                if (vehiculo.getPatente().equals(patente.trim().toUpperCase())) {
                    patenteExiste = true;
                    break;
                }
            }

            if (patenteExiste) {
                System.out.println("Error. Entrada duplicada. Debe ingresar una patente diferente");
                continue;
            }

            break;
        }

        //Bucle while para validar y registrar la marca del vehiculo
        String marca;

        while (true) {
            System.out.print("Ingrese marca: ");
            marca = scanner.nextLine();
            if (marca.isBlank()) {
                System.out.println("ERROR. La marca no puede estar vacia.");
                continue;
            }
            break;
        }

        //Bucle while para validar y registrar la cantidad de pasajeros del vehiculo
        int capacidadPasajeros;

        while (true) {
            try {
                System.out.print("Ingrese capacidad de pasajeros: ");
                capacidadPasajeros = Integer.parseInt(scanner.nextLine());

                if (capacidadPasajeros <= 0) {
                    System.out.println("ERROR. La capacidad de pasajeros debe ser mayor a cero. ");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("ERROR. Debe ingresar un numero entero.");
            }
        }
        
        //Bucle while para validar y registrar el año de fabricacion del vehiculo
        int anioFabricacion;

        while (true) {

            try {
                System.out.print("Ingrese año de fabricacion: ");
                anioFabricacion = Integer.parseInt(scanner.nextLine());

                if (anioFabricacion < 1990) {
                    System.out.println("ERROR. El año de fabricacion no puede ser menor a 1990. ");
                    continue;
                }

                if (anioFabricacion > java.time.Year.now().getValue()) {
                    System.out.println("ERROR. El año de fabricacion no puede mayor al actual. ");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("ERROR. Debe ingresar un numero entero.");
            }
        }
        
       //Bucle while para validar y registrar la cantidad de pisos del colectivo
        if (tipoVehiculo == 1) {

            int cantidadPisos;

            while (true) {
                try {
                    System.out.print("Ingrese cantidad de pisos: ");
                    cantidadPisos = Integer.parseInt(scanner.nextLine());

                    if (cantidadPisos != 1 && cantidadPisos != 2) {
                        System.out.println("ERROR. La cantidad de pisos debe ser 1 o 2.");
                        continue;
                    }

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("ERROR. Debe ingresar un numero entero.");
                }
            }

            Colectivo colectivo = new Colectivo(
                    patente,
                    marca,
                    capacidadPasajeros,
                    anioFabricacion,
                    cantidadPisos
            );

            listaVehiculos.add(colectivo);
            System.out.println("");
            System.out.println("Colectivo agregado correctamente.");
            
        } else if (tipoVehiculo == 2) {
            
            boolean aireAcondicionado;
            
            //Bucle while para validar y registrar si la van cuenta con aire acondicionado
            while (true) {
                try {
                    System.out.print("La van cuenta con aire acondicionado? 1: SI - 2: NO - Respuesta: ");
                    int tieneAire = Integer.parseInt(scanner.nextLine());

                    if (tieneAire == 1) {
                        aireAcondicionado = true;
                    } else if (tieneAire == 2) {
                        aireAcondicionado = false;
                    } else {
                        System.out.println("ERROR. Debe ingresar 1 o 2 para definir el aire acondicionado");
                        continue;
                    }
                    break;

                } catch (NumberFormatException e) {
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
            
        } else if (tipoVehiculo == 3) {
            
            String tipoMotor;
            
            //Bucle while para validar y registrar el tipo de motor de la lancha.
            while (true) {
                System.out.print("Ingrese el tipo de motor de la lancha (Nafta, Diesel o Electrico");
                tipoMotor = scanner.nextLine().trim().toUpperCase();

                if (!tipoMotor.equals("NAFTA")
                        && !tipoMotor.equals("DIESEL")
                        && !tipoMotor.equals("ELECTRICO")) {
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

    }

    /**
     * Permite mostrar la informacion de todos los vehiculos registrados en una lista.
     * 
     * @param listaVehiculos lista de vehiculos registrados
     */
    private static void mostrarVehiculos(ArrayList<Vehiculo> listaVehiculos) {

        if (listaVehiculos.isEmpty()) {
            System.out.println(" ");
            System.out.println("No hay vehiculos registrados aun.");
        } else {
            for (Vehiculo vehiculo : listaVehiculos) {
                System.out.println("---------------");
                vehiculo.mostrarInformacion();
            }
        }

    }
    
    /**
     * Permite seleccionar un tipo de excursion para realizar un servicio y ejecuita el servicio del primer vehiculo del tipo seleccionado.
     * Valida que la lista de vehiculos no este vacia.
     * 
     * @param scanner lector de datos ingresados por consola
     * @param listaVehiculos lista de los vehiculos registrado
     */
    private static void realizarServicio(
            Scanner scanner,
            ArrayList<Vehiculo> listaVehiculos) {
        
        if(listaVehiculos.isEmpty()){
            System.out.println(" ");
            System.out.println("No hay vehiculos registrados aun.");
            return; 
        }
        
        System.out.println(" ");
        System.out.println("=== SERVICIOS TURISTICOS ===");
        System.out.println("1. Excursion en Colectivo");
        System.out.println("2. Excursion en Van");
        System.out.println("3. Excursion en Lancha");
        System.out.println("0. Volver");

        int tipoServicio;

        while (true) {
            try {
                System.out.println("");
                System.out.print("Ingrese la excursion. (Ingrese 0 para volver al menu): ");
                tipoServicio = Integer.parseInt(scanner.nextLine());

                if (tipoServicio < 0 || tipoServicio > 3) {
                    System.out.println("ERROR. Servicio invalido.");
                    continue;
                }

                break;
            } catch (NumberFormatException e) {
                System.out.println("ERROR. Debe ingresar un numero entero.");
            }
        }

        if (tipoServicio == 0) {
            return;
        }

        boolean servicioRealizado = false;

        for (Vehiculo vehiculo : listaVehiculos) {

            if (tipoServicio == 1 && vehiculo instanceof Colectivo) {
                vehiculo.realizarServicio();
                servicioRealizado = true;
                break;

            } else if (tipoServicio == 2 && vehiculo instanceof Van) {
                vehiculo.realizarServicio();
                servicioRealizado = true;
                break;

            } else if (tipoServicio == 3 && vehiculo instanceof Lancha) {
                vehiculo.realizarServicio();
                servicioRealizado = true;
                break;
            }
        }

        if (!servicioRealizado) {
            System.out.println(" ");
            System.out.println("No hay vehiculos disponibles para este servicio.");
        }
    }

    /**
     * Busca un vehiculo registrado en una lista mediante el atributo de su patente.
     * Valida que la lista de vehiculos no este vacia.
     * Se permite realizar nuevos intentos si la patente solicitada no existe o no es una entrada valida.
     * 
     * @param scanner lector de datos ingresados por consola
     * @param listaVehiculos lista de los vehiculos registrado
     */
    private static void buscarPorPatente(Scanner scanner,
            ArrayList<Vehiculo> listaVehiculos) {
        
        if(listaVehiculos.isEmpty()){
            System.out.println(" ");
            System.out.println("No hay vehiculos registrados aun.");
            return; 
        }
        
        String patenteBuscada;

        while (true) {
            System.out.print("Ingrese la patente que desea buscar (0 para volver): ");
            patenteBuscada = scanner.nextLine().trim().toUpperCase();

            if (patenteBuscada.equals("0")) {
                break;
            }

            if (patenteBuscada.isBlank()) {
                System.out.println("ERROR. La patente no puede estar vacia.");
                continue;
            }

            if (patenteBuscada.length() != 6 && patenteBuscada.length() != 7) {
                System.out.println("ERROR. La patente debe tener 6 o 7 caracteres.");
                continue;
            }

            boolean patenteEncontrada = false;

            for (Vehiculo vehiculo : listaVehiculos) {
                if (vehiculo.getPatente().equals(patenteBuscada)) {
                    System.out.println(" ");
                    System.out.println("Patente encontrada: ");
                    vehiculo.mostrarInformacion();
                    patenteEncontrada = true;
                    break;
                }
            }

            if (!patenteEncontrada) {
                System.out.println("La patente ingresada no coincide con un vehiculo registrado.");
                continue;
            }

            break;
        }
    }

    /**
     * Muestra los vehiculos los cuales su capacidad de pasajeros supera el valor ingresado por un usuario en consola.
     * Valida que la lista de vehiculos no este vacia.
     * 
     * @param scanner lector de datos ingresados por consola
     * @param listaVehiculos lista de los vehiculos registrado
     */
    private static void buscarPorCapacidad(Scanner scanner,
            ArrayList<Vehiculo> listaVehiculos) {
        
        if(listaVehiculos.isEmpty()){
            System.out.println(" ");
            System.out.println("No hay vehiculos registrados aun.");
            return; 
        }
        
        int capacidadBase;

        while (true) {
            try {
                System.out.print("Ingrese la capacidad de pasajeros minima: ");
                capacidadBase = Integer.parseInt(scanner.nextLine());

                if (capacidadBase < 0) {
                    System.out.println("ERROR. La capacidad no puede ser negativa.");
                    continue;
                }

                break;

            } catch (NumberFormatException e) {
                System.out.println("ERROR. Debe ingresar un numero entero.");
            }
        }

        boolean capacidadEncontrada = false;

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getCapacidadPasajeros() > capacidadBase) {
                System.out.println(" ");
                System.out.println("Vehiculo:");
                vehiculo.mostrarInformacion();
                System.out.println("---------------------------------");
                capacidadEncontrada = true;
            }
        }

        if (!capacidadEncontrada) {
            System.out.println("No hay vehiculos con capacidad mayor a " + capacidadBase + " pasajeros");
        }
    }

    /**
     * Ordena y muestra los vehiculos por año de fabricacion de forma descendente.
     * Valida que la lista de vehiculos no este vacia.
     * 
     * @param listaVehiculos lista de los vehiculos registrado
     */
    private static void ordenarPorAnio(ArrayList<Vehiculo> listaVehiculos) {
        
        if (listaVehiculos.isEmpty()){
            System.out.println(" ");
            System.out.println("No hay vehiculos registrados aun.");
            return;
        }
        
        Collections.sort(listaVehiculos);

        System.out.println("=== VEHICULOS ORDENADOS POR AÑO DESCENDENTE ===");

        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(" ");
            vehiculo.mostrarInformacion();
            System.out.println("---------------------------------");
        }
    }
    
    /**
     * Ordena y muestra los vehiculos por capacidad de pasajeros de forma descendente.
     * Valida que la lista de vehiculos no este vacia.
     * 
     * @param listaVehiculos lista de los vehiculos registrados
     */
    private static void ordenarPorCapacidad(ArrayList<Vehiculo> listaVehiculos) {
        
        if (listaVehiculos.isEmpty()){
            System.out.println(" ");
            System.out.println("No hay vehiculos registrados aun.");
            return;
        }
        Collections.sort(listaVehiculos, new VehiculoCapacidadComparador());

        System.out.println("=== VEHICULOS ORDENADOS POR CAPACIDAD DESCENDENTE ===");

        for (Vehiculo vehiculo : listaVehiculos) {
            System.out.println(" ");
            vehiculo.mostrarInformacion();
            System.out.println("---------------------------------");
        }
    }
}