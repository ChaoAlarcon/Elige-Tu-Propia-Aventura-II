package main;

import java.util.Scanner;

public class Puzzle2 {
    // Constantes para controlar el flujo del puzzle
    private static final int MAX_INTENTOS = 3; // Número máximo de intentos permitidos
    private final Scanner sc; // Scanner para leer la entrada del usuario
    private int intentos; // Contador de intentos restantes

    // Constructor que inicializa el scanner y los intentos
    public Puzzle2(Scanner sc) {
        this.sc = sc;
        this.intentos = MAX_INTENTOS;
    }

    // Método principal que ejecuta el puzzle
    public boolean ejecutarPuzzle(PersonajeOld personaje) {
        mostrarIntroduccion(); // Muestra la introducción narrativa

        // Bucle de intentos mientras el jugador no acierte y tenga intentos
        while (intentos > 0) {
            System.out.print("\n👉 Tu respuesta: ");
            String respuesta = sc.nextLine().trim(); // Lee la respuesta del usuario

            if (esRespuestaCorrecta(respuesta)) { // Verifica si la respuesta es correcta
                System.out.println("\n✨ ¡Correcto! Has superado el enigma de la esfinge.");
                return true; // Finaliza con éxito
            } else {
                intentos--; // Resta un intento
                if (intentos > 0) {
                    System.out.println("\n❌ Respuesta incorrecta. Te quedan " + intentos + " intento(s). Intenta de nuevo...");
                } else {
                    System.out.println("\n💀 Has fallado todos los intentos. La esfinge te castiga perdiendo un uso de tu habilidad especial.");
                }
            }
        }

        return false; // El jugador falló todos los intentos
    }

    // Muestra una introducción narrativa antes del acertijo
    private void mostrarIntroduccion() {
        System.out.println("\n🌑 Una figura mítica surge entre la niebla...");
        esperar(1000); // Espera breve para efecto dramático
        System.out.println("ESFINGE: Solo los sabios pueden continuar su viaje. Responde mi acertijo o perece en el olvido.");
        esperar(2000); // Espera más larga para crear tensión
        System.out.println("\n🧩 Acertijo: \"Soy eterno... no tengo principio ni fin. ¿Qué soy?\"");
    }

    // Verifica si la respuesta ingresada es una de las correctas
    private boolean esRespuestaCorrecta(String respuesta) {
        return respuesta.equalsIgnoreCase("esfinge") || respuesta.equalsIgnoreCase("la esfinge");
    }

    // Método auxiliar para simular pausas (efecto dramático)
    private void esperar(int milisegundos) {
        try {
            Thread.sleep(milisegundos); // Detiene la ejecución por un tiempo
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restaura el estado de interrupción
        }
    }
}




//Antiguo código:

/*
public class Puzzle2 {
	//ACERCA DE LA ESFINGE
	Scanner sc = new Scanner(System.in);
	int intentos = 3;
	String respuesta = "";

	public Puzzle2(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(PersonajeOld personaje) {
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
*/