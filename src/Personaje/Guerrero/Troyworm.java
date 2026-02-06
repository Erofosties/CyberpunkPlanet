package Personaje.Guerrero;

import java.util.Random;

public class Troyworm extends Guerrero{
	private static String selectNombre() {		
		String nombres[]= new String[]{"Gusano", "Backdoor", "Spaguetti", "Polñopo"};
		Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
	}
        
     public Troyworm() {
    		super(selectNombre(),80,4,7,3,3);
    		

	}
}
