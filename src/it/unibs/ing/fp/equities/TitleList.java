package it.unibs.ing.fp.equities;

import java.util.Vector;

import it.unibs.ing.fp.library.Formatting;
import it.unibs.ing.fp.library.Menu;

public class TitleList {
	private static final String TITLE_FRAME = "ELENCO TITOLI";
	private static final String [] NAME_HEADING = {"Titoli", "Valore Iniziale", "Valore Casuale"};
	
	private Vector <Title> elencoTitoli;
	
	public TitleList() {
		elencoTitoli = new Vector <Title> ();
	}
	
	public void addTitle(Title title) {
		elencoTitoli.add(title);
	}
	
	public void removeTitle(Title title) {
		elencoTitoli.remove(title);
	}
	
	public void setRandomValues() {
		for(int i = 0; i < elencoTitoli.size(); i++) elencoTitoli.get(i).setRandomValue();
	}
	
	public boolean isEmpty() {
		return(elencoTitoli.size() == 0);
	}
	
	//	MENU
	
	private String [] getTitleNames() {
		String [] result = new String[elencoTitoli.size()];
		for(int i = 0; i < result.length; i++) result[i] = elencoTitoli.get(i).getName();
		return result;
	}
	
	public Title choiceTitle(String question) {
		String [] elencoNomiTitoli = getTitleNames();
		Menu choiceList = new Menu(question, elencoNomiTitoli);
		int choiceUser = choiceList.choice();
		if(choiceUser == 0) return null;
		else return elencoTitoli.get(choiceUser - 1);
	}
	
	//	TO_STRING
	
	private static String heading() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn("", EquitiesMain.WIDTH_FIRST_COLUMN));
		for (int i = 0; i < NAME_HEADING.length; i++) {
			result.append(Formatting.centered(NAME_HEADING[i], EquitiesMain.WIDTH_OTHER_COLUMN));
		}
		return result.toString();
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.framing(TITLE_FRAME));
		result.append(heading());
		for(int i = 0; i < elencoTitoli.size(); i++) elencoTitoli.get(i).toString();
		return result.toString();
	}
}
