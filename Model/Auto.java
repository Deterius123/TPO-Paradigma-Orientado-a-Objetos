
import java.util.*;

public abstract class Auto{

    private int kilometraje;

    private EstadosDelAuto estadoDeCompra;

    private int modelo;

    private String marca;

    private int precioLista;

    public Auto(int kilometraje, String marca, int modelo, int precioLista){
        this.kilometraje = kilometraje;
        this.marca = marca;
        this.modelo = modelo;
        this.precioLista = precioLista;
        this.estadoDeCompra = EstadosDelAuto.A_LA_VENTA;
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

    public EstadosDelAuto getEstadoDeCompra() {
        return estadoDeCompra;
    }

    public void setEstadoDeCompra(EstadosDelAuto estadoDeCompra) {
        this.estadoDeCompra = estadoDeCompra;
    }
}