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
	private int puntosPuzzle1;
	private int puntosPuzzle2;
	private int puntosPuzzle3;
	private int puntosPuzzle4;
	private int puntosPuzzle5;
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
				System.out.println("");
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
		usuarioCompleto = "'" + nuevoUsuario + "','" + nuevaContrasenia + "','0'";
		conectarBDD.insertarDatos("jugador", "nombreJugador, contrasena, puntos", usuarioCompleto);
		usuario = nuevoUsuario;
	}
	
	public void sumarPuntosPuzzle1 () {
		puntosPuzzle1 = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 1");
		conectarBDD.actualizarDatos("jugador", "puntos", puntosPuzzle1, "nombreJugador= '" + usuario + "'");
	}
	
	public void sumarPuntosPuzzle2 () {
		puntosPuzzle2 = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 2");
		conectarBDD.actualizarDatos("jugador", "puntos", puntosPuzzle2, "nombreJugador= '" + usuario + "'");
	}
	
	public void sumarPuntosPuzzle3 () {
		puntosPuzzle3 = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 3");
		conectarBDD.actualizarDatos("jugador", "puntos", puntosPuzzle3, "nombreJugador= '" + usuario + "'");
	}
	
	public void sumarPuntosPuzzle4 () {
		puntosPuzzle4 = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 4");
		conectarBDD.actualizarDatos("jugador", "puntos", puntosPuzzle4, "nombreJugador= '" + usuario + "'");
	}
	
	public void sumarPuntosPuzzle5 () {
		puntosPuzzle5 = conectarBDD.consultarDatosint("puntos", "puzzles", "id_puzzles = 5");
		conectarBDD.actualizarDatos("jugador", "puntos", puntosPuzzle5, "nombreJugador= '" + usuario + "'");
	}
}
