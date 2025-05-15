package AhoraEsPersonal;

import java.util.Scanner;

public class DecisionAmmit {
	private Scanner sc;
	private Jugador j;

	public DecisionAmmit(Scanner sc, Jugador j) {
		this.sc = sc;
		this.j = j;
	}

	/** Devuelve true si sigue vivo y hay combate final. */
	public boolean ejecutarPuzzle() {
		System.out.println("Has superado 5 retos → aparece Ammit...");
		System.out.println("1) Abandonar aliados (muerte segura)");
		System.out.println("2) Seguir juntos (ganas Favor de Ammit).");
		int respuesta = sc.nextInt();
		while (respuesta != 1 && respuesta != 2) {
			System.out.println("Elige 1 o 2.");
			respuesta = sc.nextInt();
		}
		if (respuesta == 1) {
			System.out.println("Eres castigado. FIN.");
			j.setVida(0);
			return false;
		} else {
			System.out.println("Ammit otorga su favor.");
			j.ganarUsoEspecial();
			return true;
		}
	}
}
