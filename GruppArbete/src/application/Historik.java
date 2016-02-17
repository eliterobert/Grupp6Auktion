package application;

public class Historik {

	String namn;
	String beskrivning;
	String auktionsId;
	String auktionSlut;
	String belopp;
	String auktionStart;
	

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getBeskrivning() {
		return beskrivning;
	}

	public void setBeskrivning(String beskrivning) {
		this.beskrivning = beskrivning;
	}

	public String getAuktionsId() {
		return auktionsId;
	}

	public void setAuktionsId(String auktionsId) {
		this.auktionsId = auktionsId;
	}

	public String getAuktionSlut() {
		return auktionSlut;
	}

	public void setAuktionSlut(String auktionSlut) {
		this.auktionSlut = auktionSlut;
	}

	public Historik(String namn, String beskrivning, String auktionsId, String auktionSlut) {
		super();
		this.namn = namn;
		this.beskrivning = beskrivning;
		this.auktionsId = auktionsId;
		this.auktionSlut = auktionSlut;
	}
	

	

	public Historik(String namn, String beskrivning, String auktionSlut, String belopp, String auktionStart) {
		super();
		this.namn = namn;
		this.beskrivning = beskrivning;
		this.auktionSlut = auktionSlut;
		this.belopp = belopp;
		this.auktionStart = auktionStart;
	}

	@Override
	public String toString() {
		return "LeverantorsHistorik [namn=" + namn + ", beskrivning=" + beskrivning + ", auktionsId=" + auktionsId
				+ ", auktionSlut=" + auktionSlut + "]";
	}

}
