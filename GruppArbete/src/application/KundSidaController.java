package application;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class KundSidaController implements Initializable {

	@FXML
	Button button;
	@FXML
	TableView<Historik> tableVie;
	@FXML
	TableColumn<Historik, String> namnCol;
	@FXML
	TableColumn<Historik, String> beskrivningCol;
	@FXML
	TableColumn<Historik, String> slutCol;
	@FXML
	TableColumn<Historik, String> beloppCol;

	private LinkedList<Historik> levList;

	public void initialize(URL arg0, ResourceBundle arg1) {
		levList = new LinkedList<>();
		try {
			PreparedStatement prep = Model.MODEL.getConnection().prepareStatement(
					"select produkt.beskrivning,produkt.namn,bud.belopp,auktioner.slut from bud inner join auktioner on bud.auktionId = auktioner.auktionId inner join produkt on auktioner.auktionId = produkt.produktId group by produkt.produktId");
			ResultSet rs = prep.executeQuery();
			while (rs.next()) {
				levList.add(new Historik(rs.getString("produkt.namn"), rs.getString("produkt.beskrivning"),
						rs.getString("auktioner.slut"), rs.getString("bud.belopp")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		tableVie.getItems().setAll(levList);
		System.out.println(levList);
		namnCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("namn"));
		beskrivningCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("beskrivning"));
		slutCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("auktionSlut"));
	}
}
