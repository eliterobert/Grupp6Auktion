package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class StartSidaController implements Initializable {

	@FXML
	Button kundLoginButton, leverantorLoginButton, registreraKundButton, registreraLevButton;

	Main main = new Main();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		kundLoginButton.setOnAction(e -> {
			main.logIn("KundLogin", 250, 350);
		});
		leverantorLoginButton.setOnAction(e -> {
			main.logIn("LeverantorLogin", 250, 350);
		});
		registreraLevButton.setOnAction(e -> {
			main.logIn("RegistreraLeverantor", 400, 420);
		});
		registreraKundButton.setOnAction(e -> {
			main.logIn("RegistreraKund", 400, 420);

		});

	}

}
