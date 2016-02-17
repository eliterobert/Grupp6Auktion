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

public class KundSidaController  implements Initializable{
	
	
	
	@FXML 
	Button button;
	@FXML
	TableView<Historik> tableVie;
	@FXML
	TableColumn <Historik , String> namnCol;
	@FXML
	TableColumn <Historik , String> beskrivningCol;
	@FXML
	TableColumn <Historik, String> auktionCol;
	@FXML
	TableColumn <Historik, String> startCol;
	@FXML 
	TableColumn <Historik , String> slutCol;
    private LinkedList <Historik> levList;
    
    public void initialize(URL arg0, ResourceBundle arg1) {
    	levList = new LinkedList<>();
    try{
    	PreparedStatement prep =  Model.MODEL.getConnection().prepareStatement("select produkt.beskrivning , produkt.namn , bud.belopp , auktion.`start` , auktion.slut from bud inner join auktion on bud.auktionId = auktion.auktionId inner join produkt on auktion.auktionId = produkt.produktId");
    	ResultSet rs = prep.executeQuery();
    	while(rs.next()){
    		levList.add(new Historik(rs.getString(2),rs.getString(1),rs.getString(4) ,rs.getString(3), rs.getString(5)));
    	}
    	tableVie.getItems().setAll(levList);
    	namnCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("namn"));
    	beskrivningCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("beskrivingin"));
    	auktionCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("belopp"));
    	startCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("auktionStart"));
    	slutCol.setCellValueFactory(new PropertyValueFactory<Historik, String>("auktionSlut"));
    }catch(SQLException e){
    	e.printStackTrace();
    }
    button.setOnAction(e-> {
    
    });
    	
    }
}
