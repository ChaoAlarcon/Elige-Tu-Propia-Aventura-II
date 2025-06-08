package main;
import java.sql.*;
import java.util.Random;
import main.ConectarBDD;
import java.util.ArrayList;
public class Terrenos {
	ConectarBDD conectarBDD = new ConectarBDD();
	Random random = new Random();
	private ArrayList<String> nombreTerreno = new ArrayList<>();
	private ArrayList<Integer> buffTerreno = new ArrayList<>();
	private ArrayList<String> descripcionBuffTerreno = new ArrayList<>();
	private ArrayList<Integer> penalizacionTerreno = new ArrayList<>();
	private ArrayList<String> descripcionPenalizacionTerreno = new ArrayList<>();
	private ArrayList<Integer> idTerrenosEnEscenarios = new ArrayList<>();
	private int numeroTerrenos;
	private int numeroEscenarios;
	private int terrenoActual;
	private int filaDeTerrenoActual;
	private int efectoVida;
	

	public Terrenos (ArrayList<String> nombreTerreno, ArrayList<Integer> buffTerreno,
	                ArrayList<String> descripcionBuffTerreno, ArrayList<Integer> penalizacionTerreno,
	                ArrayList<String> descripcionPenalizacionTerreno, ArrayList<Integer> idTerrenosEnEscenarios,
	                int numeroTerrenos, int numeroEscenarios, int terrenoActual, int filaDeTerrenoActual,
	                int efectoVida) {
	
	    this.nombreTerreno = nombreTerreno;
	    this.buffTerreno = buffTerreno;
	    this.descripcionBuffTerreno = descripcionBuffTerreno;
	    this.penalizacionTerreno = penalizacionTerreno;
	    this.descripcionPenalizacionTerreno = descripcionPenalizacionTerreno;
	    this.idTerrenosEnEscenarios = idTerrenosEnEscenarios;
	    this.numeroTerrenos = numeroTerrenos;
	    this.numeroEscenarios = numeroEscenarios;
	    this.terrenoActual = terrenoActual;
	    this.filaDeTerrenoActual = filaDeTerrenoActual;
	    this.efectoVida = efectoVida;
	}
	
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
	
	public int getFilaDeTerrenoActual() {
		return filaDeTerrenoActual;
	}

	public void setFilaDeTerrenoActual(int filaDeTerrenoActual) {
		this.filaDeTerrenoActual = filaDeTerrenoActual;
	}
	
	public int getTerrenoActual() {
		return terrenoActual;
	}

	public void setTerrenoActual(int terrenoActual) {
		this.terrenoActual = terrenoActual;
	}

	public void  creacionTerrenos() {
		filaDeTerrenoActual = 0;
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
			System.out.println("--El |" + nombreTerreno.get(terrenoActual) + "| te cura |" + buffTerreno.get(terrenoActual) + "| puntos de vida.--");
		} else if (penalizacionTerreno.get(terrenoActual) != 0 && buffTerreno.get(terrenoActual) == 0) {
			System.out.println("--El |" + nombreTerreno.get(terrenoActual) + "| te quita |" + penalizacionTerreno.get(terrenoActual) + "| puntos de vida.--");
		} else if (buffTerreno.get(terrenoActual) == 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			System.out.println("System error Class_Terreno not found");
		} else {
			System.out.println("Error al cargar el terreno.");
		}
	}
	
	public int efectoTerreno() {
		efectoVida = 0;
		if (buffTerreno.get(terrenoActual) != 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			efectoVida = buffTerreno.get(terrenoActual);
		} else if (penalizacionTerreno.get(terrenoActual) != 0 && buffTerreno.get(terrenoActual) == 0) {
			efectoVida = -penalizacionTerreno.get(terrenoActual);
		} else if (buffTerreno.get(terrenoActual) == 0 && penalizacionTerreno.get(terrenoActual) == 0) {
			efectoVida = 0;
		} else {
			System.out.println("Error al cargar el terreno.");
		}
		return efectoVida;
	}
	public void cambioTerreno() {
		terrenoActual = random.nextInt(numeroTerrenos);
	}
}
