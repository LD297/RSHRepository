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
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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


    private AnchorPane parentAnchorPane;
    private Role role;

    //image
    private Image showImage = new Image("/images/下拉箭头.png");
    private Image hideImage = new Image("/images/收回箭头.png");

    private boolean show = true;

    @FXML
    void finishInput(ActionEvent event) {
        String id = idField.getText();
        String password = passwordField.getText();
        LoginService loginService = new LoginController();
        ResultMessage resultMessage = loginService.checkOnline(role,id,password);
        if(resultMessage==resultMessage.succeed){
            FXMLLoader loader = new FXMLLoader();
            if(role == Role.user){
                //跳转到搜索酒店界面
                AnchorPane guide = null;
                try {
                    guide = loader.load(getClass().getResource("/fxml/导航栏.fxml"));
                }catch (Exception e){
                    e.printStackTrace();
                }
                Scene scene = new Scene(guide,800,720);
                Stage stage = (Stage)parentAnchorPane.getScene().getWindow();
                stage.setScene(scene);
            }else if(role==Role.hotel){
                //跳转到hotel主界面
            }else if(role==Role.websalesman){
                //跳转到websalesman主界面
            }else{
                //跳转到webmanager主界面
            }
        }else{
            //用户名和密码错误，或者登陆冲突
        }
    }

    @FXML
    void hideOrShow(MouseEvent event) {
        if(show){//如果当前是下拉箭头
            showMoreImage.setImage(hideImage);
            show = false;
            //加载登陆下拉界面
            FXMLLoader loader = new FXMLLoader();
            AnchorPane belowLogin = null;
            try {
                belowLogin = loader.load(getClass().getResource("/fxml/登陆下拉.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //在身份选择界面添加登陆下拉界面
            AnchorPane temp =(AnchorPane) parentAnchorPane.getChildren().get(parentAnchorPane.getChildren().size()-1);
            parentAnchorPane.getChildren().set(parentAnchorPane.getChildren().size()-1,belowLogin);
            parentAnchorPane.getChildren().add(temp);
            //设置登陆下拉在身份选择界面的位置
            AnchorPane.setRightAnchor(belowLogin,276.0);
            AnchorPane.setLeftAnchor(belowLogin,276.0);
            AnchorPane.setBottomAnchor(belowLogin,223.0);
            AnchorPane.setTopAnchor(belowLogin,446.0);
        }else {//如果当前是收起箭头
            System.out.print("true");
            showMoreImage.setImage(showImage);
            show = true;
            //删除登陆下拉界面
            int size = parentAnchorPane.getChildren().size();
            parentAnchorPane.getChildren().remove(size-1);
        }
    }

    void setParentAnchorPane(AnchorPane parentAnchorPane){
        this.parentAnchorPane = parentAnchorPane;
    }

    void setRole(Role role){
        this.role = role;
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file '登陆.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '登陆.fxml'.";
        assert showMoreImage != null : "fx:id=\"showMoreImage\" was not injected: check your FXML file '登陆.fxml'.";


    }
}
