package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;

import constant.ResultMessage;
import constant.Sexuality;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.webmanagercontrollertools.WebManagerInfoUtil;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
import vo.UserVO;

public class ModifyUserInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView cancelImage;

    @FXML
    private ImageView sexImage;

    @FXML
    private Label memberTypeLabel;

    @FXML
    private Label userCreditLabel;

    @FXML
    private Label memberLevelLabel;

    @FXML
    private Button finishModifyButton;

    @FXML
    private TextField nameField;

    @FXML
    private Label phoneLabel;

    @FXML
    private TextField nickNameField;
    @FXML
    private Label messageLabel;
    
    @FXML
    private TextField emailField;
    
    private UserVO userVO = null;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeModifyUserInfo(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
    }

    @FXML
    void finishModifyUserInfo(MouseEvent event) {
    	messageLabel.setText("");
    	String userName = nameField.getText().trim();
    	String nickName = nickNameField.getText().trim();
    	System.out.println(nickName);
    	String email = emailField.getText().trim();
    	System.out.println(userVO.userID);
    	System.out.println(userVO.password);
    	if(userName.equals("")||nickName.equals("")||email.equals("")){
    		messageLabel.setText("您有尚未填写的信息");
    	}else {
    		userVO.nickName = nickName;
    		userVO.name = userName;
    		userVO.eMail = email;
			ResultMessage resultMessage = WebManagerInfoUtil.getInstance().updateUser(userVO);
			if(resultMessage==ResultMessage.succeed){
				AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
		    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
		    	ManageUserUIController manageUserUIController = WebManagerUIFXMLFactory.getInstance().getManageUserUIController();
		    	manageUserUIController.init();
			}
		}
    }
    
    public void init(UserVO userVO){
    	this.userVO = userVO;
    	nameField.setText(userVO.name);
    	userCreditLabel.setText(String.valueOf(userVO.credit));
    	nickNameField.setText(userVO.nickName);
    	phoneLabel.setText(userVO.userID);
    	if(userVO.memberType==null){
    		memberTypeLabel.setText("非会员");
    	}else {
    		memberTypeLabel.setText(userVO.memberType.getString());
    		memberLevelLabel.setText(String.valueOf(userVO.level));
		}
    	if(userVO.sexuality==Sexuality.female){
    		sexImage.setImage(ImageFactory.getImageFactory().getFemale());
    	}else {
			sexImage.setImage(ImageFactory.getImageFactory().getMale());
		}
    	emailField.setText(userVO.eMail);
    }

    @FXML
    void initialize() {
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert sexImage != null : "fx:id=\"sexImage\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert memberTypeLabel != null : "fx:id=\"memberTypeLabel\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert userCreditLabel != null : "fx:id=\"userCreditLabel\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert memberLevelLabel != null : "fx:id=\"memberLevelLabel\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert finishModifyButton != null : "fx:id=\"finishModifyButton\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert nickNameField != null : "fx:id=\"nickNameField\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert phoneLabel != null : "fx:id=\"phoneLabel\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
        assert emailField != null : "fx:id=\"emailField\" was not injected: check your FXML file '网管_修改用户信息.fxml'.";
    }
}
