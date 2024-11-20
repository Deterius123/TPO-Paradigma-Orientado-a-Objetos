package Model;

import java.util.Scanner;

public class Moto implements Valuable{

    private EstadosDelVehiculo estadoDeCompra;

    private int modelo;

    private String marca;

    private int precioLista;

    private TiposDeMoto tipo;

    public Moto(int modelo, String marca, int precioLista, TiposDeMoto tipo) {
        this.estadoDeCompra = EstadosDelVehiculo.A_LA_VENTA;
        this.modelo = modelo;
        this.marca = marca;
        this.precioLista = precioLista;
        this.tipo = tipo;
    }

    public EstadosDelVehiculo getEstadoDeCompra() {
        return estadoDeCompra;
    }

    public void setEstadoDeCompra(EstadosDelVehiculo estadoDeCompra) {
        this.estadoDeCompra = estadoDeCompra;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecioLista() {
        return precioLista;
    }

    public void setPrecioLista(int precioLista) {
        this.precioLista = precioLista;
    }

    public TiposDeMoto getTipo() {
        return tipo;
    }

    public void setTipo(TiposDeMoto tipo) {
        this.tipo = tipo;
    }

    public void intentarComprar(Cliente cliente) {
        double precioFinal = calcularPrecio();

        if (cliente.isTarjeta() && cliente.getPresupuesto() >= precioFinal) {
            System.out.println("El cliente puede comprar la moto usando tarjeta. Precio final: " + precioFinal);
            this.setEstadoDeCompra(EstadosDelVehiculo.VENDIDO); // Cambia el estado a vendido

        } else if (!cliente.isTarjeta() && cliente.getPresupuesto() >= precioLista) {
            System.out.println("El cliente puede comprar la moto en efectivo. Precio: " + precioLista);
            this.setEstadoDeCompra(EstadosDelVehiculo.VENDIDO); // Cambia el estado a vendido
        }else {
            System.out.println("El cliente no tiene suficiente presupuesto para esta moto.");
        }
    }

    @Override
    public void decidirComprar(){
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("¿Quiere comprar el moto? (0 para si, 1 para no):");
            String decision = sc.nextLine();
            int numero = Integer.parseInt(decision);
            if (numero == 1) {
                System.out.println("Decidio no comprar el moto");
                break;
            }else if(numero == 0){
                System.out.println("Decidio comprar el moto");
                this.setEstadoDeCompra(EstadosDelVehiculo.VENDIDO); // Cambia el estado a vendido
                break;
            }else{
                System.out.println("Ingresó un numero incorrecto, intente nuevamente");
            }
        }
    }


    @Override
    public double calcularPrecio() {
        double precioVerdadero = precioLista;
        if(tipo == TiposDeMoto.DEPORTIVA){
            precioVerdadero = precioLista * 1.25;
        } else if (tipo == TiposDeMoto.SCOOTER) {
            precioVerdadero = precioLista * 1.15;
        } else {
            precioVerdadero = precioLista * 1.05;
        }
        return precioVerdadero;
    }
}