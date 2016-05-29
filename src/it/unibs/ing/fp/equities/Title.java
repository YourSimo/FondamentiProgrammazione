package it.unibs.ing.fp.equities;

import it.unibs.ing.fp.library.Formatting;

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
	private String name;
	private int amount;	//	amount ---> ItemOwned
	private double initialValue;
	private double randomValue;
	
	/**
	 * Constructor.
	 * @param name - The name of Title
	 * @param amount - The amount of Title
	 * @param initialValue - The staring value
	 * @param randomValue - The random value
	 */
	public Title(String name, int amount, double initialValue, double randomValue) {
		setName(name);
		setAmount(amount);
		setInitialValue(initialValue);
		setRandomValue(randomValue);
	}
	
	//	Getters
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
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
	
	//	Setters

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * @param initialValue the initialValue to set
	 */
	public void setInitialValue(double initialValue) {
		this.initialValue = initialValue;
	}

	/**
	 * @param randomValue the randomValue to set
	 */
	public void setRandomValue(double randomValue) {
		this.randomValue = randomValue;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn(name.toUpperCase(), TitleList.WIDTH_FIRST_COLUMN));
		result.append(Formatting.centered(String.valueOf(amount), TitleList.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(initialValue), TitleList.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(randomValue), TitleList.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
}
