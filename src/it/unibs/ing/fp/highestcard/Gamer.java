package it.unibs.ing.fp.highestcard;

public class Gamer {
	private String nickname;
	private double balance;
	
	public Gamer(double balance) {
		this.setBalance(balance);
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
}
