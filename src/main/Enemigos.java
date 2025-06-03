package main;
import java.sql.*;
import main.ConectarBDD;
public class Enemigos {
	ConectarBDD ConectarBDD = new ConectarBDD();
	private String enemigo1;
	private String enemigo2;
	private String enemigo3;
	private String enemigo4;
	private String enemigo5;
	private String enemigo6;
	private String enemigoFinal;
	private String especie_enemigo1;
	private String especie_enemigo2;
	private String especie_enemigo3;
	private String especie_enemigo4;
	private String especie_enemigo5;
	private String especie_enemigo6;
	private String especie_enemigoFinal;
	private int vida_enemigo1;
	private int vida_enemigo2;
	private int vida_enemigo3;
	private int vida_enemigo4;
	private int vida_enemigo5;
	private int vida_enemigo6;
	private int vida_enemigoFinal;
	private String nombreb_enemigo1;
	private String nombreb_enemigo2;
	private String nombreb_enemigo3;
	private String nombreb_enemigo4;
	private String nombreb_enemigo5;
	private String nombreb_enemigo6;
	private String nombreb_enemigoFinal;
	private int danob_enemigo1;
	private int danob_enemigo2;
	private int danob_enemigo3;
	private int danob_enemigo4;
	private int danob_enemigo5;
	private int danob_enemigo6;
	private int danob_enemigoFinal;
	private String descripcionb_enemigo1;
	private String descripcionb_enemigo2;
	private String descripcionb_enemigo3;
	private String descripcionb_enemigo4;
	private String descripcionb_enemigo5;
	private String descripcionb_enemigo6;
	private String descripcionb_enemigoFinal;
	private String nombref_enemigo1;
	private String nombref_enemigo2;
	private String nombref_enemigo3;
	private String nombref_enemigo4;
	private String nombref_enemigo5;
	private String nombref_enemigo6;
	private String nombref_enemigoFinal;
	private int danof_enemigo1;
	private int danof_enemigo2;
	private int danof_enemigo3;
	private int danof_enemigo4;
	private int danof_enemigo5;
	private int danof_enemigo6;
	private int danof_enemigoFinal;
	private String descripcionf_enemigo1;
	private String descripcionf_enemigo2;
	private String descripcionf_enemigo3;
	private String descripcionf_enemigo4;
	private String descripcionf_enemigo5;
	private String descripcionf_enemigo6;
	private String descripcionf_enemigoFinal;
	private String nombreh_enemigo1;
	private String nombreh_enemigo2;
	private String nombreh_enemigo3;
	private String nombreh_enemigo4;
	private String nombreh_enemigo5;
	private String nombreh_enemigo6;
	private String nombreh_enemigoFinal;
	private int datosh_enemigo1;
	private int datosh_enemigo2;
	private int datosh_enemigo3;
	private int datosh_enemigo4;
	private int datosh_enemigo5;
	private int datosh_enemigo6;
	private int datosh_enemigoFinal;
	private String descripcionh_enemigo1;
	private String descripcionh_enemigo2;
	private String descripcionh_enemigo3;
	private String descripcionh_enemigo4;
	private String descripcionh_enemigo5;
	private String descripcionh_enemigo6;
	private String descripcionh_enemigoFinal;

