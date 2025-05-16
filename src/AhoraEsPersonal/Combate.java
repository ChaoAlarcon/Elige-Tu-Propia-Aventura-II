package AhoraEsPersonal;

import java.util.Random;
import java.util.Scanner;

public class Combate {
	Scanner sc = new Scanner(System.in);
	private Random random = new Random();
	private Jugador jugador;
	private Enemigos enemigos;
	private int eleccionAtaque;
	private int acertar;
	private int mitadDanio;
	

	public Combate(Scanner sc, Jugador jugador, Enemigos enemigos) {
		this.sc = sc;
		this.jugador = jugador;
		this.enemigos = enemigos;
	}

	public void iniciar() {
		System.out.println("¡Comienza el combate contra " + enemigos.getNombre() + "!");
		while (jugador.estaVivo() && enemigos.estaVivo()) {
			turnoJugador();
			if (enemigos.estaVivo())
				turnoEnemigo();
		}
		if (jugador.estaVivo()) {
			System.out.println("Has derrotado a " + enemigos.getNombre());
		} else {
			System.out.println("Has muerto. FIN DEL JUEGO.");
		}
	}

	private void turnoJugador() {
		System.out.println("Tu vida: " + jugador.getVida() + " | Vida enemigo: " + enemigos.getVida());
		System.out.println("1) Básico (" + jugador.getAtaqueBasico() + ")");
		System.out.println("2) Especial (" + jugador.getHabilidadEspecial() + ")");
		if (jugador.getUsosEspecial() > 0) {
			System.out.println("3) Fuerte (" + jugador.getAtaqueFuerte() + ") usos: " + jugador.getUsosEspecial());
		}
		if (jugador.getUsosEspecial() == 5)
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
			enemigos.recibirDanio(jugador.getAtaqueBasico());
			System.out.println("Éxito: infliges " + jugador.getAtaqueBasico());
		} else if (acertar > 25) {
			mitadDanio = jugador.getAtaqueBasico() / 2;
			enemigos.recibirDanio(mitadDanio);
			System.out.println("Golpe débil: sólo " + mitadDanio);
		} else {
			System.out.println("Fallaste.");
		}
	}

	private void usarHabilidad() {
		if (jugador.getNombre().equalsIgnoreCase("Bastet")) {
			System.out.println("Bastet se cura " + jugador.getHabilidadEspecial());
			jugador.recibirDanio(-jugador.getHabilidadEspecial());
		} else if (jugador.getNombre().equalsIgnoreCase("Cambises")) {
			System.out.println("Cambises potencia su arma en +" + jugador.getHabilidadEspecial());
			// Ajustar ataqueBasico/fuerte internamente si quieres...			
		} else {
			System.out.println("Ánuket reduce daño enemigo en " + jugador.getHabilidadEspecial());
			// Ajustar temporalmente…
		}
	}

	private void ataqueFuerte() {
		if (jugador.getUsosEspecial() == 0) {
			System.out.println("No tienes usos de ataque fuerte.");
			return;
		}
		jugador.gastarUsoFuerte();
		acertar = random.nextInt(100);
		if (acertar > 50) {
			enemigos.recibirDanio(jugador.getAtaqueFuerte());
			System.out.println("Ataque fuerte: infliges " + jugador.getAtaqueFuerte());
		} else {
			System.out.println("Ataque fuerte fallido.");
		}
	}

	private void favorAmmit() {
		if (jugador.getUsosEspecial() == 0) {
			System.out.println("No tienes el favor de Ammit.");
			return;
		}
		jugador.gastarUsoFuerte();
		enemigos.recibirDanio(999999999);
		System.out.println("¡Favor de Ammit desatado!");
	}

	private void turnoEnemigo() {
		jugador.recibirDanio(enemigos.getAtaque());
		System.out.println(enemigos.getNombre() + " ataca y te quita " + enemigos.getAtaque());
	}
}
