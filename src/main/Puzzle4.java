package main;

import java.util.Random;
import java.util.Scanner;

public class Puzzle4 {
	// Scanner para leer la entrada del usuario
	private Scanner sc;
	// Generador aleatorio para la elección del enemigo
	private Random random = new Random();
	// Opciones del juego
	private String[] opciones = { "Piedra", "Papel", "Tijera" };
	// Puntos del usuario y del enemigo
	private int puntosUsuario = 0;
	private int puntosEnemigo = 0;
	// Variable para indicar si el usuario ganó el juego
	private boolean juegoGanado = false;

	// Constructor que recibe un Scanner
	public Puzzle4(Scanner sc) {
		this.sc = sc;
	}

	// Método principal que ejecuta el rompecabezas
	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		System.out.println("\n\u001B[1mRompecabezas 3: Piedra, Papel o Tijera (al mejor de 3).\u001B[0m\n");

		// Ciclo hasta que uno gane 3 rondas
		while (puntosUsuario < 3 && puntosEnemigo < 3) {
			mostrarOpciones(); // Mostrar opciones al jugador
			int eleccionJugador = leerEntradaUsuario(); // Leer elección del jugador
			int eleccionOponente = random.nextInt(3); // Elección aleatoria del enemigo

			// Mostrar elecciones
			System.out.printf("T\u00fa eliges: %s | Enemigo elige: %s\n", opciones[eleccionJugador], opciones[eleccionOponente]);

			// Calcular resultado de la ronda (0 = empate, 1 = gana jugador, 2 = gana enemigo)
			int resultado = (3 + eleccionJugador - eleccionOponente) % 3;
			switch (resultado) {
				case 1:
					puntosUsuario++;
					System.out.println("\u001B[32mGanas esta ronda!\u001B[0m");
					break;
				case 2:
					puntosEnemigo++;
					System.out.println("\u001B[31mPierdes esta ronda!\u001B[0m");
					break;
				default:
					System.out.println("\u001B[33mEmpate!\u001B[0m");
					break;
			}

			// Mostrar puntos actuales
			System.out.printf("\nPuntos → T\u00fa: %d | Enemigo: %d\n\n", puntosUsuario, puntosEnemigo);
			pausa(1000); // Espera de 1 segundo
		}

		// Determinar si el jugador ganó
		juegoGanado = puntosUsuario == 3;
		System.out.println(juegoGanado ? "\u001B[1;32m\n\u2714 ¡Ganaste el rompecabezas!\u001B[0m" : "\u001B[1;31m\n\u2716 Perdiste y pierdes el especial.\u001B[0m");
		return juegoGanado;
	}

	// Muestra las opciones disponibles al jugador
	private void mostrarOpciones() {
		System.out.println("Elige una opción:");
		for (int i = 0; i < opciones.length; i++) {
			System.out.printf("%d: %s\n", i, opciones[i]);
		}
		System.out.print("> ");
	}

	// Lee y valida la entrada del jugador
	private int leerEntradaUsuario() {
		int entrada = -1;
		while (entrada < 0 || entrada > 2) {
			try {
				entrada = Integer.parseInt(sc.nextLine()); // Leer línea y convertir a entero
				if (entrada < 0 || entrada > 2) System.out.println("Entrada inválida. Intenta de nuevo.");
			} catch (NumberFormatException e) {
				System.out.println("Entrada inválida. Intenta de nuevo.");
			}
			System.out.print("\n> ");
		}
		return entrada;
	}

	// Método para pausar la ejecución por cierta cantidad de milisegundos
	private void pausa(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
}


//Antiguo Código:
/*
public class Puzzle4 {
	// PIEDRA PAPEL O TIJERA
	Scanner sc = new Scanner(System.in);
	private Random random = new Random();
	private String[] opciones = { "Piedra", "Papel", "Tijera" };
	private int puntosUsuario = 0;
	private int puntosEnemigo = 0;
	private int eleccionJugador;
	private int eleccionOponente;
	private boolean juegoGanado = false;

	public Puzzle4(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		
		System.out.println("Rompecabezas 3: Piedra, Papel o Tijera (al mejor de 3).");

		while (puntosUsuario < 3 && puntosEnemigo < 3) {
			System.out.println("0:Piedra 1:Papel 2:Tijera");

			eleccionJugador = sc.nextInt();
			eleccionOponente = random.nextInt(3);

			System.out.println("Tú: " + opciones[eleccionJugador] + " | Enemigo: " + opciones[eleccionOponente]);

			if (eleccionJugador == eleccionOponente) {
			} else if ((eleccionJugador + 1) % 3 == eleccionOponente)
				puntosEnemigo++;
			else
				puntosUsuario++;
			System.out.println("Puntos → Tú: " + puntosUsuario + " Enemigo: " + puntosEnemigo);
		}
		juegoGanado = puntosUsuario == 3;
		System.out.println(juegoGanado ? "¡Ganaste!" : "Perdiste y pierdes especial.");
		return juegoGanado;
	}
}

*/
