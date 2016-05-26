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
 * @author Simone Cavicchioli
 * @version v1.0
 * @since 2016-05-17
 */

public class TamaZooMain {
	
	private static final String MAIN_QUESTION = "Scegli l'operazione da eseguire";
	private static final String [] MAIN_MENU_ITEMS = {"Dare carezze", "Dare biscotti"};
	
	private static final String MSG_INTRO = "BENVENUTO NEL MONDO DEI TAMAGOTCHI";
	private static final String MSG_OUTRO = "ARRIVEDERCI";
	
	private static final String MSG_NEW_TAMAZOO = "Inserire il numero di Tamagotchi da creare: ";
	
	private static final int MIN_CAREZZE = 0;
	private static final int MIN_BISCOTTI = 0;
	private final static int MAX_BISCOTTI = 10;
	private final static int MAX_CAREZZE = 20;
	
	private static final String MSG_NEW_NAME = "Inserisci un nickname: ";
	//	private static final String [] TAMA_TYPES = {"Tamagotchi", "TamaTriste", "TamaGordo"};
	private static final String MSG_ALL_DEAD = "PURTROPPO NON CI SONO TAMAGOTCHI SOPRAVVISSUTI - IL PROGRAMMA TERMINA";
	
	private static final String MSG_CAREZZE = "Verranno somministrate %d carezze a ciascun Tamagotchi\n\n";
	private static final String MSG_BISCOTTI = "Verranno somministrati %d biscotti a ciascun Tamagotchi\n\n";

	public static Tamagotchi makeTamagotchi() {
		String nome = InputData.readStringNotEmpty(MSG_NEW_NAME);
		int affettività = Casuale.randomInt(Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		int sazietà = Casuale.randomInt(Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		
		switch(/*Casuale.randomInt(0, TAMA_TYPES.length)*/ 0) {
			case 0: 
				return new Tamagotchi(nome, affettività, sazietà);
			case 1:
				//	return new TamaTriste(nome, affettività, sazietà);
				break;
			case 2:
				//	return new TamaGordo(nome, affettività, sazietà);
		}
		return null;
	}
	
	private static TamaZoo makeTamaZoo() {
		int amount = InputData.readIntWithMin(MSG_NEW_TAMAZOO, 1);
		return new TamaZoo(amount);
	}
	
	private static void printTamaZoo(TamaZoo taZ) {
		System.out.println(taZ.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hello.sayHello(MSG_INTRO);
		
		TamaZoo taZoo = makeTamaZoo();
		
		printTamaZoo(taZoo);
		
		Menu menu = new Menu(MAIN_QUESTION, MAIN_MENU_ITEMS);
		
		boolean finish = false;
		
		do {
			int itemSelected = menu.choise();
			switch(itemSelected) {
				case 1:
					int numCarezze = Casuale.randomInt(MIN_CAREZZE, MAX_CAREZZE);
					System.out.printf(MSG_CAREZZE, numCarezze);
					taZoo.giveCarezze(numCarezze);
					printTamaZoo(taZoo);
					break;
				case 2:
					int numBiscotti = Casuale.randomInt(MIN_BISCOTTI, MAX_BISCOTTI);
					System.out.printf(MSG_BISCOTTI, numBiscotti);
					taZoo.giveBiscotti(numBiscotti);
					printTamaZoo(taZoo);
					break;
				case 0:
					finish = true;
					break;
				default:
					System.out.println("Operazione non riconosciuta.");
					break;
			}
			if(taZoo.allDead()) {
				finish = true;
				System.out.println(MSG_ALL_DEAD);
			}
		} while(!finish);
		
		Hello.sayHello(MSG_OUTRO);
	}

}
