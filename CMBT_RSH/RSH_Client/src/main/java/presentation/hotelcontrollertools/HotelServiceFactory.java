package presentation.hotelcontrollertools;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelService_Stub;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginService_Stub;
import bl.orderservice.OrderForHotel;
import bl.orderserviceimpl.OrderForHotel_Stub;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;

/**
 * Created by a297 on 16/12/20.
 */
public class HotelServiceFactory {

    private static HotelServiceFactory hotelServiceFactory;
    private static LoginService loginService;
    private static HotelService hotelService;
    private static PromotionService promotionService;
    private static OrderForHotel orderForHotel;

    public static HotelServiceFactory getInstance(){
        if(hotelServiceFactory==null)
            hotelServiceFactory= new HotelServiceFactory();
        return hotelServiceFactory;
    }

    public HotelService getHotelService(){
        if(hotelService==null)
            hotelService = new HotelService_Stub();
        return hotelService;
    }
    public LoginService getLoginService(){
        if(loginService==null)
            loginService = new LoginService_Stub();
        return loginService;
    }

    public PromotionService getPromotionService() {
        if(promotionService==null)
            promotionService = new PromotionService_Stub();
        return promotionService;
    }

    public OrderForHotel getOrderForHotel() {
        if(orderForHotel==null)
            orderForHotel = new OrderForHotel_Stub();
        return orderForHotel;
    }
}
