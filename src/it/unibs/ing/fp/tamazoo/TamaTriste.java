package it.unibs.ing.fp.tamazoo;

import it.unibs.ing.fp.tamagotchi.Tamagotchi;

public class TamaTriste extends Tamagotchi{
	
	// Questo Tamagotchi è sempre infelice indipendentemente da quante carezze o biscotti riceve (però non muore mai di infelicità)
	// Il suo grado di sazietà invece varia come nel caso della specie base e muore solo se non mangia abbastanza o se mangia troppo (come nel caso base)
	public TamaTriste(String nome, String tipo, /*double affettività,*/ double sazietà) {
		super(nome, tipo, 0, sazietà);
	}
	
	/**
	 * Give a number of carezze.
	 * @param numCarezze - The number of carezze to give to the Object Tamagotchi
	 */
	public void giveCarezze(int numCarezze) {
		//	affettività = Math.min(affettività + numCarezze, MAX_SAZ);
		sazietà = Math.max(MIN_SAZ, sazietà - numCarezze * DECREASE_SAZIETA);
	}
	
	/**
	 * Give a nuber of biscotti.
	 * @param numBiscotti - The number of biscotti to give to the Object Tamagotchi
	 */
	public void giveBiscotti(int numBiscotti) {
		for(int i = 1; i <= numBiscotti; i++) sazietà = Math.min(sazietà * INCREASE_SAZIETA, MAX_SAZ);
		//	affettività = Math.max(MIN_SAZ, affettività - (numBiscotti / DECREASE_AFFETTIVITA));
	}
	
	//	CHECKERS
	
	public boolean isDied() {
		return (sazietà == MIN_SAZ || sazietà == MAX_SAZ);
	}
	
	public boolean isUnhappy() {
		return true;
	}
	
	

}
