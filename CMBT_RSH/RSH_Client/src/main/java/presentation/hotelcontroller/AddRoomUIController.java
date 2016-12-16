package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class AddRoomUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField roomPriceTextField;

    @FXML
    private Button backButton;

    @FXML
    private Button confirmButton;

    @FXML
    private CheckBox basicCheckBox;

    @FXML
    private CheckBox specialCheckBox;

    @FXML
    private TextField roomNumTextField;

    @FXML
    private TextField roomTypeTextField;

    @FXML
    private AnchorPane anchorPane;


    @FXML
    void confirmButtonClicked(MouseEvent event) {

    }

    @FXML
    void backButtonClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert roomPriceTextField != null : "fx:id=\"roomPriceTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert basicCheckBox != null : "fx:id=\"basicCheckBox\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert specialCheckBox != null : "fx:id=\"specialCheckBox\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomNumTextField != null : "fx:id=\"roomNumTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomTypeTextField != null : "fx:id=\"roomTypeTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '添加客房界面.fxml'.";

    }
}
