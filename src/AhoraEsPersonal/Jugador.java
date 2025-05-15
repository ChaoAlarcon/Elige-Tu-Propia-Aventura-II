package AhoraEsPersonal;

public class Jugador {
	
	// ATRIBUTOS
	private String nombre;
	private int vida;
	private int ataqueBasico;
	private int ataqueFuerte;
	private int habilidadEspecial;
	private int usosEspecial = 0;

	// CONSTRUCTORES
	
	public Jugador(String nombre, int vida, int ataB, int ataF, int esp) {
		this.nombre = nombre;
		this.vida = vida;
		this.ataqueBasico = ataB;
		this.ataqueFuerte = ataF;
		this.habilidadEspecial = esp;
	}

	// GETTERS Y SETTERS
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public void setAtaqueBasico(int ataqueBasico) {
		this.ataqueBasico = ataqueBasico;
	}

	public void setAtaqueFuerte(int ataqueFuerte) {
		this.ataqueFuerte = ataqueFuerte;
	}

	public void setHabilidadEspecial(int habilidadEspecial) {
		this.habilidadEspecial = habilidadEspecial;
	}

	public void setUsosEspecial(int usosEspecial) {
		this.usosEspecial = usosEspecial;
	}

	public String getNombre() {
		return nombre;
	}

	public int getVida() {
		return vida;
	}

	public boolean estaVivo() {
		return vida > 0;
	}

	public int getAtaqueBasico() {
		return ataqueBasico;
	}

	public int getAtaqueFuerte() {
		return ataqueFuerte;
	}

	public int getHabilidadEspecial() {
		return habilidadEspecial;
	}

	public int getUsosEspecial() {
		return usosEspecial;
	}

	public void recibirDanio(int d) {
		vida = Math.max(0, vida - d);
	}

	
	// OTROS MÉTODOS
	
	public void ganarUsoEspecial() {
		usosEspecial++;
	}

	public void gastarUsoFuerte() {
		if (usosEspecial > 0)
			usosEspecial--;
	}
}
