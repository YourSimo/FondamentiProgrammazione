package it.unibs.ing.fp.equities;

import java.io.File;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.OutputData;

public class EquitiesUtil {
	public static final int WIDTH_FIRST_COLUMN = 8;
	public static final int WIDTH_OTHER_COLUMN = 15;
	public static final int WIDTH_INDENTATION = 26;
	
	private static final String MSG_INTRO = "BENVENUTO NEL PROGRAMMA GESTIONE TITOLI AZIONARI";
	private static final String MSG_OUTRO = "A PRESTO";
	
	private static final String NAME_FILE_TITLE = "archiviotitoli.dat";
	final private static String MSG_NO_CAST = "ATTENZIONE PROBLEMI CON IL CAST";
	final private static String MSG_OK_FILE = "CARICAMENTO DA FILE EFFETTUATO";
	final private static String MSG_NO_FILE = "NON POSSO CARICARE DA FILE: ESEGUO CREAZIONE DA ZERO";
	final private static String MSG_INTRO_PORTFOLIO = "SITUAZIONE PORTAFOGLIO";
	final private static String MSG_PROCEDI = "PROCEDERE CON LA SIMULAZIONE ?";
	final private static String MSG_SALVA = "SALVATAGGIO DATI";
	final private static String MSG_INTRO_GIORNO = "GIORNO N.%d NUOVA SITUAZIONE INVESTIMENTI";

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
			
			Title t1 = new Title("Enel", 0.01);
			Title t2 = new Title("Telecom", 0.07);
			Title t3 = new Title("Google", 0.5);
			Title t4 = new Title("Apple", 0.1);
			Title t5 = new Title("Abaco", 0.033);
			
			elencoTitoli = new TitleList();
			elencoTitoli.addTitle(t1);
			elencoTitoli.addTitle(t2);
			elencoTitoli.addTitle(t3);
			elencoTitoli.addTitle(t4);
			elencoTitoli.addTitle(t5);
			
			ItemOwned io1 = new ItemOwned(t1, 300);
			ItemOwned io2 = new ItemOwned(t2, 70);
			ItemOwned io3 = new ItemOwned(t3, 10);
			ItemOwned io4 = new ItemOwned(t4, 50);
			ItemOwned io5 = new ItemOwned(t5, 800);
			
			portafoglio = new Wallet("Nome", elencoTitoli);
			portafoglio.addItemOwned(io1);
			portafoglio.addItemOwned(io2);
			portafoglio.addItemOwned(io3);
			portafoglio.addItemOwned(io4);
			portafoglio.addItemOwned(io5);
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
