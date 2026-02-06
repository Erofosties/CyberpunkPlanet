package Personaje.Guerrero;
import java.util.Random;

public class Tanker extends Guerrero{

	private static String selectNombre() {		
		String nombres[]= new String[]{"MuroDeAcero", "Blindado", "Coloso", "Fortix", "Titanio", 
		        "CuerpoEskombro", "Bastión", "Paredura", "EskudoLetal", "ArmaduraX", 
		        "IronShield", "HeavyCore", "SteelGuard", "Fatitán", "Wallz"};
		Random random = new Random();
	    	return nombres[random.nextInt(nombres.length)];
	        
		}
		
	public Tanker() {
		super(selectNombre(),250,4,3,5, 0);
			
		}

}
