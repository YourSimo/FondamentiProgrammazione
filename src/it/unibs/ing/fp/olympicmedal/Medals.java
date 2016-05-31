package it.unibs.ing.fp.olympicmedal;

import it.unibs.ing.fp.library.Formatting;

/**
 * <h1> Class Medals </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini
 * @author Simone Cavicchioli 
 * @version v2.0
 * @since 2016-05-10
 */

public class Medals {
	public final static int WIDTH_FIRST_COLUMN = 12;
	public final static int WIDTH_MEDAL_COLUMN = 9;
	
	public final static int NUM_MEDALS = 3;
	public final static String [] NAME_MEDALS = {"ORO", "ARGENTO", "BRONZO"};
	
	public static String heading() {
		StringBuffer result = new StringBuffer();
		result.append(Formatting.inColumn("", WIDTH_FIRST_COLUMN));
		for (int i = 0; i < NAME_MEDALS.length; i++)
			result.append(Formatting.centered(NAME_MEDALS[i], WIDTH_MEDAL_COLUMN));
		return result.toString();
	}
}
