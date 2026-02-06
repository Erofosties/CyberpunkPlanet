package Personaje.Civil;
import Personaje.Personaje;

public class Trabajador extends Personaje {
    private Profession profession;
    public enum Profession {
        GRINDER,
        AGROTECH,
        FIXER,
        NEONIST,
        TECHIES
    }
    
    public Trabajador(String nombre,int vida, Profession profession) {
        super(nombre, vida);
        this.profession = profession;
    }

    public Profession getProfession() {
    	return profession;
    }
    @Override
    public int getProduccion() {
        return switch (profession) {
            case GRINDER -> 10;
            case AGROTECH -> 5;
            case FIXER -> 3;
            case NEONIST -> 2;
            case TECHIES -> 1;
        };
    }
}