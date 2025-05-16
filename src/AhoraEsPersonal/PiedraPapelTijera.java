package AhoraEsPersonal;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera implements Puzzle {
	private Scanner sc;
	private Random random = new Random();
	private String[] opciones = { "Piedra", "Papel", "Tijera" };

	public PiedraPapelTijera(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(Jugador j) {
		int puntosUsuario = 0;
		int puntosEnemigo = 0;
		System.out.println("Rompecabezas 3: Piedra, Papel o Tijera (al mejor de 3).");
		
		while (puntosUsuario < 3 && puntosEnemigo < 3) {
			System.out.println("0:Piedra 1:Papel 2:Tijera");
			
			int eleccionJugador = sc.nextInt();
			int eleccionOponente = random.nextInt(3);
			
			System.out.println("Tú: " + opciones[eleccionJugador] + " | Enemigo: " + opciones[eleccionOponente]);
			
			if (eleccionJugador == eleccionOponente) {
			} else if ((eleccionJugador + 1) % 3 == eleccionOponente)
				puntosEnemigo++;
			else
				puntosUsuario++;
			System.out.println("Puntos → Tú: " + puntosUsuario + " Enemigo: " + puntosEnemigo);
		}
		boolean juegoGanado = puntosUsuario == 3;
		System.out.println(juegoGanado ? "¡Ganaste!" : "Perdiste y pierdes especial.");
		return juegoGanado;
	}
}
