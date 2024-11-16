
import java.util.*;

public class Agencia {

    public Agencia(){
    }
    //---------------------------------------------------------------------------------------------------------------------------------------
    private int precioLista;

    private List<Auto> listaAutos; // Lista donde estaran almacenados los autos ingresados

    private List<Cliente> listaClientes; // NO SE USA POR AHORA


    //---------------------------------------------------------------------------------------------------------------------------------------
    public Object sugerirAutoParaCliente() {
        return null;
    }

    public list filtrarAutosPorMarca() {
        return null;
    }

//---------------------------------------------------------------------------------------------------------------------------------------
// Este metodo va a filtrar los autos menores a cierto precio y mostrara los primeros 3 autos menores al precio y 2 mayores por un 10%
    public List<Auto> filtrarAutosMenoresDe(int precio) {

        List<Auto> autosFiltrados = new ArrayList<>(); // Lista principal para devolver los resultados
        List<Auto> autosMenores = new ArrayList<>();  // Lista para autos menores o iguales al precio
        List<Auto> autosMayores = new ArrayList<>();  // Lista para autos mayores pero dentro del 10%

        double limite = precio * 1.10; // Calcula el límite superior (10% más del precio ingresado)

//---------------------------------------------------------------------------------------------------------------------------------------
        for (Auto auto : listaAutos) { // Recorre todos los autos de la lista
            // Si el precio del auto es menor o igual al ingresado y aún hay espacio para menores
            if (autosMenores.size() < 3 && auto.getPrecioLista() <= precio) {
                autosMenores.add(auto);

            // Si el precio del auto está entre el precio ingresado y el 10% adicional
            } else if (autosMayores.size() < 2 && auto.getPrecioLista() > precio && auto.getPrecioLista() <= limite) {
                autosMayores.add(auto);
            }

            // Rompe el bucle si ya se tienen los autos necesarios
            if (autosMenores.size() == 3 && autosMayores.size() == 2) {
                break;
            }
        }
        // Combina los resultados de ambas listas en la lista principal
        autosFiltrados.addAll(autosMenores);
        autosFiltrados.addAll(autosMayores);

        return autosFiltrados; // Devuelve la lista combinada
    }
//---------------------------------------------------------------------------------------------------------------------------------------
    public list filtrarAutosPorModelo() {
        return null;
    }

}