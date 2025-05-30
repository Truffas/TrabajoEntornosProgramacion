package clases;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Juego {
	private static final String[] nombresEnemigos = { "Seath", "Nito", "Cuatro Reyes", "Lecho del Caos", "Gwyn" };
	private ArrayList<Enemigo> enemigos;
	private Personaje jugador;
	private int nRondas;
	private int ronda;

	public Juego() {
		enemigos = new ArrayList<>();
	}

	public static String nombreAleatorio() {
		int n = (int) (Math.random() * nombresEnemigos.length);
		return nombresEnemigos[n];
	}

	public void iniciarJuego() {
		enemigos.clear();
		for (int i = 0; i < nRondas; i++) {
			Enemigo e = new Enemigo();
			e.iniciarEnemigo(nombreAleatorio());
			enemigos.add(e);
		}
		ronda = 0;
	}

	public Enemigo getSiguiente() {
		return enemigos.get(0);
	}

	public boolean terminarRonda() {
		if (enemigos.get(0).muerto()) {
			enemigos.remove(0);
			ronda++;
			return true;
		}
		return false;
	}

	public void nuevoGuerrero(String nombre) {
		int vida = (int) (Math.random() * 101) + 100;
		jugador = new Guerrero(nombre, vida);
	}

	public void nuevoMago(String nombre) {
		int vida = (int) (Math.random() * 101) + 50;
		jugador = new Mago(nombre, vida);
	}

	public boolean finalJuego() {
		return enemigos.isEmpty();
	}

	public Personaje getJugador() {
		return jugador;
	}

	public void setJugador(Personaje jugador) {
		this.jugador = jugador;
	}

	public int getnRondas() {
		return nRondas;
	}

	public void setnRondas(int nRondas) {
		this.nRondas = nRondas;
	}

	public int getRonda() {
		return ronda;
	}

	public void setRonda(int ronda) {
		this.ronda = ronda;
	}

	public static void mostrarMejorPuntuacion() {
		File archivo = new File("registroMejores/mejorPuntuacion.txt");

		if (archivo.exists()) {
			if (archivo.length() == 0) {
				System.out.println("Todavía no hay ninguna puntuación guardada");
			} else {
				try {
					Scanner entradaArchivo = new Scanner(archivo);
					String nombre = entradaArchivo.nextLine();
					int nRondas = Integer.parseInt(entradaArchivo.nextLine());
					System.out.println("El mejor jugador es: " + nombre + ", con un total de: " + nRondas + " rondas");
					entradaArchivo.close();
				} catch (Exception e) {
					System.err.println("Error al intentar leer el archivo");
				}
			}
		} else {
			System.out.println("Todavía no hay ninguna puntuación guardada");
		}
	}

	public static void guardarSiEsMejor(String nombre, int nRondas) {

		File archivo = new File("registroMejores/mejorPuntuacion.txt");
		int mejorRonda = 0;

		if (archivo.exists() && archivo.length() > 0) {
			try {
				Scanner entradaArchivo = new Scanner(archivo);
				entradaArchivo.nextLine();
				mejorRonda = Integer.parseInt(entradaArchivo.nextLine());
				entradaArchivo.close();
			} catch (Exception e) {
				System.err.println("Error al leer la puntuación guardada");
			}
		}

		if (nRondas > mejorRonda) {
			try {
				FileWriter fw = new FileWriter(archivo);
				PrintWriter pw = new PrintWriter(fw);
				pw.println(nombre);
				pw.print(nRondas);
				pw.close();
				System.out.println("¡Nuevo récord guardado!");
			} catch (Exception e) {
				System.err.println("Error al guardar la puntuación.");
			}
		} else {
			System.out.println("No has superado la mejor puntuación.");
		}

	}

}