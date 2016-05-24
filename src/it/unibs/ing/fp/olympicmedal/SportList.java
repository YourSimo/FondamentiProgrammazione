package it.unibs.ing.fp.olympicmedal;

import java.util.Vector;

import it.unibs.ing.fp.library.Menu;

/**
 * <h1> Class SportList </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v1.0
 * @since 2016-05-10
 */

public class SportList {
	private static final String SPORT_FORMAT = "%s, ";
	private Vector <Sport> sports;
	
	/**
	 * Constructor.
	 */
	public SportList() {
		sports = new Vector<Sport>();
	}
	
	/**
	 * Add new sport
	 * @param newSport - The sport to add
	 */
	public void addNewSport(Sport newSport) {
		sports.add(newSport);
	}
	
	/**
	 * Returns a Array of Sport names.
	 * @return array of sports names strings
	 */
	public String [] getName() {
		String [] result = new String[sports.size()];
		for (int i = 0; i < result.length; i++) {
		 	result[i] = sports.get(i).getName();
		}
		return result;
	}
	
	/**
	 * Returns true if the sport sought exists.
	 * @param search - The sport to search
	 * @return <tt> true </tt> if find a match; <tt>false </tt> otherwise
	 */
	public boolean matchSport(String search) {
		for(Sport race : sports) {
			if(search.equalsIgnoreCase(race.getName())) return true;
		}
		return false;
	}
	
	/**
	 * Returns true if there are no sports on the list.
	 * @return <tt> true </tt> if there are no sports on the list; <tt>false </tt> otherwise
	 */
	public boolean isEmpty() {
		if(sports.size() == 0) return true;
		return false;
	}
	
	/**
	 * 
	 * @param question
	 * @return
	 */
	public Sport choiceSport(String question) {
		String [] choices = getName();
		Menu choiceList = new Menu (question, choices);
		int choise = choiceList.choise();
		if (choise == 0) return null;
		else return sports.get(choise - 1);
	}
}
