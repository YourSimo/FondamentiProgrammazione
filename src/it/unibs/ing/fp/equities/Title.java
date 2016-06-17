package it.unibs.ing.fp.equities;

import java.io.Serializable;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.math.Casuale;

/**
 * <h1> Class Title </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v3.0
 * @since 2016-05-24
 */

public class Title implements Serializable {
	private static final double OFFSET = 0.1;
	private static final String TITLE_FORMAT = "[%s] ";
	
	private String name;
	private double initialValue;	// maggiore di 0
	private double randomValue;
	
	/**
	 * Constructor.
	 * @param name - The name of Title
	 * @param initialValue - The staring value
	 */
	public Title(String name, double initialValue) {
		this.name = name;
		this.initialValue = initialValue;	// maggiore di zero
		setRandomValue();
	}
	
	//	GETTERS
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name.toUpperCase();
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
	
	public void setRandomValue() {
		randomValue = Casuale.randomDouble(Math.max(0.01, getInitialValue() - OFFSET), getInitialValue() + OFFSET);
	}
	
	//	TO_STRING: [ENEL]     3.5    :
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(String.format(TITLE_FORMAT, name.toUpperCase()));
		result.append(String.valueOf(initialValue));
		return result.toString();
	}
}
