import Model.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;


public class Main {

    public static void main(String[] args) {


        // Creamos instancia de agencia.
        Agencia agenciaPrueba = new Agencia();

        // Creamos algunos autos y los agregamos a agencia.

        // Gama baja
        Auto auto1 = new AutoGamaBaja(0, "Ford", 2020, 50000, agenciaPrueba);
        Auto auto2 = new AutoGamaBaja(100, "Chevrolet", 2018, 45000, agenciaPrueba);
        Auto auto3 = new AutoGamaBaja(250, "Toyota", 2021, 60000, agenciaPrueba);
        Auto auto4 = new AutoGamaBaja(334, "Honda", 2019, 48000, agenciaPrueba);
        Auto auto5 = new AutoGamaBaja(499, "Nissan", 2022, 55000, agenciaPrueba);
        // Gama media
        Auto auto6 = new AutoGamaMedia(150, "BMW", 2018, 85000, agenciaPrueba);
        Auto auto7 = new AutoGamaMedia(456, "Audi", 2019, 90000, agenciaPrueba);
        Auto auto8 = new AutoGamaMedia(789, "Mercedes-Benz", 2020, 95000, agenciaPrueba);
        Auto auto9 = new AutoGamaMedia(90, "Lexus", 2017, 87000, agenciaPrueba);
        Auto auto10 = new AutoGamaMedia(15, "Volvo", 2021, 88000, agenciaPrueba);
        // Gama alta
        Auto auto11 = new AutoGamaAlta(500, "Mercedes", 1999, 100000, agenciaPrueba);
        Auto auto12 = new AutoGamaAlta(99, "Ferrari", 2021, 250000, agenciaPrueba);
        Auto auto13 = new AutoGamaAlta(250, "Lamborghini", 2020, 300000, agenciaPrueba);
        Auto auto14 = new AutoGamaAlta(100, "Rolls-Royce", 2018, 400000, agenciaPrueba);
        Auto auto15 = new AutoGamaAlta(345, "Porsche", 2019, 150000, agenciaPrueba);
        // Moto
        Moto moto1 = new Moto(2020, "Yamaha", 100000, TiposDeMoto.DEPORTIVA, agenciaPrueba);
        Moto moto2 = new Moto(2021, "Honda", 120000, TiposDeMoto.SCOOTER, agenciaPrueba);
        Moto moto3 = new Moto(2019, "Suzuki", 95000, TiposDeMoto.DOBLE_PROPOSITO, agenciaPrueba);
        Moto moto4 = new Moto(2022, "Kawasaki", 150000, TiposDeMoto.DEPORTIVA, agenciaPrueba);
        Moto moto5 = new Moto(2020, "BMW", 200000, TiposDeMoto.DOBLE_PROPOSITO, agenciaPrueba);
        Moto moto6 = new Moto(2021, "Harley-Davidson", 250000, TiposDeMoto.DEPORTIVA, agenciaPrueba);
        Moto moto7 = new Moto(2018, "Ducati", 180000, TiposDeMoto.SCOOTER, agenciaPrueba);
        Moto moto8 = new Moto(2022, "Triumph", 220000, TiposDeMoto.DOBLE_PROPOSITO, agenciaPrueba);
        Moto moto9 = new Moto(2021, "Aprilia", 170000, TiposDeMoto.SCOOTER, agenciaPrueba);
        Moto moto10 = new Moto(2023, "KTM", 210000, TiposDeMoto.DEPORTIVA, agenciaPrueba);


        // Creamos un cliente y un presupuesto y lo añadimos a la agencia.
        Cliente cliente1 = new Cliente(45000, 123, true);

        //---------------------------------------------------------------------------------------------------------------------------------------
        Scanner scanner = new Scanner(System.in);

        System.out.println("¡Bienvenido a la agencia!");

        boolean salir = false;
        while (!salir) {
            System.out.println("\nOpciones:");
            System.out.println("1. Ver lista de autos");
            System.out.println("2. Ver lista de motos");
            System.out.println("3. Seleccionar y verificar compra de auto o moto");
            System.out.println("4. Salir");
            int opcion = -1; // Valor predeterminado inválido
            boolean valido = false;
            // Validamos que la opción ingresada sea un número entero
            while (!valido) {
                System.out.print("Elige una opción: ");
                try {
                    opcion = scanner.nextInt();
                    valido = true;  // Si no ocurre ninguna excepción, la entrada es válida
                } catch (InputMismatchException e) {
                    System.out.println("Opción inválida. Por favor, ingresa un número válido.");
                    scanner.nextLine(); // Limpiar el buffer para evitar un ciclo infinito de excepciones
                }
            }
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    // Mostrar autos por diferentes filtros
                    mostrarAutosPorFiltros(agenciaPrueba);
                    break;

                case 2:
                    // Mostrar motos por diferentes filtros
                    mostrarMotosPorFiltros(agenciaPrueba);
                    break;

                case 3:
                    // Seleccionar y verificar compra
                    System.out.println("Selecciona '1' para auto o '2' para moto: ");
                    int tipoSeleccionado = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (tipoSeleccionado == 1) {
                        // Selección de auto
                        seleccionarAuto(agenciaPrueba, cliente1);
                    } else if (tipoSeleccionado == 2) {
                        // Selección de moto
                        seleccionarMoto(agenciaPrueba, cliente1);
                    } else {
                        System.out.println("Opción inválida.");
                    }

                    break;

                case 4:
                    salir = true;
                    break;

                default:
                    System.out.println("Opción inválida. Intenta nuevamente.");
            }
        }

