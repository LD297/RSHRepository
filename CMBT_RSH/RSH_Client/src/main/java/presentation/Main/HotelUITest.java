package presentation.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.hotelcontroller.HotelHomepageUIController;
import presentation.tools.HotelUIFactory;
import vo.HotelVO;

import java.io.IOException;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUITest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = HotelUIFactory.getInstance().getHomepageUILoader();
        Parent root = loader.load();
        HotelHomepageUIController controller = loader.getController();
        HotelVO hotelVO = new HotelVO("0123456789","1512028766",
                "天鸿凯莱大酒店", "南京市栖霞区", "仙林大学城", "新开张", "一应俱全",
                4, 4.8, "234459");
        controller.setHotelVO(hotelVO);
        primaryStage.setTitle("hotel");

        // TODO 设置白色背景（目前看来似乎没什么用，我直接用的背景图片）
        primaryStage.initStyle(StageStyle.DECORATED);

        primaryStage.setScene(new Scene(root, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT));
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
