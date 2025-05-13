package AhoraEsPersonal;

import java.util.Random;
import java.util.Scanner;

public class PiedraPapelTijera implements Puzzle {
    private Scanner sc; private Random rnd = new Random();
    private String[] opc = {"Piedra","Papel","Tijera"};

    public PiedraPapelTijera(Scanner sc) { this.sc = sc; }

    public boolean ejecutar(Jugador j) {
        int pJ=0, pE=0;
        System.out.println("Rompecabezas 3: Piedra, Papel o Tijera (al mejor de 3).");
        while (pJ < 3 && pE < 3) {
            System.out.println("0:Piedra 1:Papel 2:Tijera");
            int sel = sc.nextInt();
            int cpu = rnd.nextInt(3);
            System.out.println("Tú: "+opc[sel]+" | CPU: "+opc[cpu]);
            if (sel == cpu) {}
            else if ((sel+1)%3 == cpu) pE++;
            else pJ++;
            System.out.println("Puntos → Tú: "+pJ+" CPU: "+pE);
        }
        boolean win = pJ == 3;
        System.out.println(win ? "¡Ganaste!" : "Perdiste y pierdes especial.");
        return win;
    }
}
