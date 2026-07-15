package imports;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import main.Cliente;
import main.FabricaDePastas;
import main.Pedido;

public class MenuPrincipal {

    //CREAR UNA VARIABLE GLOBAL PARA QUE EL TOTAL SE PUEDA CALCULAR
    
    private FabricaDePastas fabrica;
    private GestorArchivos gestor;
    private Scanner teclado;

    public MenuPrincipal(FabricaDePastas fabrica) {
        this.fabrica = fabrica;
        this.teclado = new Scanner(System.in);
    }

    public void iniciar() {
        int menu = -1;

        do {
            try {
                System.out.println("===== " + fabrica.getNombre() + " =====");
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
                    case 1 -> {
                        Cliente cliente = menuCliente();
                        Pedido pedido = menuPedido();
                        fabrica.agregarPedido(cliente, pedido);
                    }
                    case 2 -> {
                        Pedido buscado = buscarPedido();
                        buscado.mostrarPedido();
                    }
                    case 3 ->
                        fabrica.listarPedidos();
                    case 4 ->
                        fabrica.eliminarPedido();
                    case 5 ->
                        gestor.exportarPedidos();
                    case 6 ->
                        gestor.guardarPedidos();
                    case 7 ->
                        gestor.recuperarPedidos();

                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
        } while (menu != 8);
    }

    public Cliente menuCliente() {

        System.out.print("Ingrese el nombre: ");
        String nomEntrada = teclado.nextLine();
        if (nomEntrada == null || nomEntrada.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (!nomEntrada.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("El nombre no puede contener números.");
        }

        System.out.print("Ingrese el apellido: ");
        String apeEntrada = teclado.nextLine();
        if (apeEntrada == null || apeEntrada.isEmpty()) {
            throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        if (!nomEntrada.matches("[a-zA-Z ]+")) {
            throw new IllegalArgumentException("El apellido no puede contener números.");
        }

        System.out.print("Ingrese el mail: ");
        String mail = teclado.nextLine();

        System.out.print("Ingrese el teléfono: ");
        String telefono = teclado.nextLine();

        System.out.print("Ingrese la dirección: ");
        String direccion = teclado.nextLine();

        return new Cliente(nomEntrada, apeEntrada, mail, telefono, direccion);
    }

    private Pedido menuPedido() {
        MedioDeVentas mdv = menuMedioVenta();
        ArrayList<TiposDePasta> tdp = menuPastas();
        int cuotas = -1;
        double total = 0;
        if (!tdp.isEmpty()) {
            cuotas = menuCuotas();
        }

        return new Pedido(mdv, tdp, total, cuotas);
    }

    private ArrayList<TiposDePasta> menuPastas() {
        int menu = -1;
        ArrayList<TiposDePasta> pastas = new ArrayList();
        double total = 0;

        do {
            try {
                System.out.println("\n--- MENÚ DE PASTAS (0 para finalizar) ---");
                System.out.println("[ FIDEOS AL HUEVO: 1 | RAVIOLES: 2 | ÑOQUIS: 3 | AGNOLOTIS: 4 ]");
                menu = teclado.nextInt();

                if (menu < 0 || menu > 4) {
                    System.out.println("Opción de pasta inválida (Debe ser de 0 a 4).");
                }

                switch (menu) {
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
            } catch (PedidoInvalidoException e) {
                System.out.println("Error en el pedido: " + e.getMessage());
            }
            teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
        } while (menu != 0);

        return pastas;
    }

    private MedioDeVentas menuMedioVenta() {
        int menu = -1;
        MedioDeVentas medio = null;

        do {
            try {
                System.out.println("Ingrese el medio de venta[ TELEFONO:1 | PAGINA_WEB:2 | REDES_SOCIALES:3 ]: ");
                menu = teclado.nextInt();

                if (menu < 1 || menu > 3) {
                    System.out.println("El numero ingresado es invalido");
                }

                switch (menu) {
                    case 1 ->
                        medio = MedioDeVentas.TELEFONO;
                    case 2 ->
                        medio = MedioDeVentas.PAGINA_WEB;
                    case 3 ->
                        medio = MedioDeVentas.REDES_SOCIALES;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Tipo de dato incorrecto (Ingresó letras o formato numérico inválido).");
            }
            teclado.nextLine(); // Limpiamos el buffer del Scanner para evitar bucle infinito
        } while (menu < 1 || menu > 3);

        return medio;
    }

    private int menuCuotas() {

        int seleccion = -1;
        double totalC;

        do {
            try {
                System.out.println("En cuantas cuotas quiere pagar [0-6]: ");
                seleccion = teclado.nextInt();

                if (seleccion < 0 || seleccion > 6) {
                    System.out.println("Error: Cantidad de cuotas inválida.");
                } else if (seleccion == 0) {
                    // parece que con double la excepcion no sale tan facil asi que hay que forzarla
                    throw new ArithmeticException();
                } else {
                    totalC = total / seleccion;
                    System.out.println("Pagas $" + total + " en " + cuotas + " cuotas de $" + totalC);
                }

            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero válido.");
            } catch (ArithmeticException e) {
                System.out.println("No podes pagar en 0 cuotas");
            }
            teclado.nextLine();
        } while (seleccion < 1 || seleccion > 6);
        return seleccion;
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

}
