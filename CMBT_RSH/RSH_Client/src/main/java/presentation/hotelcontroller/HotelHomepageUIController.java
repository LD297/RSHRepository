package presentation.hotelcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.Hotel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import po.OrderPO;
import presentation.tools.HotelUIFactory;
import vo.HotelVO;

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
    private ImageView logo;

    @FXML
    private ImageView whiteBackground;

    @FXML
    private ImageView checkOrder;

    @FXML
    private ImageView roomAvail;

    @FXML
    private ImageView basicInfo;

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

    // 关于我们界面根结点
    private static AnchorPane aboutUsUIPane;
    // 关于我们界面控制器
    private static AboutUsUIController aboutUsUIController;

    private HotelVO hotelVO;

    private HotelService hotelService;

    public void setHotelVO(HotelVO hotelVO){
        this.hotelVO = hotelVO;
        init();
    }


    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    private void init() {
        // TODO 看看要不要在首页加每个酒店的id或者头像或者名称信息
    }

    // TODO 代码格式一致，后期考虑优化

    @FXML
    void changeToBasicInfoUI(MouseEvent event) {
        // 加载酒店基本信息维护界面
        FXMLLoader loader = HotelUIFactory.getInstance().getHotelBasicInfoUILoader();
//        System.out.println(loader==null);
        // 加载酒店信息维护界面根结点
        if(hotelBasicInfoUIPane==null)
            try {
//                System.out.println("made");
                hotelBasicInfoUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
        }
        // 得到酒店信息维护界面控制器
        if(hotelBasicInfoUIController==null)
            hotelBasicInfoUIController = loader.getController();
        // 设置酒店信息维护界面根结点
        hotelBasicInfoUIController.setAnchorPane(hotelBasicInfoUIPane);
        // 传入酒店首页根结点引用
        hotelBasicInfoUIController.setPrePane(anchorPane);
        // 传入酒店基本信息
        hotelBasicInfoUIController.setHotelVO(hotelVO);
        hotelBasicInfoUIController.init();
        // 配置hotelService
        hotelBasicInfoUIController.setHotelService(hotelService);

        Scene scene = null;
        if(hotelBasicInfoUIPane.getScene()==null)
            scene = new Scene(hotelBasicInfoUIPane, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT);
        else
            scene = hotelBasicInfoUIPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void changeToPromotionUI(MouseEvent event) {
        // 加载促销策略维护界面
        FXMLLoader loader = HotelUIFactory.getInstance().getPromotionUILoader();
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
        // 设置酒店促销策略维护界面根结点
        promotionUIController.setAnchorPane(promotionUIPane);
        // 传入酒店首页根结点引用
        promotionUIController.setPrePane(anchorPane);

        Scene scene = null;
        if(promotionUIPane.getScene()==null)
            scene = new Scene(promotionUIPane, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT);
        else
            scene = promotionUIPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);



    }

    @FXML
    void changeToAboutUsUI(MouseEvent event) {
        // 加载关于我们界面
        FXMLLoader loader = HotelUIFactory.getInstance().getAboutUsUILoader();
        // 加载关于我们界面根结点
        if(aboutUsUIPane==null)
            try {
                aboutUsUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到关于我们界面控制器
        if(aboutUsUIController==null)
            aboutUsUIController = loader.getController();
        // 设置关于我们界面根结点
        aboutUsUIController.setAnchorPane(aboutUsUIPane);
        // 传入酒店首页根结点引用
        aboutUsUIController.setPrePane(anchorPane);

        Scene scene = null;
        if(aboutUsUIPane.getScene()==null)
            scene = new Scene(aboutUsUIPane, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT);
        else
            scene = aboutUsUIPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void changeToCheckOrderUI(MouseEvent event) {
        // 加载订单搜索并浏览界面
        FXMLLoader loader = HotelUIFactory.getInstance().getCheckOrderUILoader();

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
        // 设置订单搜索并浏览界面根结点
        checkOrderUIController.setAnchorPane(checkOrderUIPane);
        // 传入酒店首页根结点引用
        checkOrderUIController.setPrePane(anchorPane);

        Scene scene = null;
        if(checkOrderUIPane.getScene()==null)
            scene = new Scene(checkOrderUIPane, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT);
        else
            scene = checkOrderUIPane.getScene();

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToRoomAvailUI(MouseEvent event) {
        // 加载可用客房信息维护界面
        FXMLLoader loader = HotelUIFactory.getInstance().getRoomAvailUILoader();
        // 加载可用客房信息维护界面根结点
        if(roomAvailUIPane==null)
            try {
                roomAvailUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到可用客房信息维护界面控制器
        if(roomAvailUIController==null)
            roomAvailUIController = loader.getController();
        // 设置可用客房信息维护界面根结点
        roomAvailUIController.setAnchorPane(roomAvailUIPane);
        // 传入酒店首页根结点引用
        roomAvailUIController.setPrePane(anchorPane);

        Scene scene = null;
        if(roomAvailUIPane.getScene()==null)
            scene = new Scene(roomAvailUIPane, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT);
        else
            scene = roomAvailUIPane.getScene();

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert promotin != null : "fx:id=\"promotin\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert whiteBackground != null : "fx:id=\"whiteBackground\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert checkOrder != null : "fx:id=\"checkOrder\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert roomAvail != null : "fx:id=\"roomAvail\" was not injected: check your FXML file '酒店首页.fxml'.";
        assert basicInfo != null : "fx:id=\"basicInfo\" was not injected: check your FXML file '酒店首页.fxml'.";

    }
}
