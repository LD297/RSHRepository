package presentation.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Created by john on 2016/12/4.
 */
public class Launcher extends Application{
    public void start(Stage stage){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("d:/身份选择.fxml"));
            System.out.print(loader.getLocation());
            AnchorPane root = loader.load();
            Scene scene = new Scene(root,800,720);
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startLaunch(String[] args){
        launch(args);
    }

}
