package it.unibs.ing.fp.trafficsimulation;

public class Vehicle extends Element {
	final static String SIMBOLOAUTO = ">";
	final static int VELOCITAORIZZONTALE = 2;
	final static int RESISTENZAAUTO = 1;

	public Vehicle() {
		super(SIMBOLOAUTO,RESISTENZAAUTO,true);
	}
			
	public Coordinates getProssimaPosizione(int rigaAttuale, int colonnaAttuale) {
		return new Coordinates(rigaAttuale, colonnaAttuale + VELOCITAORIZZONTALE);
	}
}
