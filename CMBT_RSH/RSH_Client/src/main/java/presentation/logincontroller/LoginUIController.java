package presentation.logincontroller;

/**
 * Created by john on 2016/12/4.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import constant.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

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

    @FXML
    void finishInput(ActionEvent event) {
        String id = idField.getText();
        String password = passwordField.getText();

    }

    @FXML
    void hideOrShow(MouseEvent event) {
        if(showMoreImage.getImage()==showImage){//如果当前是下拉箭头
            showMoreImage.setImage(hideImage);
            FXMLLoader loader = new FXMLLoader();
            AnchorPane belowLogin = null;
            try {
                belowLogin = loader.load(getClass().getResource("/登陆下拉.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            //设置在身份选择界面的位置
            parentAnchorPane.getChildren().add(belowLogin);
            AnchorPane.setRightAnchor(belowLogin,276.0);
            AnchorPane.setLeftAnchor(belowLogin,276.0);
            AnchorPane.setBottomAnchor(belowLogin,223.0);
            AnchorPane.setTopAnchor(belowLogin,446.0);
        }else{
            showMoreImage.setImage(showImage);
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
