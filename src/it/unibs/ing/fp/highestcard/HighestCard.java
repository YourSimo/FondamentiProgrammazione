package it.unibs.ing.fp.highestcard;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.library.Menu;

/**
 * <h1> Class HighestCardMain </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-05-03
 */

public class HighestCard {
	private final static String NOMEIT = "ITALIANE";
	private final static String [] IT_VALUES = {"A","2","3","4","5","6","7","Knave","Knight","King"};
    private final static String [] IT_SUITS = {"Swords", "Cups", "Coins", "Clubs"};
    
    
    private final static String NOMEFR = "FRANCESI";
    private final static String [] FR_VALUES = {"A","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
    private final static String [] FR_SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
	
	private final static String INTRO = "BENVENUTO AL GIOCO DELLA CARTA PIU' ALTA";
	
	private final static String INTESTA_TIPI = "SELEZIONE DEL TIPO DI CARTE DA USARE";
	private final static String MSG_START = "INIZIO PARTITA";
	
	private final static String MSG_NOME = "Inserisci il tuo nome:";
	private final static String MSG_BALANCE = ", con quanti euro vuoi giocare? ";
	private final static double MIN_BALANCE = 0.01;
	
	public final static String [] NOMI_ESISTENTI = {NOMEIT, NOMEFR};
	
	
	
	// private final static String FIRST_CHOISE = "Quale tipo di carte preferisci: Italiane [I] o Francesi [F] ?";
	// private final static String VALID_CHAR = "IF";

	private final static String CHOISE_ERR = "Attenzione: inserimento errato";
	
	private static void play(Deck type) {
		System.out.println(MSG_START);
		String nomeUtente = InputData.readStringNotEmpty(MSG_NOME);
		double soldiIniziali = InputData.readDoubleWithMin(nomeUtente + MSG_BALANCE, MIN_BALANCE);
		
		Player player = new Player(nomeUtente, soldiIniziali);
		Game game = new Game(player, type);
		game.esegui();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hello.sayHello(INTRO);
		
		Deck itDeck = new Deck(IT_VALUES, IT_SUITS);
		Deck frDeck = new Deck(FR_VALUES, FR_SUITS);
		
		Menu mainMenu = new Menu(INTESTA_TIPI, NOMI_ESISTENTI);
		
		boolean finish = false;
		do {
			int selezione = mainMenu.choise();
			switch (selezione) {
				case 1: 
					play(itDeck);
					break;
				case 2: 
					play(frDeck);
					break;
				case 0:
					finish = true;
					break;
				default:
					System.out.println(CHOISE_ERR);
			} 
		} while (!finish);
    }
}
