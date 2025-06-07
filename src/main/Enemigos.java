package main;
import java.sql.*;
import java.util.ArrayList;
import main.ConectarBDD;
public class Enemigos {
	ConectarBDD ConectarBDD = new ConectarBDD();
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
    private int vidaEnemigoActual = 0;
    
    public Enemigos(ArrayList<String> enemigos, ArrayList<String> especie,
            ArrayList<Integer> vida, ArrayList<String> nombreBasico, ArrayList<Integer> danoBasico,
            ArrayList<String> descripcionBasico, ArrayList<String> nombreFuerte, ArrayList<Integer> danoFuerte,
            ArrayList<String> descripcionFuerte, ArrayList<String> nombreHabilidad,
            ArrayList<Integer> datosHabilidad, ArrayList<String> descripcionHabilidad,
            int numeroEnemigos, int vidaEnemigoActual) {

		this.enemigos = enemigos;
		this.especie = especie;
		this.vida = vida;
		this.nombreBasico = nombreBasico;
		this.danoBasico = danoBasico;
		this.descripcionBasico = descripcionBasico;
		this.nombreFuerte = nombreFuerte;
		this.danoFuerte = danoFuerte;
		this.descripcionFuerte = descripcionFuerte;
		this.nombreHabilidad = nombreHabilidad;
		this.datosHabilidad = datosHabilidad;
		this.descripcionHabilidad = descripcionHabilidad;
		this.numeroEnemigos = numeroEnemigos;
		this.vidaEnemigoActual = vidaEnemigoActual;
	}
    
    public Enemigos() {
    	
    }
    
    

	public ArrayList<String> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(ArrayList<String> enemigos) {
		this.enemigos = enemigos;
	}

	public ArrayList<String> getEspecie() {
		return especie;
	}

	public void setEspecie(ArrayList<String> especie) {
		this.especie = especie;
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

	public void setDanoBasico(ArrayList<Integer> danoBasico) {
		this.danoBasico = danoBasico;
	}

	public ArrayList<String> getDescripcionBasico() {
		return descripcionBasico;
	}

	public void setDescripcionBasico(ArrayList<String> descripcionBasico) {
		this.descripcionBasico = descripcionBasico;
	}

	public ArrayList<String> getNombreFuerte() {
		return nombreFuerte;
	}

	public void setNombreFuerte(ArrayList<String> nombreFuerte) {
		this.nombreFuerte = nombreFuerte;
	}

	public ArrayList<Integer> getDanoFuerte() {
		return danoFuerte;
	}

	public void setDanoFuerte(ArrayList<Integer> danoFuerte) {
		this.danoFuerte = danoFuerte;
	}

	public ArrayList<String> getDescripcionFuerte() {
		return descripcionFuerte;
	}

	public void setDescripcionFuerte(ArrayList<String> descripcionFuerte) {
		this.descripcionFuerte = descripcionFuerte;
	}

	public ArrayList<String> getNombreHabilidad() {
		return nombreHabilidad;
	}

	public void setNombreHabilidad(ArrayList<String> nombreHabilidad) {
		this.nombreHabilidad = nombreHabilidad;
	}

	public ArrayList<Integer> getDatosHabilidad() {
		return datosHabilidad;
	}

	public void setDatosHabilidad(ArrayList<Integer> datosHabilidad) {
		this.datosHabilidad = datosHabilidad;
	}

	public ArrayList<String> getDescripcionHabilidad() {
		return descripcionHabilidad;
	}

	public void setDescripcionHabilidad(ArrayList<String> descripcionHabilidad) {
		this.descripcionHabilidad = descripcionHabilidad;
	}

	public int getNumeroEnemigos() {
		return numeroEnemigos;
	}

	public void setNumeroEnemigos(int numeroEnemigos) {
		this.numeroEnemigos = numeroEnemigos;
	}

	public int getVidaEnemigoActual() {
		return vidaEnemigoActual;
	}

	public void setVidaEnemigoActual(int vidaEnemigoActual) {
		this.vidaEnemigoActual = vidaEnemigoActual;
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
    	for (int i = 1; i <= numeroEnemigos; i++) {
			enemigos.add(ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos =" + i));
			especie.add(ConectarBDD.consultarDatosString("especie","enemigos",  "id_enemigos =" + i));
			vida.add(ConectarBDD.consultarDatosint( "vida","enemigos", "id_enemigos =" + i));
			nombreBasico.add(ConectarBDD.consultarDatosString( "nombreBasico","ataques_enemigos", "id_ataques_enemigos =" + i));
			danoBasico.add(ConectarBDD.consultarDatosint( "danoBasico","ataques_enemigos", "id_ataques_enemigos =" + i));
			descripcionBasico.add(ConectarBDD.consultarDatosString( "descripcionBasico","ataques_enemigos", "id_ataques_enemigos =" + i));
			nombreFuerte.add(ConectarBDD.consultarDatosString( "nombreFuerte","ataques_enemigos", "id_ataques_enemigos =" + i));
			danoFuerte.add(ConectarBDD.consultarDatosint( "danoFuerte","ataques_enemigos", "id_ataques_enemigos =" + i));
			descripcionFuerte.add(ConectarBDD.consultarDatosString( "descripcionFuerte","ataques_enemigos", "id_ataques_enemigos =" + i));
			nombreHabilidad.add(ConectarBDD.consultarDatosString( "nombreHabilidad","ataques_enemigos", "id_ataques_enemigos =" + i));
			datosHabilidad.add(ConectarBDD.consultarDatosint( "datosHabilidad","ataques_enemigos", "id_ataques_enemigos =" + i));
			descripcionHabilidad.add(ConectarBDD.consultarDatosString( "descripcionHabilidad","ataques_enemigos", "id_ataques_enemigos =" + i));
		}
    }
    
}
