package presentation.usercontrollertools;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import presentation.logincontroller.LoginUIController;
import presentation.usercontroller.BrowseHotelUIController;
import presentation.usercontroller.GuideUIController;
import presentation.usercontroller.LoadingUIController;
import presentation.usercontroller.UserOrderUIController;
import presentation.usercontroller.UserRegisterUIController;

/**
 * Created by john on 2016/12/5.
 * 加载fxml文件
 */
public class UserUIFXMLFactory {
    private static UserUIFXMLFactory userUIFXMLFactory = null;
    //UIController
    private GuideUIController guideUIController = null;
    private BrowseHotelUIController browseHotelUIController = null;
    private LoginUIController loginUIController = null;
    private UserRegisterUIController userRegisterUIController = null;
    private UserOrderUIController userOrderUIController = null;
    private LoadingUIController loadingUIController = null;
    private AnchorPane roleChoose = null;
    private AnchorPane loading = null;

    private UserUIFXMLFactory(){}
  
    public static UserUIFXMLFactory getUserUIFXMLFactory() {
        if(userUIFXMLFactory==null){
            userUIFXMLFactory = new UserUIFXMLFactory();
        }
        return userUIFXMLFactory;
    }
    
    public AnchorPane getLoading() {
    	if(loading==null){
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/正在加载.fxml"));
    		try {
    			loading = loader.load();
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
    		loadingUIController = loader.getController();
    	}
		return loading;
	}

    public AnchorPane getAddComment(){
        FXMLLoader addCommentLoader = new FXMLLoader(getClass().getResource("/fxml/添加评价.fxml"));
        AnchorPane addComment = null;
        try {
            addComment = addCommentLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return addComment;
    }

    public AnchorPane getModifyUserInfo(){
        FXMLLoader modifyUserInfoLoader = new FXMLLoader(getClass().getResource("/fxml/用户个人资料.fxml"));
        AnchorPane modifyUserInfo = null;
        try {
            modifyUserInfo = modifyUserInfoLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return modifyUserInfo;
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

    public AnchorPane getModifyPassword(){
        FXMLLoader modifyPasswordLoader = new FXMLLoader(getClass().getResource("/fxml/修改密码新.fxml"));
        AnchorPane modifyPassword = null;
        try {
            modifyPassword = modifyPasswordLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return modifyPassword;
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
        userOrderUIController =(UserOrderUIController) userOrderLoader.getController();
        return userOrder;
    }

    public AnchorPane getCreateOrder(){
        FXMLLoader createOrderLoader = new FXMLLoader(getClass().getResource("/fxml/生成订单.fxml"));
        AnchorPane createOrder = null;
        try {
            createOrder = createOrderLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return createOrder;
    }

    public AnchorPane getOrderInfo(){
        FXMLLoader orderInfoLoader = new FXMLLoader(getClass().getResource("/fxml/订单详情（user）.fxml"));
        AnchorPane orderInfo = null;
        try {
            orderInfo = orderInfoLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderInfo;
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

    public AnchorPane getRegisterCommonMember(){
        FXMLLoader registerCommonMemberLoader = new FXMLLoader(getClass().getResource("/fxml/普通会员注册.fxml"));
        AnchorPane registerCommonMember = null;
        try {
            registerCommonMember = registerCommonMemberLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return registerCommonMember;
    }

    public AnchorPane getRegisterCommerceMember(){
        FXMLLoader registerCommerceMemberLoader = new FXMLLoader(getClass().getResource("/fxml/企业会员注册.fxml"));
        AnchorPane registerCommerceMember = null;
        try {
            registerCommerceMember = registerCommerceMemberLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return registerCommerceMember;
    }

    public AnchorPane getMyMember(){
        FXMLLoader myMemberloader = new FXMLLoader(getClass().getResource("/fxml/我的会员（不是会员）.fxml"));
        AnchorPane myMember = null;
        try {
            myMember = myMemberloader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return myMember;
    }

    public AnchorPane getIsMember(){
        FXMLLoader isMemberLoader = new FXMLLoader(getClass().getResource("/fxml/我的会员（是会员）.fxml"));
        AnchorPane isMember = null;
        try {
            isMember = isMemberLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        return isMember;
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

    public AnchorPane getRoleChoose() {
        FXMLLoader roleChooseLoader = new FXMLLoader(getClass().getResource("/fxml/身份选择.fxml"));
        if(roleChoose==null){
        	try {
                roleChoose = roleChooseLoader.load();
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    public UserOrderUIController getUserOrderUIController() {
        return userOrderUIController;
    }

    public UserRegisterUIController getUserRegisterUIController() {
        return userRegisterUIController;
    }

	public LoadingUIController getLoadingUIController() {
		return loadingUIController;
	}
    
}
