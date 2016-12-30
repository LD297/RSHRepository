package presentation.hotelcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.loginservice.LoginService;
import bl.orderservice.OrderForHotel;
import bl.promotionservice.PromotionService;
import constant.Role;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelServiceFactory;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import vo.HotelVO;

public class HotelHomepageUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView logoutImageView;

    @FXML
    private ImageView whiteBackground;

    @FXML
    private ImageView checkOrder;

    @FXML
    private ImageView roomAvail;

    @FXML
    private ImageView basicInfo;

    @FXML
    private ImageView promotion;

    private LoginService loginService;
    private HotelService hotelService;
    private PromotionService promotionService;
    private HotelInfoService hotelInfoService;
    private OrderForHotel orderForHotel;

    // 登录界面根结点
    private AnchorPane prePane;
    private String hotelId;

    // 酒店信息维护界面根结点
    private static AnchorPane hotelBasicInfoUIPane;
    // 酒店信息维护界面控制器
    private static HotelBasicInfoUIController hotelBasicInfoUIController;
    // 促销策略界面根结点
    private static AnchorPane promotionUIPane;
    // 促销策略界面控制器
    private static PromotionUIController promotionUIController;
    // 订单搜索并浏览界面根结点
    private  static AnchorPane checkOrderUIPane;
    // 订单搜索并浏览界面控制器
    private static CheckOrderUIController checkOrderUIController;
    // 可用客房信息维护界面根结点
    private static AnchorPane roomAvailUIPane;
    // 可用客房信息维护界面控制器
    private static RoomAvailUIController roomAvailUIController;

    @FXML
    void changeToBasicInfoUI(MouseEvent event) {

        hotelBasicInfoUIPane = HotelUIFXMLFactory.getInstance().getHotelBasicInfoUIPane();
        hotelBasicInfoUIController = HotelUIFXMLFactory.getInstance().getHotelBasicInfoUIController();

        // 传入酒店首页根结点引用
        hotelBasicInfoUIController.setPrePane(anchorPane);
        hotelBasicInfoUIController.setHotelId(hotelId);
        hotelBasicInfoUIController.setHotelVO();
        hotelBasicInfoUIController.refreshPage();

        Scene scene = null;
        if(hotelBasicInfoUIPane.getScene()==null)
            scene = new Scene(hotelBasicInfoUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = hotelBasicInfoUIPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void changeToPromotionUI(MouseEvent event) {

        promotionUIPane = HotelUIFXMLFactory.getInstance().getPromotionUIPane();
        promotionUIController = HotelUIFXMLFactory.getInstance().getPromotionUIController();

        // 传入酒店首页根结点引用
        promotionUIController.setPrePane(anchorPane);
        promotionUIController.setHotelId(hotelId);
        promotionUIController.setSetterId();
        promotionUIController.refreshPage();

        Scene scene = null;
        if(promotionUIPane.getScene()==null)
            scene = new Scene(promotionUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = promotionUIPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToCheckOrderUI(MouseEvent event) {

        checkOrderUIPane = HotelUIFXMLFactory.getInstance().getCheckOrderUIPane();
        checkOrderUIController = HotelUIFXMLFactory.getInstance().getCheckOrderUIController();

        // 传入酒店首页根结点引用
        checkOrderUIController.setPrePane(anchorPane);
        // 配置orderForHotel
        checkOrderUIController.setHotelId(hotelId);
        checkOrderUIController.initSelectable();
        checkOrderUIController.unexecutedTabSelected();

        Scene scene = null;
        if(checkOrderUIPane.getScene()==null)
            scene = new Scene(checkOrderUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = checkOrderUIPane.getScene();

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToRoomAvailUI(MouseEvent event) {

        roomAvailUIPane= HotelUIFXMLFactory.getInstance().getRoomAvailUIPane();
        roomAvailUIController = HotelUIFXMLFactory.getInstance().getRoomAvailUIController();

        // 传入酒店首页根结点引用
        roomAvailUIController.setPrePane(anchorPane);
        roomAvailUIController.setHotelId(hotelId);
        roomAvailUIController.refreshPage();

        Scene scene = null;
        if(roomAvailUIPane.getScene()==null)
            scene = new Scene(roomAvailUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = roomAvailUIPane.getScene();

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    void logout(MouseEvent event) {
        loginService.logout(Role.hotel,hotelId);
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert logoutImageView != null : "fx:id=\"logoutImageView\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert whiteBackground != null : "fx:id=\"whiteBackground\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert checkOrder != null : "fx:id=\"checkOrder\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert roomAvail != null : "fx:id=\"roomAvail\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert basicInfo != null : "fx:id=\"basicInfo\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert promotion != null : "fx:id=\"promotion\" was not injected: check your FXML file '酒店首页.fxml'.";

        // 配置逻辑服务
        initilizeService();
    }

    private void initilizeService() {
        this.loginService = HotelServiceFactory.getInstance().getLoginService();
        this.hotelService = HotelServiceFactory.getInstance().getHotelService();
        this.promotionService = HotelServiceFactory.getInstance().getPromotionService();
        this.hotelInfoService = HotelServiceFactory.getInstance().getHotelInfoService();
        this.orderForHotel = HotelServiceFactory.getInstance().getOrderForHotel();
    }

    /**
     *  login界面调用
     * @param prePane
     */
    public void setPrePane(AnchorPane prePane){this.prePane = prePane;}

    /**
     * login界面调用
     * @param hotelId
     */
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

}
