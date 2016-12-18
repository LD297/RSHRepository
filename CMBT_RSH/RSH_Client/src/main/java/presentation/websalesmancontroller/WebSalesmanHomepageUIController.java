package presentation.websalesmancontroller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.hotelcontroller.AboutUsUIController;
import presentation.hotelcontroller.PromotionUIController;
import presentation.tools.HotelAndWebSalesmanUIFactory;
import presentation.tools.Locator;

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
    private ImageView makeMememberStandard;

    @FXML
    private ImageView promotin;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ImageView logo;

    @FXML
    private ImageView topUpCredit;

    @FXML
    private ImageView exceptionalOrder;

    @FXML
    private ImageView whiteBackground;

    private static AnchorPane promotionPane;
    private static AnchorPane exceptionalOrderPane;
    private static AnchorPane topUpCreditPane;
    private static AnchorPane makeMemberStandardPane;

    private static PromotionUIController promotionUIController;
    private static ExceptionalOrderUIController exceptionalOrderUIController;
    private static TopUpCreditUIController topUpCreditUIController;
    private static AboutUsUIController makeMemberStandardUIController;

    private static final int NUM_OF_NEXTPAGE = 4;

    private void prePareNextPage() {
        FXMLLoader loader0 = HotelAndWebSalesmanUIFactory.getInstance().getPromotionUILoader();
        FXMLLoader loader1 = HotelAndWebSalesmanUIFactory.getInstance().getExceptionalOrderUILoader();
        FXMLLoader loader2 = HotelAndWebSalesmanUIFactory.getInstance().getTopUpCreditUILoader();
        FXMLLoader loader3 = HotelAndWebSalesmanUIFactory.getInstance().getMakeMemberStandardUILoader();

        // 加载各页根结点
        if(promotionPane==null)
            try {
                promotionPane = (AnchorPane) loader0.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(exceptionalOrderPane==null)
            try {
                exceptionalOrderPane = (AnchorPane) loader1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(topUpCreditPane==null)
            try {
                topUpCreditPane = (AnchorPane) loader2.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        if(makeMemberStandardPane==null)
            try {
                makeMemberStandardPane = (AnchorPane) loader3.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(topUpCreditPane.getChildren().size());
        // 得到各页控制器
        if(promotionUIController==null)
            promotionUIController = loader0.getController();
        if(exceptionalOrderUIController==null)
            exceptionalOrderUIController = loader1.getController();
        if(topUpCreditUIController==null)
            topUpCreditUIController = loader2.getController();
        if(makeMemberStandardUIController==null)
            makeMemberStandardUIController = loader3.getController();

        // 传入首页根结点
        promotionUIController.setPrePane(anchorPane);
        exceptionalOrderUIController.setPrePane(anchorPane);
        topUpCreditUIController.setPrePane(anchorPane);
        makeMemberStandardUIController.setPrePane(anchorPane);
    }

    @FXML
    void changeToPromotionUI(MouseEvent event) {
        Scene scene = null;
        if(promotionPane.getScene()==null)
            scene = new Scene(promotionPane, HotelAndWebSalesmanUIFactory.UI_WIDTH, HotelAndWebSalesmanUIFactory.UI_HEIGHT);
        else
            scene = promotionPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToExceptionalOrderUI(MouseEvent event) {
        Scene scene = null;
        if(exceptionalOrderPane.getScene()==null)
            scene = new Scene(exceptionalOrderPane, HotelAndWebSalesmanUIFactory.UI_WIDTH, HotelAndWebSalesmanUIFactory.UI_HEIGHT);
        else
            scene = exceptionalOrderPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToTopUpCreditUI(MouseEvent event) {
        Scene scene = null;
        if(topUpCreditPane.getScene()==null){
            scene = new Scene(topUpCreditPane, 600, 450);
        }

        else
            scene = topUpCreditPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void changeToMakeMemberStandardUI(MouseEvent event) {
        Scene scene = null;
        if(makeMemberStandardPane.getScene()==null){
            scene = new Scene(makeMemberStandardPane, 600, 450);
        }

        else
            scene = makeMemberStandardPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert makeMemberStandardPane != null : "fx:id=\"makeMemberStandardPane\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert promotin != null : "fx:id=\"promotin\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert logo != null : "fx:id=\"logo\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert topUpCredit != null : "fx:id=\"topUpCredit\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert exceptionalOrder != null : "fx:id=\"exceptionalOrder\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        assert whiteBackground != null : "fx:id=\"whiteBackground\" was not injected: check your FXML file '网站营销人员首页.fxml'.";
        prePareNextPage();
    }
}
