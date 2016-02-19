package tables;

public class Manad {

	String namn;
	int nummer;

	public Manad(String namn, int nummer) {
		super();
		this.namn = namn;
		this.nummer = nummer;
	}

	@Override
	public String toString() {
		return namn;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public int getNummer() {
		return nummer;
	}

	public void setNummer(int nummer) {
		this.nummer = nummer;
	}

}
