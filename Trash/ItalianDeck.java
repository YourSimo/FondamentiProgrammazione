package it.unibs.ing.fp.highestcard;

import java.util.ArrayList;
import java.util.Collections;

import it.unibs.ing.fp.math.Casuale;

public class ItalianDeck{
	// ArrayList<Card> cards = new ArrayList<Card>();

    private String [] values = {"A","2","3","4","5","6","7","Knave","Knight","King"};
    private String [] suits = {"Swords", "Cups", "Coins", "Clubs"};
    private ArrayList<Card> cards; // = new ArrayList<Card>();

    // static boolean firstThread = true;
    
    public ItalianDeck(){
    	cards = new ArrayList<Card>();
        for (int i = 0; i < suits.length; i++) {
            for(int j = 0; j < values.length; j++){
                this.cards.add(new Card(suits[i], values[j]));
            }
        }
        //shuffle the deck when its created
        //Collections.shuffle(this.cards);
    }
    /*
    public void getRandomCard() {
    	System.out.println(cards.get(Casuale.randomInt(0, cards.size() - 1)).toString());
    }
    
    public void shuffleDeck() {
    	Collections.shuffle(this.cards);
    }

    public ArrayList<Card> getDeck(){
        return cards;
    }
    */
}
