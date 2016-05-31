package it.unibs.ing.fp.equities;

import it.unibs.ing.fp.library.Formatting;

public class ItemOwned {
	private Title title;
	private int amount;	// maggiore di 1
	
	public ItemOwned(Title title, int amount) {
		this.title = title;
		this.amount = amount;
	}
	
	//	GETTERS

	/**
	 * @return the title
	 */
	public Title getTitle() {
		return title;
	}
	
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	
	//	SETTERS

	/**
	 * @param title - The title to set
	 */
	public void setTitle(Title title) {
		this.title = title;
	}
	
	/**
	 * @param amount - The amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	//	TO_STRING

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn(title.getName().toUpperCase(), EquitiesMain.WIDTH_FIRST_COLUMN));
		result.append(Formatting.centered(String.valueOf(amount), EquitiesMain.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(title.getInitialValue()), EquitiesMain.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(title.getRandomValue()), EquitiesMain.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
}
