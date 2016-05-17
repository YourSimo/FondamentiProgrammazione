package it.unibs.ing.fp.highestcard;

import java.util.ArrayList;
import java.util.Collections;

import it.unibs.ing.fp.math.Casuale;

public class Deck {
	//private String [] values;
	//private String [] suits;
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
                this.cards.add(new Card(suits[i], values[j]));
            }
        }
	}
	
	public String getRandomCard() {
    	return cards.get(Casuale.randomInt(0, cards.size() - 1)).toString();
    }
	
	public void shuffleDeck() {
		Collections.shuffle(this.cards);
	}
	
	public ArrayList<Card> getDeck(){
        return cards;
    }
	
}
