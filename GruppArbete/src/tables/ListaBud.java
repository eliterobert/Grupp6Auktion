package tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ListaBud {

	StringProperty auktionId;
	StringProperty namn;
	StringProperty beskrivning;
	StringProperty bud;
	StringProperty fornamn;

	public ListaBud(String auktionId, String namn, String beskrivning, String bud, String fornamn) {
		super();
		this.auktionId = new SimpleStringProperty(auktionId);
		this.namn = new SimpleStringProperty(namn);
		this.beskrivning = new SimpleStringProperty(beskrivning);
		this.bud = new SimpleStringProperty(bud);
		this.fornamn = new SimpleStringProperty(fornamn);
	}

	public StringProperty getAuktionId() {
		return auktionId;
	}

	public void setAuktionId(StringProperty auktionId) {
		this.auktionId = auktionId;
	}

	public StringProperty getNamn() {
		return namn;
	}

	public void setNamn(StringProperty namn) {
		this.namn = namn;
	}

	public StringProperty getBeskrivning() {
		return beskrivning;
	}

	public void setBeskrivning(StringProperty beskrivning) {
		this.beskrivning = beskrivning;
	}

	public StringProperty getBud() {
		return bud;
	}

	public void setBud(StringProperty bud) {
		this.bud = bud;
	}

	public StringProperty getFornamn() {
		return fornamn;
	}

	public void setFornamn(StringProperty fornamn) {
		this.fornamn = fornamn;
	}

}
