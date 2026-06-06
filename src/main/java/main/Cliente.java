package main;

import java.util.Scanner;

public class Cliente {

    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String direccion;

    public Cliente(String nombre, String apellido, String mail, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public Cliente() {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Ingrese el nombre: ");
        String nomEntrada = teclado.nextLine();
        if (nomEntrada == null || nomEntrada.isEmpty()) {
        throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        this.nombre = nomEntrada;

        System.out.print("Ingrese el apellido: ");
        String apeEntrada = teclado.nextLine();
        if (apeEntrada == null || apeEntrada.isEmpty()) {
        throw new IllegalArgumentException("El apellido no puede estar vacío.");
        }
        this.apellido = apeEntrada;

        
        System.out.print("Ingrese el mail: ");
        this.mail = teclado.nextLine();

        System.out.print("Ingrese el teléfono: ");
        this.telefono = teclado.nextLine();

        System.out.print("Ingrese la dirección: ");
        this.direccion = teclado.nextLine();
    }

    public String getNombre() {
        return nombre;
    }



    public String getApellido() {
        return apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
