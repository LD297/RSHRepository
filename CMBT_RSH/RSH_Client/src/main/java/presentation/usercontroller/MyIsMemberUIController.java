package presentation.usercontroller;

/**
 * Created by john on 2016/12/8.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MyIsMemberUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label membertypeLabel;

    @FXML
    private Label registertimeLabel;

    @FXML
    void initialize() {
        assert membertypeLabel != null : "fx:id=\"membertypeLabel\" was not injected: check your FXML file '我的会员（是会员）.fxml'.";
        assert registertimeLabel != null : "fx:id=\"registertimeLabel\" was not injected: check your FXML file '我的会员（是会员）.fxml'.";

    }
}

