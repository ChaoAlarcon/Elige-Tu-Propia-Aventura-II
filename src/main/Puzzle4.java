package main;
import java.util.Scanner;
import java.sql.*;
import main.ConectarBDD;
import java.util.Random;
public class Puzzle4 {
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	ConectarBDD conectarBDD = new ConectarBDD();
	Usuarios usuario = new Usuarios();
	private boolean puzzle4Acertado = false;
	private int puntosEnemigo;
	private int puntosUsuario;
	private int eleccionOponente;
	private int eleccionJugador;
	private int puntosPuzzle;
	private int puntosTotalesUsuario;
	String[] opciones = {"Piedra", "Papel", "Tijera"};


	public Puzzle4(int puntosUsuario, int puntosEnemigo) {
		this.puntosUsuario = puntosUsuario;
		this.puntosEnemigo = puntosEnemigo;
	}

	public Puzzle4() {

	}
	
	public boolean PuzzleAcertado() {
		return puzzle4Acertado;
	}
	
	
	
	public boolean isPuzzle4Acertado() {
		return puzzle4Acertado;
	}



	public void setPuzzle4Acertado(boolean puzzle4Acertado) {
		this.puzzle4Acertado = puzzle4Acertado;
	}

	public int getPuntosEnemigo() {
		return puntosEnemigo;
	}



	public int getPuntosUsuario() {
		return puntosUsuario;
	}



	public boolean iniciarPuzzle4() {
		//PIEDRA, PAPEL O TIJERA
		puntosEnemigo = 0;
	    puntosUsuario = 0;
	    sc.nextLine();
		puntosTotalesUsuario = conectarBDD.consultarDatosint("puntos", "jugador", "nombreJugador = '" + usuario.getUsuario() + "'");
		puntosPuzzle = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 4");
		System.out.println("Después de vencer al Ent, las ramas de los árboles de alrededor, se giran y entremezclan con un fuerte chasquido hasta formar una puerta blanca.");
		System.out.println("“La puerta os lleva a una sala blanca y vacía, donde encontráis al fondo una puerta azul.\n"
				+ "Sin embargo, al adentraros, aparece en el centro un fantasma, este os dice:\n"
				+ "“Esta es una sala segura donde podéis descansar un rato antes de proseguir vuestra aventura.\n"
				+ "También puedo ofreceros un poco de ayuda pero para eso debéis demostrar vuestro valor.");
		System.out.println("\n" + conectarBDD.consultarDatosString("nombrePuzzle", "puzzles", "id_puzzles = 4") + ", " + conectarBDD.consultarDatosString("descripcion", "puzzles", "id_puzzles = 4"));
		while (puntosEnemigo != 5 && puntosUsuario != 5) {
			eleccionOponente = random.nextInt(3);//tiene que ser 3 para que el enemigo elija las 3 opciones, pero así es más fácil para probrar
			System.out.println("\n-------------------------");
			System.out.println("Elige una opción: ");
			System.out.println("1. Piedra");
			System.out.println("2. Papel");
			System.out.println("3. Tijera");
			System.out.println("-------------------------\n");
			System.out.println("Tu elección: ");
			eleccionJugador = sc.nextInt();
			eleccionJugador = eleccionJugador - 1;
			while (eleccionJugador < 0 || eleccionJugador > 2) {
						System.out.println("Esa no es una opción válida.");
						eleccionJugador = sc.nextInt();
						eleccionJugador = eleccionJugador - 1;
			}
		    System.out.println("\nTu elección: " + opciones[eleccionJugador]);
		    System.out.println("Elección de tu enenigo: " + opciones[eleccionOponente]);
					
		    if (eleccionJugador == eleccionOponente) {
			    System.out.println("¡Es un empate!");
			    System.out.println("  ");
		            
		    } else if ((eleccionJugador == 0 && eleccionOponente == 2) || 
		    		   (eleccionJugador == 1 && eleccionOponente == 0) || 
		    		   (eleccionJugador == 2 && eleccionOponente == 1)) {
		    	System.out.println("  ");
		        System.out.println("¡Has ganado!");
		        puntosUsuario++;
		        System.out.println("  ");
		        System.out.println("Puntuación: ");
		        System.out.println("Tienes: " + puntosUsuario + " puntos");
		        System.out.println("tu enemigo tiene: " + puntosEnemigo + " puntos");     	
		    } else {
		        System.out.println(" ");
		        System.out.println("¡Has perdido!");
		        puntosEnemigo++;
		        System.out.println(" ");
		        System.out.println("Puntuación: ");
		        System.out.println("Tienes: " + puntosUsuario + " puntos");
		        System.out.println("tu enemigo tiene: " + puntosEnemigo + " puntos");
		    }
		}	
		if (puntosUsuario == 5) {
			System.out.println("Has ganado |" + puntosPuzzle + "| puntos.");
            puntosPuzzle = puntosPuzzle + puntosTotalesUsuario;
			puzzle4Acertado = true;
			return true;
		} 
		else if (puntosUsuario <= 4 && puntosEnemigo == 5) {
			return false;			
		}
		return puzzle4Acertado;
	}
}
