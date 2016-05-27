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
	
	private static final double DECREASE_AFFETTIVITA = 4;
	protected static final double DECREASE_SAZIETA = 0.5;
	protected static final double INCREASE_SAZIETA = 1.1;
	
	public static final int MIN_SAZ = 0;
	public static final int MAX_SAZ = 100;
	private static final int MIN_AFF = 30;
	private static final int MAX_AFF = 90;
	
	private static final String DESCRIPTION	= "Sono %s di tipo %s\nIl mio grado di soddisfazione affettiva è %1.2f\nIl mio grado di sazietà è %1.2f";
	private static final String MSG_DIED = "\nAttenzione sono violate le condizioni per la mia sopravvivenza! Addio! X(";
	private static final String MSG_UNHAPPY = "\nAttenzione sono infelice! :(";
	
	private String nome;
	private String tipo;
	protected double affettività;
	protected double sazietà;
	
	/**
	 * Constructor.
	 * @param nome - The name of Object Tamagotchi
	 * @param affettività - The level of affettività
	 * @param sazietà - The level of sazietà
	 */
	public Tamagotchi(String nome, String tipo, double affettività, double sazietà) {
		this.nome = nome;
		this.tipo = tipo;
		this.affettività = affettività;
		this.sazietà = sazietà;
	}
	
	/**
	 * Give a number of carezze.
	 * @param numCarezze - The number of carezze to give to the Object Tamagotchi
	 */
	public void giveCarezze(int numCarezze) {
		affettività = Math.min(affettività + numCarezze, MAX_SAZ);
		sazietà = Math.max(MIN_SAZ, sazietà - numCarezze * DECREASE_SAZIETA);
	}
	
	/**
	 * Give a nuber of biscotti.
	 * @param numBiscotti - The number of biscotti to give to the Object Tamagotchi
	 */
	public void giveBiscotti(int numBiscotti) {
		for(int i = 1; i <= numBiscotti; i++) sazietà = Math.min(sazietà * INCREASE_SAZIETA, MAX_SAZ);
		affettività = Math.max(MIN_SAZ, affettività - (numBiscotti / DECREASE_AFFETTIVITA));
	}
	
	//	CHECKERS
	
	public boolean isDied() {
		return (affettività == MIN_SAZ || (sazietà == MIN_SAZ || sazietà == MAX_SAZ));
	}
	
	public boolean isUnhappy() {
		return (affettività < MIN_AFF || (sazietà < MIN_AFF || sazietà > MAX_AFF));
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(String.format(DESCRIPTION, nome, tipo, affettività, sazietà));
		if(isDied()) result.append(MSG_DIED);
		else if (isUnhappy()) result.append(MSG_UNHAPPY);
		return result.toString();
	}
}
