package main;
import java.util.Scanner;
import java.sql.*;
import main.ConectarBDD;
public class Puzzle5 {
	Scanner sc = new Scanner(System.in);
	ConectarBDD conectarBDD = new ConectarBDD();
	Usuarios usuario = new Usuarios();
	private boolean puzzle5Acertado = false;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	private int respuestaUsuario;
	private int respuestasCorrectas = 0;
	private boolean juegoPerdido = false;
	
	public Puzzle5(int respuestasCorrectas) {
		this.respuestasCorrectas = respuestasCorrectas;
	}
	
	public Puzzle5() {
		
	}

	public boolean PuzzleAcertado() {
		return puzzle5Acertado;
	}
	
	public boolean isPuzzle5Acertado() {
		return puzzle5Acertado;
	}

	public void setPuzzle5Acertado(boolean puzzle5Acertado) {
		this.puzzle5Acertado = puzzle5Acertado;
	}

	public int getRespuestasCorrectas() {
		return respuestasCorrectas;
	}

	public void setRespuestasCorrectas(int respuestasCorrectas) {
		this.respuestasCorrectas = respuestasCorrectas;
	}

	public boolean iniciarPuzzle5() {
		//TRIVIAL
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 5");
		System.out.println("\nUna luz morada, formada por todos los cristales mágicos, os envuelve y os teletransporta.");
		System.out.println("Parece que el hechizo os ha llevado al templo donde recibísteis la misión de la diosa Ammit.\n"
				+ "Cuando llegáis al altar, aparece Ammit, pero tiene un aura oscura alrededor de ella, parece estar corrompida,\n"
				+ "para liberarla tendréis que deshacer el hechizo que la controla, mientras Obi la distrae,\n"
				+ "tendrás que encargarte de resolver las preguntas que forman el hechizo.\n");
		System.out.println("\n" + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 5") + ", " + conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 5"));
		//PRIMERA PREGUNTA
		System.out.println("\n-------------------------------------------------------");
		System.out.println("Primera pregunta: \n¿Cuál es el planeta más grande del sistema solar?");
		System.out.println("1. Júpiter");
		System.out.println("2. Saturno");
		System.out.println("3. Neptuno");
		System.out.println("4. Urano");
		System.out.println("-------------------------------------------------------\n");
		System.out.print("Introduce el número de tu respuesta: ");
		respuestaUsuario = sc.nextInt();
		while (respuestaUsuario < 1 || respuestaUsuario > 4) {
			System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
			respuestaUsuario = sc.nextInt();
		}
		if (respuestaUsuario == 1) {
			System.out.println("¡Respuesta correcta!");
			respuestasCorrectas++;
		} else {
			System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
			juegoPerdido = true;
		}
		//SEGUNDA PREGUNTA
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("Segunda pregunta: \n¿Cuál es el mejor Zelda?");
			System.out.println("1. The Legend of Zelda: Ocarina of Time");
			System.out.println("2. The Legend of Zelda: Breath of the Wild");
			System.out.println("3. The Legend of Zelda: Twilight Princess");
			System.out.println("4. The Legend of Zelda: Majora's Mask");
			System.out.println("-------------------------------------------------------\n");
			System.out.print("Introduce el número de tu respuesta: ");
			respuestaUsuario = sc.nextInt();
			while (respuestaUsuario < 1 || respuestaUsuario > 4) {
				System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
				respuestaUsuario = sc.nextInt();
			}
			if (respuestaUsuario == 1) {
				System.out.println("¡Respuesta correcta!");
				respuestasCorrectas++;
			} else 
				System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
				juegoPerdido = true;
			}
		//TERCERA PREGUNTA
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("Tercera pregunta: \n¿Quién era el dios del sol en la mitología egipcia?");
			System.out.println("1. Anubis");
			System.out.println("2. Osiris");
			System.out.println("3. Ra");
			System.out.println("4. Thot");
			System.out.println("-------------------------------------------------------\n");
			System.out.print("Introduce el número de tu respuesta: ");
			respuestaUsuario = sc.nextInt();
			while (respuestaUsuario < 1 || respuestaUsuario > 4) {
				System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
				respuestaUsuario = sc.nextInt();
			}
			if (respuestaUsuario == 3) {
				System.out.println("¡Respuesta correcta!");
				respuestasCorrectas++;
			} else {
				System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
				juegoPerdido = true;
			}
		}
		//CUARTA PREGUNTA
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("Cuarta pregunta: \n¿Qué elemento químico tiene el símbolo 'Au'?");
			System.out.println("1. Plata");
			System.out.println("2. Aluminio");
			System.out.println("3. Oro");
			System.out.println("4. Hierro");
			System.out.println("-------------------------------------------------------\n");
			System.out.print("Introduce el número de tu respuesta: ");
			respuestaUsuario = sc.nextInt();
			while (respuestaUsuario < 1 || respuestaUsuario > 4) {
				System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
				respuestaUsuario = sc.nextInt();
			}
			if (respuestaUsuario == 3) {
				System.out.println("¡Respuesta correcta!");
				respuestasCorrectas++;
			} else {
				System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
				juegoPerdido = true;
			}
		}
		//QUINTA PREGUNTA
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("Quinta pregunta: \n¿Cuanto es 2 + 2 * 2 + (-2)/2?");
			System.out.println("1. 7");
			System.out.println("2. 5");
			System.out.println("3. 6");
			System.out.println("4. 4");
			System.out.println("-------------------------------------------------------\n");
			System.out.print("Introduce el número de tu respuesta: ");
			respuestaUsuario = sc.nextInt();
			while (respuestaUsuario < 1 || respuestaUsuario > 4) {
				System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
				respuestaUsuario = sc.nextInt();
			}
			if (respuestaUsuario == 2) {
				System.out.println("¡Respuesta correcta!");
				respuestasCorrectas++;
			} else {
				System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
				juegoPerdido = true;
			}
		}
		//SEXTA PREGUNTA
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("Sexta pregunta: \n¿Cuál es el océano más grande del mundo?");
			System.out.println("1. Atlántico");
			System.out.println("2. Índico");
			System.out.println("3. Ártico");
			System.out.println("4. Pacífico");
			System.out.println("-------------------------------------------------------\n");
			System.out.print("Introduce el número de tu respuesta: ");
			respuestaUsuario = sc.nextInt();
			while (respuestaUsuario < 1 || respuestaUsuario > 4) {
				System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
				respuestaUsuario = sc.nextInt();
			}
			if (respuestaUsuario == 4) {
				System.out.println("¡Respuesta correcta!");
				respuestasCorrectas++;
			} else {
				System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
				juegoPerdido = true;
			}
		}
		//SÉPTIMA PREGUNTA
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("\n-------------------------------------------------------");
			System.out.println("Séptima pregunta y última pregunta: \n¿Cuál es el primer pokémon?");
			System.out.println("1. Bulbasaur");
			System.out.println("2. Mew");
			System.out.println("3. Arceus");
			System.out.println("4. Rhydon");
			System.out.println("-------------------------------------------------------\n");
			System.out.print("Introduce el número de tu respuesta: ");
			respuestaUsuario = sc.nextInt();
			while (respuestaUsuario < 1 || respuestaUsuario > 4) {
				System.out.print("Respuesta no válida. Introduce un número entre 1 y 4: ");
				respuestaUsuario = sc.nextInt();
			}
			if (respuestaUsuario == 4) {
				System.out.println("¡Respuesta correcta!");
				respuestasCorrectas++;
			} else {
				System.out.println("Respuesta incorrecta. Has perdido el puzzle.");
				juegoPerdido = true;
			}
		}
		if (respuestasCorrectas == 0) {
			System.out.println("No has acertado ninguna respuesta.");
			return false;
		} else if (respuestasCorrectas <= 2 && respuestasCorrectas != 0) {
			System.out.println("Solamente has acertado " + respuestasCorrectas + " respuesta/s.");
			return false;
		}
		if (respuestasCorrectas <= 2) {
			return false;
		}
		else if (respuestasCorrectas >= 3 && respuestasCorrectas <= 6) {
			System.out.println("Has acertado " + respuestasCorrectas + " respuestas.");
			return false;
		} else if (respuestasCorrectas == 7) {
			System.out.println("Has ganado " + puntosPuzzle + " puntos.");
			puntosPuzzle = puntosPuzzle + puntosTotalesUsuario;
			puzzle5Acertado = true;
			return true;
		}
		return puzzle5Acertado;
	}
}
