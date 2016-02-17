package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/*
 * int auktionId;
	int produktId;
	int acceptpris;
	Date start;
	Date slut;
	int slutpris;
 */

public class RegistreraAuktion implements Initializable{
	
	@FXML
	TextField produktnamnTF, acceptprisTF;
	@FXML
	Button saveB, cancelB;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
}
