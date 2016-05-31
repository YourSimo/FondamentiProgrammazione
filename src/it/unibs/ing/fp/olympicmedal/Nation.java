package it.unibs.ing.fp.olympicmedal;

import it.unibs.ing.fp.library.Formatting;

public class Nation implements Comparable<Nation>{
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
	
	//	GETTERS
	/**
	 * Returns the name of Nation.
	 * @return name of Nation
	 */
	public String getName() {
		return name;
	}
	
	public int getNumMedal(int medal) {
		return numMedal[medal];
	}
	
	/**
	 * Add medal.
	 * @param medal - The position of podium
	 */
	public void addMedal(int medal) {
		numMedal[medal]++;
	}

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn(name, Medals.WIDTH_FIRST_COLUMN));
		for (int i = 0; i < Medals.NAME_MEDALS.length; i++)
			result.append(Formatting.centered(String.valueOf(numMedal[i]), Medals.WIDTH_MEDAL_COLUMN));
		return result.toString();
	}

	@Override
	public int compareTo(Nation compareNation) {
		int medal = 0;
		//ascending order
		return this.numMedal[medal] - compareNation.getNumMedal(medal);
		
		//descending order
		//return compareQuantity - this.quantity;
	}
}
