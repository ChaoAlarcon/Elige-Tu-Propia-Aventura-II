package AhoraEsPersonal;

import java.util.Scanner;

public class AcertijoEsfinge implements Puzzle {
	private Scanner sc;

	public AcertijoEsfinge(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(Jugador j) {
		System.out.println("Rompecabezas 1: Soy eterno… ¿Qué soy?");
		int intentos = 3;
		while (intentos >= 0) {
			String respuesta = sc.nextLine();
			if (respuesta.equalsIgnoreCase("Esfinge") || respuesta.equalsIgnoreCase("La esfinge")) {
				System.out.println("¡Correcto!");
				intentos--;
				return true;
			}
			System.out.println("Incorrecto. Te quedan " + intentos);
		}
		System.out.println("Has fallado y pierdes un uso de especial.");
		return false;
	}
}
