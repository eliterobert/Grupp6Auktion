package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import tables.Kategori;

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
		button.setDisable(true);
		comboBox.setOnAction(e -> {
			if (namnField.getText() == "" && utgangField.getText() == "" && beskrivningField.getText() == "") {
				button.setDisable(true);
			} else {
				button.setDisable(false);
			}
		});
		try (Statement stm = Model.MODEL.getConnection().createStatement()) {
			ResultSet rs = stm.executeQuery("SELECT * FROM kategori");
			while (rs.next()) {
				Kategori kat = new Kategori();
				kat.setKategoriId(rs.getString("kategoriId"));
				kat.setNamn(rs.getString("namn"));
				produktLista.add(kat);
				comboBox.getItems().add(kat);
			}
			button.setOnAction(e -> {
				try {
					PreparedStatement pS = Model.MODEL.getConnection().prepareStatement(
							"INSERT INTO produkt (Namn, Beskrivning , kategoriId,leverantörId) VALUES (?,?,?,?)");
					pS.setString(1, namnField.getText());
					pS.setString(2, beskrivningField.getText());
					pS.setString(3, comboBox.getValue().getKategoriId());
					pS.setString(4, LeverantorLoginController.test);
					pS.executeUpdate();
					System.out.println("Produkt inlagd");
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				Main.stage1.close();
			});

		} catch (SQLException e2) {
			e2.printStackTrace();
		}
	}
}
