package main;

import java.io.Serializable;
import java.util.ArrayList;

public class Cliente implements Serializable {

    private String nombre;
    private String apellido;
    private String mail;
    private String telefono;
    private String direccion;
    private ArrayList<Pedido> listaDePedidos;

    public Cliente(String nombre, String apellido, String mail, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.telefono = telefono;
        this.direccion = direccion;
        listaDePedidos = new ArrayList();
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

    public void comprar() {
        listaDePedidos.add(new Pedido());
    }

    public void mostrarPedidos() {
        for (Pedido ldp : listaDePedidos) {
            ldp.mostrarPedido();
            System.out.println("\n");
        }
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", apellido=" + apellido + ", mail=" + mail + ", telefono=" + telefono + ", direccion=" + direccion + '}';
    }

}
