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

public class Main {

    public static void main(String[] args) {
        //FABRICA DE PASTAS INICIADA
        FabricaDePastas fdp = new FabricaDePastas();

        //LLEGA UN NUEVO CLIENTE
        fdp.menu();
    }

}