        scanner.close();
        System.out.println("¡Gracias por visitar la agencia!");
    }

    // Metodo para mostrar autos según los filtros seleccionados
    private static void mostrarAutosPorFiltros(Agencia agencia) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFiltros disponibles para autos:");
        System.out.println("1. Ver por marca");
        System.out.println("2. Ver por modelo");
        System.out.println("3. Ver por precio menor a");
        System.out.print("Elige un filtro: ");
        int filtro = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (filtro) {
            case 1:
                System.out.print("Ingresa la marca: ");
                String marca = scanner.nextLine();
                agencia.filtrarAutosPorMarca(marca);
                return;

            case 2:
                System.out.print("Ingresa el modelo: ");
                int modelo = scanner.nextInt();
                agencia.filtrarAutosPorModelo(modelo);
                return;

            case 3:
                System.out.print("Ingresa el precio máximo: ");
                int precioMaximo = scanner.nextInt();
                agencia.filtrarAutosMenoresDe(precioMaximo);
                return;

            default:
                System.out.println("Filtro inválido.");
        }
    }

    // Metodo para mostrar motos según los filtros seleccionados
    private static void mostrarMotosPorFiltros(Agencia agencia) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nFiltros disponibles para motos:");
        System.out.println("1. Ver por marca");
        System.out.println("2. Ver por modelo");
        System.out.println("3. Ver por precio menor a");
        System.out.print("Elige un filtro: ");
        int filtro = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        switch (filtro) {
            case 1:
                System.out.print("Ingresa la marca: ");
                String marca = scanner.nextLine();
                agencia.filtrarMotosPorMarca(marca);
                return;


            case 2:
                System.out.print("Ingresa el modelo: ");
                int modelo = scanner.nextInt();
                agencia.filtrarMotosPorModelo(modelo);
                return;

            case 3:
                System.out.print("Ingresa el precio máximo: ");
                int precioMaximo = scanner.nextInt();
                agencia.filtrarMotosMenoresDe(precioMaximo);
                return;

            default:
                System.out.println("Filtro inválido.");
        }
    }

    // Metodo para seleccionar un auto y verificar la compra
    private static void seleccionarAuto(Agencia agencia, Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        List<Auto> listaAutos = agencia.getListaAutos();  // Obtener la lista de autos desde la agencia
        System.out.println("Selecciona un auto para comprar (ingresa el número): ");
        for (int i = 0; i < listaAutos.size(); i++) {
            System.out.println((i + 1) + ". " + listaAutos.get(i));
        }

        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= listaAutos.size()) {
            Auto auto = listaAutos.get(seleccion - 1);
            auto.intentarComprar(cliente);
        } else {
            System.out.println("Selección inválida.");
        }
    }


    // Metodo para seleccionar una moto y verificar la compra
    private static void seleccionarMoto(Agencia agencia, Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        List<Moto> listaMotos = agencia.getListaMotos();  // Obtener la lista de motos desde la agencia
        System.out.println("Selecciona una moto para comprar (ingresa el número): ");
        for (int i = 0; i < listaMotos.size(); i++) {
            System.out.println((i + 1) + ". " + listaMotos.get(i));
        }

        int seleccion = scanner.nextInt();
        if (seleccion > 0 && seleccion <= listaMotos.size()) {
            Moto moto = listaMotos.get(seleccion - 1);
            moto.intentarComprar(cliente);
        } else {
            System.out.println("Selección inválida.");
        }
    }

}