package main;
import java.util.Scanner;
import java.util.Random;
import java.sql.*;
import main.ConectarBDD;
public class Puzzle1 {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	ConectarBDD conectarBDD = new ConectarBDD();
	private int intentosRestantes = 8;
	private int respuestaUsuario;
	private int solucionPuzzle1;
	private String aceptarPista;
	private boolean puzzleAcertado = false;
	
	public boolean PuzzleAcertado() {
		return puzzleAcertado;
	}
	
	public void iniciarPuzzle1() {
		System.out.println("Puzzle 1: " + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 1"));
		System.out.println("AQUÍ IRÍA EL TEXTO DE BIENVENIDA DEL PUZZLE 1");
		System.out.println(conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 1"));
		solucionPuzzle1 = random.nextInt(20) + 1;
		while (intentosRestantes > 0) {
			System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
			if (intentosRestantes != 8 && intentosRestantes >= 2) {
				aceptarPista = "";
				sc.nextLine();
				System.out.println("Tienes la posibilidad de pedir una pista. Esta te consumirá 2 intentos. ¿Quieres pedir una pista? ([S] para aceptar/Cualquier otra tecla para rechazar)");
	            aceptarPista = sc.nextLine();
	            if (aceptarPista.equalsIgnoreCase("S")) {
		            intentosRestantes = intentosRestantes - 2;
		            if (solucionPuzzle1 > respuestaUsuario) {
		            	System.out.println("La solución es mayor que tu última respuesta. Intenta con un número más alto.");
		            }
		            else if (solucionPuzzle1 < respuestaUsuario) {
	                	System.out.println("La solución es menor que tu última respuesta. Intenta con un número más bajo.");
	                }
	            }
			}
			System.out.println("Introduce un número del 1 al 20:");
			respuestaUsuario = sc.nextInt();
			if (respuestaUsuario == solucionPuzzle1) {
				System.out.println("¡Respuesta correcta! Has completado el Puzzle.");
				intentosRestantes = 0;
				puzzleAcertado = true;
			} else {
				intentosRestantes--;
				System.out.println("Respuesta incorrecta. Inténtalo de nuevo.");
			}
		}
	}
	
}
	
