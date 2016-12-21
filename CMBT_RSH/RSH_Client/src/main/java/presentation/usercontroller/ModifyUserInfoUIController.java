package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import constant.Sexuality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import presentation.usercontrollertools.UserInputFormCheckTool;
import vo.UserVO;

public class ModifyUserInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nicknameField;


    @FXML
    private ChoiceBox<String> sexChoiceBox;

    @FXML
    private DatePicker birthdayPicker;

    @FXML
    private Button confirmButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField phonenumberField;

    @FXML
    private TextField emailaddressField;

    @FXML
    private ImageView modifypasswordImage;

    @FXML
    private Label modifypasswordLabel;


    @FXML
    private Label emailMeaasgeLabel;

    @FXML
    private Label nickNameMeassgeLabel;


    @FXML
    private Label phoneNumMeassgeLabel;


    @FXML
    void cancelButtonClicked(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToUserInfo();
    }

    @FXML
    void changeToModifyPassword(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToModifyPassword();
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {
    	System.out.println("ok");
        boolean rightInput = true;
        //检查昵称格式
        String nickName = nicknameField.getText().trim();
        String nickNameResult = UserInputFormCheckTool.getInstance().checkNickName(nickName);
        if(!nickNameResult.equals("success")){
            rightInput = false;
            nickNameMeassgeLabel.setText(nickNameResult);
        }else {
            nickNameMeassgeLabel.setText("");
        }
        //检查邮件地址格式
        String email = emailaddressField.getText().trim();
        String emailResult = UserInputFormCheckTool.getInstance().checkEmail(email);
        if(!emailResult.equals("success")){
        	System.out.println("jhfkf");
            rightInput = false;
            emailMeaasgeLabel.setText(emailResult);
        }else {
            emailMeaasgeLabel.setText("");
        }
        //检查用户账号格式
        String phoneNum = phonenumberField.getText().trim();
        String phonenumResult = UserInputFormCheckTool.getInstance().checkUserID(phoneNum);
        if(!phonenumResult.equals("success")){
            rightInput = false;
            phoneNumMeassgeLabel.setText(phonenumResult);
        }else {
        	phoneNumMeassgeLabel.setText("");
        }
        if(rightInput){
        	String name = nameField.getText().trim();
        	Sexuality sexuality = Sexuality.getSexuality(sexChoiceBox.getValue());
        	LocalDate birthday = birthdayPicker.getValue();
            //更新用户信息
        	UserInfoUtil.getInstance().modifyUserInfo(nickName, name, sexuality, birthday, phoneNum, email);
            //跳转到用户信息界面
            UIJumpTool.getUiJumpTool().changeToUserInfo();
        }
    }
    
    public void init(){
    	  UserVO userVO = UserInfoUtil.getInstance().getUserVO();
          nicknameField.setText(userVO.nickName);
          nameField.setText(userVO.name);
          phonenumberField.setText(userVO.id);
          emailaddressField.setText(userVO.eMail);
          birthdayPicker.setValue(userVO.birthday);
  		ObservableList<String> sexualities = FXCollections.observableArrayList((new ArrayList<String>(
  				Arrays.asList(new String[] { Sexuality.male.getString(), Sexuality.female.getString() }))));
  		sexChoiceBox.setItems(sexualities);
  		sexChoiceBox.setValue(userVO.sexuality.getString());
  		phonenumberField.setEditable(false);
    }

    @FXML
    void initialize() {
        assert nicknameField != null : "fx:id=\"nicknameField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert birthdayPicker != null : "fx:id=\"birthdayPicker\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert phonenumberField != null : "fx:id=\"phonenumberField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert emailaddressField != null : "fx:id=\"emailaddressField\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert modifypasswordImage != null : "fx:id=\"modifypasswordImage\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert modifypasswordLabel != null : "fx:id=\"modifypasswordLabel\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert emailMeaasgeLabel != null : "fx:id=\"emailMeaasgeLabel\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert phoneNumMeassgeLabel != null : "fx:id=\"phoneNumMeassgeLabel\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert nickNameMeassgeLabel != null : "fx:id=\"nickNameMeassgeLabel\" was not injected: check your FXML file '用户个人资料.fxml'.";
        assert sexChoiceBox != null : "fx:id=\"sexChoiceBox\" was not injected: check your FXML file '用户个人资料.fxml'.";
        init();
      
    }
}

