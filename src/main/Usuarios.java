package main;

import java.sql.*;
import main.ConectarBDD;
import java.util.Scanner;

public class Usuarios {
	private String usuario;
	private String contrasenia;
	private String nuevoUsuario;
	private String nuevaContrasenia;
	private String confirmacionNuevaContrasenia;
	private boolean confirmacionContrasenia = false;
	boolean inicioExitoso = false;
	private String usuarioCompleto;
	Scanner sc = new Scanner(System.in);
	ConectarBDD conectarBDD = new ConectarBDD();
	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void iniciarSesion() {
		inicioExitoso = false;
		while (!inicioExitoso) {
			System.out.println("Nombre de usuario:");
			usuario = sc.nextLine();
			System.out.println("Contraseña:");
			contrasenia = sc.nextLine();
			if (conectarBDD.iniciarSesionBDD("nombreJugador = '" + usuario + "' AND contrasena = '" + contrasenia + "'") == true) {
				System.out.println("Bienvenido " + usuario);
				inicioExitoso = true;
			} else {
				System.out.println("Usuario o contraseña incorrectos, inténtalo de nuevo");
			}
		}
	}

	public void registrarUsuario() {
		System.out.println("Nombre de usuario a crear:");
		nuevoUsuario = sc.nextLine();
		while (!confirmacionContrasenia) {
			System.out.println("Contraseña para nuevo usuario:");
			nuevaContrasenia = sc.nextLine();
			System.out.println("Confirmar nueva contraseña:");
			confirmacionNuevaContrasenia = sc.nextLine();
			if (nuevaContrasenia.equals(confirmacionNuevaContrasenia)) {
				confirmacionContrasenia = true;
			} else {
				System.out.println("Las contraseñas no coinciden, intente nuevamente.");
			}
		}
		usuarioCompleto = "'" + nuevoUsuario + "','" + nuevaContrasenia + "'";
		conectarBDD.insertarDatos("jugador", "nombreJugador, contrasena", usuarioCompleto);
		usuario = nuevoUsuario;
	}
}
