package it.unibs.ing.fp.equities;

import java.io.Serializable;

/**
 * <h1> Class Container </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v3.0
 * @since 2016-05-24
 */

public class Container implements Serializable{
	private TitleList elencoTitoli;
	private Wallet portafoglio;
		
	public Container (TitleList elencoTitoli, Wallet portafoglio) {
		this.elencoTitoli = elencoTitoli;
		this.portafoglio = portafoglio;		
	}
		
	public TitleList getTitleList() {
		return elencoTitoli;
	}
		
	public Wallet getWallet() {
		return portafoglio;
	}
}
