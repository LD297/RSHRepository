package presentation.hotelcontrollertools;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.controller.HotelController;
import bl.hotelserviceimpl.controller.HotelInfoController;
import bl.hotelserviceimpl.controller.HotelInfoService_Stub;
import bl.hotelserviceimpl.controller.HotelService_Stub;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.loginserviceimpl.LoginService_Stub;
import bl.orderservice.OrderForHotel;
import bl.orderserviceimpl.OrderForHotelController;
import bl.orderserviceimpl.OrderForHotel_Stub;
import bl.promotionServiceimpl.PromotionController;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;

/**
 * Created by a297 on 16/12/20.
 */
public class HotelServiceFactory {

    private static HotelServiceFactory hotelServiceFactory;
    private static LoginService loginService;
    private static HotelService hotelService;
    private static HotelInfoService hotelInfoService;
    private static PromotionService promotionService;
    private static OrderForHotel orderForHotel;

    public static HotelServiceFactory getInstance(){
        if(hotelServiceFactory==null)
            hotelServiceFactory= new HotelServiceFactory();
        return hotelServiceFactory;
    }

    public LoginService getLoginService(){
        if(loginService==null)
            loginService = new LoginController();
        return loginService;
    }

    public HotelService getHotelService(){
        if(hotelService==null)
            hotelService = new HotelController();
        return hotelService;
    }

    public HotelInfoService getHotelInfoService(){
        if(hotelInfoService==null)
            hotelInfoService = new HotelInfoController();
        return hotelInfoService;
    }


    public PromotionService getPromotionService() {
        if(promotionService==null)
            promotionService = new PromotionController();
        return promotionService;
    }

    public OrderForHotel getOrderForHotel() {
        if(orderForHotel==null)
            orderForHotel = new OrderForHotelController();
        return orderForHotel;
    }
}
