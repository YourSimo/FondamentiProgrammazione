package it.unibs.ing.fp.olympicmedal;

import java.util.Collections;
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
 * @version v2.0
 * @since 2016-05-10
 */

public class NationList {
	private static final String MSG_NO_NATION = "Attenzione non e' presente nessuna nazione";
	private static final String MSG_RANKING = "ECCO IL MEDAGLIERE OLIMPICO";
	private static final String MSG_RANKING_SORTED = "ECCO IL MEDAGLIERE OLIMPICO ORDINATO";
	
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
	// getNationsNames
	public String [] getName() {
		String [] result = new String[nations.size()];
		for(int i = 0; i < result.length; i++) {
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
	
	/**
	 * Returns true if there are no nations on the list.
	 * @return <tt> true </tt> if there are no nations on the list; <tt>false </tt> otherwise
	 */
	public boolean isEmpty() {
		if(nations.size() == 0) return true;
		return false;
	}
	
	/**
	 * Returns a user chooses Nation or nothing.
	 * @param message - ...
	 * @return Nation if user choose a number different from 0; nothing otherwise
	 */
	public Nation choiceNation(String question) {
		String [] listNationNames = getName();
		Menu choiceList = new Menu (question, listNationNames);
		int choiceUser = choiceList.choice();
		if(choiceUser == 0) return null;
		else return nations.get(choiceUser - 1);
	}
	
	public void visualizzaMedagliere() {
		if (isEmpty()) {
			System.out.println(MSG_NO_NATION);
			return;
		}
		System.out.println(Formatting.framing(MSG_RANKING));
		System.out.println(Medals.heading());
		for(int i = 0; i < nations.size(); i++) {
			System.out.println(nations.get(i).toString());
		}
	}

	public void visualizzaMedagliereOrdinato() {
		if (isEmpty()) {
			System.out.println(MSG_NO_NATION);
			return;
		}
		Vector <Nation> orderNation = nations;
		Collections.sort(orderNation);
		System.out.println(Formatting.framing(MSG_RANKING_SORTED));
		System.out.println(Medals.heading());
		for(int i = 0; i < orderNation.size(); i++) {
			System.out.println(orderNation.get(i).toString());
		}
	}
}
