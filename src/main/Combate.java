package main;

import java.util.Random;
import java.util.Scanner;

public class Combate {
	Scanner sc = new Scanner(System.in);
	private Random random = new Random();
	private Personaje personaje;
	private Enemigos enemigos;
	private int eleccionAtaque;
	private int acertar;
	private int mitadDanio;
//
	public Combate(Scanner sc, Personaje personaje, Enemigos enemigos) {
		this.sc = sc;
		this.personaje = personaje;
		this.enemigos = enemigos;
	}

	public void iniciar() {
		System.out.println("¡Comienza el combate contra " + enemigos.getNombre() + "!");
		while (personaje.estaVivo() && enemigos.estaVivo()) {
			turnoJugador();
			if (enemigos.estaVivo())
				turnoEnemigo();
		}
		if (personaje.estaVivo()) {
			System.out.println("Has derrotado a " + enemigos.getNombre());
		} else {
			System.out.println("Has muerto. FIN DEL JUEGO.");
		}
	}

	private void turnoJugador() {
		System.out.println("Tu vida: " + personaje.getVida() + " | Vida enemigo: " + enemigos.getVida());
		System.out.println("1) Básico (" + personaje.getAtaqueBasico() + ")");
		System.out.println("2) Especial (" + personaje.getHabilidadEspecial() + ")");
		if (personaje.getUsosEspecial() > 0) {
			System.out.println("3) Fuerte (" + personaje.getAtaqueFuerte() + ") usos: " + personaje.getUsosEspecial());
		}
		if (personaje.getUsosEspecial() == 5)
			System.out.println("4) Favor Ammit");
		eleccionAtaque = sc.nextInt();
		switch (eleccionAtaque) {
		case 1:
			ataqueBasico();
			break;
		case 2:
			usarHabilidad();
			break;
		case 3:
			ataqueFuerte();
			break;
		case 4:
			favorAmmit();
			break;
		default:
			System.out.println("Opción inválida.");
		}
	}

	private void ataqueBasico() {
		acertar = random.nextInt(100);
		if (acertar > 50) {
			enemigos.recibirDanio(personaje.getAtaqueBasico());
			System.out.println("Éxito: infliges " + personaje.getAtaqueBasico());
		} else if (acertar > 25) {
			mitadDanio = personaje.getAtaqueBasico() / 2;
			enemigos.recibirDanio(mitadDanio);
			System.out.println("Golpe débil: sólo " + mitadDanio);
		} else {
			System.out.println("Fallaste.");
		}
	}

	private void usarHabilidad() {
		if (personaje.getNombre().equalsIgnoreCase("Bastet")) {
			System.out.println("Bastet se cura " + personaje.getHabilidadEspecial());
			personaje.recibirDanio(-personaje.getHabilidadEspecial());
		} else if (personaje.getNombre().equalsIgnoreCase("Cambises")) {
			System.out.println("Cambises potencia su arma en +" + personaje.getHabilidadEspecial());
			// Ajustar ataqueBasico/fuerte internamente si quieres...
		} else {
			System.out.println("Ánuket reduce daño enemigo en " + personaje.getHabilidadEspecial());
			// Ajustar temporalmente…
		}
	}

	private void ataqueFuerte() {
		if (personaje.getUsosEspecial() == 0) {
			System.out.println("No tienes usos de ataque fuerte.");
			return;
		}
		personaje.gastarUsoFuerte();
		acertar = random.nextInt(100);
		if (acertar > 50) {
			enemigos.recibirDanio(personaje.getAtaqueFuerte());
			System.out.println("Ataque fuerte: infliges " + personaje.getAtaqueFuerte());
		} else {
			System.out.println("Ataque fuerte fallido.");
		}
	}

	private void favorAmmit() {
		if (personaje.getUsosEspecial() == 0) {
			System.out.println("No tienes el favor de Ammit.");
			return;
		}
		personaje.gastarUsoFuerte();
		enemigos.recibirDanio(999999999);
		System.out.println("¡Favor de Ammit desatado!");
	}

	private void turnoEnemigo() {
		personaje.recibirDanio(enemigos.getAtaque());
		System.out.println(enemigos.getNombre() + " ataca y te quita " + enemigos.getAtaque());
	}
}
