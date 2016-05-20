package it.unibs.ing.fp.highestcard;

/**
 * <h1> Class Card </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-05-03
 */

public class Card {
    private String suit;
    private String value;
    private int index;

    /**
     * Constructor.
     * @param suit - The suit of Card
     * @param value - The value of Card
     */
    public Card(String suit, String value, int index) {
        this.suit = suit;
        this.value = value;
        this.setIndex(index);
    }
    
    // Getters
    
    /**
	 * @return the suit
	 */
    public String getSuit() {
        return suit;
    }
    
    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }
    
    /**
	 * @return the index
	 */
	public int getIndex() {
		return index;
	}
	
	// Setters
    
    /**
     * @param suit - The suit to set
     */
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    /**
     * @param value - The value to set
     */
    public void setValue(String value) {
        this.value = value;
    }
    
	/**
	 * @param index - The index to set
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Returns the difference between two Card.
	 * @param other - The other card to compare
	 * @return the difference
	 */
	public int compareTo(Card other) {
		return this.getIndex() - other.getIndex();
	}

    @Override
    public String toString() {
        return value + " di "+ suit;
    }	
}
