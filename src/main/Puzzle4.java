package main;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase Puzzle4 - Juego de Piedra, Papel o Tijera
 * Implementa un sistema de juego clásico al mejor de 3 rondas
 * donde el jugador se enfrenta contra un oponente controlado por la máquina
 */
public class Puzzle4 {
	
	// ==================== ATRIBUTOS DE LA CLASE ====================
	
	/** Scanner para leer la entrada del usuario desde la consola */
	private Scanner sc;
	
	/** Generador de números aleatorios para la elección del enemigo */
	private Random random = new Random();
	
	/** Array que contiene las opciones disponibles del juego */
	private String[] opciones = { "Piedra", "Papel", "Tijera" };
	
	/** Contador de puntos/rondas ganadas por el usuario */
	private int puntosUsuario = 0;
	
	/** Contador de puntos/rondas ganadas por el enemigo */
	private int puntosEnemigo = 0;
	
	/** Variable booleana que indica si el usuario ganó el juego completo */
	private boolean juegoGanado = false;
	
	// ==================== CONSTRUCTOR ====================
	
	/**
	 * Constructor de la clase Puzzle4
	 * @param sc Scanner compartido para la entrada del usuario
	 */
	public Puzzle4(Scanner sc) {
		this.sc = sc;
	}
	
	// ==================== MÉTODO PRINCIPAL ====================
	
	/**
	 * Método principal que ejecuta el rompecabezas de Piedra, Papel o Tijera
	 * Controla el flujo completo del juego hasta que uno de los jugadores alcance 3 victorias
	 * @param personaje Objeto PersonajeOld que representa al jugador
	 * @return boolean true si el jugador gana el juego (3 rondas), false si pierde
	 */
	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		// Mostrar título del rompecabezas con formato
		System.out.println("\nRompecabezas 3: Piedra, Papel o Tijera (al mejor de 3).\n");
		
		// Bucle principal: continúa hasta que uno de los jugadores gane 3 rondas
		while (puntosUsuario < 3 && puntosEnemigo < 3) {
			
			// 1. Mostrar opciones disponibles al jugador
			mostrarOpciones();
			
			// 2. Capturar y validar la elección del jugador (0, 1 o 2)
			int eleccionJugador = leerEntradaUsuario();
			
			// 3. Generar elección aleatoria del enemigo (0, 1 o 2)
			int eleccionOponente = random.nextInt(3);
			
			// 4. Mostrar ambas elecciones de forma legible
			System.out.printf("Tú eliges: %s | Enemigo elige: %s\n", 
				opciones[eleccionJugador], opciones[eleccionOponente]);
			
			// 5. Calcular el resultado de la ronda usando aritmética modular
			// Fórmula: (3 + jugador - oponente) % 3
			// Resultado: 0 = empate, 1 = gana jugador, 2 = gana enemigo
			int resultado = (3 + eleccionJugador - eleccionOponente) % 3;
			
			// 6. Procesar resultado y actualizar puntuaciones
			switch (resultado) {
				case 1: // Jugador gana la ronda
					puntosUsuario++;
					System.out.println("Ganas esta ronda!");
					break;
				case 2: // Enemigo gana la ronda
					puntosEnemigo++;
					System.out.println("Pierdes esta ronda!");
					break;
				default: // Empate (caso 0)
					System.out.println("Empate!");
					break;
			}
			
			// 7. Mostrar puntuación actualizada
			System.out.printf("\nPuntos → Tú: %d | Enemigo: %d\n\n", puntosUsuario, puntosEnemigo);
			
			// 8. Pausa dramática entre rondas
			pausa(1000);
		}
		
		// Determinar el ganador final del juego
		juegoGanado = puntosUsuario == 3;
		
		// Mostrar mensaje final con formato
		System.out.println(juegoGanado ? 
			"\n✔ ¡Ganaste el rompecabezas!" : 
			"\n✖ Perdiste y pierdes el especial.");
		
		return juegoGanado;
	}
	
	// ==================== MÉTODOS AUXILIARES ====================
	
	/**
	 * Muestra las opciones disponibles al jugador de forma numerada
	 * Presenta un menú claro con las tres opciones: Piedra (0), Papel (1), Tijera (2)
	 */
	private void mostrarOpciones() {
		System.out.println("Elige una opción:");
		// Iterar sobre el array de opciones y mostrarlas numeradas
		for (int i = 0; i < opciones.length; i++) {
			System.out.printf("%d: %s\n", i, opciones[i]);
		}
		System.out.print("> ");
	}
	
	/**
	 * Lee y valida la entrada del jugador
	 * Garantiza que solo se acepten valores válidos (0, 1 o 2)
	 * Maneja errores de formato y valores fuera de rango
	 * @return int valor válido entre 0 y 2 que representa la elección del jugador
	 */
	private int leerEntradaUsuario() {
		int entrada = -1; // Inicializar con valor inválido para entrar al bucle
		
		// Bucle hasta obtener una entrada válida
		while (entrada < 0 || entrada > 2) {
			try {
				// Intentar convertir la entrada del usuario a entero
				entrada = Integer.parseInt(sc.nextLine());
				
				// Verificar si está en el rango válido
				if (entrada < 0 || entrada > 2) {
					System.out.println("Entrada inválida. Intenta de nuevo.");
				}
			} catch (NumberFormatException e) {
				// Capturar errores de formato (entrada no numérica)
				System.out.println("Entrada inválida. Intenta de nuevo.");
			}
			System.out.print("\n> ");
		}
		return entrada;
	}
	
	/**
	 * Método utilitario para pausar la ejecución del programa
	 * Añade suspense y mejora la experiencia de usuario entre rondas
	 * @param milisegundos cantidad de tiempo a pausar en milisegundos
	 */
	private void pausa(int milisegundos) {
		try {
			// Pausar el hilo actual por el tiempo especificado
			Thread.sleep(milisegundos);
		} catch (InterruptedException e) {
			// Restaurar el estado de interrupción del hilo si es interrumpido
			Thread.currentThread().interrupt();
		}
	}
}

//Antiguo Código:
/*
public class Puzzle4 {
	// PIEDRA PAPEL O TIJERA
	Scanner sc = new Scanner(System.in);
	private Random random = new Random();
	private String[] opciones = { "Piedra", "Papel", "Tijera" };
	private int puntosUsuario = 0;
	private int puntosEnemigo = 0;
	private int eleccionJugador;
	private int eleccionOponente;
	private boolean juegoGanado = false;

	public Puzzle4(Scanner sc) {
		this.sc = sc;
	}

	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		
		System.out.println("Rompecabezas 3: Piedra, Papel o Tijera (al mejor de 3).");

		while (puntosUsuario < 3 && puntosEnemigo < 3) {
			System.out.println("0:Piedra 1:Papel 2:Tijera");

			eleccionJugador = sc.nextInt();
			eleccionOponente = random.nextInt(3);

			System.out.println("Tú: " + opciones[eleccionJugador] + " | Enemigo: " + opciones[eleccionOponente]);

			if (eleccionJugador == eleccionOponente) {
			} else if ((eleccionJugador + 1) % 3 == eleccionOponente)
				puntosEnemigo++;
			else
				puntosUsuario++;
			System.out.println("Puntos → Tú: " + puntosUsuario + " Enemigo: " + puntosEnemigo);
		}
		juegoGanado = puntosUsuario == 3;
		System.out.println(juegoGanado ? "¡Ganaste!" : "Perdiste y pierdes especial.");
		return juegoGanado;
	}
}

*/
