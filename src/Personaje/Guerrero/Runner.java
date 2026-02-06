package Personaje.Guerrero;
import java.util.Random;

public class Runner extends Guerrero{
	
	private int unidadesExploradas;
	private static String selectNombre() {		
		String nombres[]= new String[]{"DustRunner","GravBlink","SolarSkim","SporeHop", "RockShard","PulseFoot", "HoloTrail", "CraterDash", "WindSlip",
				"EchoStep", "HuellaCero", "RastroEstelar", "SobreReloj", "BucleInfinito", "OmegaCorredor"};
		Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
        
	}
	
	public Runner() {
		super(selectNombre(),50,1,4,1, 3);
	}
	
	public int explorar(int tiempo) {
		this.unidadesExploradas= tiempo * (destreza + (int)(Math.random() * 2));
		return unidadesExploradas;
	}

	
}
