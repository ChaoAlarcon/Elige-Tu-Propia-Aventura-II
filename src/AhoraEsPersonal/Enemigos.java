package AhoraEsPersonal;


public class Enemigos {
    private String nombre;
    private int vida;
    private int ataque;

    public Enemigos(String n, int v, int a) {
        this.nombre = n;
        this.vida = v;
        this.ataque = a;
    }

    public String getNombre() { return nombre; }
    public int getVida()      { return vida; }
    public boolean estaVivo() { return vida > 0; }

    public void recibirDanio(int d) {
        vida = Math.max(0, vida - d);
    }

    public int getAtaque() { return ataque; }
}
