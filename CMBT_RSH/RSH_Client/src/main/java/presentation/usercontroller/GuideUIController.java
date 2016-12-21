package presentation.usercontroller;

/**
 * Created by john on 2016/12/5.
 */

import java.net.URL;
import java.util.ResourceBundle;
import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import vo.UserVO;

public class GuideUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView backImage;

    @FXML
    private Label logoutLabel;

    @FXML
    private ImageView headImage;

    @FXML
    private ImageView headMaskImage;
  
   
    //点击退出label跳转到登陆界面
    @FXML
    void changeToLogin(MouseEvent event) {
    	//删除在线人员持久化对象
    	if(UserInfoUtil.getInstance().logout()==ResultMessage.succeed){
    		UIJumpTool.getUiJumpTool().changeGuideToLogin();
    	}
    }

  
    //点击头像跳转到用户个人信息界面
    @FXML
    void changeToUserInfo(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToUserGuide();
    }

    //点击返回箭头
    @FXML
    void back(MouseEvent event) {
        UIJumpTool.getUiJumpTool().back();
    }

    public void setBackImage(boolean visible){backImage.setVisible(visible);}

    public void setHeadImage(String url) {
    	Image image = new Image(url,100,100,false,true);
		headImage.setImage(image);
	}
	public void init() {
		UserVO userVO = UserInfoUtil.getInstance().getUserVO();
		Image image = new Image(userVO.imageAddress,100,100,false,true);
		headImage.setImage(image);
	}
    @FXML
    void initialize() {
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '导航栏.fxml'.";
        assert logoutLabel != null : "fx:id=\"logoutLabel\" was not injected: check your FXML file '导航栏.fxml'.";
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '导航栏.fxml'.";
        assert headMaskImage != null : "fx:id=\"headMaskImage\" was not injected: check your FXML file '导航栏.fxml'.";
        init();
    }
}

