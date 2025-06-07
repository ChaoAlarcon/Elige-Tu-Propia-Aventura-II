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

	public boolean PuzzleAcertado() {
		return puzzle5Acertado;
	}
	
	public boolean isPuzzle5Acertado() {
		return puzzle5Acertado;
	}

	public void setPuzzle5Acertado(boolean puzzle5Acertado) {
		this.puzzle5Acertado = puzzle5Acertado;
	}

	public boolean iniciarPuzzle5() {
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 5");
		System.out.println("Puzzle 5: " + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 5"));
		System.out.println("AQUÍ IRÍA EL TEXTO DE BIENVENIDA DEL PUZZLE 5");
		System.out.println(conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 5"));
		System.out.println("Primera pregunta: \n¿Cuál es el planeta más grande del sistema solar?");
		System.out.println("1. Júpiter");
		System.out.println("2. Saturno");
		System.out.println("3. Neptuno");
		System.out.println("4. Urano");
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
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("Segunda pregunta: \n¿En qué año comenzó la Segunda Guerra Mundial?");
			System.out.println("1. 1938");
			System.out.println("2. 1939");
			System.out.println("3. 1940");
			System.out.println("4. 1941");
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
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("Tercera pregunta: \n¿Cuál es la capital de Australia?");
			System.out.println("1. Sídney");
			System.out.println("2. Melbourne");
			System.out.println("3. Canberra");
			System.out.println("4. Perth");
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
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("Cuarta pregunta: \n¿Qué elemento químico tiene el símbolo 'Au'?");
			System.out.println("1. Plata");
			System.out.println("2. Aluminio");
			System.out.println("3. Oro");
			System.out.println("4. Hierro");
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
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("Quinta pregunta: \n¿Quién escribió 'Cien años de soledad'?");
			System.out.println("1. Mario Vargas Llosa");
			System.out.println("2. Gabriel García Márquez");
			System.out.println("3. Jorge Luis Borges");
			System.out.println("4. Pablo Neruda");
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
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("Sexta pregunta: \n¿Cuál es el océano más grande del mundo?");
			System.out.println("1. Atlántico");
			System.out.println("2. Índico");
			System.out.println("3. Ártico");
			System.out.println("4. Pacífico");
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
		if (juegoPerdido == false) {
			respuestaUsuario = 0;
			System.out.println("Séptima pregunta y última pregunta: \n¿En qué continente se encuentra el desierto de Gobi?");
			System.out.println("1. África");
			System.out.println("2. Asia");
			System.out.println("3. América del Norte");
			System.out.println("4. Australia");
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
		if (respuestasCorrectas == 0) {
			System.out.println("No has acertado ninguna respuesta.");
		} else if (respuestasCorrectas <= 2 && respuestasCorrectas != 0) {
			System.out.println("Solamente has acertado " + respuestasCorrectas + " respuesta/s.");
		}
		if (respuestasCorrectas <= 2) {
			System.out.println("TEXTO DE MORIR TU Y EL COMPAÑERO");
			return false;
		}
		else if (respuestasCorrectas >= 3 && respuestasCorrectas <= 6) {
			System.out.println("Has acertado " + respuestasCorrectas + " respuestas.");
			System.out.println("TEXTO DE MORIR EL COMPAÑERO Y TU TE CURAS UN POCO");
			return false;
		} else if (respuestasCorrectas == 7) {
			System.out.println("¡Felicidades! Has acertado todas las respuestas.");
			System.out.println("TEXTO DE HABER GANADO EL PUZZLE Y TE CURAS ENTERO");
			System.out.println("Has ganado " + puntosPuzzle + " puntos.");
			puntosPuzzle = puntosPuzzle + puntosTotalesUsuario;
			conectarBDD.actualizarDatos("jugador", "puntos= " + puntosPuzzle,"nombreJugador= '" + usuario.getUsuario() + "'");
			puzzle5Acertado = true;
			return true;
		}
		return puzzle5Acertado;
	}
}
