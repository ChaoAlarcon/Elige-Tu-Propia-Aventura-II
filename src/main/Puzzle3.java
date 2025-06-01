package main;

import java.util.Scanner;

public class Puzzle3 {
	// JUEGO DE ADIVINAR TEMÁTICA DE CIVILIZACIONES
	Scanner sc = new Scanner(System.in);
	private int intentosRestantes = 7; // Número de intentos disponibles
	private boolean palabraAdivinada = false; // Indica si se ha adivinado la palabra
	private boolean letraEncontrada = false; // Indica si la letra introducida está en la palabra
	private String entrada = ""; // Entrada del usuario

	// Categorías temáticas basadas en el viaje de los guerreros
	private String[][] categorias = {
		{ "Civilizaciones Antiguas", "Egipto", "Babilonia", "Sumeria", "Grecia", "Roma" },
		{ "Civilizaciones Naturales", "Ents", "Druidas", "Silvanos", "Bosqueantiguo", "Dryadas" },
		{ "Civilizaciones Elementales", "Pirokineticos", "HijosdelFuego", "Rocamagmatica", "Vulcanianos", "Lavamantes" },
		{ "Civilizaciones Espirituales", "Espectros", "Fantasmas", "Almasperdidas", "GuardianesEter", "Sombras" },
		{ "Civilizaciones Celestes", "Dioses", "Avatares", "Inmortales", "SeresdeLuz", "Astrales" },
		{ "Civilizaciones Ficticias", "Eazimianos", "Atlantes", "Cyberarcanos", "Sablesluz", "Necrones" },
		{ "Civilizaciones Corruptas", "AmmitOscura", "Cambises", "NoMuertos", "Corrompidos", "Falsosdioses" },
		{ "Civilizaciones Glitch", "ClaseNoEncontrada", "Error404", "Pixelados", "CuadradosGrises", "Instables" }
	};

	// Variables que almacenan la categoría y palabra seleccionadas aleatoriamente
	private String categoria;
	private String palabraSecreta;
	private int longitud; // Longitud de la palabra secreta
	private char[] letrasAdivinadas; // Letras adivinadas por el jugador

	// Constructor del juego
	public Puzzle3(Scanner sc) {
		this.sc = sc;
		// Elegir aleatoriamente una categoría y una palabra dentro de ella
		int categoriaIndex = (int) (Math.random() * categorias.length);
		this.categoria = categorias[categoriaIndex][0];
		this.palabraSecreta = categorias[categoriaIndex][1 + (int) (Math.random() * (categorias[categoriaIndex].length - 1))];
		this.longitud = palabraSecreta.length();
		this.letrasAdivinadas = new char[longitud];
		// Inicializar las letras adivinadas con '-'
		for (int i = 0; i < longitud; i++) letrasAdivinadas[i] = '-';
	}

	// Método que ejecuta el minijuego
	public boolean ejecutarPuzzle(PersonajeOld personaje) {
		System.out.println("Te encuentras frente a una puerta que vibra con energía ancestral.");
		System.out.println("Una inscripción aparece: 'Demuestra tu sabiduría sobre las civilizaciones para continuar.'");
		System.out.println("Categoría: " + categoria);
		System.out.println();

		// Bucle principal del juego
		while (intentosRestantes > 0 && !palabraAdivinada) {
			System.out.println("Palabra: " + new String(letrasAdivinadas));
			System.out.println("Intentos restantes: " + intentosRestantes);
			System.out.print("Introduce una letra o la palabra completa: ");
			entrada = sc.nextLine().trim();
			letraEncontrada = false;

			// Si el jugador introduce una sola letra
			if (entrada.length() == 1) {
				char letra = Character.toLowerCase(entrada.charAt(0));
				// Comprobar si la letra está en la palabra
				for (int i = 0; i < longitud; i++) {
					if (Character.toLowerCase(palabraSecreta.charAt(i)) == letra) {
						letrasAdivinadas[i] = palabraSecreta.charAt(i);
						letraEncontrada = true;
					}
				}
				if (!letraEncontrada) {
					intentosRestantes--;
					System.out.println("Letra incorrecta.");
				} else {
					System.out.println("¡Bien! Letra encontrada.");
				}
			}
			// Si el jugador intenta adivinar la palabra completa
			else if (entrada.length() == palabraSecreta.length()) {
				if (entrada.equalsIgnoreCase(palabraSecreta)) {
					letrasAdivinadas = palabraSecreta.toCharArray();
					palabraAdivinada = true;
					System.out.println("¡Correcto! Has adivinado la palabra: " + palabraSecreta);
					break;
				} else {
					intentosRestantes--;
					System.out.println("Palabra incorrecta.");
				}
			}
			// Si la entrada no es válida
			else {
				System.out.println("Entrada inválida. Introduce una sola letra o la palabra completa.");
			}

			// Comprobar si todas las letras han sido adivinadas
			palabraAdivinada = true;
			for (char c : letrasAdivinadas) {
				if (c == '-') palabraAdivinada = false;
			}
			System.out.println();
		}

		// Resultado del juego
		if (palabraAdivinada) {
			System.out.println("La puerta se abre lentamente revelando el siguiente desafío.");
			return true;
		} else {
			System.out.println("Las runas se apagan. La palabra era: " + palabraSecreta);
			return false;
		}
	}
}
