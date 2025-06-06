package main;

import java.sql.*;
import main.ConectarBDD;

public class Juego {
	Personajes personaje = new Personajes();
	ConectarBDD conectarBDD = new ConectarBDD();

	public void juego() {
		System.out.println(
				"La diosa Ammit os vuelve a pedir ayuda para detener a un nuevo mal que ha surgido en Eazima, un ser que ni la diosa es capaz de entender.\n"
						+ "“Un aprendiz de Taharka, Tahorki, logró sobrevivir y ha abierto un portal a otra dimensión. Tendréis que adentraros en una pirámide que ha caído del portal que ha aparecido en el cielo y derrotar al Tahorki y a la criatura que está distorsionando esta realidad.'\n");
		personaje.ElegirPersonaje();
		System.out.println("“En esta aventura os acompañará Obi un gran guerrero capaz de ayudarte en los combates que os esperan.”\n"
				+ "“Marchar y salvad Eazima.”\n");
	}
}
