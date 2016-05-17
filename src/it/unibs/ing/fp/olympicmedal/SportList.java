package it.unibs.ing.fp.olympicmedal;

import java.util.Vector;

/**
 * Class SportList
 * 
 * @author Simone Cavicchioli <s.cavicchioli@studenti.unibs.it>
 * @version v1.0
 * @since 2016-05-10
 *
 */

public class SportList {
	private static final String SPORT_FORMAT = "%s, ";
	private Vector <String> sports;
	
	public SportList() {
		sports = new Vector<String>();
	}
	
	public void addNewNation(String race) {
		sports.add(race);
	}
	
	/**
	 * 
	 * @param search
	 * @return 
	 */
	public boolean matchNation(String search) {
		for(String race : sports) {
			if(race.equalsIgnoreCase(search)) return true;
		}
		return false;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		for(String race : sports) {
			result.append(String.format(SPORT_FORMAT, race));
		}
		return result.toString();
	}
}
