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

public class LeverantorSidanController implements Initializable {

	@FXML
	Button button;
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

	LinkedList<Historik> levList = new LinkedList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		try {
			PreparedStatement prep = Model.MODEL.getConnection().prepareStatement(
					"select leverantör.namn as 'Leverantör', produkt.beskrivning as 'Produkt', auktion.auktionId, auktion.slut as 'Slut Tid' from leverantör inner join produkt on produkt.leverantörId = leverantör.leverantörId inner join auktion on auktion.produktId = produkt.produktId where leverantör.namn = ? group by auktion.produktId");
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// tableView.getItems().setAll(col)
		button.setOnAction(e -> {
			 Model.MODEL.main.logIn("RegistreraProdukt", 400, 225);
		});
	}

}
