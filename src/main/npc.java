package main;

import java.sql.*;
import main.ConectarBDD;

public class npc {
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

    public npc() {
        this.companero = conectarBDD.consultarDatosString("nombreNPC", "npc", "id_npc = 1");
        this.npcRandom = conectarBDD.consultarDatosString("nombreNPC", "npc", "id_npc = 2");
        this.npcDios = conectarBDD.consultarDatosString("nombreNPC", "npc", "id_npc = 3");
        this.especie_companero = conectarBDD.consultarDatosString("especie", "npc", "id_npc = 1");
        this.especie_npcRandom = conectarBDD.consultarDatosString("especie", "npc", "id_npc = 2");
        this.especie_npcDios = conectarBDD.consultarDatosString("especie", "npc", "id_npc = 3");
        this.frase1_companero = conectarBDD.consultarDatosString("frase_1", "npc", "id_npc = 1");
        this.frase2_companero = conectarBDD.consultarDatosString("frase_2", "npc", "id_npc = 1");
        this.frase3_companero = conectarBDD.consultarDatosString("frase_3", "npc", "id_npc = 1");
        this.frase1_npcRandom = conectarBDD.consultarDatosString("frase_1", "npc", "id_npc = 2");
        this.frase2_npcRandom = conectarBDD.consultarDatosString("frase_2", "npc", "id_npc = 2");
        this.frase3_npcRandom = conectarBDD.consultarDatosString("frase_3", "npc", "id_npc = 2");
        this.frase1_npcDios = conectarBDD.consultarDatosString("frase_1", "npc", "id_npc = 3");
        this.frase2_npcDios = conectarBDD.consultarDatosString("frase_2", "npc", "id_npc = 3");
        this.frase3_npcDios = conectarBDD.consultarDatosString("frase_3", "npc", "id_npc = 3");
        this.ayuda1_companero = conectarBDD.consultarDatosint("ayuda_1", "npc", "id_npc = 1");
        this.ayuda2_companero = conectarBDD.consultarDatosint("ayuda_2", "npc", "id_npc = 1");
        this.ayuda3_companero = conectarBDD.consultarDatosint("ayuda_3", "npc", "id_npc = 1");
        this.ayuda1_npcRandom = conectarBDD.consultarDatosint("ayuda_1", "npc", "id_npc = 2");
        this.ayuda2_npcRandom = conectarBDD.consultarDatosint("ayuda_2", "npc", "id_npc = 2");
        this.ayuda3_npcRandom = conectarBDD.consultarDatosint("ayuda_3", "npc", "id_npc = 2");
        this.ayuda1_npcDios = conectarBDD.consultarDatosint("ayuda_1", "npc", "id_npc = 3");
        this.ayuda2_npcDios = conectarBDD.consultarDatosint("ayuda_2", "npc", "id_npc = 3");
        this.ayuda3_npcDios = conectarBDD.consultarDatosint("ayuda_3", "npc", "id_npc = 3");
    }

	public String getCompanero() {
		return companero;
	}

	public void setCompanero(String companero) {
		this.companero = companero;
	}

	public String getNpcRandom() {
		return npcRandom;
	}

	public void setNpcRandom(String npcRandom) {
		this.npcRandom = npcRandom;
	}

	public String getNpcDios() {
		return npcDios;
	}

	public void setNpcDios(String npcDios) {
		this.npcDios = npcDios;
	}

	public String getEspecie_companero() {
		return especie_companero;
	}

	public void setEspecie_companero(String especie_companero) {
		this.especie_companero = especie_companero;
	}

	public String getEspecie_npcRandom() {
		return especie_npcRandom;
	}

	public void setEspecie_npcRandom(String especie_npcRandom) {
		this.especie_npcRandom = especie_npcRandom;
	}

	public String getEspecie_npcDios() {
		return especie_npcDios;
	}

	public void setEspecie_npcDios(String especie_npcDios) {
		this.especie_npcDios = especie_npcDios;
	}

