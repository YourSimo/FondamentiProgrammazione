package it.unibs.ing.fp.lonelyhearts;

import it.unibs.ing.fp.library.InputData;

/**
 * <h1> Class LonelyHeartMain </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.0
 * @since 2016-04-05
 */

public class LonelyHeartMain {
	private final static String MSG_SALUTO = "Benvenuto nel programma Cuori Solitari";
	private final static String MSG_INTRO_INSERIMENTO = "Inserimento dati di un nuovo cuore solitario";
	private final static String MSG_PSEUDONIMO = "Inserisci il tuo pseudonimo:";
	private final static String MSG_ETA = "Inserisci la tua eta':";
	private final static String MSG_SESSO= "Inserisci F se sei femmina o M se sei maschio";
	private final static String MSG_SEGNO = "Inserisci il tuo segno zodiacale:";
	private final static String MSG_SEGNO_PREFERITO = "Inserisci il segno zodiacale che vuoi incontrare:";
	
	private final static String MSG_AFFINE= "%s E' potenzialmente affine a %s";
	private final static String MSG_NON_AFFINE= "%s NON E' potenzialmente affine a %s";
	
	private final static String RISPOSTE_AMMISSIBILI ="MF";
	
	private final static int MIN_AGE = 18;
	private final static int MAX_AGE = 120;
	
	// Metodo Saluto
	public static void hello(String message) {
		System.out.println(message);
	}
	
	// Metodo creazione di un cuore solitario
	public static LonelyHeart makeLonelyHeart() throws Exception {
		System.out.println(MSG_INTRO_INSERIMENTO);
		String nick = InputData.readStringNotEmpty(MSG_PSEUDONIMO);
		char sex = InputData.readCharLimitedNotSensitive(MSG_SESSO, RISPOSTE_AMMISSIBILI);
		int age = InputData.readIntWithLimit(MSG_ETA, MIN_AGE, MAX_AGE);
		Zodiaco segno = Zodiaco.readSegno(MSG_SEGNO);
		Zodiaco segnoPreferito = Zodiaco.readSegno(MSG_SEGNO_PREFERITO);
		
		return new LonelyHeart(nick, sex, age, segno, segnoPreferito);
	}
	
	// Metodo getAffinità 
	public static void getAffinity(LonelyHeart lhCheckA, LonelyHeart lhCheckB) {
		if (lhCheckA.checkAffinity(lhCheckB)) System.out.printf(MSG_AFFINE, lhCheckA, lhCheckB);
		else System.out.printf(MSG_NON_AFFINE, lhCheckA, lhCheckB);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		hello(MSG_SALUTO);
		
		LonelyHeart lh1 = makeLonelyHeart();
		LonelyHeart lh2 = makeLonelyHeart();
		
		getAffinity(lh1, lh2);
	}
}
