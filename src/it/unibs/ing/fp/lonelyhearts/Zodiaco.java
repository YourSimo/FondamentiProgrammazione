package it.unibs.ing.fp.lonelyhearts;

import it.unibs.ing.fp.library.InputData;

public enum Zodiaco {
	ARIETE, TORO, GEMELLI, CANCRO, LEONE, VERGINE, BILANCIA, SCORPIONE, SAGITTARIO, CAPRICORNO, ACQUARIO, PESCI;

	private final static String ERRORE_ZODIACO = "Attenzione il segno immesso non è valido";
	
	public static Zodiaco readSegno(String message) throws Exception {
		boolean checkSegno = false;
		Zodiaco segnoInserito = null;
		
		do
		{
			String segnoStringa = InputData.readString(message);
			for (Zodiaco segno : Zodiaco.values())
			{
				if (segno.toString().equalsIgnoreCase(segnoStringa))
				{
					segnoInserito = segno;
					checkSegno = true;
					break;
				}
			}
			if (!checkSegno)
				System.out.println (ERRORE_ZODIACO);
		}
		while(!checkSegno);
		
		return segnoInserito;
	}
}
