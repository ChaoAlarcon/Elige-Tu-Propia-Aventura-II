package AhoraEsPersonal;

import java.util.Scanner;

public class TrivialEgipto implements Puzzle {
    private Scanner sc;
    public TrivialEgipto(Scanner sc) { this.sc = sc; }

    public boolean ejecutar(Jugador j) {
        String[] preguntas = {
            "¿Río más largo de Egipto? a)Amazonas b)Nilo c)Yangtsé d)Misisipi",
            "¿Faraón más joven? a)Ramsés II b)Tutankamón c)Cleopatra d)Akhenatón",
            "¿Estructura en Giza? a)Muralla b)Coliseo c)Eiffel d)Pirámides",
            "¿Animal de la Esfinge? a)León b)Águila c)Serpiente d)Gato"
        };
        String[] correctas = {"b","b","d","a"};
        int puntuación = 0;
        for (int i = 0; i < 4; i++) {
            System.out.println("Pregunta " + (i+1) + ": " + preguntas[i]);
            String r = sc.nextLine().toLowerCase();
            if (r.equals(correctas[i])) {
                puntuación++;
                System.out.println("¡Correcto!");
            } else {
                System.out.println("Incorrecto.");
            }
        }
        boolean win = puntuación == 4;
        System.out.println("Tu puntuación: " + puntuación + "/4");
        if (!win) System.out.println("Fallaste y pierdes especial.");
        return win;
    }
}
