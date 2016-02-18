package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import application.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tables.Historik;

public class LeverantorSidanController implements Initializable {

	@FXML
	Button button, button2;
	@FXML
	TableView<Historik> tableVie;
	@FXML
	TableColumn<Historik, String> namnCol;
	@FXML
	TableColumn<Historik, String> beskrivningCol;
	@FXML
	TableColumn<Historik, String> auktionCol;
	@FXML
	TableColumn<Historik, String> slutCol;
	private LinkedList<Historik> levList;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		levList = new LinkedList<>();
		try {
			PreparedStatement prep = Model.MODEL.getConnection().prepareStatement(
					"select leverantör.namn as 'Leverantör', produkt.beskrivning as 'Produkt', auktioner.auktionId, auktioner.slut as 'Slut Tid' from leverantör inner join produkt on produkt.leverantörId = leverantör.leverantörId inner join auktioner on auktioner.produktId = produkt.produktId where leverantör.namn = ? group by auktioner.produktId");
			prep.setString(1, LeverantorLoginController.test2);
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				levList.add(new Historik(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			tableVie.getItems().setAll(levList);
			namnCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("namn"));
			beskrivningCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("beskrivning"));
			auktionCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("auktionsId"));
			slutCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("auktionSlut"));
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		button.setOnAction(e -> {
			Model.MODEL.getMain().logIn("RegistreraProdukt", 260, 420);
		});
		button2.setOnAction(e -> {
			Model.MODEL.getMain().logIn("RegistreraAuktion", 370, 400);
		});
		
		
	}

}
