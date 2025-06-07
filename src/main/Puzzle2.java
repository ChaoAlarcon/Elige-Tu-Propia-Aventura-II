package main;
import java.util.Scanner;
import java.sql.*;
import main.ConectarBDD;
public class Puzzle2 {
	Scanner sc = new Scanner(System.in);
	ConectarBDD conectarBDD = new ConectarBDD();
	Usuarios usuario = new Usuarios();
	private int intentosRestantes = 5;
	private String respuestaUsuario;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	private boolean puzzle2Acertado = false;
	
	public boolean PuzzleAcertado() {
		return puzzle2Acertado;
	}
	
	
	
	public boolean isPuzzle2Acertado() {
		return puzzle2Acertado;
	}



	public void setPuzzle2Acertado(boolean puzzle2Acertado) {
		this.puzzle2Acertado = puzzle2Acertado;
	}



	public boolean iniciarPuzzle2() {
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 2");
		System.out.println("Puzzle 2: " + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 2"));
		System.out.println("AQUÍ IRÍA EL TEXTO DE BIENVENIDA DEL PUZZLE 2");
		System.out.println(conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 2"));

		while (intentosRestantes > 0 && !puzzle2Acertado) {
			System.out.println("Cuanto más quitas, más grande se vuelve. ¿Qué es?" + "\n(Escribe una sola palabra en singular. El acertijo tiene 3 posibles respuestas)");
			if (intentosRestantes > 1) {
				System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
			} else if (intentosRestantes == 1) {
				System.out.println("¡Solo te queda un intento más!");
			}
			System.out.println("Introduce la palabra clave para resolver el puzzle:");
			respuestaUsuario = sc.nextLine().trim();

			if (respuestaUsuario.equalsIgnoreCase("agujero") || respuestaUsuario.equalsIgnoreCase("hoyo") || respuestaUsuario.equalsIgnoreCase("boquete")) {
				System.out.println("¡Respuesta correcta! Has completado el Puzzle.");
				System.out.println("Has ganado " + puntosPuzzle + " puntos.");
				puntosPuzzle = puntosPuzzle + puntosTotalesUsuario;
				conectarBDD.actualizarDatos("jugador", "puntos= " + puntosPuzzle, "nombreJugador= '" + usuario.getUsuario() + "'");
				puzzle2Acertado = true;
				return true;
			} else {
				intentosRestantes--;
				System.out.println("Respuesta incorrecta. Inténtalo de nuevo.");
			}

			if (intentosRestantes == 0 && !puzzle2Acertado) {
				System.out.println("Has agotado todos tus intentos. No has podido resolver el puzzle.");
				return false;
			}
		}
		return puzzle2Acertado;
	}
}
