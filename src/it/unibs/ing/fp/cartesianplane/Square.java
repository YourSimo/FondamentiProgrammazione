package it.unibs.ing.fp.cartesianplane;

// Square: classe figlia;
// Rectangle: classe madre (super);
public class Square extends Rectangle{
	
	// Costruttore
	public Square(Point p1, double side) {
		super(p1, side, side);
	}
	
	@Override
	public double getPerimeter() {
		return 4 * base;
	}

}
