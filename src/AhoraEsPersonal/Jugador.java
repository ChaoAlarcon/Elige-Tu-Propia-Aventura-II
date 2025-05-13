package AhoraEsPersonal;

public class Jugador {
    private String nombre;
    private int vida;
    private int ataqueBasico;
    private int ataqueFuerte;
    private int habilidadEspecial;
    private int usosEspecial = 0;

    public Jugador(String nombre, int vida, int ataB, int ataF, int esp) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataqueBasico = ataB;
        this.ataqueFuerte = ataF;
        this.habilidadEspecial = esp;
    }

    // getters…
    public String getNombre() { return nombre; }
    public int getVida()   { return vida; }
    public boolean estaVivo() { return vida > 0; }
    public int getAtaqueBasico()  { return ataqueBasico; }
    public int getAtaqueFuerte()  { return ataqueFuerte; }
    public int getHabilidadEspecial() { return habilidadEspecial; }
    public int getUsosEspecial()  { return usosEspecial; }

    public void recibirDanio(int d) {
        vida = Math.max(0, vida - d);
    }

    public void ganarUsoEspecial() {
        usosEspecial++;
    }

    public void gastarUsoFuerte() {
        if (usosEspecial > 0) usosEspecial--;
    }
}
