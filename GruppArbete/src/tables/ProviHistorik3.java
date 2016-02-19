package tables;

public class ProviHistorik3 {

	String namn;
	String auktionId;
	String produktNamn;
	String provision;
	String provisionsNiva;

	public ProviHistorik3(String namn, String auktionId, String produktNamn, String provision, String provisionsNiva) {
		super();
		this.namn = namn;
		this.auktionId = auktionId;
		this.produktNamn = produktNamn;
		this.provision = provision;
		this.provisionsNiva = provisionsNiva;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

	public String getAuktionId() {
		return auktionId;
	}

	public void setAuktionId(String auktionId) {
		this.auktionId = auktionId;
	}

	public String getProduktNamn() {
		return produktNamn;
	}

	public void setProduktNamn(String produktNamn) {
		this.produktNamn = produktNamn;
	}

	public String getProvision() {
		return provision;
	}

	public void setProvision(String provision) {
		this.provision = provision;
	}

	public String getProvisionsNiva() {
		return provisionsNiva;
	}

	public void setProvisionsNiva(String provisionsNiva) {
		this.provisionsNiva = provisionsNiva;
	}

}
