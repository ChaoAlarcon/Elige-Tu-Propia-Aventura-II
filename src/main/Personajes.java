package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;
public class Personajes {
	Scanner sc = new Scanner(System.in);
	ConectarBDD ConectarBDD = new ConectarBDD();
	Npc npc = new Npc();
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
	private String final1;
	private String final2;
	private String final3;
	private String final4;
	private String final5;
	private int numeroPersonajes;
	private int ataqueEspecial = 0;
	public Personajes(String nombrePersonaje, int vida, String nombreBasico, int danoBasico, String descripcionBasico, int precisionBasico,
			String nombreFuerte, int danoFuerte, String descripcionFuerte, int precisionFuerte,  String nombreHabilidad, int datosHabilidad,
			String descripcionHabilidad, String final1, String final2, String final3, String final4, String final5, int numeroPersonajes, int ataqueEspecial) {
		this.nombrePersonaje = nombrePersonaje;
		this.vida = vida;
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
		this.final1 = final1;
		this.final2 = final2;
		this.final3 = final3;
		this.final4 = final4;
		this.final5 = final5;
		this.ataqueEspecial = ataqueEspecial;
	}
	
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


	public String getFinal1() {
		return final1;
	}

	public String getFinal2() {
		return final2;
	}

	public String getFinal3() {
		return final3;
	}

	public String getFinal4() {
		return final4;
	}

	public String getFinal5() {
		return final5;
	}

	public int getAtaqueEspecial() {
		return ataqueEspecial;
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
	                final1 = ConectarBDD.consultarDatosString("final_1", "personajes", "id_personajes =" + opcionPersonaje);
	                final2 = ConectarBDD.consultarDatosString("final_2", "personajes", "id_personajes =" + opcionPersonaje);
	                final3 = ConectarBDD.consultarDatosString("final_3", "personajes", "id_personajes =" + opcionPersonaje);
	                final4 = ConectarBDD.consultarDatosString("final_4", "personajes", "id_personajes =" + opcionPersonaje);
	                final5 = ConectarBDD.consultarDatosString("final_5", "personajes", "id_personajes =" + opcionPersonaje);
				}
	            else {
	                opcionPersonaje = 0;
	            }
	    }
        System.out.println("");
        npc.creacionNpcs();
        npc.presentacionCompanero();
	}
}
