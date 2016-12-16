package presentation.usercontroller;

/**
 * Created by john on 2016/12/8.
 */

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import constant.StateOfOrder;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.MyDateFormat;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.HotelVO;
import vo.OrderVO;
import vo.UserVO;

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
    private Label promotionLabel;
   

    //直接撤销订单，并返回到订单浏览界面
    @FXML
    void cancelOrder(MouseEvent event) {
    	UserInfoUtil.getInstance().cancelOrder();
    	UIJumpTool.getUiJumpTool().closeOrderInfo();
    }

    //跳转到用户评价界面
    @FXML
    void changeToComment(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeUserOrderToAddComment();
    }

    @FXML
    void closeOrderInfo(MouseEvent event) {
        UIJumpTool.getUiJumpTool().closeOrderInfo();
    }
    
    public void init(){
    	//初始化订单中的酒店信息
    	HotelVO hotelVO = UserInfoUtil.getInstance().getHotelVO();
		hotelName.setText(hotelVO.name);
		hotelAddress.setText(hotelVO.addr);
		hotelPhoneNumber.setText(hotelVO.tel);
		//初始化订单中的用户信息
		UserVO userVO = UserInfoUtil.getInstance().getUserVO();
		userName.setText(userVO.name);
		userPhoneNumber.setText(userVO.id);
		userMemberLevel.setText(Integer.toString(userVO.level));
		userCredit.setText(Integer.toString(userVO.credit));
		//初始化纯订单信息
		OrderVO orderVO = UserInfoUtil.getInstance().getOrderVO();
		dateOfOrderCreated.setText(MyDateFormat.getInstance().toString(orderVO.getGenerationDate()));
		orderState.setText(orderVO.getState().toString());
		expectedCheckinTime.setText(MyDateFormat.getInstance().toString(orderVO.getCheckIn()));
		expectedCheckOutTime.setText(MyDateFormat.getInstance().toString(orderVO.getCheckOut()));
		latestCheckinTime.setText(orderVO.getHotelDDL());
		roomType.setText(orderVO.getRoom().getRoomType());
		roomNumber.setText(String.valueOf(orderVO.getRoomNumber()));
		numOfPeopleToLivein.setText(String.valueOf(orderVO.getPeopleNumber()));
		if(orderVO.getWithChild()){
			withChilrenOrnot.setText("有");
		}else {
			withChilrenOrnot.setText("无");
		}
		pricePerRoom.setText("￥"+String.valueOf(orderVO.getRoomPrice())+"/晚");
		totalPrice.setText("￥"+String.valueOf(orderVO.getTrueValue()));
		promotionLabel.setText("("+orderVO.getPromotion()+")");
		if(orderVO.getState()==StateOfOrder.executed){
			commentButton.setVisible(true);
			cancelOrderButton.setVisible(false);
		}else if(orderVO.getState()==StateOfOrder.unexecuted){
			cancelOrderButton.setVisible(true);
			commentButton.setVisible(false);
		}else{
			cancelOrderButton.setVisible(false);
			commentButton.setVisible(false);
		}
		
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
        assert promotionLabel != null : "fx:id=\"promotionLabel\" was not injected: check your FXML file '订单详情（user）.fxml'.";
        init();
    }
}

