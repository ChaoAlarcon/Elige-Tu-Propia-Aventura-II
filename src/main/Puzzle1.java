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
	private int puntosPuzzle;
	private boolean puzzle1Acertado = false;
	
	public boolean isPuzzle1Acertado() {
		return puzzle1Acertado;
	}

	public void setPuzzle1Acertado(boolean puzzle1Acertado) {
		this.puzzle1Acertado = puzzle1Acertado;
	}

	public boolean PuzzleAcertado() {
		return puzzle1Acertado;
	}
	
	public boolean iniciarPuzzle1() {
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 1");
		System.out.println("\nAl acercaros os dice: “...uoh uh para paaasar por estaaa puerta tendréis que aaadivinar el número secreeeto”");
		System.out.println("\n" + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 1") + ", " + conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 1"));
		solucionPuzzle1 = random.nextInt(10) + 1;
		while (intentosRestantes > 0 && !puzzle1Acertado) {
			if (intentosRestantes > 1) {
				System.out.println("\n“Tieneeees " + intentosRestantes + " intentooooss restaaanteeess.”");
			} else if (intentosRestantes == 1) {
				System.out.println("\n“¡Sooolo te queeeedaa uun intentoo máaas!");
			}
			//PISTA
			if (intentosRestantes != 8 && intentosRestantes >= 3) {
				aceptarPista = "";
				sc.nextLine();
				System.out.println("\n“Tieneees la poosibilidad de peeedir una pisstaa que teee consumiráaa 2 intentoooss.” \n¿Quieres pedir una pista? ([S] para aceptar/Cualquier otra tecla para rechazar)");
	            aceptarPista = sc.nextLine();
	            if (aceptarPista.equalsIgnoreCase("S")) {
		            intentosRestantes = intentosRestantes - 2;
		            if (solucionPuzzle1 > respuestaUsuario) {
		            	System.out.println("\n“Eeel númerooo es maaayooor que tu últimaaaa respuuuueestaaaa.”");
		            }
		            else if (solucionPuzzle1 < respuestaUsuario) {
	                	System.out.println("\n“Eeel númerooo es meenooor que tu últimaaaa respuuuueestaaaa.”");
	                }
	            }
			}
			System.out.println("\nIntroduce un número del 1 al 10:");
			respuestaUsuario = sc.nextInt();
			//ACIERTO
			if (respuestaUsuario == solucionPuzzle1) {
				System.out.println("\n“Eeese es eel númeroo correctooo oohh, podéis pasaaar.”");
				System.out.println("\nHas ganado: |" + puntosPuzzle + "| puntos de juego.");
				puzzle1Acertado = true;
				return true;
			} 
			//FALLO
			else {
				intentosRestantes--;
				System.out.println("“uuh Eeese nooo es eel númeroo correctooo oohh”");
			}
			//PERDIDO
			if (intentosRestantes == 0 && !puzzle1Acertado) {
				System.out.println("\nHas agotado todos tus intentos. No has podido resolver el puzzle.");
				System.out.println("\nLa solución era: " + solucionPuzzle1);
                System.out.println("\n“You shall not pass!!!”\n");
				return false;
			}
		}
		return puzzle1Acertado;
	}
	
}
	
