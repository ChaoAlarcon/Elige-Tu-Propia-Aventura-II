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
	Scanner sc = new Scanner(System.in);
	ConectarBDD conectarBDD = new ConectarBDD();
	public void iniciarSesion() {
	    inicioExitoso = false;
	    while (!inicioExitoso) {
	        System.out.println("Nombre de usuario:");
	        usuario = sc.nextLine();
	        System.out.println("Contraseña:");
	        contrasenia = sc.nextLine();
	        if (conectarBDD.consultarDatos("jugador", "usuario", usuario) 
	                && conectarBDD.consultarDatos("jugador", "contrasenia", contrasenia)) {
	            System.out.println("Bienvenido " + usuario);
	            inicioExitoso = true;
	        } else {
	            System.out.println("Usuario o contraseña incorrectos. Inténtalo de nuevo.");
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
		conectarBDD.insertarDatos("jugador", "usuario", nuevoUsuario);
		conectarBDD.insertarDatos("jugador", "contrasena", nuevaContrasenia);
	}
}
