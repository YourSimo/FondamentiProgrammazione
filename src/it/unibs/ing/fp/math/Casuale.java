package it.unibs.ing.fp.math;

import java.util.Random;

/**
 * <h1>Class Casuale</h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0 
 * @since 2016-04-12
 *
 */

public class Casuale {
	
	private static Random estrattore = new Random();
	
	/**
	 * Returns a random int value between a minimum and maximum value.
	 * @param min - The min value
	 * @param max - The max value
	 * @return the random value
	 */
	public static int randomInt(int min, int max)
	{
		 int range = max + 1 - min;
		 int casual = estrattore.nextInt(range);
		 return casual + min;
	}

}
