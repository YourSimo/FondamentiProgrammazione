package it.unibs.ing.fp.finedust;

/**
 * <h1> Class Week </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * 
 * @version v1.1
 * @since 2016-04-19
 *
 */

public class Week {
	public final static int MAX_VALUE = 75;
	public final static int AVERAGE_VALUE = 50;
	
	private final static String INTESTAZIONE ="Questa e' la settimana numero %d dell'anno %d %n";
	private final static String COMMENTO_MISURA = "Giorno: %d - Misura= %d %n";
	
	private int year;
	private int week;
	private int [] misure;
	
	/**
	 * Constructor.
	 * @param year 
	 * @param week
	 * @param misure
	 */
	public Week(int year, int week, int [] misure) {
		this.year = year;
		this.week = week;
		this.misure = misure;
	}

	/**
	 * Returns the max value.
	 * @return max value
	 */
	public int getMaxValue() {
		int max = 0;
		for(int i = 0; i < misure.length; i++)
			if(misure[i] > max) max = misure[i];
		return max;
	}
	
	/**
	 * Returns the avarage value.
	 * @return avarage value
	 */
	public int getAverageValue() {
		int somma = 0;
		for(int i = 0; i < misure.length; i++) somma += misure[i];
		int media = somma / misure.length;
		return media;
	}
	
	/**
	 * Check max value.
	 * @return <tt>true </tt> if the max value is higher than a threshold
	 */
	public boolean checkMaxValue() {
		if(getMaxValue() >= MAX_VALUE) return true;
		else return false;
	}
	
	/**
	 * Check average value.
	 * @return <tt>true </tt> if the average value is higher than a threshold
	 */
	public boolean checkAverageValue() {
		if(getAverageValue() >= AVERAGE_VALUE) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(String.format(INTESTAZIONE, week, year));
		for (int i = 0; i < misure.length; i++)
		{
			result.append(String.format(COMMENTO_MISURA, i + 1, misure[i]));
		}
		return result.toString();
	}
}
