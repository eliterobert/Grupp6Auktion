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

public class LeverantorLoginController implements Initializable {

	@FXML
	Button loginButton;
	@FXML
	ComboBox<Levrantör> comboBox;

	public static String test;
	public static String test2;

	private ArrayList<Levrantör> levLista = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		loginButton.setOnAction(e -> {
			test = comboBox.getValue().leveransörId;
			test2 = comboBox.getValue().namn;
			Main.stage1.close();
			Model.MODEL.main.logIn("LeverantorSidan", 730, 560);

		});
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Model.MODEL.getConnection().prepareStatement("SELECT * FROM leverantör");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Levrantör lev = new Levrantör();
				lev.leveransörId = rs.getString("leverantörId");
				lev.namn = rs.getString("namn");
				lev.epost = rs.getString("epost");
				lev.provisionsniva = rs.getFloat("provisionsnivå");
				levLista.add(lev);
				comboBox.getItems().add(lev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
