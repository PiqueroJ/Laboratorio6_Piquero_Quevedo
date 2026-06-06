package main;

import java.util.Scanner;

public class Pedido {
    private Cliente datos;
    private MedioDeVentas medio;
    private TiposDePasta pasta;
    private int cantidad;
    private double peso;

    public Pedido(Cliente datos, MedioDeVentas medio, TiposDePasta pasta, int cantidad, double peso) {
        this.datos = datos;
        this.medio = medio;
        this.pasta = pasta;
        this.cantidad = cantidad;
        this.peso = peso;
    }

    public Pedido() {
        Scanner teclado = new Scanner(System.in);
        int res = 0;
        
        /*System.out.println("Ingrese el medio de venta[ TELEFONO:1 | PAGINA_WEB:2 | REDES_SOCIALES:3 ]: ");
        res = teclado.nextInt();
        if(res < 1 || res > 3){
            throw new IllegalArgumentException("El numero ingresado es invalido");
        }
        switch(res){
            case 1 -> this.medio = TELEFONO;
            case 2 -> this.medio = PAGINA_WEB;
            case 3 -> this.medio = REDES_SOCIALES;
        }*/
               
        
        System.out.println("Cuantas cajas quiere: ");
        this.cantidad = teclado.nextInt();
        
        System.out.println("Cuantos kg quiere: ");
        this.peso = teclado.nextDouble();
        
        
    }

    
    
    public void mostrarPedido(){
        datos.toString();
        System.out.println("Medio de pago: " + medio);
    } 

    
}
