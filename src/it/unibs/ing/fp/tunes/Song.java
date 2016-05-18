package it.unibs.ing.fp.tunes;

/**
 * <h1> Class Song </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini 
 * @author Simone Cavicchioli
 * 
 * @version v1.1
 * @since 2016-04-26
 */

public class Song {
	private final static String MSG_SONG = "%s (%s)";
	
	private String title;
	private double lengh;
	
	/**
	 * Constructor.
	 * @param title - The title of song
	 * @param lengh - The lengh of song
	 */
	public Song(String title, double lengh) {
		this.title = title;
		this.lengh = lengh;
	}
	
	@Override
	public String toString() {
		StringBuffer brano = new StringBuffer();
		brano.append(String.format(MSG_SONG, title, lengh));
		return brano.toString();
	}

}
