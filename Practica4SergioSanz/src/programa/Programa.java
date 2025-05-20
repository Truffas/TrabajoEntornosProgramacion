package programa;

import clases.*;

import java.util.Scanner;

public class Programa {
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		String respuesta;

		do {
			Juego juego = new Juego();

			System.out.println("Bienvenido al juego:");
			System.out.print("¿Cuántas rondas quieres jugar? ");
			int rondas = entrada.nextInt();
			entrada.nextLine();
			juego.setnRondas(rondas);

			System.out.print("Introduce tu nombre: ");
			String nombre = entrada.nextLine();

			System.out.println("Elige tu clase:\n1. Mago\n2. Guerrero");
			System.out.print("Elige (1, 2): ");
			int eleccion = entrada.nextInt();
			entrada.nextLine();

			if (eleccion == 1) {
				juego.nuevoMago(nombre);
			} else {
				juego.nuevoGuerrero(nombre);
			}

			juego.iniciarJuego();

			while (!juego.finalJuego() && !juego.getJugador().muerto()) {
				Enemigo enemigo = juego.getSiguiente();

				System.out.println("Ronda: " + (juego.getRonda() + 1) + "/" + rondas);
				System.out.println("Estás luchando contra: " + enemigo);
				System.out.println("Eres: " + juego.getJugador());

				System.out.println("Acciones:\n1. Atacar\n2. Curar");
				System.out.print("Elige: ");
				int accion = entrada.nextInt();
				entrada.nextLine();

				if (accion == 1) {
					System.out.println(juego.getJugador().getNombre() + " ataca a " + enemigo.getNombre());
					juego.getJugador().atacar(enemigo);
				} else if (accion == 2) {
					System.out.println(juego.getJugador().getNombre() + " se cura");
					if(juego.getJugador() instanceof Mago) {
						((Mago) juego.getJugador()).curar();				
					}
					if(juego.getJugador() instanceof Guerrero) {
						((Guerrero) juego.getJugador()).curar();				
					}
					
				}

				if (!enemigo.muerto()) {
					System.out.println(enemigo.getNombre() + " ataca a " + juego.getJugador().getNombre());
					enemigo.atacar(juego.getJugador());
				}

				if (juego.terminarRonda()) {
					System.out.println("Enemigo vencido!!\n");
				}

				System.out.println();
			}

			if (juego.getJugador().muerto()) {
				System.out.println("Has perdido");
			} else {
				System.out.println("Has ganado!");
			}

			System.out.print("¿Volver a jugar? (s/n): ");
			respuesta = entrada.nextLine();

		} while (respuesta.equalsIgnoreCase("s"));

		System.out.println("Gracias por jugar!");
		entrada.close();
	}
}