	public Enemigos(String enemigo1, String enemigo2, String enemigo3, String enemigo4, String enemigo5,
			String enemigo6, String enemigoFinal, String especie_enemigo1, String especie_enemigo2,
			String especie_enemigo3, String especie_enemigo4, String especie_enemigo5, String especie_enemigo6,
			String especie_enemigoFinal, int vida_enemigo1, int vida_enemigo2, int vida_enemigo3, int vida_enemigo4,
			int vida_enemigo5, int vida_enemigo6, int vida_enemigoFinal, String nombreb_enemigo1,
			String nombreb_enemigo2, String nombreb_enemigo3, String nombreb_enemigo4, String nombreb_enemigo5,
			String nombreb_enemigo6, String nombreb_enemigoFinal, int danob_enemigo1, int danob_enemigo2,
			int danob_enemigo3, int danob_enemigo4, int danob_enemigo5, int danob_enemigo6, int danob_enemigoFinal,
			String descripcionb_enemigo1, String descripcionb_enemigo2, String descripcionb_enemigo3,
			String descripcionb_enemigo4, String descripcionb_enemigo5, String descripcionb_enemigo6,
			String descripcionb_enemigoFinal, String nombref_enemigo1, String nombref_enemigo2, String nombref_enemigo3,
			String nombref_enemigo4, String nombref_enemigo5, String nombref_enemigo6, String nombref_enemigoFinal,
			int danof_enemigo1, int danof_enemigo2, int danof_enemigo3, int danof_enemigo4, int danof_enemigo5,
			int danof_enemigo6, int danof_enemigoFinal, String descripcionf_enemigo1, String descripcionf_enemigo2,
			String descripcionf_enemigo3, String descripcionf_enemigo4, String descripcionf_enemigo5,
			String descripcionf_enemigo6, String descripcionf_enemigoFinal, String nombreh_enemigo1,
			String nombreh_enemigo2, String nombreh_enemigo3, String nombreh_enemigo4, String nombreh_enemigo5,
			String nombreh_enemigo6, String nombreh_enemigoFinal, int datosh_enemigo1, int datosh_enemigo2,
			int datosh_enemigo3, int datosh_enemigo4, int datosh_enemigo5, int datosh_enemigo6, int datosh_enemigoFinal,
			String descripcionh_enemigo1, String descripcionh_enemigo2, String descripcionh_enemigo3,
			String descripcionh_enemigo4, String descripcionh_enemigo5, String descripcionh_enemigo6,
			String descripcionh_enemigoFinal) {
		this.enemigo1 = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 1");
		this.enemigo2 = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 2");
		this.enemigo3 = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 3");
		this.enemigo4 = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 4");
		this.enemigo5 = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 5");
		this.enemigo6 = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 6");
		this.enemigoFinal = ConectarBDD.consultarDatosString("nombreEnemigo", "enemigos", "id_enemigos = 7");

		this.especie_enemigo1 = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 1");
		this.especie_enemigo2 = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 2");
		this.especie_enemigo3 = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 3");
		this.especie_enemigo4 = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 4");
		this.especie_enemigo5 = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 5");
		this.especie_enemigo6 = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 6");
		this.especie_enemigoFinal = ConectarBDD.consultarDatosString("especie", "enemigos", "id_enemigos = 7");

		this.vida_enemigo1 = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 1");
		this.vida_enemigo2 = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 2");
		this.vida_enemigo3 = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 3");
		this.vida_enemigo4 = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 4");
		this.vida_enemigo5 = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 5");
		this.vida_enemigo6 = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 6");
		this.vida_enemigoFinal = ConectarBDD.consultarDatosint("vida", "enemigos", "id_enemigos = 7");

		this.nombreb_enemigo1 = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 1");
		this.nombreb_enemigo2 = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 2");
		this.nombreb_enemigo3 = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 3");
		this.nombreb_enemigo4 = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 4");
		this.nombreb_enemigo5 = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 5");
		this.nombreb_enemigo6 = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 6");
		this.nombreb_enemigoFinal = ConectarBDD.consultarDatosString("nombreBasico", "ataques_enemigos","id_ataques_enemigos = 7");

		this.danob_enemigo1 = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 1");
		this.danob_enemigo2 = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 2");
		this.danob_enemigo3 = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 3");
		this.danob_enemigo4 = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 4");
		this.danob_enemigo5 = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 5");
		this.danob_enemigo6 = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 6");
		this.danob_enemigoFinal = ConectarBDD.consultarDatosint("danoBasico", "ataques_enemigos","id_ataques_enemigos = 7");

		this.descripcionb_enemigo1 = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 1");
		this.descripcionb_enemigo2 = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 2");
		this.descripcionb_enemigo3 = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 3");
		this.descripcionb_enemigo4 = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 4");
		this.descripcionb_enemigo5 = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 5");
		this.descripcionb_enemigo6 = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 6");
		this.descripcionb_enemigoFinal = ConectarBDD.consultarDatosString("descripcionBasico", "ataques_enemigos","id_ataques_enemigos = 7");

		this.nombref_enemigo1 = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 1");
		this.nombref_enemigo2 = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 2");
		this.nombref_enemigo3 = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 3");
		this.nombref_enemigo4 = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 4");
		this.nombref_enemigo5 = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 5");
		this.nombref_enemigo6 = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 6");
		this.nombref_enemigoFinal = ConectarBDD.consultarDatosString("nombreFuerte", "ataques_enemigos","id_ataques_enemigos = 7");

		this.danof_enemigo1 = ConectarBDD.consultarDatosint("danoFuerte", "ataques_enemigos","id_ataques_enemigos = 1");
		this.danof_enemigo2 = ConectarBDD.consultarDatosint("danoFuerte", "ataques_enemigos","id_ataques_enemigos = 2");
		this.danof_enemigo3 = ConectarBDD.consultarDatosint("danof", "ataques_enemigos", "id_ataques_enemigos = 3");
		this.danof_enemigo4 = ConectarBDD.consultarDatosint("danoFuerte", "ataques_enemigos","id_ataques_enemigos = 4");
		this.danof_enemigo5 = ConectarBDD.consultarDatosint("danoFuerte", "ataques_enemigos","id_ataques_enemigos = 5");
		this.danof_enemigo6 = ConectarBDD.consultarDatosint("danoFuerte", "ataques_enemigos","id_ataques_enemigos = 6");
		this.danof_enemigoFinal = ConectarBDD.consultarDatosint("danoFuerte", "ataques_enemigos","id_ataques_enemigos = 7");

		this.descripcionf_enemigo1 = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 1");
		this.descripcionf_enemigo2 = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 2");
		this.descripcionf_enemigo3 = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 3");
		this.descripcionf_enemigo4 = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 4");
		this.descripcionf_enemigo5 = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 5");
		this.descripcionf_enemigo6 = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 6");
		this.descripcionf_enemigoFinal = ConectarBDD.consultarDatosString("descripcionFuerte", "ataques_enemigos","id_ataques_enemigos = 7");

		this.nombreh_enemigo1 = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 1");
		this.nombreh_enemigo2 = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 2");
		this.nombreh_enemigo3 = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 3");
		this.nombreh_enemigo4 = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 4");
		this.nombreh_enemigo5 = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 5");
		this.nombreh_enemigo6 = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 6");
		this.nombreh_enemigoFinal = ConectarBDD.consultarDatosString("nombreHabilidad", "ataques_enemigos","id_ataques_enemigos = 7");

		this.datosh_enemigo1 = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 1");
		this.datosh_enemigo2 = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 2");
		this.datosh_enemigo3 = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 3");
		this.datosh_enemigo4 = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 4");
		this.datosh_enemigo5 = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 5");
		this.datosh_enemigo6 = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 6");
		this.datosh_enemigoFinal = ConectarBDD.consultarDatosint("datosHabilidad", "ataques_enemigos","id_ataques_enemigos = 7");

		this.descripcionh_enemigo1 = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos","id_ataques_enemigos = 1");
		this.descripcionh_enemigo2 = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos","id_ataques_enemigos = 2");
		this.descripcionh_enemigo3 = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos","id_ataques_enemigos = 3");
		this.descripcionh_enemigo4 = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos","id_ataques_enemigos = 4");
		this.descripcionh_enemigo5 = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos","id_ataques_enemigos = 5");
		this.descripcionh_enemigo6 = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos","id_ataques_enemigos = 6");
		this.descripcionh_enemigoFinal = ConectarBDD.consultarDatosString("descripcionHabilidad", "ataques_enemigos", "id_ataques_enemigos = 7");
	}
	
