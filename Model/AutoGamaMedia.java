public class AutoGamaMedia extends Auto {

    public AutoGamaMedia(int kilometraje, String marca, int modelo, int precioLista) {
        super(kilometraje, marca, modelo, precioLista);
    }


    public void intentarComprar(Cliente cliente) {
        double precioFinal = this.getPrecioLista() * 1.10; // Se aplica un 10% extra al precio de lista


        if (cliente.isTarjeta() && cliente.getPresupuesto() >= precioFinal) {
            System.out.println("El cliente puede comprar el auto usando tarjeta. Precio final: " + precioFinal);
            this.setEstadoDeCompra(EstadosDelAuto.VENDIDO); // Cambia el estado a vendido
        }

        else if (!cliente.isTarjeta() && cliente.getPresupuesto() >= this.getPrecioLista()) {
            System.out.println("El cliente puede comprar el auto en efectivo. Precio: " + this.getPrecioLista());
            this.setEstadoDeCompra(EstadosDelAuto.VENDIDO); // Cambia el estado a vendido
        }
        // Si el cliente no tiene suficiente presupuesto para comprar el auto
        else {
            System.out.println("El cliente no tiene suficiente presupuesto para este auto.");
        }
    }
}

