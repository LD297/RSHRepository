package presentation.usercontroller;

/**
 * Created by john on 2016/12/8.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;

public class OrderInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label hotelName;

    @FXML
    private Label hotelAddress;

    @FXML
    private Label hotelPhoneNumber;

    @FXML
    private Label userPhoneNumber;

    @FXML
    private Label userName;

    @FXML
    private Label userMemberLevel;

    @FXML
    private Label userCredit;

    @FXML
    private Label dateOfOrderCreated;

    @FXML
    private Label expectedCheckinTime;

    @FXML
    private Label orderState;

    @FXML
    private Label expectedCheckOutTime;

    @FXML
    private Label latestCheckinTime;

    @FXML
    private Label numOfPeopleToLivein;

    @FXML
    private Label roomType;

    @FXML
    private Label roomNumber;

    @FXML
    private Label withChilrenOrnot;

    @FXML
    private Label pricePerRoom;

    @FXML
    private Label totalPrice;

    @FXML
    private Button commentButton;

    @FXML
    private Button cancelOrderButton;

    @FXML
    private ImageView backImage;

    @FXML
    void cancelOrder(MouseEvent event) {

    }

    //跳转到查看评价（如果是暂无评价再考虑）
    @FXML
    void changeToComment(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeUserOrderToAddComment();
    }

    @FXML
    void closeOrderInfo(MouseEvent event) {
        UIJumpTool.getUiJumpTool().closeOrderInfo();
    }

    @FXML
    void initialize() {
        assert hotelName != null : "fx:id=\"hotelName\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert hotelAddress != null : "fx:id=\"hotelAddress\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert hotelPhoneNumber != null : "fx:id=\"hotelPhoneNumber\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert userPhoneNumber != null : "fx:id=\"userPhoneNumber\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert userName != null : "fx:id=\"userName\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert userMemberLevel != null : "fx:id=\"userMemberLevel\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert userCredit != null : "fx:id=\"userCredit\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert dateOfOrderCreated != null : "fx:id=\"dateOfOrderCreated\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert expectedCheckinTime != null : "fx:id=\"expectedCheckinTime\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert orderState != null : "fx:id=\"orderState\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert expectedCheckOutTime != null : "fx:id=\"expectedCheckOutTime\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert latestCheckinTime != null : "fx:id=\"latestCheckinTime\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert numOfPeopleToLivein != null : "fx:id=\"numOfPeopleToLivein\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert roomType != null : "fx:id=\"roomType\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert roomNumber != null : "fx:id=\"roomNumber\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert withChilrenOrnot != null : "fx:id=\"withChilrenOrnot\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert pricePerRoom != null : "fx:id=\"pricePerRoom\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert totalPrice != null : "fx:id=\"totalPrice\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert commentButton != null : "fx:id=\"commentButton\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert cancelOrderButton != null : "fx:id=\"cancelOrderButton\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '订单详情（user）.fxml'.";

    }
}

