/*
    Pedido: 1001
    Cliente: Juan Perez
    Canal: WEB
    Importe: 25000
 */
package main;

import imports.MedioDeVentas;
import java.io.Serializable;

public class Venta implements Serializable {

    private static final long serialVersionUID = 1L;

    private int idPedido;
    private String nombreCliente;
    private MedioDeVentas medio;
    private double importe;

    public Venta(Cliente clie, Pedido pedi) {
        this.idPedido = pedi.getId();
        this.nombreCliente = clie.getNombre() + " " + clie.getApellido();
        this.medio = pedi.getMedio();
        this.importe = pedi.getTotal();
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public MedioDeVentas getMedio() {
        return medio;
    }

    public double getImporte() {
        return importe;
    }

    public String obtenerFormatoTexto() {
        return "Pedido: " + this.idPedido + "\n"
                + "Cliente: " + this.nombreCliente + "\n"
                + "Canal: " + this.medio + "\n"
                + "Importe: " + this.importe + "\n"; // Deja un salto de línea al final
    }

}
