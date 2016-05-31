package it.unibs.ing.fp.equities;

import java.util.Vector;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.library.Menu;

public class Wallet {
	private static final String [] NAME_HEADING = {"Titoli", "Quantità", "Valore Iniziale", "Valore Casuale"};

	private static final String TITLE_FRAME = "PORTAFOGLIO DI ";

	private static final String SUB_TITLE_FRAME = null;
	
	private String name;
	private Vector <ItemOwned> elencoTitoliAcquisiti;
	//	private double totalInitialBatch = 0;
	//	private double totalRandomBatch = 0;
	//	private int numAzioniAcquisite;
	
	public Wallet(String name) {
		this.setName(name);
		elencoTitoliAcquisiti = new Vector<ItemOwned>();
	}
	
	//	GETTERS
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the totalInitialBatch
	 */
	public double getTotalInitialBatch() {
		double totalInitialBatch = 0;
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) {
			totalInitialBatch += elencoTitoliAcquisiti.get(i).getAmount() * 
							elencoTitoliAcquisiti.get(i).getTitle().getInitialValue();
		}
		return totalInitialBatch;
	}
	
	/**
	 * @return the totalRandomBatch
	 */
	public double getTotalRandomBatch() {
		double totalRandomBatch = 0;
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) {
			totalRandomBatch += elencoTitoliAcquisiti.get(i).getAmount() * 
							elencoTitoliAcquisiti.get(i).getTitle().getRandomValue();
		}
		return totalRandomBatch;
	}
	
	//	SETTERS

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	//	MANAGEMENT

	public void addItemOwned(ItemOwned lotto) {
		elencoTitoliAcquisiti.addElement(lotto);
	}
	
	public void removeItemOwned(ItemOwned lotto) {
		elencoTitoliAcquisiti.remove(lotto);
	}
	
	//	MENU
	
	private String [] getItemOwnedNames() {
		String [] result = new String[elencoTitoliAcquisiti.size()];
		for(int i = 0; i < result.length; i++) result[i] = elencoTitoliAcquisiti.get(i).getTitle().getName();
		return result;
	}
	
	public ItemOwned choiceItemOwned(String question) {
		String [] elencoNomiTitoli = getItemOwnedNames();
		Menu choiceList = new Menu(question, elencoNomiTitoli);
		int choiceUser = choiceList.choice();
		if(choiceUser == 0) return null;
		else return elencoTitoliAcquisiti.get(choiceUser - 1);
	}
	
	
	// simulazione valore random
	

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
		result.append(Formatting.framing(TITLE_FRAME + getName()));
		result.append(heading());
		for(int i = 0; i < elencoTitoliAcquisiti.size(); i++) elencoTitoliAcquisiti.get(i).toString();
		result.append(Formatting.framing(SUB_TITLE_FRAME));
		result.append(Formatting.indentation(String.valueOf(getTotalInitialBatch()), EquitiesMain.WIDTH_INDENTATION));
		result.append(Formatting.centered(String.valueOf(getTotalRandomBatch()), EquitiesMain.WIDTH_OTHER_COLUMN));
		return result.toString();
	}
}
