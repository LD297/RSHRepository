package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import constant.Sexuality;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.MyDateFormat;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.UserVO;

public class UserInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView headImage;

    @FXML
    private Button changeHeadimageButton;

    @FXML
    private Label modifyInfoLabel;

    @FXML
    private Label nicknameLabel;

    @FXML
    private ImageView modifyInfoImage;

    @FXML
    private Label userNameLabel;

    @FXML
    private Label birthdayLabel;

    @FXML
    private Label phonenumberLabel;

    @FXML
    private Label emailaddressLabel;
    @FXML
    private ImageView sexImage;

    //TODO 更换头像
    @FXML
    void changeHeadImage(MouseEvent event) {

    }

    //跳转到编辑用户信息界面
    @FXML
    void changeToModifyUserInfo(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToModifyUserInfo();
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '我的信息.fxml'.";
        assert changeHeadimageButton != null : "fx:id=\"changeHeadimageButton\" was not injected: check your FXML file '我的信息.fxml'.";
        assert modifyInfoLabel != null : "fx:id=\"modifyInfoLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert nicknameLabel != null : "fx:id=\"nicknameLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert modifyInfoImage != null : "fx:id=\"modifyInfoImage\" was not injected: check your FXML file '我的信息.fxml'.";
        assert userNameLabel != null : "fx:id=\"userNameLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert birthdayLabel != null : "fx:id=\"birthdayLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert phonenumberLabel != null : "fx:id=\"phonenumberLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert emailaddressLabel != null : "fx:id=\"emailaddressLabel\" was not injected: check your FXML file '我的信息.fxml'.";
        assert sexImage != null : "fx:id=\"sexImage\" was not injected: check your FXML file '我的信息.fxml'.";
        
        UserVO userVO = UserInfoUtil.getInstance().getUserVO();
        nicknameLabel.setText(userVO.nickName);
        userNameLabel.setText(userVO.name);
        birthdayLabel.setText(MyDateFormat.getInstance().toString(userVO.birthday));
        phonenumberLabel.setText(userVO.id);
        emailaddressLabel.setText(userVO.eMail);
        if(userVO.sexuality==Sexuality.female){
        	sexImage.setImage(ImageFactory.getImageFactory().getFemale());
        }else {
			sexImage.setImage(ImageFactory.getImageFactory().getMale());
		}
    }
}

