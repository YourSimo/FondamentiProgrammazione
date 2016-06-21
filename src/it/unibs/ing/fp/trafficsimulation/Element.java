package it.unibs.ing.fp.trafficsimulation;

public abstract class Element {
	private String descrizione;
	private int resistenza;
	private boolean solido;

	public Element(String d, int r, boolean s) {
		 descrizione = d;
		 resistenza = r;
		 solido = s;		
	 }

	public boolean prevaleSu (Element altro) {
		return this.resistenza > altro.resistenza;
	}

	public boolean collisioneCon (Element altro) {
		return this.solido && altro.solido;
	}

	public String toString() {
		return descrizione;
	}

	public abstract Coordinates getProssimaPosizione (int posizioneAttualeX, int posizioneAttualeY);

}
