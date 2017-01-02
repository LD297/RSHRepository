package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
/**
 * 提示用户注册企业会员或普通会员
 * @author john
 *
 */
public class MyIsnotMemberUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView userHeadImage;

    @FXML
    private Button registerCommonMemberButton;

    @FXML
    private Button registerCommerceMemberButton;

    @FXML
    void registerCommerceMember(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToCommerceMemberRegister();
    }

    @FXML
    void registerCommonMember(MouseEvent event) {
            UIJumpTool.getUiJumpTool().changeToCommonMemberRegister();
    }

    @FXML
    void initialize() {
        assert userHeadImage != null : "fx:id=\"userHeadImage\" was not injected: check your FXML file '我的会员（不是会员）.fxml'.";
        assert registerCommonMemberButton != null : "fx:id=\"registerCommonMemberButton\" was not injected: check your FXML file '我的会员（不是会员）.fxml'.";
        assert registerCommerceMemberButton != null : "fx:id=\"registerCommerceMemberButton\" was not injected: check your FXML file '我的会员（不是会员）.fxml'.";
        userHeadImage.setImage(ImageFactory.getImageFactory().getHeadImage(UserInfoUtil.getInstance().getUserID()));
    }
}
