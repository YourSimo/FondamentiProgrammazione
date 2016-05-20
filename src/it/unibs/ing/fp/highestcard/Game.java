package it.unibs.ing.fp.highestcard;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class Game </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * @author 
 * @version v1.1
 * @since 2016-05-03
 */

public class Game {
	private final static String DOMANDA_CONTINUA = "Vuoi continuare a giocare ?";
	private final static String MSG_BALANCE = "Il tuo patrimonio attuale e' di euro: ";
	private final static String MSG_BALANCE_END = "Il tuo patrimonio finale e' di euro: ";
	private final static String MSG_FINISH = "Mi spiace la partita non puo' continuare";
	private final static String MSG_CARD_USER = "Hai pescato: ";
	private final static String MSG_CARD_PC = "Il computer ha pescato: ";

	private final static String MSG_BET = "Quanti euro vuoi scommettere? ";
		
	private final static String MSG_WIN = " hai vinto!";
	private final static String MSG_LOSE = " hai perso!";
	private final static String MSG_PAR = "Carte pari: procediamo ad un'altra estrazione dallo stesso mazzo";
	
	private Player player;
	private Deck deck;
	
	public Game(Player player, Deck deck) {
		this.player = player;
		this.deck = deck;
	}
	
	private void oneGame() {
		boolean finish = false;
		do {
			Card utente = deck.getRandomCard();
			System.out.println(MSG_CARD_USER + utente.toString());
			double scommessa = InputData.readDoubleWithLimit(MSG_BET, 1, player.getBalance());
			Card computer = deck.getRandomCard();
			System.out.println(MSG_CARD_PC + computer.toString());
			int confronto = utente.compareTo(computer);
				
			if (confronto > 0) {
				player.setBalance(player.getBalance() + scommessa);
				System.out.println(player.getNickname() + MSG_WIN);
				finish = true;
			}
			else if (confronto < 0) {
				player.setBalance(player.getBalance() - scommessa);
				System.out.println(player.getNickname() + MSG_LOSE);
				finish = true;
			}
			else System.out.println(MSG_PAR);
			 
			System.out.println(MSG_BALANCE + player.getBalance());
			 
		} while(!finish);
	}
	 
	public void esegui() { 
		boolean next = true;
		do {
			oneGame();
			if (player.getBalance() == 0) {
				next = false;
				System.out.println(MSG_FINISH);
			}
			else next = InputData.yesOrNo(DOMANDA_CONTINUA);
					
		} while (next);
		System.out.println(MSG_BALANCE_END + player.getBalance());
	 }
}
