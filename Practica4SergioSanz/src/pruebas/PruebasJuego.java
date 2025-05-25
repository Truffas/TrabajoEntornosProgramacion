package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Enemigo;
import clases.Guerrero;
import clases.Juego;
import clases.Mago;
import clases.Personaje;

public class PruebasJuego {

Juego juego;

@BeforeEach
	void crearJuego() {
		juego = new Juego();
	}

@Test
	void crearNuevoGuerrero() {
		juego.nuevoGuerrero("Guerrero");
		Personaje jugador = juego.getJugador();	
		assertTrue(jugador instanceof Guerrero);
		assertEquals("Guerrero", jugador.getNombre());
		assertTrue(jugador.getVida() >= 100 && jugador.getVida() <= 200);
	}

@Test
	void crearNuevoMago() {
		juego.nuevoMago("Mago");
		Personaje jugador = juego.getJugador();	
		assertTrue(jugador instanceof Mago);
		assertEquals("Mago", jugador.getNombre());
		assertTrue(jugador.getVida() >= 50 && jugador.getVida() <= 150);
	}

@Test
	void iniciarJuego() {
		juego.setnRondas(3);
		juego.iniciarJuego();
		assertEquals(3, juego.getnRondas());
		assertEquals(0, juego.getRonda());
		assertFalse(juego.finalJuego());
	}

@Test
	void getSiguiente() {
	    juego.setnRondas(1);
	    juego.iniciarJuego();
	    Enemigo e = juego.getSiguiente();
	    assertTrue(e instanceof Enemigo);
	}


@Test
	void terminarRonda() {
	    juego.setnRondas(1);
	    juego.iniciarJuego();	
	    Enemigo enemigo = juego.getSiguiente();
	    enemigo.setVida(0);	
	    boolean resultado = juego.terminarRonda();	
	    assertTrue(resultado);
	    assertTrue(juego.finalJuego());
	}

@Test
	void nombreAleatorio() {
	    String nombre = Juego.nombreAleatorio();
	    assertNotNull(nombre);
	    assertTrue(nombre.length() > 0);
	}

@Test
	void guardarSiEsMejor_NoSupera() {
		File archivo = new File("registroMejores/mejorPuntuacion.txt");
		try {
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("JugadorBueno");
			pw.print(3);
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		
		Juego.guardarSiEsMejor("JugadorMalo", 2);
	
		Scanner entrada = null;
		try {
			entrada = new Scanner(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String nombre = entrada.nextLine();
		int rondas = Integer.parseInt(entrada.nextLine());
		entrada.close();
	
		assertEquals("JugadorBueno", nombre);
		assertEquals(3, rondas);
	}

@Test
	void guardarSiEsMejor_SiSupera() {
		File archivo = new File("registroMejores/mejorPuntuacion.txt");
		try {
			FileWriter fw = new FileWriter(archivo);
			PrintWriter pw = new PrintWriter(fw);
			pw.println("JugadorMalo");
			pw.print(2);
			pw.close();
		} catch (IOException e) {
			System.out.println("Error al leer el archivo");
		}
		
		Juego.guardarSiEsMejor("JugadorBueno", 3);
	
		Scanner entrada = null;
		try {
			entrada = new Scanner(archivo);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String nombre = entrada.nextLine();
		int rondas = Integer.parseInt(entrada.nextLine());
		entrada.close();
	
		assertEquals("JugadorBueno", nombre);
		assertEquals(3, rondas);
	}












}