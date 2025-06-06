package main;

import java.sql.*;
import main.ConectarBDD;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Batallas extends Enemigos {
	ConectarBDD conectarBDD = new ConectarBDD();
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	Personajes heroe = new Personajes();
	Climas clima = new Climas();
	Terrenos terreno = new Terrenos();
	HorasDelDia hora = new HorasDelDia();
	private ArrayList<String> nombreBatalla = new ArrayList<>();
	private int batallaActual = 0;
	private int numeroBatallas;
	private int respuestaUsuarioBatalla;
	private int precisionBasicoActual;
	private int precisionFuerteActual;
	private int vidaEnemigoActual;
	private int ataqueEnemigoAleatorio;
	private boolean horaCambiada = false;
	private boolean terrenoCambiado = false;
	private boolean climaCambiado = false;

	public Batallas() {

	}

	public ArrayList<String> getNombreBatalla() {
		return nombreBatalla;
	}

	public int getNumeroBatallas() {
		return numeroBatallas;
	}

	public void setNumeroBatallas(int numeroBatallas) {
		this.numeroBatallas = numeroBatallas;
	}

	public int getBatallaActual() {
		return batallaActual;
	}

	public void setBatallaActual(int batallaActual) {
		this.batallaActual = batallaActual;
	}

	public boolean isHoraCambiada() {
		return horaCambiada;
	}

	public void setHoraCambiada(boolean horaCambiada) {
		this.horaCambiada = horaCambiada;
	}

	public boolean isTerrenoCambiado() {
		return terrenoCambiado;
	}

	public void setTerrenoCambiado(boolean terrenoCambiado) {
		this.terrenoCambiado = terrenoCambiado;
	}

	public boolean isClimaCambiado() {
		return climaCambiado;
	}

	public void setClimaCambiado(boolean climaCambiado) {
		this.climaCambiado = climaCambiado;
	}

	public void creacionBatallas() {
		numeroBatallas = conectarBDD.obtenerNumeroDeFilas("batallas");
		for (int i = 1; i <= numeroBatallas; i++) {
			nombreBatalla.add(conectarBDD.consultarDatosString("nombreBatalla", "batallas", "id_batallas= " + i));
		}
	}

	public void batallas() {
		clima.efectoClimaDescrip();
		terreno.efectoTerrenoDescrip();
		hora.efectoHoraDelDiaDescrip();
		if (batallaActual == 0) {
			System.out.println(
					"Mientras avanzáis por el camino de arena que lleva a la nueva pirámide, os encontráis con un cactus de aspecto extraño, que parece que os amenaza con su mirada.\n"
							+ nombreBatalla.get(batallaActual));
		}
		if (batallaActual == 1) {
			System.out.println(nombreBatalla.get(batallaActual));
		}
		if (batallaActual == 2) {
			System.out.println(
					"La puerta os lleva a una zona, que parece el interior de un volcán, y en el centro de la sala veis que hay una puerta de color verde.”n"
							+ "“Os dirigís hacia ella, y cuando estais a mitad de camino, el suelo empieza a temblar y de la cascada de lava surge un "
							+ getEnemigos().get(batallaActual) + " que se dirige rápidamente hacia vosotros, "
							+ getEnemigos().get(batallaActual) + " y " + heroe.getNombrePersonaje()
							+ " entran en combate:\n" + nombreBatalla);
		}
		if (batallaActual == 3) {
			System.out.println(nombreBatalla.get(batallaActual));
		}
		if (batallaActual == 4) {
			System.out.println(
					"Entrais por la puerta y os encontráis en la cima de una montaña, veis que cerca de donde estais hay un pequeño lago con una isla en el centro,"
					+ " y en ella una puerta morada, así que os dirigís hacia allí, pero antes de cruzar, veis una sombra en el agua, del agua salta " 
							+ getEnemigos().get(batallaActual) + ", cortando el paso hacia la puerta. " + getEnemigos().get(batallaActual) + " y " 
					+ heroe.getNombrePersonaje() + " entran en combate:\n" + nombreBatalla);
			System.out.println("Al derrotar a " + getEnemigos().get(batallaActual - 1) + ", se forma un puente de hielo que os permite cruzar a la isla.");
		}
		if (batallaActual == 5) {
			System.out.println("La puerta os lleva al interior de una cueva repleta de cristales mágicos, seguís hacia delante y encontráis una habitación en "
					+ "la que parece que Taharka y sus aprendices realizaban sus experimentos con los muertos. Empezáis a buscar algún sitio por donde seguir, "
					+ "cuando aparece " + getEnemigos().get(batallaActual) + " dispuesto a proteger su guarida." + getEnemigos().get(batallaActual) + " y " + heroe.getNombrePersonaje() + " entran en combate:\n" + nombreBatalla);
		}
		if (batallaActual == 6) {
			System.out.println("Al derrotar a " + getEnemigos().get(batallaActual - 1) + ", una luz morada os envuelve y os teletransporta.");
		}
		System.out.println("Empiezas el combate:");
		horaCambiada = false;
		terrenoCambiado = false;
		climaCambiado = false;
		while (getVida().get(batallaActual) >= 0 && heroe.getVida() >= 0) {
			vidaEnemigoActual = getVida().get(batallaActual);
			System.out.println("A " + getEnemigos().get(batallaActual) + " le quedan " + getVida().get(batallaActual)
					+ " puntos de vida");
			System.out.println("Que quieres hacer?");
			System.out.println("1." + heroe.getNombreBasico() + ":" + heroe.getDanoBasico() + " puntos de daño. ("
					+ heroe.getDescripcionBasico() + ")");
			System.out.println("2." + heroe.getNombreFuerte() + ":" + heroe.getDanoFuerte() + " puntos de daño. ("
					+ heroe.getDescripcionFuerte() + ")");
			System.out.println("3." + heroe.getNombreHabilidad() + ":" + heroe.getDatosHabilidad()
					+ " puntos de daño. (" + heroe.getDescripcionHabilidad() + ")");
			respuestaUsuarioBatalla = sc.nextInt();
			while (respuestaUsuarioBatalla < 1 || respuestaUsuarioBatalla > 3) {
				System.out.println("Opciones inválida");
				respuestaUsuarioBatalla = sc.nextInt();
			}
			if (respuestaUsuarioBatalla == 1) {
				precisionBasicoActual = random.nextInt(99) + 1;
				if (heroe.getPrecisionBasico() - precisionBasicoActual >= 80) {
					System.out.println("Usaste " + heroe.getNombreBasico() + " y le has hecho un daño crítico de "
							+ heroe.getDanoBasico() + " puntos de daño a " + getEnemigos().get(batallaActual) + ".");
					vidaEnemigoActual = vidaEnemigoActual - heroe.getDanoBasico() + hora.efectoHoraDelDia();
					System.out.println("A " + getEnemigos().get(batallaActual) + " le quedan " + vidaEnemigoActual
							+ " puntos de vida");
				}
				if (heroe.getPrecisionBasico() - precisionBasicoActual >= 20
						&& heroe.getPrecisionBasico() - precisionBasicoActual < 80) {
					System.out.println("Usaste " + heroe.getNombreBasico() + " y le has hecho un daño de "
							+ heroe.getDanoBasico() / 2 + " puntos de daño a " + getEnemigos().get(batallaActual)
							+ ".");
					vidaEnemigoActual = vidaEnemigoActual - heroe.getDanoBasico() / 2;
					System.out.println("A " + getEnemigos().get(batallaActual) + " le quedan " + vidaEnemigoActual
							+ " puntos de vida");
				} else {
					System.out.println("Usaste " + heroe.getNombreBasico() + " pero fallaste el ataque.");
				}
			}

			if (respuestaUsuarioBatalla == 2) {
				precisionFuerteActual = random.nextInt(99) + 1;
				if (heroe.getPrecisionFuerte() - precisionFuerteActual >= 80) {
					System.out.println("Usaste " + heroe.getNombreFuerte() + " y le has hecho un daño crítico de "
							+ heroe.getDanoFuerte() + " puntos de daño a " + getEnemigos().get(batallaActual) + ".");
					vidaEnemigoActual = vidaEnemigoActual - heroe.getDanoFuerte() + hora.efectoHoraDelDia();
					System.out.println("A " + getEnemigos().get(batallaActual) + " le quedan " + vidaEnemigoActual
							+ " puntos de vida");
				}
				if (heroe.getPrecisionFuerte() - precisionBasicoActual >= 20
						&& heroe.getPrecisionFuerte() - precisionFuerteActual < 80) {
					System.out.println("Usaste " + heroe.getNombreFuerte() + " y le has hecho un daño de "
							+ heroe.getDanoFuerte() / 2 + " puntos de daño a " + getEnemigos().get(batallaActual)
							+ ".");
					vidaEnemigoActual = vidaEnemigoActual - heroe.getDanoFuerte() / 2;
					System.out.println("A " + getEnemigos().get(batallaActual) + " le quedan " + vidaEnemigoActual
							+ " puntos de vida");
				} else {
					System.out.println("Usaste " + heroe.getNombreFuerte() + " pero fallaste el ataque.");
				}
			}

			if (respuestaUsuarioBatalla == 3) {
				if (heroe.getOpcionPersonaje() == 1) {

				}
				if (heroe.getOpcionPersonaje() == 2) {

				}
				if (heroe.getOpcionPersonaje() == 3) {

				}
			}

			if (getVida().get(batallaActual) >= 0) {
				ataqueEnemigoAleatorio = random.nextInt(2);
				precisionBasicoActual = random.nextInt(99) + 1;
				if (ataqueEnemigoAleatorio == 0) {
					if (precisionBasicoActual >= 80) {
						System.out.println(getEnemigos().get(batallaActual) + " te ataca con " + getNombreBasico()
								+ " y te hace un crítico de " + getDanoBasico().get(batallaActual)
								+ " puntos de daño.");
						heroe.setVida(heroe.getVida() - getDanoBasico().get(batallaActual));
						System.out.println("Te quedan " + heroe.getVida() + " puntos de vida.");
					}
					if (precisionBasicoActual >= 20 && precisionBasicoActual < 80) {
						System.out.println(getEnemigos().get(batallaActual) + " te ataca con " + getNombreBasico()
								+ " y te hace " + getDanoBasico().get(batallaActual) / 2 + " puntos de daño.");
						heroe.setVida(heroe.getVida() - getDanoBasico().get(batallaActual) / 2);
						System.out.println("Te quedan " + heroe.getVida() + " puntos de vida.");
					} else {
						System.out.println(getEnemigos().get(batallaActual) + " usó " + getNombreBasico()
								+ " pero falló el ataque.");
					}
				}
			}
			if (ataqueEnemigoAleatorio == 1) {
				if (precisionBasicoActual >= 80) {
					System.out.println(getEnemigos().get(batallaActual) + " te ataca con " + getNombreFuerte()
							+ " y te hace un crítico de " + getDanoFuerte().get(batallaActual) + " puntos de daño.");
					heroe.setVida(heroe.getVida() - getDanoFuerte().get(batallaActual));
					System.out.println("Te quedan " + heroe.getVida() + " puntos de vida.");
				}
				if (precisionBasicoActual >= 20 && precisionBasicoActual < 80) {
					System.out.println(getEnemigos().get(batallaActual) + " te ataca con " + getNombreFuerte()
							+ " y te hace " + getDanoFuerte().get(batallaActual) / 2 + " puntos de daño.");
					heroe.setVida(heroe.getVida() - getDanoFuerte().get(batallaActual) / 2);
					System.out.println("Te quedan " + heroe.getVida() + " puntos de vida.");
				} else {
					System.out.println(
							getEnemigos().get(batallaActual) + " usó " + getNombreFuerte() + " pero falló el ataque.");
				}
			}
			if (ataqueEnemigoAleatorio == 2) {
				if (getDatosHabilidad().get(batallaActual) > 3) {
					System.out.println(getEnemigos().get(batallaActual) + " te ataca con "
							+ getNombreHabilidad().get(batallaActual) + " y te hace "
							+ getDatosHabilidad().get(batallaActual) + " puntos de daño.");
					heroe.setVida(heroe.getVida() - getDatosHabilidad().get(batallaActual));
					System.out.println("Te quedan " + heroe.getVida() + " puntos de vida.");
				} else if (getDatosHabilidad().get(batallaActual) == 1) {
					terrenoCambiado = true;
				} else if (getDatosHabilidad().get(batallaActual) == 2) {
					terrenoCambiado = true;
					climaCambiado = true;
				} else if (getDatosHabilidad().get(batallaActual) == 3) {
					terrenoCambiado = true;
					climaCambiado = true;
					horaCambiada = true;
				}
			}
		}
		batallaActual++;
	}
}
