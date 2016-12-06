package presentation.Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.UIJumpTool;
import presentation.tools.UserUIFXMLFactory;

import java.io.IOException;

/**
 * Created by john on 2016/12/4.
 */
public class Launcher extends Application{
    public void start(Stage stage){
        try{
            FXMLLoader loader = UserUIFXMLFactory.getUserUIFXMLFactory().getRoleChooseLoader();
            AnchorPane root = loader.load();
            Scene scene = new Scene(root,800,720);
            stage.setTitle("RSH");
            stage.setScene(scene);
            UIJumpTool.getUiJumpTool().setStage(stage);

            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startLaunch(String[] args){
        launch(args);
    }

}
