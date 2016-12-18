package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import constant.Sexuality;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.tools.WebManagerInfoUtil;
import presentation.tools.WebManagerUIFXMLFactory;
import vo.UserVO;

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
    private String userid = null;

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
    	//重置密码
    	String password = WebManagerInfoUtil.getInstance().resetPassword(userid);
		AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
		AnchorPane successResetPassword = WebManagerUIFXMLFactory.getInstance().getSuccessResetPassword();
		SuccessResetPasswordUIController successResetPasswordUIController = WebManagerUIFXMLFactory.getInstance()
				.getSuccessResetPasswordUIController();
		successResetPasswordUIController.init(password);//提示重置密码成功，并显示新密码
		manageUser.getChildren().add(successResetPassword);
	}


    @FXML
    void closeCheckUserInfo(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
    }
    
    public void init(UserVO userVO) {
    	userid = userVO.id;
    	usernameLabel.setText(userVO.name);
    	userCreditLabel.setText(String.valueOf(userVO.credit));
    	userNicknameLabel.setText(userVO.nickName);
    	userPhonelabel.setText(userVO.id);
    	if(userVO.memberType==null){
    		memberTypeLabel.setText("非会员");
    	}else {
    		memberTypeLabel.setText(userVO.memberType.getString());
		}
    	memberLevelLabel.setText(String.valueOf(userVO.level));
    	if(userVO.sexuality==Sexuality.female){
    		sexImage.setImage(ImageFactory.getImageFactory().getFemale());
    	}else {
			sexImage.setImage(ImageFactory.getImageFactory().getMale());
		}
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
