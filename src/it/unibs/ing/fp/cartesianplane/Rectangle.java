package it.unibs.ing.fp.cartesianplane;

public class Rectangle {
	private Point AngoloDownSx = null;
	protected double base = 0;
	protected double height = 0;
	
	public Rectangle(Point p1, double base, double height) {
		AngoloDownSx = p1;
		this.base = base;
		this.height = height;
	}
	
	public Rectangle(Point p1, Point p2) {
		this(p1, p2.getX() - p1.getX(), p2.getY() - p1.getY());
	}
	
	public double getPerimeter() {
		return 2 * (base + height);
	}
	
	public double getArea() {
		return base * height;
	}

}
