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
    Climas clima = new Climas();
	
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
	
	public void creacionNpcs() {
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
    	clima.creacionClimas();
    }
}