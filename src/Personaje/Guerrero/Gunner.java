package Personaje.Guerrero;

import java.util.Random;

public class Gunner extends Guerrero{

	private static String selectNombre() {		
		String nombres[]= new String[]{"DisparoFulgor", "CañonNeón", "RayoLetal", "BalazoSombra", "FusilCrítico", 
		        "PulsoCorto", "ImpactoVeloz", "TiroCertero", "ExplosiónX", "BalaFantasma", 
		        "RifleRojo", "CiberFuego", "PlasmaStrike", "BlastCore", "ZeroShot", 
		        "TormentaLetal", "NeonTrigger"};
		Random random = new Random();
        return nombres[random.nextInt(nombres.length)];
        
	}
	
	public Gunner() {
		super(selectNombre(),100,6,3,3, 0);
		
	}
}
