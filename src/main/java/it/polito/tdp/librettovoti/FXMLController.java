package it.polito.tdp.librettovoti;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ResourceBundle;

import it.polito.tdp.librettovoti.model.Libretto;
import it.polito.tdp.librettovoti.model.Voto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Libretto model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtEsame;

    @FXML
    private TextField txtVoto;

    @FXML
    private DatePicker dateEsame;

    @FXML
    private TextArea txtResult;

    @FXML
    void handleInserisci(ActionEvent event) {
    	String nomeEsame = txtEsame.getText();
    	if(nomeEsame.length() == 0) {
    		txtResult.setText("ERRORE: nome esame vuoto");
    		return;
    	}
    	
    	String votoEsame = txtVoto.getText();
    	int votoInt = 0;
    	try {
    		votoInt = Integer.parseInt(votoEsame);
    	}
    	catch(NumberFormatException nfe) {
    		txtResult.setText("ERRORE: il voto deve essere numerico");
    		return;
    	}
    	if(votoInt < 18 || votoInt > 30) {
    		txtResult.setText("ERRORE: il voto deve essere compreso tra 18 e 30");
    		return;
    	}
    	
    	/*String dataEsame = txtData.getText();
    	LocalDate data;
    	try {
    		data = LocalDate.parse(dataEsame);
    	}
    	catch(DateTimeParseException dtpe) {
    		txtResult.setText("ERRORE: formato data non valido");
    		return;
    	}*/
    	LocalDate data = dateEsame.getValue();
    	if(data == null) {
    		txtResult.setText("ERRORE: data non presente");
    		return;
    	}
    	Voto voto = new Voto(nomeEsame, votoInt, data);
    	model.add(voto);
    	
    	txtResult.setText(model.toString());
    	txtEsame.clear();
    	txtVoto.clear();	
    	dateEsame.setValue(null);
    }
    
    public void setModel(Libretto model) {
    	this.model = model;
    }
    
    @FXML
    void initialize() {
        assert txtEsame != null : "fx:id=\"txtEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtVoto != null : "fx:id=\"txtVoto\" was not injected: check your FXML file 'Scene.fxml'.";
        assert dateEsame != null : "fx:id=\"dateEsame\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
