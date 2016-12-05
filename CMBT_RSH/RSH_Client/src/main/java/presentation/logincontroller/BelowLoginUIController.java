package presentation.logincontroller;

import java.net.URL;
import java.util.ResourceBundle;

import constant.Role;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.usercontroller.UserRegisterUIController;

/**
 * Created by john on 2016/12/4.
 */

public class BelowLoginUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private RadioButton rememberPasswordButton;

    @FXML
    private Label registerLabel;

    private Role role;
    private AnchorPane parentAnchorPane;
    private LoginUIController loginUIController;
    @FXML
    void changeToRegister(MouseEvent event) {
        if(role==Role.user){
            //关闭登陆下拉界面
            int size = parentAnchorPane.getChildren().size();
            parentAnchorPane.getChildren().remove(size-2);
            //将登陆界面的收回箭头改为下拉箭头
            Image showImage = new Image("/images/下拉箭头.png");
            loginUIController.getShowMoreImage().setImage(showImage);
            loginUIController.setShow(true);
            //跳转到用户注册界面
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/用户注册.fxml"));
            AnchorPane userRegister = null;
            try {
                userRegister = loader.load();
            }catch (Exception e){
                e.printStackTrace();
            }
            Stage stage = (Stage)parentAnchorPane.getScene().getWindow();
            Scene scene = new Scene(userRegister,800,720);
            stage.setScene(scene);
            stage.setTitle("用户注册");
            //用于在注册界面关闭时还原登陆场景
            UserRegisterUIController userRegisterUIController = (UserRegisterUIController)loader.getController();
            userRegisterUIController.setParentAnchorPane(parentAnchorPane);

        }
    }

    void setRole(Role role){
        this.role = role;
    }

    void setParentAnchorPane(AnchorPane parentAnchorPane){this.parentAnchorPane = parentAnchorPane;}

    void setLoginUIController(LoginUIController loginUIController){this.loginUIController = loginUIController;}

    @FXML
    void initialize() {
        assert rememberPasswordButton != null : "fx:id=\"rememberPasswordButton\" was not injected: check your FXML file '登陆下拉.fxml'.";
        assert registerLabel != null : "fx:id=\"registerLabel\" was not injected: check your FXML file '登陆下拉.fxml'.";

    }
}

