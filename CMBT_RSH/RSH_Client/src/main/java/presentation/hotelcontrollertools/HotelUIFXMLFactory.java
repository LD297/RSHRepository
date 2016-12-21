package presentation.hotelcontrollertools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.hotelcontroller.HotelHomepageUIController;

import java.io.IOException;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUIFXMLFactory {

    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    private static HotelUIFXMLFactory hotelUIFXMLFactory;

    private FXMLLoader hotelHomepageUILoader;

    private FXMLLoader hotelBasicInfoUILoader;

    private FXMLLoader promotionUILoader;

    private FXMLLoader checkOrderUILoader;

    private FXMLLoader aboutUsUILoader;

    private FXMLLoader roomAvailUILoader;

    private FXMLLoader roomInfoUILoader;

    private FXMLLoader addRoomUILoader;

    private FXMLLoader addPromotionUILoader;

    private AnchorPane hotelHomePage;

    private HotelHomepageUIController hotelHomepageUIController;

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

    public FXMLLoader getAboutUsUILoader() {
        if(aboutUsUILoader==null)
            aboutUsUILoader = new FXMLLoader(getClass().getResource("/fxml/关于我们.fxml"));
        return aboutUsUILoader;
    }

    public FXMLLoader getRoomAvailUILoader() {
        if(roomAvailUILoader==null)
            roomAvailUILoader = new FXMLLoader(getClass().getResource("/fxml/可用客房信息维护.fxml"));
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
        if(hotelHomePage==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getHotelHomepageUILoader();
            try {
                hotelHomePage = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return hotelHomePage;
    }

    //
    public HotelHomepageUIController getHotelHomepageUIController() {
        if(hotelHomepageUIController==null){
            FXMLLoader loader = HotelUIFXMLFactory.getInstance().getHotelHomepageUILoader();
            if(hotelHomePage==null)
                try {
                    hotelHomePage = loader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            hotelHomepageUIController = loader.getController();
        }
        return hotelHomepageUIController;
    }

}
