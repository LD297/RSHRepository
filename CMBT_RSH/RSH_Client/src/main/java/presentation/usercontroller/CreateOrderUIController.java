package presentation.usercontroller;

/**
 * Created by john on 2016/12/8.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;

public class CreateOrderUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label hotelName;

    @FXML
    private Label hoteladdressLabel;

    @FXML
    private Label hotelPhonenumberLabel;

    @FXML
    private Label userPhoneNumberLabel;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label memberLevelLabel;

    @FXML
    private Label userCreditLabel;

    @FXML
    private Label dateOfOrderCreatedLabel;

    @FXML
    private Label latestCheckinTimeLabel;

    @FXML
    private Label priceOfPerRoomLabel;

    @FXML
    private Label totalPriceLabel;

    @FXML
    private Button finishCreateOrder;

    @FXML
    private ImageView cancelImage;

    @FXML
    private DatePicker expectedCheckinTimepicker;

    @FXML
    private DatePicker expectedCheckoutTimepicker;

    @FXML
    private Label messageLabel;

    @FXML
    private ComboBox<?> roomtypeCombox;

    @FXML
    private ComboBox<?> peopleNumombox;

    @FXML
    private ComboBox<?> withChildrenCombox;

    @FXML
    private ComboBox<?> roomnumCombox;
    
    private String userID = null;
    private String hotelname = null;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeCreateOrder(MouseEvent event) {
        UIJumpTool.getUiJumpTool().closeCreateOrder();
    }

    @FXML
    void finishCreateOrder(MouseEvent event) {
        //TODO 存储订单信息
        UIJumpTool.getUiJumpTool().closeCreateOrder();
    }
    
    @FXML
    void toSetRoomNum(ActionEvent event) {

    }

    public void init() {
		
	}
    
    @FXML
    void initialize() {
        assert hotelName != null : "fx:id=\"hotelName\" was not injected: check your FXML file '生成订单.fxml'.";
        assert hoteladdressLabel != null : "fx:id=\"hoteladdressLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert hotelPhonenumberLabel != null : "fx:id=\"hotelPhonenumberLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert userPhoneNumberLabel != null : "fx:id=\"userPhoneNumberLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert userNameLabel != null : "fx:id=\"userNameLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert memberLevelLabel != null : "fx:id=\"memberLevelLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert userCreditLabel != null : "fx:id=\"userCreditLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert dateOfOrderCreatedLabel != null : "fx:id=\"dateOfOrderCreatedLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert latestCheckinTimeLabel != null : "fx:id=\"latestCheckinTimeLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert priceOfPerRoomLabel != null : "fx:id=\"priceOfPerRoomLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert totalPriceLabel != null : "fx:id=\"totalPriceLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert finishCreateOrder != null : "fx:id=\"finishCreateOrder\" was not injected: check your FXML file '生成订单.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '生成订单.fxml'.";
        assert expectedCheckinTimepicker != null : "fx:id=\"expectedCheckinTimepicker\" was not injected: check your FXML file '生成订单.fxml'.";
        assert expectedCheckoutTimepicker != null : "fx:id=\"expectedCheckoutTimepicker\" was not injected: check your FXML file '生成订单.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert roomtypeCombox != null : "fx:id=\"roomtypeCombox\" was not injected: check your FXML file '生成订单.fxml'.";
        assert peopleNumombox != null : "fx:id=\"peopleNumombox\" was not injected: check your FXML file '生成订单.fxml'.";
        assert withChildrenCombox != null : "fx:id=\"withChildrenCombox\" was not injected: check your FXML file '生成订单.fxml'.";
        assert roomnumCombox != null : "fx:id=\"roomnumCombox\" was not injected: check your FXML file '生成订单.fxml'.";

        
    }
}

