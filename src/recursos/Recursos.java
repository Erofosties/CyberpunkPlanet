package recursos;

public class Recursos {
	 // METAL
    private int Neocromo;// Ultraligero y conductor. Ideal para implantes neuronales, filos de armas rápidas y placas internas de naves.
    private int Umbrium;// Metal oscuro que absorbe energía y señales. Muy usado en blindaje, armas sigilosas y sistemas de ocultación.
    private int Syntherium;// Aleación corporativa autorreparable. Básico para reparaciones rápidas de naves y prótesis de alta gama.
    private int Hexalium;//Extremadamente resistente al calor y a la radiación. Perfecto para cañones, reactores y estructuras externas.
    private int Voidium;//Rarísimo y carísimo. Inestable pero brutal: potencia armas experimentales y mejora implantes a costa de riesgos.

    // COMIDA
    private int Kromafruta;//Planta modificada que crece bajo luz artificial. Dulce metálico. Raciones energéticas, estimulantes suaves.
    private int Algacarne;//Masa proteica cultivada a partir de algas y células animales. Carne sintética, pienso animal, emergencia en naves.
    private int Neurotrigo;//Cereal bio-hackeado que mejora la concentración. Usos: pan, fideos, alcohol barato para runners.
    private int Ratax;//Animal pequeño criado en granjas verticales. Crece rápido y come basura orgánica. Usos: carne, cuero barato, implantes de prueba.
    private int FlorSomnio;//Planta nocturna que libera compuestos sedantes.Usos: infusiones, anestesia natural, drogas legales.

    // MEDICINAS
    private int Reflexa;//buff combate
    private int Nanocura;//cura con nanobots programados
    private int Somnex;//fuerza el criosueño

    private int ptosExploracio;
	public enum ResourceType {
	    NEOCROMO,UMBRIUM,SYNTHERIUM,HEXALIUM,VOIDIUM,KROMAFRUTA,ALGACARNE,NEUROTRIGO,
	    RATAX,FLORSOMNIO,REFLEXA,NANOCURA,SOMNEX,EXPLORACION}
	
	//Constructor
	public Recursos() {
		super();
		
	}
	public void add(ResourceType type, int amount) {
	    switch (type) {
	        case NEOCROMO -> Neocromo += amount;
	        case UMBRIUM -> Umbrium += amount;
	        case SYNTHERIUM -> Syntherium += amount;
	        case HEXALIUM -> Hexalium += amount;
	        case VOIDIUM -> Voidium += amount;

	        case KROMAFRUTA -> Kromafruta += amount;
	        case ALGACARNE -> Algacarne += amount;
	        case NEUROTRIGO -> Neurotrigo += amount;
	        case RATAX -> Ratax += amount;
	        case FLORSOMNIO -> FlorSomnio += amount;

	        case REFLEXA -> Reflexa += amount;
	        case NANOCURA -> Nanocura += amount;
	        case SOMNEX -> Somnex += amount;

	        case EXPLORACION -> ptosExploracio += amount;
	    }
	}
	public void verRecursos() {

	    System.out.println("\n--- METALES ---");
	    System.out.println("Neocromo: " + Neocromo);
	    System.out.println("Umbrium: " + Umbrium);
	    System.out.println("Syntherium: " + Syntherium);
	    System.out.println("Hexalium: " + Hexalium);
	    System.out.println("Voidium: " + Voidium);

	    System.out.println("\n--- COMIDA ---");
	    System.out.println("Kromafruta: " + Kromafruta);
	    System.out.println("Algacarne: " + Algacarne);
	    System.out.println("Neurotrigo: " + Neurotrigo);
	    System.out.println("Ratax: " + Ratax);
	    System.out.println("FlorSomnio: " + FlorSomnio);

	    System.out.println("\n--- MEDICINAS ---");
	    System.out.println("Reflexa: " + Reflexa);
	    System.out.println("Nanocura: " + Nanocura);
	    System.out.println("Somnex: " + Somnex);

	    System.out.println("\n--- EXPLORACIÓN ---");
	    System.out.println("Puntos de exploración: " + ptosExploracio);
	}
	


	
}
