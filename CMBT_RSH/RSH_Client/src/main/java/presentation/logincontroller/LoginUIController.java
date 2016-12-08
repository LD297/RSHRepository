package presentation.logincontroller;

/**
 * Created by john on 2016/12/4.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import constant.ResultMessage;
import constant.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.tools.*;
import presentation.usercontroller.GuideUIController;
import presentation.usercontroller.SearchHotelUIController;

public class LoginUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView headImage;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView showMoreImage;

    @FXML
    private ImageView cancelImage;

    @FXML
    private AnchorPane loginBelowAnchorpane;

    @FXML
    private RadioButton rememberPasswordButton;

    @FXML
    private Label registerLabel;

    private Role role;

    //image
    private Image showImage = ImageFactory.getImageFactory().getShowImage();
    private Image hideImage = ImageFactory.getImageFactory().getHideImage();
    private Image cancel_gray = ImageFactory.getImageFactory().getCancel_gray();
    private Image cancel_red = ImageFactory.getImageFactory().getCancel_red();

    private boolean show = true;//true表示当前是下拉箭头

    //点击注册跳转到注册界面
    @FXML
    void changeToRegister(MouseEvent event) {
        //关闭登陆下拉界面
        loginBelowAnchorpane.setVisible(false);
        //将登陆界面的收回箭头改为下拉箭头
        show = true;
        showMoreImage.setImage(ImageFactory.getImageFactory().getShowImage());
        //跳转
        UIJumpTool.getUiJumpTool().changeLoginToRegister();
    }

    //输入用户名和密码之后敲击回车完成登陆，跳转到相应的客户端的主界面
    @FXML
    void finishInput(ActionEvent event) {
        String id = idField.getText();
        String password = passwordField.getText();
        //TODO 输入格式检查
        LoginService loginService = new LoginController();
        ResultMessage resultMessage = loginService.checkOnline(role,id,password);
        if(resultMessage==resultMessage.succeed){
            if(role == Role.user){
                //跳转到搜索酒店界面
                if(loginBelowAnchorpane.isVisible()){//先判断有没有登陆下拉界面,有就删除
                    loginBelowAnchorpane.setVisible(false);
                }
                UIJumpTool.getUiJumpTool().changeLoginToSearchHotel();
            }else if(role==Role.hotel){
                //跳转到hotel主界面
                UIJumpTool.getUiJumpTool().changeLoginToHotelHomePage();
            }else if(role==Role.websalesman){
                //TODO 跳转到websalesman主界面
            }else{
                //TODO 跳转到webmanager主界面
            }
        }else{
            //TODO 用户名和密码错误，或者登陆冲突
        }
    }

    //展开或收起登陆下拉界面
    @FXML
    void hideOrShow(MouseEvent event) {
        if(show){//如果当前是下拉箭头
            showMoreImage.setImage(hideImage);//将箭头改为收起箭头
            show = false;
            loginBelowAnchorpane.setVisible(true);
        }else {//如果当前是收起箭头
            showMoreImage.setImage(showImage);//将箭头改为下拉箭头
            show = true;
            //删除登陆下拉界面
            loginBelowAnchorpane.setVisible(false);
        }
    }

    //点击叉叉，取消登陆，返回身份选择界面
    @FXML
    void backToRoleChoose(MouseEvent event) {
        if(!show){//如果当前是收起箭头，说明登陆下拉界面已经被放在身份选择界面上，这时要先删除登陆下拉界面
            //删除登陆下拉界面
            loginBelowAnchorpane.setVisible(false);
        }
        //删除登陆界面
         UIJumpTool.getUiJumpTool().removeLogin();
    }

    //将取消的叉叉变为灰色
    @FXML
    void changeToGray(MouseEvent event) {
        cancelImage.setImage(cancel_gray);
    }

    //将取消的叉叉变为红色
    @FXML
    void changeToRed(MouseEvent event) {
        cancelImage.setImage(cancel_red);
    }

    void setRole(Role role){
        this.role = role;
    }

    void setShow(boolean show){
        this.show = show;
        if(show){
            showMoreImage.setImage(showImage);
        }else {
            showMoreImage.setImage(hideImage);
        }
    }

    void setShowMoreImage(boolean visible){
        showMoreImage.setVisible(visible);
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file '登陆.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '登陆.fxml'.";
        assert showMoreImage != null : "fx:id=\"showMoreImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert loginBelowAnchorpane != null : "fx:id=\"loginBelowAnchorpane\" was not injected: check your FXML file '登陆.fxml'.";
        assert rememberPasswordButton != null : "fx:id=\"rememberPasswordButton\" was not injected: check your FXML file '登陆.fxml'.";
        assert registerLabel != null : "fx:id=\"registerLabel\" was not injected: check your FXML file '登陆.fxml'.";

    }
}
