package presentation.websalesmancontrollertools;

import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.loginserviceimpl.LoginService_Stub;
import bl.orderservice.OrderForWebsite;
import bl.orderserviceimpl.OrderForHotel_Stub;
import bl.orderserviceimpl.OrderForWebsiteController;
import bl.promotionServiceimpl.PromotionController;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;
import bl.userservice.UserService;
import bl.userserviceimpl.UserController;
import bl.userserviceimpl.UserService_Stub;
import bl.webstaffservice.WebStaffService;
import bl.webstaffserviceimpl.WebStaffController;
import bl.webstaffserviceimpl.WebStaffService_Stub;

/**
 * Created by a297 on 16/12/20.
 */
public class WebSalesmanServiceFactory {
    private static WebSalesmanServiceFactory webSalesmanServiceFactory;
    private static LoginService loginService;
    private static WebStaffService webStaffService;
    private static PromotionService promotionService;
    private static UserService userService;
    private static OrderForWebsite orderForWebsite;

    public static WebSalesmanServiceFactory getInstance(){
        if(webSalesmanServiceFactory==null)
            webSalesmanServiceFactory = new WebSalesmanServiceFactory();
        return webSalesmanServiceFactory;
    }

    public WebStaffService getWebStaffService(){
        if(webStaffService==null)
            webStaffService = new WebStaffController();
        return webStaffService;
    }

    public PromotionService getPromotionService(){
        if(promotionService==null)
            promotionService = new PromotionController();
        return promotionService;
    }
    public UserService getUserService(){
        if(userService==null)
            userService = new UserController();
        return userService;
    }
    public OrderForWebsite getOrderForWebsite(){
        if(orderForWebsite==null)
            orderForWebsite = new OrderForWebsiteController();
        return orderForWebsite;
    }

    public LoginService getLoginService() {
        if(loginService==null)
            loginService = new LoginController();
        return loginService;
    }
}
