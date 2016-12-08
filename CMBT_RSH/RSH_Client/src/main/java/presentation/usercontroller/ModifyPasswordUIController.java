package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInputFormCheckTool;

public class ModifyPasswordUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView userHeadImage;

    @FXML
    private Button finishModifyButton;

    @FXML
    private PasswordField prePasswordField;

    @FXML
    private PasswordField confirmNewPasswordField;

    @FXML
    private PasswordField newPasswordField;

    @FXML
    private ImageView cancelImage;

    @FXML
    private Label prepasswordLabel;

    @FXML
    private Label confirmnewpasswordLabel;

    @FXML
    private Label newpasswordLabel;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeModifyPassword(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeModifypasswordToModifyuserinfo();
    }

    @FXML
    void finishModifyButtonClicked(MouseEvent event) {

        UIJumpTool.getUiJumpTool().changeModifypasswordToModifyuserinfo();
    }

    @FXML
    void initialize() {
        assert userHeadImage != null : "fx:id=\"userHeadImage\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert finishModifyButton != null : "fx:id=\"finishModifyButton\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert prePasswordField != null : "fx:id=\"prePasswordField\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert confirmNewPasswordField != null : "fx:id=\"confirmNewPasswordField\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert newPasswordField != null : "fx:id=\"newPasswordField\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert prepasswordLabel != null : "fx:id=\"prepasswordLabel\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert confirmnewpasswordLabel != null : "fx:id=\"confirmnewpasswordLabel\" was not injected: check your FXML file '修改密码新.fxml'.";
        assert newpasswordLabel != null : "fx:id=\"newpasswordLabel\" was not injected: check your FXML file '修改密码新.fxml'.";

    }
}

