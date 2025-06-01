package main;

import java.util.Scanner;

public class Puzzle2 { private final Scanner sc; // Scanner para leer la entrada del usuario

// Constructor que inicializa el scanner
public Puzzle2(Scanner sc) {
    this.sc = sc;
}

// Método principal que ejecuta el puzzle
public boolean ejecutarPuzzle(PersonajeOld personaje) {
    System.out.println("\n🧩 Acertijo: \"Cuanto más quitas, más grande se vuelve. ¿Qué es?\"");
    System.out.print("👉 Tu respuesta: ");
    String respuesta = sc.nextLine().trim();

    if (esRespuestaCorrecta(respuesta)) {
        System.out.println("\n✅ ¡Correcto! Has resuelto el enigma.");
        return true;
    } else {
        System.out.println("\n❌ Incorrecto. Pierdes un uso de tu habilidad especial.");
        return false;
    }
}

// Verifica si la respuesta ingresada es una de las correctas
private boolean esRespuestaCorrecta(String respuesta) {
    return respuesta.equalsIgnoreCase("agujero") || respuesta.equalsIgnoreCase("un agujero");
}

}

