package it.unibs.ing.fp.equities;

import java.io.File;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;
import it.unibs.ing.fp.library.OutputData;
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
	public static final int WIDTH_FIRST_COLUMN = 8;
	public static final int WIDTH_OTHER_COLUMN = 15;
	public static final int WIDTH_INDENTATION = 26;
	
	private static final String MSG_WALLET_NAME = "INSERIRE LA DENOMINAZIONE DEL PORTAFOGLIO CONSIDERATO: ";
	private static final String MSG_TITLE_NAME = "INSERIRE LA DENOMINAZIONE DEL NUOVO TITOLO DA CREARE: ";
	private static final String MSG_TITLE_VALUE = "INSERIRE IL PREZZO INIZIALE DEL TITOLO:%n[%s] ";
	private static final String MSG_OTHER_TITLE = "INSERIRE UN ALTRO TITOLO IN ELENCO?";
	private static final String MSG_TITLE_AMOUNT = "INSERIRE IL NUMERO DI AZIONI ACQUISTATE DEL TITOLO %s: ";
	
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE TITOLI AZIONARI";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String NAME_FILE_TITLE = "archiviotitoli.dat";
	private static final String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	private static final String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	private static final String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	private static final String MSG_INTRO_PORTFOLIO = "SITUAZIONE PORTAFOGLIO";
	private static final String MSG_PROCEDI = "PROCEDERE CON LA SIMULAZIONE ?";
	private static final String MSG_SALVA = "SALVATAGGIO DATI";
	private static final String MSG_INTRO_GIORNO = "GIORNO N.%d NUOVA SITUAZIONE INVESTIMENTI";
	
	private static Title makeTitle() {
		String name = InputData.readStringNotEmpty(MSG_TITLE_NAME);
		double value = InputData.readDoublePositive(String.format(MSG_TITLE_VALUE, name.toUpperCase()));
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
	
		File fileTitle = new File(NAME_FILE_TITLE);
	  
		Wallet portafoglio = null;
		TitleList elencoTitoli = null;
		Container contenitore = null;
		
		boolean caricamentoRiuscito = false;
		
		if(fileTitle.exists()) {
			try {
				contenitore = (Container)OutputData.loadSingleObject(fileTitle);
				elencoTitoli = contenitore.getTitleList();
				portafoglio = contenitore.getWallet();
			} catch (ClassCastException e) {
			   System.out.println(MSG_NO_CAST);
			} finally {
				if ((portafoglio != null) && (elencoTitoli != null)) {
				   System.out.println(MSG_OK_FILE);
				   caricamentoRiuscito = true;
				}
			}
		}
		
		if (!caricamentoRiuscito) {
			System.out.println(MSG_NO_FILE);
			elencoTitoli = makeTitleList();
			portafoglio = makeWallet(elencoTitoli);
		}
		System.out.println("\n" + MSG_INTRO_PORTFOLIO);
	 	System.out.println(portafoglio.toString());
			
		int giorni = 0;
		while (InputData.yesOrNo(MSG_PROCEDI)) {
			 giorni++;
			 elencoTitoli.setRandomValues();
			 System.out.println(String.format(MSG_INTRO_GIORNO, giorni));
		 	 System.out.println(portafoglio);
		}
			
		System.out.println(MSG_SALVA);
		contenitore = new Container(elencoTitoli, portafoglio);
		OutputData.uploadSingleObject(fileTitle, contenitore);
		
		Hello.sayHello(MSG_OUTRO);
	 }
}
