package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import clases.Mago;

public class PruebasMago {

	Mago mago;

	@BeforeEach
	void crearMago() {
		mago = new Mago("Mago", 100);
	}

	@Test
	void curar() {
		mago.setVida(80);
		mago.curar();
		assertEquals(100, mago.getVida());
	}

	@Test
	void curarSinSuperarVidaInicial() {
		mago.setVida(70);
		mago.curar();
		assertEquals(90, mago.getVida());
	}

	@Test
	void curarSinMagia() {
		mago.setVida(50);
		for (int i = 0; i < 10; i++) { // Agotamos la magia.
			mago.curar();
		}

		mago.setVida(90);
		mago.curar();
		assertEquals(90, mago.getVida());
	}

	@Test
	void resetear() {
		mago.setVida(40);
		for (int i = 0; i < 5; i++) {
			mago.curar();
		}
		mago.resetear();
		assertEquals(100, mago.getVida());
		assertEquals(20, mago.getAtaque());
	}

	@Test
	void atacarSinMagia() {
		Mago otro = new Mago("Mago2", 100);

		for (int i = 0; i < 10; i++) {
			mago.atacar(otro);
		}
		assertEquals(5, mago.getAtaque());
	}
}