package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Climas {
	ConectarBDD conectarBDD = new ConectarBDD();
	HorasDelDia hora = new HorasDelDia();
	private ArrayList<String> nombreClima = new ArrayList<>();
	private ArrayList<Integer> buffClima = new ArrayList<>();
	private ArrayList<String> descripcionBuffClima = new ArrayList<>();
	private ArrayList<Integer> penalizacionClima = new ArrayList<>();
	private ArrayList<String> descripcionPenalizacionClima = new ArrayList<>();
	private ArrayList<Integer> idClimasEnEscenarios = new ArrayList<>();
	private int numeroClimas;
	private int numeroEscenarios;
	private int climaActual;
	private int filaDeClimaActual = 0;
	
	public Climas() {
		
	}

	public ArrayList<String> getNombreClima() {
		return nombreClima;
	}

	public ArrayList<Integer> getBuffClima() {
		return buffClima;
	}

	public ArrayList<String> getDescripcionBuffClima() {
		return descripcionBuffClima;
	}


	public ArrayList<Integer> getPenalizacionClima() {
		return penalizacionClima;
	}

	public ArrayList<String> getDescripcionPenalizacionClima() {
		return descripcionPenalizacionClima;
	}


	public void creacionClimas() {
		numeroClimas = conectarBDD.obtenerNumeroDeFilas("climas");
		numeroEscenarios = conectarBDD.obtenerNumeroDeFilas("climas");
		nombreClima.clear();
	    buffClima.clear();
	    descripcionBuffClima.clear();
	    penalizacionClima.clear();
	    descripcionPenalizacionClima.clear();
	    idClimasEnEscenarios.clear();
		for (int i = 1; i <= numeroClimas; i++) {
			nombreClima.add(conectarBDD.consultarDatosString("nombreClima", "climas", "id_climas = " + i));
			buffClima.add(conectarBDD.consultarDatosint("buff", "climas", "id_climas = " + i));
			descripcionBuffClima.add(conectarBDD.consultarDatosString("descripcionBuff", "climas", "id_climas = " + i));
			penalizacionClima.add(conectarBDD.consultarDatosint("penalizacion", "climas", "id_climas = " + i));
			descripcionPenalizacionClima.add(conectarBDD.consultarDatosString("descripcionPenalizacion", "climas", "id_climas = " + i));
		}
		for (int j = 1; j <= numeroEscenarios; j++) {
			idClimasEnEscenarios.add(conectarBDD.consultarDatosint("id_climas", "escenarios", "id_escenarios = " + j));
		}
		hora.creacionHoras();
	}
	
	public void efectoClimaDescrip() {
		climaActual = idClimasEnEscenarios.get(filaDeClimaActual);
		if (buffClima.get(climaActual) != 0 && penalizacionClima.get(climaActual) == 0) {
			System.out.println("Es por la " + nombreClima.get(climaActual) + ".");
			System.out.println("La hora te da un buff de " + buffClima.get(climaActual) + " " + descripcionBuffClima.get(climaActual));
		} else if (penalizacionClima.get(climaActual) != 0 && buffClima.get(climaActual) == 0) {
			System.out.println("Es por la " + nombreClima.get(climaActual) + ".");
			System.out.println("La hora te penaliza con " + penalizacionClima.get(climaActual) + " " + descripcionPenalizacionClima.get(climaActual));
		} else if (buffClima.get(climaActual) == 0 && penalizacionClima.get(climaActual) == 0) {
			System.out.println("Son las " + nombreClima.get(climaActual) + descripcionPenalizacionClima.get(climaActual));
		} else {
			System.out.println("Error al cargar el clima.");
		}
	}
}

