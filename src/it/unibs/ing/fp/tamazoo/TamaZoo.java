package it.unibs.ing.fp.tamazoo;

import java.util.Vector;
import it.unibs.ing.fp.tamagotchi.Tamagotchi;

/**
 * <h1> Class TamaZoo </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-05-17
 */

public class TamaZoo {
	private static final String MSG_TAMAZOO = "----------[TamaZoo]----------";
	
	private Vector <Tamagotchi> tamaZoo;
	
	/**
	 * Constructor.
	 */
	public TamaZoo() {
		tamaZoo = new Vector <Tamagotchi>();
	}
	
	/**
	 * Add a Tamagotchi in TamaZoo.
	 * @param ta - The Tamagotchi to add
	 */
	public void addTamagotchi(Tamagotchi ta) {
		tamaZoo.add(ta);
	}
	
	/**
	 * Give a number of carezze on each Tamagotchi.
	 * @param numCarezze - The number of carezze to give to the Vector Tamagotchi
	 */
	public void giveCarezze(int numCarezze) {
		for(Tamagotchi ta : tamaZoo) ta.giveCarezze(numCarezze);
	}
	
	/**
	 * Give a number of biscotti on each Tamagotchi.
	 * @param numBiscotti - The number of biscotti to give to the Vector Tamagotchi
	 */
	public void giveBiscotti(int numBiscotti) {
		for(Tamagotchi ta : tamaZoo) ta.giveBiscotti(numBiscotti);
	}
	
	public void removeTamagotchiDied() {
		for(int i = 0; i < tamaZoo.size(); i++) {
			if(tamaZoo.get(i).isDied()) {
				tamaZoo.remove(i); 
				i--;
			}
		}
	}
	
	public boolean allDead() {
		if(tamaZoo.size() == 0) return true;
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append("\n" + MSG_TAMAZOO + "\n\n");
		for(int i = 0; i < tamaZoo.size(); i++) {
			result.append(tamaZoo.get(i).toString() + "\n\n");
		}
		return result.toString();
	}
}
