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

		kundLoginButton.setOnAction(e -> {
			main.logIn("UserLogin", 270, 150);
		});
		leverantorLoginButton.setOnAction(e -> {
			main.logIn("LeverantorLogin", 270, 150);
		});
		registreraLevButton.setOnAction(e -> {
			main.logIn("RegistreraLeverantor", 400, 300);
		});
		registreraKundButton.setOnAction(e -> {
			main.logIn("RegistreraKund", 400, 350);

		});

	}

}
