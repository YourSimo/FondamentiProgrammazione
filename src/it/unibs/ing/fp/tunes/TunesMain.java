package it.unibs.ing.fp.tunes;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;

/**
 * <h1> Class TunesMain </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini 
 * @author Simone Cavicchioli
 * 
 * @version v1.1
 * @since 2016-04-26
 */

public class TunesMain {
	
	final private static String INTRO = "\nProgramma per la gestione dell'Archivio CD\n\n";
	final private static String MSG_EXIT = "Vuoi veramente uscire?";
	final private static String MESS_FINALE = "Fine programma";
	final private static String TITLE = "Elenco Funzionalità";
	  
	final private static String ERRORE_FUNZIONE = "La funzione non rientra tra quelle disponibili!";
	final private static String MESS_ALTRA_OPZIONE = "Selezionare un'altra opzione.";
	  
	final private static String [] VOCIMENU = {"Inserisci nuovo CD","Rimuovi CD dall'archivio","Visualizza CD", "Visualizza intera collezione", "Selezione casuale"};
	

	public static void main(String[] args) {
		boolean fineProgramma = false;

		System.out.println(INTRO);

		CDCollection myCollection = new CDCollection();
			
		Menu menuMain = new Menu(TITLE, VOCIMENU);

		do {
			int selezione = menuMain.choice();
			fineProgramma = eseguiFunzioneScelta(selezione, myCollection);
		} while(!fineProgramma);

		System.out.println(MESS_FINALE);
	}

			
	private static boolean eseguiFunzioneScelta(int numFunzione, CDCollection archivio) {
	 
		switch (numFunzione) {

			case 0: // Esci
				return InputData.yesOrNo(MSG_EXIT);
				//break; // ! Superfluo e non solo ... (non compila)
				
			case 1: // Inserisci
				archivio.addNewAlbum();
				break;

			case 2: // Rimuovi
				archivio.deleteAlbum();
				break;

			case 3: // Visualizza
				archivio.showAlbum();
				break;

			case 4: // Visualizzazione completa
				System.out.println(archivio.toString());
				break;
					
			case 5: // Selezione Casuale
				archivio.selectRandomAlbum();
				break;

			default: // Se i controlli nella classe Menu sono corretti, questo non viene mai eseguito !
				System.out.println(ERRORE_FUNZIONE);
				System.out.println(MESS_ALTRA_OPZIONE);
				break;
		}
		return false;
	}
}
