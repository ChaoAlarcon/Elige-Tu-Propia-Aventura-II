package main;
import java.util.Random;
import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;
public class Personajes {
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	ConectarBDD ConectarBDD = new ConectarBDD();
	private int opcionPersonaje;
	private String confirmacionSeleccionPersonaje;
	private String nombrePersonaje;
	private int vida;
	private String nombreBasico;
	private int danoBasico;
	private String descripcionBasico;
	private String nombreFuerte;
	private int danoFuerte;
	private String descripcionFuerte;
	private String nombreHabilidad;
	private int datosHabilidad;
	private String descripcionHabilidad;
	private String final1;
	private String final2;
	private String final3;
	private String final4;
	private String final5;
	
	public Personajes(String nombrePersonaje, int vida, String nombreBasico, int danoBasico, String descripcionBasico,
			String nombreFuerte, int danoFuerte, String descripcionFuerte, String nombreHabilidad, int datosHabilidad,
			String descripcionHabilidad, String final1, String final2, String final3, String final4, String final5) {
		this.nombrePersonaje = nombrePersonaje;
		this.vida = vida;
		this.nombreBasico = nombreBasico;
		this.danoBasico = danoBasico;
		this.descripcionBasico = descripcionBasico;
		this.nombreFuerte = nombreFuerte;
		this.danoFuerte = danoFuerte;
		this.descripcionFuerte = descripcionFuerte;
		this.nombreHabilidad = nombreHabilidad;
		this.datosHabilidad = datosHabilidad;
		this.descripcionHabilidad = descripcionHabilidad;
		this.final1 = final1;
		this.final2 = final2;
		this.final3 = final3;
		this.final4 = final4;
		this.final5 = final5;
	}
	
