package main;
import java.sql.*;
import main.ConectarBDD;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class Batallas {
	ConectarBDD conectarBDD = new ConectarBDD();
	Scanner sc = new Scanner(System.in);
	Random random = new Random();
	Personajes heroe = new Personajes();
	Npc npc = new Npc();
	Climas clima = new Climas();
	Terrenos terreno = new Terrenos();
	HorasDelDia hora = new HorasDelDia();
	Enemigos enemigos = new Enemigos();
	private ArrayList<String> nombreBatalla = new ArrayList<>();
	private int batallaActual = 0;
	private int numeroBatallas;
	private int danoConHora;
	private int respuestaUsuarioBatalla;
	private int precisionBasicoActual;
	private int precisionFuerteActual;
	private int ataqueNpcAleatorio;
	private int ataqueEnemigoAleatorio;
	private int vidaEnemigoActual;
	private int ataqueBasicoEnemigoActual;
	private int ataqueFuerteEnemigoActual;
	private int danoSubidoB;
	private int danoSubidoF;
	
	public Batallas(Personajes heroe, Npc npc, Climas clima,
            Terrenos terreno, HorasDelDia hora, Enemigos enemigos,
            ArrayList<String> nombreBatalla, int batallaActual, int numeroBatallas, int danoConHora,
            int respuestaUsuarioBatalla, int precisionBasicoActual, int precisionFuerteActual,
            int ataqueNpcAleatorio, int ataqueEnemigoAleatorio, int vidaEnemigoActual) {

		this.heroe = heroe;
		this.npc = npc;
		this.clima = clima;
		this.terreno = terreno;
		this.hora = hora;
		this.enemigos = enemigos;
		this.nombreBatalla = nombreBatalla;
		this.batallaActual = batallaActual;
		this.numeroBatallas = numeroBatallas;
		this.danoConHora = danoConHora;
		this.respuestaUsuarioBatalla = respuestaUsuarioBatalla;
		this.precisionBasicoActual = precisionBasicoActual;
		this.precisionFuerteActual = precisionFuerteActual;
		this.ataqueNpcAleatorio = ataqueNpcAleatorio;
		this.ataqueEnemigoAleatorio = ataqueEnemigoAleatorio;
		this.vidaEnemigoActual = vidaEnemigoActual;
	}
	
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
	
	public void creacionBatallas() {
		heroe.ElejirPersonajes();
		npc.creacionNpc();
		npc.presentacionCompanero();
		clima.creacionClimas();
		terreno.creacionTerrenos();
		hora.creacionHorasDelDia();
		enemigos.creacionEnemigos();
		numeroBatallas = conectarBDD.obtenerNumeroDeFilas("batallas");
		for (int i = 1; i <= numeroBatallas; i++) {
			nombreBatalla.add(conectarBDD.consultarDatosString("nombreBatalla", "batallas", "id_batallas= " + i));
		}
		
	}
	
	public void batallas() {
			if (batallaActual == 0) {
				System.out.println("Mientras avanzáis por el camino de arena que lleva a la nueva pirámide,\n"
						+ "os encontráis con un cactus de aspecto extraño, que parece que os amenaza con su mirada.\n");
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			}
			if (batallaActual == 1) {
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");


			}
			if (batallaActual == 2) {
				System.out.println("Syso de batalla 3");
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			}
			if (batallaActual == 3) {
				System.out.println("Syso de batalla 4");
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			}
			if (batallaActual == 4) {
				System.out.println("Syso de batalla 5");
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			}
			if (batallaActual == 5) {
				System.out.println("Syso de batalla 6");
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			}
			if (batallaActual == 6) {
				System.out.println("Syso de batalla 7");
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
				System.out.println(nombreBatalla.get(batallaActual));
				System.out.println("-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-|-");
			}
			System.out.println("\n" + heroe.getNombrePersonaje() + " y " + enemigos.getEnemigos().get(batallaActual) + " entran en combate\n");
			
			danoSubidoB = heroe.getDanoBasico();
			danoSubidoF = heroe.getDanoFuerte();
			vidaEnemigoActual = enemigos.getVida().get(batallaActual);
			ataqueBasicoEnemigoActual = enemigos.getDanoBasico().get(batallaActual);
			ataqueFuerteEnemigoActual = enemigos.getDanoFuerte().get(batallaActual);
			clima.efectoClimaDescrip();
			hora.efectoHoraDelDiaDescrip();
			terreno.efectoTerrenoDescrip();
			while (vidaEnemigoActual > 0 && heroe.getVida() > 0) {
				heroe.setVida(heroe.getVida() + terreno.efectoTerreno());
				if (heroe.getVida() > heroe.getVidaMax()) {
					heroe.setVida(heroe.getVidaMax());
				}
				//MENU
				System.out.println("\nA ~" + enemigos.getEnemigos().get(batallaActual) + "~ le quedan |" + vidaEnemigoActual + "| puntos de vida");
				System.out.println("Te quedan |" + heroe.getVida() + "| puntos de vida");
				System.out.println("\n----------------------------");
				System.out.println("Menu de batalla:\n");
				System.out.println("1. " + heroe.getNombreBasico() + ": |" + heroe.getDanoBasico() + "| puntos de daño. (" + heroe.getDescripcionBasico() + ")");
				System.out.println("2. " + heroe.getNombreFuerte() + ": |" + heroe.getDanoFuerte() + "| puntos de daño. (" + heroe.getDescripcionFuerte() + ")");
				System.out.println("3. " + heroe.getNombreHabilidad() + ": |" + heroe.getDatosHabilidad() + "| puntos de daño. (" + heroe.getDescripcionHabilidad() + ")");
				System.out.println("----------------------------");
				respuestaUsuarioBatalla = sc.nextInt();
				while (respuestaUsuarioBatalla < 1 || respuestaUsuarioBatalla > 3) {
					System.out.println("Opciones inválida");
					respuestaUsuarioBatalla = sc.nextInt();
				}
				//BÁSICO
				if (respuestaUsuarioBatalla == 1) {
					precisionBasicoActual = random.nextInt(99) + 1 + clima.efectoClima();
					danoConHora = danoSubidoB + hora.efectoHoraDelDia();
					//CRÍTICO
					if (heroe.getPrecisionBasico() - precisionBasicoActual >= 80) {
						System.out.println("·Usaste " + heroe.getNombreBasico() + " y le has hecho un daño crítico de |" + danoConHora + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - danoConHora;
					}
					//NORMAL
					if (heroe.getPrecisionBasico() - precisionBasicoActual >= 20 && heroe.getPrecisionBasico() - precisionBasicoActual < 80) {
						System.out.println("·Usaste " + heroe.getNombreBasico() + " y le has hecho un daño de |" + danoConHora/2 + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - (danoConHora/2);
					} 
					//FALLIDO
					else{
						System.out.println("·Usaste " + heroe.getNombreBasico() + " pero fallaste el ataque.");
					}
				}
				//FUERTE
				if (respuestaUsuarioBatalla == 2) {
					precisionFuerteActual = random.nextInt(99) + 1 + clima.efectoClima();
					danoConHora = danoSubidoF + hora.efectoHoraDelDia();
					//CRÍTICO
					if (heroe.getPrecisionFuerte() - precisionFuerteActual >= 80) {
						System.out.println("·Usaste " + heroe.getNombreFuerte() + " y le has hecho un daño crítico de |" + danoConHora + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - danoConHora;
					}
					//NORMAL
					if (heroe.getPrecisionFuerte() - precisionBasicoActual >= 20 && heroe.getPrecisionFuerte() - precisionFuerteActual < 80) {
						System.out.println("·Usaste " + heroe.getNombreFuerte() + " y le has hecho un daño de |" + danoConHora/2 + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - (danoConHora/2);
					} 
					//FALLIDO
					else{
						System.out.println("·Usaste " + heroe.getNombreFuerte() + " pero fallaste el ataque.");
					}
				}
				//HABILIDAD
				if (respuestaUsuarioBatalla == 3) {
					//ÁNUKET
					if (heroe.getOpcionPersonaje() == 1) {
						ataqueBasicoEnemigoActual = ataqueBasicoEnemigoActual - heroe.getDatosHabilidad();
						ataqueFuerteEnemigoActual = ataqueFuerteEnemigoActual - heroe.getDatosHabilidad();
						System.out.println("·Usaste " + heroe.getNombreHabilidad() + " e invocas un escudo que reduce |" + heroe.getDatosHabilidad() + "| puntos de daño.");
					}
					//BASTET
					if (heroe.getOpcionPersonaje() == 2) {
						heroe.setVida(heroe.getVida() + heroe.getDatosHabilidad());
						if (heroe.getVida() > heroe.getVidaMax()) {
							heroe.setVida(heroe.getVidaMax());
							System.out.println("·Usaste " + heroe.getNombreHabilidad() + " y te curas |" + heroe.getDatosHabilidad() + "| puntos de vida.");
						}
					}
					//GERALD
					if (heroe.getOpcionPersonaje() == 3) {
						danoSubidoB = danoSubidoB + heroe.getDatosHabilidad();
						danoSubidoF = danoSubidoF + heroe.getDatosHabilidad();
						System.out.println("·Usaste " + heroe.getNombreHabilidad() + " y te subes el ataque |" + heroe.getDatosHabilidad() + "| puntos de daño.");
					}
				}
				if (vidaEnemigoActual <= 0) {
					vidaEnemigoActual = 0;
				}
				System.out.println("\nA ~"+ enemigos.getEnemigos().get(batallaActual) + "~ le quedan |" + vidaEnemigoActual + "| puntos de vida");
				//COMPAÑERO
				if (vidaEnemigoActual > 0) {
					ataqueNpcAleatorio = random.nextInt(2);
					System.out.println("\n·" + npc.getCompanero() + " dice:");
					//UNO
					if (ataqueNpcAleatorio == 0) {
						System.out.println(npc.getFrase1_companero() + " y le hace |" + npc.getAyuda1_companero() + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - npc.getAyuda1_companero();
					}
					//DOS
					if (ataqueNpcAleatorio == 1) {
						System.out.println(npc.getFrase2_companero() + " y le hace |" + npc.getAyuda2_companero() + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - npc.getAyuda2_companero();
					}
					//TRES
					if (ataqueNpcAleatorio == 2) {
						System.out.println(npc.getFrase3_companero() + " y le hace |" + npc.getAyuda3_companero() + "| puntos de daño a ~" + enemigos.getEnemigos().get(batallaActual) + "~.");
						vidaEnemigoActual = vidaEnemigoActual - npc.getAyuda3_companero();
					}
					if (vidaEnemigoActual <= 0) {
						vidaEnemigoActual = 0;
					}
					System.out.println("\nA ~"+ enemigos.getEnemigos().get(batallaActual) + "~ le quedan |" + vidaEnemigoActual + "| puntos de vida.\n");
				}
				//ENEMIGO BÁSICO
				if (vidaEnemigoActual > 0) {
					ataqueEnemigoAleatorio = random.nextInt(2);
					precisionBasicoActual = random.nextInt(99) + 1;
					if (ataqueEnemigoAleatorio == 0) {
						//CRÍTICO
						if (precisionBasicoActual >= 80) {
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + "~ te ataca con "+ enemigos.getNombreBasico().get(batallaActual) + "\n(" + enemigos.getDescripcionBasico().get(batallaActual) + ") y te hace un crítico de |" + ataqueBasicoEnemigoActual + "| puntos de daño.");
							heroe.setVida(heroe.getVida() - ataqueBasicoEnemigoActual);
							System.out.println("\nTe quedan |" + heroe.getVida() + "| puntos de vida.");	
						}
						//NORMAL
						else if (precisionBasicoActual >= 20 && precisionBasicoActual < 80) {
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + "~ te ataca con "+ enemigos.getNombreBasico().get(batallaActual) + "\n(" + enemigos.getDescripcionBasico().get(batallaActual) + ") y te hace |" + ataqueBasicoEnemigoActual/2 + "| puntos de daño.");
							heroe.setVida(heroe.getVida() - ataqueBasicoEnemigoActual/2);
							System.out.println("\nTe quedan |" + heroe.getVida() + "| puntos de vida.");	
						} 
						//FALLIDO
						else if (precisionBasicoActual < 20) {
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + "~ usó "  + enemigos.getNombreBasico().get(batallaActual) + " pero falló el ataque.");
						}
					}
					//ENEMIGO FUERTE
					 if (ataqueEnemigoAleatorio == 1) {
						//CRÍTICO
						if (precisionBasicoActual >= 80) {
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + "~ te ataca con " + enemigos.getNombreFuerte().get(batallaActual) + "\n(" + enemigos.getDescripcionFuerte().get(batallaActual) + ") y te hace un crítico de |" + ataqueFuerteEnemigoActual + "| puntos de daño.");
							heroe.setVida(heroe.getVida() - ataqueFuerteEnemigoActual);
							System.out.println("\nTe quedan |" + heroe.getVida() + "| puntos de vida.");	
						}
						//NORMAL
						else if (precisionBasicoActual >= 20 && precisionBasicoActual < 80) {
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + "~ te ataca con " + enemigos.getNombreFuerte().get(batallaActual) + "\n(" + enemigos.getDescripcionFuerte().get(batallaActual) + ") y te hace |" + ataqueFuerteEnemigoActual/2 + "| puntos de daño.");
							heroe.setVida(heroe.getVida() - ataqueFuerteEnemigoActual/2);
							System.out.println("\nTe quedan |" + heroe.getVida() + "| puntos de vida.");	
						}
						//FALLIDO
						else if (precisionBasicoActual < 20) {
							System.out.println("~" +enemigos.getEnemigos().get(batallaActual) + "~ usó " + enemigos.getNombreFuerte().get(batallaActual) + " pero falló el ataque.");
						}
					}
					 //ENEMIGO HABILIDAD
					if (ataqueEnemigoAleatorio == 2) {
						//DAÑO
						if (enemigos.getDatosHabilidad().get(batallaActual) > 3) {
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + " te ataca con "+ enemigos.getNombreHabilidad().get(batallaActual) + "\n(" + enemigos.getDescripcionHabilidad().get(batallaActual) + ") y te hace |"+ enemigos.getDatosHabilidad().get(batallaActual) + "| puntos de daño.");
							heroe.setVida(heroe.getVida() - enemigos.getDatosHabilidad().get(batallaActual));
							System.out.println("\nTe quedan |" + heroe.getVida() + "| puntos de vida.");	
						}
						//CAMBIO TERRENO
						else if (enemigos.getDatosHabilidad().get(batallaActual) == 1) {
							terreno.cambioTerreno();
							System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + " usa " + enemigos.getNombreHabilidad().get(batallaActual) + "\n(" + enemigos.getDescripcionHabilidad().get(batallaActual) + ")");
							System.out.println("El terreno ha cambiado");
						}
						//CAMBIO TERRENO
						//CAMBIO CLIMA
						else if (enemigos.getDatosHabilidad().get(batallaActual) == 2) {
                            terreno.cambioTerreno();
                            clima.cambioClima();
                            System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + " usa " + enemigos.getNombreHabilidad().get(batallaActual) + "\n(" + enemigos.getDescripcionHabilidad().get(batallaActual) + ")");
							System.out.println("El terreno ha cambiado");
                            System.out.println("El clima ha cambiado");
						}
						//CAMBIO TERRENO
						//CAMBIO CLIMA
						//CAMBIO HORA
                        else if (enemigos.getDatosHabilidad().get(batallaActual) == 3) {
                            terreno.cambioTerreno();
                            clima.cambioClima();
                            hora.cambioHora();
                            System.out.println("~" + enemigos.getEnemigos().get(batallaActual) + " usa " + enemigos.getNombreHabilidad().get(batallaActual) + "\n(" + enemigos.getDescripcionHabilidad().get(batallaActual) + ")");
							System.out.println("El terreno ha cambiado");
							System.out.println("El clima ha cambiado");
							System.out.println("La hora ha cambiado");
                        }
					}
				}
	}
			//SIGUIENTE ESCENARIO
            clima.setFilaDeClimaActual(clima.getFilaDeClimaActual() + 1);
            terreno.setFilaDeTerrenoActual(terreno.getFilaDeTerrenoActual() + 1);
            hora.setFilaDeHoraActual(hora.getFilaDeHoraActual() + 1);
			batallaActual++;
	}
	//OTROS MÉTODOS
	
	public void Puzzlecambio1() {
        clima.setFilaDeClimaActual(clima.getFilaDeClimaActual() + 1);
        terreno.setFilaDeTerrenoActual(terreno.getFilaDeTerrenoActual() + 1);
        hora.setFilaDeHoraActual(hora.getFilaDeHoraActual() + 1);
        batallaActual++;
	}
	
	public void Puzzlecambio2() {
        clima.setFilaDeClimaActual(clima.getFilaDeClimaActual() + 1);
        terreno.setFilaDeTerrenoActual(terreno.getFilaDeTerrenoActual() + 1);
        hora.setFilaDeHoraActual(hora.getFilaDeHoraActual() + 1);
	}
}
