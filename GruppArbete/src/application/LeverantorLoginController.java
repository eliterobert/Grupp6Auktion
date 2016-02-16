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

public class LeverantorLoginController implements Initializable {

	@FXML
	Button loginButton;
	@FXML
	ComboBox<String> comboBox;
	
	public static String test;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		
		loginButton.setOnAction(e -> {
			test = comboBox.getValue();
			Main.stage1.close();
			Model.MODEL.main.logIn("LeverantorSidan", 730, 560);

		});
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Model.MODEL.getConnection().prepareStatement("SELECT leverantörId FROM leverantör");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				comboBox.getItems().add(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
