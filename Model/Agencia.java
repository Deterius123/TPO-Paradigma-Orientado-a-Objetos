package Model;

import java.util.*;

public class Agencia {

        public Agencia() {
            List<Auto> listaAutos = new ArrayList<>();
            List<Moto> listaMotos = new ArrayList<>();
        }

        public void mostrarAutos() {
            System.out.println("Lista de autos:");
            for (Auto auto: listaAutos) {
                System.out.println(auto);
            }
        }

        public void mostrarMotos(){
            System.out.println("Lista de motos:");
            for (Moto moto: listaMotos){
                System.out.println(moto);
            }
        }
        public List<Auto> getListaAutos() {
            return listaAutos;
        }

        public List<Moto> getListaMotos() {
            return listaMotos;
        }
//---------------------------------------------------------------------------------------------------------------------------------------

        private List<Auto> listaAutos; // Lista donde estaran almacenados los autos ingresados

        private List<Moto> listaMotos; //Lista donde estaran almacenados las motos ingresadas
//---------------------------------------------------------------------------------------------------------------------------------------
        // Este metodo va a filtrar los autos menores a cierto precio
        public void filtrarAutosMenoresDe(int precio) {
            List<Auto> autosMenores = new ArrayList<>();  // Lista para autos menores o iguales al precio

            double limitePresupuesto = precio * 1.10; // Calcula el límite superior (10% más del precio ingresado)
//---------------------------------------------------------------------------------------------------------------------------------------
            for (Auto auto : listaAutos) { // Recorre todos los autos de la lista
                // Si el precio del auto es menor o igual al ingresado
                if (auto.getPrecioLista() <= precio) {
                    autosMenores.add(auto);
                }
            }
            // Verifica si la lista de motos menores a cierto precio está vacia,
            // si lo está avisa mostrando un mensaje en pantalla.
                if (autosMenores.isEmpty()){
                    System.out.println("No se encontraron autos menores a ese precio");
                }else{ // Si no está vacia devuelve la lista entera.
                    for (int i = 0; i < autosMenores.size(); i++) {
                        System.out.println((i + 1) + ". " + autosMenores.get(i));
                    }
                }
        }

    //---------------------------------------------------------------------------------------------------------------------------------------
    // Este metodo va a filtrar las motos menores a cierto precio
    public void filtrarMotosMenoresDe(int precio) {
        List<Moto> motosMenores = new ArrayList<>();  // Lista para motos menores o iguales al precio

        double limitePresupuesto = precio * 1.10; // Calcula el límite superior (10% más del precio ingresado)
//---------------------------------------------------------------------------------------------------------------------------------------
        for (Moto moto : listaMotos) { // Recorre todos los autos de la lista
            // Si el precio de la moto es menor o igual al ingresado
            if (moto.getPrecioLista() <= precio) {
                motosMenores.add(moto);
            }
        }
        // Verifica si la lista de motos menores a cierto precio está vacia,
        // si lo está avisa mostrando un mensaje en pantalla.
        if (motosMenores.isEmpty()){
            System.out.println("No se encontraron motos menores a ese precio");
        }else{ // // Si no está vacia, devuelve lo que tiene en el momento.
            for (int i = 0; i < motosMenores.size(); i++) {
                System.out.println((i + 1) + ". " + motosMenores.get(i));
            }
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------------
        // Metodo para filtrar autos por modelo.
        public void filtrarAutosPorModelo(int modelo) {
            List<Auto> autosPorModelo = new ArrayList<>(); //Lista para autos del modelo que buscamos
            //Si el auto es del modelo que buscamos se le agrega a la lista
            for (Auto auto : listaAutos) {
                if (auto.getModelo() == (modelo)) {
                    autosPorModelo.add(auto);
                }
            }
                if (autosPorModelo.isEmpty()){  // Se verifica si la lista de autos por modelo está vacia devuelve un mensaje por pantalla.
                    System.out.println("No se encontraron autos de ese modelo");
                }else{  // Si no está vacia, devuelve lo que tiene en el momento.
                    for (int i = 0; i < autosPorModelo.size(); i++) {
                        System.out.println((i + 1) + ". " + autosPorModelo.get(i));
                    }
                }
        }
    //---------------------------------------------------------------------------------------------------------------------------------------

        // Simplemente agrega un auto ingresado a la listaAutos.
        public void agregarAuto(Auto auto) {
            listaAutos.add(auto);
        }

    // Simplemente agrega una moto ingresado a la listaMotos.
    public void agregarMoto(Moto moto) {
        listaMotos.add(moto);
    }

    //---------------------------------------------------------------------------------------------------------------------------------------
    // Metodo para filtrar motos por modelo.
    public void filtrarMotosPorModelo(int modelo) {
        List<Moto> motosPorModelo = new ArrayList<>(); //Lista para motos del modelo que buscamos
        //Si la moto es del modelo que buscamos se le agrega a la lista
        for (Moto moto : listaMotos) {
            if (moto.getModelo() == (modelo)) {
                motosPorModelo.add(moto);
            }
        }
        // Se verifica si la lista de motos por modelo está,
        // si lo esta avisa devolviendo un mensaje por pantalla.
        if (motosPorModelo.isEmpty()){
            System.out.println("No se encontraron motos de ese modelo");
        }else{  // Si no está vacia, devuelve lo que tiene en el momento.
            for (int i = 0; i < motosPorModelo.size(); i++) {
                System.out.println((i + 1) + ". " + motosPorModelo.get(i));
            }
        }
    }

//---------------------------------------------------------------------------------------------------------------------------------------
        // Metodo para sugerir los 3 autos con menor diferencia respecto al presupuesto
        public void sugerirAutoParaCliente(Cliente cliente) {

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
            }// Se verifica si la lista de autos dentro del rango de precio está vacia devuelve un mensaje por pantalla.
            if (autosEnRango.isEmpty()) {
                System.out.println("No existen autos para sugerir a este cliente");
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

                    for (int i = 0; i < 3; i++) {
                        System.out.println((i + 1) + ". " + listaAutos.get(i));
                    }
                    // Los parametros subList(Parametro de inicio, parametro de fin) tienen esa logica, funcionan con el indice de una lista y se
                    // les aclara desde donde comienzan y hasta que elemento llegan.

                } catch (IndexOutOfBoundsException e) {
                    // Si hay menos de 3 autos, devolver la lista como está.
                    for (int i = 0; i < autosEnRango.size(); i++) {
                        System.out.println((i + 1) + ". " + autosEnRango.get(i));
                    }
                }
            }
        }

