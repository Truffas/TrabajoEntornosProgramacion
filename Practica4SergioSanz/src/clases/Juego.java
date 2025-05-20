package clases;

import java.util.ArrayList;
import java.util.Random;

public class Juego {
    private static final String[] nombresEnemigos = {"Seath", "Nito", "Cuatro Reyes", "Lecho del Caos", "Gwyn"};
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
}