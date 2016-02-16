package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class LeverantorSidanController implements Initializable {

	
	@FXML
	Button button;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

		button.setOnAction(e-> {
			Model.MODEL.main.logIn("RegistreraProdukt", 600, 600);
		});
	}

}
