package imports;

public class ValidadorPedido {

    // Validación para las cajas
    public static void validarCajas(int cajas) throws PedidoInvalidoException {
        if (cajas <= 0) {
            throw new PedidoInvalidoException("La cantidad de cajas debe ser mayor a 0.");
        }
    }

    // Validación para los Kg
    public static void validarPeso(double peso) throws PedidoInvalidoException {
        if (peso <= 0) {
            throw new PedidoInvalidoException("Los kg deben ser mayores a 0.");
        }
        if (peso > 10.0) {
            throw new PedidoInvalidoException("Los kg no pueden superar los 10kg.");
        }
    }
}
