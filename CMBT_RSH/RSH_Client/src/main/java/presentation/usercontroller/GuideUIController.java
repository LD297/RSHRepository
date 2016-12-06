package presentation.usercontroller;

/**
 * Created by john on 2016/12/5.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.UIJumpTool;

public class GuideUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView backImage;

    @FXML
    private TextField whereToGoField;

    @FXML
    private Label helpLabel;

    @FXML
    private Label logoutLabel;

    @FXML
    private ImageView headImage;

    @FXML
    private ImageView headMaskImage;


    //点击help label跳出help提示框
    @FXML
    void changeToHeplInfo(MouseEvent event) {

    }

    //点击退出label跳转到登陆界面
    @FXML
    void changeToLogin(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeGuideToLogin();
    }

    //点击搜索框跳转到搜索酒店界面，并且设置光标
    @FXML
    void changeToSearchHotel(ActionEvent event) {
        UIJumpTool.getUiJumpTool().changeToSearchHotel();
    }

    //点击头像跳转到用户个人信息界面
    @FXML
    void changeToUserInfo(MouseEvent event) {

    }

    //点击返回箭头
    @FXML
    void back(MouseEvent event) {
        UIJumpTool.getUiJumpTool().back();
    }

    public void setBackImage(boolean visible){backImage.setVisible(visible);}

    @FXML
    void initialize() {
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '导航栏.fxml'.";
        assert whereToGoField != null : "fx:id=\"whereToGoField\" was not injected: check your FXML file '导航栏.fxml'.";
        assert helpLabel != null : "fx:id=\"helpLabel\" was not injected: check your FXML file '导航栏.fxml'.";
        assert logoutLabel != null : "fx:id=\"logoutLabel\" was not injected: check your FXML file '导航栏.fxml'.";
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '导航栏.fxml'.";
        assert headMaskImage != null : "fx:id=\"headMaskImage\" was not injected: check your FXML file '导航栏.fxml'.";

    }
}

