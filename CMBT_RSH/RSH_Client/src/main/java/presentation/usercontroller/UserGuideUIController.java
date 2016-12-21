package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import presentation.usercontrollertools.UIJumpTool;

public class UserGuideUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label userInfoLabelBelow;

    @FXML
    private Label myMemberLabelbelow;

    @FXML
    private Label userOrderLabelBelow;

    @FXML
    private Label userCreditRecordLabelBelow;

    @FXML
    private Label userInfoLabel;

    @FXML
    private Label myMemberLabel;

    @FXML
    private Label userOrderLabel;

    @FXML
    private Label userCreditRecordLabel;

    private void setGuideProperty(Label label,Label labelBelow){
        myMemberLabelbelow.setVisible(false);
        userInfoLabelBelow.setVisible(false);
        userOrderLabelBelow.setVisible(false);
        userCreditRecordLabelBelow.setVisible(false);
        userInfoLabel.setTextFill(Color.valueOf("#bbbbbb"));
        userOrderLabel.setTextFill(Color.valueOf("#bbbbbb"));
        userCreditRecordLabel.setTextFill(Color.valueOf("#bbbbbb"));
        myMemberLabel.setTextFill(Color.valueOf("#bbbbbb"));

        label.setTextFill(Color.valueOf("#ffffff"));
        labelBelow.setVisible(true);
    }

    @FXML
    void myMemberLabelClicked(MouseEvent event) {
       setGuideProperty(myMemberLabel,myMemberLabelbelow);
        UIJumpTool.getUiJumpTool().changeToMyMember();
    }

    @FXML
    void myMemberLabelEntered(MouseEvent event) {
        myMemberLabel.setTextFill(Color.valueOf("#ffffff"));
    }

    @FXML
    void myMemberLabelExited(MouseEvent event) {
        if(!myMemberLabelbelow.isVisible()){
            myMemberLabel.setTextFill(Color.valueOf("#bbbbbb"));
        }
    }

    @FXML
    void userCreditRecordLabelClicked(MouseEvent event) {
        setGuideProperty(userCreditRecordLabel,userCreditRecordLabelBelow);
        UIJumpTool.getUiJumpTool().changeToUserCreditRecord();
    }

    @FXML
    void userCreditRecordLabelEntered(MouseEvent event) {
        userCreditRecordLabel.setTextFill(Color.valueOf("#ffffff"));
    }

    @FXML
    void userCreditRecordLabelExited(MouseEvent event) {
        if(!userCreditRecordLabelBelow.isVisible()){
            userCreditRecordLabel.setTextFill(Color.valueOf("#bbbbbb"));
        }
    }

    @FXML
    void userInfoLabelClicked(MouseEvent event) {
        setGuideProperty(userInfoLabel,userInfoLabelBelow);
        UIJumpTool.getUiJumpTool().changeToUserInfo();
    }

    @FXML
    void userInfoLabelEntered(MouseEvent event) {
        userInfoLabel.setTextFill(Color.valueOf("#ffffff"));
    }

    @FXML
    void userInfoLabelExited(MouseEvent event) {
        if(!userInfoLabelBelow.isVisible()){
            userInfoLabel.setTextFill(Color.valueOf("#bbbbbb"));
        }
    }

    @FXML
    void userOrderLabelClicked(MouseEvent event) {
        setGuideProperty(userOrderLabel,userOrderLabelBelow);
        UIJumpTool.getUiJumpTool().changeToUserOrder();
    }

    @FXML
    void userOrderLabelEntered(MouseEvent event) {
        userOrderLabel.setTextFill(Color.valueOf("#ffffff"));
    }

    @FXML
    void userOrderLabelExited(MouseEvent event) {
        if(!userOrderLabelBelow.isVisible()){
            userOrderLabel.setTextFill(Color.valueOf("#bbbbbb"));
        }
    }

    @FXML
    void initialize() {
        assert userInfoLabelBelow != null : "fx:id=\"userInfoLabelBelow\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert myMemberLabelbelow != null : "fx:id=\"myMemberLabelbelow\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert userOrderLabelBelow != null : "fx:id=\"userOrderLabelBelow\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert userCreditRecordLabelBelow != null : "fx:id=\"userCreditRecordLabelBelow\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert userInfoLabel != null : "fx:id=\"userInfoLabel\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert myMemberLabel != null : "fx:id=\"myMemberLabel\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert userOrderLabel != null : "fx:id=\"userOrderLabel\" was not injected: check your FXML file '用户导航栏.fxml'.";
        assert userCreditRecordLabel != null : "fx:id=\"userCreditRecordLabel\" was not injected: check your FXML file '用户导航栏.fxml'.";

    }
}
