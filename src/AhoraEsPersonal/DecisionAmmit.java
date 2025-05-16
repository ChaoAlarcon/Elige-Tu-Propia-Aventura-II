package AhoraEsPersonal;

import java.util.Scanner;

public class DecisionAmmit {
	Scanner sc = new Scanner(System.in);
	private Jugador jugador;
	private int respuesta;

	public DecisionAmmit(Scanner sc, Jugador jugador) {
		this.sc = sc;
		this.jugador = jugador;
	}

	/* Devuelve true si sigue vivo y hay combate final. */
	public boolean ejecutarPuzzle() {
		System.out.println("Has superado 5 retos → aparece Ammit...");
		System.out.println("1) Abandonar aliados (muerte segura)");
		System.out.println("2) Seguir juntos (ganas Favor de Ammit).");
		respuesta = sc.nextInt();
		while (respuesta != 1 && respuesta != 2) {
			System.out.println("Elige 1 o 2.");
			respuesta = sc.nextInt();
		}
		if (respuesta == 1) {
			System.out.println("Eres castigado. FIN.");
			jugador.setVida(0);
			return false;
		} else {
			System.out.println("Ammit otorga su favor.");
			jugador.ganarUsoEspecial();
			return true;
		}
	}
}
