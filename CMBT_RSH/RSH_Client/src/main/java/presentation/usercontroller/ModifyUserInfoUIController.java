package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.UIJumpTool;

public class ModifyUserInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nicknameField;

    @FXML
    private RadioButton isBoyButton;

    @FXML
    private RadioButton isgirlButton;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField firstnameField;

    @FXML
    private TextField phonenumberField;

    @FXML
    private TextField emailaddressField;

    @FXML
    private ImageView modifypasswordImage;

    @FXML
    private Label modifypasswordLabel;

    @FXML
    void cancelButtonClicked(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToUserInfo();
    }

    @FXML
    void changeToModifyPassword(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToModifyPassword();
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToUserInfo();
    }

    @FXML
    void initialize() {
        assert nicknameField != null : "fx:id=\"nicknameField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert isBoyButton != null : "fx:id=\"isBoyButton\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert isgirlButton != null : "fx:id=\"isgirlButton\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert birthdayPicker != null : "fx:id=\"birthdayPicker\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert firstnameField != null : "fx:id=\"firstnameField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert phonenumberField != null : "fx:id=\"phonenumberField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert emailaddressField != null : "fx:id=\"emailaddressField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert modifypasswordImage != null : "fx:id=\"modifypasswordImage\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert modifypasswordLabel != null : "fx:id=\"modifypasswordLabel\" was not injected: check your FXML file '用户个人资料.fxml'.";

    }
}

