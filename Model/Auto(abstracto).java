
import java.util.*;


public abstract class Auto {

    public Auto() {
    }

    private int kilometraje;

    private enum estadoDeCompra;

    private int modelo;

    private String marca;

    private int precioLista;

    public abstract void intentarComprar();

    public boolean es0KM() {
        return false;
    }

}