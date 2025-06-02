package main;

import java.util.Scanner;

/**
 * Clase Puzzle5 - Desafío de Conocimiento Universal
 * Implementa un sistema de preguntas y respuestas de cultura general
 * para evaluar el conocimiento del jugador en diferentes áreas
 */
public class Puzzle5Old {
	// Scanner para capturar la entrada del usuario
	private Scanner sc;

	// Array de preguntas de conocimiento general con opciones múltiples
	// Cada pregunta incluye 4 opciones (a, b, c, d) en diferentes categorías:
	// Astronomía, Historia, Geografía, Química, Literatura
	String[] preguntas = {
		"¿Cuál es el planeta más grande del sistema solar?\na)Júpiter\nb)Saturno\nc)Neptuno\nd)Urano",
		"¿En qué año comenzó la Segunda Guerra Mundial?\na)1938\nb)1939\nc)1940\nd)1941",
		"¿Cuál es la capital de Australia?\na)Sídney\nb)Melbourne\nc)Canberra\nd)Perth",
		"¿Qué elemento químico tiene el símbolo 'Au'?\na)Plata\nb)Aluminio\nc)Oro\nd)Hierro",
		"¿Quién escribió 'Cien años de soledad'?\na)Mario Vargas Llosa\nb)Gabriel García Márquez\nc)Jorge Luis Borges\nd)Pablo Neruda",
		"¿Cuál es el océano más grande del mundo?\na)Atlántico\nb)Índico\nc)Ártico\nd)Pacífico",
		"¿En qué continente se encuentra el desierto de Gobi?\na)África\nb)Asia\nc)América del Norte\nd)Australia"
	};

	// Array con las respuestas correctas correspondientes a cada pregunta
	String[] correctas = { "a", "b", "c", "c", "b", "d", "b" };

	// Variables para el control del juego
	String respuesta = "";              // Almacena la respuesta actual del jugador
	private int puntuacion = 0;         // Contador de respuestas correctas
	private boolean juegoGanado = false; // Indica si el jugador ha superado el desafío

	/**
	 * Constructor de la clase Puzzle5
	 * @param sc Scanner compartido para la entrada del usuario
	 */
	public Puzzle5Old(Scanner sc) {
		this.sc = sc;
	}

	/**
	 * Método principal que ejecuta el desafío de conocimiento
	 * Presenta las preguntas una por una, valida las respuestas y calcula la puntuación final
	 * @param personaje Objeto PersonajeOld que representa al jugador
	 * @return boolean true si el jugador supera el desafío, false en caso contrario
	 */
	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		// Presentación del desafío
		System.out.println("\n===== Desafío de Conocimiento: Sabiduría Universal =====\n");
		System.out.println("Los antiguos sabios han puesto a prueba tu conocimiento del mundo...\n");

		// Bucle principal: itera sobre todas las preguntas
		for (int i = 0; i < preguntas.length; i++) {
			// Mostrar pregunta actual
			System.out.println("Pregunta " + (i + 1) + ": " + preguntas[i]);
			respuesta = sc.nextLine().trim().toLowerCase();

			// Validación de entrada: solo acepta opciones a, b, c, d
			while (!respuesta.equals("a") && !respuesta.equals("b") && !respuesta.equals("c") && !respuesta.equals("d")) {
				System.out.println("Respuesta inválida. Intenta de nuevo (a/b/c/d):");
				respuesta = sc.nextLine().trim().toLowerCase();
			}

			// Evaluación de la respuesta
			if (respuesta.equals(correctas[i])) {
				puntuacion++; // Incrementar contador de aciertos
				System.out.println("¡Correcto! Tu sabiduría brilla.\n");
			} else {
				System.out.println("Incorrecto. Los sabios murmuran desaprobación.\n");
			}
		}

		// Mostrar puntuación final
		System.out.println("Tu puntuación: " + puntuacion + "/" + preguntas.length);

		// Evaluación final basada en la puntuación obtenida
		if (puntuacion == preguntas.length) {
			// Puntuación perfecta: 7/7
			System.out.println("¡Perfecto! Tu conocimiento universal es extraordinario. Los dioses te bendicen.");
			juegoGanado = true;
		} else if (puntuacion >= 5) {
			// Puntuación aceptable: 5 o más aciertos
			System.out.println("Tu sabiduría es respetable. Has demostrado ser digno de continuar.");
			juegoGanado = true;
		} else {
			// Puntuación insuficiente: menos de 5 aciertos
			System.out.println("Tu ignorancia decepciona a los antiguos. Deberás enfrentar las consecuencias.");
			juegoGanado = false;
		}

		return juegoGanado; // Retorna el resultado del desafío
	}
}