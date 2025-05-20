package clases;

public class Mago extends Personaje implements Jugable{
    private static final int ATAQUE_MAGIA = 20;
    private static final int ATAQUE_SIN_MAGIA = 5;
    private static final int DEFENSA = 5;
    private static final int MAGIA = 10;

    private int magia;

    public Mago(String nombre, int vida) {
        super(nombre, vida, ATAQUE_MAGIA, DEFENSA);
        this.magia = MAGIA;
    }

    @Override
    public void atacar(Personaje otro) {
        super.atacar(otro);
        magia--;
        magia = magia <= 0 ? 0 : magia;
        if (magia == 0) {
            this.setAtaque(ATAQUE_SIN_MAGIA);
        }
    }

    @Override
    public void curar() {
        if (magia > 0) {
            System.out.println("SI ME ESTOY CURANDO");
    }}

    @Override
    public void resetear() {
        super.resetear();
        this.magia = MAGIA;
        this.setAtaque(ATAQUE_MAGIA);
    }

    @Override
    public String toString() {
        return super.toString() + "; Magia: " + magia;
    }
}

