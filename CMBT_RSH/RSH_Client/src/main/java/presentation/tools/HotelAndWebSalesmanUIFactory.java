package presentation.tools;

import javafx.fxml.FXMLLoader;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelAndWebSalesmanUIFactory {

    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    private static HotelAndWebSalesmanUIFactory hotelUIFactory;

    private FXMLLoader homepageUILoader;

    private FXMLLoader hotelBasicInfoUILoader;

    private FXMLLoader promotionUILoader;

    private FXMLLoader checkOrderUILoader;

    private FXMLLoader aboutUsUILoader;

    private FXMLLoader roomAvailUILoader;

    private FXMLLoader roomInfoUILoader;

    private FXMLLoader addRoomUILoader;

    private FXMLLoader addPromotionUILoader;

    private FXMLLoader webSalesmanHomepageUILoader;

    private FXMLLoader exceptionalOrderUILoader;

    private FXMLLoader topUpCreditUILoader;

    public static HotelAndWebSalesmanUIFactory getInstance(){
        if(hotelUIFactory==null)
            hotelUIFactory = new HotelAndWebSalesmanUIFactory();
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

    public FXMLLoader getExceptionalOrderUILoader(){
        if(exceptionalOrderUILoader==null)
            exceptionalOrderUILoader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员浏览异常订单.fxml"));
        return exceptionalOrderUILoader;
    }

    public FXMLLoader getTopUpCreditUILoader(){
        if(topUpCreditUILoader==null)
            topUpCreditUILoader = new FXMLLoader(getClass().getResource("/fxml/信用充值界面.fxml"));
        return topUpCreditUILoader;
    }

    public FXMLLoader getWebSalesmanHomepageUILoader() {
        if(webSalesmanHomepageUILoader==null)
            webSalesmanHomepageUILoader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员首页.fxml"));
        return webSalesmanHomepageUILoader;
    }
}
