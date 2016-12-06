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
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;
import presentation.tools.UserUIFXMLFactory;
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
    private LoginUIController loginUIController;


    //点击注册账号label跳转到注册界面
    @FXML
    void changeToRegister(MouseEvent event) {
        if(role==Role.user){
            //关闭登陆下拉界面
            UIJumpTool.getUiJumpTool().removeLoginBelow();
            //将登陆界面的收回箭头改为下拉箭头
            loginUIController.setShow(true);
            //跳转到用户注册界面
            UserRegisterUIController userRegisterUIController = UIJumpTool.getUiJumpTool().changeLoginToRegister();
            userRegisterUIController.setLoginUIController(loginUIController);//用于将用户名和密码返回给登陆界面
        }
    }

    void setRole(Role role){
        this.role = role;
    }

    void setLoginUIController(LoginUIController loginUIController){this.loginUIController = loginUIController;}

    @FXML
    void initialize() {
        assert rememberPasswordButton != null : "fx:id=\"rememberPasswordButton\" was not injected: check your FXML file '登陆下拉.fxml'.";
        assert registerLabel != null : "fx:id=\"registerLabel\" was not injected: check your FXML file '登陆下拉.fxml'.";

    }
}

