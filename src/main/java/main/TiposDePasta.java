package main;

public enum TiposDePasta {
    FIDEOS_AL_HUEVO(500), RAVIOLES(800), NIOQUIS(600), AGNOLOTIS(750);

    private double precio;

    private TiposDePasta(double precio) {
        this.precio = precio;
    }

    public double getPrecio() {
        return precio;
    }
    
    public double calcularTotal(int cantidad) throws PedidoInvalidoException {
        double total = 0;
        if (cantidad !=  cantidad) {
            throw new PedidoInvalidoException(" La cantidad de cajas no puede tener coma");
        }
        if (cantidad <= 0) {
            throw new PedidoInvalidoException(" La cantidad de cajas de ser mayor a 0");
        }
        total += cantidad * precio;

    return total;
    }
    
    public double calcularTotal(double cantidad) throws PedidoInvalidoException {
        double total = 0;
        if (cantidad <= 0) {
            throw new PedidoInvalidoException(" El peso debe ser mayor a 0 kg");
        }
        if (cantidad > 10) {
            throw new PedidoInvalidoException("El peso no puede superar los 10 kg");
        }
        total += cantidad * precio;
        return total;
    }
    
}
