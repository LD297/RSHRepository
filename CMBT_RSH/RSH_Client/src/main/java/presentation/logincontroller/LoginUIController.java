package presentation.logincontroller;

/**
 * Created by john on 2016/12/4.
 */
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
import bl.loginservice.LoginService;
import bl.loginserviceimpl.LoginController;
import bl.orderservice.OrderForHotel;
import bl.orderservice.OrderForWebsite;
import bl.promotionServiceimpl.PromotionService_Stub;
import bl.promotionservice.PromotionService;
import bl.userservice.UserService;
import bl.webstaffservice.WebStaffService;
import bl.webstaffserviceimpl.WebSalesman;
import constant.ResultMessage;
import constant.Role;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
import presentation.websalesmancontrollertools.WebSalesmanServiceFactory;
import presentation.websalesmancontrollertools.WebSalesmanUIFXMLFactory;
import vo.WebSalesmanVO;

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
            	ResultMessage resultMessage = UserInfoUtil.getInstance().login(id, password);
                if(resultMessage==ResultMessage.succeed){
                    //跳转到搜索酒店界面
                    if(loginBelowAnchorpane.isVisible()){//先判断有没有登陆下拉界面,有就删除
                        loginBelowAnchorpane.setVisible(false);
                    }
                    UIJumpTool.getUiJumpTool().changeLoginToSearchHotel();
                }else{
                	if(resultMessage==ResultMessage.idNotExist){
                		idFormLabel.setText("该用户名不存在");
                	}else if (resultMessage==ResultMessage.password_wrong) {
						passwordFormLabel.setText("密码错误");
					}
                }
            }
        }else if (role==Role.webmanager) {
			if(WebManagerInfoUtil.getInstance().checkOnLine(id, password)==ResultMessage.succeed){
				passwordFormLabel.setText("");
				Stage stage = (Stage)idField.getScene().getWindow();
				Scene scene = null;
				AnchorPane webmanagerHomepage = WebManagerUIFXMLFactory.getInstance().getManageHomepage();
				if(webmanagerHomepage.getScene()!=null){
					scene = webmanagerHomepage.getScene();
				}else {
					scene = new Scene(webmanagerHomepage,800,720);
				}
				stage.setScene(scene);
			}else{
				passwordFormLabel.setText("用户名或密码错误");
			}
		} else if(role==Role.hotel){
            LoginService loginService = HotelServiceFactory.getInstance().getLoginService();

            if(loginService.checkOnline(Role.hotel, id, password).equals(ResultMessage.succeed)){

                HotelService hotelService = HotelServiceFactory.getInstance().getHotelService();
                PromotionService promotionService = HotelServiceFactory.getInstance().getPromotionService();
                HotelInfoService hotelInfoService = HotelServiceFactory.getInstance().getHotelInfoService();
                OrderForHotel orderForHotel = HotelServiceFactory.getInstance().getOrderForHotel();

                AnchorPane hotelHomepage = HotelUIFXMLFactory.getInstance().getHotelHomePage();
                HotelHomepageUIController hotelHomepageUIController = HotelUIFXMLFactory.getInstance().
                        getHotelHomepageUIController();

                hotelHomepageUIController.setPrePane(loginBelowAnchorpane);
                hotelHomepageUIController.setHotelId(id);
                hotelHomepageUIController.setHotelService(hotelService);
                hotelHomepageUIController.setPromotionService(promotionService);
                hotelHomepageUIController.setHotelInfoService(hotelInfoService);
                hotelHomepageUIController.setOrderForHotel(orderForHotel);

                Stage stage = (Stage)idField.getScene().getWindow();
                Scene scene = null;
                if(hotelHomepage.getScene()==null)
                    scene = new Scene(hotelHomepage, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
                else
                    scene = hotelHomepage.getScene();
                stage.setScene(scene);
            } else {
                passwordFormLabel.setText("用户名或密码错误");
            }

        } else if(role.equals(Role.websalesman)){
            LoginService loginService = HotelServiceFactory.getInstance().getLoginService();
            if(loginService.checkOnline(Role.websalesman, id, password ).equals(ResultMessage.succeed)){

                WebStaffService webStaffService = WebSalesmanServiceFactory.getInstance().getWebStaffService();
                PromotionService promotionService = WebSalesmanServiceFactory.getInstance().getPromotionService();
                OrderForWebsite orderForWebsite = WebSalesmanServiceFactory.getInstance().getOrderForWebsite();
                UserService userService = WebSalesmanServiceFactory.getInstance().getUserService();

                AnchorPane webSalesmanHomepage = WebSalesmanUIFXMLFactory.getInstance().getWebSalesmanHomepage();
                WebSalesmanHomepageUIController webSalesmanHomepageUIController = WebSalesmanUIFXMLFactory.
                        getInstance().getWebSalesmanHomepageUIController();

                WebSalesmanVO webSalesmanVO = webStaffService.webSalesmanVO(id);
                webSalesmanHomepageUIController.setPrePane(loginBelowAnchorpane);
                webSalesmanHomepageUIController.setWebSalesmanVO(webSalesmanVO);
                // 配置逻辑处理服务
                webSalesmanHomepageUIController.setPromotionService(promotionService);
                webSalesmanHomepageUIController.setOrderForWebsite(orderForWebsite);
                webSalesmanHomepageUIController.setUserService(userService);

                Stage stage = (Stage)idField.getScene().getWindow();
                Scene scene = null;
                if(webSalesmanHomepage.getScene()==null)
                    scene = new Scene(webSalesmanHomepage, WebSalesmanUIFXMLFactory.UI_WIDTH, WebSalesmanUIFXMLFactory.UI_HEIGHT);
                else
                    scene = webSalesmanHomepage.getScene();
                stage.setScene(scene);
            } else {
                passwordFormLabel.setText("用户名或密码错误");
            }
        }/*        if(resultMessage==resultMessage.succeed){
            if(role == Role.user){

            }else if(role==Role.hotel){
                //跳转到hotel主界面
                UIJumpTool.getUiJumpTool().changeLoginToHotelHomePage();
            }else if(role==Role.websalesman){
                //TODO 跳转到websalesman主界面
            }else{
                //TODO 跳转到webmanager主界面
            }
        }else{
            //TODO 用户名和密码错误，或者登陆冲突
        }*/
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
