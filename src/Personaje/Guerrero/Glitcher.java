package Personaje.Guerrero;

import java.util.Random;

public class Glitcher extends Guerrero{
	
	private static String selectNombre() {		
		String nombres[]= new String[]{"HackerMan", "SoyProgramador", "HacheTemele"};
		Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
	}
        
     public Glitcher() {
    		super(selectNombre(),100,1,3,3,8);
    		

	}
}
