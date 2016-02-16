package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegistreraKund implements Initializable {

	@FXML
	TextField personnummerField, efternamnField, fornamnField, adressField, postnummerField, ortField, nummerField,
			epostField;
	@FXML
	Button button, closeButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		button.setOnAction(e -> {
			try {
				PreparedStatement pS = Model.MODEL.getConnection().prepareStatement(
						"INSERT INTO kund (personnummer, efternamn, förnamn, gatuadress, postnummer, ort, telefon, epost) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
				pS.setString(1, personnummerField.getText());
				pS.setString(2, efternamnField.getText());
				pS.setString(3, fornamnField.getText());
				pS.setString(4, adressField.getText());
				pS.setString(5, postnummerField.getText());
				pS.setString(6, ortField.getText());
				pS.setString(7, nummerField.getText());
				pS.setString(8, epostField.getText());
				pS.executeUpdate();
				System.out.println("Kund inlagd");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			personnummerField.clear();
			epostField.clear();
			nummerField.clear();
			adressField.clear();
			postnummerField.clear();
			ortField.clear();
			Main.stage1.close();

		});

	}

}
