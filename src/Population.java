//Clase population, es la principal donde se guarda el array de personajes de todo tipo, metodos para añadir y borrar personajes.
import java.util.ArrayList;

import Personaje.Personaje;

public class Population {

		private ArrayList<Personaje> personajes;
		int total_produccion;
		
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
