package it.unibs.ing.fp.highestcard;

/**
 * <h1> Class Player </h1>
 * <p>
 * 
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
	
	/**
	 * @return the nickname
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname - The nickname to set
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance - The balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
