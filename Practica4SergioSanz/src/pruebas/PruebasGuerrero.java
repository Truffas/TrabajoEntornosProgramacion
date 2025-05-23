package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Guerrero;

public class PruebasGuerrero {
	
	Guerrero guerrero;


@BeforeEach
	void crearGuerrero() {
		guerrero = new Guerrero("Guerrero",100);
	}

@Test
	void curar() {
	    guerrero.setVida(50);
	    guerrero.curar();
	    assertEquals(100, guerrero.getVida());
	}

@Test
	void curarSinPociones() {
	    guerrero.setVida(10);
	    guerrero.curar(); 
	    guerrero.setVida(20);
	    guerrero.curar();
	    guerrero.setVida(5);
	    guerrero.curar(); //No debería curar, hemos gastado las 2 pociones.	
	    assertEquals(5, guerrero.getVida()); 
	}

@Test
	void resetear() {
	    guerrero.setVida(40);
	    guerrero.curar();
	    guerrero.resetear();	
	    assertEquals(100, guerrero.getVida());
	    assertEquals(2, guerrero.getPociones());
	}

}
