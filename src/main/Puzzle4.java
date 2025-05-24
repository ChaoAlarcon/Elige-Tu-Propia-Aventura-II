package main;

import java.util.Random;
import java.util.Scanner;

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
//
	public boolean ejecutarPuzzle(Personaje personaje) {
		
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