	public Enemigos () {
		
	}

	public String getEnemigo1() {
		return enemigo1;
	}

	public void setEnemigo1(String enemigo1) {
		this.enemigo1 = enemigo1;
	}

	public String getEnemigo2() {
		return enemigo2;
	}

	public void setEnemigo2(String enemigo2) {
		this.enemigo2 = enemigo2;
	}

	public String getEnemigo3() {
		return enemigo3;
	}

	public void setEnemigo3(String enemigo3) {
		this.enemigo3 = enemigo3;
	}

	public String getEnemigo4() {
		return enemigo4;
	}

	public void setEnemigo4(String enemigo4) {
		this.enemigo4 = enemigo4;
	}

	public String getEnemigo5() {
		return enemigo5;
	}

	public void setEnemigo5(String enemigo5) {
		this.enemigo5 = enemigo5;
	}

	public String getEnemigo6() {
		return enemigo6;
	}

	public void setEnemigo6(String enemigo6) {
		this.enemigo6 = enemigo6;
	}

	public String getEnemigoFinal() {
		return enemigoFinal;
	}

	public void setEnemigoFinal(String enemigoFinal) {
		this.enemigoFinal = enemigoFinal;
	}

	public String getEspecie_enemigo1() {
		return especie_enemigo1;
	}

