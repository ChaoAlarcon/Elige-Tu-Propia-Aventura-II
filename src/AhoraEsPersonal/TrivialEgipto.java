package AhoraEsPersonal;

import java.util.Scanner;

public class TrivialEgipto implements Puzzle {
	private Scanner sc;
	String[] preguntas = { "¿Río más largo de Egipto? \na)Amazonas \nb)Nilo \nc)Yangtsé \nd)Misisipi",
			"¿Faraón más joven? \na)Ramsés II \nb)Tutankamón \nc)Cleopatra \nd)Akhenatón",
			"¿Estructura en Giza? \na)Muralla \nb)Coliseo \nc)Eiffel \nd)Pirámides",
			"¿Animal de la Esfinge? \na)León \nb)Águila \nc)Serpiente \nd)Gato" };
	String[] correctas = { "b", "b", "d", "a" };
	String respuesta = "";
	private int puntuacion = 0;
	private boolean juegoGanado = false;

	public TrivialEgipto(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(Jugador jugador) {

		for (int i = 0; i < 4; i++) {
			System.out.println("Pregunta " + (i + 1) + ": " + preguntas[i]);
			respuesta = sc.nextLine().toLowerCase();
			while (!respuesta.equals("a") && !respuesta.equals("b") && !respuesta.equals("c") && !respuesta.equals("d")) {
				System.out.println("Respuesta inválida. Intenta de nuevo.");
				respuesta = sc.nextLine().toLowerCase();
			}
			if (respuesta.equals(correctas[i])) {
				puntuacion++;
				System.out.println("¡Correcto!");
			} else {
				System.out.println("Incorrecto.");
			}
		}
		juegoGanado = puntuacion == 4;
		System.out.println("Tu puntuación: " + puntuacion + "/4");
		if (!juegoGanado)
			System.out.println("Fallaste y pierdes especial.");
		return juegoGanado;
	}
}
