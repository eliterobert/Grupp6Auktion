package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import tables.Levrantör;

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
		loginButton.setDisable(true);
		comboBox.setOnAction(e -> {
			loginButton.setDisable(false);
		});
		loginButton.setOnAction(e -> {
			Main.stage1.close();
			test = comboBox.getValue().getLeveransörId();
			test2 = comboBox.getValue().getNamn();
			Main.stage1.close();
			Model.MODEL.getMain().logIn("LeverantorSidan", 620, 765);
		});
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = Model.MODEL.getConnection().prepareStatement("SELECT * FROM leverantör");
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Levrantör lev = new Levrantör();
				lev.setLeveransörId(rs.getString("leverantörId"));
				lev.setNamn(rs.getString("namn"));
				lev.setEpost(rs.getString("epost"));
				lev.setProvisionsniva(rs.getFloat("provisionsnivå"));
				levLista.add(lev);
				comboBox.getItems().add(lev);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
