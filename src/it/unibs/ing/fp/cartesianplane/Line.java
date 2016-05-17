package it.unibs.ing.fp.cartesianplane;

// La linea è in relazione COMPOSED OF con la classe punto

/**
 * <h1>Class Line</h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-03-15
 */
public class Line {
	// y = mx + q
	private Point p1;
	private Point p2;
	
	/**
	 * Constructor.
	 * @param p1 - The first Point
	 * @param p2 - The second Point
	 */
	public Line(Point p1, Point p2) {
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Returns the distance between two points.
	 * @return the distance
	 */
	public double getDistance() {
		System.out.print("d = ");
		return Math.sqrt(Math.pow((p1.getX() - p2.getX()), 2) + 
						 Math.pow((p1.getY() - p2.getY()), 2));
	}
	
	// Metodo Check Point diversi
	public boolean pointDifferent() {
		if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) return false;
		else return true;
	}
	
	// Metodo Check Line verticale
	public boolean verticalLine() {
		if(pointDifferent() == true && p1.getX() == p2.getX()) return true;
		else return false;
	}
	
	/**
	 * Returns the factor of Line passing through two points.
	 * @return factor
	 */
	public double factor() {
		return (p2.getY() - p1.getY())/
			    (p2.getX() - p1.getX());
	}
	
	/**
	 * returns the term of Line passing through two points.
	 * @return term
	 */
	public double term() {
		if(verticalLine() == true) return p1.getX();
		else return p2.getY() - factor()*p2.getX();
	}
	
	@Override
	public String toString() {
		// Condizione in cui la retta è verticale e quindi return x = q
		if (verticalLine() == true) return "x = " + term();
		
		// Condizione in cui la retta è orizzontale e quindi return y = q
		else if (factor() == 0) return "y = " + term();
		
		// Condizione in cui termineNoto = 0 e quindi y = mx
		else if (term() == 0) return "y = " + String.format("%.2f", factor()) + "x";
		
		// Condizione in cui il termineNoto è negativo e quindi y = mx - q
		else if (term() < 0) return "y = " + String.format("%.2f", factor()) + "x - " + String.format("%.2f", Math.abs(term()));
		else return "y = " + String.format("%.2f", factor()) + "x + " + String.format("%.2f", term()); 
	}
	
	// Metodo Check Appartenenza punto & retta
	public String itBelongs(Point p1, Line l1) { 
		if (p1.getY() == l1.factor() * p1.getX() + l1.term()) return p1.toString() + " ∈ r : " + l1.toString();
		else return p1.toString() + " ∉ r : " + l1.toString();
	}

}
