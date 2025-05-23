package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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












}