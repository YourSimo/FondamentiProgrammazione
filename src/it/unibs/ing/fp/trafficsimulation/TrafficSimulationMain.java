package it.unibs.ing.fp.trafficsimulation;

import it.unibs.ing.fp.library.InputData;

public class TrafficSimulationMain {

	final private static int NUMRIGHE_STRADA = 5;
	final private static int NUMCOLONNE_STRADA = 20;
	
	final private static String MSG_INIZIALE = "Strada inizializzata:";
	final private static String MSG_CONTINUA = "Proseguire la simulazione ?";
	
	
	public static void main(String[] args) {
		Road road = new Road(NUMRIGHE_STRADA,NUMCOLONNE_STRADA);
		
		road.inizializza();

		System.out.println(MSG_INIZIALE);
		System.out.println(road); 
		
		while (InputData.yesOrNo(MSG_CONTINUA)) {
				road.evoluzione();
				System.out.println(road);
		} 	
	}
}
