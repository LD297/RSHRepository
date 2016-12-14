package presentation.usercontroller;

/**
 * Created by john on 2016/12/8.
 */

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import bl.promotionServiceimpl.Promotion;
import constant.ResultMessage;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import presentation.tools.ImageFactory;
import presentation.tools.MyDateFormat;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.HotelVO;
import vo.OrderVO;
import vo.RoomNormVO;
import vo.UserVO;

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
    private ComboBox<String> roomtypeCombox;

    @FXML
    private ComboBox<Integer> peopleNumombox;

    @FXML
    private ComboBox<String> withChildrenCombox;

    @FXML
    private ComboBox<Integer> roomnumCombox;
    
    @FXML
    private Label promotionlabel;
    
    @FXML
    private Button backToModifyButton;

    
    private Date expectedCheckinDate = null;
    private Date expectedCheckoutDate = null;
    private String roomtype = null;
    private double roomPrice = -1;
    private String totalPrice = null;
    private String promotion = null;
    private int peopleNum = 0;
    private boolean withChildren = false;
    private int roomNum = 0;

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
    
    //点击返回修改，还原编辑场景
    @FXML
    void backToModifyOrderInfo(MouseEvent event) {
    	expectedCheckinTimepicker.setDisable(false);
    	expectedCheckoutTimepicker.setDisable(false);
    	roomtypeCombox.setDisable(false);
    	peopleNumombox.setDisable(false);
    	roomnumCombox.setDisable(false);
    	withChildrenCombox.setDisable(false);
    	finishCreateOrder.setText("提交订单");
    	finishCreateOrder.setDisable(false);
    	backToModifyButton.setVisible(false);
    	totalPriceLabel.setText("");
    	promotionlabel.setText("");
    	messageLabel.setText("");
    }

    //点击提交订单，判断是否有未输入的选项，没有的话就提示用户再次核对订单信息
    //点击我已核对，关闭生成订单界面，在数据层添加order的持久化对象
	@FXML
	void finishCreateOrder(MouseEvent event) {
		// 如果用户是提交订单，则显示总价格，提醒用户确认订单信息
		if (finishCreateOrder.getText().equals("提交订单")) {
			//将组件还原
			//设置组件不可编辑
			expectedCheckinTimepicker.setDisable(true);
	    	expectedCheckoutTimepicker.setDisable(true);
	    	roomtypeCombox.setDisable(true);
	    	peopleNumombox.setDisable(true);
	    	roomnumCombox.setDisable(true);
	    	withChildrenCombox.setDisable(true);
	    	//返回修改按钮可见
			backToModifyButton.setVisible(true);
			//如果有尚未填写的信息
			if(expectedCheckinTimepicker.getValue()==null||
					expectedCheckoutTimepicker.getValue()==null||
					roomtypeCombox.getValue()==null||
					peopleNumombox.getValue()==null||
					roomnumCombox.getValue()==null||
					withChildrenCombox.getValue()==null){
				messageLabel.setText("您有尚未填写的信息");
				//提交订单不可点
				finishCreateOrder.setDisable(true);
				backToModifyButton.setVisible(true);
			}else{//如果没有尚未填写的信息，得到总价和促销策略
				getInfoFromUI();
				String temp = UserInfoUtil.getInstance().getOrderPriceAndPromotion(expectedCheckinDate, expectedCheckoutDate,
						roomtype, roomPrice, roomNum);
				totalPrice = temp.split("#")[1];
				promotion = temp.split("#")[0];
				totalPriceLabel.setText(totalPrice);//显示总价格
				promotionlabel.setText("("+promotion+")");//显示促销策略
				finishCreateOrder.setText("我已核对");
				finishCreateOrder.setDisable(false);
				backToModifyButton.setVisible(true);
				messageLabel.setText("请您再次核对订单信息");
			}
			
		//如果用户是确认订单，则判断订单是否可以生成，目前订单生成失败的情况是信用不足
		} else {
			getInfoFromUI();
			ResultMessage resultMessage = UserInfoUtil.getInstance().confirmOrder(roomtype, roomPrice, withChildren,
					peopleNum, roomNum, Double.parseDouble(totalPrice), promotion, expectedCheckinDate,
					expectedCheckinDate, new Date());
			if(resultMessage==ResultMessage.succeed){
				UIJumpTool.getUiJumpTool().closeCreateOrder();
			}else{
				messageLabel.setText("您的信用不足");
			}
		}
	}
	
	private void getInfoFromUI(){
		LocalDate expectedCheckinLocalDate = expectedCheckinTimepicker.getValue();
    	expectedCheckinDate = MyDateFormat.getInstance().changeLocalDateToDate(expectedCheckinLocalDate);
    	LocalDate expectedCheckoutLocalDate = expectedCheckoutTimepicker.getValue();
    	expectedCheckoutDate = MyDateFormat.getInstance().changeLocalDateToDate(expectedCheckoutLocalDate);
    	roomtype = roomtypeCombox.getValue().trim();
    	roomNum = roomnumCombox.getValue();
    	peopleNum = peopleNumombox.getValue();
    	if(withChildrenCombox.getValue().equals("有")){
    		withChildren = true;
    	}else{
    		withChildren = false;
    	}
	}

    //用户选择完房间类型，就在roomnumCombox里面set该房间的房间数目，并在priceOfPerRoom里面set进单间价格
    @FXML
    void toSetRoomNum(ActionEvent event) {
    	getInfoFromUI();
    	//在roomnumCombox里面set该房间的房间数目
    	int availRoomNum = UserInfoUtil.getInstance().getAvailRoomNum(roomtype, expectedCheckinDate, expectedCheckoutDate);
    	ArrayList<Integer> roomNums = new ArrayList<>();
    	for(int i=1;i<=availRoomNum;i++){
    		roomNums.add(i);
    	}
    	ObservableList<Integer> roomnumItem = FXCollections.observableArrayList(roomNums);
    	roomnumCombox.setItems(roomnumItem);
    	//设置单间价格
    	roomPrice = UserInfoUtil.getInstance().getRoomPrice(roomtype);
    	priceOfPerRoomLabel.setText("￥"+Double.toString(roomPrice));
    }

    public void init() {
    	//初始化订单中的酒店信息
    	HotelVO hotelVO = UserInfoUtil.getInstance().getHotelVO();
		hotelName.setText(hotelVO.name);
		hoteladdressLabel.setText(hotelVO.addr);
		hotelPhonenumberLabel.setText(hotelVO.tel);
		//初始化订单中的用户信息
		UserVO userVO = UserInfoUtil.getInstance().getUserVO();
		userNameLabel.setText(userVO.name);
		userPhoneNumberLabel.setText(userVO.id);
		memberLevelLabel.setText(Integer.toString(userVO.level));
		userCreditLabel.setText(Integer.toString(userVO.credit));
		//初始化订单中的纯订单信息
		String dateOfOrderCreate = MyDateFormat.getInstance().toString(LocalDate.now());
		dateOfOrderCreatedLabel.setText(dateOfOrderCreate);
		latestCheckinTimeLabel.setText(hotelVO.latestCheckinTime);
		ObservableList<String> withChildren = FXCollections.observableArrayList(Arrays.asList(new String[]{"有","无"}));
		withChildrenCombox.setItems(withChildren);
		//设置入住人数下拉框为1-18
		ArrayList<Integer> peopleNums = new ArrayList<>();
		for(int i=1;i<=18;i++){
			peopleNums.add(i);
		}
		ObservableList<Integer> peopleNumItems = FXCollections.observableArrayList(peopleNums);
		peopleNumombox.setItems(peopleNumItems);
		
		//设置预计入住时间的时间选择器只能从今天开始选起
		expectedCheckinTimepicker.setValue(LocalDate.now());
		Callback<DatePicker, DateCell> checkintimeCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(LocalDate.now())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		expectedCheckinTimepicker.setDayCellFactory(checkintimeCellFactory);
		//设置预计离开时间的时间选择器只能从预计入住时间开始选起
		expectedCheckoutTimepicker.setValue(expectedCheckinTimepicker.getValue());
		Callback<DatePicker, DateCell> checkouttimeCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(expectedCheckinTimepicker.getValue()) || item.isEqual(expectedCheckinTimepicker.getValue())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		expectedCheckoutTimepicker.setDayCellFactory(checkouttimeCellFactory);

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
        assert promotionlabel != null : "fx:id=\"promotionlabel\" was not injected: check your FXML file '生成订单.fxml'.";
        assert backToModifyButton != null : "fx:id=\"backToModifyButton\" was not injected: check your FXML file '生成订单.fxml'.";

        init();
        
    }
}

