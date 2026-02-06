/*Se desea representar a los personajes que pueden combatir.

Crea una clase Guerrero que herede de Personaje.

Un guerrero debe tener:

un valor de combate

un método que devuelva su poder de combate

Implementa un constructor adecuado y los métodos necesarios.*/
package Personaje.Guerrero;

import Personaje.Personaje;

public abstract class Guerrero extends Personaje{
	//Atributos
	
	protected int fuerza;
	protected int destreza;
	protected int resistencia;
	protected int hackeo;
    protected boolean disponible;
	
	//Constructor
	public Guerrero (String nombre, int vida, int fuerza, int destreza, int resistencia, int hackeo) {
		super(nombre, vida);
        this.fuerza = Math.max(fuerza, 0);
        this.resistencia = Math.max(resistencia, 0);
        this.destreza = Math.max(destreza, 0);
        this.disponible = true;
        this.hackeo = Math.max(hackeo,0);
		
	}
	@Override
    public int getProduccion() {return 0;}
	public int getFuerza() {return fuerza;} 
	public int getResistencia() {return resistencia;}
	public int getDestreza() {return destreza;}
	
	public void setFuerza(int modFuerza) {this.fuerza+=modFuerza;}
	public void setResistencia(int modResistencia) {this.resistencia+=modResistencia;}
	public void setDestreza(int modDestreza) {this.destreza+=modDestreza;}
	
	public void setDisponible(boolean disponible) {this.disponible = disponible;}
	
	public boolean isDisponible() {return disponible;}
}
