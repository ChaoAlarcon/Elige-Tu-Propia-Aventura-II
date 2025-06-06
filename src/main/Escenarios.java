package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Escenarios {
	ConectarBDD conectarBDD = new ConectarBDD();
	Puzzle1 puzzle1 = new Puzzle1();
	Puzzle2 puzzle2 = new Puzzle2();
	Puzzle3 puzzle3 = new Puzzle3();
	Puzzle4 puzzle4 = new Puzzle4();
	Puzzle5 puzzle5 = new Puzzle5();
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
	    nombreEscenario.clear();
	    numeroIdBatalla.clear();
	    numeroIdPuzzles.clear();
	    numeroIdTerreno.clear();
	    numeroIdClima.clear();
	    numeroIdHora.clear();
	    numeroIdNpc.clear();
		for (int i = 1; i <= numeroEscenarios; i++) {
			nombreEscenario.add(conectarBDD.consultarDatosString("nombreEscenario", "escenarios", "id_escenarios= " + i));
			numeroIdBatalla.add(conectarBDD.consultarDatosint("id_batallas", "escenarios", "id_escenarios= " + i));
			numeroIdPuzzles.add(conectarBDD.consultarDatosint("id_puzzles", "escenarios", "id_escenarios= " + i));
			numeroIdTerreno.add(conectarBDD.consultarDatosint("id_terrenos", "escenarios", "id_escenarios= " + i));
			numeroIdClima.add(conectarBDD.consultarDatosint("id_climas", "escenarios", "id_escenarios= " + i));
			numeroIdHora.add(conectarBDD.consultarDatosint("id_horas_del_dia", "escenarios", "id_escenarios= " + i));
			numeroIdNpc.add(conectarBDD.consultarDatosint("id_npc", "escenarios", "id_escenarios= " + i));
		}
		escenariosIniciar();
	}
	

	public void escenariosIniciar() {
	    for (int j = 1; j <= 10; j++) {
	        System.out.println("Escenario " + j + ": " + nombreEscenario.get(j-1));
	        if (numeroIdPuzzles.get(j - 1) != 0) {
	            System.out.println("Puzzle: " + numeroIdPuzzles.get(j - 1));
	            switch (numeroIdPuzzles.get(j - 1)) {
	                case 1:
	                    puzzle1.iniciarPuzzle1();
	                    break;
	                case 2:
	                    puzzle2.iniciarPuzzle2();
	                    break;
	                case 3:
	                    puzzle3.iniciarPuzzle3();
	                    break;
	                case 4:
	                    puzzle4.iniciarPuzzle4();
	                    break;
	                case 5:
	                    puzzle5.iniciarPuzzle5();
	                    break;
	            }
	        } else if (numeroIdBatalla.get(j - 1) != 0) {
	            System.out.println("jiji");
	        }
	    }
}

}
