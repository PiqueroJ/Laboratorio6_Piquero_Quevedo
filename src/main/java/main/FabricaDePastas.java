package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FabricaDePastas {

    private String nombre = "Piquedo S.A.";
    private ArrayList<Venta> listaDeVentas;
    private ArrayList<Pedido> listaDePedidos;

    public FabricaDePastas() {
        this.listaDeVentas = new ArrayList();
        this.listaDePedidos = new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPedido(Cliente cliente, Pedido pedido) {
        listaDePedidos.add(pedido);
        listaDeVentas.add(new Venta(cliente, pedido));
    }

    public void listarPedidos() {
        for (Pedido ldp : listaDePedidos) {
            ldp.mostrarPedido();
            System.out.println("");
        }
    }

    public void eliminarPedido() {
        Pedido aBorrar = buscarPedido();
        if (aBorrar != null) {
            listaDePedidos.remove(aBorrar);
        }
    }

}
