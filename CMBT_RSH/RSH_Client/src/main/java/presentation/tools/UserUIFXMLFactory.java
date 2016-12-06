package presentation.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.logincontroller.BelowLoginUIController;
import presentation.logincontroller.LoginUIController;
import presentation.usercontroller.BrowseHotelUIController;
import presentation.usercontroller.GuideUIController;
import presentation.usercontroller.UserRegisterUIController;

import java.io.IOException;

/**
 * Created by john on 2016/12/5.
 */
public class UserUIFXMLFactory {
    private static UserUIFXMLFactory userUIFXMLFactory = null;
    //loader
    private FXMLLoader guideLoader = new FXMLLoader(getClass().getResource("/fxml/导航栏.fxml"));
    private FXMLLoader searchHotelLoader = new FXMLLoader(getClass().getResource("/fxml/搜索酒店.fxml"));
    private FXMLLoader browseHotelLoader = new FXMLLoader(getClass().getResource("/fxml/酒店浏览（用户视角）.fxml"));
    private FXMLLoader hotelInfoLoader = new FXMLLoader(getClass().getResource("/fxml/酒店详情.fxml"));
    private FXMLLoader roomInfoLoader = new FXMLLoader(getClass().getResource("/fxml/客房信息.fxml"));
    private FXMLLoader commentLoader = new FXMLLoader(getClass().getResource("/fxml/查看评价.fxml"));
    private FXMLLoader selectConditionLoader = new FXMLLoader(getClass().getResource("/fxml/筛选条件.fxml"));
    private FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/fxml/登陆.fxml"));
    private FXMLLoader loginBelowLoader = new FXMLLoader(getClass().getResource("/fxml/登陆下拉.fxml"));
    private FXMLLoader userRegisterLoader = new FXMLLoader(getClass().getResource("/fxml/用户注册.fxml"));
    private FXMLLoader roleChooseLoader = new FXMLLoader(getClass().getResource("/fxml/身份选择.fxml"));
    //AnchorPane
    private AnchorPane comment = null;
    private AnchorPane guide = null;
    private AnchorPane searchHotel = null;
    private AnchorPane browseHotel = null;
    private AnchorPane hotelInfo = null;
    private AnchorPane roomInfo = null;
    private AnchorPane selectionCondition = null;
    private AnchorPane login = null;
    private AnchorPane loginBelow = null;
    private AnchorPane userRegister = null;
    private AnchorPane roleChoose = null;
    //UIController
    private GuideUIController guideUIController = null;
    private BrowseHotelUIController browseHotelUIController = null;
    private LoginUIController loginUIController = null;
    private BelowLoginUIController belowLoginUIController = null;
    private UserRegisterUIController userRegisterUIController = null;

    private UserUIFXMLFactory(){}

    public static UserUIFXMLFactory getUserUIFXMLFactory() {
        if(userUIFXMLFactory==null){
            userUIFXMLFactory = new UserUIFXMLFactory();
        }
        return userUIFXMLFactory;
    }

    public AnchorPane getComment() {
        try{
            comment = commentLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return comment;
    }

    public AnchorPane getGuide(){
        try {
            guide = guideLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        guideUIController = (GuideUIController)guideLoader.getController();
        return guide;
    }

    public AnchorPane getSearchHotel(){
        try {
            searchHotel = searchHotelLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return searchHotel;
    }

    public AnchorPane getUserRegister() {
        try {
            userRegister = userRegisterLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        userRegisterUIController = (UserRegisterUIController)userRegisterLoader.getController();
        return userRegister;
    }

    public AnchorPane getLogin() {
        try {
            login = loginLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        loginUIController = (LoginUIController)loginLoader.getController();
        return login;
    }

    public AnchorPane getHotelInfo() {
        try {
            hotelInfo = hotelInfoLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return hotelInfo;
    }

    public AnchorPane getRoomInfo() {
        try {
            roomInfo = roomInfoLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return roomInfo;
    }

    public AnchorPane getBrowseHotel() {
        try {
            browseHotel = browseHotelLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        browseHotelUIController = (BrowseHotelUIController)browseHotelLoader.getController();
        return browseHotel;
    }

    public AnchorPane getSelectionCondition(){
        try {
            selectionCondition = selectConditionLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return selectionCondition;
    }

    public AnchorPane getLoginBelow() {
        try {
            loginBelow = loginBelowLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        belowLoginUIController = (BelowLoginUIController)loginBelowLoader.getController();
        return loginBelow;
    }

    public AnchorPane getRoleChoose(){
        try {
            roleChoose = roleChooseLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return roleChoose;
    }

    public GuideUIController getGuideUIController() {
        return guideUIController;
    }

    public BrowseHotelUIController getBrowseHotelUIController() {
        return browseHotelUIController;
    }

    public LoginUIController getLoginUIController() {
        return loginUIController;
    }

    public BelowLoginUIController getBelowLoginUIController() {
        return belowLoginUIController;
    }

    public UserRegisterUIController getUserRegisterUIController() {
        return userRegisterUIController;
    }
}
