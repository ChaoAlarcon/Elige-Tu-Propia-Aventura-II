package main;
import java.sql.*;
import main.ConectarBDD;
public class Juego {
	Personajes personaje = new Personajes();
	ConectarBDD conectarBDD = new ConectarBDD();
	Escenarios escenario = new Escenarios();
	public void juego() {
		personaje.ElegirPersonaje();
		escenario.escenarios();
	}
}
