package application;

public class Kund {
	String personnummer;
	String efternamn;
	String förnamn;
	String gatuadress;
	String ort;
	String telefon;
	String epost;

	@Override
	public String toString() {
		return förnamn + " " + efternamn;
	}
}
