package it.unibs.ing.fp.bankaccount;

public class Person {
	private String nome;
	private String cognome;
	private String sesso;
	private String dataDiNascita;
	private String città;
	private String paese;
	// private String password;
	
	// Costruttore
	public Person(String _nome, String _cognome, String _sesso, String _dataDiNascita, String _città, String _paese) {
		nome = _nome;
		cognome = _cognome;
		sesso = _sesso;
		dataDiNascita = _dataDiNascita;
		città = _città;
		paese = _paese;
	}
	
	// Metodo Owner
	public String getOwner() {
		String nomeCognome = nome + " " + cognome;
		return nomeCognome;
	}
	
	// Metodo Nationality
	public String getNationality() {
		return paese;
	}
	
	// Metodo getHello
	public String getHello(String paese) {
		if (paese == "Italy") return "Buongiorno! ";
		if (paese == "England") return "Good morning! ";
		if (paese == "France") return "Bonjour! ";
		if (paese == "German") return "guten Morgen! ";
		return null;
	}
}
