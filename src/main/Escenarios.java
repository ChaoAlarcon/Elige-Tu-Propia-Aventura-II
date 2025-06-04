package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Escenarios {
	ConectarBDD conectarBDD = new ConectarBDD();
	private ArrayList<String> nombreEscenario = new ArrayList<>();
	private ArrayList<Integer> numeroIdBatalla = new ArrayList<>();
	private ArrayList<Integer> numeroIdPuzzles = new ArrayList<>();
	private ArrayList<Integer> numeroIdTerreno = new ArrayList<>();
	private ArrayList<Integer> numeroIdClima = new ArrayList<>();
	private ArrayList<Integer> numeroIdHora = new ArrayList<>();
	private ArrayList<Integer> numeroIdNpc = new ArrayList<>();
	private int numeroEscenarios;
	public Escenarios() {
		
	}

	public ArrayList<String> getNombreEscenario() {
		return nombreEscenario;
	}

	public void setNombreEscenario(ArrayList<String> nombreEscenario) {
		this.nombreEscenario = nombreEscenario;
	}

	public void creacionEscenarios() {
		numeroEscenarios = conectarBDD.obtenerNumeroDeFilas("escenarios");
		for (int i = 1; i <= numeroEscenarios; i++) {
			nombreEscenario.add(conectarBDD.consultarDatosString("nombreEscenario", "escenarios", "id_escenarios= " + i));
			numeroIdBatalla.add(conectarBDD.consultarDatosint("id_batallas", "escenarios", "id_escenarios= " + i));
			numeroIdPuzzles.add(conectarBDD.consultarDatosint("id_puzzles", "escenarios", "id_escenarios= " + i));
			numeroIdTerreno.add(conectarBDD.consultarDatosint("id_terrenos", "escenarios", "id_escenarios= " + i));
			numeroIdClima.add(conectarBDD.consultarDatosint("id_climas", "escenarios", "id_escenarios= " + i));
			numeroIdHora.add(conectarBDD.consultarDatosint("id_horas_del_dia", "escenarios", "id_escenarios= " + i));
			numeroIdNpc.add(conectarBDD.consultarDatosint("id_npc", "escenarios", "id_escenarios= " + i));
		}
	}
	
	public void escenarios() {
		for (int j = 1; j <= numeroEscenarios; j++) {
			
		}
	}
}
