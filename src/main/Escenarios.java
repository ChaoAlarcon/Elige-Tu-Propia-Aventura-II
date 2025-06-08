package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Escenarios {
	ConectarBDD conectarBDD = new ConectarBDD();
	Batallas batalla = new Batallas();
	Puzzle1 puzzle1 = new Puzzle1();
	Puzzle2 puzzle2 = new Puzzle2();
	Puzzle3 puzzle3 = new Puzzle3();
	Puzzle4 puzzle4 = new Puzzle4();
	Puzzle5 puzzle5 = new Puzzle5();
	Personajes heroe = new Personajes();
	Npc npc = new Npc();
	Enemigos enemigos = new Enemigos();
	Climas climas = new Climas();
	Terrenos terrenos = new Terrenos();
	HorasDelDia horasDelDia = new HorasDelDia();
	private ArrayList<String> nombreEscenario = new ArrayList<>();
	private ArrayList<Integer> numeroIdBatalla = new ArrayList<>();
	private ArrayList<Integer> numeroIdPuzzles = new ArrayList<>();
	private ArrayList<Integer> numeroIdTerreno = new ArrayList<>();
	private ArrayList<Integer> numeroIdClima = new ArrayList<>();
	private ArrayList<Integer> numeroIdHora = new ArrayList<>();
	private ArrayList<Integer> numeroIdNpc = new ArrayList<>();
	private int numeroEscenarios;
	

	public Escenarios(Personajes personajes, Puzzle1 puzzle1, Puzzle2 puzzle2, Puzzle3 puzzle3, Puzzle4 puzzle4, Puzzle5 puzzle5,
	                  ArrayList<String> nombreEscenario, ArrayList<Integer> numeroIdBatalla,
	                  ArrayList<Integer> numeroIdPuzzles, ArrayList<Integer> numeroIdTerreno,
	                  ArrayList<Integer> numeroIdClima, ArrayList<Integer> numeroIdHora,
	                  ArrayList<Integer> numeroIdNpc, int numeroEscenarios) {
	    
	    this.puzzle1 = puzzle1;
	    this.puzzle2 = puzzle2;
	    this.puzzle3 = puzzle3;
	    this.puzzle4 = puzzle4;
	    this.puzzle5 = puzzle5;
	    this.nombreEscenario = nombreEscenario;
	    this.numeroIdBatalla = numeroIdBatalla;
	    this.numeroIdPuzzles = numeroIdPuzzles;
	    this.numeroIdTerreno = numeroIdTerreno;
	    this.numeroIdClima = numeroIdClima;
	    this.numeroIdHora = numeroIdHora;
	    this.numeroIdNpc = numeroIdNpc;
	    this.numeroEscenarios = numeroEscenarios;
	}

	
	public Escenarios() {
		
	}

	public ArrayList<String> getNombreEscenario() {
		return nombreEscenario;
	}

	public void setNombreEscenario(ArrayList<String> nombreEscenario) {
		this.nombreEscenario = nombreEscenario;
	}

	public void creacionEscenarios() {
		batalla.creacionBatallas();
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
	    	puzzle1.setPuzzle1Acertado(false);
	    	puzzle3.setPuzzle3Acertado(false);
	    	System.out.println("\n//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\");
	        System.out.println("Escenario " + j + ": " + nombreEscenario.get(j-1));
	        System.out.println("\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\n");
	        if (numeroIdPuzzles.get(j - 1) != 0) {
	            switch (numeroIdPuzzles.get(j - 1)) {
	                case 1:
	                	System.out.println("Tras derrotar al cactus proseguís vuestro camino hacia la pirámide,\n"
	                			+ "cuando llegáis, os encontráis con un extraño guardián, ¡es Cambises!, pero está momificado,\n"
	                			+ "parece ser que ha intentado adentrarse él solo a la pirámide y no ha sobrevivido,\n"
	                			+ "y ahora es solo un espejismo del guerrero que fue. convertido en mero guardián de puerta.\n");
	                    puzzle1.iniciarPuzzle1();
	                    puzzle3.setPuzzle3Acertado(true);
						if (puzzle1.isPuzzle1Acertado()) {
							batalla.Puzzlecambio1();
						}
	                    break;
	                case 2:
	                	System.out.println("Conseguís pasar por la puerta y os adentráis por un oscuro pasillo,\n"
	                			+ "cuando llegáis al final se encienden unas antorchas y ante vosotros se encuentra una esfinge de 5 metros de altura,\n"
	                			+ "mientras admiráis la belleza de la estructura os sorprende una voz que dice:\n"
	                			+ "“Si querés continuar tenéis que demostrar vuestra valía resolviendo este acertijo:”");
	                    puzzle2.iniciarPuzzle2();
	                    batalla.Puzzlecambio2();
	                    break;
	                case 3:
	                    puzzle3.iniciarPuzzle3();
	                    puzzle1.setPuzzle1Acertado(true);
	                    if (puzzle3.isPuzzle3Acertado()) {
							batalla.Puzzlecambio1();
						}
	                    break;
	                case 4:
	                    puzzle4.iniciarPuzzle4();
	                    batalla.Puzzlecambio2();
	                    break;
	                case 5:
	                    puzzle5.iniciarPuzzle5();
	                    batalla.Puzzlecambio2();
	                    break;
	            }
	        } if (!puzzle1.isPuzzle1Acertado() && numeroIdBatalla.get(j - 1) != 0 || !puzzle3.isPuzzle3Acertado() && numeroIdBatalla.get(j - 1) != 0 ) {
	            batalla.batallas();
	        }
	    }
}

}
