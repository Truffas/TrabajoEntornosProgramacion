package clases;

public class Enemigo extends Personaje {

    public Enemigo() {}

    public void iniciarEnemigo(String nombre) {
        this.setNombre(nombre);
        int vida = (int) (Math.random() * 81) + 20; 
        this.setVida(vida);
        this.setVidaInicial(vida);
        this.setAtaque((int) (Math.random() * 14) + 2); 
        this.setDefensa((int) (Math.random() * 3) + 1); 
    }
}