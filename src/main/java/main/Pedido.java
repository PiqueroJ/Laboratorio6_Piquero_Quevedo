package main;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Pedido {

    private Cliente datos;
    private MedioDeVentas medio;
    private double total;

    public Pedido() {
        Scanner teclado = new Scanner(System.in);

        int menu = 0;
        int res = 0;
        System.out.println("Ingrese el medio de venta[ TELEFONO:1 | PAGINA_WEB:2 | REDES_SOCIALES:3 ]: ");
        menu = teclado.nextInt();
        
        // PONERLO EN UN METODO PARA QUE SEA MEJOR
        res = menuMedioVenta(menu);
        
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
                    // Como calcular la cantidad sin morir
                    case 1 -> { pastaPedida = TiposDePasta.FIDEOS_AL_HUEVO; total += TiposDePasta.FIDEOS_AL_HUEVO.calcularTotalKilogramos(); }
                    case 2 -> { pastaPedida = TiposDePasta.RAVIOLES; total += TiposDePasta.RAVIOLES.calcularTotalCajas(); }
                    case 3 -> { pastaPedida = TiposDePasta.NIOQUIS; total += TiposDePasta.NIOQUIS.calcularTotalKilogramos();}
                    case 4 -> { pastaPedida = TiposDePasta.AGNOLOTIS; total += TiposDePasta.AGNOLOTIS.calcularTotalCajas(); }
                }

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
        System.out.println("Total del pedido: " + total);
    }
    
    public int menuMedioVenta(int menu){
        int res = 0;
        if (menu < 1 || menu > 3) {
            throw new IllegalArgumentException("El numero ingresado es invalido");
        }
        switch (menu) {
            case 1 ->{
                this.medio = MedioDeVentas.TELEFONO;
                res = 1; }
            case 2 -> {
                this.medio = MedioDeVentas.PAGINA_WEB;
                res = 2; }
            case 3 ->{
                this.medio = MedioDeVentas.REDES_SOCIALES;
                res = 3; }
        }
        return res;
    }
}
