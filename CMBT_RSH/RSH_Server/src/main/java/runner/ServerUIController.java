package runner;
import data.daohelperimpl.jdbc.Values;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ServerUIController {

    @FXML
    private TextField passwordField;

    @FXML
    private Button startServerButton;

    @FXML
    private Button closeServerButton;


    @FXML
    void finishSetPassword(ActionEvent event) {
    	String password = passwordField.getText();
    	Values.getInstance().setPassword(password);
    	Stage stage = (Stage)passwordField.getScene().getWindow();
    	stage.close();
    }
    @FXML
    void closeServer(MouseEvent event) {

    }

    @FXML
    void startServer(MouseEvent event) {
    	String password = passwordField.getText();
    	Values.getInstance().setPassword(password);
    }

}