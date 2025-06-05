package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Enemigos {
	ConectarBDD ConectarBDD = new ConectarBDD();
	Escenarios escenario = new Escenarios();
	private ArrayList<String> enemigos = new ArrayList<>();
    private ArrayList<String> especie = new ArrayList<>();
    private ArrayList<Integer> vida = new ArrayList<>();
    private ArrayList<String> nombreBasico = new ArrayList<>();
    private ArrayList<Integer> danoBasico = new ArrayList<>();
    private ArrayList<String> descripcionBasico = new ArrayList<>();
    private ArrayList<String> nombreFuerte = new ArrayList<>();
    private ArrayList<Integer> danoFuerte = new ArrayList<>();
    private ArrayList<String> descripcionFuerte = new ArrayList<>();
    private ArrayList<String> nombreHabilidad = new ArrayList<>();
    private ArrayList<Integer> datosHabilidad = new ArrayList<>();
    private ArrayList<String> descripcionHabilidad = new ArrayList<>();
    private int numeroEnemigos;
    
    public Enemigos() {
    	
    }
    
    public ArrayList<String> getEnemigos() {
		return enemigos;
	}

	public ArrayList<String> getEspecie() {
		return especie;
	}

	public ArrayList<Integer> getVida() {
		return vida;
	}

	public void setVida(ArrayList<Integer> vida) {
		this.vida = vida;
	}

	public ArrayList<String> getNombreBasico() {
		return nombreBasico;
	}

	public void setNombreBasico(ArrayList<String> nombreBasico) {
		this.nombreBasico = nombreBasico;
	}

	public ArrayList<Integer> getDanoBasico() {
		return danoBasico;
	}

	public ArrayList<String> getDescripcionBasico() {
		return descripcionBasico;
	}

	public ArrayList<String> getNombreFuerte() {
		return nombreFuerte;
	}

	public ArrayList<Integer> getDanoFuerte() {
		return danoFuerte;
	}

	public ArrayList<String> getDescripcionFuerte() {
		return descripcionFuerte;
	}

	public ArrayList<String> getNombreHabilidad() {
		return nombreHabilidad;
	}

	public ArrayList<Integer> getDatosHabilidad() {
		return datosHabilidad;
	}

	public ArrayList<String> getDescripcionHabilidad() {
		return descripcionHabilidad;
	}

	public void creacionEnemigos() {
    	numeroEnemigos = ConectarBDD.obtenerNumeroDeFilas("enemigos");
        enemigos.clear();
        especie.clear();
        vida.clear();
        nombreBasico.clear();
        danoBasico.clear();
        descripcionBasico.clear();
        nombreFuerte.clear();
        danoFuerte.clear();
        descripcionFuerte.clear();
        nombreHabilidad.clear();
        datosHabilidad.clear();
        descripcionHabilidad.clear();
    	for (int i = 1; i < numeroEnemigos; i++) {
			enemigos.add(ConectarBDD.consultarDatosString("enemigos", "nombreEnemigo", "id_enemigos =" + i));
			especie.add(ConectarBDD.consultarDatosString("enemigos", "especie", "id_enemigos =" + i));
			vida.add(ConectarBDD.consultarDatosint("enemigos", "vida", "id_enemigos =" + i));
			nombreBasico.add(ConectarBDD.consultarDatosString("ataques_enemigos", "nombreBasico", "id_ataques_enemigos =" + i));
			danoBasico.add(ConectarBDD.consultarDatosint("ataques_enemigos", "danoBasico", "id_ataques_enemigos =" + i));
			descripcionBasico.add(ConectarBDD.consultarDatosString("ataques_enemigos", "descripcionBasico", "id_ataques_enemigos =" + i));
			nombreFuerte.add(ConectarBDD.consultarDatosString("ataques_enemigos", "nombreFuerte", "id_ataques_enemigos =" + i));
			danoFuerte.add(ConectarBDD.consultarDatosint("ataques_enemigos", "danoFuerte", "id_ataques_enemigos =" + i));
			descripcionFuerte.add(ConectarBDD.consultarDatosString("ataques_enemigos", "descripcionFuerte", "id_ataques_enemigos =" + i));
			nombreHabilidad.add(ConectarBDD.consultarDatosString("habilidades_enemigos", "nombreHabilidad", "id_habilidades_enemigos =" + i));
			datosHabilidad.add(ConectarBDD.consultarDatosint("habilidades_enemigos", "datosHabilidad", "id_habilidades_enemigos =" + i));
			descripcionHabilidad.add(ConectarBDD.consultarDatosString("habilidades_enemigos", "descripcionHabilidad", "id_habilidades_enemigos =" + i));
		}
    	escenario.creacionEscenarios();
    }
    
}
