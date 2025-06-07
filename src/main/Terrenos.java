package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.ArrayList;
public class Terrenos {
	ConectarBDD conectarBDD = new ConectarBDD();
	private ArrayList<String> nombreTerreno = new ArrayList<>();
	private ArrayList<Integer> buffTerreno = new ArrayList<>();
	private ArrayList<String> descripcionBuffTerreno = new ArrayList<>();
	private ArrayList<Integer> penalizacionTerreno = new ArrayList<>();
	private ArrayList<String> descripcionPenalizacionTerreno = new ArrayList<>();
	private ArrayList<Integer> idTerrenosEnEscenarios = new ArrayList<>();
	private int numeroTerrenos;
	private int numeroEscenarios;
	private int terrenoActual;
	private int filaDeTerrenoActual = 0;
	private int efectoVida;
	
	public Terrenos() {

	}

	public ArrayList<String> getNombreTerreno() {
		return nombreTerreno;
	}

	public ArrayList<Integer> getBuffTerreno() {
		return buffTerreno;
	}

	public ArrayList<String> getDescripcionBuffTerreno() {
		return descripcionBuffTerreno;
	}

	public ArrayList<Integer> getPenalizacionTerreno() {
		return penalizacionTerreno;
	}
	
	public ArrayList<String> getDescripcionPenalizacionTerreno() {
		return descripcionPenalizacionTerreno;
	}
	
	public void creacionTerrenos() {
		numeroTerrenos = conectarBDD.obtenerNumeroDeFilas("terrenos");
		numeroEscenarios = conectarBDD.obtenerNumeroDeFilas("escenarios");
	    nombreTerreno.clear();
	    buffTerreno.clear();
	    descripcionBuffTerreno.clear();
	    penalizacionTerreno.clear();
	    descripcionPenalizacionTerreno.clear();
	    idTerrenosEnEscenarios.clear();
		for (int i = 1; i <= numeroTerrenos; i++) {
			nombreTerreno.add(conectarBDD.consultarDatosString("nombreTerreno", "terrenos", "id_terrenos = " + i));
			buffTerreno.add(conectarBDD.consultarDatosint("buff", "terrenos", "id_terrenos = " + i));
			descripcionBuffTerreno.add(conectarBDD.consultarDatosString("descripcionBuff", "terrenos", "id_terrenos = " + i));
			penalizacionTerreno.add(conectarBDD.consultarDatosint("penalizacion", "terrenos", "id_terrenos = " + i));
			descripcionPenalizacionTerreno.add(conectarBDD.consultarDatosString("descripcionPenalizacion","terrenos", "id_terrenos = " + i));
		}
		for (int j = 1; j <= numeroEscenarios; j++) {
			idTerrenosEnEscenarios.add(conectarBDD.consultarDatosint("id_terrenos", "escenarios", "id_escenarios = " + j));
		}
	}
	
	public void efectoTerrenoDescrip() {
		terrenoActual = idTerrenosEnEscenarios.get(filaDeTerrenoActual) - 1;
		if (buffTerreno.get(terrenoActual) != 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			System.out.println("El terreno es " + nombreTerreno.get(terrenoActual) + ".");
			System.out.println("El terreno te da un buff de " + buffTerreno.get(terrenoActual) + " " + descripcionBuffTerreno.get(terrenoActual));
		} else if (penalizacionTerreno.get(terrenoActual) != 0 && buffTerreno.get(terrenoActual) == 0) {
			System.out.println("El terreno es " + nombreTerreno.get(terrenoActual) + ".");
			System.out.println("El terreno te penaliza con " + penalizacionTerreno.get(terrenoActual) + " " + descripcionPenalizacionTerreno.get(terrenoActual));
		} else if (buffTerreno.get(terrenoActual) == 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			System.out.println("El terreno es " + nombreTerreno.get(terrenoActual) + descripcionPenalizacionTerreno.get(terrenoActual));
		} else {
			System.out.println("Error al cargar el terreno.");
		}
	}
	
	public int efectoTerreno() {
		efectoVida = 0;
		terrenoActual = idTerrenosEnEscenarios.get(filaDeTerrenoActual) - 1;
		if (buffTerreno.get(terrenoActual) != 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			efectoVida = buffTerreno.get(terrenoActual);
		} else if (penalizacionTerreno.get(terrenoActual) != 0 && buffTerreno.get(terrenoActual) == 0) {
			efectoVida = -penalizacionTerreno.get(terrenoActual);
		} else if (buffTerreno.get(terrenoActual) == 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			efectoVida = 0;
		} else {
			System.out.println("Error al cargar la hora.");
		}
		return efectoVida;
	}
}
