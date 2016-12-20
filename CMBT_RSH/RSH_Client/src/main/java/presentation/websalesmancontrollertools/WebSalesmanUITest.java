package presentation.websalesmancontrollertools;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import presentation.websalesmancontroller.WebSalesmanHomepageUIController;
import presentation.websalesmancontrollertools.WebSalesmanUIFXMLFactory;

/**
 * Created by a297 on 16/12/18.
 */
public class WebSalesmanUITest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = WebSalesmanUIFXMLFactory.getInstance().getWebSalesmanHomepageUILoader();
        Parent root = loader.load();
        // TODO 设置一些该地区（网站营销人员）信息
        WebSalesmanHomepageUIController controller = loader.getController();
        Scene scene = new Scene(root, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}
