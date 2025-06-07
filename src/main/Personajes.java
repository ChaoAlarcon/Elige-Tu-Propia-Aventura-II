package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;
public class Personajes {
	Scanner sc = new Scanner(System.in);
	ConectarBDD ConectarBDD = new ConectarBDD();
	private int opcionPersonaje;
	private String confirmacionSeleccionPersonaje;
	private String nombrePersonaje;
	private int vida;
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
	private String Muerte_antes_de_Boss;
	private String Muerte_Ammit;
	private String Muerte_Boss;
	private String Victoria_Boss;
	private String Bendicion_Ammit;
	private int numeroPersonajes;
	private int ataqueEspecial = 0;
	
	public Personajes() {
		
	}

	public String getNombrePersonaje() {
		return nombrePersonaje;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public String getNombreBasico() {
		return nombreBasico;
	}

	public int getDanoBasico() {
		return danoBasico;
	}

	public String getDescripcionBasico() {
		return descripcionBasico;
	}

	public int getPrecisionBasico() {
		return precisionBasico;
	}

	public String getNombreFuerte() {
		return nombreFuerte;
	}


	public int getDanoFuerte() {
		return danoFuerte;
	}


	public String getDescripcionFuerte() {
		return descripcionFuerte;
	}


	public int getPrecisionFuerte() {
		return precisionFuerte;
	}

	public String getNombreHabilidad() {
		return nombreHabilidad;
	}


	public int getDatosHabilidad() {
		return datosHabilidad;
	}


	public String getDescripcionHabilidad() {
		return descripcionHabilidad;
	}
	
	public String getMuerte_antes_de_Boss() {
		return Muerte_antes_de_Boss;
	}

	public String getMuerte_Ammit() {
		return Muerte_Ammit;
	}

	public String getMuerte_Boss() {
		return Muerte_Boss;
	}

	public String getVictoria_Boss() {
		return Victoria_Boss;
	}

	public String getBendicion_Ammit() {
		return Bendicion_Ammit;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
	}
	

	public int getOpcionPersonaje() {
		return opcionPersonaje;
	}

	public void setOpcionPersonaje(int opcionPersonaje) {
		this.opcionPersonaje = opcionPersonaje;
	}

	public void ElegirPersonaje() {
	    opcionPersonaje = 0;
	    confirmacionSeleccionPersonaje = "";
	    numeroPersonajes = ConectarBDD.obtenerNumeroDeFilas("personajes");
	    while (opcionPersonaje < 1 || opcionPersonaje > numeroPersonajes) {
	        System.out.println("Elige a tu presonaje:");
			for (int i = 1; i <= numeroPersonajes; i++) {
				System.out.println(i + ". "+ ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = " + i));
			}
	        opcionPersonaje = sc.nextInt();
	        if (opcionPersonaje < 1 || opcionPersonaje > numeroPersonajes) {
	            System.out.println("Opción no válida, elige un personaje entre 1 y " + numeroPersonajes + ".");
	        }
	            confirmacionSeleccionPersonaje = "";
	            sc.nextLine();
	            System.out.println("Has elegido a " + ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes =" + opcionPersonaje) + " que tiene " + ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes =" + opcionPersonaje) + " puntos de vida y los siguientes ataques:");
	            System.out.println("\nAtaque básico (" + ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques =" + opcionPersonaje) + "): " + ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques =" + opcionPersonaje) + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques =" + opcionPersonaje) + ".");
	            System.out.println("\nAtaque fuerte (" + ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques =" + opcionPersonaje) + "): " + ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques =" + opcionPersonaje) + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques =" + opcionPersonaje) + ".");
	            System.out.println("\nHabilidad especial (" + ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques =" + opcionPersonaje) + "): " + ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques =" + opcionPersonaje) + " puntos de efecto de habilidad. " + ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques =" + opcionPersonaje) + ".");
	            System.out.println("\nEstas seguro de que quieres jugar con Ánuket? (S para confirmar/ Cualquier otra tecla para cancelar)");
	            confirmacionSeleccionPersonaje = sc.nextLine();
	            if (confirmacionSeleccionPersonaje.equalsIgnoreCase("S")) {
	                nombrePersonaje = ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes =" + opcionPersonaje);
	                System.out.println("\n¡Has elegido a " + nombrePersonaje + "!");
	                vida = ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes =" + opcionPersonaje);
	                nombreBasico = ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques =" + opcionPersonaje);
	                danoBasico = ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques =" + opcionPersonaje);
	                descripcionBasico = ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques =" + opcionPersonaje);
	                precisionBasico = ConectarBDD.consultarDatosint("precisionBasico", "ataques", "id_ataques =" + opcionPersonaje);
	                nombreFuerte = ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques =" + opcionPersonaje);
	                danoFuerte = ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques =" + opcionPersonaje);
	                descripcionFuerte = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques =" + opcionPersonaje);
	                precisionFuerte = ConectarBDD.consultarDatosint("precisionFuerte", "ataques", "id_ataques =" + opcionPersonaje);
	                nombreHabilidad = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques =" + opcionPersonaje);
	                datosHabilidad = ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques =" + opcionPersonaje);
	                descripcionHabilidad = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques =" + opcionPersonaje);
	                Muerte_antes_de_Boss = ConectarBDD.consultarDatosString("Muerte_antes_de_Boss", "personajes", "id_personajes =" + opcionPersonaje);
	                Muerte_Ammit = ConectarBDD.consultarDatosString("Muerte_Ammit", "personajes", "id_personajes =" + opcionPersonaje);
	                Muerte_Boss = ConectarBDD.consultarDatosString("Muerte_Boss", "personajes", "id_personajes =" + opcionPersonaje);
	                Victoria_Boss = ConectarBDD.consultarDatosString("Victoria_Boss", "personajes", "id_personajes =" + opcionPersonaje);
	                Bendicion_Ammit = ConectarBDD.consultarDatosString("Bendicion_Ammit", "personajes", "id_personajes =" + opcionPersonaje);
				}
	            else {
	                opcionPersonaje = 0;
	            }
	    }
        System.out.println("");
	}
}
