package Personaje;



public abstract class Personaje {

    protected String nombre;
    protected int vida;
    

    public Personaje(String name, int vida) {
        this.vida = Math.max(vida, 0);
        this.nombre = name;
    }

    public abstract int getProduccion();

    public String getNombre() {
        return nombre;
    }
    public int getVida() {
        return vida;
    }
    
}