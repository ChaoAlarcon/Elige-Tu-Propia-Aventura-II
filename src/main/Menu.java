package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;
public class Menu {
	Scanner sc = new Scanner(System.in);
	private int opcionUsuario = 0;
	private int opcionMenu;
	private boolean juegoIniciado = true;
	ConectarBDD ConectarBDD = new ConectarBDD();
	Usuarios Usuarios = new Usuarios();
	public void mostrarMenu() {
	while (juegoIniciado) {
		while (opcionUsuario > 2 || opcionUsuario < 1) {
			System.out.println("1.Iniciar sesión");
			System.out.println("2.Registrarse");
			opcionUsuario = sc.nextInt();
			if (opcionUsuario > 2 || opcionUsuario < 1) {
				System.out.println("Opción no válida");
			}
		}
		if (opcionUsuario == 1) {
			Usuarios.iniciarSesion();
		} else if (opcionUsuario == 2) {
			Usuarios.registrarUsuario();
		}
		while (opcionMenu > 3 || opcionMenu < 1) {
			System.out.println("¿Que quieres hacer?");
			System.out.println("1. Jugar");
			System.out.println("2.Mostrar puntuaciones");
			System.out.println("3. Salir");
			opcionMenu = sc.nextInt();
			if (opcionMenu > 3 || opcionMenu < 1) {
				System.out.println("Opción no válida");
			}
			if (opcionMenu == 1) {
				//
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
