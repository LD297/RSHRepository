package runner;
import data.daohelperimpl.jdbc.Values;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ServerUIController {

    @FXML
    private TextField passwordField;

    @FXML
    void finishSetPassword(ActionEvent event) {
    	String password = passwordField.getText();
    	Values.getInstance().setPassword(password);
    	Stage stage = (Stage)passwordField.getScene().getWindow();
    	stage.close();
    }
   
}