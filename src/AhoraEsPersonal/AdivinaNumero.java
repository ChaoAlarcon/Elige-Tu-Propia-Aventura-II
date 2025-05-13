package AhoraEsPersonal;

import java.util.Random;
import java.util.Scanner;

public class AdivinaNumero implements Puzzle {
    private Scanner sc;
    public AdivinaNumero(Scanner sc) { this.sc = sc; }

    public boolean ejecutar(Jugador j) {
        Random rnd = new Random();
        int secreto = rnd.nextInt(10);
        int intentos = 5;
        System.out.println("Rompecabezas 2: Adivina el número (0–9).");
        while (intentos-- > 0) {
            int a = sc.nextInt();
            if (a == secreto) {
                System.out.println("¡Correcto!");
                return true;
            }
            System.out.println(a < secreto ? "Más alto" : "Más bajo");
            System.out.println("Te quedan " + intentos);
        }
        System.out.println("Fallaste y pierdes un uso de especial.");
        return false;
    }
}
