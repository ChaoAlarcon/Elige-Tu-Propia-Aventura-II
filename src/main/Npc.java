package main;

import java.sql.*;
import main.ConectarBDD;

public class Npc {
    private String companero;
    private String npcRandom;
    private String npcDios;
    private String especie_companero;
    private String especie_npcRandom;
    private String especie_npcDios;
    private String frase1_companero;
    private String frase2_companero;
    private String frase3_companero;
    private String frase1_npcRandom;
    private String frase2_npcRandom;
    private String frase3_npcRandom;
    private String frase1_npcDios;
    private String frase2_npcDios;
    private String frase3_npcDios;
    private String frase4_npcDios;
    private int ayuda1_companero;
    private int ayuda2_companero;
    private int ayuda3_companero;
    private int ayuda1_npcRandom;
    private int ayuda2_npcRandom;
    private int ayuda3_npcRandom;
    private int ayuda1_npcDios;
    private int ayuda2_npcDios;
    private int ayuda3_npcDios;
    ConectarBDD conectarBDD = new ConectarBDD();


	public Npc(String companero, String npcRandom, String npcDios, String especie_companero, String especie_npcRandom,
	           String especie_npcDios, String frase1_companero, String frase2_companero, String frase3_companero,
	           String frase1_npcRandom, String frase2_npcRandom, String frase3_npcRandom, String frase1_npcDios,
	           String frase2_npcDios, String frase3_npcDios, String frase4_npcDios, int ayuda1_companero,
	           int ayuda2_companero, int ayuda3_companero, int ayuda1_npcRandom, int ayuda2_npcRandom,
	           int ayuda3_npcRandom, int ayuda1_npcDios, int ayuda2_npcDios, int ayuda3_npcDios) {
	
	    this.companero = companero;
	    this.npcRandom = npcRandom;
	    this.npcDios = npcDios;
	    this.especie_companero = especie_companero;
	    this.especie_npcRandom = especie_npcRandom;
	    this.especie_npcDios = especie_npcDios;
	    this.frase1_companero = frase1_companero;
	    this.frase2_companero = frase2_companero;
	    this.frase3_companero = frase3_companero;
	    this.frase1_npcRandom = frase1_npcRandom;
	    this.frase2_npcRandom = frase2_npcRandom;
	    this.frase3_npcRandom = frase3_npcRandom;
	    this.frase1_npcDios = frase1_npcDios;
	    this.frase2_npcDios = frase2_npcDios;
	    this.frase3_npcDios = frase3_npcDios;
	    this.frase4_npcDios = frase4_npcDios;
	    this.ayuda1_companero = ayuda1_companero;
	    this.ayuda2_companero = ayuda2_companero;
	    this.ayuda3_companero = ayuda3_companero;
	    this.ayuda1_npcRandom = ayuda1_npcRandom;
	    this.ayuda2_npcRandom = ayuda2_npcRandom;
	    this.ayuda3_npcRandom = ayuda3_npcRandom;
	    this.ayuda1_npcDios = ayuda1_npcDios;
	    this.ayuda2_npcDios = ayuda2_npcDios;
	    this.ayuda3_npcDios = ayuda3_npcDios;
	}
	
	public Npc() {
		
	}

    
	public String getCompanero() {
		return companero;
	}
	
	public String getNpcRandom() {
		return npcRandom;
	}

	public String getNpcDios() {
		return npcDios;
	}

	public String getEspecie_companero() {
		return especie_companero;
	}

	public String getEspecie_npcRandom() {
		return especie_npcRandom;
	}

	public String getEspecie_npcDios() {
		return especie_npcDios;
	}
	
	public String getFrase1_companero() {
		return frase1_companero;
	}

	public String getFrase2_companero() {
		return frase2_companero;
	}

	public String getFrase3_companero() {
		return frase3_companero;
	}

	public String getFrase1_npcRandom() {
		return frase1_npcRandom;
	}

	public String getFrase2_npcRandom() {
		return frase2_npcRandom;
	}

	public String getFrase3_npcRandom() {
		return frase3_npcRandom;
	}

