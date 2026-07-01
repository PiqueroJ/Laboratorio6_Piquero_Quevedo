/*
    Pedido: 1001
    Cliente: Juan Perez
    Canal: WEB
    Importe: 25000
 */
package main;

import imports.MedioDeVentas;

public class Venta {

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

}
