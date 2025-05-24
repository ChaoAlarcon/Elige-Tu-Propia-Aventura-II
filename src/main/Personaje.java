package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Personaje {
	Random random = new Random();
	Scanner sc = new Scanner(System.in);

	// ATRIBUTOS
	private String nombre;
	private int vida;
	private int vidaMax;
	private int ataqueBasico;
	private String nombreBasico;
	private int ataqueFuerte;
	private String nombreFuerte;
	private int habilidadEspecial;
	private String nombreHabilidad;
	private int usosEspecial = 0;
	private int opcion;

	ArrayList<Personaje> personajes = new ArrayList<Personaje>();
	Personaje personaje1 = new Personaje("Ánuket", 600, "basico", 20, "fuerte", 30, "especial", 40);
	Personaje personaje2 = new Personaje("Bastet", 600, "basico", 20, "fuerte", 30, "especial", 40);
	Personaje personaje3 = new Personaje("Cambises", 600, "basico", 20, "fuerte", 30, "especial", 40);
	

	// CONSTRUCTORES
	public Personaje(String nombre, int vida, String nombreBasico, int ataqueBasico, 
			String nombreFuerte, int ataqueFuerte, String nombreHabilidad, int habilidadEspecial) {
		this.nombre = nombre;
		this.vida = vida;
		this.vidaMax = vida;
		this.ataqueBasico = ataqueBasico;
		this.nombreBasico = nombreBasico;
		this.ataqueFuerte = ataqueFuerte;
		this.nombreFuerte = nombreFuerte;
		this.habilidadEspecial = habilidadEspecial;
		this.nombreHabilidad = nombreHabilidad;
		

	}
	public Personaje() {
	}

	// OTROS MÉTODOS	
	public void elegirPersonaje(Personaje personaje) {
		personajes.add(personaje1);
		personajes.add(personaje2);
		personajes.add(personaje3);

		System.out.println("Elige a tu peronaje:");
		System.out.println("1. Ánuket");
		System.out.println("2. Bastet");
		System.out.println("3. Cambises");
		opcion = sc.nextInt();

		while (opcion < 1 || opcion > 3) {
			System.out.println("Opción no válida");
			System.out.println("Elige a tu peronaje:");
			System.out.println("1. Ánuket");
			System.out.println("2. Bastet");
			System.out.println("3. Cambises");
			opcion = sc.nextInt();
		}
		if (opcion == 1) {
			System.out.println("Has elegido a Ánuket");
			/*personajeE.setNombre(personaje1.getNombre());
			personajeE.setVida(personaje1.getVida());
			personajeE.setNombreBasico(personaje1.getNombreBasico());
			personajeE.setNombreFuerte(personaje1.getNombreFuerte());
			personajeE.setNombreHabilidad(personaje1.getNombreHabilidad());
			personajeE.setAtaqueBasico(personaje1.getAtaqueBasico());
			personajeE.setAtaqueFuerte(personaje1.getAtaqueFuerte());
			personajeE.setHabilidadEspecial(personaje1.getHabilidadEspecial());*/
		}
		if (opcion == 2) {
			System.out.println("Has elegido a Bastet");
			/*personajeE.setNombre(personaje2.getNombre());
			personajeE.setVida(personaje2.getVida());
			personajeE.setNombreBasico(personaje2.getNombreBasico());
			personajeE.setNombreFuerte(personaje2.getNombreFuerte());
			personajeE.setNombreHabilidad(personaje2.getNombreHabilidad());
			personajeE.setAtaqueBasico(personaje2.getAtaqueBasico());
			personajeE.setAtaqueFuerte(personaje2.getAtaqueFuerte());
			personajeE.setHabilidadEspecial(personaje2.getHabilidadEspecial());*/
			
		}
		if (opcion == 3) {
			System.out.println("Has elegido a Cambises");
			/*personajeE.setNombre(personaje3.getNombre());
			personajeE.setVida(personaje3.getVida());
			personajeE.setNombreBasico(personaje3.getNombreBasico());
			personajeE.setNombreFuerte(personaje3.getNombreFuerte());
			personajeE.setNombreHabilidad(personaje3.getNombreHabilidad());
			personajeE.setAtaqueBasico(personaje3.getAtaqueBasico());
			personajeE.setAtaqueFuerte(personaje3.getAtaqueFuerte());
			personajeE.setHabilidadEspecial(personaje3.getHabilidadEspecial());*/

		}
			
		
		imprimirInfo();

		/*
		 * Combate combate = new Combate(); 
		 * combate.elegirEnemigos(personaje);
		 */

	}

	// GETTERS Y SETTERS	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

	public int getAtaqueBasico() {
		return ataqueBasico;
	}

	public void setAtaqueBasico(int ataqueBasico) {
		this.ataqueBasico = ataqueBasico;
	}

	public int getAtaqueFuerte() {
		return ataqueFuerte;
	}

	public void setAtaqueFuerte(int ataqueFuerte) {
		this.ataqueFuerte = ataqueFuerte;
	}

	public int getHabilidadEspecial() {
		return habilidadEspecial;
	}

	public void setHabilidadEspecial(int habilidadEspecial) {
		this.habilidadEspecial = habilidadEspecial;
	}
	public String getNombreBasico() {
		return nombreBasico;
	}

	public void setNombreBasico(String nombreBasico) {
		this.nombreBasico = nombreBasico;
	}

	public String getNombreFuerte() {
		return nombreFuerte;
	}

	public void setNombreFuerte(String nombreFuerte) {
		this.nombreFuerte = nombreFuerte;
	}

	public String getNombreHabilidad() {
		return nombreHabilidad;
	}

	public void setNombreHabilidad(String nombreHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
	}

	public int getUsosEspecial() {
		return usosEspecial;
	}

	public void setUsosEspecial(int usosEspecial) {
		this.usosEspecial = usosEspecial;
	}

	public int getOpcion() {
		return opcion;
	}

	public void setOpcion(int opcion) {
		this.opcion = opcion;
	}
	
	
	
	// OTROS MÉTODOS
	public void recibirDanio(int danio) {
		vida = Math.max(0, vida - danio);
	}

	public void ganarUsoEspecial() {
		usosEspecial++;
	}

	public void gastarUsoFuerte() {
		if (usosEspecial > 0)
			usosEspecial--;
	}

	public void imprimirInfo() {
		String infoPersonaje = "Nombre: " + nombre + "\n" + "Vida: " + vida + "\n" + "\n"
				+ "Ataque básico: " + ataqueBasico + "\n" + "Ataque fuerte: " + ataqueFuerte + "\n"
				+ "Habilidad especial: " + habilidadEspecial + "\n";
		System.out.println(infoPersonaje);
		System.out.println();
	}

	public boolean estaVivo() {
		return vida > 0;
	}

}
