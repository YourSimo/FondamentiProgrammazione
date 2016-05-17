package it.unibs.ing.fp.finedust;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class FinedustMain </h1>
 * <p>
 * 
 * @author Federico Avino 
 * @author Matteo Bellicini 
 * @author Simone Cavicchioli
 * 
 * @version v1.1
 * @since 2016-04-19
 *
 */

public class FinedustMain {
	private final static String INTRO = "Benvenuto nel programma di verifica di polveri sottili nell'aria";
	private final static String RESULT = "I risultati della settimana: ";
	
	private final static int MIN_YEAR = 1950;
	private final static int MAX_WEEK = 53;
	private final static int N_MISURE = 7;

	
	private final static String MSG_YEAR = "Inserire l'anno: ";
	private final static String MSG_WEEK = "Inserie il numero della settimana: ";
	private final static String MSG_MISURE = "Inserire il valore misurato nel giorno: ";
	
	private final static String MSG_NEXT = "Cosa vuoi Fare? Inserire i dati di una nuova settimana [N] o Uscire [Q]";
	private final static String VALID_CHAR = "NQ";
	private final static String CHOISE_ERR = "Attenzione: inserimento errato";
	
	private final static String MSG_ALARM_MAX_VALUE = "ATTENZIONE: il valore massimo settimanale di %d è superiore alla soglia di %d%n";
	private final static String MSG_ALARM_AVERAGE_VALUE = "ATTENZIONE: il valore medio settimanale di %1.2f è superiore alla soglia di %d%n";
	
	// Metodi
	public static Week makeWeek() {
		int year = InputData.readIntWithMin(MSG_YEAR, MIN_YEAR);
		int week = InputData.readIntWithLimit(MSG_WEEK, 1, MAX_WEEK);
		// ciclo...
		int [] misure = new int[N_MISURE];
		for(int i = 0; i < misure.length; i++) misure[i] = InputData.readIntWithMin(MSG_MISURE + (i+1), 0); 
		return new Week(year, week, misure);
	}
	
	public static void next() {
		boolean finish = false;
		do {
			char operation = InputData.readCharLimitedNotSensitive(MSG_NEXT, VALID_CHAR);
			switch(operation) {
			case 'N' :
			case 'n' :
				Week week2 = makeWeek();
				checkWeek(week2);
				System.out.println(RESULT);
				System.out.println(week2.toString());
				break;
			case 'Q' :
			case 'q' :
				finish = true;
				break;
			default :
				System.out.println(CHOISE_ERR);
			}
		} while(!finish);
	}
	
	public static void checkWeek(Week sett) {
		if(sett.checkMaxValue()) System.out.printf(MSG_ALARM_MAX_VALUE, sett.getMaxValue(), Week.MAX_VALUE);
		if(sett.checkAverageValue()) System.out.printf(MSG_ALARM_AVERAGE_VALUE, sett.getAverageValue(), Week.AVERAGE_VALUE);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hello.sayHello(INTRO);
		Week week1 = makeWeek();
		
		System.out.println(RESULT);
		System.out.println(week1.toString());
		
		checkWeek(week1);
		next();
	}

}
