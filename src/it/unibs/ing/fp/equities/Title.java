package it.unibs.ing.fp.equities;

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
	private static final String TITLE_FORMAT = "%s %.2f";
	
	private String name;
	private double value;
	
	public Title(String name, double value) {
		setName(name);
		setValue(value);
	}
	
	//	Getters
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the value
	 */
	public double getValue() {
		return value;
	}
	
	//	Setters

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(double value) {
		this.value = value;
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(String.format(TITLE_FORMAT, name.toUpperCase(), value));
		return result.toString();
	}
}
