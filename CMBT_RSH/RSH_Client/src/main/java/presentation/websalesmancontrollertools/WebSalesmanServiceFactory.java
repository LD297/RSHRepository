package presentation.websalesmancontrollertools;

import bl.orderservice.OrderForWebsite;
import bl.orderserviceimpl.OrderForHotel_Stub;
import bl.orderserviceimpl.OrderForWebsiteController;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;
import bl.userservice.UserService;
import bl.userserviceimpl.UserService_Stub;

/**
 * Created by a297 on 16/12/20.
 */
public class WebSalesmanServiceFactory {
    private static WebSalesmanServiceFactory webSalesmanServiceFactory;
    private static PromotionService promotionService;
    private static UserService userService;
    private static OrderForWebsite orderForWebsite;

    public static WebSalesmanServiceFactory getInstance(){
        if(webSalesmanServiceFactory==null)
            webSalesmanServiceFactory = new WebSalesmanServiceFactory();
        return webSalesmanServiceFactory;
    }

    public PromotionService getPromotionService(){
        if(promotionService==null)
            promotionService = new PromotionService_Stub();
        return promotionService;
    }
    public UserService getUserService(){
        if(userService==null)
            userService = new UserService_Stub();
        return userService;
    }
    public OrderForWebsite getOrderForWebsite(){
        if(orderForWebsite==null)
            orderForWebsite = new OrderForWebsiteController();
        return orderForWebsite;
    }
}
