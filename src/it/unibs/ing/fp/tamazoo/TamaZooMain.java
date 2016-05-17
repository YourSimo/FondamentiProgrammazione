package it.unibs.ing.fp.tamazoo;

import it.unibs.ing.fp.hello.Hello;
import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.math.Casuale;
import it.unibs.ing.fp.tamagotchi.Tamagotchi;

/**
 * <h1> Class TamaZooMain </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.0
 * @since 2016-05-17
 */

public class TamaZooMain {
	private static final String MSG_BENVENUTO = "Benvenuto nel mondo dei TamaZoo";
	
	private static final String MSG_NEW_TAMAZOO = "Inserire il numero di Tamagotchi da creare: ";
	
	private final static String MSG_NEXT = "Cosa vuoi Fare? Dare Carezze [C], Biscotti [B] o Uscire [Q]";
	private final static String VALID_CHAR = "CBQ";
	private final static String CHOISE_ERR = "Attenzione: inserimento errato";
	
	private final static int MAX_BISCOTTI = 10;
	private final static int MAX_CAREZZE = 20;

	public static TamaZoo makeTamaZoo() {
		int amount = InputData.readIntWithMin(MSG_NEW_TAMAZOO, 1);
		return new TamaZoo(amount);
	}
	
	public static void whatDoYouWantToDo(Tamagotchi ta) {
		boolean finish = false;
		do {
			char operation = InputData.readCharLimitedNotSensitive(MSG_NEXT, VALID_CHAR);
			switch(operation) {
			case 'C' :
			case 'c' :
				int carezze = Casuale.randomInt(1,MAX_CAREZZE); 
				ta.giveCarezze(carezze);
				break;
			case 'B' : 
			case 'b' :
				int biscotti = Casuale.randomInt(1,MAX_BISCOTTI);
				ta.giveBiscotti(biscotti);
				break;
			case 'Q' : 
			case 'q' :
				finish = true;
				break;
			default :
				System.out.println(CHOISE_ERR);
			}
		if(!finish) {
			System.out.println(ta.toString());
			if(ta.isDied()) finish = true;
		}
		} while(!finish);
	}
	
	public static void printTamaZoo(TamaZoo taZ) {
		System.out.println(taZ.toString());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Hello.sayHello(MSG_BENVENUTO);
		
		TamaZoo taZoo = makeTamaZoo();
		
		printTamaZoo(taZoo);
		
		
		
		// 
	}

}
