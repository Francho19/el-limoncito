package app;

import domain.Cliente;
import domain.Orden;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Registrar cliente
        System.out.print("Ingrese nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese teléfono del cliente: ");
        int telefono = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Cliente cliente = new Cliente(nombre, telefono);

        // Servicio exprés
        System.out.print("¿Servicio exprés? (s/n): ");
        String expresStr = scanner.nextLine();
        boolean express = expresStr.equalsIgnoreCase("s");

        Orden orden = new Orden(cliente, express);

        // Agregar prendas
        boolean agregarMas = true;
        while (agregarMas) {
            System.out.print("Ingrese tipo de prenda (camisa/pantalon/chaqueta): ");
            String tipo = scanner.nextLine();
            System.out.print("Ingrese cantidad: ");
            int cantidad = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                orden.agregarPrenda(tipo, cantidad);
                System.out.println("Prenda agregada.");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.print("¿Agregar otra prenda? (s/n): ");
            String mas = scanner.nextLine();
            agregarMas = mas.equalsIgnoreCase("s");
        }

        // Mostrar resumen antes de confirmar
        orden.mostrarResumen();

        // Confirmar
        System.out.print("¿Confirmar la orden? (s/n): ");
        String confirmarStr = scanner.nextLine();
        if (confirmarStr.equalsIgnoreCase("s")) {
            orden.confirmar();
            System.out.println("Orden confirmada.");
            orden.mostrarResumen();
        } else {
            System.out.println("Orden no confirmada.");
        }

        scanner.close();
    }
}
