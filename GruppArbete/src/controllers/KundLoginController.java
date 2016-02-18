package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import tables.Kund;

public class KundLoginController implements Initializable {

	@FXML
	Button loginButton;
	@FXML
	PasswordField passwordField;
	@FXML
	ComboBox<Kund> comboBox;

	private ArrayList<Kund> kundList;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		kundList = new ArrayList<>();

		try (Statement stm = Model.MODEL.getConnection().createStatement()) {
			ResultSet rs = stm.executeQuery("SELECT * FROM kund");
			while (rs.next()) {
				Kund kund = new Kund();
				kund.setFörnamn(rs.getString("Förnamn"));
				kund.setEfternamn(rs.getString("Efternamn"));
				kund.setPersonnummer(rs.getString("personnummer"));
				comboBox.getItems().add(kund);
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		loginButton.setOnAction(e -> {
			Main.stage1.close();
			Model.MODEL.getMain().logIn("KundSida", 670, 730);
		});

	}

}
