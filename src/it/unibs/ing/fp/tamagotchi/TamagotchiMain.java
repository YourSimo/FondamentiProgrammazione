package it.unibs.ing.fp.tamagotchi;

import it.unibs.ing.fp.library.InputData;
import it.unibs.ing.fp.math.Casuale;
import it.unibs.ing.fp.hello.Hello;

/**
 * <h1> Class TamagotchiMain </h1>
 * <p>
 * 
 * @author Simone Cavicchioli
 * @version v1.0
 * @since 2016-04-12
 */

public class TamagotchiMain {
	
	private final static String MSG_SALUTO = "Benvenuto";
	
	private final static String MSG_NOME = ": inserisci un nickname ";
	private final static String MSG_AFF = ": inserisci un valore di affettività ";
	private final static String MSG_SAZ = ": inserisci un valore di sazietà ";
	
	private final static String MSG_NEXT = "Cosa vuoi Fare? Dare Carezze [C], Biscotti [B] o Uscire [Q]";
	private final static String VALID_CHAR = "CBQ";
	private final static String CHOISE_ERR = "Attenzione: inserimento errato";
	
	private final static int MAX_BISCOTTI = 10;
	private final static int MAX_CAREZZE = 20;
	
	// Metodo static makeTamagotchi
	public static Tamagotchi makeTamagotchi() {
		String nome = InputData.readStringNotEmpty(MSG_NOME);
		int affettività = InputData.readIntWithLimit(MSG_AFF, Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		int sazietà = InputData.readIntWithLimit(MSG_SAZ, Tamagotchi.MIN_SAZ, Tamagotchi.MAX_SAZ);
		
		return new Tamagotchi(nome, "TamaBase", affettività, sazietà);
	}
	
	// Metodo static whatDoYouWantToDo
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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Hello.sayHello(MSG_SALUTO);
		Tamagotchi ta1 = makeTamagotchi();
		whatDoYouWantToDo(ta1);
	}
}
