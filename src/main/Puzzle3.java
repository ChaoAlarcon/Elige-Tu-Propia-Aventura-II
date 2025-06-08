package main;
import java.util.Scanner;
import java.sql.*;
import main.ConectarBDD;
import java.util.Random;
public class Puzzle3 {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	ConectarBDD conectarBDD = new ConectarBDD();
	Usuarios usuario = new Usuarios();
	private int fallosDisponibles;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	private boolean puzzle3Acertado;
	private boolean acierto;
	private String[] palabraSecreta = {"abedul", "nogal", "sauce", "secuoya", "melocotonero" };
	private String palabraSecretaFinal;
	private String[] letrasAdivinadas;
	
	public boolean isPuzzle3Acertado() {
		return puzzle3Acertado;
	}

	public void setPuzzle3Acertado(boolean puzzle3Acertado) {
		this.puzzle3Acertado = puzzle3Acertado;
	}

	public boolean PuzzleAcertado() {
		return puzzle3Acertado;
	}
	
	public boolean iniciarPuzzle3() {
		//AHORCADO
		fallosDisponibles = 7;
		acierto = false;
		puzzle3Acertado = false;
		letrasAdivinadas = null;
		sc.nextLine();
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 3");
		System.out.println("Después de derrotar al enemigo, abrís la puerta verde y os lleva a una zona de bosque,\n"
				+ "grandes árboles os rodean, mientras el suelo está cubierto de musgo y hojarasca, un olor a humedad os invade.\n");		
		System.out.println("\nAvanzando por el bosque, os topáis con un Ent, que dice:\n"
				+ "“Estoy demasiado mayor para pelear, ¿Qué os parece si jugamos a un juego en vez de pelear?”\n");
		System.out.println("\n" + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 3") + ", " + conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 3"));
		palabraSecretaFinal = palabraSecreta[random.nextInt(palabraSecreta.length)];
	    letrasAdivinadas = new String[palabraSecretaFinal.length()];
	    for (int i = 0; i < letrasAdivinadas.length; i++) {
	        letrasAdivinadas[i] = "_ ";
	    }
	    System.out.println("Adivina la palabra: " + String.join("", letrasAdivinadas));
	    while (fallosDisponibles > 0 && !puzzle3Acertado) {
	        System.out.print("Introduce una letra: ");
	        char letra = sc.nextLine().toLowerCase().charAt(0);
	
	        acierto = false;
	        for (int i = 0; i < palabraSecretaFinal.length(); i++) {
	            if (palabraSecretaFinal.charAt(i) == letra) {
	                // Check if it's the first letter
	                if (i == 0) {
	                    letrasAdivinadas[i] = Character.toUpperCase(letra) + " ";
	                } else {
	                    letrasAdivinadas[i] = letra + " ";
	                }
	                acierto = true;
	            }
	        }
	
	        if (acierto) {
	            System.out.println("“Letra correcta.” " + String.join("", letrasAdivinadas));
	        } else {
	            fallosDisponibles--;
	            System.out.println("“Muy mal, pero todavía os quedan " + fallosDisponibles + "intentos” " + String.join("", letrasAdivinadas));
	        }
	        
			if (fallosDisponibles == 0) {
				System.out.println("“Jajaja, la palabra era " + palabraSecretaFinal + " que incompetentes, creía que seríais rivales más difíciles, pero veo que os he sobreestimado, ahora que sé que sois así de estúpidos, ¡Os machacaré!.”");
				return false;
			}
	
			if (String.join("", letrasAdivinadas).replace(" ", "").equalsIgnoreCase(palabraSecretaFinal)) {
	            System.out.println("“Muy bien, la palabra era: " + String.join("", letrasAdivinadas) + ", parece que sois lo suficientemente sabios, os dejaré pasar.”");
			    System.out.println("Has ganado |" + puntosPuzzle + "| puntos.");
			    puntosPuzzle += puntosTotalesUsuario;
			    puzzle3Acertado = true;
			    return true;
			}
	    }
	    return puzzle3Acertado;
	}
}
