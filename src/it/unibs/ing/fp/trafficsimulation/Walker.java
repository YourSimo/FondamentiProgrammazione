package it.unibs.ing.fp.trafficsimulation;

public class Walker extends Element {
	final static String SIMBOLOPEDONE = "*";
	final static int VELOCITAVERTICALE = 1;
	final static int RESISTENZAPEDONE = 2;

	public Walker() {
		super(SIMBOLOPEDONE, RESISTENZAPEDONE, true);
	}
			
	public Coordinates getProssimaPosizione(int rigaAttuale, int colonnaAttuale) {
		return new Coordinates(rigaAttuale + VELOCITAVERTICALE,colonnaAttuale);
	}
}
