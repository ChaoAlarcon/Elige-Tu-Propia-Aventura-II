package main;

import java.util.Scanner;

public class Puzzle2 {
	//ACERCA DE LA ESFINGE
	Scanner sc = new Scanner(System.in);
	int intentos = 3;
	String respuesta = "";

	public Puzzle2(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(Personaje personaje) {
		System.out.println("Rompecabezas 1: Soy eterno… ¿Qué soy?");
		while (intentos >= 0) {
			respuesta = sc.nextLine();
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
