package main;
import java.util.Scanner;
public class Personajes {
    ConectarBDD ConectarBDD = new ConectarBDD();
    Scanner sc = new Scanner(System.in);
    private int opcionPersonaje = 0;
    private String confirmacionSeleccionPersonaje;
    private int numeroPersonajes;
    private String nombrePersonaje;
    private int vida;
    private int vidaMax;
    private String nombreBasico;
    private int danoBasico;
    private String descripcionBasico;
    private int precisionBasico;
    private String nombreFuerte;
    private int danoFuerte;
    private String descripcionFuerte;
    private int precisionFuerte;
    private String nombreHabilidad;
    private int datosHabilidad;
    private String descripcionHabilidad;
    

	public Personajes(int opcionPersonaje, String confirmacionSeleccionPersonaje,
	                  int numeroPersonajes, String nombrePersonaje, int vida, int vidaMax, String nombreBasico,
	                  int danoBasico, String descripcionBasico, int precisionBasico, String nombreFuerte,
	                  int danoFuerte, String descripcionFuerte, int precisionFuerte, String nombreHabilidad,
	                  int datosHabilidad, String descripcionHabilidad) {
	
	    this.opcionPersonaje = opcionPersonaje;
	    this.confirmacionSeleccionPersonaje = confirmacionSeleccionPersonaje;
	    this.numeroPersonajes = numeroPersonajes;
	    this.nombrePersonaje = nombrePersonaje;
	    this.vida = vida;
	    this.vidaMax = vidaMax;
	    this.nombreBasico = nombreBasico;
	    this.danoBasico = danoBasico;
	    this.descripcionBasico = descripcionBasico;
	    this.precisionBasico = precisionBasico;
	    this.nombreFuerte = nombreFuerte;
	    this.danoFuerte = danoFuerte;
	    this.descripcionFuerte = descripcionFuerte;
	    this.precisionFuerte = precisionFuerte;
	    this.nombreHabilidad = nombreHabilidad;
	    this.datosHabilidad = datosHabilidad;
	    this.descripcionHabilidad = descripcionHabilidad;
	}
	
	public Personajes () {
		
	}
	
	public int getOpcionPersonaje() {
		return opcionPersonaje;
	}

	public void setOpcionPersonaje(int opcionPersonaje) {
		this.opcionPersonaje = opcionPersonaje;
	}

	public String getConfirmacionSeleccionPersonaje() {
		return confirmacionSeleccionPersonaje;
	}

	public void setConfirmacionSeleccionPersonaje(String confirmacionSeleccionPersonaje) {
		this.confirmacionSeleccionPersonaje = confirmacionSeleccionPersonaje;
	}

	public int getNumeroPersonajes() {
		return numeroPersonajes;
	}

