package tables;


public class Produkt {
	private String produktId;
	private String namn;
	String beskrivning;
	int utgangspris;
	int kategoriId;
	private String leveranstrId;
	@Override
	public String toString() {
		return getNamn(); 
	}
	public String getProduktId() {
		return produktId;
	}
	public void setProduktId(String produktId) {
		this.produktId = produktId;
	}
	public String getNamn() {
		return namn;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String getLeveranstrId() {
		return leveranstrId;
	}
	public void setLeveranstrId(String leveranstrId) {
		this.leveranstrId = leveranstrId;
	}
	
	

}
