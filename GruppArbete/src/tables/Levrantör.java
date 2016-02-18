package tables;


public class Levrantör {
	private String leveransörId;
	private String namn;
	private String epost;
	String telefon;
	String gatuadress;
	String ort;
	private float provisionsniva;
	@Override
	public String toString() {
		return getNamn();
	}
	public String getLeveransörId() {
		return leveransörId;
	}
	public void setLeveransörId(String leveransörId) {
		this.leveransörId = leveransörId;
	}
	public String getNamn() {
		return namn;
	}
	public void setNamn(String namn) {
		this.namn = namn;
	}
	public String getEpost() {
		return epost;
	}
	public void setEpost(String epost) {
		this.epost = epost;
	}
	public float getProvisionsniva() {
		return provisionsniva;
	}
	public void setProvisionsniva(float provisionsniva) {
		this.provisionsniva = provisionsniva;
	}
	
	
	
}
