public class AutoGamaMedia extends Auto{

    private int kilometraje;

    private enum estadoDeCompra;

    private int modelo;

    private String marca;

    private int precioBase;

    public AutoGamaMedia(int kilometraje, String marca, int modelo, int precioLista, int kilometraje1, int modelo1, String marca1, int precioBase) {
        super(kilometraje, marca, modelo, precioLista);
        this.kilometraje = kilometraje1;
        this.modelo = modelo1;
        this.marca = marca1;
        this.precioBase = precioBase;
    }

    public void intentarComprar(void Cliente) {
        return null;
    }

    public boolean es0KM() {
        return false;
    }

}