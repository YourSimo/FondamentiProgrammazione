package it.unibs.ing.fp.bankaccount;

/**
 * <h1>Class BankAccount</h1>
 * <p>
 * 
 * @author Simone Cavicchioli <s.cavicchioli@studenti.unibs.it>
 * @version v2.0
 * @since 2016-03-15
 *
 */

public class BankAccount {
	private final static String MSG = "Il suo bilancio è di: %.2f€\n";
	private final static String MSG_INSUFF_CREDIT = "Attenzione credito insufficiente!\n";
	private final static String MSG_WITHDRAW = "Prelevato %.2f€\n";
	private final static double DEFAULT_BALANCE = 1000;
	
	private Person owner;
	private double balance = 0.00;

	/**
	 * Constructor.
	 * @param owner - The owner of BankAccount
	 * @param balance
	 */
	public BankAccount(Person owner, double balance) {
		this.owner = owner;
		this.balance = balance;
	}
	
	/**
	 * Constructor.
	 * @param owner The owner of BankAccount
	 */
	public BankAccount(Person owner) {
		this(owner, 0);
	}
	
	/**
	 * Returns the balance.
	 * @return balance
	 */
	public double getBalance() {
		return balance;
	}
	
	/**
	 * Returns the incremental balance of a certain amount.
	 * @param amount - The amount of money to increase the balance
	 * @return final balance
	 */
	public double deposit(double amount) {
		return balance += amount;
	}
	
	/**
	 * Returns the balance 
	 * <tt>if</tt> the amount of money to be taken is greater than the balance,  
	 * <tt>else</tt> the amount of money.
	 * @param amount - The amount of money 
	 * @return the balance or the amount of money taken
	 */
	public double withdraw(double amount) {
		double result = amount;
		if (result > balance) {
			result = balance;
			System.out.print(MSG_INSUFF_CREDIT);
		}
		else {
			balance -= result;
			System.out.printf(MSG_WITHDRAW, result);
		}
		return result;
	}
	
	/**
	 * Prints the balance of Object BankAccount.
	 * @param ba - The Object BankAccount
	 */
	public static void printBalance(BankAccount ba) {
		System.out.printf(MSG, ba.getBalance());
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Person p1 = new Person("Simone", "Cavicchioli", "M", "06/09/1996", "MN", "Italy");
		
		BankAccount ba1 = new BankAccount(p1,  DEFAULT_BALANCE);
		
		System.out.println(p1.getHello(p1.getNationality()) + p1.getOwner());
		
		printBalance(ba1);
		
		ba1.deposit(100.52);
		printBalance(ba1);
		
		ba1.withdraw(2000);
		printBalance(ba1);
		
		ba1.withdraw(400);
		printBalance(ba1);
	}
}
