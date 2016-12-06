package presentation.usercontroller;

/**
 * Created by john on 2016/12/5.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class GuideUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView backImage;

    @FXML
    private TextField whereToGoField;

    @FXML
    private Label helpLabel;

    @FXML
    private Label logoutLabel;

    @FXML
    private ImageView headImage;

    @FXML
    private ImageView headMaskImage;

    private AnchorPane lastPane = null;

    @FXML
    void changeToHeplInfo(MouseEvent event) {

    }

    @FXML
    void changeToLogin(MouseEvent event) {

    }

    @FXML
    void changeToSearchHotel(ActionEvent event) {

    }

    @FXML
    void changeToUserInfo(MouseEvent event) {

    }

    @FXML
    void back(MouseEvent event) {

    }

    void setLastPane(AnchorPane lastPane){this.lastPane = lastPane; }

    @FXML
    void initialize() {
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '导航栏.fxml'.";
        assert whereToGoField != null : "fx:id=\"whereToGoField\" was not injected: check your FXML file '导航栏.fxml'.";
        assert helpLabel != null : "fx:id=\"helpLabel\" was not injected: check your FXML file '导航栏.fxml'.";
        assert logoutLabel != null : "fx:id=\"logoutLabel\" was not injected: check your FXML file '导航栏.fxml'.";
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '导航栏.fxml'.";
        assert headMaskImage != null : "fx:id=\"headMaskImage\" was not injected: check your FXML file '导航栏.fxml'.";

    }
}