	public Personajes() {
		
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

	public String getFinal1() {
		return final1;
	}

	public void setFinal1(String final1) {
		this.final1 = final1;
	}

	public String getFinal2() {
		return final2;
	}

	public void setFinal2(String final2) {
		this.final2 = final2;
	}

	public String getFinal3() {
		return final3;
	}

	public void setFinal3(String final3) {
		this.final3 = final3;
	}

	public String getFinal4() {
		return final4;
	}

	public void setFinal4(String final4) {
		this.final4 = final4;
	}

	public String getFinal5() {
		return final5;
	}

	public void setFinal5(String final5) {
		this.final5 = final5;
	}


	public void ElegirPersonaje() {
	    opcionPersonaje = 0;
	    confirmacionSeleccionPersonaje = "";
	    while (opcionPersonaje < 1 || opcionPersonaje > 3) {
	        System.out.println("Elige a tu presonaje:");
	        System.out.println("1. Ánuket");
	        System.out.println("2. Bastet");
	        System.out.println("3. Gereald");
	        opcionPersonaje = sc.nextInt();
	        if (opcionPersonaje < 1 || opcionPersonaje > 3) {
	            System.out.println("Opción no válida, elige un personaje entre 1 y 3.");
	        }
	        if (opcionPersonaje == 1) {
	            confirmacionSeleccionPersonaje = "";
	            sc.nextLine();
	            System.out.println("Has elegido a " + ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = 1") + " que tiene " + ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes = 1") + " puntos de vida y los siguientes ataques:");
	            System.out.println("Ataque básico (" + ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques = 1") + "): " + ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques = 1") + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques = 1") + ".");
	            System.out.println("Ataque fuerte (" + ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques = 1") + "): " + ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques = 1") + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques = 1") + ".");
	            System.out.println("Habilidad especial (" + ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques = 1") + "): " + ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques = 1") + " puntos de escudo. " + ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques = 1") + ".");
	            System.out.println("Estas seguro de que quieres jugar con Ánuket? (S para confirmar/ Cualquier otra tecla para cancelar)");
	            confirmacionSeleccionPersonaje = sc.nextLine();
	            if (confirmacionSeleccionPersonaje.equalsIgnoreCase("S")) {
	                nombrePersonaje = ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = 1");
	                System.out.println("¡Has elegido a " + nombrePersonaje + "!");
	                vida = ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes = 1");
	                nombreBasico = ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques = 1");
	                danoBasico = ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques = 1");
	                descripcionBasico = ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques = 1");
	                nombreFuerte = ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques = 1");
	                danoFuerte = ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques = 1");
	                descripcionFuerte = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques = 1");
	                nombreHabilidad = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques = 1");
	                datosHabilidad = ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques = 1");
	                descripcionHabilidad = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques = 1");
	                final1 = ConectarBDD.consultarDatosString("final_1", "personajes", "id_personajes = 1");
	                final2 = ConectarBDD.consultarDatosString("final_2", "personajes", "id_personajes = 1");
	                final3 = ConectarBDD.consultarDatosString("final_3", "personajes", "id_personajes = 1");
	                final4 = ConectarBDD.consultarDatosString("final_4", "personajes", "id_personajes = 1");
	                final5 = ConectarBDD.consultarDatosString("final_5", "personajes", "id_personajes = 1");
				}
				if (!confirmacionSeleccionPersonaje.equalsIgnoreCase("")) {
					opcionPersonaje = 0;
				}
	            else {
	                opcionPersonaje = 0;
	            }
	        }
	
	        if (opcionPersonaje == 2) {
	            confirmacionSeleccionPersonaje = "";
	            sc.nextLine();
	            System.out.println("Has elegido a " + ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = 2") + " que tiene " + ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes = 2") + " puntos de vida y los siguientes ataques:");
	            System.out.println("Ataque básico (" + ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques = 2") + "): " + ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques = 2") + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques = 2") + ".");
	            System.out.println("Ataque fuerte (" + ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques = 2") + "): " + ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques = 2") + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques = 2") + ".");
	            System.out.println("Habilidad especial (" + ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques = 2") + "): " + ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques = 2") + " puntos de curación. " + ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques = 2") + ".");
	            System.out.println("Estas seguro de que quieres jugar con Bastet? (S para confirmar/ Cualquier otra tecla para cancelar)");
	            confirmacionSeleccionPersonaje = sc.nextLine();
	            if (confirmacionSeleccionPersonaje.equalsIgnoreCase("S")) {
	                nombrePersonaje = ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = 2");
	                System.out.println("¡Has elegido a " + nombrePersonaje + "!");
	                vida = ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes = 2");
	                nombreBasico = ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques = 2");
	                danoBasico = ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques = 2");
	                descripcionBasico = ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques = 2");
	                nombreFuerte = ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques = 2");
	                danoFuerte = ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques = 2");
	                descripcionFuerte = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques = 2");
	                nombreHabilidad = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques = 2");
	                datosHabilidad = ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques = 2");
	                descripcionHabilidad = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques = 2");
	                final1 = ConectarBDD.consultarDatosString("final_1", "personajes", "id_personajes = 2");
	                final2 = ConectarBDD.consultarDatosString("final_2", "personajes", "id_personajes = 2");
	                final3 = ConectarBDD.consultarDatosString("final_3", "personajes", "id_personajes = 2");
	                final4 = ConectarBDD.consultarDatosString("final_4", "personajes", "id_personajes = 2");
	                final5 = ConectarBDD.consultarDatosString("final_5", "personajes", "id_personajes = 2");
	            } else {
	                opcionPersonaje = 0;
	            }
	        }
	
	        if (opcionPersonaje == 3) {
	            confirmacionSeleccionPersonaje = "";
	            sc.nextLine();
	            System.out.println("Has elegido a " + ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = 3") + " que tiene " + ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes = 3") + " puntos de vida y los siguientes ataques:");
	            System.out.println("Ataque básico (" + ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques = 3") + "): " + ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques = 3") + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques = 3") + ".");
	            System.out.println("Ataque fuerte (" + ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques = 3") + "): " + ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques = 3") + " puntos de daño. " + ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques = 3") + ".");
	            System.out.println("Habilidad especial (" + ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques = 3") + "): " + ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques = 3") + " puntos de aumento de ataque. " + ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques = 3") + ".");
	            System.out.println("Estas seguro de que quieres jugar con Gereald? (S para confirmar/ Cualquier otra tecla para cancelar)");
	            confirmacionSeleccionPersonaje = sc.nextLine();
	            if (confirmacionSeleccionPersonaje.equalsIgnoreCase("S")) {
	                nombrePersonaje = ConectarBDD.consultarDatosString("nombrePersonaje", "personajes", "id_personajes = 3");
	                System.out.println("¡Has elegido a " + nombrePersonaje + "!");
	                vida = ConectarBDD.consultarDatosint("vida", "personajes", "id_personajes = 3");
	                nombreBasico = ConectarBDD.consultarDatosString("nombreBasico", "ataques", "id_ataques = 3");
	                danoBasico = ConectarBDD.consultarDatosint("danoBasico", "ataques", "id_ataques = 3");
	                descripcionBasico = ConectarBDD.consultarDatosString("descripcionBasico", "ataques", "id_ataques = 3");
	                nombreFuerte = ConectarBDD.consultarDatosString("nombreFuerte", "ataques", "id_ataques = 3");
	                danoFuerte = ConectarBDD.consultarDatosint("danoFuerte", "ataques", "id_ataques = 3");
	                descripcionFuerte = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques", "id_ataques = 3");
	                nombreHabilidad = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques", "id_ataques = 3");
	                datosHabilidad = ConectarBDD.consultarDatosint("datosHabilidad", "ataques", "id_ataques = 3");
	                descripcionHabilidad = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques", "id_ataques = 3");
	                final1 = ConectarBDD.consultarDatosString("final_1", "personajes", "id_personajes = 3");
	                final2 = ConectarBDD.consultarDatosString("final_2", "personajes", "id_personajes = 3");
	                final3 = ConectarBDD.consultarDatosString("final_3", "personajes", "id_personajes = 3");
	                final4 = ConectarBDD.consultarDatosString("final_4", "personajes", "id_personajes = 3");
	                final5 = ConectarBDD.consultarDatosString("final_5", "personajes", "id_personajes = 3");
	            } else {
	                opcionPersonaje = 0;
	            }
	        }
	    }
	}
}
