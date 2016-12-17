package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.tools.WebManagerUIFXMLFactory;

/**
 * 网管查看用户信息界面
 * @author john
 *
 */
public class CheckUserInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView cancelImage;

    @FXML
    private Label usernameLabel;

    @FXML
    private ImageView sexImage;

    @FXML
    private Label userNicknameLabel;

    @FXML
    private Label userPhonelabel;

    @FXML
    private Label memberTypeLabel;

    @FXML
    private Label userCreditLabel;

    @FXML
    private Label memberLevelLabel;

    @FXML
    private Button resetPasswordButton;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void changeToSuccessResetPassword(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	AnchorPane successResetPassword = WebManagerUIFXMLFactory.getInstance().getSuccessResetPassword();
    	manageUser.getChildren().add(successResetPassword);
    }


    @FXML
    void closeCheckUserInfo(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
    }

    @FXML
    void initialize() {
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert usernameLabel != null : "fx:id=\"usernameLabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert sexImage != null : "fx:id=\"sexImage\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert userNicknameLabel != null : "fx:id=\"userNicknameLabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert userPhonelabel != null : "fx:id=\"userPhonelabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert memberTypeLabel != null : "fx:id=\"memberTypeLabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert userCreditLabel != null : "fx:id=\"userCreditLabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert memberLevelLabel != null : "fx:id=\"memberLevelLabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
        assert resetPasswordButton != null : "fx:id=\"resetPasswordButton\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";

    }
}
