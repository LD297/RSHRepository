package presentation.usercontroller;

/**
 * Created by john on 2016/12/4.
 */

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import constant.MemberType;
import constant.ResultMessage;
import constant.Sexuality;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.logincontroller.LoginUIController;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInputFormCheckTool;
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
    private DatePicker dataPicker;//当时太困了，所以就把生日的日期选择器去了个这么个名字

    @FXML
    private Button finishRegisterButton;

    @FXML
    private TextField emailButton;//命名问题

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField confirmPasswordField;

    @FXML
    private ImageView returnImage;
    
    @FXML
    private ChoiceBox<?> sexChoicebox;

    //点击返回箭头，舍弃一切注册的内容，直接返回
    @FXML
    void backToLogin(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeRegisterToLogin();
    }

    //点击完成注册，将该用户注册的内容存到数据库，并且返回到登陆界面，set登陆界面的用户名和密码
    @FXML
    void finishRegister(MouseEvent event) {
    	ArrayList<String> wrongMessages = new ArrayList<String>();
        //检查昵称格式
        String nickName = nicknameField.getText().trim();
        String nickNameResult = UserInputFormCheckTool.getInstance().checkNickName(nickName);
        if(!nickNameResult.equals("success")){
            wrongMessages.add(nickNameResult);
        }
        //检查姓名是否为空
        String name = nameField.getText().trim();
        if(name.equals("")){
        	wrongMessages.add("姓名不能为空");
        }
        //检查用户账号格式
        //TODO 直接提供一个判断该用户是否已存在的方法，在逻辑层加
        String phoneNum = phoneNumButton.getText().trim();
        String phonenumResult = UserInputFormCheckTool.getInstance().checkUserID(phoneNum);
        if(!phonenumResult.equals("success")){
            wrongMessages.add(phonenumResult);
        }
        //检查邮件地址格式
        String email = emailButton.getText().trim();
        String emailResult = UserInputFormCheckTool.getInstance().checkEmail(email);
        if(!emailResult.equals("success")){
            wrongMessages.add(emailResult);
        }
        //检查密码格式
        String password = passwordField.getText().trim();
        String passwordResult = UserInputFormCheckTool.getInstance().checkUserPassword(password);
    	if(!passwordResult.equals("success")){
    		wrongMessages.add(passwordResult);
    	}else{//检查两次输入的密码是否一致
    		String confirmPassword = confirmPasswordField.getText().trim();
    		if(!confirmPassword.equals(password)){
    			wrongMessages.add("两次密码不一致");
    		}
    	}
    	if(wrongMessages.isEmpty()){
    		LocalDate birth = dataPicker.getValue();
    		//TDDO 获取用户性别
    		Sexuality sexuality = Sexuality.male;
    		//TODO 获取头像地址
    		String imageAddress = null;
    		UserVO userVO = new UserVO(phoneNum, password, nickName, imageAddress, birth, 0, MemberType.commom, name, sexuality, email, 0);
    		 //将该用户注册的内容存到数据库
        	LoginService loginService = new LoginController();
        	ResultMessage resultMessage = loginService.register(userVO);
        	if(resultMessage!=ResultMessage.succeed){
        		//TODO 完善resultmessage中的失败类型
        		wrongMessages.add("该用户已存在");
        	}else{
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
        assert returnImage != null : "fx:id=\"returnImage\" was not injected: check your FXML file '用户注册.fxml'.";
        assert sexChoicebox != null : "fx:id=\"sexChoicebox\" was not injected: check your FXML file '用户注册.fxml'.";
    }
}

