package it.unibs.ing.fp.math;

/**
 * <h1> Class Complesso </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.1
 * @since 2016-03-08
 */

public class Complesso {
	private double re;
	private double img;
	
	/**
	 * Constructor.
	 * @param re - The real part
	 * @param img - The imaginary part
	 */
	public Complesso(double re, double img) {
		this.re = re;
		this.img = img;
	}
	
	/**
	 * Constructor.
	 * @param re - The real part
	 */
	public Complesso(double re) {
		this.re = re;
	}
	
	/**
	 * Constructor.
	 */
	public Complesso() {
		re = 0;
		img = 0;
	}
	
	/**
	 * Sets the real part.
	 * @param re - The real part
	 */
	public void setReale(double re) {
		this.re = re;
	}

	/**
	 * Sets the imaginary part.
	 * @param img
	 */
	public void setImmaginario(double img) {
		this.img = img;
	}
		
	// Metodi Getters
	
	/**
	 * Returns the real part.
	 * @return real part
	 */
	public double getReale() {
		return re;
	}
	
	/**
	 * Returns the imaginary part.
	 * @return imaginary part
	 */
	public double getImmaginario() {
		return img;
	}
	
	/**
	 * Returns the module.
	 * @return (module)^2
	 */
	public double getModulo() {
		double modulo2 = re * re + img * img;
		return (Math.sqrt(modulo2));
	}
	
	// Metodo main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Complesso c1 = new Complesso(5,1);
		// Complesso c2 = new Complesso();
		// Complesso c3 = new Complesso(5);
		
		// Classe.oggetto.metodo
		System.out.println("Parte reale : Re = " + c1.getReale());
		System.out.println("Parte immaginaria : Im = " + c1.getImmaginario());
		System.out.println("Modulo : |Z| = " + c1.getModulo());
	}

}
