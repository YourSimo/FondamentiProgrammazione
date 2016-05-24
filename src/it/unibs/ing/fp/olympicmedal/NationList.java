package it.unibs.ing.fp.olympicmedal;

import java.util.Vector;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.library.Menu;

/**
 * <h1> Class NationList </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v1.0
 * @since 2016-05-10
 */

public class NationList {
	private static final String NATION_FORMAT = "%s, ";
	private Vector <Nation> nations;
	
	/**
	 * Constructor.
	 */
	public NationList() {
		nations = new Vector<Nation>();
	}
	
	/**
	 * Add new nation.
	 * @param newState - The nation to add
	 */
	public void addNewNation(Nation newState) {
		nations.add(newState);
	}
	
	/**
	 * Returns a Array of Nation names.
	 * @return array of nations names strings
	 */
	public String [] getName() {
		String [] result = new String[nations.size()];
		for (int i = 0; i < result.length; i++) {
		 	result[i] = nations.get(i).getName();
		}
		return result;
	}
	
	/**
	 * Returns true if the nation sought exists.
	 * @param search - The nation to search
	 * @return <tt> true </tt> if find a match; <tt>false </tt> otherwise
	 */
	public boolean matchNation(String search) {
		for(Nation state : nations) {
			if(search.equalsIgnoreCase(state.getName())) return true;
		}
		return false;
	}
	
	public boolean isEmpty() {
		if(nations.size() == 0) return true;
		return false;
	}
	
	public Nation choiceNation(String question) {
		String [] choices = getName();
		Menu choiceList = new Menu (question, choices);
		int choise = choiceList.choise();
		if (choise == 0) return null;
		else return nations.get(choise - 1);
	}
	
	public void visualizzaMedagliere() {
		if (/* SE NON CI SONO NAZIONI IN ELENCO */) {
			// DARE UN MESSAGGIO DI ERRORE E USCIRE IMMEDIATAMENTE
		}
		System.out.println(Formatting.framing(MSG_MEDAGLIERE));
		System.out.println(Medals.heading());
		// DOPO L'INTESTAZIONE STAMPARE I DATI DELLE NAZIONI UNA PER UNA
	}

	public void visualizzaMedagliereOrdinato() {
		 // DA COMPLETARE
	}
}
