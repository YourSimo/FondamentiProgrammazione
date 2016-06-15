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
	private static final String [] NAME_HEADING = {"Titoli", "Qtà", "Val.Inz.", "Val.Casuale"};
	private static final String TITLE_FRAME = "PORTAFOGLIO DI ";
	//	private static final String SUB_TITLE_FRAME = "-";
	
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
	
	public double getFinalResult() {
		return getTotalRandomBatch() - getTotalInitialBatch();
	}
	
	//	MANAGEMENT

	public void addItemOwned(ItemOwned lotto) {
		elencoTitoliAcquisiti.addElement(lotto);
	}
	
	public void simulationChange() {
		elencoTitoli.setRandomValues();
	}

	//	HEADING: Titoli        Qtà          Val.Inz.     Val.Casuale
	
	private static String heading() {
		StringBuffer result = new StringBuffer();
		result.append("\n"+ Formatting.inColumn(NAME_HEADING[0], EquitiesMain.WIDTH_FIRST_COLUMN));
		for(int i = 1; i < NAME_HEADING.length; i++) {
			result.append(Formatting.centered(NAME_HEADING[i], EquitiesMain.WIDTH_OTHER_COLUMN));
		}
		return result.toString();
	}
	
	//	TOTALS:                           TOT. 25,12   TOT. 60,08
	
	private String totals() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.indentation("TOT. " + String.valueOf(String.format("%.2f", getTotalInitialBatch())), EquitiesMain.WIDTH_INDENTATION));
		result.append(Formatting.centered("TOT. " + String.valueOf(String.format("%.2f", getTotalRandomBatch())), EquitiesMain.WIDTH_OTHER_COLUMN));
		result.append(Formatting.centered("SALDO " + String.valueOf(String.format("%.2f", getFinalResult())), EquitiesMain.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
	
	//	TO_STRING
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.framing(TITLE_FRAME + name.toUpperCase()));
		result.append(heading());
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) result.append("\n" + elencoTitoliAcquisiti.get(i).toString());
		result.append("\n" + Formatting.framing(totals()));
		return result.toString();
	}
}