	public void setNumeroPersonajes(int numeroPersonajes) {
		this.numeroPersonajes = numeroPersonajes;
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public void setNombrePersonaje(String nombrePersonaje) {
		this.nombrePersonaje = nombrePersonaje;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

	public String getNombreBasico() {
		return nombreBasico;
	}

	public void setNombreBasico(String nombreBasico) {
		this.nombreBasico = nombreBasico;
	}

	public int getDanoBasico() {
		return danoBasico;
	}

	public void setDanoBasico(int danoBasico) {
		this.danoBasico = danoBasico;
	}

	public String getDescripcionBasico() {
		return descripcionBasico;
	}

	public void setDescripcionBasico(String descripcionBasico) {
		this.descripcionBasico = descripcionBasico;
	}

	public int getPrecisionBasico() {
		return precisionBasico;
	}

	public void setPrecisionBasico(int precisionBasico) {
		this.precisionBasico = precisionBasico;
	}

	public String getNombreFuerte() {
		return nombreFuerte;
	}

	public void setNombreFuerte(String nombreFuerte) {
		this.nombreFuerte = nombreFuerte;
	}

	public int getDanoFuerte() {
		return danoFuerte;
	}

	public void setDanoFuerte(int danoFuerte) {
		this.danoFuerte = danoFuerte;
	}

	public String getDescripcionFuerte() {
		return descripcionFuerte;
	}

	public void setDescripcionFuerte(String descripcionFuerte) {
		this.descripcionFuerte = descripcionFuerte;
	}

	public int getPrecisionFuerte() {
		return precisionFuerte;
	}

	public void setPrecisionFuerte(int precisionFuerte) {
		this.precisionFuerte = precisionFuerte;
	}

	public String getNombreHabilidad() {
		return nombreHabilidad;
	}

	public void setNombreHabilidad(String nombreHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
	}

	public int getDatosHabilidad() {
		return datosHabilidad;
	}

	public void setDatosHabilidad(int datosHabilidad) {
		this.datosHabilidad = datosHabilidad;
	}

	public String getDescripcionHabilidad() {
		return descripcionHabilidad;
	}

	public void setDescripcionHabilidad(String descripcionHabilidad) {
		this.descripcionHabilidad = descripcionHabilidad;
	}

	public void ElejirPersonajes() {
		System.out.println("La diosa Ammit necesita vuestra ayuda para detener a un nuevo mal que ha surgido en Eazima,\n"
				+ "un ser que ni la diosa es capaz de entender.\n“Un aprendiz de Taharka, llamado Tahorki, heredó sus"
				+ " conocimientos,\ny parece que ha abierto un portal en el cielo a otra dimensión situada en un mundo oscuro"
				+ " y siniestro.\nTendréis que adentraros en una pirámide que se ha desprendido desde el portal, y derrotar al"
				+ " Tahorki\ny a la criatura que está distorsionando esta realidad.");
    	confirmacionSeleccionPersonaje = "";
        numeroPersonajes = ConectarBDD.obtenerNumeroDeFilas("personajes");

        while (opcionPersonaje < 1 || opcionPersonaje > numeroPersonajes) {
        	System.out.println("\n--------------------------------");
            System.out.println("Elige a tu personaje:\n");
            for (int i = 1; i <= numeroPersonajes; i++) {
                System.out.println(i + ". " + ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = " + i));
            }
            System.out.println("---------------------------------");
            opcionPersonaje = sc.nextInt();
            if (opcionPersonaje < 1 || opcionPersonaje > numeroPersonajes) {
                System.out.println("Opción no válida, elige un personaje entre 1 y " + numeroPersonajes + ".");
            }
            sc.nextLine();
            System.out.println("Has elegido a " + ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes =" + opcionPersonaje) + " que tiene |" + ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes =" + opcionPersonaje) + "| puntos de vida y los siguientes ataques:");
            System.out.println("\nAtaque básico (" + ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques =" + opcionPersonaje) + "): |" + ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques =" + opcionPersonaje) + "| puntos de daño. " + ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques =" + opcionPersonaje) + ".");
            System.out.println("\nAtaque fuerte (" + ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques =" + opcionPersonaje) + "): |" + ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques =" + opcionPersonaje) + "| puntos de daño. " + ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques =" + opcionPersonaje) + ".");
            System.out.println("\nHabilidad especial (" + ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques =" + opcionPersonaje) + "): |" + ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques =" + opcionPersonaje) + "| puntos de efecto de habilidad. " + ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques =" + opcionPersonaje) + ".");
            System.out.println("\n---------------------------------");
            System.out.println("Estas seguro de que quieres jugar con Ánuket? (S para confirmar/ Cualquier otra tecla para cancelar)");
            System.out.println("---------------------------------");
            confirmacionSeleccionPersonaje = sc.nextLine();

            if (confirmacionSeleccionPersonaje.equalsIgnoreCase("S")) {
                setNombrePersonaje(ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes =" + opcionPersonaje));
                setVida(ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes =" + opcionPersonaje));
                setVidaMax(ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes =" + opcionPersonaje));
                setNombreBasico(ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques =" + opcionPersonaje));
                setDanoBasico(ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques =" + opcionPersonaje));
                setDescripcionBasico(ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques =" + opcionPersonaje));
                setPrecisionBasico(ConectarBDD.consultarDatosint("precisionBasico", "ataques", "id_ataques =" + opcionPersonaje));
                setNombreFuerte(ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques =" + opcionPersonaje));
                setDanoFuerte(ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques =" + opcionPersonaje));
                setDescripcionFuerte(ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques =" + opcionPersonaje));
                setPrecisionFuerte(ConectarBDD.consultarDatosint("precisionFuerte", "ataques", "id_ataques =" + opcionPersonaje));
                setNombreHabilidad(ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques =" + opcionPersonaje));
                setDatosHabilidad(ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques =" + opcionPersonaje));
                setDescripcionHabilidad(ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques =" + opcionPersonaje));

                System.out.println("\nHas elegido a " + nombrePersonaje);
            } else {
                opcionPersonaje = 0;
            }
        }
    }
}
