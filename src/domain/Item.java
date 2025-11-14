package domain;

public final class Item {

    private final String tipo;
    private final int cantidad;
    private final int subtotal;

    public Item(String tipo, int cantidad) {
        if (tipo == null || tipo.isBlank())
            throw new IllegalArgumentException("Tipo vacío.");

        if (cantidad <= 0)
            throw new IllegalArgumentException("Cantidad debe ser > 0.");

        String t = tipo.trim().toLowerCase();

        if (!t.equals("camisa") && !t.equals("pantalon") && !t.equals("chaqueta"))
            throw new IllegalArgumentException("Tipo inválido: " + tipo);

        this.tipo = t;
        this.cantidad = cantidad;
        this.subtotal = Catalogo.calcularSubtotal(t, cantidad);
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getSubtotal() {
        return subtotal;
    }

    @Override
    public String toString() {
        return tipo + " x" + cantidad + " → " + subtotal;
    }
}
