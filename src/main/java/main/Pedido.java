package main;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Pedido {

    private Cliente datos;
    private MedioDeVentas medio;

    public Pedido() {
        Scanner teclado = new Scanner(System.in);

        int menu = 0;
        System.out.println("Ingrese el medio de venta[ TELEFONO:1 | PAGINA_WEB:2 | REDES_SOCIALES:3 ]: ");
        menu = teclado.nextInt();
        if (menu < 1 || menu > 3) {
            throw new IllegalArgumentException("El numero ingresado es invalido");
        }
        switch (menu) {
            case 1 ->
                this.medio = MedioDeVentas.TELEFONO;
            case 2 ->
                this.medio = MedioDeVentas.PAGINA_WEB;
            case 3 ->
                this.medio = MedioDeVentas.REDES_SOCIALES;
        }
        
/*
        do {
            TiposDePasta pastaPedida;
            boolean cajas = true;

            System.out.println("Que tipo de fideos quiere? " + "\n" + "[ FIDEOS AL HUEVO: 1 | RAVIOLES: 2 | ÑOQUIS: 3 | AGNOLOTIS: 4 ]: " + "\n" + "Pulse 0 para acabar de pedir");
            menu = teclado.nextInt();
            if (menu < 0 || menu > 4) {
                throw new IllegalArgumentException("El numero ingresado es invalido");
            }
            switch (menu) {
                case 1 ->
                    pastaPedida = TiposDePasta.FIDEOS_AL_HUEVO;
                case 2 ->
                    pastaPedida = TiposDePasta.RAVIOLES;
                case 3 -> {
                    pastaPedida = TiposDePasta.NIOQUIS;
                    cajas = false;
                }
                case 4 -> {
                    pastaPedida = TiposDePasta.AGNOLOTIS;
                    cajas = false;
                }
            }

            if (cajas) {
                System.out.println("Cuantas cajas quiere: ");
                this.cantidad = teclado.nextInt();
                if (cantidad < 1 ) {
                    throw new IllegalArgumentException("El nombre no puede estar vacío.");
                }

            } else {
                System.out.println("Cuantos kg quiere: ");
                this.peso = teclado.nextDouble();
            }

        } while (menu != 0);*/

        int menuPasta = -1;
        do {
            try {
                System.out.println("\n--- MENÚ DE PASTAS (0 para finalizar) ---");
                System.out.println("[ FIDEOS AL HUEVO: 1 | RAVIOLES: 2 | ÑOQUIS: 3 | AGNOLOTIS: 4 ]");
                System.out.print("Seleccione una opción: ");
                menuPasta = teclado.nextInt();


                if (menuPasta < 0 || menuPasta > 4) {
                    throw new IllegalArgumentException("Opción de pasta inválida (Debe ser de 0 a 4).");
                }

                TiposDePasta pastaPedida = null;
                boolean llevaCajas = false;

                // Asignación según consigna: 
                // Cajas: Ravioles(2) y Agnolotis(4). Kg: Fideos(1) y Ñoquis(3)
                switch (menuPasta) {
                    case 1 -> pastaPedida = TiposDePasta.FIDEOS_AL_HUEVO;
                    case 2 -> { pastaPedida = TiposDePasta.RAVIOLES; llevaCajas = true; }
                    case 3 -> pastaPedida = TiposDePasta.NIOQUIS;
                    case 4 -> { pastaPedida = TiposDePasta.AGNOLOTIS; llevaCajas = true; }
                }

                int cantidadCajas = 0;
                double cantidadKg = 0.0;

                if (llevaCajas) {
                    System.out.print("¿Cuántas cajas quiere?: ");
                    cantidadCajas = teclado.nextInt(); // Lanza InputMismatchException si ponen coma o letras
                    
                    // Validamos con nuestra excepción personalizada
                    ValidadorPedido.validarCajas(cantidadCajas);
                } else {
                    System.out.print("¿Cuántos kg quiere?: ");
                    cantidadKg = teclado.nextDouble(); // Lanza InputMismatchException si ponen letras
                    
                    // Validamos con nuestra excepción personalizada
                    ValidadorPedido.validarPeso(cantidadKg);
                }

                //FALTA AGREGAR EL PEDIDO

            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
                teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
            } catch (PedidoInvalidoException e) {
                System.out.println("Error en el pedido: " + e.getMessage());
            }

        } while (menuPasta != 0);
    }


    public void mostrarPedido() {
        datos.toString();
        System.out.println("Medio de pago: " + medio);
    }

}
