package main;

public class Menu {
	public void mostrarMenu() {
		System.out.println("¿Que quieres hacer?");
		System.out.println("1. Jugar");
		System.out.println("2.Mostrar puntuaciones");
		String insertSql = "INSERT INTO Jugador (titulo, descripcion, plataforma, precio) VALUES (?,?,?,?)";
	}
}
