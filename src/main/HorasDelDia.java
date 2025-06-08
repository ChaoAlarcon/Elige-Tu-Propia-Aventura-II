package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
import java.util.Random;
public class HorasDelDia {
	ConectarBDD conectarBDD = new ConectarBDD();
	Random random = new Random();
	private ArrayList<String> nombreHora = new ArrayList<>();
	private ArrayList<Integer> buffHora = new ArrayList<>();
	private ArrayList<String> descripcionBuffHora = new ArrayList<>();
	private ArrayList<Integer> penalizacionHora = new ArrayList<>();
	private ArrayList<String> descripcionPenalizacionHora = new ArrayList<>();
	private ArrayList<Integer> idHorasEnEscenarios = new ArrayList<>();
	private int numeroHoras;
	private int numeroEscenarios;
	private int horaActual;
	private int efectoAtaque;
	private int filaDeHoraActual = 0;
	
	public HorasDelDia(ArrayList<String> nombreHora, ArrayList<Integer> buffHora, ArrayList<String> descripcionBuffHora,
	        ArrayList<Integer> penalizacionHora, ArrayList<String> descripcionPenalizacionHora,
	        ArrayList<Integer> idHorasEnEscenarios, int numeroHoras, int numeroEscenarios, int horaActual,
	        int efectoAtaque, int filaDeHoraActual) {

	    this.nombreHora = nombreHora;
	    this.buffHora = buffHora;
	    this.descripcionBuffHora = descripcionBuffHora;
	    this.penalizacionHora = penalizacionHora;
	    this.descripcionPenalizacionHora = descripcionPenalizacionHora;
	    this.idHorasEnEscenarios = idHorasEnEscenarios;
	    this.numeroHoras = numeroHoras;
	    this.numeroEscenarios = numeroEscenarios;
	    this.horaActual = horaActual;
	    this.efectoAtaque = efectoAtaque;
	    this.filaDeHoraActual = filaDeHoraActual;
	}
	
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
	
	public int getHoraActual() {
		return horaActual;
	}

	public void setHoraActual(int horaActual) {
		this.horaActual = horaActual;
	}
	

	public int getFilaDeHoraActual() {
		return filaDeHoraActual;
	}

	public void setFilaDeHoraActual(int filaDeHoraActual) {
		this.filaDeHoraActual = filaDeHoraActual;
	}

	public void creacionHorasDelDia() {
		numeroHoras = conectarBDD.obtenerNumeroDeFilas("horas_del_dia");
		numeroEscenarios = conectarBDD.obtenerNumeroDeFilas("escenarios");
		nombreHora.clear();
	    buffHora.clear();
	    descripcionBuffHora.clear();
	    penalizacionHora.clear();
	    descripcionPenalizacionHora.clear();
	    idHorasEnEscenarios.clear();
		for (int i = 1; i <= numeroHoras; i++) {
			nombreHora.add(conectarBDD.consultarDatosString("nombreHora", "horas_del_dia", "id_horas_del_dia = " + i));
			buffHora.add(conectarBDD.consultarDatosint("buff", "horas_del_dia", "id_horas_del_dia = " + i));
			descripcionBuffHora.add(conectarBDD.consultarDatosString("descripcionBuff", "horas_del_dia", "id_horas_del_dia = " + i));
			penalizacionHora.add(conectarBDD.consultarDatosint("penalizacion", "horas_del_dia", "id_horas_del_dia = " + i));
			descripcionPenalizacionHora.add(conectarBDD.consultarDatosString("descripcionPenalizacion", "horas_del_dia", "id_horas_del_dia = " + i));
		}
		for (int j = 1; j <= numeroEscenarios; j++) {
			idHorasEnEscenarios.add(conectarBDD.consultarDatosint("id_horas_del_dia", "escenarios", "id_escenarios = " + j));
		}
	}
	
	public void efectoHoraDelDiaDescrip() {
		horaActual = idHorasEnEscenarios.get(filaDeHoraActual) - 1;
		if (buffHora.get(horaActual) != 0 && penalizacionHora.get(horaActual) == 0) {
			System.out.println("--Es por la |" + nombreHora.get(horaActual) + "| y te sube el ataque |" + buffHora.get(horaActual) + "| puntos de daño.--");
		} else if (penalizacionHora.get(horaActual) != 0 && buffHora.get(horaActual) == 0) {
			System.out.println("--Es por la |" + nombreHora.get(horaActual) + "| y te baja el ataque |" + penalizacionHora.get(horaActual) + "| puntos de daño.--");
		} else if (buffHora.get(horaActual) == 0 && penalizacionHora.get(horaActual) == 0) {
			System.out.println("System error Class_Hora not found");
		} else {
			System.out.println("Error al cargar la hora.");
		}
	}
	
	public int efectoHoraDelDia() {
		efectoAtaque = 0;
		if (buffHora.get(horaActual) != 0 && penalizacionHora.get(horaActual) == 0) {
			efectoAtaque = buffHora.get(horaActual);
		} else if (penalizacionHora.get(horaActual) != 0 && buffHora.get(horaActual) == 0) {
			efectoAtaque = -penalizacionHora.get(horaActual);
		} else if (buffHora.get(horaActual) == 0 && penalizacionHora.get(horaActual) == 0) {
			efectoAtaque = 0;
		} else {
			System.out.println("Error al cargar la hora.");
		}
		return efectoAtaque;
	}
	public void cambioHora() {
		horaActual = random.nextInt(numeroHoras);
	}
}
