package main;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que representa el primer rompecabezas del juego:
 * "Adivina el número entre 1 y 20".
 * El jugador tiene 6 intentos y puede usar una habilidad especial del personaje.
 */
public class Puzzle1 implements Puzzle {
    // Scanner para recibir entradas del usuario
    Scanner sc;

    // Generador de números aleatorios
    Random random = new Random();

    // Variable para almacenar la respuesta del jugador
    int respuesta;

    /**
     * Constructor que recibe el scanner principal del juego
     * @param sc Scanner del sistema
     */
    public Puzzle1(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Método que ejecuta el rompecabezas.
     * El jugador debe adivinar un número entre 1 y 20.
     * @param personaje Personaje que está jugando (para usar habilidades especiales)
     * @return true si el jugador adivina, false si pierde y no quiere reintentar
     */
    public boolean ejecutarPuzzle(PersonajeOld personaje) {
        System.out.println("=== El Guardián de los Números ===");

        // Variables para controlar el bucle de reintento
        boolean seguirJugando = true;
        boolean victoria = false;

        // Bucle principal del juego: permite reiniciar si pierde
        while (seguirJugando) {
            // Cada vez que se reinicia, se genera un nuevo número secreto
            int numeroAdivinar = random.nextInt(20) + 1; // Entre 1 y 20
            int intentos = 6; // Intentos por partida

            // Mensaje inicial del guardián
            System.out.println("\nGuardián: \"¡Bienvenido otra vez, valiente viajero!\"");
            System.out.println("Guardián: \"Tienes 6 intentos para adivinar un número entre 1 y 20.\"");
            System.out.println("Guardián: \"¿Podrás vencerme esta vez?\"");

            // Bucle de adivinación: mientras tenga intentos
            while (intentos > 0) {
                System.out.print("\nTu elección: ");
                respuesta = sc.nextInt(); // Recibe el número del jugador

                // Comprobamos si acertó
                if (respuesta == numeroAdivinar) {
                    System.out.println("\n¡Felicidades! Adivinaste el número. La puerta se abre.");
                    victoria = true;
                    seguirJugando = false; // Sale del bucle principal
                    break; // Sale del bucle de intentos
                } else {
                    // Da pista según sea mayor o menor
                    darPista(numeroAdivinar, respuesta);
                    intentos--; // Reduce intentos

                    // Si aún tiene intentos y puede usar habilidad especial
                    if (intentos > 0 && personaje.getUsosEspeciales() > 0) {
                        System.out.print("¿Quieres usar tu habilidad especial? (s/n): ");
                        String usarEspecial = sc.next().trim().toLowerCase();

                        // Comprobamos si dice 's' o 'si', sin importar mayúsculas
                        if (usarEspecial.equals("s") || usarEspecial.equals("si")) {
                            usarHabilidadEspecial(personaje); // Ejecutamos la habilidad
                        }
                    }

                    // Muestra cuántos intentos quedan
                    System.out.println("Te quedan " + intentos + " intentos.");
                }
            }

            // Si el jugador perdió esta ronda
            if (!victoria) {
                System.out.println("\n¡Fallaste! El número era: " + numeroAdivinar);
                System.out.println("Guardián: \"No eres digno de pasar...\"");
                personaje.usarEspecial(); // Penalización: reduce usos del especial

                // Pregunta si quiere reintentar
                System.out.print("¿Quieres volver a intentarlo? (s/n): ");
                String reintentar = sc.next().trim().toLowerCase();

                // Si dice que sí, el bucle continúa
                // Si dice que no, se sale del juego
                if (reintentar.equals("s") || reintentar.equals("si")) {
                    victoria = false; // Reinicia estado
                } else {
                    seguirJugando = false;
                    return false; // Retorna false si abandona
                }
            }
        }

        return victoria; // Retorna true si ganó
    }

    /**
     * Muestra una pista indicando si el número introducido es más alto o bajo
     * @param numeroCorrecto Número que debe adivinarse
     * @param intento Número introducido por el jugador
     */
    private void darPista(int numeroCorrecto, int intento) {
        if (intento < numeroCorrecto) {
            System.out.println("Guardián: \"Demasiado bajo...\"");
        } else {
            System.out.println("Guardián: \"Demasiado alto...\"");
        }
    }

    /**
     * Ejecuta la habilidad especial del personaje (una sola vez por partida).
     * Ofrece una pista adicional al azar.
     * @param personaje Personaje que usa la habilidad
     */
    private void usarHabilidadEspecial(PersonajeOld personaje) {
        personaje.usarEspecial(); // Resta un uso del especial
        System.out.println("Usaste tu habilidad especial...");

        // Aleatoriamente da una pista útil o una falsa
        if (random.nextBoolean()) {
            System.out.println("¡Una chispa de magia te revela algo!");
            System.out.println("Pista extra: El número es " + (numeroAdivinar % 2 == 0 ? "par." : "impar."));
        } else {
            System.out.println("El Guardián ríe: \"¡Tu poder no me afecta!\"");
        }
    }
}


// Antiguo Puzzle1:

/* package main;

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

*/