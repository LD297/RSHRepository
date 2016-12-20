package presentation.websalesmancontroller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by a297 on 16/12/18.
 */
public class TopUpCreditUIController {
    private AnchorPane prePane;

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField userIdTextField;

    @FXML
    private Button backButton;

    @FXML
    private TextField topNumTextField;

    @FXML
    private Button confirmButton;

    @FXML
    void confirmButtonClicked(MouseEvent event) {
        // TODO
        backButtonClicked(null);
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setX(320);
        stage.setY(46);
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());

    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '信用充值界面.fxml'.";
        assert userIdTextField != null : "fx:id=\"userIdTextField\" was not injected: check your FXML file '信用充值界面.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '信用充值界面.fxml'.";
        assert topNumTextField != null : "fx:id=\"topNumTextField\" was not injected: check your FXML file '信用充值界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '信用充值界面.fxml'.";

    }
}
