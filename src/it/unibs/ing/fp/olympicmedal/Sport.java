package it.unibs.ing.fp.olympicmedal;

/**
 * <h1> Class Sport </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v2.0
 * @since 2016-05-10
 */

public class Sport {
	private String name;
	private boolean existing;
	private Nation [] ranking;
	
	//	Ogni Sport ha: Cond. Esistenza; Nazione ORO, Nazione AREGNTO, Nazione BRONZO
	/**
	 * Constructor.
	 * @param name - The name of Sport
	 */
	public Sport(String name) {
		this.name = name;
		existing = false;
		ranking = new Nation[Medals.NUM_MEDALS];
	}
	
	/**
	 * Returns the name of Sport
	 * @return name of Sport
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns true if 
	 * @return
	 */
	public boolean isExist() {
		return existing;
	}
	
	/**
	 * Set true at existing 
	 */
	public void setExist() {
		existing = true;
	}
	
	/**
	 * Add ranking.
	 * @param nation - The Nation to add
	 * @param index - The position of podium
	 */
	public void addRanking(Nation nation, int index) {
		ranking[index] = nation;
	}
}
