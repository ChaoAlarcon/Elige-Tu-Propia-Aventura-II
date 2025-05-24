package main;

public class Enemigos {
	
	// ATRIBUTOS
	private String nombre;
	private int vida;
	private int ataque;
//
	// CONSTRUCTORES
	public Enemigos(String nombre, int vida, int ataque) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataque = ataque;
	}
	
	// GETTERS Y SETTERS
	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	// OTROS METODOS
	public boolean estaVivo() {
		return vida > 0;
	}

	public void recibirDanio(int danio) {
		vida = Math.max(0, vida - danio);
	}

}
