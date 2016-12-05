package presentation.Main;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import presentation.tools.HotelUIFactory;

import java.io.IOException;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUITest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = HotelUIFactory.getInstance().getHomepageUILoader().load();
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
