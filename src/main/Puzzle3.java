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
	Batallas batallas = new Batallas();
	Enemigos enemigos = new Enemigos();
	private int fallosDisponibles = 7;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	private boolean puzzle3Acertado = false;
	private boolean acierto = false;
	private String[] palabraSecreta = {"egipto", "babilonia", "sumeria", "grecia", "roma" };
	private String palabraSecretaFinal;
	private String[] letrasAdivinadas;
	
	public boolean PuzzleAcertado() {
		return puzzle3Acertado;
	}
	
	public boolean iniciarPuzzle3() {
		System.out.println("Después de derrotar al " + getEnemigos().get(batallaActual)
				+ " abrís la puerta y os lleva a una zona de bosque");
		System.out.println("Avanzando por el bosque, os topáis con un " + getEnemigos().get(batallaActual) + 1
				+ ", que dice: Estoy demasiado mayor para pelear, ¿Qué os parece si jugamos a un juego en vez de pelear?\n");
		System.out.println("Nombre Puzzle");
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
	            System.out.println("”Muy mal, pero todavía te quedan intentos.” " + fallosDisponibles + " " + String.join("", letrasAdivinadas));
	        }
	        
			if (fallosDisponibles == 0) {
				 System.out.println("”Jajaja, la palabra era: " + palabraSecretaFinal + " que incompetentes, creía que serias rivales más difíciles, pero veo que os he sobreestimado, ahora que sé que sois así de estúpidos, ¡Os machacare!.”");
				 return false;
			}
	
			if (String.join("", letrasAdivinadas).replace(" ", "").equalsIgnoreCase(palabraSecretaFinal)) {
				System.out.println("”Muy bien, has adivinado la palabra: " + palabraSecretaFinal + " y has completado el puzzle, parece que sois lo suficientemente sabios, os dejaré pasar.”");
			    System.out.println("Has ganado " + puntosPuzzle + " puntos.");
			    puntosPuzzle += puntosTotalesUsuario;
			    conectarBDD.actualizarDatos("jugador", "puntos= " + puntosPuzzle, "nombreJugador= '" + usuario.getUsuario() + "'");
			    puzzle3Acertado = true;
			    batallas.setBatallaActual(batallas.getBatallaActual() + 1);
			    return true;
			}
	    }
	    return puzzle3Acertado;
	}
}
