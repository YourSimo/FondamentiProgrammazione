package it.unibs.ing.fp.tamagotchi;

/**
 * <h1> Class Tamagotchi </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-04-12
 */

public class Tamagotchi {
	
	private final static double DECREASE_AFFETTIVITA = 4;
	private final static double DECREASE_SAZIETA = 0.5;
	private final static double INCREASE_SAZIETA = 1.1;
	
	public final static int MIN_SAZ = 0;
	public final static int MAX_SAZ = 100;
	private final static int MIN_AFF = 30;
	private final static int MAX_AFF = 90;
	
	private final static String DESCRIPTION	= "Sono %s\nIl mio grado di sazietà è %1.2f\nIl mio grado di soddisfazione affettiva è %1.2f";
	private final static String MSG_DIED = "\nAttenzione sono violate le condizioni per la mia sopravvivenza! Addio!";
	private final static String MSG_UNHAPPY = "\nAttenzione sono infelice!";
	
	private String nome;
	private double affettività;
	private double sazietà;
	
	/**
	 * Constructor.
	 * @param nome - The name of Object Tamagotchi
	 * @param affettività - The level of affettività
	 * @param sazietà - The level of sazietà
	 */
	public Tamagotchi(String nome, double affettività, double sazietà) {
		this.nome = nome;
		this.affettività = affettività;
		this.sazietà = sazietà;
	}
	
	/**
	 * Give a number of carezze.
	 * @param carezze - The number of carezze to give to the Object Tamagotchi
	 */
	public void giveCarezze(int carezze) {
		affettività = Math.min(affettività + carezze, MAX_SAZ);
		sazietà = Math.max(MIN_SAZ, sazietà - carezze * DECREASE_SAZIETA);
	}
	
	/**
	 * Give a nuber of biscotti.
	 * @param biscotti - The number of biscotti to give to the Object Tamagotchi
	 */
	public void giveBiscotti(int biscotti) {
		for(int i = 1; i <= biscotti; i++) sazietà = Math.min(sazietà * INCREASE_SAZIETA, MAX_SAZ);
		affettività = Math.max(MIN_SAZ, affettività - (biscotti / DECREASE_AFFETTIVITA));
	}
	
	// Metodo Checker
	public boolean isDied() {
		if(affettività == MIN_SAZ || (sazietà == MIN_SAZ || sazietà == MAX_SAZ)) return true;
		else return false;
	}
	
	public boolean isUnhappy() {
		if(affettività < MIN_AFF || (sazietà < MIN_AFF || sazietà > MAX_AFF)) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(String.format(DESCRIPTION, nome, affettività, sazietà));
		if(isDied()) result.append(MSG_DIED);
		else if (isUnhappy()) result.append(MSG_UNHAPPY);
		
		return result.toString();
	}
}
