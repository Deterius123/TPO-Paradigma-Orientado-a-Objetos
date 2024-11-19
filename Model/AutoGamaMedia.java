public class AutoGamaMedia extends Auto {

    public AutoGamaMedia(int kilometraje, String marca, int modelo, int precioLista) {
        super(kilometraje, marca, modelo, precioLista);
    }

    public void intentarComprar(Cliente cliente) {
        double precioFinal = calcularPrecio();

        // Si el cliente tiene tarjeta y su presupuesto cubre el precio final
        if (cliente.isTarjeta() && cliente.getPresupuesto() >= precioFinal) {
            System.out.println("El cliente puede comprar el auto usando tarjeta. Precio final: " + precioFinal);
            this.setEstadoDeCompra(EstadosDelVehiculo.VENDIDO); // Cambia el estado a vendido
        }
        // Si el cliente no tiene tarjeta pero tiene el presupuesto suficiente para pagar
        // en efectivo si le sumamos un 5% extra al precio de lista
        else if (!cliente.isTarjeta() && cliente.getPresupuesto() >= (this.getPrecioLista() * 1.05)) {
            System.out.println("El cliente puede comprar el auto en efectivo. Precio: " + this.getPrecioLista());
            this.setEstadoDeCompra(EstadosDelVehiculo.VENDIDO); // Cambia el estado a vendido
        }
        // Si el cliente no tiene suficiente presupuesto para comprar el auto
        else {
            System.out.println("El cliente no tiene suficiente presupuesto para este auto.");
        }
    }

    @Override
    public double calcularPrecio() {
        double precioVerdadero = getPrecioLista();
        precioVerdadero *= 1.10;
        return precioVerdadero;
        // Se aplica un 10% extra al precio de lista
    }


}

