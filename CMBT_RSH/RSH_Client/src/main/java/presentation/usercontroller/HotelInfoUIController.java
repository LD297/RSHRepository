package presentation.usercontroller;

/**
 * Created by john on 2016/12/6.
 */


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import presentation.tools.ImageFactory;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import vo.HotelVO;
/**
 * 酒店详情界面
 * @author john
 *
 */
public class HotelInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView hotelImage;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label briefLabel;

    @FXML
    private ImageView wifiImage;


    @FXML
    private ImageView swimpoolImage;

    @FXML
    private ImageView parkImage;

    @FXML
    private ImageView diningroomImage;

    @FXML
    private Text diningText;

    @FXML
    private Text parkText;

    @FXML
    private Text swimText;
    
    @FXML
    private Text wifiText;

    @FXML
    private Label phoneLabel;

    @FXML
    private Button createOrderButton;

    @FXML
    private Label startLevelLabel;

    @FXML
    private Label gradeLabel;

    @FXML
    private Rectangle roomInfoEffect;

    @FXML
    private Rectangle commentEffect;

    @FXML
    private Button roonInfoButton;

    @FXML
    private Button commentButton;

    @FXML
    private Button myOrderButton;

    private boolean isRoomInfo = true;
    
    private HotelVO hotelVO = null;

    //跳转到新建订单界面
    @FXML
    void changeToCreateOrder(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToCreateOrder();
    }

    @FXML
    void changeToComment(MouseEvent event) {
        commentEffect.setVisible(false);
        isRoomInfo = false;
        roomInfoEffect.setVisible(true);
        UIJumpTool.getUiJumpTool().changeToComment();
    }

    //TODO RoomInfoUIController
    @FXML
    void changeToRoomInfo(MouseEvent event) {
        roomInfoEffect.setVisible(false);
        isRoomInfo = true;
        commentEffect.setVisible(true);
        UIJumpTool.getUiJumpTool().changeToRoomInfo();
    }

    @FXML
    void commentEntered(MouseEvent event) {
        commentEffect.setVisible(false);
    }

    @FXML
    void commentExited(MouseEvent event) {
        if(isRoomInfo){
            commentEffect.setVisible(true);
        }
    }

    @FXML
    void roomInfoEntered(MouseEvent event) {
        roomInfoEffect.setVisible(false);
    }

    @FXML
    void roomInfoExited(MouseEvent event) {
        if(!isRoomInfo){
            roomInfoEffect.setVisible(true);
        }

    }

    //跳转到我的订单界面
    @FXML
    void changeToMyOrder(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToMyOrderOfOneHotel();
    }
    
    public void init() {
    	  UserInfoUtil userInfoUtil = UserInfoUtil.getInstance();
          hotelVO = userInfoUtil.getHotelVO();
          hotelNameLabel.setText(hotelVO.getHotelName());
          startLevelLabel.setText(String.valueOf(hotelVO.getLevel()));
          gradeLabel.setText(String.valueOf(hotelVO.getGrade()));
          addressLabel.setText(hotelVO.getFullAddress());
          briefLabel.setText(hotelVO.getBriefIntro());
          //TODO 设置设施服务
          if(!hotelVO.hasWIFI()){
        	  wifiText.setStrikethrough(true);
          }
          if(!hotelVO.hasCanteen()){
        	  diningText.setStrikethrough(true);
          }
          if(!hotelVO.hasPark()){
        	  parkText.setStrikethrough(true);
          }
          if(!hotelVO.hasSwimmingPool()){
        	  swimText.setStrikethrough(true);
          }
          hotelImage.setImage(ImageFactory.getImageFactory().getHotelImage(UserInfoUtil.getInstance().getHotelID()));
          phoneLabel.setText(hotelVO.tel);
    }

    @FXML
    void initialize() {
        assert hotelImage != null : "fx:id=\"hotelImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert hotelNameLabel != null : "fx:id=\"hotelNameLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert addressLabel != null : "fx:id=\"addressLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert briefLabel != null : "fx:id=\"briefLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert wifiImage != null : "fx:id=\"wifiImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert swimpoolImage != null : "fx:id=\"swimpoolImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert parkImage != null : "fx:id=\"parkImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert diningroomImage != null : "fx:id=\"diningroomImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert createOrderButton != null : "fx:id=\"createOrderButton\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert startLevelLabel != null : "fx:id=\"startLevelLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert gradeLabel != null : "fx:id=\"gradeLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert roomInfoEffect != null : "fx:id=\"roomInfoEffect\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert commentEffect != null : "fx:id=\"commentEffect\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert roonInfoButton != null : "fx:id=\"roonInfoButton\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert commentButton != null : "fx:id=\"commentButton\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert myOrderButton != null : "fx:id=\"myOrderButton\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert wifiText != null : "fx:id=\"wifiText\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert phoneLabel != null : "fx:id=\"phoneLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert diningText != null : "fx:id=\"diningText\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert parkText != null : "fx:id=\"parkText\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert swimText != null : "fx:id=\"swimText\" was not injected: check your FXML file '酒店详情.fxml'.";
        init();
    }
}

