package it.unibs.ing.fp.tamazoo;

import java.util.Vector;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.math.Casuale;
import it.unibs.ing.fp.tamagotchi.Tamagotchi;

/**
 * <h1> Class TamaZoo </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.0
 * @since 2016-05-17
 */

public class TamaZoo {
	private static final String MSG_TAMAZOO = "--[TamaZoo]--\n";
	
	private Vector <Tamagotchi> tamaZoo;
	
	public TamaZoo(int qtà) {
		tamaZoo = new Vector <Tamagotchi>();
		for (int i = 0; i < qtà; i++) {
			tamaZoo.add(TamaZooMain.makeTamagotchi());
		}
	}
	
	public void giveCarezze(int carezze) {
		for(Tamagotchi ta : tamaZoo) ta.giveCarezze(carezze);
	}
	
	public void giveBiscotti(int biscotti) {
		for(Tamagotchi ta : tamaZoo) ta.giveBiscotti(biscotti);
	}
	
	
	public boolean allDead() {
		boolean noSurvivors = true;
		for(int i = 0; i < tamaZoo.size(); i++) {
			if(tamaZoo.get(i).isDied()) {
				tamaZoo.remove(i); 
				i--;
			}
		}
		for(Tamagotchi ta : tamaZoo) if(!ta.isDied()) noSurvivors = false;
		return noSurvivors;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(MSG_TAMAZOO);
		for(int i = 0; i < tamaZoo.size(); i++) {
			result.append(tamaZoo.get(i).toString() + "\n");
		}
		return result.toString();
	}
}
