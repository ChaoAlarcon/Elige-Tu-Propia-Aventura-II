package main;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import main.ConectarBDD;
public class Escenarios {
	ConectarBDD conectarBDD = new ConectarBDD();
	Scanner sc = new Scanner(System.in);
	Batallas batalla = new Batallas();
	Puzzle1 puzzle1 = new Puzzle1();
	Puzzle2 puzzle2 = new Puzzle2();
	Puzzle3 puzzle3 = new Puzzle3();
	Puzzle4 puzzle4 = new Puzzle4();
	Puzzle5 puzzle5 = new Puzzle5();
	Usuarios usuario = new Usuarios();
	Enemigos enemigos = new Enemigos();
	Climas climas = new Climas();
	Terrenos terrenos = new Terrenos();
	HorasDelDia horasDelDia = new HorasDelDia();
	Usuarios Usuarios = new Usuarios();
	private ArrayList<String> nombreEscenario = new ArrayList<>();
	private ArrayList<Integer> numeroIdBatalla = new ArrayList<>();
	private ArrayList<Integer> numeroIdPuzzles = new ArrayList<>();
	private ArrayList<Integer> numeroIdTerreno = new ArrayList<>();
	private ArrayList<Integer> numeroIdClima = new ArrayList<>();
	private ArrayList<Integer> numeroIdHora = new ArrayList<>();
	private ArrayList<Integer> numeroIdNpc = new ArrayList<>();
	private int numeroEscenarios;
	private int puzzlesAcertados = 0;
	private int opcionUsuario = 0;
	

