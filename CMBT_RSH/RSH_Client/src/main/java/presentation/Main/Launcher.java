package presentation.Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.usercontrollertools.UserUIFXMLFactory;

/**
 * Created by john on 2016/12/4.
 * 启动界面
 */
public class Launcher extends Application{
    public void start(Stage stage){
        try{
            AnchorPane roleChoose = UserUIFXMLFactory.getUserUIFXMLFactory().getRoleChoose();
            Scene scene = new Scene(roleChoose,800,720);
            stage.setTitle("RSH");
            stage.setScene(scene);
//            UIJumpTool.getUiJumpTool().setStage(stage);
            stage.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void startLaunch(String[] args){
        launch(args);
    }
/*    public static void main(String[] args){
        launch(args);
    }*/

}
