package main;

public enum TiposDePasta {
    FIDEOS_ALHUEVO(500), RAVIOLES(800), NIOQUIS(600), AGNOLOTIS(750);

    private double precio;

    private TiposDePasta(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    
    
}
