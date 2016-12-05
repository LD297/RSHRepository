package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/5.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.HotelUIFactory;

public class HotelBasicInfoUIController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button confirmButton;

    private AnchorPane prePane;

    @FXML
    void confimButtonClicked(MouseEvent event){
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '酒店信息维护.fxml'.";

    }

    public void setAnchorPane(AnchorPane anchorePane){
        this.anchorPane = anchorePane;
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
}
