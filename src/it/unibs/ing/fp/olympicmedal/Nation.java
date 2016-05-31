package it.unibs.ing.fp.olympicmedal;

import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class Nation </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v2.0
 * @since 2016-05-10
 */

public class Nation implements Comparable <Nation> {
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
	
	/**
	 * Returns the number of Medals
	 * @param medal - The position of podium
	 * @return the number of medals
	 */
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
	public int compareTo(Nation other) {
		// -1 minore di, 0 =, +1 maggiore di;
		int result = 0, gold = 0, silver = 1, bronze = 2;
		if(other.numMedal[gold] > this.numMedal[gold]) result = 1;
		
		else if(other.numMedal[gold] == this.numMedal[gold] 
				&& other.numMedal[silver] > this.numMedal[silver]) result = 1;
		
		else if(other.numMedal[gold] == this.numMedal[gold] 
				&& other.numMedal[silver] == this.numMedal[silver] 
						&& other.numMedal[bronze] == this.numMedal[bronze]) result = 1;
		
		else result = -1;
		
		return result;
		
		//ascending order
		//	return this.numMedal[medal] - other.getNumMedal(medal);
		
		//descending order
		//	return other.numMedal[medal] - this.getNumMedal(medal);
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
