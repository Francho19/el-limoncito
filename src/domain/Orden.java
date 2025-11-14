package domain;

import java.util.ArrayList;
import java.util.List;

public class Orden {

    private final Cliente cliente;
    private final List<Item> items;
    private final boolean express;
    private boolean confirmada;

    public Orden(Cliente cliente, boolean express) {
        this.cliente = cliente;
        this.express = express;
        this.items = new ArrayList<>();
        this.confirmada = false;
    }

    public void agregarPrenda(String prenda, int cantidad) {
        if (confirmada) {
            throw new IllegalStateException("La orden ya está confirmada y no se puede editar.");
        }
        Item item = new Item(prenda, cantidad);
        items.add(item);
    }

    public int calcularTotalBruto() {
        int total = 0;
        for (Item item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int calcularRecargo() {
        if (express) {
            return (int) Math.round(calcularTotalBruto() * 0.10);
        }
        return 0;
    }

    public int calcularDescuento() {
        int totalConRecargo = calcularTotalBruto() + calcularRecargo();
        if (totalConRecargo > 60000) {
            return (int) Math.round(totalConRecargo * 0.05);
        }
        return 0;
    }

    public int calcularTotalFinal() {
        return calcularTotalBruto() + calcularRecargo() - calcularDescuento();
    }

    public void confirmar() {
        if (confirmada) {
            throw new IllegalStateException("La orden ya está confirmada.");
        }
        confirmada = true;
    }

    public void mostrarResumen() {
        System.out.println("=== Resumen de la Orden ===");
        System.out.println("Cliente: " + cliente.getNombre() + " - Tel: " + cliente.getNumero());
        System.out.println("Servicio: " + (express ? "Exprés" : "Normal"));
        System.out.println("Detalle de prendas:");
        for (Item item : items) {
            System.out.println("  - " + item);
        }
        System.out.println("Total Bruto: $" + calcularTotalBruto());
        System.out.println("Recargo (10% si exprés): $" + calcularRecargo());
        System.out.println("Descuento (5% si > $60.000): $" + calcularDescuento());
        System.out.println("Total Final: $" + calcularTotalFinal());
        System.out.println("Estado: " + (confirmada ? "Confirmada" : "Pendiente"));
    }

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isExpress() {
        return express;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

}
