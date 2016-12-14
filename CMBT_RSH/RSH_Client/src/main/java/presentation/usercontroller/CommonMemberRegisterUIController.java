package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;

public class CommonMemberRegisterUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView headImage;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private Button finifshRegisterButton;

    @FXML
    private ImageView cancelImage;
    
    @FXML
    private Label birthdayMessageLabel;


    @FXML
    void changeCancelImageToGray(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    //直接关闭，跳转到我的会员，不是会员界面
    @FXML
    void closeRegisterCommonMember(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeMemberRegisterToMyMember();
    }

    //跳转到我的会员，是会员界面
    @FXML
    void finishRegisterButtonClicked(MouseEvent event) {
    	//检测生日输入是否一致
    	LocalDate birth = birthdayPicker.getValue();
    	if(!birth.equals(UserInfoUtil.getInstance().getUserVO().birthday)){
    		birthdayMessageLabel.setText("您的生日与注册信息时不一致");
    	}else{
    		ResultMessage resultMessage = UserInfoUtil.getInstance().registerCommonMember();
        	if(resultMessage==ResultMessage.succeed){
        		UIJumpTool.getUiJumpTool().changeMemberRegisterToMember();
        	}
    	}
        
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert birthdayPicker != null : "fx:id=\"birthdayPicker\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert finifshRegisterButton != null : "fx:id=\"finifshRegisterButton\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert birthdayMessageLabel != null : "fx:id=\"birthdayMessageLabel\" was not injected: check your FXML file '普通会员注册.fxml'.";

    }
}

