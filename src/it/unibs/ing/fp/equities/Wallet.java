package it.unibs.ing.fp.equities;

import java.io.Serializable;
import java.util.Vector;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.library.Menu;

/**
 * <h1> Class Wallet </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v3.0
 * @since 2016-05-24
 */

public class Wallet implements Serializable {
	private static final String [] NAME_HEADING = {"Titoli", "Quantità", "Valore Iniziale", "Valore Casuale"};
	private static final String TITLE_FRAME = "PORTAFOGLIO DI ";
	private static final String SUB_TITLE_FRAME = null;
	
	private String name;
	private TitleList elencoTitoli;
	private Vector <ItemOwned> elencoTitoliAcquisiti;
	
	public Wallet(String name, TitleList elencoTitoli) {
		this.name = name;
		this.elencoTitoli = elencoTitoli;
		elencoTitoliAcquisiti = new Vector<ItemOwned>();
	}
	
	//	GETTERS
	
	/**
	 * @return the totalInitialBatch
	 */
	public double getTotalInitialBatch() {
		double totalInitialBatch = 0;
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) {
			totalInitialBatch += elencoTitoliAcquisiti.get(i).getTotalInizialValue();
		}
		return totalInitialBatch;
	}
	
	/**
	 * @return the totalRandomBatch
	 */
	public double getTotalRandomBatch() {
		double totalRandomBatch = 0;
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) {
			totalRandomBatch += elencoTitoliAcquisiti.get(i).getTotalRandomValue();
		}
		return totalRandomBatch;
	}
	
	//	MANAGEMENT

	public void addItemOwned(ItemOwned lotto) {
		elencoTitoliAcquisiti.addElement(lotto);
	}
	
	public void simulationChange() {
		elencoTitoli.setRandomValues();
	}

	//	TO_STRING
	
	private static String heading() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn("", EquitiesMain.WIDTH_FIRST_COLUMN));
		for(int i = 0; i < NAME_HEADING.length; i++) {
			result.append(Formatting.centered(NAME_HEADING[i], EquitiesMain.WIDTH_OTHER_COLUMN));
		}
		return result.toString();
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.framing(TITLE_FRAME + name));
		result.append(heading());
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) elencoTitoliAcquisiti.get(i).toString();
		result.append(Formatting.framing(SUB_TITLE_FRAME));
		result.append(Formatting.indentation(String.valueOf(getTotalInitialBatch()), EquitiesMain.WIDTH_INDENTATION));
		result.append(Formatting.centered(String.valueOf(getTotalRandomBatch()), EquitiesMain.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
}