	public Escenarios(Puzzle1 puzzle1, Puzzle2 puzzle2, Puzzle3 puzzle3, Puzzle4 puzzle4, Puzzle5 puzzle5,
	                  ArrayList<String> nombreEscenario, ArrayList<Integer> numeroIdBatalla,
	                  ArrayList<Integer> numeroIdPuzzles, ArrayList<Integer> numeroIdTerreno,
	                  ArrayList<Integer> numeroIdClima, ArrayList<Integer> numeroIdHora,
	                  ArrayList<Integer> numeroIdNpc, int numeroEscenarios, int puzzlesAcertados) {
	    
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
	    this.puzzlesAcertados = puzzlesAcertados;
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
				opcionUsuario = 0;
				while (opcionUsuario > 2 || opcionUsuario < 1) {
					System.out.println("--------------------------------");
					System.out.println("1.Iniciar sesión");
					System.out.println("2.Registrarse");
					System.out.println("--------------------------------");
					opcionUsuario = sc.nextInt();
					if (opcionUsuario > 2 || opcionUsuario < 1) {
						System.out.println("Opción no válida");
					}
				}
				if (opcionUsuario == 1) {
					Usuarios.iniciarSesion();
				} else if (opcionUsuario == 2) {
					Usuarios.registrarUsuario();
				}
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
		batalla.setGameOver(false);
		batalla.setBatallaActual(0);	    	    
	    for (int j = 1; j <= 10; j++) {
	    	if (!batalla.isGameOver()) {
	    		puzzle1.setPuzzle1Acertado(false);
		    	puzzle3.setPuzzle3Acertado(false);
		    	System.out.println("\n//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\");
		        System.out.println("Escenario " + j + ": " + nombreEscenario.get(j-1));
		        System.out.println("\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\\//\n");
		        if (numeroIdPuzzles.get(j - 1) != 0) {
		            switch (numeroIdPuzzles.get(j - 1)) {
		                //CAMBISES
		                case 1:
		                	System.out.println("Tras derrotar al cactus proseguís vuestro camino hacia la pirámide,\n"
		                			+ "cuando llegáis, os encontráis con un extraño guardián, ¡es Cambises!, pero está momificado,\n"
		                			+ "parece ser que ha intentado adentrarse él solo a la pirámide y no ha sobrevivido,\n"
		                			+ "y ahora es solo un espejismo del guerrero que fue. convertido en mero guardián de puerta.\n");
		                    puzzle1.iniciarPuzzle1();
		                    puzzle3.setPuzzle3Acertado(true);
							if (puzzle1.isPuzzle1Acertado()) {
								Usuarios.sumarPuntosPuzzle1();
								batalla.Puzzlecambio1();
								puzzlesAcertados++;
							}
		                    break;
		                //ESFINGE
		                case 2:
		                	System.out.println("Conseguís pasar por la puerta y os adentráis por un oscuro pasillo,\n"
		                			+ "cuando llegáis al final se encienden unas antorchas y ante vosotros se encuentra una esfinge de 5 metros de altura,\n"
		                			+ "mientras admiráis la belleza de la estructura os sorprende una voz que dice:\n"
		                			+ "“Si querés continuar tenéis que demostrar vuestra valía resolviendo este acertijo:”");
		                    puzzle2.iniciarPuzzle2();
		                    batalla.Puzzlecambio2();
							if (puzzle2.isPuzzle2Acertado()) {
								Usuarios.sumarPuntosPuzzle2();
								puzzlesAcertados++;
							}
		                    break;
		                //ENT		                    
		                case 3:
		                    puzzle3.iniciarPuzzle3();
		                    puzzle1.setPuzzle1Acertado(true);
		                    if (puzzle3.isPuzzle3Acertado()) {
		                    	Usuarios.sumarPuntosPuzzle3();
								batalla.Puzzlecambio1();
								puzzlesAcertados++;
		                    }
		                    break;
		                //CARLOS
		                case 4:
		                    puzzle4.iniciarPuzzle4();
		                    batalla.Puzzlecambio2();
							if (puzzle4.isPuzzle4Acertado()) {
								Usuarios.sumarPuntosPuzzle4();
								puzzlesAcertados++;
							}
							if (puzzle4.getPuntosEnemigo() == 5 && puzzle4.getPuntosUsuario() < 4) {
								batalla.Puzzle4Final1();
								System.out.println("“Para continuar pasad por esa puerta azul”");
							}
							else if (puzzle4.getPuntosEnemigo() == 5 && puzzle4.getPuntosUsuario() == 4) {
								batalla.Puzzle4Final2();
								System.out.println("“Para continuar pasad por esa puerta azul”");
							}
							else if (puzzle4.getPuntosUsuario() == 5) {
								batalla.Puzzle4Final3();
								System.out.println("“Para continuar pasad por esa puerta azul”");
							}
							
		                    break;
		                //AMMIT
		                case 5:
		                    puzzle5.iniciarPuzzle5();
		                    batalla.Puzzlecambio2();
							if (puzzle5.isPuzzle5Acertado()) {
								Usuarios.sumarPuntosPuzzle5();
								puzzlesAcertados++;
							}
							if (!puzzle5.isPuzzle5Acertado() && puzzle5.getRespuestasCorrectas() < 3) {
								batalla.Puzzle5Final1();
								batalla.setGameOver(true);
								batalla.setBatallaActual(batalla.getBatallaActual() + 1);
							}
							
							if (!puzzle5.isPuzzle5Acertado() && puzzle5.getRespuestasCorrectas() >= 3 && puzzle5.getRespuestasCorrectas() <= 6) {
								batalla.Puzzle5Final2();
							}
							
							if (puzzle5.isPuzzle5Acertado() && puzzlesAcertados != 5) {
								batalla.Puzzle5Final3();
							}
							
							if (puzzlesAcertados == 5) {
								batalla.Puzzle5Final4();
							}
		                    break;
		            }
		        }  
		        if (!puzzle1.isPuzzle1Acertado() && numeroIdBatalla.get(j - 1) != 0 && puzzlesAcertados != 5 && !batalla.isGameOver() || !puzzle3.isPuzzle3Acertado() && numeroIdBatalla.get(j - 1) != 0 && puzzlesAcertados != 5 && !batalla.isGameOver()) {
		            batalla.batallas();
		        }
				if (puzzlesAcertados == 5) {
					batalla.bendicionAmmit();
				}
	    	}
	    	if (batalla.isGameOver()) {
	    		j = 11;
	    	}
	    }
	    if (batalla.getBatallaActual() == 6 && batalla.isGameOver()) {
	    	batalla.muerteBoss();
	    }
	    if (batalla.getBatallaActual() == 6 && !batalla.isGameOver()) {
	    	batalla.muerteBoss();
	    }
		if (batalla.isGameOver()) {
			System.out.println("FIN DE LA PARTIDA");
		}
}

}
