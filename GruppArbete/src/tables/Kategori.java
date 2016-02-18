package tables;

public class Kategori {

	private String kategoriId;
	private String namn;

	@Override
	public String toString() {
		return getNamn();
	}

	public String getKategoriId() {
		return kategoriId;
	}

	public void setKategoriId(String kategoriId) {
		this.kategoriId = kategoriId;
	}

	public String getNamn() {
		return namn;
	}

	public void setNamn(String namn) {
		this.namn = namn;
	}

}
