/*
    Pedido: 1001
    Cliente: Juan Perez
    Canal: WEB
    Importe: 25000
*/
package main;

public class Venta {
    private int idPedido;
    private String nombreCliente;
    private MedioDeVentas medio;
    private double importe;

    public Venta(int idPedido, String nombreCliente, MedioDeVentas medio, double importe) {
        this.idPedido = idPedido;
        this.nombreCliente = nombreCliente;
        this.medio = medio;
        this.importe = importe;
    }
    
    
}
