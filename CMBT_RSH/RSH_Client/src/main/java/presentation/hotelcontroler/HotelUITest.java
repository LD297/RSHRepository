package presentation.hotelcontroler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by a297 on 16/12/5.
 */
public class HotelUITest extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../resources/fxml/酒店首页.fxml"));
        primaryStage.setTitle("hotel");
        primaryStage.setScene(new Scene(root, 800, 720));
        primaryStage.show();

    }
    public static void main(String[] args){
        launch(args);
    }
}