    //---------------------------------------------------------------------------------------------------------------------------------------
    // Metodo para sugerir las 3 motos con menor diferencia respecto al presupuesto
    public void sugerirMotoParaCliente(Cliente cliente) {

        int presupuesto = cliente.getPresupuesto();
        List<Moto> motosEnRango = new ArrayList<>(); // Esto va a ser una lista donde van a estar las motos que esten un 10% mayor y menor al presupuesto.

        int rangoInferior = (int) (presupuesto * 0.90); // 10% debajo del presupuesto
        int rangoSuperior = (int) (presupuesto * 1.10); // 10% encima del presupuesto

        // Filtrar los autos dentro del rango de precio
        for (Moto moto : listaMotos) {

            int precioMoto = moto.getPrecioLista(); // Esto es un getter a la lista de precios.

            // Esto verifica cada elemento que está en la listaMotos y verifica 2 menores y 1 mayor.
            if (precioMoto >= rangoInferior && precioMoto <= rangoSuperior) {
                motosEnRango.add(moto);
            }
        }// Si la lista de motos dentro del rango de precio está vacia devuelve un mensaje por pantalla.
        if (motosEnRango.isEmpty()) {
            System.out.println("No existen autos para sugerir a este cliente");
        } else {
            // Ordenar los autos por la diferencia entre su precio y el presupuesto
            motosEnRango.sort((moto1, moto2) -> {
                // La flecha "->" es una expresion lambda que especifica que los parametros
                // ingresados (moto1, moto2) van a hacer el codigo que le sigue.
                int diferencia1 = Math.abs(moto1.getPrecioLista() - presupuesto);
                int diferencia2 = Math.abs(moto2.getPrecioLista() - presupuesto);

                return Integer.compare(diferencia1, diferencia2);
            });

            // Intentar obtener las primeros 3 motos o menos si no hay suficientes motos
            try {

                // Si la lista tiene más de 3 motos, se seleccionan los primeros 3

                // Lo que hace el subList es extrar una parte de una lista creando una "sublista" ya existente.
                // Los parametros subList(Parametro de inicio, parametro de fin) tienen esa logica,
                // funcionan con el indice de una lista y se les aclara desde donde comienzan y hasta que elemento llegan.
                for (int i = 0; i < 3; i++) {
                    System.out.println((i + 1) + ". " + motosEnRango.get(i));
                }
            } catch (IndexOutOfBoundsException e) {
                // Si hay menos de 3 motos, devolver la lista como está.
                for (int i = 0; i < motosEnRango.size(); i++) {
                    System.out.println((i + 1) + ". " + motosEnRango.get(i));
                }
            }
        }
    }




    //---------------------------------------------------------------------------------------------------------------------------------------
            // Metodo para filtrar autos por marca.
    public void filtrarAutosPorMarca (String marca){

            List<Auto> autosPorMarca = new ArrayList<>(); // Lista para autos que sean de la marca que buscamos

        // Si la marca es igual a la buscada se la agrega a la lista
        // toUpperCase() se asegura que la marca empiece en mayuscula
        for (Auto auto : listaAutos) {
            if (auto.getMarca().equals(mayusculaPrimeraLetra(marca))) {
                        autosPorMarca.add(auto);
            }
        }
        if (autosPorMarca.isEmpty()){   // Se verifica si la lista de autos por marca está vacia devuelve un mensaje por pantalla.
            System.out.println("No se encontro ningun auto con esa marca");
        }else { // Si no está vacia, devuelve lo que tiene en el momento.
            for (int i = 0; i < autosPorMarca.size(); i++) {
                System.out.println((i + 1) + ". " + autosPorMarca.get(i));
            }
            }
        }

    //---------------------------------------------------------------------------------------------------------------------------------------
    // Metodo para filtrar motos por marca.
    public void filtrarMotosPorMarca (String marca){

        List<Moto> motosPorMarca = new ArrayList<>(); // Lista para motos que sean de la marca que buscamos

        // Si la marca es igual a la buscada se la agrega a la lista
        // toUpperCase() se asegura que la marca empiece en mayuscula
        for (Moto moto : listaMotos) {
            if (moto.getMarca().equals(mayusculaPrimeraLetra(marca))) {
                motosPorMarca.add(moto);
            }
        }
        if (motosPorMarca.isEmpty()){   // Se verifica si la lista de motos por marca está vacia devuelve un mensaje por pantalla.
            System.out.println("No se encontro ninguna moto con esa marca");
        }else { // Si no está vacia, devuelve lo que tiene en el momento.
            for (int i = 0; i < motosPorMarca.size(); i++) {
                System.out.println((i + 1) + ". " + motosPorMarca.get(i));
            }
        }
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    private String mayusculaPrimeraLetra(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto; // Retorna el texto original si es nulo o vacío
        }
        return texto.substring(0, 1).toUpperCase() + texto.substring(1); // Convierte la primera letra
    }
    //---------------------------------------------------------------------------------------------------------------------------------------

}