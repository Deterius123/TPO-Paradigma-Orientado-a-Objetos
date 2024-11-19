import java.util.*;

public class Agencia {

        public Agencia(List<Auto> listaAutos, List<Cliente> listaClientes) {
            this.listaAutos = listaAutos;
            this.listaClientes = listaClientes;
        }

        //---------------------------------------------------------------------------------------------------------------------------------------

        private List<Auto> listaAutos; // Lista donde estaran almacenados los autos ingresados

        private List<Cliente> listaClientes; // ---NO SE USA POR AHORA---

        //---------------------------------------------------------------------------------------------------------------------------------------
    // Este metodo va a filtrar los autos menores a cierto precio
        public List<Auto> filtrarAutosMenoresDe(int precio) {
            List<Auto> autosMenores = new ArrayList<>();  // Lista para autos menores o iguales al precio

            double limitePresupuesto = precio * 1.10; // Calcula el límite superior (10% más del precio ingresado)
    //---------------------------------------------------------------------------------------------------------------------------------------
            for (Auto auto : listaAutos) { // Recorre todos los autos de la lista
                // Si el precio del auto es menor o igual al ingresado
                if (auto.getPrecioLista() <= precio) {
                    autosMenores.add(auto);
                }
            }
                if (autosMenores.isEmpty()){
                    System.out.println("No se encontraron autos menores a ese precio");
                    return null;
                }else{
                    return autosMenores;
                }
        }

        //---------------------------------------------------------------------------------------------------------------------------------------
        public List<Auto> filtrarAutosPorModelo(int modelo) {
            List<Auto> autosPorModelo = new ArrayList<>(); //Lista para autos del modelo que buscamos
            //Si el auto es del modelo que buscamos se le agrega a la lista
            for (Auto auto : listaAutos) {
                if (auto.getModelo() == (modelo)) {
                    autosPorModelo.add(auto);
                }
            }
                if (autosPorModelo.isEmpty()){
                    System.out.println("No se encontraron autos de ese modelo");
                    return null;
                }else{
                    return autosPorModelo;
                }
        }

        public void agregarAuto(Auto auto) {
            listaAutos.add(auto);
        }

        //---------------------------------------------------------------------------------------------------------------------------------------
    // Metodo para sugerir los 3 autos con menor diferencia respecto al presupuesto
        public List<Auto> sugerirAutoParaCliente(Cliente cliente) {

            int presupuesto = cliente.getPresupuesto();
            List<Auto> autosEnRango = new ArrayList<>(); // Esto va a ser una lista donde van a estar los autos que esten un 10% mayor y menor al presupuesto.

            int rangoInferior = (int) (presupuesto * 0.90); // 10% debajo del presupuesto
            int rangoSuperior = (int) (presupuesto * 1.10); // 10% encima del presupuesto

            // Filtrar los autos dentro del rango de precio
            for (Auto auto : listaAutos) {

                int precioAuto = auto.getPrecioLista(); // Esto es un getter a la lista de precios.

                // Esto verifica cada elemento que está en la listaAutos y verifica 2 menores y 1 mayor.
                if (precioAuto >= rangoInferior && precioAuto <= rangoSuperior) {
                    autosEnRango.add(auto);
                }
            }
            if (autosEnRango.isEmpty()) {
                System.out.println("No existen autos para sugerir a este cliente");
                return null;
            } else {
                // Ordenar los autos por la diferencia entre su precio y el presupuesto
                autosEnRango.sort((auto1, auto2) -> {
                    // La flecha "->" es una expresion lambda que especifica que los parametros ingresados (auto1, auto2) van a hacer el codigo que le sigue.
                    int diferencia1 = Math.abs(auto1.getPrecioLista() - presupuesto);
                    int diferencia2 = Math.abs(auto2.getPrecioLista() - presupuesto);

                    return Integer.compare(diferencia1, diferencia2);
                });

                // Intentar obtener los primeros 3 autos o menos si no hay suficientes autos
                try {
                    // Si la lista tiene más de 3 autos, se seleccionan los primeros 3
                    return autosEnRango.subList(0, 3);
                } catch (IndexOutOfBoundsException e) {
                    // Si hay menos de 3 autos, devolver la lista completa
                    return autosEnRango;
                }
            }
        }

    //---------------------------------------------------------------------------------------------------------------------------------------
            public List<Auto> filtrarAutosPorMarca (String marca){
                List<Auto> autosPorMarca = new ArrayList<>(); // Lista para autos que sean de la marca que buscamos
                // Si la marca es igual a la buscada se la agrega a la lista
                // toUpperCase() se asegura que la marca empiece en mayuscula
                for (Auto auto : listaAutos) {
                    if (auto.getMarca().equals(marca.toUpperCase())) {
                        autosPorMarca.add(auto);
                    }
                }
                    if (autosPorMarca.isEmpty()){
                        System.out.println("No se encontro ningun auto con esa marca");
                        return null;
                    }else {
                        return autosPorMarca; //Devuelve la lista
                    }
                }
        }