package it.unibs.ing.fp.highestcard;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class HighestCardMain </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-05-03
 */

public class HighestCard {
	private final static String [] ITA_VALUES = {"A","2","3","4","5","6","7","Knave","Knight","King"};
    private final static String [] ITA_SUITS = {"Swords", "Cups", "Coins", "Clubs"};
	
	private final static String INTRO = "";
	
	private final static String MSG_BALANCE = "";
	private final static double MIN_BALANCE = 0.01;
	
	private final static String FIRST_CHOISE = "Quale tipo di carte preferisci: Italiane [I] o Francesi [F] ?";
	private final static String VALID_CHAR = "IF";

	private final static String CHOISE_ERR = "Attenzione: inserimento errato";
	
	public static Gamer makeGamer() {
		double balance = InputData.readDoubleWithMin(MSG_BALANCE, MIN_BALANCE);
		return new Gamer(balance);
	}
	
	public static void firstChoise() {
		char operation = InputData.readCharLimitedNotSensitive(FIRST_CHOISE, VALID_CHAR);
		switch (operation) {
		case 'i' :
		case 'I' : 
			// ItalianDeck deckIt = new ItalianDeck();
			String [] suits = ITA_SUITS;
			String [] values = ITA_VALUES;
			break;
		case 'f' :
		case 'F' :
			// FrenchDeck deckF = new FrenchDeck();
			break;
		default :
			System.out.println(CHOISE_ERR);
		}
		// return new Deck(values, suits);
	}
	
	public static void next() {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Saluto
		
		// firstChoise
		/*
        FrenchDeck fdeck = new FrenchDeck();

        //print out the deck.
        System.out.println(fdeck.getDeck());
        fdeck.shuffleDeck();
        System.out.println(fdeck.getDeck());
        fdeck.shuffleDeck();
        System.out.println(fdeck.getDeck());
        fdeck.getRandomCard();
        */
		if(true) {
			String [] values = ITA_VALUES;
			String [] suits = ITA_SUITS;
		}
		
		/*
		 * Deck deck = new Deck(values, suits);
		 * System.out.println(itaDeck.getDeck());
		 * System.out.println(itaDeck.getRandomCard());
		 */
		
    }
}
