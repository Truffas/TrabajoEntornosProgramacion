package clases;

public abstract class Personaje {
    private String nombre;
    private int vida;
    private int vidaInicial;
    private int ataque;
    private int defensa;

    public Personaje() {}

    public Personaje(String nombre, int vida, int ataque, int defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaInicial = vida;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida < 0 ? 0 : vida;
    }

    public int getVidaInicial() {
        return vidaInicial;
    }

    public void setVidaInicial(int vidaInicial) {
        this.vidaInicial = vidaInicial;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void atacar(Personaje otro) {
    	int danio = (this.ataque - otro.getDefensa()) < 0 ? 0 : (this.ataque - otro.getDefensa());
    	otro.setVida(otro.getVida() - danio);
    }

    public void resetear() {
        this.vida = this.vidaInicial;
    }

    public boolean muerto() {
        return this.vida <= 0;
    }

    @Override
    public String toString() {
        return nombre + "=> Vida: " + vida + "/" + vidaInicial;
    }
}