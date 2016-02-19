package tables;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TotalHistorik {

	StringProperty personnumer;
	StringProperty efternamn;
	StringProperty fornamn;
	StringProperty total;

	public TotalHistorik(String personnumer, String efternamn, String fornamn, String total) {
		super();
		this.personnumer = new SimpleStringProperty(personnumer);
		this.efternamn = new SimpleStringProperty(efternamn);
		this.fornamn = new SimpleStringProperty(fornamn);
		this.total = new SimpleStringProperty(total);
	}

	public StringProperty getPersonnumer() {
		return personnumer;
	}

	public void setPersonnumer(StringProperty personnumer) {
		this.personnumer = personnumer;
	}

	public StringProperty getEfternamn() {
		return efternamn;
	}

	public void setEfternamn(StringProperty efternamn) {
		this.efternamn = efternamn;
	}

	public StringProperty getFornamn() {
		return fornamn;
	}

	public void setFornamn(StringProperty fornamn) {
		this.fornamn = fornamn;
	}

	public StringProperty getTotal() {
		return total;
	}

	public void setTotal(StringProperty total) {
		this.total = total;
	}

}
