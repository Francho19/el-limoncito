package domain;

public class Catalogo {
    
    public static final int PRECIO_CAMISA_NORMAL = 4000;
    public static final int PRECIO_CAMISA_BULK = 3500;
    public static final int PRECIO_PANTALON_NORMAL = 6000;
    public static final int PRECIO_PANTALON_BULK = 5000;
    public static final int PRECIO_CHAQUETA_NORMAL = 9000;
    public static final int PRECIO_CHAQUETA_BULK = 7500;

    public static int getPrecio(String tipo, int cantidad) {
        boolean bulk = cantidad >= 5;
        switch (tipo.toLowerCase()) {
            case "camisa":
                return bulk ? PRECIO_CAMISA_BULK : PRECIO_CAMISA_NORMAL;
            case "pantalon":
                return bulk ? PRECIO_PANTALON_BULK : PRECIO_PANTALON_NORMAL;
            case "chaqueta":
                return bulk ? PRECIO_CHAQUETA_BULK : PRECIO_CHAQUETA_NORMAL;
            default:
                throw new IllegalArgumentException("Tipo de prenda no válido: " + tipo);
        }
    }

}
