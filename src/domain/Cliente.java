package domain;

public final class Cliente {

    private final String nombre;
    private final String numeroContacto;

    public Cliente(String nombre, String numeroContacto) {
        if (nombre == null || nombre.isBlank())
            throw new IllegalArgumentException("Nombre inválido");

        if (numeroContacto == null || numeroContacto.isBlank())
            throw new IllegalArgumentException("Número inválido");

        this.nombre = nombre.trim();
        this.numeroContacto = numeroContacto.trim();
    }

    public String getNombre() {
        return nombre;
    }

    public String getNumeroContacto() {
        return numeroContacto;
    }

    @Override
    public String toString() {
        return nombre + " (" + numeroContacto + ")";
    }
}
