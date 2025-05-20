package clases;

public class Guerrero extends Personaje implements Jugable{
    public static final int ATAQUE = 15;
    public static final int DEFENSA = 10;
    public static final int POCIONES = 2;

    private int pociones;

    public Guerrero(String nombre, int vida) {
        super(nombre, vida, ATAQUE, DEFENSA);
        this.pociones = POCIONES;
    }

    @Override
    public void curar() {
        if (pociones > 0) {
            this.setVida(this.getVidaInicial());
            pociones--;
        }
    }

    @Override
    public void resetear() {
        super.resetear();
        this.pociones = POCIONES;
    }

    @Override
    public String toString() {
        return super.toString() + "; Pociones: " + pociones;
    }
}
