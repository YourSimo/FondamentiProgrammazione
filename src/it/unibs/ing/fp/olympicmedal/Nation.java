package it.unibs.ing.fp.olympicmedal;

public class Nation {
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
	 * Add medals
	 * @param qtà - The number of medal
	 */
	public void addMedal(int qtà) {
		numMedal[qtà]++;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		return result.toString();
	}
}
