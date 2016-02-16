package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserLoginController implements Initializable {

	@FXML
	Button loginButton;
	@FXML
	PasswordField passwordField;
	@FXML
	ComboBox<String> comboBox;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		PreparedStatement preparedStatement = null;

		try {
			preparedStatement = Model.MODEL.getConnection().prepareStatement("SELECT personnummer FROM kund");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				comboBox.getItems().add(rs.getString(1));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
