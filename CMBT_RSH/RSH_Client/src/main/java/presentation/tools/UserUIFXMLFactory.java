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

    public AnchorPane getUserGuide(){
        FXMLLoader userGuideLoader = new FXMLLoader(getClass().getResource("/fxml/用户导航栏.fxml"));
        AnchorPane userGuide = null;
        try {
            userGuide = userGuideLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userGuide;
    }

    public AnchorPane getUserInfo(){
        FXMLLoader userInfoLoader = new FXMLLoader(getClass().getResource("/fxml/我的信息.fxml"));
        AnchorPane userInfo = null;
        try {
            userInfo = userInfoLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userInfo;
    }

    public AnchorPane getUserOrder(){
        FXMLLoader userOrderLoader = new FXMLLoader(getClass().getResource("/fxml/订单浏览（用户视角）.fxml"));
        AnchorPane userOrder = null;
        try {
            userOrder = userOrderLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userOrder;
    }

    public AnchorPane getUserCreditRecord(){
        FXMLLoader userCreditRecordLoader = new FXMLLoader(getClass().getResource("/fxml/信用记录.fxml"));
        AnchorPane userCreditRecord = null;
        try {
            userCreditRecord = userCreditRecordLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return userCreditRecord;
    }

    public AnchorPane getMyMember(){
        FXMLLoader myMemberloader = new FXMLLoader(getClass().getResource("/fxml/我的会员.fxml"));
        AnchorPane myMember = null;
        try {
            myMember = myMemberloader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return myMember;
    }

    public AnchorPane getIsMember(){
        FXMLLoader isMemberLoader = new FXMLLoader(getClass().getResource("/fxml/是会员.fxml"));
        AnchorPane isMember = null;
        try {
            isMember = isMemberLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isMember;
    }

    public AnchorPane getIsnotMember(){
        FXMLLoader isnotMemberLoader = new FXMLLoader(getClass().getResource("/fxml/不是会员.fxml"));
        AnchorPane isnotMember = null;
        try {
            isnotMember = isnotMemberLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isnotMember;
    }

    public AnchorPane getComment() {
        FXMLLoader commentLoader = new FXMLLoader(getClass().getResource("/fxml/查看评价.fxml"));
        AnchorPane comment = null;
        try {
            comment = commentLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comment;
    }

    public AnchorPane getGuide(){
        FXMLLoader guideLoader = new FXMLLoader(getClass().getResource("/fxml/导航栏.fxml"));
        AnchorPane guide = null;
        try {
            guide = guideLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        guideUIController = (GuideUIController) guideLoader.getController();
        return guide;
    }

    public AnchorPane getSearchHotel(){
        FXMLLoader searchHotelLoader = new FXMLLoader(getClass().getResource("/fxml/搜索酒店.fxml"));
        AnchorPane searchHotel = null;
        try {
            searchHotel = searchHotelLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return searchHotel;
    }

    public AnchorPane getUserRegister() {
        FXMLLoader userRegisterLoader = new FXMLLoader(getClass().getResource("/fxml/用户注册.fxml"));
        AnchorPane userRegister = null;
            try {
                userRegister = userRegisterLoader.load();
            }catch (Exception e){
                e.printStackTrace();
            userRegisterUIController = (UserRegisterUIController)userRegisterLoader.getController();
        }
        return userRegister;
    }

    public AnchorPane getLogin() {
        FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/fxml/登陆.fxml"));
        AnchorPane login = null;
        try {
            login = loginLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        loginUIController = (LoginUIController) loginLoader.getController();
        return login;
    }

    public AnchorPane getHotelInfo() {
        FXMLLoader hotelInfoLoader = new FXMLLoader(getClass().getResource("/fxml/酒店详情.fxml"));
        AnchorPane hotelInfo = null;
        try {
            hotelInfo = hotelInfoLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hotelInfo;
    }

    public AnchorPane getRoomInfo() {
        FXMLLoader roomInfoLoader = new FXMLLoader(getClass().getResource("/fxml/客房信息.fxml"));
        AnchorPane roomInfo = null;
        try {
            roomInfo = roomInfoLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return roomInfo;
    }

    public AnchorPane getBrowseHotel() {
        FXMLLoader browseHotelLoader = new FXMLLoader(getClass().getResource("/fxml/酒店浏览（用户视角）.fxml"));
        AnchorPane browseHotel = null;
        try {
            browseHotel = browseHotelLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        browseHotelUIController = (BrowseHotelUIController) browseHotelLoader.getController();
        return browseHotel;
    }

    public AnchorPane getSelectionCondition(){
        FXMLLoader selectConditionLoader = new FXMLLoader(getClass().getResource("/fxml/筛选条件.fxml"));
        AnchorPane selectionCondition = null;
        try {
            selectionCondition = selectConditionLoader.load();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return selectionCondition;
    }

    public AnchorPane getLoginBelow() {
        FXMLLoader loginBelowLoader = new FXMLLoader(getClass().getResource("/fxml/登陆下拉.fxml"));
        AnchorPane loginBelow = null;
        try {
            loginBelow = loginBelowLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        belowLoginUIController = (BelowLoginUIController) loginBelowLoader.getController();
        return loginBelow;
    }

    public AnchorPane getRoleChoose() {
        FXMLLoader roleChooseLoader = new FXMLLoader(getClass().getResource("/fxml/身份选择.fxml"));
        AnchorPane roleChoose = null;
        try {
            roleChoose = roleChooseLoader.load();
        } catch (Exception e) {
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
