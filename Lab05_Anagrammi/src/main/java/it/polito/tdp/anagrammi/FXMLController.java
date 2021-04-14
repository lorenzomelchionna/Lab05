package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.anagrammi.model.Anagrammi;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Anagrammi model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private TextArea txtOutput;

    @FXML
    void doAnagramma(ActionEvent event) {
    	
    	if(txtParola.getText() == null || txtParola.getText().equals("")) {
    		txtOutput.setText("Devi inserire una parola!");
    		return;
    	}
    	
    	List<String> AnagrammiCorretti = model.AnagrammiParola(txtParola.getText());
    	
    	if(AnagrammiCorretti.size() == 0) {
    		txtOutput.setText("Non ci sono anagrammi corretti!");
    		return;
    	}
    	
    	for(String s : AnagrammiCorretti)
    		txtOutput.appendText(s+"\n");

    }
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtParola.clear();
    	
    	txtOutput.clear();
    	
    }
    
    public void setModel(Anagrammi model) {
    	
    	this.model = model;
    	
    }

    @FXML
    void initialize() {
    	
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtOutput != null : "fx:id=\"txtOutput\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