	public void setEspecie_enemigo1(String especie_enemigo1) {
		this.especie_enemigo1 = especie_enemigo1;
	}

	public String getEspecie_enemigo2() {
		return especie_enemigo2;
	}

	public void setEspecie_enemigo2(String especie_enemigo2) {
		this.especie_enemigo2 = especie_enemigo2;
	}

	public String getEspecie_enemigo3() {
		return especie_enemigo3;
	}

	public void setEspecie_enemigo3(String especie_enemigo3) {
		this.especie_enemigo3 = especie_enemigo3;
	}

	public String getEspecie_enemigo4() {
		return especie_enemigo4;
	}

	public void setEspecie_enemigo4(String especie_enemigo4) {
		this.especie_enemigo4 = especie_enemigo4;
	}

	public String getEspecie_enemigo5() {
		return especie_enemigo5;
	}

	public void setEspecie_enemigo5(String especie_enemigo5) {
		this.especie_enemigo5 = especie_enemigo5;
	}

	public String getEspecie_enemigo6() {
		return especie_enemigo6;
	}

	public void setEspecie_enemigo6(String especie_enemigo6) {
		this.especie_enemigo6 = especie_enemigo6;
	}

	public String getEspecie_enemigoFinal() {
		return especie_enemigoFinal;
	}

	public void setEspecie_enemigoFinal(String especie_enemigoFinal) {
		this.especie_enemigoFinal = especie_enemigoFinal;
	}

	public int getVida_enemigo1() {
		return vida_enemigo1;
	}

	public void setVida_enemigo1(int vida_enemigo1) {
		this.vida_enemigo1 = vida_enemigo1;
	}

	public int getVida_enemigo2() {
		return vida_enemigo2;
	}

	public void setVida_enemigo2(int vida_enemigo2) {
		this.vida_enemigo2 = vida_enemigo2;
	}

	public int getVida_enemigo3() {
		return vida_enemigo3;
	}

	public void setVida_enemigo3(int vida_enemigo3) {
		this.vida_enemigo3 = vida_enemigo3;
	}

	public int getVida_enemigo4() {
		return vida_enemigo4;
	}

	public void setVida_enemigo4(int vida_enemigo4) {
		this.vida_enemigo4 = vida_enemigo4;
	}

	public int getVida_enemigo5() {
		return vida_enemigo5;
	}

