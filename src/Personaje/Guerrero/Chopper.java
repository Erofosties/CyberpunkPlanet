package Personaje.Guerrero;
import java.util.Random;
public class Chopper extends Guerrero{
	
	private static String selectNombre() {		
		String nombres[]= new String[]{"Hierroto", "Oxigeno", "Mordaz", "Rajas", "Navaja",
				"Mandibula","Rompedor", "Filoafilado", "Crack", "ZeroCut","Hemorragia", "BloodSync", "Carnicero",
				"GodFist", "Vantablack"};
		Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
        
	}
	
	public Chopper() {
		super(selectNombre(),120,3,3,3,0);
		
	}
	
	
	
	

	
	
	
	
	

}