	public String getFrase1_companero() {
		return frase1_companero;
	}

	public void setFrase1_companero(String frase1_companero) {
		this.frase1_companero = frase1_companero;
	}

	public String getFrase2_companero() {
		return frase2_companero;
	}

	public void setFrase2_companero(String frase2_companero) {
		this.frase2_companero = frase2_companero;
	}

	public String getFrase3_companero() {
		return frase3_companero;
	}

	public void setFrase3_companero(String frase3_companero) {
		this.frase3_companero = frase3_companero;
	}

	public String getFrase1_npcRandom() {
		return frase1_npcRandom;
	}

	public void setFrase1_npcRandom(String frase1_npcRandom) {
		this.frase1_npcRandom = frase1_npcRandom;
	}

	public String getFrase2_npcRandom() {
		return frase2_npcRandom;
	}

	public void setFrase2_npcRandom(String frase2_npcRandom) {
		this.frase2_npcRandom = frase2_npcRandom;
	}

	public String getFrase3_npcRandom() {
		return frase3_npcRandom;
	}

	public void setFrase3_npcRandom(String frase3_npcRandom) {
		this.frase3_npcRandom = frase3_npcRandom;
	}

	public String getFrase1_npcDios() {
		return frase1_npcDios;
	}

	public void setFrase1_npcDios(String frase1_npcDios) {
		this.frase1_npcDios = frase1_npcDios;
	}

	public String getFrase2_npcDios() {
		return frase2_npcDios;
	}

	public void setFrase2_npcDios(String frase2_npcDios) {
		this.frase2_npcDios = frase2_npcDios;
	}

	public String getFrase3_npcDios() {
		return frase3_npcDios;
	}

	public void setFrase3_npcDios(String frase3_npcDios) {
		this.frase3_npcDios = frase3_npcDios;
	}

	public int getAyuda1_companero() {
		return ayuda1_companero;
	}

	public void setAyuda1_companero(int ayuda1_companero) {
		this.ayuda1_companero = ayuda1_companero;
	}

	public int getAyuda2_companero() {
		return ayuda2_companero;
	}

	public void setAyuda2_companero(int ayuda2_companero) {
		this.ayuda2_companero = ayuda2_companero;
	}

	public int getAyuda3_companero() {
		return ayuda3_companero;
	}

	public void setAyuda3_companero(int ayuda3_companero) {
		this.ayuda3_companero = ayuda3_companero;
	}

	public int getAyuda1_npcRandom() {
		return ayuda1_npcRandom;
	}

	public void setAyuda1_npcRandom(int ayuda1_npcRandom) {
		this.ayuda1_npcRandom = ayuda1_npcRandom;
	}

	public int getAyuda2_npcRandom() {
		return ayuda2_npcRandom;
	}

	public void setAyuda2_npcRandom(int ayuda2_npcRandom) {
		this.ayuda2_npcRandom = ayuda2_npcRandom;
	}

	public int getAyuda3_npcRandom() {
		return ayuda3_npcRandom;
	}

	public void setAyuda3_npcRandom(int ayuda3_npcRandom) {
		this.ayuda3_npcRandom = ayuda3_npcRandom;
	}

	public int getAyuda1_npcDios() {
		return ayuda1_npcDios;
	}

	public void setAyuda1_npcDios(int ayuda1_npcDios) {
		this.ayuda1_npcDios = ayuda1_npcDios;
	}

	public int getAyuda2_npcDios() {
		return ayuda2_npcDios;
	}

	public void setAyuda2_npcDios(int ayuda2_npcDios) {
		this.ayuda2_npcDios = ayuda2_npcDios;
	}

	public int getAyuda3_npcDios() {
		return ayuda3_npcDios;
	}

	public void setAyuda3_npcDios(int ayuda3_npcDios) {
		this.ayuda3_npcDios = ayuda3_npcDios;
	}
    
    
}