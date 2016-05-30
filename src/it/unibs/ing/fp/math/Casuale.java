package it.unibs.ing.fp.math;

import java.util.Random;

/**
 * <h1> Class Casuale </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0 
 * @since 2016-04-12
 */

public class Casuale {
	
	private static Random extractor = new Random();
	
	/**
	 * Returns a random int value between a minimum and maximum value.
	 * @param min - The min value
	 * @param max - The max value
	 * @return the random int value
	 */
	public static int randomInt(int min, int max) {
		 int range = max + 1 - min;
		 int random = extractor.nextInt(range);
		 return random + min;
	}
	
	/**
	 * Returns a random double value between a minimum and maximum value.
	 * @param min - The min value
	 * @param max - The max value
	 * @return the random double value
	 */
	public static double randomDouble(double min, double max) {
		double range = max + 1 - min;
		double random = extractor.nextDouble();
		double result = range * random;
		return result + min;
	}

}
