package main;
import java.util.Scanner;
import java.util.Random;
import java.sql.*;
import main.ConectarBDD;
public class Puzzle1 {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	ConectarBDD conectarBDD = new ConectarBDD();
	Usuarios usuario = new Usuarios();
	Batallas batallas = new Batallas();
	private int intentosRestantes = 8;
	private int respuestaUsuario;
	private int solucionPuzzle1;
	private String aceptarPista;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	private boolean puzzle1Acertado = false;
	
	
	public boolean PuzzleAcertado() {
		return puzzle1Acertado;
	}
	
	public boolean iniciarPuzzle1() {
		System.out.println("Tras derrotar al cactus prosiguis vuestro camino hacia la pirámide, cuando llegais, os encontráis con un extraño guardián, ¡es Cambises!, pero está momificado, parece ser que ha intentado adentrarse él solo a la pirámide y no ha sobrevivido, y ahora es solo un espejismo del guerrero que fue convertido, en mero guardián.\n");
		System.out.println("Al acercaros os dice: “...uoh uh para paaasar por estaaa puerta tendréis que aaadivinar el número secreeeto”");
		System.out.println("Nombre Puzzle");
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 1");
		System.out.println("Puzzle 1: " + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 1"));
		System.out.println("AQUÍ IRÍA EL TEXTO DE BIENVENIDA DEL PUZZLE 1");
		System.out.println(conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 1"));
		solucionPuzzle1 = random.nextInt(20) + 1;
		while (intentosRestantes > 0 && !puzzle1Acertado) {
			if (intentosRestantes > 1) {
				System.out.println("Tienes " + intentosRestantes + " intentos restantes.");
			} else if (intentosRestantes == 1) {
				System.out.println("¡Solo te queda un intento más!");
			}
			if (intentosRestantes != 8 && intentosRestantes >= 3) {
				aceptarPista = "";
				sc.nextLine();
				System.out.println("Tienes la posibilidad de pedir una pista. Esta te consumirá 2 intentos. ¿Quieres pedir una pista? ([S] para aceptar/Cualquier otra tecla para rechazar)");
	            aceptarPista = sc.nextLine();
	            if (aceptarPista.equalsIgnoreCase("S")) {
		            intentosRestantes = intentosRestantes - 2;
		            if (solucionPuzzle1 > respuestaUsuario) {
		            	System.out.println("La solución es mayor que tu última respuesta. Intenta con un número más alto.");
		            }
		            else if (solucionPuzzle1 < respuestaUsuario) {
	                	System.out.println("La solución es menor que tu última respuesta. Intenta con un número más bajo.");
	                }
	            }
			}
			System.out.println("Introduce un número del 1 al 20:");
			respuestaUsuario = sc.nextInt();
			if (respuestaUsuario == solucionPuzzle1) {
				System.out.println("“Eeese es eel númeroo correctooo oohh, podéis pasaaar.”");
				System.out.println("Has ganado " + puntosPuzzle + " puntos.");
				puntosPuzzle = puntosPuzzle + puntosTotalesUsuario;
				conectarBDD.actualizarDatos("jugador", "puntos= " + puntosPuzzle, "nombreJugador= '" + usuario.getUsuario() + "'");
				puzzle1Acertado = true;
				batallas.setBatallaActual(batallas.getBatallaActual() + 1);
				return true;
			} else {
				intentosRestantes--;
				System.out.println("“uuh Eeese nooo es eel númeroo correctooo oohh”");
			}
			if (intentosRestantes == 0 && !puzzle1Acertado) {
				System.out.println("“You shall not pass!!!”");
				//System.out.println("La solución era: " + solucionPuzzle1);
				return false;
			}
		}
		return puzzle1Acertado;
	}
	
}
	
