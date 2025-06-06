package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Enemigos {
	ConectarBDD ConectarBDD = new ConectarBDD();
	Terrenos terreno = new Terrenos();
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
    	System.out.println(numeroEnemigos);
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
			enemigos.add(ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos =" + i));
			System.out.println(enemigos.get(i - 1));
			especie.add(ConectarBDD.consultarDatosString("especie","enemigos",  "id_enemigos =" + i));
			vida.add(ConectarBDD.consultarDatosint( "vida","enemigos", "id_enemigos =" + i));
			nombreBasico.add(ConectarBDD.consultarDatosString( "nombreBasico","ataques_enemigos", "id_ataques_enemigos =" + i));
			danoBasico.add(ConectarBDD.consultarDatosint( "danoBasico","ataques_enemigos", "id_ataques_enemigos =" + i));
			descripcionBasico.add(ConectarBDD.consultarDatosString( "descripcionBasico","ataques_enemigos", "id_ataques_enemigos =" + i));
			nombreFuerte.add(ConectarBDD.consultarDatosString( "nombreFuerte","ataques_enemigos", "id_ataques_enemigos =" + i));
			danoFuerte.add(ConectarBDD.consultarDatosint( "danoFuerte","ataques_enemigos", "id_ataques_enemigos =" + i));
			descripcionFuerte.add(ConectarBDD.consultarDatosString( "descripcionFuerte","ataques_enemigos", "id_ataques_enemigos =" + i));
			nombreHabilidad.add(ConectarBDD.consultarDatosString( "nombreHabilidad","ataques_enemigos", "id_habilidades_enemigos =" + i));
			datosHabilidad.add(ConectarBDD.consultarDatosint( "datosHabilidad","ataques_enemigos", "id_habilidades_enemigos =" + i));
			descripcionHabilidad.add(ConectarBDD.consultarDatosString( "descripcionHabilidad","ataques_enemigos", "id_habilidades_enemigos =" + i));
		}
    	terreno.creacionTerrenos();
    }
    
}
