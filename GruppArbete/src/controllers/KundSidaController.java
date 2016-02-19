package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.ResourceBundle;

import application.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tables.ListaBud;

public class KundSidaController implements Initializable {

	@FXML
	Button button, button2;
	@FXML
	TableView<ListaBud> tableVie;
	@FXML
	TableColumn<ListaBud, String> namnCol;
	@FXML
	TableColumn<ListaBud, String> beskrivningCol;
	@FXML
	TableColumn<ListaBud, String> auktionCol;
	@FXML
	TableColumn<ListaBud, String> budCol;
	@FXML
	TableColumn<ListaBud, String> fornamnCol;

	private ObservableList<ListaBud> levLista;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		levLista = FXCollections.observableArrayList();

		try (Statement stm = Model.MODEL.getConnection().createStatement()) {
			ResultSet rs = stm.executeQuery(
					"SELECT auktioner.auktionid, produkt.namn,produkt.beskrivning, max(bud.belopp), kund.förnamn FROM auktioner LEFT JOIN bud on auktioner.auktionID = bud.auktionID LEFT JOIN kund ON bud.kundID = kund.Personnummer INNER JOIN produkt on produkt.produktId = auktioner.produktId GROUP BY auktioner.auktionId");
			while (rs.next()) {
				levLista.add(new ListaBud(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5)));
			}
			tableVie.getItems().setAll(levLista);
			auktionCol.setCellValueFactory(cellData -> cellData.getValue().getAuktionId());
			namnCol.setCellValueFactory(cellData -> cellData.getValue().getNamn());
			beskrivningCol.setCellValueFactory(cellData -> cellData.getValue().getBeskrivning());
			budCol.setCellValueFactory(cellData -> cellData.getValue().getBud());
			fornamnCol.setCellValueFactory(cellData -> cellData.getValue().getFornamn());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
