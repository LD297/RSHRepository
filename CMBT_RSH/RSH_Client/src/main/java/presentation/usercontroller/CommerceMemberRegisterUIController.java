package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;

public class CommerceMemberRegisterUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button finishRegisterButton;

    @FXML
    private TextField commerceNameField;

    @FXML
    private ImageView cancelImage;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    //直接关闭注册企业会员界面
    @FXML
    void closeCommerceMemberRegister(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeMemberRegisterToMyMember();
    }

    
    @FXML
    void finishRegisterButtonClicked(MouseEvent event) {
    	String commerceName = commerceNameField.getText().trim();
    	if(UserInfoUtil.getInstance().registerCommerceMember(commerceName)==ResultMessage.succeed){
    		 UIJumpTool.getUiJumpTool().changeMemberRegisterToMember();
    	}
    }

    @FXML
    void initialize() {
        assert finishRegisterButton != null : "fx:id=\"finishRegisterButton\" was not injected: check your FXML file '企业会员注册.fxml'.";
        assert commerceNameField != null : "fx:id=\"commerceNameField\" was not injected: check your FXML file '企业会员注册.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '企业会员注册.fxml'.";

    }
}

