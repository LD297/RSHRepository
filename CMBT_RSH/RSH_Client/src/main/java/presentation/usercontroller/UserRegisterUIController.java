package presentation.usercontroller;

/**
 * Created by john on 2016/12/4.
 */

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.logincontroller.LoginUIController;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import presentation.usercontrollertools.UserInputFormCheckTool;
import vo.UserVO;

public class UserRegisterUIController {

	   @FXML
	    private ResourceBundle resources;

	    @FXML
	    private URL location;

	    @FXML
	    private TextField nicknameField;

	    @FXML
	    private TextField nameField;

	    @FXML
	    private TextField phoneNumButton;

	    @FXML
	    private DatePicker dataPicker;

	    @FXML
	    private Button finishRegisterButton;

	    @FXML
	    private TextField emailButton;

	    @FXML
	    private PasswordField passwordField;

	    @FXML
	    private PasswordField confirmPasswordField;

	    @FXML
	    private ChoiceBox<String> sexChoicebox;

	    @FXML
	    private Label nameWarning;

	    @FXML
	    private Label sexWarning;

	    @FXML
	    private Label phoneWarning;

	    @FXML
	    private Label emailWarning;

	    @FXML
	    private Label passwordWarning;

	    @FXML
	    private Label confirmPasswordWarning;

	    @FXML
	    private Label birthdayWarning;

	    @FXML
	    private Label nickNameWarning;

	    @FXML
	    private ImageView returnImage;

    //点击返回箭头，舍弃一切注册的内容，直接返回
    @FXML
    void backToLogin(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeRegisterToLogin();
    }

    //点击完成注册，将该用户注册的内容存到数据库，并且返回到登陆界面，set登陆界面的用户名和密码
    @FXML
    void finishRegister(MouseEvent event) {
    	//将所有提示的label清空
    	nickNameWarning.setText("");
    	nameWarning.setText("");
    	passwordWarning.setText("");
    	phoneWarning.setText("");
    	confirmPasswordWarning.setText("");
    	sexWarning.setText("");
    	birthdayWarning.setText("");
    	emailWarning.setText("");
//    	ArrayList<String> wrongMessages = new ArrayList<String>();
    	boolean rightInput = true;
        //检查昵称格式
        String nickName = nicknameField.getText().trim();
        String nickNameResult = UserInputFormCheckTool.getInstance().checkNickName(nickName);
        if(!nickNameResult.equals("success")){
        	rightInput = false;
        	nickNameWarning.setText(nickNameResult);
//            wrongMessages.add(nickNameResult);
        }
        //检查姓名是否为空
        String name = nameField.getText().trim();
        if(name.equals("")){
        	rightInput = false;
        	nameWarning.setText("姓名不能为空");
//        	wrongMessages.add("姓名不能为空");
        }
        //检查用户账号格式
        String phoneNum = phoneNumButton.getText().trim();
        String phonenumResult = UserInputFormCheckTool.getInstance().checkUserID(phoneNum);
        if(!phonenumResult.equals("success")){
        	rightInput = false;
        	phoneWarning.setText(phonenumResult);
 //           wrongMessages.add(phonenumResult);
        }
        //检查邮件地址格式
        String email = emailButton.getText().trim();
        String emailResult = UserInputFormCheckTool.getInstance().checkEmail(email);
        if(!emailResult.equals("success")){
        	rightInput = false;
        	emailWarning.setText(emailResult);
//            wrongMessages.add(emailResult);
        }
        //检查密码格式
        String password = passwordField.getText().trim();
        String passwordResult = UserInputFormCheckTool.getInstance().checkUserPassword(password);
    	if(!passwordResult.equals("success")){
    		rightInput = false;
    		passwordWarning.setText(passwordResult);
//    		wrongMessages.add(passwordResult);
    	}else{//检查两次输入的密码是否一致
    		String confirmPassword = confirmPasswordField.getText().trim();
    		if(!confirmPassword.equals(password)){
    			rightInput = false;
    			passwordWarning.setText("两次密码不一致");
//    			wrongMessages.add("两次密码不一致");
    		}
    	}
    	if(sexChoicebox.getValue()==null){
    		rightInput = false;
    		sexWarning.setText("请选择性别");
    	}
    	if(dataPicker.getValue()==null){
    		rightInput = false;
    		birthdayWarning.setText("请选择生日");
    	}
    	if(rightInput){
    		LocalDate birth = dataPicker.getValue();
    		Sexuality sexuality = Sexuality.getSexuality(sexChoicebox.getValue());     
    		//TODO 获取头像地址
    		String imageAddress = null;
    		UserVO userVO = new UserVO(phoneNum, password, nickName, imageAddress, birth, 0, MemberType.commom, name, sexuality, email, 0,null);
    		 //将该用户注册的内容存到数据库
        	ResultMessage resultMessage = UserInfoUtil.getInstance().register(userVO);
        	if(resultMessage!=ResultMessage.succeed){
        		phoneWarning.setText("该手机号已被注册");
        	}else{//如果注册成功
        		//返回到登陆界面
                LoginUIController loginUIController = UIJumpTool.getUiJumpTool().changeRegisterToLogin();
                //set登陆界面的用户名和密码
                loginUIController.setIdAndPassword(phoneNum, password);
        	}
    	}
       
    }

    @FXML
    void initialize() {
    	 assert nicknameField != null : "fx:id=\"nicknameField\" was not injected: check your FXML file '用户注册.fxml'.";
         assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file '用户注册.fxml'.";
         assert phoneNumButton != null : "fx:id=\"phoneNumButton\" was not injected: check your FXML file '用户注册.fxml'.";
         assert dataPicker != null : "fx:id=\"dataPicker\" was not injected: check your FXML file '用户注册.fxml'.";
         assert finishRegisterButton != null : "fx:id=\"finishRegisterButton\" was not injected: check your FXML file '用户注册.fxml'.";
         assert emailButton != null : "fx:id=\"emailButton\" was not injected: check your FXML file '用户注册.fxml'.";
         assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '用户注册.fxml'.";
         assert confirmPasswordField != null : "fx:id=\"confirmPasswordField\" was not injected: check your FXML file '用户注册.fxml'.";
         assert sexChoicebox != null : "fx:id=\"sexChoicebox\" was not injected: check your FXML file '用户注册.fxml'.";
         assert nameWarning != null : "fx:id=\"nameWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert sexWarning != null : "fx:id=\"sexWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert phoneWarning != null : "fx:id=\"phoneWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert emailWarning != null : "fx:id=\"emailWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert passwordWarning != null : "fx:id=\"passwordWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert confirmPasswordWarning != null : "fx:id=\"confirmPasswordWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert birthdayWarning != null : "fx:id=\"birthdayWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert nickNameWarning != null : "fx:id=\"nickNameWarning\" was not injected: check your FXML file '用户注册.fxml'.";
         assert returnImage != null : "fx:id=\"returnImage\" was not injected: check your FXML file '用户注册.fxml'.";

        ObservableList<String> sexualities = FXCollections.observableArrayList((new ArrayList<String>(
  				Arrays.asList(new String[] { Sexuality.male.getString(), Sexuality.female.getString() }))));
  		sexChoicebox.setItems(sexualities);
    
    }
}

