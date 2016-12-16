package presentation.tools;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUIFactory {

    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    private static HotelUIFactory hotelUIFactory;

    private FXMLLoader homepageUILoader;

    private FXMLLoader hotelBasicInfoUILoader;

    private FXMLLoader promotionUILoader;

    private FXMLLoader checkOrderUILoader;

    private FXMLLoader aboutUsUILoader;

    private FXMLLoader roomAvailUILoader;

    private FXMLLoader roomInfoUILoader;

    private FXMLLoader addRoomUILoader;

    public static HotelUIFactory getInstance(){
        if(hotelUIFactory==null)
            hotelUIFactory = new HotelUIFactory();
        return hotelUIFactory;
    }

    public FXMLLoader getHomepageUILoader(){
        if(homepageUILoader==null)
            homepageUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店首页.fxml"));
        return homepageUILoader;
    }

    public FXMLLoader getHotelBasicInfoUILoader(){
        if(hotelBasicInfoUILoader==null)
            hotelBasicInfoUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店信息维护.fxml"));
        return hotelBasicInfoUILoader;
    }

    public FXMLLoader getPromotionUILoader() {
        if(promotionUILoader==null)
            promotionUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店促销策略维护.fxml"));
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
}
