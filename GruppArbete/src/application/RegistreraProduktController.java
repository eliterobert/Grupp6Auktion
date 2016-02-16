package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class RegistreraProduktController implements Initializable {

	@FXML
	TextField namnField, utgangField, beskrivningField;
	@FXML
	ComboBox<Kategori> comboBox;
	@FXML
	Button button;

	private ArrayList<Kategori> produktLista = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Model.MODEL.getConnection().prepareStatement("SELECT * FROM kategori");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Kategori kat = new Kategori();
				kat.kategoriId = rs.getString("kategoriId");
				kat.namn = rs.getString("namn");
				produktLista.add(kat);
				comboBox.getItems().add(kat);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		button.setOnAction(e -> {
			try {
				PreparedStatement pS = Model.MODEL.getConnection().prepareStatement(
						"INSERT INTO produkt (Namn, Beskrivning , kategoriId,leverantörId) VALUES (?,?,?,?)");
				pS.setString(1, namnField.getText());
				pS.setString(2, beskrivningField.getText());
				pS.setString(3, comboBox.getValue().kategoriId);
				pS.setString(4, LeverantorLoginController.test);
				pS.executeUpdate();
				System.out.println("Produkt inlagd");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Main.stage1.close();

		});

	}

}
