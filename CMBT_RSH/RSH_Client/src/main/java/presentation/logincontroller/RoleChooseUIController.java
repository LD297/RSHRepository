package presentation.logincontroller;


/**
 * Created by john on 2016/12/4.
 */
import java.net.URL;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import constant.Role;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.*;

public class RoleChooseUIController {
    @FXML
    private AnchorPane anchorPanel;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView userImage;

    @FXML
    private ImageView hotelStaffImage;

    @FXML
    private ImageView webSalesmanImage;

    @FXML
    private ImageView webManagerImage;

    @FXML
    private Label maskLabel;

    //考虑能不能用一个map
    //鼠标移到头像上，头像变亮
    @FXML
    void changeDarkToLight(MouseEvent event) {
        ImageView imageView = (ImageView)event.getSource();
        MyMap turnBright = ImageFactory.getImageFactory().
                getTurnBright(userImage, hotelStaffImage, webSalesmanImage, webManagerImage);
        imageView.setImage((Image) turnBright.get(imageView));

    }

    //鼠标离开头像，头像变暗
    @FXML
    void changeLightToDark(MouseEvent event) {
        ImageView imageView = (ImageView)event.getSource();
        MyMap turnDark = ImageFactory.getImageFactory().
                getTurnDark(userImage, hotelStaffImage, webSalesmanImage, webManagerImage);
        imageView.setImage((Image) turnDark.get(imageView));
    }

    //点击头像跳转到登陆界面
    @FXML
    void changeToLogin(MouseEvent event) {
        //设置背景
        maskLabel.setVisible(true);
        //设置uijumptool中的role choose用于之后的界面跳转
        UIJumpTool.getUiJumpTool().setRoleChoose(anchorPanel);
        //跳转到login界面
        LoginUIController loginUIController = UIJumpTool.getUiJumpTool().addLogin();
        //设置LoginUIController的Role
        ImageView imageView = (ImageView)event.getSource();
        MyMap viewRoleMap = ImageFactory.getImageFactory().
                getViewRoleMap(userImage, hotelStaffImage, webSalesmanImage, webManagerImage);
        Role role = (Role) viewRoleMap.get(imageView);
        loginUIController.setRole(role);
        if(role!=Role.user){//只有用户才可以看到下拉箭头
            loginUIController.setShowMoreImage(false);
        }
    }

    @FXML
    void initialize() {
        assert anchorPanel != null : "fx:id=\"anchorPanel\" was not injected: check your FXML file '身份选择.fxml'.";
        assert userImage != null : "fx:id=\"userImage\" was not injected: check your FXML file '身份选择.fxml'.";
        assert hotelStaffImage != null : "fx:id=\"hotelStaffImage\" was not injected: check your FXML file '身份选择.fxml'.";
        assert webSalesmanImage != null : "fx:id=\"webSalesmanImage\" was not injected: check your FXML file '身份选择.fxml'.";
        assert webManagerImage != null : "fx:id=\"webManagerImage\" was not injected: check your FXML file '身份选择.fxml'.";
        assert maskLabel != null : "fx:id=\"maskLabel\" was not injected: check your FXML file '身份选择.fxml'.";

    }
}

