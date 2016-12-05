package presentation.logincontroller;


/**
 * Created by john on 2016/12/4.
 */
import java.net.URL;
import java.util.ResourceBundle;

import constant.Role;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

    //image
    private Image user_bright = new Image("/images/身份选择界面素材/User_bright.jpg");
    private Image hotelStaff_bright = new Image("/images/身份选择界面素材/HM_bright.jpg");
    private Image webSalesman_bright = new Image("/images/身份选择界面素材/WS_bright.jpg");
    private Image webManager_bright = new Image("/images/身份选择界面素材/WM_bright.jpg");
    private Image user_dark = new Image("/images/身份选择界面素材/User_dark.png");
    private Image hotelStaff_dark = new Image("/images/身份选择界面素材/HM_dark.png");
    private Image webSalesman_dark = new Image("/images/身份选择界面素材/WS_dark.png");
    private Image webManager_dark = new Image("/images/身份选择界面素材/WM_dark.png");

    //考虑能不能用一个map
    @FXML
    void changeDarkToLight(MouseEvent event) {
        ImageView imageView = (ImageView)event.getSource();
        if(imageView==userImage){
            userImage.setImage(user_bright);
        }else if(imageView==hotelStaffImage){
            hotelStaffImage.setImage(hotelStaff_bright);
        }else if(imageView==webSalesmanImage){
            webSalesmanImage.setImage(webSalesman_bright);
        }else{
            webManagerImage.setImage(webManager_bright);
        }

    }

    @FXML
    void changeLightToDark(MouseEvent event) {
        ImageView imageView = (ImageView)event.getSource();
        if(imageView==userImage){
            userImage.setImage(user_dark);
        }else if(imageView==hotelStaffImage){
            hotelStaffImage.setImage(hotelStaff_dark);
        }else if(imageView==webSalesmanImage){
            webSalesmanImage.setImage(webSalesman_dark);
        }else{
            webManagerImage.setImage(webManager_dark);
        }
    }

    @FXML
    void changeToLogin(MouseEvent event) {
        //设置背景
        maskLabel.setVisible(true);
        //跳转到login界面
        AnchorPane login = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/登陆.fxml"));
        try {
            login = loader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        //在身份选择界面添加登陆界面
        anchorPanel.getChildren().add(login);
        //设置Login的位置
        AnchorPane.setBottomAnchor(login,274.0);
        AnchorPane.setTopAnchor(login,130.0);
        AnchorPane.setLeftAnchor(login,276.0);
        AnchorPane.setRightAnchor(login,276.0);
        //用于在loginUIController里面设置BelowLoginUIController的位置
        LoginUIController loginUIController = (LoginUIController)loader.getController();
        loginUIController.setParentAnchorPane(anchorPanel);
        //设置LoginUIController的Role
        Role role;
        ImageView imageView = (ImageView)event.getSource();
        if(imageView==userImage){
            role = Role.user;
        }else if(imageView==hotelStaffImage){
            role = Role.hotel;
        }else if(imageView==webSalesmanImage){
            role = Role.websalesman;
        }else{
            role = Role.webmanager;
        }
       loginUIController.setRole(role);
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

