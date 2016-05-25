package it.unibs.ing.fp.library;

public class Menu {
	final private static String FRAME = "--------------------------------";
	final private static String OUTRO = "0\tEsci";
	final private static String RICHIESTA_INSERIMENTO = "Digita il numero dell'opzione desiderata > ";

	private String title;
	private String [] voci;

	/**
	 * Constructor.
	 * @param title - The message ...
	 * @param voci - The list of options
	 */	
	public Menu(String title, String [] voci) {
		this.title = title;
		this.voci = voci;
	}

	/**
	 * Returns the choise from the list of options.
	 * @return a int number between 0 and the number of options
	 */
	public int choise() {
		printMenu();
		return InputData.readIntWithLimit(RICHIESTA_INSERIMENTO, 0, voci.length);	 
  	}
	
	/**
	 * Prints the Menu with title and list of options.
	 */
	public void printMenu() {
		System.out.println(FRAME);
		System.out.println(title);
		System.out.println(FRAME);
	    for (int i=0; i<voci.length; i++) {
	    	System.out.println((i + 1) + "\t" + voci[i]);
		}
	    System.out.println();
		System.out.println(OUTRO);
	    System.out.println();
  	}
}
