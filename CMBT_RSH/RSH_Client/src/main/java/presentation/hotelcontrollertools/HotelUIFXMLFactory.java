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

    private FXMLLoader hotelHomepageUILoader;

    private FXMLLoader hotelBasicInfoUILoader;

    private FXMLLoader roomInfoUILoader;

    private FXMLLoader addRoomUILoader;

    private FXMLLoader roomAvailUILoader;

    private FXMLLoader promotionUILoader;

    private FXMLLoader addPromotionUILoader;

    private FXMLLoader checkOrderUILoader;

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


    public static HotelUIFXMLFactory getInstance(){
        if(hotelUIFXMLFactory==null)
            hotelUIFXMLFactory = new HotelUIFXMLFactory();
        return hotelUIFXMLFactory;
    }

    public FXMLLoader getHotelHomepageUILoader(){
        if(hotelHomepageUILoader==null)
            hotelHomepageUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店首页.fxml"));
        return hotelHomepageUILoader;
    }

    public FXMLLoader getHotelBasicInfoUILoader(){
        if(hotelBasicInfoUILoader==null)
            hotelBasicInfoUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店信息维护界面.fxml"));
        return hotelBasicInfoUILoader;
    }

    public FXMLLoader getPromotionUILoader() {
        if(promotionUILoader==null)
            promotionUILoader = new FXMLLoader(getClass().getResource("/fxml/促销策略维护.fxml"));
        return promotionUILoader;
    }

    public FXMLLoader getCheckOrderUILoader() {
        if(checkOrderUILoader==null)
            checkOrderUILoader = new FXMLLoader(getClass().getResource("/fxml/订单搜索并浏览（酒店）.fxml"));
        return checkOrderUILoader;
    }

    public FXMLLoader getRoomAvailUILoader() {
        if(roomAvailUILoader==null)
            roomAvailUILoader = new FXMLLoader(getClass().getResource("/fxml/可用客房.fxml"));
        return roomAvailUILoader;
    }

    public FXMLLoader getRoomInfoUILoader() {
        if(roomInfoUILoader==null)
            roomInfoUILoader = new FXMLLoader(getClass().getResource("/fxml/客房信息维护.fxml"));
        return roomInfoUILoader;
    }

    public FXMLLoader getAddRoomUILoader() {
        if(addRoomUILoader==null)
            addRoomUILoader = new FXMLLoader(getClass().getResource("/fxml/添加客房界面.fxml"));
        return addRoomUILoader;
    }

    public FXMLLoader getAddPromotionUILoader(){
        if(addPromotionUILoader==null)
            addPromotionUILoader = new FXMLLoader(getClass().getResource("/fxml/添加促销策略.fxml"));
        return addPromotionUILoader;
    }


    public AnchorPane getHotelHomePage() {
        if(hotelHomepageUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getHotelHomepageUILoader();
            try {
                hotelHomepageUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hotelHomepageUIPane;
    }

    public AnchorPane getHotelBasicInfoUIPane() {
        if (hotelBasicInfoUIPane == null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getHotelBasicInfoUILoader();
            try {
                hotelBasicInfoUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hotelBasicInfoUIPane;
    }

    public AnchorPane getRoomInfoUIPane() {
        if(roomInfoUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getRoomInfoUILoader();
            try {
                roomInfoUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roomInfoUIPane;
    }

    public AnchorPane getAddRoomUIPane() {
        if(addRoomUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getAddRoomUILoader();
            try {
                addRoomUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addRoomUIPane;
    }

    public AnchorPane getRoomAvailUIPane() {
        if(roomAvailUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getRoomAvailUILoader();
            try {
                roomAvailUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return roomAvailUIPane;
    }

    public AnchorPane getCheckOrderUIPane() {
        if(checkOrderUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getCheckOrderUILoader();
            try {
                checkOrderUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return checkOrderUIPane;
    }

    public AnchorPane getPromotionUIPane(){
        if(promotionUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getPromotionUILoader();
            try {
                promotionUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return promotionUIPane;
    }
    public AnchorPane getAddPromotionUIPane(){
        if(addPromotionUIPane==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getAddPromotionUILoader();
            try {
                addPromotionUIPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return addPromotionUIPane;
    }
    public HotelHomepageUIController getHotelHomepageUIController() {
        if(hotelHomepageUIController==null){
            getHotelHomepageUILoader();
            hotelHomepageUIController = HotelUIFXMLFactory.getInstance().getHotelHomepageUILoader().getController();
        }
        return hotelHomepageUIController;
    }

    public HotelBasicInfoUIController getHotelBasicInfoUIController() {
        if(hotelBasicInfoUIController==null){
            getHotelBasicInfoUIPane();
            hotelBasicInfoUIController = HotelUIFXMLFactory.getInstance().getHotelBasicInfoUILoader().getController();
        }
        return hotelBasicInfoUIController;
    }

    public RoomInfoUIController getRoomInfoUIController() {
        if(roomInfoUIController==null){
            getRoomInfoUIPane();
            roomInfoUIController = HotelUIFXMLFactory.getInstance().getRoomInfoUILoader().getController();
        }
        return roomInfoUIController;
    }

    public AddRoomUIController getAddRoomUIController() {
        if(addRoomUIController==null){
            getAddRoomUIPane();
            addRoomUIController = HotelUIFXMLFactory.getInstance().getAddRoomUILoader().getController();
        }
        return addRoomUIController;
    }

    public RoomAvailUIController getRoomAvailUIController() {
        if(roomAvailUIController==null){
            getRoomAvailUIPane();
            roomAvailUIController = HotelUIFXMLFactory.getInstance().getRoomAvailUILoader().getController();
        }
        return roomAvailUIController;
    }

    public CheckOrderUIController getCheckOrderUIController() {
        if(checkOrderUIController==null){
            getCheckOrderUIPane();
            checkOrderUIController = HotelUIFXMLFactory.getInstance().getCheckOrderUILoader().getController();
        }
        return checkOrderUIController;
    }

    public PromotionUIController getPromotionUIController(){
        if(promotionUIController==null){
            getPromotionUIPane();
            promotionUIController = HotelUIFXMLFactory.getInstance().getPromotionUILoader().getController();
        }
        return promotionUIController;
    }

    public AddPromotionUIController getAddPromotionUIController(){
        if(addPromotionUIController==null){
            getAddPromotionUIPane();
            addPromotionUIPane = HotelUIFXMLFactory.getInstance().getAddPromotionUILoader().getController();
        }
        return addPromotionUIController;
    }

}
