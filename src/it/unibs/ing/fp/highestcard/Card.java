package it.unibs.ing.fp.highestcard;

/**
 * <h1> Class Card </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-05-03
 */

public class Card {
    private String suit;
    private String value;

    /**
     * Constructor.
     * @param suit - The suit of Card
     * @param value - The value of Card
     */
    public Card(String suit, String value) {
        this.suit = suit;
        this.value = value;
    }
    
    //public Card() { }
    
    public String getSuit() {
        return suit;
    }
    
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public String getValue() {
        return value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "\n"+value + " of "+ suit;
    }
}
