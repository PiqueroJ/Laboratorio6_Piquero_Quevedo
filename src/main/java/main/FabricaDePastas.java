package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FabricaDePastas {

    private String nombre = "Piquedo S.A.";
    private ArrayList<Pedido> listaDePedidos;

    public FabricaDePastas() {
        this.listaDePedidos = new ArrayList();
        
    }

    
    
    
    public String getNombre() {
        return nombre;
    }

    public void menu() {
        Scanner teclado = new Scanner(System.in);
        int menu = -1;

        do {
            try {
                System.out.println("===== " + nombre + " =====");
                System.out.println("1. Agregar pedido");
                System.out.println("2. Buscar pedido");
                System.out.println("3. Listar pedidos");
                System.out.println("4. Eliminar pedido");
                System.out.println("5. Exportar pedidos a TXT");
                System.out.println("6. Guardar pedidos (Serialización)");
                System.out.println("7. Recuperar pedidos (Deserialización)");
                System.out.println("8. Salir");
                System.out.println("Opción: ");
                menu = teclado.nextInt();

                if (menu < 1 || menu > 8) {
                    System.out.println("El numero ingresado es invalido");
                }

                switch (menu) {
                    case 1 ->
                        agregarPedido();
                    case 2 ->
                        buscarPedido();
                    case 3->
                        listarPedidos();
                    case 4->
                        eliminarPedido();
                    case 5 ->
                        exportarPedidos();
                    case 6 ->
                        guardarPedidos(listaDePedidos);
                    case 7->
                        recuperarPedidos();
                        
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
        } while (menu < 1 || menu > 3);
    }

    private void agregarPedido() {
        listaDePedidos.add(new Pedido());
    }

    private void buscarPedido() {
        
    }

    private void listarPedidos() {
        for (Pedido ldp : listaDePedidos) {
            ldp.mostrarPedido();
            System.out.println("");
        }
    }

    private void eliminarPedido() {
        
    }

    private void exportarPedidos() {

    }

    private void guardarPedidos(ArrayList<Pedido> pedi) {
        try{
            FileOutputStream f = new FileOutputStream("src/main/resources/pedidos.dat");
            ObjectOutputStream ost = new ObjectOutputStream(f);
            ost.writeObject(pedi);
            ost.flush();
            ost.close();
        }catch (IOException e) {
            System.err.println(e);
        }
    }

    private void recuperarPedidos() {
       try{
            FileInputStream f = new FileInputStream("src/main/resources/pedidos.dat");
            ObjectInputStream ist = new ObjectInputStream(f);
            Pedido pedi = (Pedido) ist.readObject();
            System.out.println(pedi);
            ist.close();
        }catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        }
    }
}
    


