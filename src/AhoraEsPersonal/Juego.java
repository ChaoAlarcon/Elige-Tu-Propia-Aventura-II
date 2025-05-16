package AhoraEsPersonal;

import java.util.Scanner;

public class Juego {
	private Scanner sc = new Scanner(System.in);
	private Jugador jugador;
	private boolean juegoActivo = true;
	private String personajeElegido;

	public void iniciar() {
		seleccionarPersonaje();
		mostrarIntroduccion();
		runPuzzles();
		runDecisionFinal();
		if (juegoActivo) {
			runCombateFinal();
		}
		sc.close();
	}

	private void seleccionarPersonaje() {
		
		do {
			System.out.println("Elige personaje: Cambises, Bastet o Ánuket");
			personajeElegido = sc.nextLine();
		} while (!CreacionJugador.isValido(personajeElegido));
		jugador = CreacionJugador.crear(personajeElegido);
	}

	private void mostrarIntroduccion() {
		System.out.println();
		System.out.println("¡Comienza la aventura, " + jugador.getNombre() + "!");
		System.out.println("Taharka ha regresado...");
		System.out.println();
	}

	private void runPuzzles() {
		// 1. Acertijo Esfinge
		Puzzle esfinge = new AcertijoEsfinge(sc);
		if (esfinge.ejecutarPuzzle(jugador)) {
			jugador.ganarUsoEspecial();
		}
		// 2. Adivina número
		Puzzle num = new AdivinaNumero(sc);
		if (num.ejecutarPuzzle(jugador)) {
			jugador.ganarUsoEspecial();
		}
		// 3. Piedra Papel Tijera
		Puzzle ppt = new PiedraPapelTijera(sc);
		if (ppt.ejecutarPuzzle(jugador)) {
			jugador.ganarUsoEspecial();
		}
		// 4. Trivial Egipto
		Puzzle trivial = new TrivialEgipto(sc);
		if (trivial.ejecutarPuzzle(jugador)) {
			jugador.ganarUsoEspecial();
		}
		// 5. Ahorcado
		Puzzle ahorcado = new Ahorcado(sc);
		if (ahorcado.ejecutarPuzzle(jugador)) {
			jugador.ganarUsoEspecial();
		}
	}

	private void runDecisionFinal() {
		DecisionAmmit decision = new DecisionAmmit(sc, jugador);
		juegoActivo = decision.ejecutarPuzzle();
	}

	private void runCombateFinal() {
		Enemigos taharka = new Enemigos("Taharka", 600, 50);
		Combate combate = new Combate(sc, jugador, taharka);
		combate.iniciar();
	}
}
