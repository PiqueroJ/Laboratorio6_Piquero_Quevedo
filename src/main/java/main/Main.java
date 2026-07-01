/*
La fábrica de pastas Mat-Noodles SRL realiza ventas mediante:

Teléfono
Página web
Redes sociales
El sistema debe permitir registrar pedidos de clientes y controlar posibles errores durante la carga de datos.

Deberá solicitar:

Datos del cliente (nombre, apellido, mail, telefono, direccion)
Medio de venta (telefono / web / RS)
Tipo de pasta (fideos al huevo, ravioles, ñoquis, agnolotis)
Cantidad (cajas para ravioles o agnolotis / peso en kg para fideos o ñoquis)
Luego deberá calcular:

Total de la compra (considere que en un pedido pueden haber diferentes tipos de pasta para un mismo cliente)
Mostrar resumen del pedido
Reglas de validación:

El nombre y apellido del cliente no puede estar vacío.
El nombre y apellido del cliente no puede contener números.
La cantidad de cajas no puede contener letras y no puede ser un numero con coma, debe ser mayor a 0.
Los kg no pueden contener letras, debe ser mayor a 0 y no puede superar los 10kg.
Excepciones obligatorias

InputMismatchException
IllegalArgumentException
ArithmeticException
Exception
Excepción personalizada
Crear una excepción llamada:

PedidoInvalidoException
La excepción deberá utilizarse cuando la cantidad de cajas sea incorrecta o el peso sea incorrecto.
 */
package main;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //Hardcode
        Cliente comprador = new Cliente("Jesus", "Quevedo", "mailfalso@gmail", "123456", "calle falsa");
        ArrayList<Pedido> pedidos = new ArrayList<Pedido>();

        //Entrada manual
        //Cliente comprador = new Cliente();
        System.out.println("\n" + comprador.getNombre() + " viene a la tienda a comprar, al comprar ya le ofrecen el menú" + "\n");
        comprador.comprar();

        System.out.println("\n" + "A " + comprador.getNombre() + " le gustaron tanto que fue a comprar más para la semana" + "\n");
        comprador.comprar();

        System.out.println("\n" + "Días después viene a comprar" + "\n");
        comprador.comprar();

        System.out.println("\n" + "Ahora " + comprador.getNombre() + " usará los recibos para ver la economía de su casa" + "\n");
        comprador.mostrarPedidos();
        
    }
    
    public void serializacion(Pedido pedi){
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
        
    public void deserializacion(){
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
