package presentation.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import presentation.tools.HotelAndWebSalesmanUIFactory;
import presentation.websalesmancontroller.WebSalesmanHomepageUIController;

/**
 * Created by a297 on 16/12/18.
 */
public class WebSalesmanUITest extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = HotelAndWebSalesmanUIFactory.getInstance().getWebSalesmanHomepageUILoader();
        Parent root = loader.load();
        // TODO 设置一些该地区（网站营销人员）信息
        WebSalesmanHomepageUIController controller = loader.getController();
        Scene scene = new Scene(root, HotelAndWebSalesmanUIFactory.UI_WIDTH, HotelAndWebSalesmanUIFactory.UI_HEIGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args){
        launch(args);
    }

}
