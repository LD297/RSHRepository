package presentation.hotelcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.HotelUIFactory;

public class HotelHomepageUIController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView promotin;

    @FXML
    private ImageView executeOrder;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView whiteBackground;

    @FXML
    private ImageView checkOrder;

    @FXML
    private ImageView roomAvail;

    @FXML
    private ImageView basicInfo;

    private AnchorPane nextAnchorPane;

    @FXML
    void changeToBasicInfoUI(MouseEvent event) {
        try {
            nextAnchorPane = HotelUIFactory.getInstance().getHotelInfoLoader().load();
            anchorPane.getChildren().add(nextAnchorPane);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void changeToPromotionUI(ActionEvent event) {

    }

    @FXML
    void changeToExecuteOrderUI(ActionEvent event) {

    }

    @FXML
    void changeToCheckOrderUI(ActionEvent event) {

    }

    @FXML
    void changeToRoomAvailUI(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert promotin != null : "fx:id=\"promotin\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert executeOrder != null : "fx:id=\"executeOrder\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert whiteBackground != null : "fx:id=\"whiteBackground\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert checkOrder != null : "fx:id=\"checkOrder\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert roomAvail != null : "fx:id=\"roomAvail\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert basicInfo != null : "fx:id=\"basicInfo\" was not injected: check your FXML file '酒店首页.fxml'.";

    }
}
