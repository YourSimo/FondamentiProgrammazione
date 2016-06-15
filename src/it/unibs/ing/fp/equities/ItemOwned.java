package it.unibs.ing.fp.equities;

import java.io.Serializable;
import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class ItemOwned </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v3.0
 * @since 2016-05-24
 */

public class ItemOwned implements Serializable {
	private Title title;
	private int amount;	// maggiore di 1
	
	public ItemOwned(Title title, int amount) {
		this.title = title;
		this.amount = amount;
	}
	
	//	GETTERS
	
	public double getTotalInizialValue() {
		return amount * title.getInitialValue();
	}
	
	public double getTotalRandomValue() {
		return amount * title.getRandomValue();
	}
	
	//	TO_STRING: ENEL           3             0.04          0,105

	@Override
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn(title.getName().toUpperCase(), EquitiesMain.WIDTH_FIRST_COLUMN));
		result.append(Formatting.centered(String.valueOf(amount), EquitiesMain.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(title.getInitialValue()), EquitiesMain.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered(String.valueOf(String.format("%.3f", title.getRandomValue())), EquitiesMain.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
}
