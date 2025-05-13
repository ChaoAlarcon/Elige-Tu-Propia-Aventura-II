package AhoraEsPersonal;


public class CreacionJugador {
    public CreacionJugador(String string, int i, int j, int k, int l) {
	}

	public static boolean isValido(String nombre) {
        return nombre.equalsIgnoreCase("cambises") ||
               nombre.equalsIgnoreCase("bastet")   ||
               nombre.equalsIgnoreCase("ánuket");
    }

    public static Jugador crear(String nombre) {
        switch (nombre.toLowerCase()) {
            case "cambises":
                return new Jugador("Cambises", 600, 40, 120, 30);
            case "bastet":
                return new Jugador("Bastet",   700, 30, 140, 40);
            case "ánuket":
                return new Jugador("Ánuket",   650, 30, 130, 20);
        }
		return null;
    }
}
