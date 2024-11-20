import Model.*;

import java.util.List;
import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {

        List<Auto> listaAutos = new ArrayList<>();
        List<Cliente> listaClientes = new ArrayList<>();
        List<Moto> listaMotos = new ArrayList<>();


        // Creamos instancia de agencia.
        Agencia agenciaPrueba = new Agencia(listaAutos, listaClientes, listaMotos);

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
        Cliente cliente1 = new Cliente(100000, 123, true);

        // Mostramos la lista de autos y motos disponibles.
        agenciaPrueba.mostrarAutos();

        agenciaPrueba.mostrarMotos();
    }
}
