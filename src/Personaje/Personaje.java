package Personaje;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    

    public Personaje(String nombre, int vida) {
        this.nombre = nombre;
        this.vida = Math.max(vida, 0);
        
    }

    public abstract int getProduccion() ;

    /*public int getFelicidad() {
        return felicidad;
    }*/

    public String getNombre() {
        return nombre;
    }
}