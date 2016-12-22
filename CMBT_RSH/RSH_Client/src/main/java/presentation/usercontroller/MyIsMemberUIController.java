package presentation.usercontroller;

/**
 * Created by john on 2016/12/8.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import presentation.tools.ImageFactory;
import presentation.usercontrollertools.UserInfoUtil;
import vo.UserVO;

public class MyIsMemberUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label membertypeLabel;

    @FXML
    private Label memberLevelLabel;
    
    @FXML
    private ImageView userHeadImage;

    
    public void init() {
        UserVO userVO = UserInfoUtil.getInstance().getUserVO();
        membertypeLabel.setText(userVO.memberType.getString());
        memberLevelLabel.setText(String.valueOf(userVO.level));
        userHeadImage.setImage(ImageFactory.getImageFactory().getHeadImage(userVO.userID));
	}

    @FXML
    void initialize() {
        assert membertypeLabel != null : "fx:id=\"membertypeLabel\" was not injected: check your FXML file '我的会员（是会员）.fxml'.";
        assert memberLevelLabel != null : "fx:id=\"memberLevelLabel\" was not injected: check your FXML file '我的会员（是会员）.fxml'.";
        assert userHeadImage != null : "fx:id=\"userHeadImage\" was not injected: check your FXML file '我的会员（是会员）.fxml'.";
        init();
    }
}

