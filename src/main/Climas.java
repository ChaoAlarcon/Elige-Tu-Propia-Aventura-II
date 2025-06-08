package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
import java.util.Random;
public class Climas{
	ConectarBDD conectarBDD = new ConectarBDD();
	Random random = new Random();
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
	private int efectoPrecision;
	
	public Climas(ArrayList<String> nombreClima, ArrayList<Integer> buffClima, ArrayList<String> descripcionBuffClima,
            ArrayList<Integer> penalizacionClima, ArrayList<String> descripcionPenalizacionClima,
            ArrayList<Integer> idClimasEnEscenarios, int numeroClimas, int numeroEscenarios, 
            int climaActual, int filaDeClimaActual, int efectoPrecision) {

	  this.nombreClima = nombreClima;
	  this.buffClima = buffClima;
	  this.descripcionBuffClima = descripcionBuffClima;
	  this.penalizacionClima = penalizacionClima;
	  this.descripcionPenalizacionClima = descripcionPenalizacionClima;
	  this.idClimasEnEscenarios = idClimasEnEscenarios;
	  this.numeroClimas = numeroClimas;
	  this.numeroEscenarios = numeroEscenarios;
	  this.climaActual = climaActual;
	  this.filaDeClimaActual = filaDeClimaActual;
	  this.efectoPrecision = efectoPrecision;
	}
	
	public Climas () {
		
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

	public int getClimaActual() {
		return climaActual;
	}

	public void setClimaActual(int climaActual) {
		this.climaActual = climaActual;
	}
	
	

	public int getFilaDeClimaActual() {
		return filaDeClimaActual;
	}

	public void setFilaDeClimaActual(int filaDeClimaActual) {
		this.filaDeClimaActual = filaDeClimaActual;
	}

	public void creacionClimas() {
		numeroClimas = conectarBDD.obtenerNumeroDeFilas("climas");
		numeroEscenarios = conectarBDD.obtenerNumeroDeFilas("escenarios");
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
	}
	
	public void efectoClimaDescrip() {
		climaActual = idClimasEnEscenarios.get(filaDeClimaActual) - 1;
		if (buffClima.get(climaActual) != 0 && penalizacionClima.get(climaActual) == 0) {
			System.out.println("--El clima es |" + nombreClima.get(climaActual) + "| y te sube la precision |" + buffClima.get(climaActual) + "| puntos.--");
		} else if (penalizacionClima.get(climaActual) != 0 && buffClima.get(climaActual) == 0) {
			System.out.println("--El clima es |" + nombreClima.get(climaActual) + "| y te baja la precision |" + penalizacionClima.get(climaActual) + "| puntos.--");
		} else if (buffClima.get(climaActual) == 0 && penalizacionClima.get(climaActual) == 0) {
			System.out.println("System error Class_Clima not found");
		} else {
			System.out.println("Error al cargar el clima.");
		}
	}
	public int efectoClima() {
		efectoPrecision = 0;
		if (buffClima.get(climaActual) != 0 && penalizacionClima.get(climaActual) == 0) {
			efectoPrecision = buffClima.get(climaActual);
		} else if (penalizacionClima.get(climaActual) != 0 && buffClima.get(climaActual) == 0) {
			efectoPrecision = -penalizacionClima.get(climaActual);
		} else if (buffClima.get(climaActual) == 0 && penalizacionClima.get(climaActual) == 0) {
			efectoPrecision = 0;
		} else {
			System.out.println("Error al cargar el clima.");
		}
		return efectoPrecision;
	}
	public void cambioClima() {
		climaActual = random.nextInt(numeroClimas);
	}
}

