package it.unibs.ing.fp.highestcard;

import java.util.ArrayList;
import java.util.Collections;

import it.unibs.ing.fp.math.Casuale;

/**
 * <h1> Class Deck </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-05-03
 */

public class Deck {
	private ArrayList<Card> cards;
	
	/**
	 * Constructor.
	 * @param values
	 * @param suits
	 */
	public Deck(String [] values, String [] suits) {
		cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++) {
            for(int j = 0; j < values.length; j++){
                this.cards.add(new Card(suits[i], values[j], j + 1));
            }
        }
	}
	
	/**
	 * Returns a random Card.
	 * @return random Card
	 */
	public Card getRandomCard() {
    	return cards.get(Casuale.randomInt(0, cards.size() - 1));
    }
	
	/**
	 * Returns the entire Deck.
	 * @return all cards
	 */
	public ArrayList<Card> getDeck(){
        return cards;
    }
	
	/**
	 * Shuffle the Deck.
	 */
	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
}
