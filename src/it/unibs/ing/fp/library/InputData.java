package it.unibs.ing.fp.library;

import java.util.Scanner;

/**
 * <h1>Class InputData</h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v5.0
 * @since 2016-03-15
 */

public class InputData {
	private static Scanner reader = makeScanner();
	
	private final static String ERRORE_MINIMO = "Attenzione: e' richiesto un valore maggiore o uguale a ";
	private final static String ERRORE_MASSIMO = "Attenzione: e' richiesto un valore minore o uguale a ";
	private final static String ERRORE_LIMITI = "Attenzione i valori ammessi sono nell'intervallo: ";
	private final static String ERRORE_CHAR_CONSENTITI = "Attenzione sono consentiti solo i caratteri ";
	private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non è nel formato corretto";
	private final static String ERRORE_STRINGA_VUOTA = "Attenzione: non hai inserito alcun carattere";

	private static final char YES_ANSWER = 'S';
	private static final char NO_ANSWER = 'N';
	
	
	// Metodo Scanner
	private static Scanner makeScanner() {
		Scanner reader = new Scanner(System.in);
		reader.useDelimiter(System.getProperty("line.separator"));
		return reader;
	}
	
	// Metodo ReadInt
	public static int readInt(String message) {
		boolean finish = false;
		int readValue = 0;
		do {
			System.out.print(message);
			if (reader.hasNextInt()) {
				readValue = reader.nextInt();
				finish = true;
			} else {
				System.out.println(ERRORE_FORMATO);
				String trashing = reader.next();
			}
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadIntWithMin
	public static int readIntWithMin(String message, int min) {
	   boolean finish = false;
	   int readValue = 0;
	   do {
		   readValue = readInt(message);
		   if (readValue >= min)
			   finish = true;
		   else System.out.println(ERRORE_MINIMO + min);
	   } while (!finish);  
	   	return readValue;
	}
	
	// Metodo ReadIntWithLimit
	public static int readIntWithLimit(String message, int min, int max) {
		boolean finish = false;
		int readValue = 0;
		do {
			System.out.print(message);
			if (reader.hasNextInt()) {
				readValue = reader.nextInt();
				if (readValue >= min && readValue <= max) finish = true;
			} else {
				System.out.println(ERRORE_LIMITI + min + "-" + max);
				String trashing = reader.next();
			}
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadDouble
	public static double readDouble(String message) {
		System.out.println(message);
		boolean finish = false;
		double readValue = 0.0;
		do {
			if (reader.hasNextDouble()){
				readValue = reader.nextDouble();
				finish = true;
			} else {
				System.out.println(ERRORE_FORMATO);
				reader.next();
			}
		} while(!finish);
		return readValue;	
	}
	
	// Metodo ReadDoubleWithMin
	public static double readDoubleWithMin(String message, double min) {
		boolean finish = false;
		double readValue = 0;
		do {
			readValue = readDouble(message);
			if (readValue >= min)
				finish = true;
			else System.out.println(ERRORE_MINIMO + min);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadChar
	public static char readChar(String message) {
		boolean finish = false;
		char readValue = '\0';
		do {
			System.out.print(message);
			String reading = reader.next();
			if (reading.length() > 0) {
				readValue = reading.charAt(0);
				finish = true;
			}
			else System.out.println(ERRORE_STRINGA_VUOTA);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadCharLimitedNotSensitive
	public static char readCharLimitedNotSensitive(String message, String validChar) {
		boolean finish = false;
		char readValue = '\0';
		do {
			System.out.print(message);
			String reading = reader.next();
			if (reading.length() == 1 && validChar.indexOf(reading.toUpperCase().charAt(0)) != -1) {
				readValue = reading.charAt(0);
				finish = true;
			}
			else System.out.println(ERRORE_CHAR_CONSENTITI + validChar);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadCharLimitedSensitive
	public static char readCharLimitedSensitive(String message, String validChar) {
		boolean finish = false;
		char readValue = '\0';
		do {
			System.out.print(message);
			String reading = reader.next();
			if (reading.length() == 1 && validChar.indexOf(reading.charAt(0)) != -1) {
				readValue = reading.charAt(0);
				finish = true;
			}
			else System.out.println(ERRORE_CHAR_CONSENTITI + validChar);
		} while (!finish);
		return readValue;
	}
	
	// Metodo ReadString
	public static String readString(String message) {
		System.out.print(message);
		return reader.next();
	}
	
	// Metodo readStringNotEmpty
	public static String readStringNotEmpty(String message) {
		boolean finish = false;
		String reading = null;
		do {
			reading = readString(message);
			reading = reading.trim(); // Rimuove i caratteri di spaziatura
			if (reading.length() > 0) finish = true;
			else System.out.println(ERRORE_STRINGA_VUOTA);
		} while (!finish);
		return reading;
	}

	// Metodo yesOrNo
	public static boolean yesOrNo(String message) {
		String myMessage = message + "("+YES_ANSWER+"/"+NO_ANSWER+")";
		char readValue = readCharLimitedNotSensitive(myMessage,String.valueOf(YES_ANSWER)+String.valueOf(NO_ANSWER));
		if (readValue == YES_ANSWER) return true;
		else return false;
	}
}

