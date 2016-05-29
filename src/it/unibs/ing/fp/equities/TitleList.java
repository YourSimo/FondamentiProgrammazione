package it.unibs.ing.fp.equities;

import java.util.Vector;

import it.unibs.ing.fp.library.Formatting;

public class TitleList {
	private static final String TITLE_FRAME = "ELENCO TITOLI";
	private static final String [] NAME_HEADING = {"Titoli", "Quantità", "Valore Iniziale", "Valore Casuale"};
	
	public static final int WIDTH_FIRST_COLUMN = 7;
	public static final int WIDTH_OTHER_COLUMN = 7;
	
	private Vector <Title> elencoTitoli;
	
	public TitleList() {
		elencoTitoli = new Vector <Title> ();
	}
	
	public void addTitle(Title title) {
		elencoTitoli.add(title);
	}
	
	//	Metodo Variazione valore titoli
	
	private static String heading() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn("", WIDTH_FIRST_COLUMN));
		for (int i = 0; i < NAME_HEADING.length; i++)
			result.append(Formatting.centered(NAME_HEADING[i], WIDTH_OTHER_COLUMN));
		return result.toString();
	}
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.framing(TITLE_FRAME));
		result.append(heading());
		for(int i = 0; i < elencoTitoli.size(); i++) {
			elencoTitoli.get(i).toString();
		}
		return result.toString();
	}
}
