package it.unibs.ing.fp.equities;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.math.Casuale;

/**
 * <h1> Class Title </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v1.0
 * @since 2016-05-24
 */

public class Title {
	private static final double OFFSET = 3;
	
	private String name;
	private double initialValue;
	private double randomValue;
	
	/**
	 * Constructor.
	 * @param name - The name of Title
	 * @param initialValue - The staring value
	 */
	public Title(String name, double initialValue) {
		setName(name);
		setInitialValue(initialValue);
		setRandomValue();
	}
	
	//	GETTERS
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the initialValue
	 */
	public double getInitialValue() {
		return initialValue;
	}
	
	/**
	 * @return the randomValue
	 */
	public double getRandomValue() {
		return randomValue;
	}
	
	//	SETTERS

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param initialValue the initialValue to set
	 */
	public void setInitialValue(double initialValue) {
		this.initialValue = initialValue;
	}

	public void setRandomValue() {
		randomValue = Casuale.randomDouble(Math.max(0, initialValue - OFFSET), initialValue + OFFSET);
	}
	
	//	TO_STRING
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn(name.toUpperCase(), EquitiesMain.WIDTH_FIRST_COLUMN));
		result.append(Formatting.centered(String.valueOf(initialValue), EquitiesMain.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(randomValue), EquitiesMain.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
}
