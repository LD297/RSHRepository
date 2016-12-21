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
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
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
    private Button modifyUserInfoButton;
    
    @FXML
    private Label emailLabel;

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
    void changeToModifyUserInfo(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	AnchorPane modifyUser = WebManagerUIFXMLFactory.getInstance().getModifyUserInfo();
    	ModifyUserInfoUIController modifyUserInfoUIController = WebManagerUIFXMLFactory.getInstance().getModifyUserInfoUIController();
    	modifyUserInfoUIController.init(userVO);
    	//先删除查看用户信息界面
    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
    	//添加修改用户信息界面
    	manageUser.getChildren().add(modifyUser);
    }


    @FXML
    void closeCheckUserInfo(MouseEvent event) {
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	manageUser.getChildren().remove(manageUser.getChildren().size()-1);
    }
    
    public void init(UserVO userVO) {
    	this.userVO = userVO;
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
    	emailLabel.setText(userVO.eMail);
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
        assert emailLabel != null : "fx:id=\"emailLabel\" was not injected: check your FXML file '网管_查看用户信息.fxml'.";
    }
}
