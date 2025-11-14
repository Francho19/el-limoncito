package app;

import java.util.List;
import java.util.Scanner;

import domain.Catalogo;
import domain.Cliente;
import domain.Item;
import service.Orden;
public class App {

    private final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        System.out.println("=== Sistema de Ventas ===");

        Cliente cliente = crearClienteSeguro();
        boolean express = leerBooleano("¿Envío express? (s/n): ");
        Orden orden = new Orden(cliente, express);

        menu(orden);
    }

    private void menu(Orden orden) {
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1) Agregar item");
            System.out.println("2) Quitar item");
            System.out.println("3) Ver orden");
            System.out.println("4) Confirmar orden");
            System.out.println("0) Salir");

            int op = leerEnteroConRango("Opción: ", 0, 4);

            try {
                switch (op) {
                    case 1 -> agregarItem(orden);
                    case 2 -> quitarItem(orden);
                    case 3 -> mostrarOrden(orden);
                    case 4 -> confirmarOrden(orden);
            case 0 -> {
                System.out.println("Saliendo...");
                orden.imprimirRecibo();   // 👈 AQUÍ IMPRIME EL RECIBO FINAL
                return;
                }
                }
            } catch (Exception ex) {
                System.out.println("❌ Error: " + ex.getMessage());
            }
        }
    }

    private void agregarItem(Orden orden) {
        if (orden.isConfirmada()) {
            System.out.println("La orden ya está confirmada.");
            return;
        }

        String tipo = leerTipo("Tipo (camisa/pantalon/chaqueta): ");
        int cantidad = leerEnteroPositivo("Cantidad: ");

        Item item = new Item(tipo, cantidad);
        orden.agregarItem(item);
        System.out.println("Item agregado.");
    }

    private void quitarItem(Orden orden) {
        List<Item> items = orden.getItems();

        if (items.isEmpty()) {
            System.out.println("No hay items.");
            return;
        }

        System.out.println("Items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println("[" + i + "] " + items.get(i));
        }

        int idx = leerEnteroConRango("Índice a remover: ", 0, items.size() - 1);
        Item removed = orden.removerItem(idx);
        System.out.println("Item removido: " + removed);
    }

    private void mostrarOrden(Orden orden) {
        System.out.println("\n--- Orden Actual ---");
        System.out.println("Cliente: " + orden.getCliente().getNombre());
        System.out.println("Contacto: " + orden.getCliente().getNumeroContacto());
        System.out.println("Express: " + (orden.isExpress() ? "Sí" : "No"));
        System.out.println("Confirmada: " + (orden.isConfirmada() ? "Sí" : "No"));
        System.out.println("Items:");

        List<Item> items = orden.getItems();
        if (items.isEmpty()) {
            System.out.println(" (sin items)");
        } else {
            for (Item i : items) {
                System.out.println(" - " + i.getTipo() + " x" + i.getCantidad() + " → " + i.getSubtotal());
            }
        }

        System.out.println("Total: " + orden.getTotal());
    }

    private void confirmarOrden(Orden orden) {
        orden.confirmar();
        System.out.println("Orden confirmada. Total: " + orden.getTotal());
    }

    private Cliente crearClienteSeguro() {
        while (true) {
            System.out.print("Nombre cliente: ");
            String nombre = sc.nextLine();

            System.out.print("Número contacto: ");
            String numero = sc.nextLine();

            try {
                return new Cliente(nombre, numero);
            } catch (Exception e) {
                System.out.println("❌ " + e.getMessage());
            }
        }
    }

    /* ---------------- Helpers ---------------- */

    private int leerEnteroPositivo(String msg) {
        while (true) {
            System.out.print(msg);
            try {
                int v = Integer.parseInt(sc.nextLine());
                if (v > 0) return v;
                System.out.println("Debe ser > 0");
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número.");
            }
        }
    }

    private int leerEnteroConRango(String msg, int min, int max) {
        while (true) {
            System.out.print(msg);
            try {
                int v = Integer.parseInt(sc.nextLine());
                if (v >= min && v <= max) return v;
                System.out.println("Fuera de rango.");
            } catch (NumberFormatException e) {
                System.out.println("Ingresa un número.");
            }
        }
    }

    private boolean leerBooleano(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.startsWith("s")) return true;
            if (s.startsWith("n")) return false;
            System.out.println("Responde s/n.");
        }
    }

    private String leerTipo(String msg) {
        while (true) {
            System.out.print(msg);
            String t = sc.nextLine().trim().toLowerCase();
            if (t.equals("camisa") || t.equals("pantalon") || t.equals("chaqueta"))
                return t;
            System.out.println("Tipo inválido.");
        }
    }
}
