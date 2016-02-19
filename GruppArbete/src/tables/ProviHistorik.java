package tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProviHistorik {

	StringProperty namn;
	StringProperty auktionId;
	StringProperty produktNamn;
	StringProperty provision;
	StringProperty provisionsNiva;

	public ProviHistorik(String namn, String auktionId, String produktNamn, String provision, String provisionsNiva) {
		super();
		this.namn = new SimpleStringProperty(namn);
		this.auktionId = new SimpleStringProperty(auktionId);
		this.produktNamn = new SimpleStringProperty(produktNamn);
		this.provision = new SimpleStringProperty(provision);
		this.provisionsNiva = new SimpleStringProperty(provisionsNiva);
	}

	public StringProperty getNamn() {
		return namn;
	}

	public void setNamn(StringProperty namn) {
		this.namn = namn;
	}

	public StringProperty getAuktionId() {
		return auktionId;
	}

	public void setAuktionId(StringProperty auktionId) {
		this.auktionId = auktionId;
	}

	public StringProperty getProduktNamn() {
		return produktNamn;
	}

	public void setProduktNamn(StringProperty produktNamn) {
		this.produktNamn = produktNamn;
	}

	public StringProperty getProvision() {
		return provision;
	}

	public void setProvision(StringProperty provision) {
		this.provision = provision;
	}

	public StringProperty getProvisionsNiva() {
		return provisionsNiva;
	}

	public void setProvisionsNiva(StringProperty provisionsNiva) {
		this.provisionsNiva = provisionsNiva;
	}

}
