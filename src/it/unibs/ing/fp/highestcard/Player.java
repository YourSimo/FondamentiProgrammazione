package it.unibs.ing.fp.highestcard;

/**
 * <h1> Class Player </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-05-03
 */

public class Player {
	private String nickname;
	private double balance;
	
	/**
	 * Constructor.
	 * @param nickname
	 * @param balance
	 */
	public Player(String nickname, double balance) {
		this.setNickname(nickname);
		this.setBalance(balance);
	}
	
	// Getters
	
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}
	
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}
	
	// Setters

	/**
	 * @param nickname - The nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * @param balance - The balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
