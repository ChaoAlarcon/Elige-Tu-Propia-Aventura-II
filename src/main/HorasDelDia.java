package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class HorasDelDia {
	ConectarBDD conectarBDD = new ConectarBDD();
	Enemigos enemigo = new Enemigos();
	private ArrayList<String> nombreHora = new ArrayList<>();
	private ArrayList<Integer> buffHora = new ArrayList<>();
	private ArrayList<String> descripcionBuffHora = new ArrayList<>();
	private ArrayList<Integer> penalizacionHora = new ArrayList<>();
	private ArrayList<String> descripcionPenalizacionHora = new ArrayList<>();
	private ArrayList<Integer> idHorasEnEscenarios = new ArrayList<>();
	private int numeroHoras;
	private int numeroEscenarios;
	private int horaActual;
	private int filaDeHoraActual = 0;
	
	public HorasDelDia() {

	}

	public ArrayList<String> getNombreHora() {
		return nombreHora;
	}

	public ArrayList<Integer> getBuffHora() {
		return buffHora;
	}
	
	public ArrayList<String> getDescripcionBuffHora() {
		return descripcionBuffHora;
	}

	public ArrayList<Integer> getPenalizacionHora() {
		return penalizacionHora;
	}

	public ArrayList<String> getDescripcionPenalizacionHora() {
		return descripcionPenalizacionHora;
	}
	
	public void creacionHoras() {
		numeroHoras = conectarBDD.obtenerNumeroDeFilas("horas_del_dia");
		numeroEscenarios = conectarBDD.obtenerNumeroDeFilas("horas_del_dia");
		nombreHora.clear();
	    buffHora.clear();
	    descripcionBuffHora.clear();
	    penalizacionHora.clear();
	    descripcionPenalizacionHora.clear();
	    idHorasEnEscenarios.clear();
		for (int i = 1; i <= numeroHoras; i++) {
			nombreHora.add(conectarBDD.consultarDatosString("nombreHora", "horas_del_dia", "id_horas_del_dia = " + i));
			System.out.println("Hora");
			buffHora.add(conectarBDD.consultarDatosint("buff", "horas_del_dia", "id_horas_del_dia = " + i));
			descripcionBuffHora.add(conectarBDD.consultarDatosString("descripcionBuff", "horas_del_dia", "id_horas_del_dia = " + i));
			penalizacionHora.add(conectarBDD.consultarDatosint("penalizacion", "horas_del_dia", "id_horas_del_dia = " + i));
			descripcionPenalizacionHora.add(conectarBDD.consultarDatosString("descripcionPenalizacion", "horas_del_dia", "id_horas_del_dia = " + i));
		}
		for (int j = 1; j <= numeroEscenarios; j++) {
			idHorasEnEscenarios.add(conectarBDD.consultarDatosint("id_horas_del_dia", "escenarios", "id_escenarios = " + j));
		}
		enemigo.creacionEnemigos();
	}
	
	public void efectoHoraDelDia() {
		horaActual = idHorasEnEscenarios.get(filaDeHoraActual) - 1;
		if (buffHora.get(horaActual) != 0 && penalizacionHora.get(horaActual) == 0) {
			System.out.println("Es por la " + nombreHora.get(horaActual) + ".");
			System.out.println("La hora te da un buff de " + buffHora.get(horaActual) + " " + descripcionBuffHora.get(horaActual));
		} else if (penalizacionHora.get(horaActual) != 0 && buffHora.get(horaActual) == 0) {
			System.out.println("Es por la " + nombreHora.get(horaActual) + ".");
			System.out.println("La hora te penaliza con " + penalizacionHora.get(horaActual) + " " + descripcionPenalizacionHora.get(horaActual));
		} else if (buffHora.get(horaActual) == 0 && penalizacionHora.get(horaActual) == 0) {
			System.out.println("Son las " + nombreHora.get(horaActual) + descripcionPenalizacionHora.get(horaActual));
		} else {
			System.out.println("Error al cargar la hora.");
		}
		filaDeHoraActual++;
	}
}
