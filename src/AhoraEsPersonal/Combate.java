package AhoraEsPersonal;

import java.util.Random;
import java.util.Scanner;

public class Combate {
    private Scanner sc;
    private Jugador j;
    private Enemigos e;
    private Random rand = new Random();

    public Combate(Scanner sc, Jugador j, Enemigos e) {
        this.sc = sc;
        this.j = j;
        this.e = e;
    }

    public void iniciar() {
        System.out.println("¡Comienza el combate contra " + e.getNombre() + "!");
        while (j.estaVivo() && e.estaVivo()) {
            turnoJugador();
            if (e.estaVivo()) turnoEnemigo();
        }
        if (j.estaVivo()) {
            System.out.println("Has derrotado a " + e.getNombre());
        } else {
            System.out.println("Has muerto. FIN DEL JUEGO.");
        }
    }

    private void turnoJugador() {
        System.out.println("Tu vida: " + j.getVida() + " | Vida enemigo: " + e.getVida());
        System.out.println("1) Básico (" + j.getAtaqueBasico() + ")");
        System.out.println("2) Especial (" + j.getHabilidadEspecial() + ")");
        if (j.getUsosEspecial() > 0) {
            System.out.println("3) Fuerte (" + j.getAtaqueFuerte() + ") usos: " + j.getUsosEspecial());
        }
        if (j.getUsosEspecial() > 0) System.out.println("4) Favor Ammit");
        int op = sc.nextInt();
        switch (op) {
            case 1: ataqueBasico(); break;
            case 2: usarHabilidad(); break;
            case 3: ataqueFuerte(); break;
            case 4: favorAmmit(); break;
            default: System.out.println("Opción inválida.");
        }
    }

    private void ataqueBasico() {
        int chance = rand.nextInt(100);
        if (chance > 50) {
            e.recibirDanio(j.getAtaqueBasico());
            System.out.println("Éxito: infliges " + j.getAtaqueBasico());
        } else if (chance > 25) {
            int mitad = j.getAtaqueBasico()/2;
            e.recibirDanio(mitad);
            System.out.println("Golpe débil: sólo " + mitad);
        } else {
            System.out.println("Fallaste.");
        }
    }

    private void usarHabilidad() {
        if (j.getNombre().equalsIgnoreCase("Bastet")) {
            System.out.println("Bastet se cura " + j.getHabilidadEspecial());
            j.recibirDanio(-j.getHabilidadEspecial());
        } else if (j.getNombre().equalsIgnoreCase("Cambises")) {
            System.out.println("Cambises potencia su arma en +" + j.getHabilidadEspecial());
            // Ajustar ataqueBasico/fuerte internamente si quieres...
        } else {
            System.out.println("Ánuket reduce daño enemigo en " + j.getHabilidadEspecial());
            // Ajustar temporalmente…
        }
    }

    private void ataqueFuerte() {
        if (j.getUsosEspecial() == 0) {
            System.out.println("No tienes usos de ataque fuerte.");
            return;
        }
        j.gastarUsoFuerte();
        int chance = rand.nextInt(100);
        if (chance > 50) {
            e.recibirDanio(j.getAtaqueFuerte());
            System.out.println("Ataque fuerte: infliges " + j.getAtaqueFuerte());
        } else {
            System.out.println("Ataque fuerte fallido.");
        }
    }

    private void favorAmmit() {
        if (j.getUsosEspecial() == 0) {
            System.out.println("No tienes el favor de Ammit.");
            return;
        }
        j.gastarUsoFuerte();
        e.recibirDanio(999999999);
        System.out.println("¡Favor de Ammit desatado!");
    }

    private void turnoEnemigo() {
        j.recibirDanio(e.getAtaque());
        System.out.println(e.getNombre() + " ataca y te quita " + e.getAtaque());
    }
}
