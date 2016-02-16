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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class KundLoginController implements Initializable {

	@FXML
	Button loginButton;
	@FXML
	PasswordField passwordField;
	@FXML
	ComboBox<Kund> comboBox;
	
	ArrayList<Kund> kundList = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = Model.MODEL.getConnection().prepareStatement("SELECT * FROM kund");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Kund kund = new Kund();
				kund.förnamn = rs.getString("Förnamn");
				kund.efternamn = rs.getString("Efternamn");
				kund.personnummer = rs.getString("personnummer");
				comboBox.getItems().add(kund);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
