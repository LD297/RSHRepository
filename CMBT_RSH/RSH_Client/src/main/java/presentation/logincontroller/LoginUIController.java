package presentation.logincontroller;

/**
 * Created by john on 2016/12/4.
 */
import java.net.URL;
import java.util.ResourceBundle;

import bl.loginservice.LoginService;
import constant.ResultMessage;
import constant.Role;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import presentation.hotelcontroller.HotelHomepageUIController;
import presentation.hotelcontrollertools.HotelServiceFactory;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import presentation.tools.*;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import presentation.usercontrollertools.UserInputFormCheckTool;
import presentation.webmanagercontrollertools.WebManagerInfoUtil;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
import presentation.websalesmancontroller.WebSalesmanHomepageUIController;
import presentation.websalesmancontrollertools.WebSalesmanUIFXMLFactory;

/**
 * 登陆界面，其中如果是用户，可以选择注册
 * @author john
 *
 */
public class LoginUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView headImage;

    @FXML
    private TextField idField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ImageView showMoreImage;

    @FXML
    private ImageView cancelImage;

    @FXML
    private AnchorPane loginBelowAnchorpane;

    @FXML
    private Label registerLabel;

    @FXML
    private Label idFormLabel;

    @FXML
    private Label passwordFormLabel;

    private Role role;

    //image
    private Image showImage = ImageFactory.getImageFactory().getShowImage();
    private Image hideImage = ImageFactory.getImageFactory().getHideImage();
    private Image cancel_gray = ImageFactory.getImageFactory().getCancel_gray();
    private Image cancel_red = ImageFactory.getImageFactory().getCancel_red();

    private boolean show = true;//true表示当前是下拉箭头

    //用户完成注册之后登陆界面上的用户名和密码就给他填好了
    public void setIdAndPassword(String id,String password){
    	idField.setText(id);
    	passwordField.setText(password);
    }
    
    
    //点击注册跳转到注册界面
    @FXML
    void changeToRegister(MouseEvent event) {
        //关闭登陆下拉界面
        loginBelowAnchorpane.setVisible(false);
        //将登陆界面的收回箭头改为下拉箭头
        show = true;
        showMoreImage.setImage(ImageFactory.getImageFactory().getShowImage());
        //跳转
        UIJumpTool.getUiJumpTool().setStage((Stage)idField.getScene().getWindow());
        UIJumpTool.getUiJumpTool().changeLoginToRegister();
    }

    //输入用户名和密码之后敲击回车完成登陆，跳转到相应的客户端的主界面
    @FXML
    void finishInput(ActionEvent event) {
        String id = idField.getText();
        String password = passwordField.getText();
        ResultMessage resultMessage = null;
        //如果用户的身份是用户
        if(role == Role.user){
        	UIJumpTool.getUiJumpTool().setStage((Stage)idField.getScene().getWindow());
        	//检查用户名
            String idResult = UserInputFormCheckTool.getInstance().checkUserID(id);
            if(idResult!="success"){
                idFormLabel.setText(idResult);
            }else {
                idFormLabel.setText("");
            }
            //检查密码
            String passwordResult = UserInputFormCheckTool.getInstance().checkUserPassword(password);
            if(passwordResult!="success"){
                passwordFormLabel.setText(passwordResult);
            }else {
                passwordFormLabel.setText("");
            }
            //如果用户名和密码都输入正确
            if(idResult=="success"&&passwordResult=="success"){
            	resultMessage = UserInfoUtil.getInstance().login(id, password);
                if(resultMessage==ResultMessage.succeed){
                	idFormLabel.setText("");
                	passwordFormLabel.setText("");
                    if(loginBelowAnchorpane.isVisible()){//先判断有没有登陆下拉界面,有就删除
                        loginBelowAnchorpane.setVisible(false);
                    }
                    //关闭窗口退出
					Stage stage = (Stage) idField.getScene().getWindow();
					stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
						@Override
						public void handle(WindowEvent event) {
							UserInfoUtil.getInstance().logout();
						}
					});
					 //跳转到搜索酒店界面
                    UIJumpTool.getUiJumpTool().changeLoginToSearchHotel();
                }
            }
        }else if (role==Role.webmanager) {
        	resultMessage = WebManagerInfoUtil.getInstance().checkOnLine(id, password);
			if(resultMessage==ResultMessage.succeed){
				idFormLabel.setText("");
            	passwordFormLabel.setText("");
				WebManagerInfoUtil.getInstance().login(id, password);
				passwordFormLabel.setText("");
				Stage stage = (Stage)idField.getScene().getWindow();
				//关闭窗口退出
				stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						WebManagerInfoUtil.getInstance().logout();
					}
				});
				Scene scene = null;
				AnchorPane webmanagerHomepage = WebManagerUIFXMLFactory.getInstance().getManageHomepage();
				if(webmanagerHomepage.getScene()!=null){
					scene = webmanagerHomepage.getScene();
				}else {
					scene = new Scene(webmanagerHomepage,800,720);
				}
				stage.setScene(scene);
			}
		} else if(role==Role.hotel){
            // 得到登陆服务
            LoginService loginService = HotelServiceFactory.getInstance().getLoginService();
            
            resultMessage = loginService.checkOnline(Role.hotel, id, password);
            if(resultMessage.equals(ResultMessage.succeed)){
            	idFormLabel.setText("");
            	passwordFormLabel.setText("");
                // 酒店首页根结点
                AnchorPane hotelHomepage = HotelUIFXMLFactory.getInstance().getHotelHomePageUIPane();
                // 酒店首页控制器
                HotelHomepageUIController hotelHomepageUIController = HotelUIFXMLFactory.getInstance().
                        getHotelHomepageUIController();

                hotelHomepageUIController.setPrePane(loginBelowAnchorpane);
                hotelHomepageUIController.setHotelId(id);

                Stage stage = (Stage)idField.getScene().getWindow();
              //关闭窗口退出
				stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						loginService.logout(Role.hotel, id);
					}
				});
                Scene scene = null;
                if(hotelHomepage.getScene()==null)
                    scene = new Scene(hotelHomepage, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
                else
                    scene = hotelHomepage.getScene();
                stage.setScene(scene);
            } 

        } else if(role.equals(Role.websalesman)){
            // 得到登陆服务
            LoginService loginService = HotelServiceFactory.getInstance().getLoginService();
            
            resultMessage = loginService.checkOnline(Role.websalesman, id, password );
            if(resultMessage.equals(ResultMessage.succeed)){
            	idFormLabel.setText("");
            	passwordFormLabel.setText("");
                // 网站营销人员首页根结点
                AnchorPane webSalesmanHomepage = WebSalesmanUIFXMLFactory.getInstance().getWebSalesmanHomepageUIPane();
                // 网站营销人员首页控制器
                WebSalesmanHomepageUIController webSalesmanHomepageUIController = WebSalesmanUIFXMLFactory.
                        getInstance().getWebSalesmanHomepageUIController();

                webSalesmanHomepageUIController.setWebSalesmanId(id);
                webSalesmanHomepageUIController.setWebSalesmanVO();
                webSalesmanHomepageUIController.setPrePane(loginBelowAnchorpane);

                Stage stage = (Stage)idField.getScene().getWindow();
              //关闭窗口退出
				stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
					@Override
					public void handle(WindowEvent event) {
						loginService.logout(Role.websalesman, id);
					}
				});
                Scene scene = null;
                if(webSalesmanHomepage.getScene()==null)
                    scene = new Scene(webSalesmanHomepage, WebSalesmanUIFXMLFactory.UI_WIDTH, WebSalesmanUIFXMLFactory.UI_HEIGHT);
                else
                    scene = webSalesmanHomepage.getScene();
                stage.setScene(scene);
            } 
        }
        if(resultMessage==ResultMessage.idNotExist){
    		idFormLabel.setText("该用户名不存在");
    	}else if (resultMessage==ResultMessage.password_wrong) {
			passwordFormLabel.setText("密码错误");
		}else if (resultMessage==ResultMessage.idAlreadyExist) {
			idFormLabel.setText("不能重复登陆");
		}
      
    }

    //展开或收起登陆下拉界面
    @FXML
    void hideOrShow(MouseEvent event) {
        if(show){//如果当前是下拉箭头
            showMoreImage.setImage(hideImage);//将箭头改为收起箭头
            show = false;
            loginBelowAnchorpane.setVisible(true);
        }else {//如果当前是收起箭头
            showMoreImage.setImage(showImage);//将箭头改为下拉箭头
            show = true;
            //删除登陆下拉界面
            loginBelowAnchorpane.setVisible(false);
        }
    }

    //点击叉叉，取消登陆，返回身份选择界面
    @FXML
    void backToRoleChoose(MouseEvent event) {
        if(!show){//如果当前是收起箭头，说明登陆下拉界面已经被放在身份选择界面上，这时要先删除登陆下拉界面
            //删除登陆下拉界面
            loginBelowAnchorpane.setVisible(false);
        }
        //删除登陆界面
         UIJumpTool.getUiJumpTool().removeLogin();
    }

    //将取消的叉叉变为灰色
    @FXML
    void changeToGray(MouseEvent event) {
        cancelImage.setImage(cancel_gray);
    }

    //将取消的叉叉变为红色
    @FXML
    void changeToRed(MouseEvent event) {
        cancelImage.setImage(cancel_red);
    }

    void setRole(Role role){
        this.role = role;
    }

    void setShowMoreImage(boolean visible){
        showMoreImage.setVisible(visible);
    }

    @FXML
    void initialize() {
        assert headImage != null : "fx:id=\"headImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file '登陆.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '登陆.fxml'.";
        assert showMoreImage != null : "fx:id=\"showMoreImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '登陆.fxml'.";
        assert loginBelowAnchorpane != null : "fx:id=\"loginBelowAnchorpane\" was not injected: check your FXML file '登陆.fxml'.";
        assert registerLabel != null : "fx:id=\"registerLabel\" was not injected: check your FXML file '登陆.fxml'.";
        assert idFormLabel != null : "fx:id=\"idFormLabel\" was not injected: check your FXML file '登陆.fxml'.";
        assert passwordFormLabel != null : "fx:id=\"passwordFormLabel\" was not injected: check your FXML file '登陆.fxml'.";

    }
}
