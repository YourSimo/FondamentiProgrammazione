package it.unibs.ing.fp.trafficsimulation;

public class Empty extends Element {
	final static String SPAZIO = " ";
	final static int RESISTENZAVUOTO = 0;

	public Empty() {
		super(SPAZIO, RESISTENZAVUOTO, false);
	}
			
	public Coordinates getProssimaPosizione (int posizioneAttualeX, int posizioneAttualeY) {
		return new Coordinates(posizioneAttualeX,posizioneAttualeY);
	}
}
