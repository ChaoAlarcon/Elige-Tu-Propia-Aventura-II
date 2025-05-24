package main;

import java.util.Scanner;

public class Puzzle3 {
	// AHORCADO
	Scanner sc = new Scanner(System.in);
	private int intentosRestantes = 6;
	private boolean palabraAdivinada = false;
	private boolean letraEncontrada = false;
	private String entrada = "";
	private String[] palabras = { "Seth", "Anubis", "Horus", "Osiris", "Sekhmet" };
	private String palabraSecreta = palabras[(int) (Math.random() * palabras.length)];
	private int longitud = palabraSecreta.length();
	private char[] letrasAdivinadas = new char[longitud];

	public Puzzle3(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(Personaje personaje) {

		System.out.println(
				"Pasáis a la siguiente cámara, donde os encontráis con Imhotep, sabio sacerdote del Antigüo Egipto, guardián de las almas.");
		System.out.println("''¿Os atrevéis a adentraros en las entrañas del conocimiento prohibido?''");
		System.out.println(
				"Para poder superar esta prueba, tenéis que acertar la palabra secreta. Si falláis, el alma de uno de vosotros quedará atrapada aquí.");
		System.out.println("PISTA: Seth, Anubis, Horus, Osiris, Sekhmet");
		System.out.println(" ");

		// Juego ahorcado

		for (int i = 0; i < longitud; i++) {
			letrasAdivinadas[i] = '-';
		}

		while (intentosRestantes > 0 && !palabraAdivinada) {
			System.out.println("Palabra: " + new String(letrasAdivinadas));
			System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
			System.out.print("Introduce una letra o la palabra completa si la tienes: ");
			entrada = sc.nextLine();

			if (entrada.length() == 1) {
				char letra = entrada.charAt(0);

				for (int i = 0; i < longitud; i++) {

					if (palabraSecreta.charAt(i) == letra) {
						letrasAdivinadas[i] = letra;
						letraEncontrada = true;
					}
				}

				if (!letraEncontrada) {
					intentosRestantes--;
					System.out.println("¡Letra incorrecta!");

				} else {
					System.out.println("Esa letra está en la palabra");
				}

			} else if (entrada.length() == longitud) {

				if (entrada.equalsIgnoreCase(palabraSecreta)) {
					letrasAdivinadas = palabraSecreta.toCharArray();
					System.out.println(" ");
					System.out.println("¡Felicidades! Has adivinado la palabra: " + palabraSecreta);
					palabraAdivinada = true;

				} else {
					intentosRestantes--;
					System.out.println(" ");
					System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
				}

			} else {
				System.out.println("Entrada no válida. Debes introducir una letra o la palabra completa.");
			}

			palabraAdivinada = true;

			for (char c : letrasAdivinadas) {

				if (c == '-') {
					palabraAdivinada = false;
					continue;
				}
			}
		}

		if (!palabraAdivinada) {
			System.out.println(" ");
			System.out.println("¡Has perdido! La palabra era: " + palabraSecreta);
			System.out.println("");
			return false;

		} else {
			System.out.println(" ");
			System.out.println("Has superado la prueba de Imhotep. Se aparta para dejaros paso.");
			System.out.println(" ");
			return true;
		}
	}
}
