package it.unibs.ing.fp.library;

/**
 * <h1> Class Formatting </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v2.0
 * @since 2016-05-10
 */

public class Formatting {
	private final static String SPACE = " ";
	private final static String FRAME = "-";
	private final static String HEAD = "\n";

	/**
	 * Returns a String isolated. <p>
	 * Example:
	 * <blockquote><pre>
	 * (space)
	 * String
	 * (space)
	 * </pre></blockquote>
	 * 
	 * @param s - The String to isolate
	 * @return a String isolated 
	 */
	public static String rowIsolated(String s) {
		StringBuffer result = new StringBuffer();
		 result.append(HEAD);
		 result.append(s);
		 result.append(HEAD);
		 return result.toString();
	}
	
	/**
	 * Returns a String framed. <p>
	 * Example:
	 * <blockquote><pre>
	 * ------
	 * String
	 * ------
	 * </pre></blockquote>
	 * 
	 * @param s - The String to frame
	 * @return a String framed
	 */
	public static String framing(String s) {
		StringBuffer result = new StringBuffer();
		for(int i = 0; i < s.length(); i++) result.append(FRAME);
		result.append(HEAD + s + HEAD);
		for(int i = 0; i < s.length(); i++) result.append(FRAME);
		return result.toString();
	}

	/**
	 * Returns a String in column.
	 * @param s - The String to be placed in column
	 * @param width - The width of column
	 * @return a String in column
	 */
	public static String inColumn(String s, int width) {
		StringBuffer result = new StringBuffer(width);
		int numCharToPrint = Math.min(s.length(), width);
		result.append(s.substring(0, numCharToPrint));
		for (int i = s.length() + 1; i <= width; i++) result.append(SPACE);
		return result.toString();
	}
	
	/**
	 * Returns a String centered.
	 * @param s - The String to be placed in center
	 * @param width - The width of column
	 * @return a String centered
	 */
	public static String centered(String s, int width) {	
		StringBuffer result = new StringBuffer(width);
		
		if (width <= s.length()) result.append(s.substring(width));
		else {
			int spaceBefore = (width - s.length())/2;
			int spaceAfter = width - spaceBefore - s.length();
			for (int i = 1; i <= spaceBefore; i++) result.append(SPACE);
			result.append(s);	
			for (int i = 1; i <= spaceAfter; i++) result.append(SPACE);
		}
		return result.toString();
	}
	
	/**
	 * Returns a String of cloned characters.
	 * @param c - The Char to clone
	 * @param width - The number of characters to clone
	 * @return a String of cloned characters
	 */
	public static String cloneChar(char c, int width) {
		StringBuffer result = new StringBuffer(width);
		 for (int i = 0; i < width; i++) result.append(c);
		 return result.toString();
	}
}
