package presentation.websalesmancontrollertools;

import javafx.fxml.FXMLLoader;

/**
 * Created by a297 on 16/12/20.
 */
public class WebSalesmanUIFXMLFactory {


    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    private static WebSalesmanUIFXMLFactory webSalesmanUIFXMLFactory;

    private FXMLLoader webSalesmanHomepageUILoader;

    private FXMLLoader promotionUILoader;

    private FXMLLoader exceptionalOrderUILoader;

    private FXMLLoader topUpCreditUILoader;

    private FXMLLoader makeMemberStandardUILoader;

    public static WebSalesmanUIFXMLFactory getInstance(){
        if(webSalesmanUIFXMLFactory==null)
            webSalesmanUIFXMLFactory = new WebSalesmanUIFXMLFactory();
        return webSalesmanUIFXMLFactory;
    }

    public FXMLLoader getWebSalesmanHomepageUILoader() {
        if(webSalesmanHomepageUILoader==null)
            webSalesmanHomepageUILoader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员首页.fxml"));
        return webSalesmanHomepageUILoader;
    }

    public FXMLLoader getPromotionUILoader() {
        if(promotionUILoader==null)
            promotionUILoader = new FXMLLoader(getClass().getResource("/fxml/促销策略维护.fxml"));
        return promotionUILoader;
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

    public FXMLLoader getMakeMemberStandardUILoader() {
        if(makeMemberStandardUILoader==null)
            makeMemberStandardUILoader = new FXMLLoader(getClass().getResource("/fxml/制定会员等级界面.fxml"));
        return makeMemberStandardUILoader;
    }
}
