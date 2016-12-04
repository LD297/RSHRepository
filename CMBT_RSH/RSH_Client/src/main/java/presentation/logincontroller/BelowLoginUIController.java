package presentation.logincontroller;

import java.net.URL;
import java.util.ResourceBundle;

import constant.Role;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;

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
    @FXML
    void changeToRegister(MouseEvent event) {
        if(role==Role.user){
            //跳转到用户注册界面

        }
    }

    void setRole(Role role){
        this.role = role;
    }

    @FXML
    void initialize() {
        assert rememberPasswordButton != null : "fx:id=\"rememberPasswordButton\" was not injected: check your FXML file '登陆下拉.fxml'.";
        assert registerLabel != null : "fx:id=\"registerLabel\" was not injected: check your FXML file '登陆下拉.fxml'.";

    }
}

