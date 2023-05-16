import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Car {

    String marca;
    String modelo;
    String placa;
    Cliente dueño;

    public Car(String Marca, String Modelo, String Placa, Cliente Dueño) {
        this.marca = Marca;
        this.modelo = Modelo;
        this.placa = Placa;
        this.dueño = Dueño;
    }
}

class Cliente {

    String nombre;
    String cedula;
    String telefono;

    public Cliente(String Nombre, String Cedula, String Telefono) {
        this.nombre = Nombre;
        this.cedula = Cedula;
        this.telefono = Telefono;
    }
}

class Servicio {

    String servicio;
    int precio;
    String duracion;

    public Servicio(String Servicio, int Precio, String Duracion) {
        this.servicio = Servicio;
        this.precio = Precio;
        this.duracion = Duracion;
    }
}

class Reparacion {

    Car carrito;
    Servicio servicio;
    Factura factura;
    String estado;

    public Reparacion(Car Carrito, Servicio Servicio, Factura Factura, String Estado) {
        this.carrito = Carrito;
        this.servicio = Servicio;
        this.factura = Factura;
        this.estado = Estado;
    }
}

class Factura {

    Cliente cliente;
    Car carro;
    double impuestos;
    double total;

    public Factura(Car Carro, double Impuestos, double Total) {
        this.carro = Carro;
        this.impuestos = Impuestos;
        this.total = Total;
    }
}

class Pieza {

    String nombre;
    int cantidad;
    int precio;

    public Pieza(String Nombre, int Cantidad, int Precio) {
        this.nombre = Nombre;
        this.cantidad = Cantidad;
        this.precio = Precio;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getPrecio(){
        return this.precio;
    }

    public int getCantidad(){
        return this.cantidad;
    }
}

public class Main {

    public static void main(String[] args) {

        // Creacion de servicios
        Servicio Servicio1 = new Servicio("Cambio de Aceite", 60000, "5 horas");
        Servicio Servicio2 = new Servicio("Reemplazo de frenos", 150000, "1 dia");
        Servicio Servicio3 = new Servicio("Cambio de neumáticos", 200000, "2 horas");
        Servicio Servicio4 = new Servicio("Reparacion de transmisión", 230000, "3 dias");

        // Creacion de piezas
        Pieza pieza1 = new Pieza("Disco de frenos", 30, 67500);
        Pieza pieza2 = new Pieza("Bateria", 16, 115000);
        Pieza pieza3 = new Pieza("Llantas x4", 8, 850000);

        List<Car> cars = new ArrayList<>();
        List<Factura> factRep = new ArrayList<>();
        List<Cliente> clientes = new ArrayList<>();
        List<Reparacion> RepCur = new ArrayList<>();
        List<Pieza> Pinv = new ArrayList<>();

        Pinv.add(pieza1);
        Pinv.add(pieza2);
        Pinv.add(pieza3);

        while (true) {
            String opcion = mostrarMenu();

            if (opcion.equals("1")) {
                System.out.println("------------Ingrese los datos del cliente------------");
                Scanner sc = new Scanner(System.in);
                System.out.print("Ingrese el nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el numero de cedula: ");
                String cedula = sc.nextLine();
                System.out.print("Ingrese un telefono de contacto: ");
                String telefono = sc.nextLine();

                Cliente cliente = new Cliente(nombre, cedula, telefono);
                clientes.add(cliente);

                System.out.println();
                System.out.print("Ingrese la placa: ");
                String placa = sc.nextLine();
                System.out.print("Ingrese la marca: ");
                String marca = sc.nextLine();
                System.out.print("Ingrese el modelo: ");
                String modelo = sc.nextLine();

                Car carrito = new Car(marca, modelo, placa, cliente);
                cars.add(carrito);
                System.out.println("------------Bienvenido al servicio de reparacion y mantenimiento de Pepes Garage------------ ");
                System.out.println("1. Cambio de aceite");
                System.out.println("2. Reemplazo de frenos");
                System.out.println("3. Cambio de neumáticos");
                System.out.println("4. Reparación de transmisión");

                int opcionServicio = sc.nextInt();
                if (opcionServicio == 1) {
                    Servicio servicio = Servicio1; // para crear la reparacion
                    double impuestos = servicio.precio * (19.0 / 100);
                    double total = servicio.precio + impuestos;
                
                    Factura facturita = new Factura(carrito, impuestos, total);
                    factRep.add(facturita);

                    Reparacion reparacion = new Reparacion(carrito, servicio, facturita, "En curso");
                    RepCur.add(reparacion);

                    System.out.printf("La factura creada fue -Carro: %s -impuestos: %.2f -total: %.2f%n", facturita.carro.placa, facturita.impuestos, facturita.total);
                    System.out.printf("El servicio contratado fue -Servicio %s - Dueño %s - El costo por el servicio sin impuestos es: %d%n", servicio.servicio, facturita.carro.dueño.nombre, servicio.precio);
                }

                if (opcionServicio == 2) {
                    Servicio servicio = Servicio2; // para crear la reparación
                    double impuestos = Servicio2.precio * (19.0 / 100);
                    double total = Servicio2.precio + impuestos;
                    Factura facturita = new Factura(carrito, impuestos, total);
                    factRep.add(facturita);

                    Reparacion reparacion = new Reparacion(carrito, servicio, facturita, "En curso");
                    RepCur.add(reparacion);

                    System.out.printf("La factura creada fue -Carro: %s -impuestos: %.2f -total: %.2f%n", facturita.carro.placa, facturita.impuestos, facturita.total);
                    System.out.printf("El servicio contratado fue -Servicio %s - Dueño %s - El costo por el servicio sin impuestos es: %d%n", servicio.servicio, facturita.carro.dueño.nombre, servicio.precio);
                    
                }   

                if (opcionServicio == 3) {
                    Servicio servicio = Servicio3; //para crear la reparación
                    double impuestos = Servicio3.precio * (19.0 / 100.0);
                    double total = Servicio3.precio + impuestos;
                    
                    Factura facturita = new Factura(carrito, impuestos, total);
                    factRep.add(facturita);

                    Reparacion reparacion = new Reparacion(carrito, servicio, facturita, "En curso");
                    RepCur.add(reparacion);

                    System.out.printf("La factura creada fue - Carro: %s - impuestos: %s - total: %.2f%n",
                                      facturita.carro.placa, facturita.impuestos, facturita.total);
                    System.out.printf("El servicio contratado fue - Servicio %s - Dueño %s - El costo por el servicio sin impuestos es: %d%n",
                                      servicio.servicio, facturita.carro.dueño.nombre, servicio.precio);
                }

                if (opcionServicio == 4) {
                    Servicio servicio = Servicio4; //para crear la reparación
                    double impuestos = Servicio4.precio * (19.0 / 100.0);
                    double total = Servicio4.precio + impuestos;
                    
                    Factura facturita = new Factura(carrito, impuestos, total);
                    factRep.add(facturita);

                    Reparacion reparacion = new Reparacion(carrito, servicio, facturita, "En curso");
                    RepCur.add(reparacion);

                    System.out.printf("La factura creada fue - Carro: %s - impuestos: %s - total: %.2f%n",
                                      facturita.carro.placa, facturita.impuestos, facturita.total);
                    System.out.printf("El servicio contratado fue - Servicio %s - Dueño %s - El costo por el servicio sin impuestos es: %d%n",
                                      servicio.servicio, facturita.carro.dueño.nombre, servicio.precio);
                }
            }
            else if (opcion.equals("2")) {
                
                
                Scanner sc_2 = new Scanner(System.in);
                String placa = sc_2.nextLine();
                boolean bandera = false;
                for (Reparacion reparacion : RepCur) {
                    if (placa.toLowerCase().equals(reparacion.carrito.placa.toLowerCase())) {
                        bandera = true;
                        System.out.printf("La reparación del carro de placas: %s está %s\n",
                                        reparacion.carrito.placa, reparacion.estado);
                    }
                }
                if (!bandera) {
                    System.out.println("La placa ingresada no tiene reparaciones asociadas.");
                }
            }

            else if (opcion.equals("3")) {
                Scanner sc_3 = new Scanner(System.in);
                System.out.println("Ingrese el nombre de la pieza: ");
                String nombre = sc_3.nextLine();
                Pieza Parte = consultarPieza(Pinv, nombre);

            } else if (opcion.equals("4")) {
                Scanner sc_4 = new Scanner(System.in);
                System.out.println("Ingrese la placa del carro para pagar la reparacion: ");
                String placa_buscar = sc_4.nextLine();
                pagarReparacion(RepCur, placa_buscar);
            }

        


        } //corchete del while
       
    }

