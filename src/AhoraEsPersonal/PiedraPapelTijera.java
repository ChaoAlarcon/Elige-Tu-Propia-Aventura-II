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
/*
  while (puntosEnemigo != 3 && puntosUsuario != 3) {
				eleccionOponente = random.nextInt(3);
				System.out.println("Piedra, papel o tijera.... 1, 2, 3!");
				System.out.println("0: Piedra, 1: Papel, 2: Tijera");
				System.out.println("Tu elección");
				eleccionJugador = sc.nextInt();
						
				while (eleccionJugador < 0 || eleccionJugador > 2) {
							System.out.println("Esa no es una opción válida.");
							eleccionJugador = sc.nextInt();
				}
						
				System.out.println("");
			    System.out.println("Tu elección: " + opciones[eleccionJugador]);
			    System.out.println("Elección del guardián: " + opciones[eleccionOponente]);
						
			    if (eleccionJugador == eleccionOponente) {
				    System.out.println("¡Es un empate!");
				    System.out.println("  ");
			            
			    } else if ((eleccionJugador == 0 && eleccionOponente == 2) || 
			    		   (eleccionJugador == 1 && eleccionOponente == 0) || 
			    		   (eleccionJugador == 2 && eleccionOponente == 1)) {
			    	System.out.println("  ");
			        System.out.println("¡Has ganado!");
			        puntosUsuario++;
			        System.out.println("  ");
			        System.out.println("Puntuación: ");
			        System.out.println(personaje + " tienes: " + puntosUsuario + " puntos");
			        System.out.println("El guardián tiene: " + puntosEnemigo + " puntos");
			           	
			    } else {
			        System.out.println(" ");
			        System.out.println("¡Has perdido!");
			        puntosEnemigo++;
			        System.out.println(" ");
			        System.out.println("Puntuación: ");
			        System.out.println(personaje + " tienes: " + puntosUsuario + " puntos");
			        System.out.println("El guardián tiene: " + puntosEnemigo + " puntos");
			    }
			}
					
			if (puntosUsuario == 3) {
				System.out.println(" ");
				System.out.println("Me has derrotado justamente, podéis continuar vuestro camino.");
				numeroJuegosGanados++;
				System.out.println("  ");
				System.out.println(personaje + " y sus 3 aliados continúan su camino");
						
			} else {
				System.out.println(" ");
				System.out.println("Habeis perdido la prueba, podéis pasar a la siguiente zona, pero a cambio de un uso de tu ataque especial " + personaje);
			}
 */
