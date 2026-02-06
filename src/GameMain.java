import Personaje.Civil.Trabajador;
import Personaje.*;
import Personaje.Guerrero.*;
import java.util.ArrayList;


public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Bienvenido a CyberpunkPlanet. Se creará una colonia para que comiences a jugar.");
		Population colonia = new Population(6);
		
		colonia.addPjs(new Trabajador("Neo", 50, Trabajador.Profession.GRINDER));
        colonia.addPjs(new Trabajador("Ivy", 50, Trabajador.Profession.AGROTECH));
        colonia.addPjs(new Trabajador("Hex", 50, Trabajador.Profession.NEONIST));
		
        Runner run1 = new Runner();
        colonia.addPjs(run1);
        
        // 3️⃣ Simular trabajo del día
        int puntosExploracion = 0;
        int tiempoExploracion = 8; // horas

        for (Personaje p : new ArrayList<>(colonia.getPersonajes())) {
            if (p instanceof Runner r && r.isDisponible()) {
                puntosExploracion += r.explorar(tiempoExploracion);
            }
        }

        // 4️⃣ Mostrar resultados
        
        System.out.println("===== FIN DEL DÍA =====");
        colonia.showStatus();
        System.out.println("Puntos de exploración obtenidos: " + puntosExploracion);
	}
}
