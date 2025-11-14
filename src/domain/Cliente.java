package domain;

public class Cliente {

    private String nombre;
    private int numero;

    public Cliente(String nombre, int numero) {
        this.nombre = nombre;
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void verAtributos() {

        System.out.println("Nombre: " + getNombre());
        System.out.println("Numero: " + getNumero());

    }

}
