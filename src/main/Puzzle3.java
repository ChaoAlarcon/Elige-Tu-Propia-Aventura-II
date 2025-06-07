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
	private int fallosDisponibles = 7;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	private boolean puzzle3Acertado = false;
	private boolean acierto = false;
	private String[] palabraSecreta = {"egipto", "babilonia", "sumeria", "grecia", "roma" };
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
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 3");
		System.out.println("Puzzle 3: " + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 3"));
		System.out.println("AQUÍ IRÍA EL TEXTO DE BIENVENIDA DEL PUZZLE 3");
		System.out.println(conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 3"));
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
	            System.out.println("¡Correcto! " + String.join("", letrasAdivinadas));
	        } else {
	            fallosDisponibles--;
	            System.out.println("Letra incorrecta. Intentos restantes: " + fallosDisponibles + " " + String.join("", letrasAdivinadas));
	        }
	        
			if (fallosDisponibles == 0) {
				System.out.println("¡Has perdido! La palabra era: " + palabraSecretaFinal);
				return false;
			}
	
			if (String.join("", letrasAdivinadas).replace(" ", "").equalsIgnoreCase(palabraSecretaFinal)) {
			    System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecretaFinal + " y has completado el Puzzle.");
			    System.out.println("Has ganado " + puntosPuzzle + " puntos.");
			    puntosPuzzle += puntosTotalesUsuario;
			    conectarBDD.actualizarDatos("jugador", "puntos= " + puntosPuzzle, "nombreJugador= '" + usuario.getUsuario() + "'");
			    puzzle3Acertado = true;
			    return true;
			}
	    }
	    return puzzle3Acertado;
	}
}
