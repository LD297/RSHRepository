package presentation.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by a297 on 16/11/27.
 */
public class HotelInfoView extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("HotelInfoView.fxml"));
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setTitle("HotelInfoView");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
