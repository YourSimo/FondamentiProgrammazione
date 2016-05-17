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
	private final static String MSG_NOME = "Inserisci un nickname: ";
	private static final String MSG_TAMAZOO = "--[TamaZoo]--%n";
	
	private Vector <Tamagotchi> tamaZoo;
	
	public TamaZoo(int qtà) {
		tamaZoo = new Vector <Tamagotchi>();
		for (int i = 0; i < qtà; i++) {
			tamaZoo.add(makeTamagotchi());
		}
	}
	
	public void diedTamagotchi(Tamagotchi ta) {
		tamaZoo.remove(ta);
	}
	
	public static Tamagotchi makeTamagotchi() {
		String nome = InputData.readStringNotEmpty(MSG_NOME);
		int affettività = Casuale.randomInt(Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		int sazietà = Casuale.randomInt(Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		
		return new Tamagotchi(nome, affettività, sazietà);
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(MSG_TAMAZOO);
		for(int i = 0; i < tamaZoo.size(); i++) {
			result.append(tamaZoo.get(i).toString() + "%n");
		}
		return result.toString();
	}
}
