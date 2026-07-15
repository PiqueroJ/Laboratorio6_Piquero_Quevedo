package main;

import imports.TiposDePasta;
import imports.MedioDeVentas;
import java.io.Serializable;
import java.util.ArrayList;

public class Pedido implements Serializable {

    private static int contadorId = 0;

    private int id;
    private MedioDeVentas medio;
    private ArrayList<TiposDePasta> pastas;
    private double total;
    private int cuotas;

    public Pedido(MedioDeVentas medio, ArrayList<TiposDePasta> pastas, double total, int cuotas) {
        this.id = contadorId++;
        this.medio = medio;
        this.pastas = pastas;
        this.total = total;
        this.cuotas = cuotas;
    }

    public void mostrarPedido() {
        if (!pastas.isEmpty()) {
            System.out.println("Medio de pago: " + medio);
            for (TiposDePasta pasta : pastas) {
                pasta.mostrarPasta();
                System.out.println("");
            }
            System.out.println("Total del pedido: $" + total + " en " + cuotas + " cuotas de $" + total / cuotas);
        } else {
            System.out.println("No hay pastas");
        }
    }

    public int getId() {
        return id;
    }

    public MedioDeVentas getMedio() {
        return medio;
    }

    public ArrayList<TiposDePasta> getPastas() {
        return pastas;
    }

    public double getTotal() {
        return total;
    }

    public int getCuotas() {
        return cuotas;
    }

}
