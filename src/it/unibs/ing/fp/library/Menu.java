package it.unibs.ing.fp.library;

public class Menu {
	final private static String CORNICE = "--------------------------------";
	final private static String OUTRO = "0\tEsci";
	final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

	private String title;
	private String [] voci;

		
	public Menu(String title, String [] voci) {
		this.title = title;
		this.voci = voci;
	}

	public int choise() {
		printInterface();
		return InputData.readIntWithLimit(RICHIESTA_INSERIMENTO, 0, voci.length);	 
  	}
			
	public void printInterface() {
		System.out.println(CORNICE);
		System.out.println(title);
		System.out.println(CORNICE);
	    for (int i=0; i<voci.length; i++) {
	    	System.out.println((i + 1) + "\t" + voci[i]);
		}
	    System.out.println();
		System.out.println(OUTRO);
	    System.out.println();
  	}
}
