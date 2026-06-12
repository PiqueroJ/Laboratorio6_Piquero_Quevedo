package main;

import java.util.Scanner;

public enum TiposDePasta {
    FIDEOS_AL_HUEVO(500), RAVIOLES(800), NIOQUIS(600), AGNOLOTIS(750);

    private double precio;
    private int cajas;
    private double kilogramos;

    private TiposDePasta(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }

    // es mejor calcuar el total con el TipoDePasta?
    public double calcularTotalCajas() throws PedidoInvalidoException {
        Scanner teclado = new Scanner(System.in);
        int cantidad = 0;
        double total = 0;
        System.out.println("Cuantas cajas quiere[Deven ser mas de 0]");
        cantidad = teclado.nextInt();
        if (cantidad != cantidad) {
            throw new PedidoInvalidoException(" La cantidad de cajas no puede tener coma");
        }
        if (cantidad <= 0) {
            throw new PedidoInvalidoException(" La cantidad de cajas de ser mayor a 0");
        }
        total += cantidad * precio;
        cajas = cantidad;
        return total;
    }

    public double calcularTotalKilogramos() throws PedidoInvalidoException {
        Scanner teclado = new Scanner(System.in);
        double cantidad = 0;
        double total = 0;
        System.out.println("Cuantos kg quiere[Deven ser entre 0-10]");
        cantidad = teclado.nextDouble();
        if (cantidad <= 0) {
            throw new PedidoInvalidoException(" El peso debe ser mayor a 0 kg");
        }
        if (cantidad > 10) {
            throw new PedidoInvalidoException("El peso no puede superar los 10 kg");
        }
        total += cantidad * precio;
        kilogramos = cantidad;
        return total;
    }

    public void mostrarPasta() {
        System.out.println(this.name());
        System.out.println(this.getPrecio());
        if (cajas != 0) {
            System.out.println("Cajas: " + cajas);
        }
        if (kilogramos != 0) {
            System.out.println("Kilogramos" + kilogramos);
        }
    }

}
