package controllers;

import java.net.URL;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ResourceBundle;

import application.Model;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tables.Historik;
import tables.Manad;
import tables.ProviHistorik;
import tables.TotalHistorik;

public class LeverantorSidanController implements Initializable {

	@FXML
	Label provisionLabel;
	@FXML
	ComboBox<Manad> manadBox;
	@FXML
	Button button, button2, visaButton, button4, manadButton;
	@FXML
	TableView<Historik> tableVie;
	@FXML
	TableView<ProviHistorik> tableView2;
	@FXML
	TableView<TotalHistorik> tableView3;
	@FXML
	TableColumn<TotalHistorik, String> personnummerCol;
	@FXML
	TableColumn<TotalHistorik, String> efternamnetCol;
	@FXML
	TableColumn<TotalHistorik, String> fornamnetCol;
	@FXML
	TableColumn<TotalHistorik, String> totalVardeCol;
	@FXML
	TableColumn<ProviHistorik, String> leverantorCol;
	@FXML
	TableColumn<ProviHistorik, String> idCol;
	@FXML
	TableColumn<ProviHistorik, String> produktNamnCol;
	@FXML
	TableColumn<ProviHistorik, String> provisionCol;
	@FXML
	TableColumn<ProviHistorik, String> proviNivCol;
	@FXML
	TableColumn<Historik, String> namnCol;
	@FXML
	TableColumn<Historik, String> beskrivningCol;
	@FXML
	TableColumn<Historik, String> auktionCol;
	@FXML
	TableColumn<Historik, String> slutCol;
	@FXML
	DatePicker startPicker;
	@FXML
	DatePicker stopPicker;
	@FXML
	Tab tab3;

	private LinkedList<Historik> levList;
	private ObservableList<ProviHistorik> proviHistorik;
	private ObservableList<TotalHistorik> totalHistorik;
	private ArrayList<Manad> manadList = new ArrayList<>();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		levList = new LinkedList<>();
		proviHistorik = FXCollections.observableArrayList();
		totalHistorik = FXCollections.observableArrayList();

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
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		visaButton.setDisable(true);
		stopPicker.setOnAction(e -> {
			if (startPicker.getValue() != null && stopPicker.getValue() != null) {
				visaButton.setDisable(false);
			}
		});

		visaButton.setOnAction(e -> {
			try (CallableStatement callS = Model.MODEL.getConnection().prepareCall("{call auktionInomTid(?,?)}")) {
				callS.setString(1, startPicker.getValue().toString());
				callS.setString(2, stopPicker.getValue().toString());
				ResultSet rs = callS.executeQuery();
				while (rs.next()) {
					proviHistorik.add(new ProviHistorik(rs.getString(1), rs.getString(2), rs.getString(3),
							rs.getString(4), rs.getString(5)));
				}
				tableView2.getItems().setAll(proviHistorik);
				leverantorCol.setCellValueFactory(cellData -> cellData.getValue().getNamn());
				idCol.setCellValueFactory(cellData -> cellData.getValue().getAuktionId());
				produktNamnCol.setCellValueFactory(cellData -> cellData.getValue().getProduktNamn());
				provisionCol.setCellValueFactory(cellData -> cellData.getValue().getProvision());
				proviNivCol.setCellValueFactory(cellData -> cellData.getValue().getProvisionsNiva());
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		button4.setOnAction(e -> {
			try (Statement stm = Model.MODEL.getConnection().createStatement();
					ResultSet rs = stm.executeQuery(
							"SELECT kund.personnummer, kund.efternamn,kund.förnamn ,sum(auktionhistorik.slutpris) as totalordervärde From kund INNER JOIN bud ON kund.personnummer=bud.kundId INNER JOIN auktionhistorik ON bud.budId= auktionhistorik.vinnandebudId GROUP BY kund.personnummer")) {

				while (rs.next()) {
					totalHistorik
							.add(new TotalHistorik(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4)));

				}
				tableView3.getItems().addAll(totalHistorik);
				personnummerCol.setCellValueFactory(cellData -> cellData.getValue().getPersonnumer());
				efternamnetCol.setCellValueFactory(cellData -> cellData.getValue().getEfternamn());
				fornamnetCol.setCellValueFactory(cellData -> cellData.getValue().getFornamn());
				totalVardeCol.setCellValueFactory(cellData -> cellData.getValue().getTotal());
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		});

		button.setOnAction(e -> {
			Model.MODEL.getMain().logIn("RegistreraProdukt", 260, 420);
		});
		button2.setOnAction(e -> {
			Model.MODEL.getMain().logIn("RegistreraAuktion", 370, 400);
		});

		manadBox.getItems().addAll(Model.MODEL.adderaManader(manadList));
		manadButton.setDisable(true);
		manadBox.setOnAction(e-> {
			manadButton.setDisable(false);
		});
		manadButton.setOnAction(e -> {
			try {
				CallableStatement call = Model.MODEL.getConnection().prepareCall("{call totalProvPerMån(?)}");
				call.setInt(1, manadBox.getValue().getNummer());
				ResultSet rs = call.executeQuery();
				while (rs.next()) {
					if (rs.getInt(1) == 0) {
						provisionLabel.setText("Inget sålt!");
					} else
						provisionLabel.setText(rs.getString(1) + " Kr");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}

		});

	}

}
