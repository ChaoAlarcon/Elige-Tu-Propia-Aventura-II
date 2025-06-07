package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;
public class Menu {
	Scanner sc = new Scanner(System.in);
	private int opcionUsuario = 0;
	private int opcionMenu;
	private boolean juegoIniciado = true;
	private boolean sesionIniciada = false;
	ConectarBDD ConectarBDD = new ConectarBDD();
	Usuarios Usuarios = new Usuarios();
	Escenarios escenarios = new Escenarios();
	public void mostrarMenu() {
	while (juegoIniciado) {
		while (!sesionIniciada) {
			opcionUsuario = 0;
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
				sesionIniciada = true;
			} else if (opcionUsuario == 2) {
				Usuarios.registrarUsuario();
				sesionIniciada = true;
			}
		}
		opcionMenu = 0;
		while (opcionMenu > 4 || opcionMenu < 1) {
			System.out.println("\n¿Que quieres hacer?");
			System.out.println("1. Jugar");
			System.out.println("2. Mostrar puntuaciones");
			System.out.println("3. Cambiar de usuario");
			System.out.println("4. Salir");
			opcionMenu = sc.nextInt();
			if (opcionMenu > 4 || opcionMenu < 1) {
				System.out.println("Opción no válida");
			}
			if (opcionMenu == 1) {
				escenarios.creacionVariables();
			} else if (opcionMenu == 2) {
				ConectarBDD.consultarPuntuaciones();
			} else if (opcionMenu == 3) {
				sesionIniciada = false;
				System.out.println("Cerrando sesión...");
			} else if (opcionMenu == 4) {
				System.out.println("Saliendo del juego...");
				juegoIniciado = false;
			}
		}
	}	
	}
}
