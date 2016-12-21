package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;

/**
 * 提示充值密码成功的界面，并在界面显示新密码
 * @author john
 *
 */
public class SuccessResetPasswordUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button iknowButton;

    @FXML
    private Label newPasswordLabel;


    @FXML
    void closeSuccessResetPassword(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
    }
    
    public void init(String password) {
		newPasswordLabel.setText(password);
	}
    
    @FXML
    void initialize() {
        assert iknowButton != null : "fx:id=\"iknowButton\" was not injected: check your FXML file '网管_重置密码成功.fxml'.";
        assert newPasswordLabel != null : "fx:id=\"newPasswordLabel\" was not injected: check your FXML file '网管_重置密码成功.fxml'.";

    }
}