	public void setVida_enemigo5(int vida_enemigo5) {
		this.vida_enemigo5 = vida_enemigo5;
	}

	public int getVida_enemigo6() {
		return vida_enemigo6;
	}

	public void setVida_enemigo6(int vida_enemigo6) {
		this.vida_enemigo6 = vida_enemigo6;
	}

	public int getVida_enemigoFinal() {
		return vida_enemigoFinal;
	}

	public void setVida_enemigoFinal(int vida_enemigoFinal) {
		this.vida_enemigoFinal = vida_enemigoFinal;
	}

	public String getNombreb_enemigo1() {
		return nombreb_enemigo1;
	}

	public void setNombreb_enemigo1(String nombreb_enemigo1) {
		this.nombreb_enemigo1 = nombreb_enemigo1;
	}

	public String getNombreb_enemigo2() {
		return nombreb_enemigo2;
	}

	public void setNombreb_enemigo2(String nombreb_enemigo2) {
		this.nombreb_enemigo2 = nombreb_enemigo2;
	}

	public String getNombreb_enemigo3() {
		return nombreb_enemigo3;
	}

	public void setNombreb_enemigo3(String nombreb_enemigo3) {
		this.nombreb_enemigo3 = nombreb_enemigo3;
	}

	public String getNombreb_enemigo4() {
		return nombreb_enemigo4;
	}

	public void setNombreb_enemigo4(String nombreb_enemigo4) {
		this.nombreb_enemigo4 = nombreb_enemigo4;
	}

	public String getNombreb_enemigo5() {
		return nombreb_enemigo5;
	}

	public void setNombreb_enemigo5(String nombreb_enemigo5) {
		this.nombreb_enemigo5 = nombreb_enemigo5;
	}

	public String getNombreb_enemigo6() {
		return nombreb_enemigo6;
	}

	public void setNombreb_enemigo6(String nombreb_enemigo6) {
		this.nombreb_enemigo6 = nombreb_enemigo6;
	}

	public String getNombreb_enemigoFinal() {
		return nombreb_enemigoFinal;
	}

	public void setNombreb_enemigoFinal(String nombreb_enemigoFinal) {
		this.nombreb_enemigoFinal = nombreb_enemigoFinal;
	}

	public int getDanob_enemigo1() {
		return danob_enemigo1;
	}

	public void setDanob_enemigo1(int danob_enemigo1) {
		this.danob_enemigo1 = danob_enemigo1;
	}

	public int getDanob_enemigo2() {
		return danob_enemigo2;
	}

	public void setDanob_enemigo2(int danob_enemigo2) {
		this.danob_enemigo2 = danob_enemigo2;
	}

	public int getDanob_enemigo3() {
		return danob_enemigo3;
	}

	public void setDanob_enemigo3(int danob_enemigo3) {
		this.danob_enemigo3 = danob_enemigo3;
	}

	public int getDanob_enemigo4() {
		return danob_enemigo4;
	}

	public void setDanob_enemigo4(int danob_enemigo4) {
		this.danob_enemigo4 = danob_enemigo4;
	}

	public int getDanob_enemigo5() {
		return danob_enemigo5;
	}

	public void setDanob_enemigo5(int danob_enemigo5) {
		this.danob_enemigo5 = danob_enemigo5;
	}

	public int getDanob_enemigo6() {
		return danob_enemigo6;
	}

	public void setDanob_enemigo6(int danob_enemigo6) {
		this.danob_enemigo6 = danob_enemigo6;
	}

	public int getDanob_enemigoFinal() {
		return danob_enemigoFinal;
	}

	public void setDanob_enemigoFinal(int danob_enemigoFinal) {
		this.danob_enemigoFinal = danob_enemigoFinal;
	}

	public String getDescripcionb_enemigo1() {
		return descripcionb_enemigo1;
	}

