package presentation.websalesmancontroller;

import bl.loginservice.LoginService;
import bl.orderservice.OrderForWebsite;
import bl.promotionservice.PromotionService;
import bl.userservice.UserService;
import bl.webstaffservice.WebStaffService;
import bl.webstaffserviceimpl.WebSalesman;
import constant.Role;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.hotelcontroller.PromotionUIController;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import presentation.websalesmancontrollertools.WebSalesmanServiceFactory;
import presentation.websalesmancontrollertools.WebSalesmanUIFXMLFactory;
import vo.WebSalesmanVO;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by a297 on 16/12/18.
 */
public class WebSalesmanHomepageUIController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView makeMemberStandard;

    @FXML
    private ImageView promotin;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView logoutImageView;

    @FXML
    private ImageView topUpCredit;

    @FXML
    private ImageView exceptionalOrder;

    @FXML
    private ImageView whiteBackground;


    private LoginService loginService;
    private WebStaffService webStaffService;

    private String webSalesmanId;
    private WebSalesmanVO webSalesmanVO;
    private AnchorPane prePane;

    private static AnchorPane promotionPane;
    private static AnchorPane exceptionalOrderPane;
    private static AnchorPane topUpCreditPane;
    private static AnchorPane makeMemberStandardPane;

    private static PromotionUIController promotionUIController;
    private static ExceptionalOrderUIController exceptionalOrderUIController;
    private static TopUpCreditUIController topUpCreditUIController;
    private static MakeMemberStandardUIController makeMemberStandardUIController;

    private static final int NUM_OF_NEXTPAGE = 4;
//
//    private void prePareNextPage() {
//        FXMLLoader loader0 = WebSalesmanUIFXMLFactory.getInstance().getPromotionUILoader();
//        FXMLLoader loader1 = WebSalesmanUIFXMLFactory.getInstance().getExceptionalOrderUILoader();
//        FXMLLoader loader2 = WebSalesmanUIFXMLFactory.getInstance().getTopUpCreditUILoader();
//        FXMLLoader loader3 = WebSalesmanUIFXMLFactory.getInstance().getMakeMemberStandardUILoader();
//
//        // 加载各页根结点
//        if(promotionPane==null)
//            try {
//                promotionPane = (AnchorPane) loader0.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        if(exceptionalOrderPane==null)
//            try {
//                exceptionalOrderPane = (AnchorPane) loader1.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        if(topUpCreditPane==null)
//            try {
//                topUpCreditPane = (AnchorPane) loader2.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        if(makeMemberStandardPane==null)
//            try {
//                makeMemberStandardPane = (AnchorPane) loader3.load();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        // 得到各页控制器
//        if(promotionUIController==null)
//            promotionUIController = loader0.getController();
//        if(exceptionalOrderUIController==null)
//            exceptionalOrderUIController = loader1.getController();
//        if(topUpCreditUIController==null)
//            topUpCreditUIController = loader2.getController();
//        if(makeMemberStandardUIController==null)
//            makeMemberStandardUIController = loader3.getController();
//
//        // 传入首页根结点
//        promotionUIController.setPrePane(anchorPane);
//        exceptionalOrderUIController.setPrePane(anchorPane);
//        topUpCreditUIController.setPrePane(anchorPane);
//        makeMemberStandardUIController.setPrePane(anchorPane);
//    }

    @FXML
    void changeToPromotionUI(MouseEvent event) {

        promotionPane = WebSalesmanUIFXMLFactory.getInstance().getPromotionUIPane();
        promotionUIController =WebSalesmanUIFXMLFactory.getInstance().getPromotionUIController();

        Scene scene = null;
        if(promotionPane.getScene()==null)
            scene = new Scene(promotionPane, WebSalesmanUIFXMLFactory.UI_WIDTH, WebSalesmanUIFXMLFactory.UI_HEIGHT);
        else
            scene = promotionPane.getScene();

        promotionUIController.setPrePane(anchorPane);
        promotionUIController.setWebSalesVO(webSalesmanVO);
        promotionUIController.setSetterId();
        promotionUIController.refreshPage();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToExceptionalOrderUI(MouseEvent event) {

        exceptionalOrderPane = WebSalesmanUIFXMLFactory.getInstance().getExceptionalOrderUIPane();
        exceptionalOrderUIController = WebSalesmanUIFXMLFactory.getInstance().getExceptionalOrderUIController();

        Scene scene = null;
        if(exceptionalOrderPane.getScene()==null)
            scene = new Scene(exceptionalOrderPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = exceptionalOrderPane.getScene();

        exceptionalOrderUIController.refreshPage();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToTopUpCreditUI(MouseEvent event) {

        topUpCreditPane = WebSalesmanUIFXMLFactory.getInstance().getTopUpCreditUIPane();
        topUpCreditUIController = WebSalesmanUIFXMLFactory.getInstance().getTopUpCreditUIController();

        Scene scene = null;
        if(topUpCreditPane.getScene()==null){
            scene = new Scene(topUpCreditPane, WebSalesmanUIFXMLFactory.TOPUPCREDIT_WIDTH,
                    WebSalesmanUIFXMLFactory.TOPUPCREDIT_HEIGHT);
        }
        else
            scene = topUpCreditPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setX(WebSalesmanUIFXMLFactory.TOPUPCREDIT_X);
        stage.setY(WebSalesmanUIFXMLFactory.TOPUPCREDIT_Y);
        stage.setScene(scene);
    }

    @FXML
    void changeToMakeMemberStandardUI(MouseEvent event) {

        makeMemberStandardPane = WebSalesmanUIFXMLFactory.getInstance().getMakeMemberStandardUIPane();
        makeMemberStandardUIController = WebSalesmanUIFXMLFactory.getInstance().getMakeMemberStandardUIController();

        Scene scene = null;
        if(makeMemberStandardPane.getScene()==null){
            scene = new Scene(makeMemberStandardPane,
                    WebSalesmanUIFXMLFactory.TOPUPCREDIT_WIDTH, WebSalesmanUIFXMLFactory.TOPUPCREDIT_HEIGHT);
        }

        else
            scene = makeMemberStandardPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setX(WebSalesmanUIFXMLFactory.TOPUPCREDIT_X);
        stage.setY(WebSalesmanUIFXMLFactory.TOPUPCREDIT_Y);
        stage.setScene(scene);
    }

    @FXML
    void logout(MouseEvent event){
        loginService.logout(Role.websalesman, webSalesmanVO.getId());
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());

    }

    @FXML
    void initialize() {
        assert makeMemberStandard != null : "fx:id=\"makeMemberStandard\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert promotin != null : "fx:id=\"promotin\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert logoutImageView != null : "fx:id=\"logoutImageView\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert topUpCredit != null : "fx:id=\"topUpCredit\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert exceptionalOrder != null : "fx:id=\"exceptionalOrder\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert whiteBackground != null : "fx:id=\"whiteBackground\" was not injected: check your FXML file '网站营销人员首页.fxml'.";

        initializeService();
    }

    private void initializeService() {
        this.loginService = WebSalesmanServiceFactory.getInstance().getLoginService();
        this.webStaffService = WebSalesmanServiceFactory.getInstance().getWebStaffService();
    }

    public void setWebSalesmanId(String id){this.webSalesmanId = id;}

    public void setWebSalesmanVO() {
        this.webSalesmanVO = webStaffService.webSalesmanVO(webSalesmanId);
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
}
