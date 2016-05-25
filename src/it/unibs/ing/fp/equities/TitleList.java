package it.unibs.ing.fp.equities;

import java.util.Vector;

public class TitleList {
	private Vector <Title> elencoTitoli;
	
	public TitleList() {
		elencoTitoli = new Vector <Title> ();
	}
	
	public void addTitle(Title title) {
		elencoTitoli.add(title);
	}
	
	//	Metodo Variazione valore titoli
	
	public String toString() {
		StringBuffer result = new StringBuffer();
		
		return result.toString();
	}
}
