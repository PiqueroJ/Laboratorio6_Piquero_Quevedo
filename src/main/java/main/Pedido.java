package main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Pedido {

    private MedioDeVentas medio;
    private ArrayList<TiposDePasta> pastas;
    private double total;

    public Pedido() {
        //INICIAMOS EL MENU DE LOS TIPOS DE PASTA
        menuMedioVenta();

        //INICIAMOS EL MENU DE PASTA
        menuPasta();

        //FINALIZAMOS CON LAS CUOTAS
        menuCuotas();
    }

    public void mostrarPedido() {
        System.out.println("Medio de pago: " + medio);
        for (TiposDePasta pasta : pastas) {
            pasta.mostrarPasta();
        }
        System.out.println("Total del pedido: " + total);
    }

    private void menuMedioVenta() {
        Scanner teclado = new Scanner(System.in);
        int menu = -1;

        do {
            try {
                System.out.println("Ingrese el medio de venta[ TELEFONO:1 | PAGINA_WEB:2 | REDES_SOCIALES:3 ]: ");
                menu = teclado.nextInt();

                if (menu < 1 || menu > 3) {
                    System.out.println("El numero ingresado es invalido");
                }

                switch (menu) {
                    case 1 ->
                        this.medio = MedioDeVentas.TELEFONO;
                    case 2 ->
                        this.medio = MedioDeVentas.PAGINA_WEB;
                    case 3 ->
                        this.medio = MedioDeVentas.REDES_SOCIALES;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
                teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
            }
        } while (menu < 1 || menu > 3);
    }

    private void menuPasta() {
        Scanner teclado = new Scanner(System.in);
        int menu = -1;
        pastas = new ArrayList();

        do {
            try {
                System.out.println("\n--- MENÚ DE PASTAS (0 para finalizar) ---");
                System.out.println("[ FIDEOS AL HUEVO: 1 | RAVIOLES: 2 | ÑOQUIS: 3 | AGNOLOTIS: 4 ]");
                menu = teclado.nextInt();

                if (menu < 0 || menu > 4) {
                    System.out.println("Opción de pasta inválida (Debe ser de 0 a 4).");
                }

                switch (menu) {
                    // Como calcular la cantidad sin morir
                    case 1 -> {
                        pastas.add(TiposDePasta.FIDEOS_AL_HUEVO);
                        total += TiposDePasta.FIDEOS_AL_HUEVO.calcularTotalKilogramos();
                    }
                    case 2 -> {
                        pastas.add(TiposDePasta.RAVIOLES);
                        total += TiposDePasta.RAVIOLES.calcularTotalCajas();
                    }
                    case 3 -> {
                        pastas.add(TiposDePasta.NIOQUIS);
                        total += TiposDePasta.NIOQUIS.calcularTotalKilogramos();
                    }
                    case 4 -> {
                        pastas.add(TiposDePasta.AGNOLOTIS);
                        total += TiposDePasta.AGNOLOTIS.calcularTotalCajas();
                    }
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
                teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
            } catch (PedidoInvalidoException e) {
                System.out.println("Error en el pedido: " + e.getMessage());
            }
        } while (menu < 0 || menu > 3);
    }

    private void menuCuotas() {

    }

}
