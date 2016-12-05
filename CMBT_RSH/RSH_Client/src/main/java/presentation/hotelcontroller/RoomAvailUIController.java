package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/5.
 */
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class RoomAvailUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button backButton;

    @FXML
    private Button confirmButton;

    private static AnchorPane prePane;

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {
        // TODO 条件判断
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '可用客房信息维护.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '可用客房信息维护.fxml'.";

    }

    public void setAnchorPane(AnchorPane anchorPane) {
        this.anchorPane = anchorPane;
    }
}

