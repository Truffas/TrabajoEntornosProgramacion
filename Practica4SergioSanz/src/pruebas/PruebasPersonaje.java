package pruebas;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;

import clases.Personaje;

public class PruebasPersonaje {
	
	static Personaje personaje;
	
@BeforeAll
	static void crearPersonaje() {
		personaje = new PersonajePruebas("Heroe", 100, 20, 5);
}



}
