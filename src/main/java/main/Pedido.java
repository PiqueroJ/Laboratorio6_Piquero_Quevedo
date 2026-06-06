package main;

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

    public Cliente getDatos() {
        return datos;
    }

    public void setDatos(Cliente datos) {
        this.datos = datos;
    }

    public MedioDeVentas getMedio() {
        return medio;
    }

    public void setMedio(MedioDeVentas medio) {
        this.medio = medio;
    }

    public TiposDePasta getPasta() {
        return pasta;
    }

    public void setPasta(TiposDePasta pasta) {
        this.pasta = pasta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
    public void mostrarPedido(){
        datos.toString();
        System.out.println("Medio de pago: " + medio);
    } 

    
}
