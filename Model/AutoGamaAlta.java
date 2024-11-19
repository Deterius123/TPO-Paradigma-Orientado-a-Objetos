public class AutoGamaAlta extends Auto {

    public AutoGamaAlta(int kilometraje, String marca, int modelo, int precioLista) {
        super(kilometraje, marca, modelo, precioLista);
    }

    public void intentarComprar(Cliente cliente) {
        double precioFinal = this.getPrecioLista() * 1.20;

        // Si el cliente tiene tarjeta y su presupuesto cubre el precio final
        if (cliente.isTarjeta() && cliente.getPresupuesto() >= precioFinal) {
            System.out.println("El cliente puede comprar el auto de gama alta usando tarjeta. Precio final: " + precioFinal);
            this.setEstadoDeCompra(EstadosDelAuto.VENDIDO); // Cambia el estado a vendido
        }
        // Si el cliente no tiene tarjeta pero tiene el presupuesto suficiente para pagar en efectivo
        else if (!cliente.isTarjeta() && cliente.getPresupuesto() >= this.getPrecioLista()) {
            System.out.println("El cliente puede comprar el auto de gama alta en efectivo. Precio: " + this.getPrecioLista());
            this.setEstadoDeCompra(EstadosDelAuto.VENDIDO); // Cambia el estado a vendido
        }
        // Si el cliente no tiene suficiente presupuesto para comprar el auto
        else {
            System.out.println("El cliente no tiene suficiente presupuesto para este auto de gama alta.");
        }
    }
}
