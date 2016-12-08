package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.UIJumpTool;

public class UserInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView headImage;

    @FXML
    private Button changeHeadimageButton;

    @FXML
    private Label modifyInfoLabel;

    @FXML
    private Label nicknameLabel;

    @FXML
    private ImageView modifyInfoImage;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label phonenumberLabel;

    @FXML
    private Label emailaddressLabel;

    @FXML
    void changeHeadImage(MouseEvent event) {

    }

    @FXML
    void changeToModifyUserInfo(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToModifyUserInfo();
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '我的信息.fxml'.";
        assert changeHeadimageButton != null : "fx:id=\"changeHeadimageButton\" was not injected: check your FXML file '我的信息.fxml'.";
        assert modifyInfoLabel != null : "fx:id=\"modifyInfoLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert nicknameLabel != null : "fx:id=\"nicknameLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert modifyInfoImage != null : "fx:id=\"modifyInfoImage\" was not injected: check your FXML file '我的信息.fxml'.";
        assert userNameLabel != null : "fx:id=\"userNameLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert birthdayLabel != null : "fx:id=\"birthdayLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert phonenumberLabel != null : "fx:id=\"phonenumberLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert emailaddressLabel != null : "fx:id=\"emailaddressLabel\" was not injected: check your FXML file '我的信息.fxml'.";

    }
}

