package main;

import java.util.Random;
import java.util.Scanner;

public class Personaje {
	Random random = new Random();
	Scanner sc = new Scanner(System.in);
	private String nombre;
	private int vida;
	private int vidaMax;
	private int ataque;
	int opcion;

	

	public Personaje() {
	}

	public Personaje(String nombre, int vida, int ataque) {

		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
	
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public int getVidaMax() {
		return vidaMax;
	}

	public void setVidaMax(int vidaMax) {
		this.vidaMax = vidaMax;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}


	public void atacar(Personaje defensor) {

		if (defensor.getVida() > 0) {
			int resultado = defensor.getVida() - this.ataque;

			defensor.setVida(resultado);

			defensor.imprimirInfo();

		} else {
			System.out.println(defensor.getNombre() + " está muerto/a");
		}

	}

	public void elegirPersonaje(Personaje estudiante) {

		System.out.println("Elige tu estudiante:");
		System.out.println("1. Dimitri, Leones Azules");
		System.out.println("2. Edelgard, Águilas Negras");
		System.out.println("3. Claude, Ciervos Dorados");
		opcion = sc.nextInt();

		while (opcion < 1 || opcion > 3) {
			System.out.println("Opción no válida");
			System.out.println("Elige tu estudiante:");
			System.out.println("1. Dimitri, Leones Azules");
			System.out.println("2. Edelgard, Águilas Negras");
			System.out.println("3. Claude, Ciervos Dorados");
			opcion = sc.nextInt();
		}
		if (opcion == 1) {
			System.out.println("Has elegido a Dimitri");
			estudiante.setNombre("Dimitri");
		}
		if (opcion == 2) {
			System.out.println("Has elegido a Edelgard");
			estudiante.setNombre("Edelgard");
		}
		if (opcion == 3) {
			System.out.println("Has elegido a Claude");
			estudiante.setNombre("Claude");

		}
		estudiante.setVida(random.nextInt(21) + 40);
		estudiante.setVidaMax(getVida());
		estudiante.setAtaque(random.nextInt(6) + 7);

		imprimirInfo();
		Combate combate = new Combate();
		combate.elegirEnemigos(estudiante);
		

	}

	public void imprimirInfo() {
		String personaje = "Estudiante: " + nombre + "\nCasa: " + casa + "\nLema: " + casa.getLema() + "\nVida: " + vida
				+ "\nAtaque: " + ataque + "\nDefensa: " + defensa;

		System.out.println(personaje);
		System.out.println();
	}

}
