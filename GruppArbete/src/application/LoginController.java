package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LoginController implements Initializable {

	@FXML
	Button kundLoginButton, leverantorLoginButton, registreraKundButton, registreraLevButton;

	Main main = new Main();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		kundLoginButton.setOnAction(e -> {
			main.logIn();
			Model.getConnection();
		});
		leverantorLoginButton.setOnAction(e-> {
			main.logIn();
			
		});

	}

}