	public void setDescripcionb_enemigo1(String descripcionb_enemigo1) {
		this.descripcionb_enemigo1 = descripcionb_enemigo1;
	}

	public String getDescripcionb_enemigo2() {
		return descripcionb_enemigo2;
	}

	public void setDescripcionb_enemigo2(String descripcionb_enemigo2) {
		this.descripcionb_enemigo2 = descripcionb_enemigo2;
	}

	public String getDescripcionb_enemigo3() {
		return descripcionb_enemigo3;
	}

	public void setDescripcionb_enemigo3(String descripcionb_enemigo3) {
		this.descripcionb_enemigo3 = descripcionb_enemigo3;
	}

	public String getDescripcionb_enemigo4() {
		return descripcionb_enemigo4;
	}

	public void setDescripcionb_enemigo4(String descripcionb_enemigo4) {
		this.descripcionb_enemigo4 = descripcionb_enemigo4;
	}

	public String getDescripcionb_enemigo5() {
		return descripcionb_enemigo5;
	}

	public void setDescripcionb_enemigo5(String descripcionb_enemigo5) {
		this.descripcionb_enemigo5 = descripcionb_enemigo5;
	}

	public String getDescripcionb_enemigo6() {
		return descripcionb_enemigo6;
	}

	public void setDescripcionb_enemigo6(String descripcionb_enemigo6) {
		this.descripcionb_enemigo6 = descripcionb_enemigo6;
	}

	public String getDescripcionb_enemigoFinal() {
		return descripcionb_enemigoFinal;
	}

	public void setDescripcionb_enemigoFinal(String descripcionb_enemigoFinal) {
		this.descripcionb_enemigoFinal = descripcionb_enemigoFinal;
	}

	public String getNombref_enemigo1() {
		return nombref_enemigo1;
	}

	public void setNombref_enemigo1(String nombref_enemigo1) {
		this.nombref_enemigo1 = nombref_enemigo1;
	}

	public String getNombref_enemigo2() {
		return nombref_enemigo2;
	}

	public void setNombref_enemigo2(String nombref_enemigo2) {
		this.nombref_enemigo2 = nombref_enemigo2;
	}

	public String getNombref_enemigo3() {
		return nombref_enemigo3;
	}

	public void setNombref_enemigo3(String nombref_enemigo3) {
		this.nombref_enemigo3 = nombref_enemigo3;
	}

	public String getNombref_enemigo4() {
		return nombref_enemigo4;
	}

	public void setNombref_enemigo4(String nombref_enemigo4) {
		this.nombref_enemigo4 = nombref_enemigo4;
	}

	public String getNombref_enemigo5() {
		return nombref_enemigo5;
	}

	public void setNombref_enemigo5(String nombref_enemigo5) {
		this.nombref_enemigo5 = nombref_enemigo5;
	}

	public String getNombref_enemigo6() {
		return nombref_enemigo6;
	}

	public void setNombref_enemigo6(String nombref_enemigo6) {
		this.nombref_enemigo6 = nombref_enemigo6;
	}

	public String getNombref_enemigoFinal() {
		return nombref_enemigoFinal;
	}

	public void setNombref_enemigoFinal(String nombref_enemigoFinal) {
		this.nombref_enemigoFinal = nombref_enemigoFinal;
	}

	public int getDanof_enemigo1() {
		return danof_enemigo1;
	}

	public void setDanof_enemigo1(int danof_enemigo1) {
		this.danof_enemigo1 = danof_enemigo1;
	}

	public int getDanof_enemigo2() {
		return danof_enemigo2;
	}

	public void setDanof_enemigo2(int danof_enemigo2) {
		this.danof_enemigo2 = danof_enemigo2;
	}

	public int getDanof_enemigo3() {
		return danof_enemigo3;
	}

	public void setDanof_enemigo3(int danof_enemigo3) {
		this.danof_enemigo3 = danof_enemigo3;
	}

