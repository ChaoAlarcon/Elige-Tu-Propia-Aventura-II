package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Batallas {
	ConectarBDD conectarBDD = new ConectarBDD();
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	Personajes heroe = new Personajes();
	Enemigos enemigo = new Enemigos();
	Climas clima = new Climas();
	Terrenos terreno = new Terrenos();
	HorasDelDia hora = new HorasDelDia();
	private ArrayList<String> nombreBatalla = new ArrayList<>();
	private int batallaActual = 0;
	private int numeroBatallas;
	
	public Batallas() {
		
	}

	public ArrayList<String> getNombreBatalla() {
		return nombreBatalla;
	}
	

	
	public int getNumeroBatallas() {
		return numeroBatallas;
	}

	public void setNumeroBatallas(int numeroBatallas) {
		this.numeroBatallas = numeroBatallas;
	}

	public void creacionBatallas() {
		numeroBatallas = conectarBDD.obtenerNumeroDeFilas("batallas");
		for (int i = 1; i <= numeroBatallas; i++) {
			nombreBatalla.add(conectarBDD.consultarDatosString("nombreBatalla", "batallas", "id_batallas= " + i));
		}
	}
	
	public void batallas() {
			System.out.println(nombreBatalla.get(batallaActual));
			clima.efectoClima();
			terreno.efectoTerreno();
			hora.efectoHoraDelDia();
	}
}
