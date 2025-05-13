package AhoraEsPersonal;


import java.util.Random;
import java.util.Scanner;

public class Ahorcado implements Puzzle {
    private Scanner sc;
    public Ahorcado(Scanner sc) { this.sc = sc; }

    public boolean ejecutar(Jugador j) {
        String[] palabras = {"Seth","Anubis","Horus","Osiris","Sekhmet"};
        String secreto = palabras[new Random().nextInt(palabras.length)];
        char[] vis = new char[secreto.length()];
        for (int i = 0; i < vis.length; i++) vis[i]='-';
        int intentos = 6;
        System.out.println("Rompecabezas 5: Ahorcado.");
        while (intentos > 0) {
            System.out.println(vis);
            System.out.println("Intentos restantes: " + intentos);
            String e = sc.nextLine();
            if (e.length() == 1) {
                boolean acertó = false;
                for (int i = 0; i < secreto.length(); i++) {
                    if (String.valueOf(secreto.charAt(i)).equalsIgnoreCase(e)) {
                        vis[i] = secreto.charAt(i);
                        acertó = true;
                    }
                }
                if (!acertó) intentos--;
            } else if (e.equalsIgnoreCase(secreto)) {
                System.out.println("¡Adivinaste la palabra!");
                return true;
            } else {
                intentos--;
            }
            if (new String(vis).equalsIgnoreCase(secreto)) {
                System.out.println("¡Has completado la palabra!");
                return true;
            }
        }
        System.out.println("Perdiste y pierdes especial. La palabra era: " + secreto);
        return false;
    }
}
