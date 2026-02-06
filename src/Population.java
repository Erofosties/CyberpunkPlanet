/*consultar la productividad de la población

		aplicar decisiones que afecten a la felicidad

		evitar valores fuera de rango
		getProductivity()
👉 devuelve un valor numérico que dependa de total y happiness

increasePopulation(int amount)

decreaseHappiness(int amount)

increaseHappiness(int amount)
La felicidad nunca puede ser < 0 ni > 100

La población nunca puede ser negativa*/
import java.util.ArrayList;

import Personaje.Personaje;

public class Population {

		private ArrayList<Personaje> personajes;
		int total_produccion;
		
		//Constructor por defecto
		public Population() {
			personajes = new ArrayList<>();
		}
		
		//Añadir pjs
		public void addPjs(Personaje p)
		{
			personajes.add(p);
			updateStats();
		}
		//Eliminar pjs
		public void removePjs(Personaje p) {
			personajes.remove(p);
			if (personajes.isEmpty()) {
				System.out.println("Todos los pjs han muerto.");
			}
			updateStats();
		}
		
		public ArrayList<Personaje> getPersonajes() {
		    return personajes;
		}

		
		public void modifyProduccionTotal(int mod) {
			total_produccion += mod;
	    }
		
		//gets total productivity
		/*public int getProductivity() {
		    return (int)Math.round(total_produccion / (double) personajes.size());
		}*/
				
		private void updateStats() {
	        int sumaProduccion = 0;
	        for(Personaje p : personajes) {
	            sumaProduccion += p.getProduccion();
	        }
	        total_produccion = sumaProduccion;	    
	        }
		
		public void showStatus() {
	        System.out.println("Población total: " + personajes.size() + " personajes");
	        System.out.println("Producción total: " + total_produccion);
	        System.out.println("==============================");
	    }
}
