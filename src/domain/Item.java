package domain;

public class Item {

    private String tipo;
    private int cantidad;
    private int precioUnitario;
    private int subtotal;

    public Item(String tipo, int cantidad) {
        if (cantidad <= 0) {
            throw new IllegalArgumentException("Cantidad debe ser mayor a 0");
        }
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.precioUnitario = Catalogo.getPrecio(tipo, cantidad);
        this.subtotal = calcularSubtotal();
    }

    public int calcularSubtotal() {
        return precioUnitario * cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getPrecioUnitario() {
        return precioUnitario;
    }

    public int getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return tipo + " x" + cantidad + " @ $" + precioUnitario + " = $" + subtotal;
    }

}