	public int getDanof_enemigo4() {
		return danof_enemigo4;
	}

	public void setDanof_enemigo4(int danof_enemigo4) {
		this.danof_enemigo4 = danof_enemigo4;
	}

	public int getDanof_enemigo5() {
		return danof_enemigo5;
	}

	public void setDanof_enemigo5(int danof_enemigo5) {
		this.danof_enemigo5 = danof_enemigo5;
	}

	public int getDanof_enemigo6() {
		return danof_enemigo6;
	}

	public void setDanof_enemigo6(int danof_enemigo6) {
		this.danof_enemigo6 = danof_enemigo6;
	}

	public int getDanof_enemigoFinal() {
		return danof_enemigoFinal;
	}

	public void setDanof_enemigoFinal(int danof_enemigoFinal) {
		this.danof_enemigoFinal = danof_enemigoFinal;
	}

	public String getDescripcionf_enemigo1() {
		return descripcionf_enemigo1;
	}

	public void setDescripcionf_enemigo1(String descripcionf_enemigo1) {
		this.descripcionf_enemigo1 = descripcionf_enemigo1;
	}

	public String getDescripcionf_enemigo2() {
		return descripcionf_enemigo2;
	}

	public void setDescripcionf_enemigo2(String descripcionf_enemigo2) {
		this.descripcionf_enemigo2 = descripcionf_enemigo2;
	}

	public String getDescripcionf_enemigo3() {
		return descripcionf_enemigo3;
	}

	public void setDescripcionf_enemigo3(String descripcionf_enemigo3) {
		this.descripcionf_enemigo3 = descripcionf_enemigo3;
	}

	public String getDescripcionf_enemigo4() {
		return descripcionf_enemigo4;
	}

	public void setDescripcionf_enemigo4(String descripcionf_enemigo4) {
		this.descripcionf_enemigo4 = descripcionf_enemigo4;
	}

	public String getDescripcionf_enemigo5() {
		return descripcionf_enemigo5;
	}

	public void setDescripcionf_enemigo5(String descripcionf_enemigo5) {
		this.descripcionf_enemigo5 = descripcionf_enemigo5;
	}

	public String getDescripcionf_enemigo6() {
		return descripcionf_enemigo6;
	}

	public void setDescripcionf_enemigo6(String descripcionf_enemigo6) {
		this.descripcionf_enemigo6 = descripcionf_enemigo6;
	}

	public String getDescripcionf_enemigoFinal() {
		return descripcionf_enemigoFinal;
	}

	public void setDescripcionf_enemigoFinal(String descripcionf_enemigoFinal) {
		this.descripcionf_enemigoFinal = descripcionf_enemigoFinal;
	}

	public String getNombreh_enemigo1() {
		return nombreh_enemigo1;
	}

	public void setNombreh_enemigo1(String nombreh_enemigo1) {
		this.nombreh_enemigo1 = nombreh_enemigo1;
	}

	public String getNombreh_enemigo2() {
		return nombreh_enemigo2;
	}

	public void setNombreh_enemigo2(String nombreh_enemigo2) {
		this.nombreh_enemigo2 = nombreh_enemigo2;
	}

	public String getNombreh_enemigo3() {
		return nombreh_enemigo3;
	}

	public void setNombreh_enemigo3(String nombreh_enemigo3) {
		this.nombreh_enemigo3 = nombreh_enemigo3;
	}

	public String getNombreh_enemigo4() {
		return nombreh_enemigo4;
	}

	public void setNombreh_enemigo4(String nombreh_enemigo4) {
		this.nombreh_enemigo4 = nombreh_enemigo4;
	}

	public String getNombreh_enemigo5() {
		return nombreh_enemigo5;
	}

	public void setNombreh_enemigo5(String nombreh_enemigo5) {
		this.nombreh_enemigo5 = nombreh_enemigo5;
	}

