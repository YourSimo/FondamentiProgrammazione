package it.unibs.ing.fp.trafficsimulation;

import it.unibs.ing.fp.library.Formatting;

public class Road {
    final static double PROB_AUTO = 0.1;
	final static double PROB_PEDONE = 0.1;
	
	final static char SEPARATORE = '|';
	final static char ELEMENTOCORNICE = '-';
	final static char SPAZIO = ' ';
	final static int LARGHEZZACASELLA = 4;
	
	final static String MESSAGGIOCOLLISIONE = "ATTENZIONE! COLLISIONE IN POSIZIONE:";
	
	private int numRighe;
	private int numColonne;
	private Element[][] mappa; 
	
	public Road(int dimensioneR, int dimensioneC) {
	    numRighe = dimensioneR;
		numColonne = dimensioneC;
		mappa = new Element[dimensioneR][dimensioneC]; 
	}
	
	public void inizializza() {
		for ( int x = 0; x < mappa.length; x++ ) {
			for ( int y = 0; y < mappa[x].length; y++ ) {
				mappa[x][y] = oggettoCasuale();
			}			
		}
	}
	
	private Element oggettoCasuale() {
		double casuale = Math.random();
		
		if(casuale <  PROB_AUTO) {
			return new Vehicle();
		}
		else if (casuale < (PROB_AUTO+PROB_PEDONE)) {
			return new Walker(); 
		}
		else {
			return new Empty(); 
		}
	}
		
	public void evoluzione() {
		Element[][] prossimaMappa = mappaVuota(mappa.length, mappa[0].length);
		
		for(int x = 0; x < mappa.length; ++x) {
			for(int y = 0; y < mappa[x].length; ++y) {
				Element esaminato = mappa[x][y];
				Coordinates prossimaPosizione = esaminato.getProssimaPosizione(x,y);
				if (prossimaPosizione.isInside(mappa.length,mappa[x].length)) {
					Element altro = prossimaMappa[prossimaPosizione.getLine()][prossimaPosizione.getColumn()];
					if (esaminato.collisioneCon(altro)) {
						System.out.println(MESSAGGIOCOLLISIONE + prossimaPosizione.toString());
					}
					if (esaminato.prevaleSu(altro)) {
						piazzaElemento(esaminato, prossimaPosizione, prossimaMappa);
					}
				}
			}		
		}
		mappa = prossimaMappa;
	}

	public String toString() {
		StringBuffer descrizione = new StringBuffer();
		String cornice = Formatting.cloneChar(ELEMENTOCORNICE, LARGHEZZACASELLA*(mappa[0].length+1));
		String rientro = Formatting.cloneChar(SPAZIO, LARGHEZZACASELLA);
		
		descrizione.append(rientro); // SPAZI INIZIALI SULLA RIGA DEI NUMERI COLONNA
		
		for (int i = 1; i <= mappa[0].length; i++) // RIGA CON I NUMERI DI COLONNA
			descrizione.append(Formatting.centered(Integer.toString(i), LARGHEZZACASELLA));
			
		descrizione.append(Formatting.rowIsolated(cornice));
		
		for ( int x = 0; x < mappa.length; ++x ) {
			descrizione.append(Formatting.centered(Integer.toString(x+1),LARGHEZZACASELLA)); // NUMERO DI RIGA
			
			for ( int y = 0; y < mappa[x].length; ++y ) {
				descrizione.append(Formatting.centered(mappa[x][y].toString(),LARGHEZZACASELLA));
			}
			descrizione.append(Formatting.rowIsolated(cornice));	 
		}
		return descrizione.toString();
	}	
	
	public void piazzaElemento (Element daPiazzare, Coordinates dovePiazzarlo, Element[][] nuovaMappa) {
		nuovaMappa[dovePiazzarlo.getLine()][dovePiazzarlo.getColumn()] = daPiazzare;
	}
 
	private Element [][] mappaVuota(int numRighe, int numColonne) {
		Element [][] newMap = new Element[numRighe][numColonne];
		for(int x = 0; x < newMap.length; ++x) {
			for(int y = 0; y < newMap[x].length; ++y) {
				newMap[x][y] = new Empty();
			}
		}
		return newMap;
	}
}
