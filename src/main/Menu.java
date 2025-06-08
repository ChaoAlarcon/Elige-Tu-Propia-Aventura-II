package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;
public class Menu {
	Scanner sc = new Scanner(System.in);
	private int opcionMenu;
	private boolean sesionIniciada = false;
	private boolean juegoIniciado = true;
	ConectarBDD ConectarBDD = new ConectarBDD();
	Usuarios Usuarios = new Usuarios();
	Batallas batalla = new Batallas();
	Escenarios escenarios = new Escenarios();
	public void mostrarMenu() {
		while (juegoIniciado) {
		opcionMenu = 0;
		while (opcionMenu > 4 || opcionMenu < 1) {
			System.out.println("\n--------------------------------");
			System.out.println("¿Que quieres hacer?\n");
			System.out.println("1. Jugar");
			System.out.println("2. Mostrar puntuaciones");
			System.out.println("3. Salir");
			System.out.println("--------------------------------");
			opcionMenu = sc.nextInt();
			if (opcionMenu > 3 || opcionMenu < 1) {
				System.out.println("Opción no válida");
			}
			if (opcionMenu == 1) {
				escenarios.creacionEscenarios();
			} else if (opcionMenu == 2) {
				ConectarBDD.consultarPuntuaciones();
			} else if (opcionMenu == 3) {
				System.out.println("Saliendo del juego...");
				juegoIniciado = false;
			}
		}
	}
	}
}
