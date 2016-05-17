package it.unibs.ing.fp.cartesianplane;

/**
 * <h1>Class Point</h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-03-15
 */

public class Point {
	
	private double x = 0.0;
	private double y = 0.0;
	
	/**
	 * Constructor.
	 * @param x - The x coordinate
	 * @param y - The y coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Returns the x coordinate.
	 * @return x coordinate
	 */
	public double getX() {
		return x;
	}
	
	/**
	 * Returns the y coordinate.
	 * @return y coordinate
	 */
	public double getY() {
		return y;
	}
	
	@Override
	public String toString() {
		return "(" + x + ";" + y + ")";
	}
}
