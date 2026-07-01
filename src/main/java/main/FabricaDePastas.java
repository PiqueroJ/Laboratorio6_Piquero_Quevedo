package main;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
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
                System.out.print("Opción: ");
                menu = teclado.nextInt();

                if (menu < 1 || menu > 8) {
                    System.out.println("El numero ingresado es invalido");
                }

                switch (menu) {
                    case 1 ->
                        agregarPedido();
                    case 2 -> {
                        Pedido buscado = buscarPedido();
                        buscado.mostrarPedido();
                    }
                    case 3 ->
                        listarPedidos();
                    case 4 ->
                        eliminarPedido();
                    case 5 ->
                        exportarPedidos();
                    case 6 ->
                        guardarPedidos();
                    case 7 ->
                        recuperarPedidos();

                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
        } while (menu != 8);
    }

    private void agregarPedido() {
        Cliente cliente = new Cliente();
        Pedido pedido = new Pedido();
        listaDePedidos.add(pedido);
        listaDeVentas.add(new Venta(cliente, pedido));
    }

    private Pedido buscarPedido() {
        Scanner teclado = new Scanner(System.in);
        Pedido buscado = null;
        int id = -1;

        do {
            try {
                System.out.println("Pedido a buscar:");
                id = teclado.nextInt();

                if (id < 1) {
                    System.out.println("El numero ingresado es invalido");
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
        } while (id < 1);

        if (listaDeVentas.get(id - 1) == null) {
            System.out.println("No existe");
        } else {
            buscado = listaDePedidos.get(id - 1);
            buscado.mostrarPedido();
        }

        return buscado;
    }

    private void listarPedidos() {
        for (Pedido ldp : listaDePedidos) {
            ldp.mostrarPedido();
            System.out.println("");
        }
    }

    private void eliminarPedido() {
        Pedido aBorrar = buscarPedido();
        if (aBorrar != null) {
            listaDePedidos.remove(aBorrar);
        }
    }

    private void exportarPedidos() {
        String nombreArchivo = "pedidos.txt";
        try (FileWriter fw = new FileWriter(nombreArchivo);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {

            // Recorremos la lista de elementos
            for (Venta v : listaDeVentas) {
                // Escribimos el bloque de texto del objeto
                pw.println(v.obtenerFormatoTexto());
            }

            System.out.println("¡Archivo 'pedidos.txt' exportado con éxito!");

        } catch (IOException e) {
            // Punto 5: Manejo de excepciones (Error de lectura/escritura)
            System.out.println("Error al escribir el archivo de texto: " + e.getMessage());
        }
    }


    private void guardarPedidos() {
        ObjectOutputStream ost = null;
        try {
            FileOutputStream f = new FileOutputStream("src/main/resources/pedidos.dat");
            ost = new ObjectOutputStream(f);
            ost.writeObject(listaDeVentas);
            ost.flush();
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            if (ost != null) {
                try {
                    ost.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }

    private void recuperarPedidos() {
        ObjectInputStream ist = null;
        try {
            FileInputStream f = new FileInputStream("src/main/resources/pedidos.dat");
            ist = new ObjectInputStream(f);
            listaDeVentas = (ArrayList<Venta>) ist.readObject();
            System.out.println(listaDeVentas);
        } catch (IOException e) {
            System.err.println(e);
        } catch (ClassNotFoundException e) {
            System.err.println(e);
        } finally {
            if (ist != null) {
                try {
                    ist.close();
                } catch (IOException e) {
                    System.err.println(e);
                }
            }
        }
    }
}
