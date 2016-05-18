package it.unibs.ing.fp.tunes;

import java.util.Vector;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.math.Casuale;

/**
 * <h1> Class CDCollection </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini 
 * @author Simone Cavicchioli
 * 
 * @version v1.1
 * @since 2016-04-26
 */

public class CDCollection {
	
	private final static String MSG_NEW_TITLE = "Inserisci il titolo dell'album da aggiungere: ";
	private final static String MSG_EXISTING_TITLE = "Attenzione: il nome inserito è già in uso";
	private final static String MSG_NEW_ARTIST = "Inserisci l'artista dell'album: ";
	private final static String MSG_SONG = "Inserisci i brani dell'album: ";
	private static final String HEAD_SONG = "Brano n°";
	private static final String MSG_TITLE_SONG = "Insrisci il titolo del brano: ";
	private static final String MSG_LENGH = "Inserisci la durata del brano in secondi: ";
	private static final double MIN_LENGH = 1;
	private static final String MSG_NEW_SONG = "Vuoi inserire un altro brano? ";
	private static final String MSG_EMPTY_COLLECTION = "Attenzione l'archivio non contiene alcun CD!";
	private static final String HEADING_ALBUM = "%n[ALBUM n° %d DELLA COLLEZIONE]%n";
	private static final String MSG_SHOW_ALBUM = "Inserisci il titolo dell'album: ";
	private static final String MSG_DELETE_ALBUM = "Confermi la rimozione dell'album? ";
	
	private Vector <Album> collection;
	// private int count;
	// private int totalCost;
	
	/**
	 * Constructor.
	 */
	public CDCollection() {
		collection = new Vector<Album>();
	}
	
	/**
	 * Returns the number of album.
	 * @return dimentions
	 */
	public int getNumberAlbum() {
		return collection.size();
	}
	
	/**
	 * Add new album
	 * @param album
	 */
	public void addNewAlbum(Album album) {
		collection.add(album);
	}
	
	public void addNewAlbum() {
		String titleAlbum = InputData.readStringNotEmpty(MSG_NEW_TITLE);
		
		if(searchAlbum(titleAlbum) != null)
			System.out.println(MSG_EXISTING_TITLE);
		else {
			String artist = InputData.readStringNotEmpty(MSG_NEW_ARTIST);
			
			Album album = new Album(titleAlbum, artist);
			
			System.out.println(MSG_SONG + titleAlbum);
			int count = 1;
			
			do {
				System.out.println(HEAD_SONG + count);
				
				String titleSong = InputData.readStringNotEmpty(MSG_TITLE_SONG);
				double lengh = InputData.readDoubleWithMin(MSG_LENGH, MIN_LENGH);
				
				Song song = new Song(titleSong, lengh);
				
				album.addNewSong(song);
				count++;
			} while(InputData.yesOrNo(MSG_NEW_SONG));
			
		collection.add(album);
		}
		
	}
	
	/**
	 * Search album
	 * @param titleAlbum The name of album
	 * @return album if exist
	 */
	public Album searchAlbum(String titleAlbum) {
		Album album = null;
		for(int i = 0; i < collection.size(); i++) {
			album = collection.get(i);
			if(album.matchSong(titleAlbum)) return album;
		}
		return null;
	}
	
	
	public void showAlbum() {
		String titleAlbum = InputData.readStringNotEmpty(MSG_SHOW_ALBUM);
		Album album = searchAlbum(titleAlbum);
		System.out.println(album.toString());
	}
	
	/**
	 * Delete album
	 * @param titleAlbum The name of Album
	 */
	public void deleteAlbum(String titleAlbum) {
		Album album = searchAlbum(titleAlbum);
		collection.remove(album);
	}
	
	public void deleteAlbum() {
		String titleAlbum = InputData.readStringNotEmpty(MSG_SHOW_ALBUM);
		Album album = searchAlbum(titleAlbum);
		System.out.println(album.toString());
		if(InputData.yesOrNo(MSG_DELETE_ALBUM)) collection.remove(album);
	}
	
	public void selectRandomAlbum() {
		int index = Casuale.randomInt(0, collection.size() - 1);
		System.out.println(collection.get(index).toString());
	}
	
	@Override
	public String toString() {
		if(collection.size() == 0) return MSG_EMPTY_COLLECTION;
		else {
			StringBuffer result = new StringBuffer();
			for (int i = 0; i < collection.size(); i++) {
				result.append(String.format(HEADING_ALBUM, i + 1));
				Album album = collection.get(i);
				result.append(album.toString() + "\n");	
			}
		return result.toString();
		}
	}
}
