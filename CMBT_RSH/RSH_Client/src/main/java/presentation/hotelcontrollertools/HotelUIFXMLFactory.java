package presentation.hotelcontrollertools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.hotelcontroller.*;

import java.io.IOException;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUIFXMLFactory {

    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    private static HotelUIFXMLFactory hotelUIFXMLFactory;

    // loader

    private static FXMLLoader hotelHomepageUILoader;

    private static FXMLLoader hotelBasicInfoUILoader;

    private static FXMLLoader roomInfoUILoader;

    private static FXMLLoader addRoomUILoader;

    private static FXMLLoader roomAvailUILoader;

    private static FXMLLoader promotionUILoader;

    private static FXMLLoader addPromotionUILoader;

    private static FXMLLoader checkOrderUILoader;

    // anchorPane

    private AnchorPane hotelHomepageUIPane;

    private AnchorPane hotelBasicInfoUIPane;

    private AnchorPane roomInfoUIPane;

    private AnchorPane addRoomUIPane;

    private AnchorPane roomAvailUIPane;

    private AnchorPane promotionUIPane;

    private AnchorPane addPromotionUIPane;

    private AnchorPane checkOrderUIPane;

    // controller

    private HotelHomepageUIController hotelHomepageUIController;

    private HotelBasicInfoUIController hotelBasicInfoUIController;

    private RoomInfoUIController roomInfoUIController;

    private AddRoomUIController addRoomUIController;

    private RoomAvailUIController roomAvailUIController;

    private PromotionUIController promotionUIController;

    private AddPromotionUIController addPromotionUIController;

    private CheckOrderUIController checkOrderUIController;

    HotelUIFXMLFactory(){
        initLoader();
    }
    private void initLoader() {
        hotelHomepageUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店首页.fxml"));
        hotelBasicInfoUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店信息维护界面.fxml"));
        promotionUILoader = new FXMLLoader(getClass().getResource("/fxml/促销策略维护.fxml"));
        checkOrderUILoader = new FXMLLoader(getClass().getResource("/fxml/订单搜索并浏览（酒店）.fxml"));
        roomAvailUILoader = new FXMLLoader(getClass().getResource("/fxml/可用客房.fxml"));
        roomInfoUILoader = new FXMLLoader(getClass().getResource("/fxml/客房信息维护.fxml"));
        addRoomUILoader = new FXMLLoader(getClass().getResource("/fxml/添加客房界面.fxml"));
        addPromotionUILoader = new FXMLLoader(getClass().getResource("/fxml/添加促销策略.fxml"));
    }

    public static HotelUIFXMLFactory getInstance(){
        if(hotelUIFXMLFactory==null)
            hotelUIFXMLFactory = new HotelUIFXMLFactory();
        return hotelUIFXMLFactory;
    }

    public AnchorPane getHotelHomePageUIPane() {
        if(hotelHomepageUIPane==null){
            try {
                hotelHomepageUIPane = HotelUIFXMLFactory.hotelHomepageUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hotelHomepageUIPane;
    }

    public AnchorPane getHotelBasicInfoUIPane() {
        if (hotelBasicInfoUIPane == null){
            try {
                hotelBasicInfoUIPane = HotelUIFXMLFactory.hotelBasicInfoUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hotelBasicInfoUIPane;
    }

    public AnchorPane getRoomInfoUIPane() {
        if(roomInfoUIPane==null){
            try {
                roomInfoUIPane = HotelUIFXMLFactory.roomInfoUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roomInfoUIPane;
    }

    public AnchorPane getAddRoomUIPane() {
        if(addRoomUIPane==null){
            try {
                addRoomUIPane = HotelUIFXMLFactory.addRoomUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addRoomUIPane;
    }

    public AnchorPane getRoomAvailUIPane() {
        if(roomAvailUIPane==null){
            try {
                roomAvailUIPane = HotelUIFXMLFactory.roomAvailUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roomAvailUIPane;
    }

    public AnchorPane getCheckOrderUIPane() {
        if(checkOrderUIPane==null){
            try {
                checkOrderUIPane = HotelUIFXMLFactory.checkOrderUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return checkOrderUIPane;
    }

    public AnchorPane getPromotionUIPane(){
        if(promotionUIPane==null){
            try {
                promotionUIPane = HotelUIFXMLFactory.promotionUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return promotionUIPane;
    }
    public AnchorPane getAddPromotionUIPane(){
        if(addPromotionUIPane==null){
            try {
                addPromotionUIPane = HotelUIFXMLFactory.addPromotionUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addPromotionUIPane;
    }
    public HotelHomepageUIController getHotelHomepageUIController() {
        if(hotelHomepageUIController==null){
            getHotelHomePageUIPane();
            hotelHomepageUIController = HotelUIFXMLFactory.hotelHomepageUILoader.getController();
        }
        return hotelHomepageUIController;
    }

    public HotelBasicInfoUIController getHotelBasicInfoUIController() {
        if(hotelBasicInfoUIController==null){
            getHotelBasicInfoUIPane();
            hotelBasicInfoUIController = HotelUIFXMLFactory.hotelBasicInfoUILoader.getController();
        }
        return hotelBasicInfoUIController;
    }

    public RoomInfoUIController getRoomInfoUIController() {
        if(roomInfoUIController==null){
            getRoomInfoUIPane();
            roomInfoUIController = HotelUIFXMLFactory.roomInfoUILoader.getController();
        }
        return roomInfoUIController;
    }

    public AddRoomUIController getAddRoomUIController() {
        if(addRoomUIController==null){
            getAddRoomUIPane();
            addRoomUIController = HotelUIFXMLFactory.addRoomUILoader.getController();
        }
        return addRoomUIController;
    }

    public RoomAvailUIController getRoomAvailUIController() {
        if(roomAvailUIController==null){
            getRoomAvailUIPane();
            roomAvailUIController = HotelUIFXMLFactory.roomAvailUILoader.getController();
        }
        return roomAvailUIController;
    }

    public CheckOrderUIController getCheckOrderUIController() {
        if(checkOrderUIController==null){
            getCheckOrderUIPane();
            checkOrderUIController = HotelUIFXMLFactory.checkOrderUILoader.getController();
        }
        return checkOrderUIController;
    }

    public PromotionUIController getPromotionUIController(){
        if(promotionUIController==null){
            getPromotionUIPane();
            promotionUIController = HotelUIFXMLFactory.promotionUILoader.getController();
        }
        return promotionUIController;
    }

    public AddPromotionUIController getAddPromotionUIController(){
        if(addPromotionUIController==null){
            getAddPromotionUIPane();
            addPromotionUIController = HotelUIFXMLFactory.addPromotionUILoader.getController();
        }
        return addPromotionUIController;
    }

}