	public String getFrase1_npcDios() {
		return frase1_npcDios;
	}

	public String getFrase2_npcDios() {
		return frase2_npcDios;
	}

	public String getFrase3_npcDios() {
		return frase3_npcDios;
	}
	
	public String getFrase4_npcDios() {
		return frase4_npcDios;
	}

	public int getAyuda1_companero() {
		return ayuda1_companero;
	}

	public int getAyuda2_companero() {
		return ayuda2_companero;
	}


	public int getAyuda3_companero() {
		return ayuda3_companero;
	}

	public int getAyuda1_npcRandom() {
		return ayuda1_npcRandom;
	}
	
	public int getAyuda2_npcRandom() {
		return ayuda2_npcRandom;
	}

	public int getAyuda3_npcRandom() {
		return ayuda3_npcRandom;
	}
	
	public int getAyuda1_npcDios() {
		return ayuda1_npcDios;
	}

	public int getAyuda2_npcDios() {
		return ayuda2_npcDios;
	}

	public int getAyuda3_npcDios() {
		return ayuda3_npcDios;
	}
	
	
	public void creacionNpc() {
		companero = conectarBDD.consultarDatosString("nombreNPC", "npc", "id_npc = 1");
        npcRandom = conectarBDD.consultarDatosString("nombreNPC", "npc", "id_npc = 2");
        npcDios = conectarBDD.consultarDatosString("nombreNPC", "npc", "id_npc = 3");
        especie_companero = conectarBDD.consultarDatosString("especie", "npc", "id_npc = 1");
        especie_npcRandom = conectarBDD.consultarDatosString("especie", "npc", "id_npc = 2");
        especie_npcDios = conectarBDD.consultarDatosString("especie", "npc", "id_npc = 3");
        frase1_companero = conectarBDD.consultarDatosString("frase_1", "npc", "id_npc = 1");
        frase2_companero = conectarBDD.consultarDatosString("frase_2", "npc", "id_npc = 1");
        frase3_companero = conectarBDD.consultarDatosString("frase_3", "npc", "id_npc = 1");
        frase1_npcRandom = conectarBDD.consultarDatosString("frase_1", "npc", "id_npc = 2");
        frase2_npcRandom = conectarBDD.consultarDatosString("frase_2", "npc", "id_npc = 2");
        frase3_npcRandom = conectarBDD.consultarDatosString("frase_3", "npc", "id_npc = 2");
        frase1_npcDios = conectarBDD.consultarDatosString("frase_1", "npc", "id_npc = 3");
        frase2_npcDios = conectarBDD.consultarDatosString("frase_2", "npc", "id_npc = 3");
        frase3_npcDios = conectarBDD.consultarDatosString("frase_3", "npc", "id_npc = 3");
        frase4_npcDios = conectarBDD.consultarDatosString("frase_4", "npc", "id_npc = 3");
        ayuda1_companero = conectarBDD.consultarDatosint("ayuda_1", "npc", "id_npc = 1");
        ayuda2_companero = conectarBDD.consultarDatosint("ayuda_2", "npc", "id_npc = 1");
        ayuda3_companero = conectarBDD.consultarDatosint("ayuda_3", "npc", "id_npc = 1");
        ayuda1_npcRandom = conectarBDD.consultarDatosint("ayuda_1", "npc", "id_npc = 2");
        ayuda2_npcRandom = conectarBDD.consultarDatosint("ayuda_2", "npc", "id_npc = 2");
        ayuda3_npcRandom = conectarBDD.consultarDatosint("ayuda_3", "npc", "id_npc = 2");
        ayuda1_npcDios = conectarBDD.consultarDatosint("ayuda_1", "npc", "id_npc = 3");
        ayuda2_npcDios = conectarBDD.consultarDatosint("ayuda_2", "npc", "id_npc = 3");
        ayuda3_npcDios = conectarBDD.consultarDatosint("ayuda_3", "npc", "id_npc = 3");
	}
	
    public void presentacionCompanero() {
    	System.out.println("Te acompañará " + companero + " que es un " + especie_companero + " y el cual te podrá ayudar en los combates.");
    }

}