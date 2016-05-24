package it.unibs.ing.fp.library;

public class Formatting {
	private final static String SPACE = " ";
	private final static String FRAME = "---------------------------------------------------";
	private final static String HEAD = "\n";

	public static String framing(String s) { 
		 // RESTUTUISCE LA String OPPORTUNAMENTE INCORNICIATA
		StringBuffer result = new StringBuffer();
		result.append(FRAME + HEAD + s + HEAD + FRAME);
		return result.toString();
	}

	public static String inColumn (String s, int width) {
		 // RESTITUISCE UNA String DI DIMENSIONE larghezza AGGIUNGENDO SPAZI AD s
		StringBuffer result = new StringBuffer();
		result.append(s);
		for(int i = 0; i <= width; i++) result.append(SPACE);
		return result.toString();
	}
		
	public static String centered (String s, int width) {
		 /* RESTITUISCE UNA String DI DIMENSIONE larghezza  
		  *AGGIUNGENDO SPAZI PRIMA E DOPO s IN MODO CHE s RISULTI IN POSIZIONE CENTRATA
		  */	
		StringBuffer result = new StringBuffer();
		int halfWidth = width / 2;
		for(int i = 0; i <= halfWidth; i++) result.append(SPACE);
		result.append(s);
		for(int i = 0; i <= halfWidth; i++) result.append(SPACE);
		return result.toString();
	}
}
