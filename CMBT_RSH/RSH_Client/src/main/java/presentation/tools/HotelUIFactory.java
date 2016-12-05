package presentation.tools;

import javafx.fxml.FXMLLoader;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUIFactory {

    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    private static HotelUIFactory hotelUIFactory;

    private FXMLLoader homepageUILoader;

    private FXMLLoader hotelInfoUILoader;

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

    public FXMLLoader getHotelInfoLoader(){
        if(hotelInfoUILoader==null)
            hotelInfoUILoader = new FXMLLoader(getClass().getResource("/fxml/酒店信息维护.fxml"));
        return hotelInfoUILoader;
    }
}
