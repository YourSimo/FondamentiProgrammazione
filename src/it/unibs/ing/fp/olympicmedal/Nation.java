package it.unibs.ing.fp.olympicmedal;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.library.Sortable;

public class Nation /*implements Sortable*/{
	private String name;
	private int [] numMedal;
	
	//	Ogni Nazione ha: N°ORI, N°ARGENTI, N°BRONZI
	/**
	 * Constructor.
	 * @param name - The name of Nation
	 */
	public Nation(String name) {
		this.name = name;
		numMedal = new int[Medals.NUM_MEDALS];
	}
	
	/**
	 * Returns the name of Nation.
	 * @return name of Nation
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Add medal.
	 * @param medal - The position of podium
	 */
	public void addMedal(int medal) {
		numMedal[medal]++;
	}
	
	public boolean lessThan(Nation otherNation, int podio) {
		if(numMedal[podio] < otherNation.numMedal[podio]) return true;
		else return false;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn(name, Medals.WIDTH_FIRST_COLUMN));
		for (int i = 0; i < Medals.NAME_MEDALS.length; i++)
			result.append(Formatting.centered(String.valueOf(numMedal[i]), Medals.WIDTH_MEDAL_COLUMN));
		return result.toString();
	}
}
