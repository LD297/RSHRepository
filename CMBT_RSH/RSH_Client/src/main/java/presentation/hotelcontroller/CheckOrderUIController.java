package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class CheckOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button backButton;

    private AnchorPane prePane;

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '订单搜索并浏览（酒店）.fxml'.";

    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
}

