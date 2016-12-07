package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;

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
    void changeCancelImageToGray(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeRegisterCommonMember(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeMemberRegisterToMyMember();
    }

    @FXML
    void finishRegisterButtonClicked(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeMemberRegisterToMember();
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert birthdayPicker != null : "fx:id=\"birthdayPicker\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert finifshRegisterButton != null : "fx:id=\"finifshRegisterButton\" was not injected: check your FXML file '普通会员注册.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '普通会员注册.fxml'.";

    }
}

