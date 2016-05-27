package it.unibs.ing.fp.tamazoo;

import it.unibs.ing.fp.tamagotchi.Tamagotchi;

/**
 * <h1> Class TamaTriste </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * @version v1.0
 * @since 2016-05-17
 */

public class TamaTriste extends Tamagotchi{
	
	/**
	 * Constructor.
	 * @param nome - The name of Object Tamagotchi
	 * @param tipo - The type of Tamagotchi
	 * @param sazietà - The level of sazietà
	 */
	public TamaTriste(String nome, String tipo, double sazietà) {
		super(nome, tipo, MIN_SAZ, sazietà);
	}
	
	/**
	 * Give a number of carezze.
	 * @param numCarezze - The number of carezze to give to the Object Tamagotchi
	 */
	public void giveCarezze(int numCarezze) {
		sazietà = Math.max(MIN_SAZ, sazietà - numCarezze * DECREASE_SAZIETA);
	}
	
	/**
	 * Give a number of biscotti.
	 * @param numBiscotti - The number of biscotti to give to the Object Tamagotchi
	 */
	public void giveBiscotti(int numBiscotti) {
		for(int i = 1; i <= numBiscotti; i++) sazietà = Math.min(sazietà * INCREASE_SAZIETA, MAX_SAZ);
	}
	
	//	CHECKERS
	
	public boolean isDied() {
		return (sazietà == MIN_SAZ || sazietà == MAX_SAZ);
	}
	
	public boolean isUnhappy() {
		return true;
	}
}
