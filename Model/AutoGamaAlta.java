public class AutoGamaAlta extends Auto {

    public AutoGamaAlta(int kilometraje, String marca, int modelo, int precioLista, Agencia agencia) {
        super(kilometraje, marca, modelo, precioLista, agencia);
    }

    public void intentarComprar(Cliente cliente) {
        double precioFinal = calcularPrecio();

        // Si el cliente tiene tarjeta y su presupuesto cubre el precio final
        if (cliente.isTarjeta() && cliente.getPresupuesto() >= precioFinal) {
            System.out.println("El cliente puede comprar el auto de gama alta usando tarjeta. Precio final: " + precioFinal);
            decidirComprar();
        }
        // el cliente no puede comprar autos de alta gama con efectivo
        // Si el cliente no tiene suficiente presupuesto para comprar el auto
        else {
            System.out.println("El cliente no tiene suficiente presupuesto para este auto de gama alta.");
        }
    }

    @Override
    public double calcularPrecio() {
        double precioVerdadero= getPrecioLista();
        precioVerdadero *= 1.20;
        return precioVerdadero;
        // Se aplica un 20% extra al precio de lista
    }
}
