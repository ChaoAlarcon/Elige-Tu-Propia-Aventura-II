package main;

import java.util.Random;
import java.util.Scanner;

/**
 * Rompecabezas: Adivina el número entre 1 y 20.
 * El jugador tiene 6 intentos y puede usar una habilidad especial del personaje.
 */
public class Puzzle1 implements Puzzle {
    Scanner sc; // Para leer lo que escribe el usuario
    Random random = new Random(); // Para generar números aleatorios
    int respuesta; // Guarda la respuesta del jugador
    int numeroAdivinar; // Ahora es variable de clase, accesible en todos los métodos

    /**
     * Constructor: recibe el scanner del juego
     */
    public Puzzle1(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Método principal del rompecabezas
     * @param personaje Personaje que juega (para usar su habilidad especial)
     * @return true si ganó, false si perdió y no quiere reintentar
     */
    public boolean ejecutarPuzzle(PersonajeOld personaje) {
        System.out.println("=== El Guardián de los Números ===");

        boolean seguirJugando = true; // Controla si vuelve a jugar
        boolean victoria = false; // Si acierta el número

        while (seguirJugando) {
            // Generamos un nuevo número cada partida
            numeroAdivinar = random.nextInt(20) + 1; // Entre 1 y 20
            int intentos = 6; // Tiene 6 oportunidades

            System.out.println("\nGuardián: \"¡Bienvenido otra vez, valiente viajero!\"");
            System.out.println("Guardián: \"Tienes 6 intentos para adivinar un número entre 1 y 20.\"");
            System.out.println("Guardián: \"¿Podrás vencerme esta vez?\"");

            // Bucle mientras tenga intentos
            while (intentos > 0) {
                System.out.print("\nTu elección: ");
                respuesta = sc.nextInt();

                if (respuesta == numeroAdivinar) {
                    // Ganó
                    System.out.println("\n¡Felicidades! Adivinaste el número. La puerta se abre.");
                    victoria = true;
                    seguirJugando = false; // Sale del bucle general
                    break; // Sale del bucle de intentos
                } else {
                    darPista(numeroAdivinar, respuesta); // Muestra pista
                    intentos--; // Reduce intentos

                    // Pregunta si quiere usar habilidad especial
                    if (intentos > 0 && personaje.getUsosEspeciales() > 0) {
                        System.out.print("¿Quieres usar tu habilidad especial? (s/n): ");
                        String usarEspecial = sc.next().trim().toLowerCase();

                        if (usarEspecial.equals("s") || usarEspecial.equals("si")) {
                            usarHabilidadEspecial(personaje);
                        }
                    }

                    System.out.println("Te quedan " + intentos + " intentos.");
                }
            }

            // Si no ganó
            if (!victoria) {
                System.out.println("\n¡Fallaste! El número era: " + numeroAdivinar);
                System.out.println("Guardián: \"No eres digno de pasar...\"");
                personaje.usarEspecial(); // Pierde un uso especial

                // Preguntar si quiere volver a intentarlo
                System.out.print("¿Quieres volver a intentarlo? (s/n): ");
                String reintentar = sc.next().trim().toLowerCase();

                if (reintentar.equals("s") || reintentar.equals("si")) {
                    victoria = false; // Reinicia estado para nueva partida
                } else {
                    seguirJugando = false;
                    return false;
                }
            }
        }

        return victoria;
    }

    /**
     * Da una pista si el número es más alto o bajo que el secreto
     */
    private void darPista(int numero, int intento) {
        if (intento < numero) {
            System.out.println("Guardián: \"Demasiado bajo...\"");
        } else {
            System.out.println("Guardián: \"Demasiado alto...\"");
        }
    }

    /**
     * Usa la habilidad especial del personaje
     * Ofrece una pista extra al azar
     */
    private void usarHabilidadEspecial(PersonajeOld personaje) {
        personaje.usarEspecial();
        System.out.println("Usaste tu habilidad especial...");

        // Algunas veces da una pista útil, otras no
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