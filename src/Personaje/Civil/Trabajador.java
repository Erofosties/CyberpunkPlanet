package Personaje.Civil;
import Personaje.Personaje;
import recursos.Recursos.ResourceType;

public class Trabajador extends Personaje {
    private Profession profession;
    private ResourceType resource;
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
    public void assignResource (ResourceType resource) {
    	this.resource = resource;
    }
    public ResourceType getAssignedResource() {
    	return resource;
    }
    public Profession getProfession() {
    	return profession;
    }
    public boolean isAssigned() {
        return resource != null;
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

