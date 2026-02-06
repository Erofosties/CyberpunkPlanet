import Personaje.Civil.Trabajador;
import Personaje.*;
import Personaje.Guerrero.*;
import java.util.ArrayList;


public class GameMain {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		System.out.println("Bienvenido a CyberpunkPlanet. Se creará una colonia para que comiences a jugar.");
		Population colonia = new Population();
		
		colonia.addPjs(new Trabajador("Neo", 50, Trabajador.Profession.GRINDER));
        colonia.addPjs(new Trabajador("Ivy", 50, Trabajador.Profession.AGROTECH));
        colonia.addPjs(new Trabajador("Hex", 50, Trabajador.Profession.NEONIST));
        colonia.addPjs(new Trabajador("Hex", 50, Trabajador.Profession.FIXER));
        colonia.addPjs(new Trabajador("Hex", 50, Trabajador.Profession.TECHIES));
		
        Guerrero runner = new Guerrero(Guerrero.Tipo.RUNNER);
        colonia.addPjs(runner);
        
  
        // 3️⃣ Simular exploracion
        int puntosExploracion = 0;
        int tiempoExploracion = 0; // horas
        puntosExploracion=runner.explorar(tiempoExploracion);
        

        // 4️⃣ Mostrar resultados
        System.out.println("Tamaño de la colonia."+ colonia.getPersonajes().size());
        System.out.println("-----------------");
        System.out.println("Personajes de la colonia: Tipo - Nombre - Fuerza - Destreza - Resistencia - Hackeo - Disponibilidad");
        for (Personaje p: colonia.getPersonajes()) 
        {
        	if (p instanceof Trabajador) {
        		Trabajador trabajador = (Trabajador)p;
        		System.out.println("Trabajador - nombre: "+ trabajador.getNombre()+
        		" - Produccion: " + trabajador.getProduccion() +
        		" - Profesion: " + trabajador.getProfession());
        	}else if (p instanceof Guerrero) 
        	{
        		Guerrero guerrero = (Guerrero)p ;
        		System.out.println("Guerrero (" + guerrero.getTipo() + ") - Nombre: " + guerrero.getNombre() +
        	            " - Fuerza: " + guerrero.getFuerza() +
        	            " - Destreza: " + guerrero.getDestreza() +
        	            " - Resistencia: " + guerrero.getResistencia() +
        	            " - Hackeo: " + guerrero.getHacke() +
        	            " - Disponible: " + guerrero.getDisponible());
        	}
        
        }
	}
}
