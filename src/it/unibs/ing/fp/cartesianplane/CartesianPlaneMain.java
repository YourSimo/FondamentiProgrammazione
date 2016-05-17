package it.unibs.ing.fp.cartesianplane;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1>Class CartesianPlaneMain</h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-03-15
 */

public class CartesianPlaneMain {
	
	// Metodo creazione di un punto
	public static Point makePoint(String description) {
		double x = InputData.readDouble(description + ": inserisci la coordinata x ");
		double y = InputData.readDouble(description + ": inserisci la coordinata y ");
		return new Point(x, y);
	}
	
	// Metodo creazione di una retta
	public static Line makeLine(Point p1, Point p2) {
		return new Line(p1, p2);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Point A = makePoint("Coodinate Punto A");
		
		Point B = makePoint("Coordinate Punto B");
		
		// System.out.println("Distanza : " + String.format("%.2f", getDistance(A, B)));
		
		Line AB = makeLine(A, B);
		
		System.out.println("Distanza : " + String.format("%.2f", AB.getDistance()));
		
		// Stampa l'equazione della retta passante per i due punti
		System.out.println("Equazione : " + AB.toString());
		
		// Acquisisce un terzo punto
		
		Point C = makePoint("Coordinate Punto C");
		
		// Verificare che il terzo punto è allineato con gli altri due
		System.out.println("C = " + AB.itBelongs(C, AB));
	}
}

