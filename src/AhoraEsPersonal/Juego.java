package AhoraEsPersonal;
import java.util.Scanner;

public class Juego {
    private Scanner sc = new Scanner(System.in);
    private Jugador jugador;
    private boolean juegoActivo = true;

    public void iniciar() {
        verificarContrasena();
        seleccionarPersonaje();
        mostrarIntroduccion();
        runPuzzles();
        runDecisionFinal();
        if (juegoActivo) {
            runCombateFinal();
        }
        sc.close();
    }

    private void verificarContrasena() {
        String pass;
        boolean ok = false;
        do {
            System.out.print("Escribe la contraseña: ");
            pass = sc.nextLine();
            if (pass.equalsIgnoreCase("jugones")) {
                ok = true;
                System.out.println("¡Enhorabuena! Contraseña correcta.");
            } else {
                System.out.println("Contraseña incorrecta. Intenta de nuevo.");
            }
        } while (!ok);
    }

    private void seleccionarPersonaje() {
        String p;
        do {
            System.out.println("Elige personaje: Cambises, Bastet o Ánuket");
            p = sc.nextLine().trim();
        } while (!CreacionJugador.isValido(p));
        jugador = CreacionJugador.crear(p);
    }

    private void mostrarIntroduccion() {
        System.out.println();
        System.out.println("¡Comienza la aventura, " + jugador.getNombre() + "!");
        System.out.println("Taharka ha regresado...");  
        System.out.println();
    }

    private void runPuzzles() {
        // 1. Acertijo Esfinge
        Puzzle esfinge = new AcertijoEsfinge(sc);
        if (esfinge.ejecutar(jugador)) jugador.ganarUsoEspecial();

        // 2. Adivina número
        Puzzle num = new AdivinaNumero(sc);
        if (num.ejecutar(jugador)) jugador.ganarUsoEspecial();

        // 3. Piedra Papel Tijera
        Puzzle ppt = new PiedraPapelTijera(sc);
        if (ppt.ejecutar(jugador)) jugador.ganarUsoEspecial();

        // 4. Trivial Egipto
        Puzzle trivial = new TrivialEgipto(sc);
        if (trivial.ejecutar(jugador)) jugador.ganarUsoEspecial();

        // 5. Ahorcado
        Puzzle ahorcado = new Ahorcado(sc);
        if (ahorcado.ejecutar(jugador)) jugador.ganarUsoEspecial();
    }

    private void runDecisionFinal() {
        DecisionAmmit decision = new DecisionAmmit(sc, jugador);
        juegoActivo = decision.ejecutar();
    }

    private void runCombateFinal() {
        Enemigos taharka = new Enemigos("Taharka", 600, 50);
        Combate combate = new Combate(sc, jugador, taharka);
        combate.iniciar();
    }
}