	public String getNombreh_enemigo6() {
		return nombreh_enemigo6;
	}

	public void setNombreh_enemigo6(String nombreh_enemigo6) {
		this.nombreh_enemigo6 = nombreh_enemigo6;
	}

	public String getNombreh_enemigoFinal() {
		return nombreh_enemigoFinal;
	}

	public void setNombreh_enemigoFinal(String nombreh_enemigoFinal) {
		this.nombreh_enemigoFinal = nombreh_enemigoFinal;
	}

	public int getDatosh_enemigo1() {
		return datosh_enemigo1;
	}

	public void setDatosh_enemigo1(int datosh_enemigo1) {
		this.datosh_enemigo1 = datosh_enemigo1;
	}

	public int getDatosh_enemigo2() {
		return datosh_enemigo2;
	}

	public void setDatosh_enemigo2(int datosh_enemigo2) {
		this.datosh_enemigo2 = datosh_enemigo2;
	}

	public int getDatosh_enemigo3() {
		return datosh_enemigo3;
	}

	public void setDatosh_enemigo3(int datosh_enemigo3) {
		this.datosh_enemigo3 = datosh_enemigo3;
	}

	public int getDatosh_enemigo4() {
		return datosh_enemigo4;
	}

	public void setDatosh_enemigo4(int datosh_enemigo4) {
		this.datosh_enemigo4 = datosh_enemigo4;
	}

	public int getDatosh_enemigo5() {
		return datosh_enemigo5;
	}

	public void setDatosh_enemigo5(int datosh_enemigo5) {
		this.datosh_enemigo5 = datosh_enemigo5;
	}

	public int getDatosh_enemigo6() {
		return datosh_enemigo6;
	}

	public void setDatosh_enemigo6(int datosh_enemigo6) {
		this.datosh_enemigo6 = datosh_enemigo6;
	}

	public int getDatosh_enemigoFinal() {
		return datosh_enemigoFinal;
	}

	public void setDatosh_enemigoFinal(int datosh_enemigoFinal) {
		this.datosh_enemigoFinal = datosh_enemigoFinal;
	}

	public String getDescripcionh_enemigo1() {
		return descripcionh_enemigo1;
	}

	public void setDescripcionh_enemigo1(String descripcionh_enemigo1) {
		this.descripcionh_enemigo1 = descripcionh_enemigo1;
	}

	public String getDescripcionh_enemigo2() {
		return descripcionh_enemigo2;
	}

	public void setDescripcionh_enemigo2(String descripcionh_enemigo2) {
		this.descripcionh_enemigo2 = descripcionh_enemigo2;
	}

	public String getDescripcionh_enemigo3() {
		return descripcionh_enemigo3;
	}

	public void setDescripcionh_enemigo3(String descripcionh_enemigo3) {
		this.descripcionh_enemigo3 = descripcionh_enemigo3;
	}

	public String getDescripcionh_enemigo4() {
		return descripcionh_enemigo4;
	}

	public void setDescripcionh_enemigo4(String descripcionh_enemigo4) {
		this.descripcionh_enemigo4 = descripcionh_enemigo4;
	}

	public String getDescripcionh_enemigo5() {
		return descripcionh_enemigo5;
	}

	public void setDescripcionh_enemigo5(String descripcionh_enemigo5) {
		this.descripcionh_enemigo5 = descripcionh_enemigo5;
	}

	public String getDescripcionh_enemigo6() {
		return descripcionh_enemigo6;
	}

	public void setDescripcionh_enemigo6(String descripcionh_enemigo6) {
		this.descripcionh_enemigo6 = descripcionh_enemigo6;
	}

	public String getDescripcionh_enemigoFinal() {
		return descripcionh_enemigoFinal;
	}

	public void setDescripcionh_enemigoFinal(String descripcionh_enemigoFinal) {
		this.descripcionh_enemigoFinal = descripcionh_enemigoFinal;
	}
}