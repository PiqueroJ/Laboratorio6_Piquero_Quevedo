package imports;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import main.Venta;

public class GestorArchivos {

    private static final String RUTA_TXT = "pedidos.txt";
    private static final String RUTA_DAT = "src/main/resources/pedidos.dat";

    public GestorArchivos() {
    }

    
    
    public void exportarPedidos() {
        String nombreArchivo = "pedidos.txt";
        try (FileWriter fw = new FileWriter(nombreArchivo); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {

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

    public void guardarPedidos() {
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

    public void recuperarPedidos() {
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
