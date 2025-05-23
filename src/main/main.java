package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/etpa2_g25v2", "root", "");
		System.out.println("Conexión establecida");
		Menu menu = new Menu();	
		menu.mostrarMenu();
	}

}
