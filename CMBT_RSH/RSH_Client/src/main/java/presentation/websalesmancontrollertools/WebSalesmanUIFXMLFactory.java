package presentation.websalesmancontrollertools;

import bl.webstaffserviceimpl.WebSalesman;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.hotelcontroller.PromotionUIController;
import presentation.websalesmancontroller.ExceptionalOrderUIController;
import presentation.websalesmancontroller.MakeMemberStandardUIController;
import presentation.websalesmancontroller.TopUpCreditUIController;
import presentation.websalesmancontroller.WebSalesmanHomepageUIController;

import java.io.IOException;

/**
 * Created by a297 on 16/12/20.
 */
public class WebSalesmanUIFXMLFactory {

    public static final int UI_X = 320;
    public static final int UI_Y = 46;

    public static final int UI_WIDTH = 800;
    public static final int UI_HEIGHT = 720;

    public static final int TOPUPCREDIT_X = 400;
    public static final int TOPUPCREDIT_Y = 160;

    public static final int TOPUPCREDIT_WIDTH = 600;
    public static final int TOPUPCREDIT_HEIGHT = 450;

    private static WebSalesmanUIFXMLFactory webSalesmanUIFXMLFactory;

    // loader
    private static FXMLLoader webSalesmanHomepageUILoader;

    private static FXMLLoader promotionUILoader;

    private static FXMLLoader exceptionalOrderUILoader;

    private static FXMLLoader topUpCreditUILoader;

    private static FXMLLoader makeMemberStandardUILoader;

    // anchorPane

    private AnchorPane webSalesmanHomepageUIPane;

    private AnchorPane promotionUIPane;

    private AnchorPane exceptionalOrderUIPane;

    private AnchorPane topUpCreditUIPane;

    private AnchorPane makeMemberStandardUIPane;

    // controller

    private WebSalesmanHomepageUIController webSalesmanHomepageUIController;

    private PromotionUIController promotionUIController;

    private ExceptionalOrderUIController exceptionalOrderUIController;

    private TopUpCreditUIController topUpCreditUIController;

    private MakeMemberStandardUIController makeMemberStandardUIController;

    WebSalesmanUIFXMLFactory(){
        initLoader();
    }

    private void initLoader() {
        webSalesmanHomepageUILoader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员首页.fxml"));
        promotionUILoader = new FXMLLoader(getClass().getResource("/fxml/促销策略维护.fxml"));
        exceptionalOrderUILoader = new FXMLLoader(getClass().getResource("/fxml/网站营销人员浏览异常订单.fxml"));
        topUpCreditUILoader = new FXMLLoader(getClass().getResource("/fxml/信用充值界面.fxml"));
        makeMemberStandardUILoader = new FXMLLoader(getClass().getResource("/fxml/制定会员等级界面.fxml"));
    }

    public static WebSalesmanUIFXMLFactory getInstance(){
        if(webSalesmanUIFXMLFactory==null)
            webSalesmanUIFXMLFactory = new WebSalesmanUIFXMLFactory();
        return webSalesmanUIFXMLFactory;
    }

    public AnchorPane getWebSalesmanHomepageUIPane() {
        if(webSalesmanHomepageUIPane==null){
            try {
                webSalesmanHomepageUIPane = WebSalesmanUIFXMLFactory.webSalesmanHomepageUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return webSalesmanHomepageUIPane;
    }

    public AnchorPane getPromotionUIPane(){
        if(promotionUIPane==null){
            try {
                promotionUIPane = WebSalesmanUIFXMLFactory.promotionUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return promotionUIPane;
    }

    public AnchorPane getExceptionalOrderUIPane(){
        if(exceptionalOrderUIPane==null){
            try {
                exceptionalOrderUIPane = WebSalesmanUIFXMLFactory.exceptionalOrderUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return exceptionalOrderUIPane;
    }

    public AnchorPane getTopUpCreditUIPane(){
        if(topUpCreditUIPane==null){
            try {
                topUpCreditUIPane = WebSalesmanUIFXMLFactory.topUpCreditUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return topUpCreditUIPane;
    }

    public AnchorPane getMakeMemberStandardUIPane(){
        if(makeMemberStandardUIPane==null){
            try {
                makeMemberStandardUIPane = WebSalesmanUIFXMLFactory.makeMemberStandardUILoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return makeMemberStandardUIPane;
    }

    public WebSalesmanHomepageUIController getWebSalesmanHomepageUIController() {
        if(webSalesmanHomepageUIController==null){
            getWebSalesmanHomepageUIPane();
            webSalesmanHomepageUIController = WebSalesmanUIFXMLFactory.webSalesmanHomepageUILoader.getController();
        }
        return webSalesmanHomepageUIController;
    }

    public PromotionUIController getPromotionUIController() {
        if(promotionUIController==null){
            getPromotionUIPane();
            promotionUIController = WebSalesmanUIFXMLFactory.promotionUILoader.getController();
        }
        return promotionUIController;
    }

    public ExceptionalOrderUIController getExceptionalOrderUIController() {
        if(exceptionalOrderUIController==null){
            getExceptionalOrderUIPane();
            exceptionalOrderUIController = WebSalesmanUIFXMLFactory.exceptionalOrderUILoader.getController();
        }
        return exceptionalOrderUIController;
    }

    public TopUpCreditUIController getTopUpCreditUIController() {
        if(topUpCreditUIController==null){
            getTopUpCreditUIPane();
            topUpCreditUIController = WebSalesmanUIFXMLFactory.topUpCreditUILoader.getController();
        }
        return topUpCreditUIController;
    }

    public MakeMemberStandardUIController getMakeMemberStandardUIController() {
        if(makeMemberStandardUIController==null){
            getMakeMemberStandardUIPane();
            makeMemberStandardUIController = WebSalesmanUIFXMLFactory.makeMemberStandardUILoader.getController();
        }
        return makeMemberStandardUIController;
    }
}
