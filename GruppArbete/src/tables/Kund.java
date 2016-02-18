package tables;

public class Kund {
	private String personnummer;
	private String efternamn;
	private String förnamn;
	String gatuadress;
	String ort;
	String telefon;
	String epost;

	@Override
	public String toString() {
		return getFörnamn() + " " + getEfternamn();
	}

	public String getFörnamn() {
		return förnamn;
	}

	public void setFörnamn(String förnamn) {
		this.förnamn = förnamn;
	}

	public String getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(String efternamn) {
		this.efternamn = efternamn;
	}

	public String getPersonnummer() {
		return personnummer;
	}

	public void setPersonnummer(String personnummer) {
		this.personnummer = personnummer;
	}
}
