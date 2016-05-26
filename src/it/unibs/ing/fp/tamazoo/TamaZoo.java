package it.unibs.ing.fp.tamazoo;

import java.util.Vector;
import it.unibs.ing.fp.tamagotchi.Tamagotchi;

/**
 * <h1> Class TamaZoo </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-05-17
 */

public class TamaZoo {
	private static final String MSG_TAMAZOO = "----------[TamaZoo]----------";
	
	private Vector <Tamagotchi> tamaZoo;
	
	public TamaZoo() {
		tamaZoo = new Vector <Tamagotchi>();
	}
	
	public TamaZoo(int qtà) {
		tamaZoo = new Vector <Tamagotchi>();
		for (int i = 0; i < qtà; i++) {
			tamaZoo.add(TamaZooMain.makeTamagotchi());
		}
	}
	
	public void addTamagotchi(Tamagotchi ta) {
		tamaZoo.add(ta);
	}
	
	public void giveCarezze(int carezze) {
		for(Tamagotchi ta : tamaZoo) ta.giveCarezze(carezze);
	}
	
	public void giveBiscotti(int biscotti) {
		for(Tamagotchi ta : tamaZoo) ta.giveBiscotti(biscotti);
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
		result.append(MSG_TAMAZOO + "\n");
		for(int i = 0; i < tamaZoo.size(); i++) {
			result.append(tamaZoo.get(i).toString() + "\n");
		}
		return result.toString();
	}
}
