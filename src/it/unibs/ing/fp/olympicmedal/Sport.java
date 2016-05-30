package it.unibs.ing.fp.olympicmedal;

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
	 * Add ...
	 * @param medal - The medal ...
	 * @param index - The position ...
	 */
	public void addRanking(Nation nation, int index) {
		ranking[index] = nation;
	}
}
