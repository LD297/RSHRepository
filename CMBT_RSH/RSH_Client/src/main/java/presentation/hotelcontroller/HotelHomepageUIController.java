package presentation.hotelcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import bl.orderservice.OrderForHotel;
import bl.promotionservice.PromotionService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import vo.HotelVO;

public class HotelHomepageUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView aboutUs;

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

    private AnchorPane prePane;

    private String hotelId;

    private HotelService hotelService;

    private PromotionService promotionService;

    private OrderForHotel orderForHotel;

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

    // Login界面set进来的
    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }
    public void setOrderForHotel(OrderForHotel orderForHotel) {
        this.orderForHotel = orderForHotel;
    }

    @FXML
    void changeToBasicInfoUI(MouseEvent event) {
        // 加载酒店基本信息维护界面
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getHotelBasicInfoUILoader();
        // 加载酒店信息维护界面根结点
        if(hotelBasicInfoUIPane==null)
            try {
                hotelBasicInfoUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
        }
        // 得到酒店信息维护界面控制器
        if(hotelBasicInfoUIController==null)
            hotelBasicInfoUIController = loader.getController();
        // 传入酒店首页根结点引用
        hotelBasicInfoUIController.setPrePane(anchorPane);
        // 配置hotelService
        hotelBasicInfoUIController.setHotelService(hotelService);
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
        // 加载促销策略维护界面
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getPromotionUILoader();
        // 加载促销策略维护界面根结点
        if(promotionUIPane==null)
            try {
                promotionUIPane = (AnchorPane)loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到促销策略维护界面控制器
        if(promotionUIController==null)
                promotionUIController = loader.getController();
        // 传入酒店首页根结点引用
        promotionUIController.setPrePane(anchorPane);
        // 配置promotionService
        promotionUIController.setPromotionService(promotionService);
        promotionUIController.setIsHotel(true);
        promotionUIController.setIdForSearchPro(hotelId);
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
        // 加载订单搜索并浏览界面
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getCheckOrderUILoader();

        // 加载订单搜索并浏览界面根结点
        if(checkOrderUIPane==null)
            try {
                checkOrderUIPane = (AnchorPane)loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到订单搜索并浏览界面控制器
        if(checkOrderUIController==null)
            checkOrderUIController = loader.getController();
        // 传入酒店首页根结点引用
        checkOrderUIController.setPrePane(anchorPane);
        // 配置orderForHotel
        checkOrderUIController.setOrderForHotel(orderForHotel);
        checkOrderUIController.setHotelId(hotelId);

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
        // 加载可用客房信息维护界面
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getRoomAvailUILoader();
        // 加载可用客房信息维护界面根结点
        if(roomAvailUIPane==null)
            try {
                System.out.println(loader.load()==null);
                roomAvailUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到可用客房信息维护界面控制器
        if(roomAvailUIController==null)
            roomAvailUIController = loader.getController();
        // 传入酒店首页根结点引用
        roomAvailUIController.setPrePane(anchorPane);
        // 配置hotelService
        roomAvailUIController.setHotelService(hotelService);
        roomAvailUIController.setHotelId(hotelId);
//        roomAvailUIController.refreshPage();

        Scene scene = null;
//        System.out.println(roomAvailUIPane==null);
        if(roomAvailUIPane.getScene()==null)
            scene = new Scene(roomAvailUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = roomAvailUIPane.getScene();

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }
    @FXML
    void logout(MouseEvent event) {
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

    }
    public void setPrePane(AnchorPane prePane){this.prePane = prePane;}
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
}
