package main;
import java.sql.*;
import main.ConectarBDD;
public class Juego {
	Personajes personaje = new Personajes();
	ConectarBDD conectarBDD = new ConectarBDD();
	Npc npc = new Npc();
	public void juego() {
		personaje.ElegirPersonaje();
	}
}
