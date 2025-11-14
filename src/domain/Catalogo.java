package domain;

public final class Catalogo {

    private Catalogo() {}

    public static final int CAMISA_NORMAL = 10000;
    public static final int CAMISA_BULK   = 9000;

    public static final int PANTALON_NORMAL = 15000;
    public static final int PANTALON_BULK   = 14000;

    public static final int CHAQUETA_NORMAL = 30000;
    public static final int CHAQUETA_BULK   = 28000;

    public static int getPrecioUnidad(String tipo, int cantidad) {
        boolean bulk = cantidad >= 10;

        return switch (tipo) {
            case "camisa" -> bulk ? CAMISA_BULK : CAMISA_NORMAL;
            case "pantalon" -> bulk ? PANTALON_BULK : PANTALON_NORMAL;
            case "chaqueta" -> bulk ? CHAQUETA_BULK : CHAQUETA_NORMAL;
            default -> throw new IllegalArgumentException("Tipo no existe: " + tipo);
        };
    }

    public static int calcularSubtotal(String tipo, int cantidad) {
        return getPrecioUnidad(tipo, cantidad) * cantidad;
    }
}
