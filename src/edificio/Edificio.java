package edificio;

import java.util.ArrayList;
import Personaje.Civil.Trabajador;
import Personaje.Civil.Trabajador.Profession;
import recursos.Recursos;
import recursos.Recursos.ResourceType;

public class Edificio {

    public enum TipoEdificio {

        // MINAS (GRINDER)
        MINA_NEOCROMO,
        MINA_UMBRIUM,
        MINA_SYNTHERIUM,
        MINA_HEXALIUM,
        MINA_VOIDIUM,

        // GRANJAS (AGROTECH)
        GRANJA_KROMAFRUTA,
        GRANJA_NEUROTRIGO,
        GRANJA_ALGACARNE,
        CRIADERO_RATAX,
        CULTIVO_FLORSOMNIO,

        // LABORATORIOS (FIXER)
        LAB_REFLEXA,
        LAB_NANOCURA,
        LAB_SOMNEX,
        
        //Energia
        PLACA_SOLAR,
        REACTOR_FUSION,
        GENERADOR_NEON
    }

    private TipoEdificio tipo;
    private ResourceType recursoProduce;
    private int nivel;
    private int capacidad;
    private int vidaEstructural;

    private ArrayList<Trabajador> trabajadores;

    public Edificio(TipoEdificio tipo) {
        this.tipo = tipo;
        this.nivel = 1;
        this.capacidad = 5;
        this.trabajadores = new ArrayList<>();
        this.recursoProduce = mapTipoToRecurso(tipo);
        this.vidaEstructural = 100;
    }

    private ResourceType mapTipoToRecurso(TipoEdificio tipo) {
        return switch (tipo) {

            // MINAS
            case MINA_NEOCROMO -> ResourceType.NEOCROMO;
            case MINA_UMBRIUM -> ResourceType.UMBRIUM;
            case MINA_SYNTHERIUM -> ResourceType.SYNTHERIUM;
            case MINA_HEXALIUM -> ResourceType.HEXALIUM;
            case MINA_VOIDIUM -> ResourceType.VOIDIUM;

            // GRANJAS
            case GRANJA_KROMAFRUTA -> ResourceType.KROMAFRUTA;
            case GRANJA_NEUROTRIGO -> ResourceType.NEUROTRIGO;
            case GRANJA_ALGACARNE -> ResourceType.ALGACARNE;
            case CRIADERO_RATAX -> ResourceType.RATAX;
            case CULTIVO_FLORSOMNIO -> ResourceType.FLORSOMNIO;

            // LABS
            case LAB_REFLEXA -> ResourceType.REFLEXA;
            case LAB_NANOCURA -> ResourceType.NANOCURA;
            case LAB_SOMNEX -> ResourceType.SOMNEX;
            //ENERGIA
            
            case PLACA_SOLAR, REACTOR_FUSION, GENERADOR_NEON -> ResourceType.ENERGIA;
        };
    }

    public boolean addTrabajador(Trabajador t) {
        if (trabajadores.size() >= capacidad) return false;
        trabajadores.add(t);
        return true;
    }

    public int producir() {
        int total = 0;
        double estado = vidaEstructural/100.0;
        total = (int) Math.round(total*estado);
        
        for (Trabajador t : trabajadores) {
            int base = t.getProduccion();

            if (profesionCorrecta(t.getProfession())) {
                total += base;
            } else {
                total += base / 2;
            }
        }

        double bonusNivel = 1 + (nivel * 0.2);
        return (int) Math.round(total * bonusNivel);
    }

    private boolean profesionCorrecta(Profession p) {
        return switch (tipo) {

            // MINAS → GRINDER
            case MINA_NEOCROMO,
                 MINA_UMBRIUM,
                 MINA_SYNTHERIUM,
                 MINA_HEXALIUM,
                 MINA_VOIDIUM -> p == Profession.GRINDER;

            // GRANJAS → AGROTECH
            case GRANJA_KROMAFRUTA,
                 GRANJA_NEUROTRIGO,
                 GRANJA_ALGACARNE,
                 CRIADERO_RATAX,
                 CULTIVO_FLORSOMNIO -> p == Profession.AGROTECH;

            // LABS → FIXER
            case LAB_REFLEXA,
                 LAB_NANOCURA,
                 LAB_SOMNEX -> p == Profession.FIXER;
                 
            //ENERGIA
            case PLACA_SOLAR, REACTOR_FUSION, GENERADOR_NEON -> p == Profession.TECHIES;
        };
    }

    public void simularDia(Recursos recursos) {
        int producido = producir();
        recursos.add(recursoProduce, producido);
    }

    public void subirNivel() {
        nivel++;
    }
    
    public void recibirDaño(int daño) {
    	vidaEstructural -= daño;
    	if(vidaEstructural <0) vidaEstructural = 0;
    }
    
    public void reparar() {
    	int techiesAsignados = 0;
    	
    	for (Trabajador t : trabajadores) {
    		if (t.getProfession() == Profession.TECHIES) {
    			techiesAsignados++;
    		}
    	}
    	vidaEstructural += techiesAsignados *5;
    	
    	if (vidaEstructural >100)vidaEstructural = 100;
    }

    public TipoEdificio getTipo() {
        return tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public int getTrabajadoresAsignados() {
        return trabajadores.size();
    }
}