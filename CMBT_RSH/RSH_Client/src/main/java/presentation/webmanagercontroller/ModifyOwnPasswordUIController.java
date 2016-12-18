package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.ImageFactory;
import presentation.tools.WebManagerUIFXMLFactory;

/**
 * 网管修改自己的密码界面
 * @author john
 *
 */
public class ModifyOwnPasswordUIController {

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
    	ManagerHomepageUIController managerHomepageUIController = WebManagerUIFXMLFactory.getInstance().getManagerHomepageUIController();
    	AnchorPane homepageAnchorPane = managerHomepageUIController.getHomepageAnchorPane();
    	homepageAnchorPane.getChildren().remove(homepageAnchorPane.getChildren().size()-1);
    }

    @FXML
    void finishModifyButtonClicked(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert userHeadImage != null : "fx:id=\"userHeadImage\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert finishModifyButton != null : "fx:id=\"finishModifyButton\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert prePasswordField != null : "fx:id=\"prePasswordField\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert confirmNewPasswordField != null : "fx:id=\"confirmNewPasswordField\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert newPasswordField != null : "fx:id=\"newPasswordField\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert prepasswordLabel != null : "fx:id=\"prepasswordLabel\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert confirmnewpasswordLabel != null : "fx:id=\"confirmnewpasswordLabel\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";
        assert newpasswordLabel != null : "fx:id=\"newpasswordLabel\" was not injected: check your FXML file '网管_修改自己的密码.fxml'.";

    }
}
