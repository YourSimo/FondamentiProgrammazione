package it.unibs.ing.fp.tamazoo;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;
import it.unibs.ing.fp.math.Casuale;
import it.unibs.ing.fp.tamagotchi.Tamagotchi;

/**
 * <h1> Class TamaZooMain </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-05-17
 */

public class TamaZooMain {
	private static final String MSG_NEW_NAME = "Inserisci un nickname: ";
	private static final String [] TAMA_TYPES = {"TamaBase", "TamaTriste", "TamaGordo"};
	
	private static final String MSG_NEW_TAMAZOO = "Inserire il numero di Tamagotchi da creare: ";
	
	private static final String MSG_INTRO = "BENVENUTO NEL MONDO DEI TAMAGOTCHI";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String MAIN_QUESTION = "Scegli l'operazione da eseguire";
	private static final String [] MAIN_MENU_ITEMS = {"Dare carezze", "Dare biscotti"};
	
	private static final String MSG_CAREZZE = "Verranno somministrate %d carezze a ciascun Tamagotchi\n\n";
	private static final String MSG_BISCOTTI = "Verranno somministrati %d biscotti a ciascun Tamagotchi\n\n";
	
	private static final int MIN_CAREZZE = 0;
	private static final int MIN_BISCOTTI = 0;
	private static final int MAX_BISCOTTI = 10;
	private static final int MAX_CAREZZE = 20;
	
	private static final String MSG_ALL_DEAD = "PURTROPPO NON CI SONO TAMAGOTCHI SOPRAVVISSUTI - IL PROGRAMMA TERMINA";
	
	private static TamaZoo myTamaZoo = new TamaZoo();
	
	private static Tamagotchi makeTamagotchi() {
		String nome = InputData.readStringNotEmpty(MSG_NEW_NAME);
		int affettività = Casuale.randomInt(Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		int sazietà = Casuale.randomInt(Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		
		Tamagotchi newTama = null;
		
		int type = Casuale.randomInt(0, TAMA_TYPES.length - 1);
		switch(type) {
			case 0: 
				newTama = new Tamagotchi(nome, TAMA_TYPES[0], affettività, sazietà);
				break;
			case 1:
				newTama = new TamaTriste(nome, TAMA_TYPES[1], sazietà);
				break;
			case 2:
				newTama = new TamaGordo(nome, TAMA_TYPES[2], sazietà);
				break;
		}
		return newTama;
	}
	
	private static TamaZoo makeTamaZoo() {
		int amount = InputData.readIntWithMin(MSG_NEW_TAMAZOO, 1);
		for (int i = 0; i < amount; i++) myTamaZoo.addTamagotchi(makeTamagotchi());
		return myTamaZoo;
	}	
	
	private static void printTamaZoo(TamaZoo taZ) {
		System.out.println(taZ.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hello.sayHello(MSG_INTRO);
		
		makeTamaZoo();
		
		printTamaZoo(myTamaZoo);
		
		Menu menu = new Menu(MAIN_QUESTION, MAIN_MENU_ITEMS);
		
		boolean finish = false;
		
		do {
			int itemSelected = menu.choice();
			switch(itemSelected) {
				case 1:
					int numCarezze = Casuale.randomInt(MIN_CAREZZE, MAX_CAREZZE);
					System.out.printf(MSG_CAREZZE, numCarezze);
					myTamaZoo.giveCarezze(numCarezze);
					printTamaZoo(myTamaZoo);
					break;
				case 2:
					int numBiscotti = Casuale.randomInt(MIN_BISCOTTI, MAX_BISCOTTI);
					System.out.printf(MSG_BISCOTTI, numBiscotti);
					myTamaZoo.giveBiscotti(numBiscotti);
					printTamaZoo(myTamaZoo);
					break;
				case 0:
					finish = true;
					break;
				default:
					System.out.println("Operazione non riconosciuta.");
					break;
			}
			myTamaZoo.removeTamagotchiDied();
			
			if(myTamaZoo.allDead()) {
				finish = true;
				System.out.println(MSG_ALL_DEAD);
			}
		} while(!finish);
		
		Hello.sayHello(MSG_OUTRO);
	}

}
