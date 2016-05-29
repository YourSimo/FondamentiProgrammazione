package it.unibs.ing.fp.library;

public class Formatting {
	private final static String SPACE = " ";
	private final static String FRAME = "---------------------------------------------------";
	private final static String HEAD = "\n";

	/**
	 * Returns a framing String.
	 * @param s - The String to frame
	 * @return a framing String
	 */
	
	public static String framing(String s) {
		StringBuffer result = new StringBuffer();
		result.append(FRAME + HEAD + s + HEAD + FRAME);
		return result.toString();
	}

	/**
	 * Returns a column String.
	 * @param s - The String to be placed in column
	 * @param width - The width of column
	 * @return a String in Column
	 */
	public static String inColumn(String s, int width) {
		StringBuffer result = new StringBuffer();
		result.append(s);
		int remainingSpace = width - s.length();
		for(int i = 0; i <= remainingSpace; i++) result.append(SPACE);
		return result.toString();
	}
	
	/**
	 * Returns a centered String.
	 * @param s - The String to be placed in center
	 * @param width - The width of column
	 * @return a centered String
	 */
	public static String centered(String s, int width) {	
		StringBuffer result = new StringBuffer();
		int remainingSpace = width - s.length();
		int halfWidth = remainingSpace / 2;
		for(int i = 0; i <= halfWidth; i++) result.append(SPACE);
		result.append(s);
		for(int i = 0; i <= halfWidth; i++) result.append(SPACE);
		return result.toString();
	}
}