    public static String mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------Bienvenido al taller------------");
        System.out.println("1. Ingresar auto");
        System.out.println("2. Consultar estado de reparacion");
        System.out.println("3. Consultar partes en el inventario");
        System.out.println("4. Pagar reparacion");
        System.out.print("Por favor ingrese la opción deseada: ");
        String opcion = scanner.nextLine();
        return opcion;
    }

    public static Pieza consultarPieza(List<Pieza> Pinv, String nombrePieza) {
        for (Pieza pieza : Pinv) {
            if (pieza.getNombre().equalsIgnoreCase(nombrePieza)) {
                System.out.println("La pieza: " + pieza.getNombre() + " se encuentra disponible, su precio es: " + pieza.getPrecio() + " y las unidades en bodega son: " + pieza.getCantidad());
                return pieza;
            }
        }
        System.out.println("La pieza que buscas no existe en el inventario");
        return null;
    }
    
    public static void pagarReparacion(List<Reparacion> RepCur, String placa_carro) {
        for (Reparacion reparacion : RepCur) {
            if (reparacion.carrito.placa.toLowerCase().equals(placa_carro.toLowerCase())) {
                RepCur.remove(reparacion);
                System.out.println("Se pago la reparacion con exito");
                return;
            }
        }
        System.out.println("No existen reparaciones en curso para ese vehiculo");
    }


    // Lista para los carros que ingresan al taller
    List<Car> cars = new ArrayList<Car>();
    // Facturas de las reparaciones en curso
    List<Factura> factRep = new ArrayList<Factura>();
    // Clientes en el taller
    List<Cliente> clientes = new ArrayList<Cliente>();
    // Reparaciones en curso
    List<Reparacion> RepCur = new ArrayList<Reparacion>();
    // partes en inventario
    List<Pieza> Pinv = new ArrayList<Pieza>();

    
    
}


