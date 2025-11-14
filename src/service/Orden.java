package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.Cliente;
import domain.Item;

public class Orden {

    private final Cliente cliente;
    private final boolean express;

    private final List<Item> items = new ArrayList<>();
    private boolean confirmada = false;

    public Orden(Cliente cliente, boolean express) {
        if (cliente == null)
            throw new IllegalArgumentException("Cliente no puede ser null");

        this.cliente = cliente;
        this.express = express;
    }

    // ------------------ Gestión de Ítems ------------------

    public void agregarItem(Item item) {
        if (confirmada)
            throw new IllegalStateException("La orden ya está confirmada.");

        items.add(item);
    }

    public Item removerItem(int index) {
        if (confirmada)
            throw new IllegalStateException("La orden ya está confirmada.");

        return items.remove(index);
    }

    public List<Item> getItems() {
        return Collections.unmodifiableList(items);
    }

    // ------------------ Getters ------------------

    public Cliente getCliente() {
        return cliente;
    }

    public boolean isExpress() {
        return express;
    }

    public boolean isConfirmada() {
        return confirmada;
    }

    public int getTotal() {
        return items.stream().mapToInt(Item::getSubtotal).sum();
    }

    // ------------------ Confirmación ------------------

    public void confirmar() {
        if (items.isEmpty())
            throw new IllegalStateException("No puedes confirmar una orden vacía.");

        confirmada = true;
    }

    // ------------------ Recibo ------------------

    public void imprimirRecibo() {
        System.out.println("\n======= RECIBO =======");

        System.out.println("Cliente:   " + cliente.getNombre());
        System.out.println("Contacto:  " + cliente.getNumeroContacto());
        System.out.println("Express:   " + (express ? "Sí" : "No"));
        System.out.println("Estado:    " + (confirmada ? "Confirmada" : "Sin confirmar"));

        System.out.println("\n--- Items ---");
        if (items.isEmpty()) {
            System.out.println(" (sin items)");
        } else {
            for (Item i : items) {
                System.out.println(" - " + i.getTipo()
                        + "  x" + i.getCantidad()
                        + "  → $" + i.getSubtotal());
            }
        }

        System.out.println("\nTOTAL A PAGAR: $" + getTotal());
        System.out.println("=======================\n");
    }
}
