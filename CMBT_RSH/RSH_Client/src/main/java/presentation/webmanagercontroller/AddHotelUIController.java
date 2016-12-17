package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.tools.WebManagerUIFXMLFactory;

/**
 * 网站管理人员添加酒店界面
 * @author john
 *
 */
public class AddHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hotelNameField;

    @FXML
    private ComboBox<?> provinceCombox;

    @FXML
    private ComboBox<?> districtCombox;

    @FXML
    private ComboBox<?> cityCombox;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private ImageView cancelImage;

    @FXML
    private Button finishAddHotel;

    @FXML
    private TextField passwordField;

    @FXML
    void ToSetDistrictCombox(ActionEvent event) {

    }

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeAddHotel(MouseEvent event) {
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
    }

    @FXML
    void finifshAddHotel(MouseEvent event) {
    	//TODO 添加酒店信息，reset 管理酒店界面
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
    	AnchorPane successAddHotel = WebManagerUIFXMLFactory.getInstance().getSuccessAddHotel();
    	manageHotel.getChildren().add(successAddHotel);
    }

    @FXML
    void toSetCityCombox(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert hotelNameField != null : "fx:id=\"hotelNameField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert provinceCombox != null : "fx:id=\"provinceCombox\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert districtCombox != null : "fx:id=\"districtCombox\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert addressField != null : "fx:id=\"addressField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert finishAddHotel != null : "fx:id=\"finishAddHotel\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";

    }
}
