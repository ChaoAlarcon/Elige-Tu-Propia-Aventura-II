package main;
import java.util.Scanner;
import java.sql.*;
import main.ConectarBDD;
import java.util.Random;
public class Puzzle4 {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	ConectarBDD conectarBDD = new ConectarBDD();
	Usuarios usuario = new Usuarios();
	private boolean puzzle4Acertado = false;
	private int puntosEnemigo = 0;
	private int puntosUsuario = 0;
	private int eleccionOponente;
	private int eleccionJugador;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	String[] opciones = {"Piedra", "Papel", "Tijera"};
	
	public boolean PuzzleAcertado() {
		return puzzle4Acertado;
	}
	
	
	
	public boolean isPuzzle4Acertado() {
		return puzzle4Acertado;
	}



	public void setPuzzle4Acertado(boolean puzzle4Acertado) {
		this.puzzle4Acertado = puzzle4Acertado;
	}



	public boolean iniciarPuzzle4() {
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 4");
		System.out.println("Puzzle 4: " + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 4"));
		System.out.println("AQUÍ IRÍA EL TEXTO DE BIENVENIDA DEL PUZZLE 4");
		System.out.println(conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 4"));
		while (puntosEnemigo != 5 && puntosUsuario != 5) {
			eleccionOponente = random.nextInt(2);
			System.out.println("Elige una opción: ");
			System.out.println("1. Piedra");
			System.out.println("2. Papel");
			System.out.println("3. Tijera");
			System.out.println("Tu elección: ");
			eleccionJugador = sc.nextInt();
			eleccionJugador = eleccionJugador - 1;
			while (eleccionJugador < 0 || eleccionJugador > 2) {
						System.out.println("Esa no es una opción válida.");
						eleccionJugador = sc.nextInt();
						eleccionJugador = eleccionJugador - 1;
			}
		    System.out.println("\nTu elección: " + opciones[eleccionJugador]);
		    System.out.println("Elección de tu enenigo: " + opciones[eleccionOponente]);
					
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
		        System.out.println("Tienes: " + puntosUsuario + " puntos");
		        System.out.println("tu enemigo tiene: " + puntosEnemigo + " puntos");     	
		    } else {
		        System.out.println(" ");
		        System.out.println("¡Has perdido!");
		        puntosEnemigo++;
		        System.out.println(" ");
		        System.out.println("Puntuación: ");
		        System.out.println("Tienes: " + puntosUsuario + " puntos");
		        System.out.println("tu enemigo tiene: " + puntosEnemigo + " puntos");
		    }
		}	
		if (puntosUsuario == 5) {
			System.out.println("¡Felicidades! Has derrotado a tu enemigo y has completado el Puzzle.");
			System.out.println("Has ganado " + puntosPuzzle + " puntos.");
            puntosPuzzle = puntosPuzzle + puntosTotalesUsuario;
			puzzle4Acertado = true;
			return true;
		} 
		if (puntosEnemigo == 5) {
			System.out.println("¡Has perdido! Tu enemigo ha ganado el puzzle.");
			return false;
		}
		return puzzle4Acertado;
	}
}
