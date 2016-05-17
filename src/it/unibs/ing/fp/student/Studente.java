package it.unibs.ing.fp.student;

/**
 * <h1> Class Studente </h1>
 * <p>
 * 
 * @author Simone Cavicchioli <s.cavicchioli@studenti.unibs.it>
 * @version v1.1
 * @since 2016-03-08
 */

public class Studente {
	private String nome;
	private String cognome;
	
	/**
	 * Constructor.
	 * @param nome - The name of Studente
	 * @param cognome - The surname of Studente
	 */
	public Studente(String nome, String cognome) {
		this.nome = nome;
		this.cognome = cognome;
	}
	
	/**
	 * Returns the String "name surname" to upper case. 
	 * @return "NAME SURNAME"
	 */
	public String getMaiuscolo() {
		String nomeMaiuscolo = nome.toUpperCase();
		String congnomeMaiuscolo = cognome.toUpperCase();
		
		String nomeCognome = nomeMaiuscolo + " " + congnomeMaiuscolo;
		return nomeCognome;
	}
	
	/**
	 * Returns a sub-string of "NAME SURNAME".
	 * @param numChar - The number of char to estract
	 * @return sub-string
	 */
	public String getEstrai(int numChar) {
		String nomeCognome = nome + " " + cognome;
		
		//...?
		
		String sottostringa = new String();
		
		if (numChar <= nomeCognome.length()) sottostringa = nomeCognome.substring(0, numChar);
		return sottostringa;
	}
	
	// Metodo main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Nuovo oggetto s1
		Studente s1 = new Studente("Simone", "Cavicchioli");
		
		System.out.println(s1.getMaiuscolo());
		
		System.out.println(s1.getEstrai(2));
	}

}
