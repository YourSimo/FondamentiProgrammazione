package it.unibs.ing.fp.equities;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;

public class EquitiesMain {
	public static final int WIDTH_FIRST_COLUMN = 7;
	public static final int WIDTH_OTHER_COLUMN = 7;
	public static final int WIDTH_INDENTATION = 12;
	
	private static final String MSG_INTRO = null;
	private static final String MAIN_QUESTION = null;
	private static final String [] MAIN_MENU_ITEMS = null;
	private static final String MSG_OUTRO = null;
	private static final String MSG_NEW_NAME = null;
	
	
	private static TitleList myListTitle = new TitleList();
	
	// la composizione di un portafoglio, che consiste nello stabilire, per ciascun titolo in elenco, un numero di azioni acquistate
	
	private static Wallet makeWallet() {
		String name = InputData.readStringNotEmpty(MSG_NEW_NAME);
		return new Wallet(name);
	}
	
	private static managementTitleList() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hello.sayHello(MSG_INTRO);
		
		makeWallet();
		
		Menu menu = new Menu(MAIN_QUESTION, MAIN_MENU_ITEMS);
		
		boolean finish = false;
		
		// chiede all’utente se gestire elenco titoli, composizione portafogli o simulazione
		
		do {
			int itemSelected = menu.choice();
			switch(itemSelected) {
				case 1:
					
					break;
				case 2:
					
					break;
					
				case 0:
					finish = true;
					break;
				default:
					System.out.println("Operazione non riconosciuta.");
					break;
			}
		} while(!finish);
		
		Hello.sayHello(MSG_OUTRO);
		
	}

}
