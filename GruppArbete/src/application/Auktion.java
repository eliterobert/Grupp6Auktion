package application;

import java.sql.Date;

public class Auktion {

	String auktionId;
	String produktId;
	int acceptpris;
	Date start;
	Date slut;
	int slutpris;
	@Override
	public String toString() {
		return produktId;
	}
	
}
