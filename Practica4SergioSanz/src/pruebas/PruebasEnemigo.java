package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Enemigo;

public class PruebasEnemigo {

	static Enemigo enemigo;
	
@BeforeEach
	void crearCuenta() {
		enemigo = new Enemigo();
}
	
@Test
    void iniciarEnemigo() {
        String nombre = "Orco";
        enemigo.iniciarEnemigo(nombre);

        int vida = enemigo.getVida();
        int vidaInicial = enemigo.getVidaInicial();
        int ataque = enemigo.getAtaque();
        int defensa = enemigo.getDefensa();

        assertTrue(vida >= 20 && vida <= 100);
        assertEquals(vida, vidaInicial);
        assertTrue(ataque >= 2 && ataque <= 15);
        assertTrue(defensa >= 1 && defensa <= 3);
    }
	

}
