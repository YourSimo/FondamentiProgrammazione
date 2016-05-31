package it.unibs.ing.fp.olympicmedal;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;

/**
 * <h1> Class OlympicMedalMain </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v1.0
 * @since 2016-05-10
 */

public class OlympicMedalMain {
	private static NationList participants = new NationList();
	private static SportList sports = new SportList();
	
	private static final String RETURN = "-";
	private static final String MSG_NEW_NATION = "Introdurre il nome della nuova nazione partecipante (" + RETURN + " per tornare al menu principale) ";
	private static final String MSG_EXISTING_NATION = "Attenzione: nazione gia' presente in elenco - Ripetere l'inserimento";

	private static final String MSG_NEW_SPORT = "Introdurre il nome della nuova gara in programma (" + RETURN + " per tornare al menu principale) ";
	private static final String MSG_EXISTING_SPORT = "Attenzione: gara gia' presente in elenco - Ripetere l'inserimento";
	
	private static final String MSG_INTRO = "BENVENUTO NELLA GESTIONE DEL MEDAGLIERE OLIMPICO";
	private static final String MSG_OUTRO = "GRAZIE PER AVERE USATO IL PROGRAMMA MEDAGLIERE - ARRIVEDERCI";
	private static final String MAIN_QUESTION = "Scegli l'operazione da eseguire";
	private static final String [] MAIN_MENU_ITEMS = {"Introduzione nuove nazioni","Introduzione nuove gare","Introduzione risultato gara", "Visualizzazione medagliere","Visualizzazione medagliere ordinato"};
	
	private static final String MSG_MISSING_DATA = "Attenzione: devono essere gia' inserite almeno una nazione e una gara";
	private static final String MSG_CHOICE_SPORT = "Selezionare la gara della quale effettuare la premiazione";
	private static final String MSG_AWARDS_CANCELED = "Attenzione: premiazione annullata";
	private static final String MSG_SPORT_DONE = "Attenzione: la premiazione della gara selezionata e' stata gia' svolta";
	private static final String MSG_CHOICE_WINNER = "Selezionare nazione vincente della medaglia:";
	private static final String MSG_OBLIGATORY_CHOICE = "Attenzione: la scelta di una nazione e' obbligatoria";
	
	private static void newNation() {
		boolean finish = false;
		do {
			String nameNation = InputData.readStringNotEmpty(MSG_NEW_NATION);
			if (nameNation.equals(RETURN)) finish = true;
			else if (participants.matchNation(nameNation)) System.out.println(MSG_EXISTING_NATION);
			else participants.addNewNation(new Nation(nameNation));  
		} while (!finish);
	}
	
	private static void newSport() {
		boolean finish = false;
		do {
			String nameSport = InputData.readStringNotEmpty(MSG_NEW_SPORT);
			if (nameSport.equals(RETURN)) finish = true;
			else if (sports.matchSport(nameSport)) System.out.println(MSG_EXISTING_SPORT);
			else sports.addNewSport(new Sport(nameSport));  
		} while (!finish);
	}
	
	private static void addScore() {
		if (participants.isEmpty() || sports.isEmpty()) System.out.println(MSG_MISSING_DATA);
		else {
			Sport selected = sports.choiceSport(MSG_CHOICE_SPORT);
			if (selected == null) {
				System.out.println(MSG_AWARDS_CANCELED);
				return;
			}
			if (selected.isExist()) System.out.println(MSG_SPORT_DONE);
			else {
				selected.setExist();
		
				for (int i = 0; i < Medals.NUM_MEDALS; i++) {
					Nation medagliata;
					do {
						medagliata = participants.choiceNation(MSG_CHOICE_WINNER + Medals.NAME_MEDALS[i]);
						if (medagliata == null) System.out.println(MSG_OBLIGATORY_CHOICE); 
					} while (medagliata == null);
					medagliata.addMedal(i);
					selected.addRanking(medagliata, i);
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hello.sayHello(MSG_INTRO);
		
		Menu menu = new Menu(MAIN_QUESTION, MAIN_MENU_ITEMS);
		
		boolean finish = false;
		
		do {
			int voceSelezionata = menu.choice();
			
			switch(voceSelezionata) {
			case 1:
				newNation();
				break;
			case 2:
				newSport();
				break;
			case 3:
				addScore();
				break;
			case 4:
				participants.visualizzaMedagliere();
				break;
			case 5:
				participants.visualizzaMedagliereOrdinato();
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
