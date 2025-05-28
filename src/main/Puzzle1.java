package main;

import java.util.Random;
import java.util.Scanner;

public class Puzzle1 implements  Puzzle{
	//ADIVINA EL NÚMERO
	Scanner sc = new Scanner (System.in);
	Random numeroRandom = new Random();
	int numeroAdivinar = numeroRandom.nextInt(10);
	int intentos = 5;
	int respuesta;
	
	public Puzzle1(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		
		System.out.println("Rompecabezas 2: Adivina el número (0–9).");
		
		while (intentos >= 0) {
			respuesta = sc.nextInt();
			if (respuesta == numeroAdivinar) {
				System.out.println("¡Correcto!");
				intentos--;
				return true;
			}
			System.out.println(respuesta < numeroAdivinar ? "Más alto" : "Más bajo");
			System.out.println("Te quedan " + intentos);
		}
		System.out.println("Fallaste y pierdes un uso de especial.");
		return false;
	}
}