package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Personaje;

public class PruebasPersonaje {
	
	static Personaje personaje;
	static Personaje enemigo;
	
@BeforeEach
	void crearPersonaje() {
		personaje = new PersonajePruebas("Heroe", 100, 20, 5);
		enemigo = new PersonajePruebas("Enemigo", 100, 10, 3);
	}

@Test
	void testGettersSetters() {
	    personaje.setNombre("Nombre");
	    personaje.setVida(50);
	    personaje.setVidaInicial(100);
	    personaje.setAtaque(30);
	    personaje.setDefensa(10);
	
	    assertEquals("Nombre", personaje.getNombre());
	    assertEquals(50, personaje.getVida());
	    assertEquals(100, personaje.getVidaInicial());
	    assertEquals(30, personaje.getAtaque());
	    assertEquals(10, personaje.getDefensa());
	}

@Test
	void testSetVidaNoNegativa() {
	    personaje.setVida(-10);
	    assertEquals(0, personaje.getVida());
	}

@Test
	void testAtacar() {
	    personaje.atacar(enemigo);
	    assertEquals(83, enemigo.getVida());
	}

@Test
	void resetear() {
	    personaje.resetear();
	    assertEquals(100, personaje.getVida());
	}

@Test
	void muerto() {
	    personaje.setVida(0);
	    assertTrue(personaje.muerto());
	}



}
