package it.unibs.ing.fp.equities;

import java.io.Serializable;
import java.util.Vector;
import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class TitleList </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v3.0
 * @since 2016-05-24
 */

public class TitleList implements Serializable {
	//	private static final String TITLE_FRAME = "ELENCO TITOLI";
	//	private static final String [] NAME_HEADING = {"Titoli", "Valore Iniziale", "Valore Casuale"};

	private Vector <Title> elencoTitoli;
	
	public TitleList() {
		elencoTitoli = new Vector <Title> ();
	}
	
	public void addTitle(Title title) {
		elencoTitoli.add(title);
	}
	
	public Title getTitle(int i) {
		return elencoTitoli.get(i);
	}
	
	public int getSize() {
		return elencoTitoli.size();
	}
	
	public void setRandomValues() {
		for(int i = 0; i < elencoTitoli.size(); i++) elencoTitoli.get(i).setRandomValue();
	}
	
	//	TO_STRING
	/*
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
		for(int i = 0; i < elencoTitoli.size(); i++) result.append(elencoTitoli.get(i).toString());
		return result.toString();
	}
	*/
}
