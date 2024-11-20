import java.util.Scanner;

public abstract class Auto implements Valuable{

    private int kilometraje;

    private EstadosDelVehiculo estadoDeCompra;

    private int modelo;

    private String marca;

    private int precioLista;

    private Agencia agencia;

    public Auto(int kilometraje, String marca, int modelo, int precioLista, Agencia agencia){
        this.kilometraje = kilometraje;
        this.marca = marca;
        this.modelo = modelo;
        this.precioLista = precioLista;
        this.estadoDeCompra = EstadosDelVehiculo.A_LA_VENTA;
        this.agencia = agencia;
        agencia.agregarAuto(this);
    }

    public abstract void intentarComprar(Cliente cliente);

    public boolean es0KM() {
        return kilometraje < 100;
    }

    public int getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(int kilometraje) {
        this.kilometraje = kilometraje;
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

    public EstadosDelVehiculo getEstadoDeCompra() {
        return estadoDeCompra;
    }

    public void setEstadoDeCompra(EstadosDelVehiculo estadoDeCompra) {
        this.estadoDeCompra = estadoDeCompra;
    }

    @Override
    public abstract double calcularPrecio();

    @Override
    public void decidirComprar(){
        Scanner sc= new Scanner(System.in);
        while(true){
            System.out.println("¿Quiere comprar el auto? (0 para si, 1 para no):");
            String decision = sc.nextLine();
            int numero = Integer.parseInt(decision);
            if (numero == 1) {
                System.out.println("Decidio no comprar el auto");
                break;
            }else if(numero == 0){
                System.out.println("Decidio comprar el auto");
                this.setEstadoDeCompra(EstadosDelVehiculo.VENDIDO); // Cambia el estado a vendido
                break;
            }else{
                System.out.println("Ingresó un numero incorrecto, intente nuevamente");
            }
        }
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }
}