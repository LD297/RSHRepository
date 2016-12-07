package presentation.usercontroller;

/**
 * Created by john on 2016/12/4.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.logincontroller.LoginUIController;
import presentation.tools.UIJumpTool;

public class UserRegisterUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nicknameField;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phoneNumButton;

    @FXML
    private RadioButton boyButton;

    @FXML
    private RadioButton girlButton;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private Button finishRegisterButton;

    @FXML
    private TextField emailButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ImageView returnImage;

    //点击返回箭头，舍弃一切注册的内容，直接返回
    @FXML
    void backToLogin(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeRegisterToLogin();
    }

    //点击完成注册，将该用户注册的内容存到数据库，并且返回到登陆界面，set登陆界面的用户名和密码
    @FXML
    void finishRegister(MouseEvent event) {
        //TODO 将该用户注册的内容存到数据库
        //返回到登陆界面
        UIJumpTool.getUiJumpTool().changeRegisterToLogin();
        //TODO set登陆界面的用户名和密码

    }

    @FXML
    void initialize() {
        assert nicknameField != null : "fx:id=\"nicknameField\" was not injected: check your FXML file '用户注册.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file '用户注册.fxml'.";
        assert phoneNumButton != null : "fx:id=\"phoneNumButton\" was not injected: check your FXML file '用户注册.fxml'.";
        assert boyButton != null : "fx:id=\"boyButton\" was not injected: check your FXML file '用户注册.fxml'.";
        assert girlButton != null : "fx:id=\"girlButton\" was not injected: check your FXML file '用户注册.fxml'.";
        assert dataPicker != null : "fx:id=\"dataPicker\" was not injected: check your FXML file '用户注册.fxml'.";
        assert finishRegisterButton != null : "fx:id=\"finishRegisterButton\" was not injected: check your FXML file '用户注册.fxml'.";
        assert emailButton != null : "fx:id=\"emailButton\" was not injected: check your FXML file '用户注册.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '用户注册.fxml'.";
        assert confirmPasswordField != null : "fx:id=\"confirmPasswordField\" was not injected: check your FXML file '用户注册.fxml'.";
        assert returnImage != null : "fx:id=\"returnImage\" was not injected: check your FXML file '用户注册.fxml'.";

    }
}

