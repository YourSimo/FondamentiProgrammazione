package it.unibs.ing.fp.equities;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;
import it.unibs.ing.fp.olympicmedal.Nation;

/**
 * <h1> Class EquitiesMain </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v3.0
 * @since 2016-05-24
 */

public class EquitiesMain {
	public static final int WIDTH_FIRST_COLUMN = 7;
	public static final int WIDTH_OTHER_COLUMN = 7;
	public static final int WIDTH_INDENTATION = 12;
	
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE TITOLI AZIONARI";
	private static final String MSG_OUTRO = "A PRESTO";
	
	public static final String MAIN_QUESTION = "Scegli l'operazione da eseguire";
	private static final String [] MAIN_MENU_ITEMS = {"Gestione elenco titoli", "Gestione portafoglio", "Simulazione giornagliera"};
	
	private static final String MSG_WALLET_NAME = "INSERIRE LA DENOMINAZIONE DEL PORTAFOGLIO CONSIDERATO: ";
	private static final String MSG_TITLE_NAME = "INSERIRE LA DENOMINAZIONE DEL NUOVO TITOLO DA CREARE: ";
	private static final String MSG_TITLE_VALUE = "INSERIRE IL PREZZO INIZIALE DEL TITOLO %s: ";
	private static final String MSG_OTHER_TITLE = "INSERIRE UN ALTRO TITOLO IN ELENCO? ";
	private static final String MSG_TITLE_AMOUNT = "INSERIRE IL NUMERO DI AZIONI ACQUISTATE DEL TITOLO %s: ";
	
	// la composizione di un portafoglio, che consiste nello stabilire, per ciascun titolo in elenco, un numero di azioni acquistate
	
	private static Title makeTitle() {
		String name = InputData.readStringNotEmpty(MSG_TITLE_NAME);
		double value = InputData.readDoublePositive(String.format(MSG_TITLE_VALUE, name));
		return new Title(name, value);
	}
	
	private static TitleList makeTitleList() {
		TitleList newElencoTitoli = new TitleList();
		do {
			Title newTitle = makeTitle();
			newElencoTitoli.addTitle(newTitle);
		} while (InputData.yesOrNo(MSG_OTHER_TITLE));
			
		return newElencoTitoli;
	}

	private static Wallet makeWallet(TitleList elencoTitoli) {
		String name = InputData.readStringNotEmpty(MSG_WALLET_NAME);
		Wallet wallet = new Wallet(name, elencoTitoli);
		for (int i = 0; i < elencoTitoli.getSize(); i++) {
			Title title = elencoTitoli.getTitle(i);
			int amount = InputData.readIntPositive(String.format(MSG_TITLE_AMOUNT, title.toString()));
			wallet.addItemOwned(new ItemOwned(title, amount));
		}
		return wallet;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hello.sayHello(MSG_INTRO);
		
		//	makeWallet();
		
		Menu menuMain = new Menu(MAIN_QUESTION, MAIN_MENU_ITEMS);
		
		boolean finish = false;
		
		// chiede all’utente se gestire elenco titoli, composizione portafogli o simulazione
		
		do {
			int itemSelected = menuMain.choice();
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
