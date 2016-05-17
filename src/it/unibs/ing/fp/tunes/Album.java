package it.unibs.ing.fp.tunes;

import java.util.Vector;

/**
 * Class Album
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini 
 * @author Simone Cavicchioli
 * 
 * @version v1.0
 * @since 2016-04-26
 *
 */
public class Album {
	private final static String MSG_ALBUM = "Titolo album: %s%nArtista album: %s%nCanzoni: ";
	private final static String FORMAT = "%n%s; ";
	
	private String title, artist;
	// private double cost;
	// priavte int tracks;
	private Vector <Song> songList;
	
	/**
	 * Constructor.
	 * @param name - The name of Album
	 * @param singer - The singer of Album
	 */
	public Album(String name, String singer) {
		title = name;
		artist = singer;
		songList = new Vector <Song> ();
	}
	
	/**
	 * Add new song
	 * @param song
	 */
	public void addNewSong(Song song) {
		songList.add(song);
	}
	
	/**
	 * Match song
	 * @param search The song of research
	 * @return <tt>true </tt> if the name of song exist
	 */
	public boolean matchSong(String search) {
		return title.equalsIgnoreCase(search);
	}
	
	@Override
	public String toString() {
		StringBuffer album = new StringBuffer();
		album.append(String.format(MSG_ALBUM, title, artist));
		for (int i = 0; i < songList.size(); i++)
		{
			Song song = (Song)songList.get(i);
			album.append(String.format(FORMAT, song.toString()));
		}
		return album.toString();
	}
}
