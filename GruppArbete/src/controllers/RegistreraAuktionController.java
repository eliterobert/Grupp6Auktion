package controllers;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import application.Main;
import application.Model;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import tables.Auktion;
import tables.Produkt;

public class RegistreraAuktionController implements Initializable {

	@FXML
	TextField acceptprisTF;
	@FXML
	Button button;
	@FXML
	DatePicker startdatumDP;
	@FXML
	DatePicker slutdatumDP;
	@FXML
	ComboBox<LocalTime> startBox;
	@FXML
	ComboBox<LocalTime> slutBox;
	@FXML
	ComboBox<Produkt> produktBox;
	ArrayList<Produkt> produktList = new ArrayList<>();
	ArrayList<Auktion> auktionList = new ArrayList<>();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		button.setDisable(true);

		produktBox.setOnAction(e -> {
			slutBox.setOnAction(ea -> {
				if (acceptprisTF.getText() != null && startdatumDP.getValue() != null
						&& slutdatumDP.getValue() != null) {
					button.setDisable(false);
				}
			});
		});

		ResultSet rs = null;
		setTimesComboB();
		try {
			PreparedStatement prep = Model.MODEL.getConnection().prepareStatement(
					"select produkt.produktId, produkt.namn , leverantör.leverantörId from produkt inner join leverantör on produkt.leverantörId = leverantör.leverantörId WHERE leverantör.leverantörId = ?");
			prep.setString(1, LeverantorLoginController.test);
			rs = prep.executeQuery();
			while (rs.next()) {
				Produkt p = new Produkt();
				p.setProduktId(rs.getString(1));
				p.setNamn(rs.getString(2));
				p.setLeveranstrId(rs.getString(3));
				produktList.add(p);
				produktBox.getItems().add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		button.setOnAction(e -> {
			try {
				PreparedStatement pstm = Model.MODEL.getConnection().prepareStatement(
						"INSERT INTO auktioner (ProduktId, acceptpris,`start`,slut) VALUES (?,?,?,?)");
				pstm.setString(1, produktBox.getValue().getProduktId());
				pstm.setString(2, acceptprisTF.getText());
				pstm.setString(3, startdatumDP.getValue() + " " + startBox.getValue());
				pstm.setString(4, slutdatumDP.getValue() + " " + slutBox.getValue());
				pstm.executeUpdate();
				System.out.println("Produkt Inlagd");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			Main.stage1.close();
		});

	}

	private void setTimesComboB() {
		LocalTime interval = LocalTime.MIDNIGHT;
		//
		for (int i = 0; i < 96; i++) {
			startBox.getItems().add(interval);
			slutBox.getItems().add(interval);
			interval = interval.plusMinutes(15);
		}
		LocalTime startTime = LocalTime.of(LocalTime.now().getHour(), 00);
		for (int i = 0; i < 4; i++) {
			// set the start time to the soonest 15-minute block.
			if (startTime.isAfter(LocalTime.now())) {
				startBox.setValue(startTime);
				slutBox.setValue(startTime);

				break;
			}
			startTime = startTime.plusMinutes(15);
		}
		startBox.setValue(startTime);
	}
}
