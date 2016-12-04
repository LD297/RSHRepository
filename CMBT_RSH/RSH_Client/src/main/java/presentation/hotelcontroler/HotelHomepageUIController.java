package presentation.hotelcontroler;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HotelHomepageUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView basicInfo;

    @FXML
    void changeToBasicInfo(ActionEvent event) {
        System.out.println("basicInfo");
    }

    @FXML
    void initialize() {
        assert basicInfo != null : "fx:id=\"basicInfo\" was not injected: check your FXML file '酒店首页.fxml'.";

    }
}
