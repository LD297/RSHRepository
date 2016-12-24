package presentation.usercontrollertools;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import presentation.logincontroller.LoginUIController;
import presentation.tools.Locator;
import presentation.usercontroller.GuideUIController;
import presentation.usercontroller.UserOrderUIController;

import java.io.IOException;
import java.util.Stack;

import constant.MemberType;

/**
 * Created by john on 2016/12/5.
 */
public class UIJumpTool {
    private static UIJumpTool uiJumpTool = null;
    private Stage stage = null;
    private Stack<AnchorPane> anchorPanes = new Stack<AnchorPane>();
    private AnchorPane roleChoose = null;
    private AnchorPane guide = null;
    private AnchorPane searchHotel = null;
    private AnchorPane browseHotel = null;
    private AnchorPane hotelInfo = null;
    private AnchorPane roomInfo = null;
    private AnchorPane comment = null;
    private AnchorPane selectionCondition = null;
    private AnchorPane login = null;
    private AnchorPane userRegister = null;
    private AnchorPane userGuide = null;
    private AnchorPane userInfo = null;
    private AnchorPane modifyUserInfo = null;
    private AnchorPane modifyUserPassword = null;
    private AnchorPane myMember = null;//不是会员
    private AnchorPane isMember = null;//是会员
    private AnchorPane userCreditRecord = null;
    private AnchorPane userOrder = null;
    private AnchorPane myOrderOfOneHotel = null;
    private AnchorPane registerCommonMember = null;
    private AnchorPane registerCommerceMember = null;
    private AnchorPane addComment = null;
    private AnchorPane createOrder = null;
    private AnchorPane orderInfo = null;
    private GuideUIController guideUIController = null;
    private LoginUIController loginUIController = null;
    private UIJumpTool(){}

    public static UIJumpTool getUiJumpTool() {
        if(uiJumpTool==null){
            uiJumpTool = new UIJumpTool();
        }
        return uiJumpTool;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setRoleChoose(AnchorPane roleChoose) {
        this.roleChoose = roleChoose;
    }

    public Stage getStage(){return stage;}

    //在酒店详情界面上弹出针对该酒店的我的订单界面
    public void changeToMyOrderOfOneHotel(){
        myOrderOfOneHotel = UserUIFXMLFactory.getUserUIFXMLFactory().getUserOrder();
        //TODO 在initialize方法里面设置返回箭头可见
        UserOrderUIController userOrderUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getUserOrderUIController();
        userOrderUIController.setBackImage(true);
        hotelInfo.getChildren().get(hotelInfo.getChildren().size()-1).setVisible(true);
        hotelInfo.getChildren().add(myOrderOfOneHotel);
        //设置我的订单的位置
        Locator.getLocator().setLocation(myOrderOfOneHotel,20.0,20.0,0.0,0.0);
    }

    //在酒店详情界面上关闭针对该酒店的我的订单界面
    public void closeMyOrderOfOneHotel(){
        hotelInfo.getChildren().remove(hotelInfo.getChildren().size()-1);
        //将酒店详情上蒙的label设置为不可见
        hotelInfo.getChildren().get(hotelInfo.getChildren().size()-1).setVisible(false);
    }

    //在我的订单界面上弹出订单详情界面
    public void changeToOrderInfo(){
        orderInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getOrderInfo();
        guide.getChildren().add(orderInfo);
    }

    /**
     * 关闭订单详情，并刷新订单浏览界面
     */
    public void closeOrderInfo(){
        guide.getChildren().remove(guide.getChildren().size()-1);
        //刷新浏览订单界面
        UserOrderUIController userOrderUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getUserOrderUIController();
        userOrderUIController.refresh();
    }

    //在酒店浏览界面上弹出订单生成界面
    public void changeToCreateOrder(){
        createOrder = UserUIFXMLFactory.getUserUIFXMLFactory().getCreateOrder();
        guide.getChildren().add(createOrder);
    }

    //关闭订单生成界面
    public void closeCreateOrder(){
        guide.getChildren().remove(guide.getChildren().size()-1);
        //TODO 刷新酒店浏览界面
    }

    //从订单浏览界面跳转到添加评价界面
    /**
     * 从订单详情界面跳转到添加评价界面
     */
    public void changeUserOrderToAddComment(){
        addComment = UserUIFXMLFactory.getUserUIFXMLFactory().getAddComment();
        guide.getChildren().add(addComment);
    }

    //从添加评价界面返回到订单浏览界面
    /**
     * 从添加评价界面跳转返回到订单详情界面
     */
    public void changeAddCommentToUserOrder(){
        guide.getChildren().remove(guide.getChildren().size()-1);
        //刷新
        UserOrderUIController userOrderUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getUserOrderUIController();
        userOrderUIController.refresh();
    }

    //从会员注册界面返回到我的会员(是会员)界面
    public void changeMemberRegisterToMember(){
        isMember = UserUIFXMLFactory.getUserUIFXMLFactory().getIsMember();
        GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        gridPane.add(isMember,0,1);
    }

    //从会员注册界面返回到我的会员（不是会员）界面
    public void changeMemberRegisterToMyMember(){
        myMember.getChildren().remove(myMember.getChildren().size()-1);
    }

    //跳转到普通会员注册界面
    public void changeToCommonMemberRegister(){
        registerCommonMember = UserUIFXMLFactory.getUserUIFXMLFactory().getRegisterCommonMember();
        myMember.getChildren().add(registerCommonMember);
    }

    //跳转到企业会员注册界面
    public void changeToCommerceMemberRegister(){
        registerCommerceMember = UserUIFXMLFactory.getUserUIFXMLFactory().getRegisterCommerceMember();
        myMember.getChildren().add(registerCommerceMember);
    }

    //跳转到用户导航栏
    public void changeToUserGuide(){
        //将当前界面压栈
        GridPane gridPane = (GridPane)guide.getChildren().get(0);
        AnchorPane prePane = (AnchorPane) gridPane.getChildren().get(1);
        anchorPanes.push(prePane);
        gridPane.getChildren().remove(1);
        //将用户导航栏set进guide
        userGuide = UserUIFXMLFactory.getUserUIFXMLFactory().getUserGuide();
        userInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getUserInfo();
        ((GridPane)userGuide.getChildren().get(0)).add(userInfo,0,1);
        gridPane.add(userGuide,0,1);
        guideUIController.setBackImage(true);
    }

    //跳转到用户个人资料
    public void changeToUserInfo(){
        userInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getUserInfo();
        GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        gridPane.add(userInfo,0,1);
    }

    //跳转到修改密码
    public void changeToModifyPassword(){
        modifyUserPassword = UserUIFXMLFactory.getUserUIFXMLFactory().getModifyPassword();
        modifyUserInfo.getChildren().add(modifyUserPassword);
    }

    //从修改密码返回到编辑用户个人资料
    public void changeModifypasswordToModifyuserinfo(){
        modifyUserInfo.getChildren().remove(modifyUserInfo.getChildren().size()-1);
    }

    //跳转到编辑用户个人资料
    public void changeToModifyUserInfo(){
        modifyUserInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getModifyUserInfo();
        GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        gridPane.add(modifyUserInfo,0,1);
    }

    //跳转到我的会员
    public void changeToMyMember(){
    	MemberType memberType = UserInfoUtil.getInstance().getUserVO().memberType;
    	if(memberType==MemberType.not_member){
    		myMember = UserUIFXMLFactory.getUserUIFXMLFactory().getMyMember();
            GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
            gridPane.getChildren().remove(1);
            gridPane.add(myMember,0,1);
    	}else {
			isMember = UserUIFXMLFactory.getUserUIFXMLFactory().getIsMember();
			GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
            gridPane.getChildren().remove(1);
            gridPane.add(isMember,0,1);
		}
       
    }

    //跳转到我的订单
    public void changeToUserOrder(){
        userOrder = UserUIFXMLFactory.getUserUIFXMLFactory().getUserOrder();
        GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        gridPane.add(userOrder,0,1);
    }

    //跳转到我的信用
    public void changeToUserCreditRecord(){
        userCreditRecord = UserUIFXMLFactory.getUserUIFXMLFactory().getUserCreditRecord();
        GridPane gridPane = (GridPane)userGuide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        gridPane.add(userCreditRecord,0,1);
    }

    //从搜索酒店界面跳转到酒店浏览界面
    public void changeSearchHotelToBrowseHotel(){
        GridPane gridPane = (GridPane)guide.getChildren().get(0);
        gridPane.getChildren().remove(1);//删除searchhotel
        anchorPanes.push(searchHotel);
        browseHotel = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotel();
        gridPane.add(browseHotel,0,1);
        stage.setScene(gridPane.getScene());
        //设置导航栏上的箭头可点
        guideUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getGuideUIController();
        guideUIController.setBackImage(true);
    }
    
    /**
     * 跳转到loading界面
     */
	public void changeToLoading() {
		Scene scene = null;
		AnchorPane loading = UserUIFXMLFactory.getUserUIFXMLFactory().getLoading();
		if (loading.getScene() != null) {
			scene = loading.getScene();
		} else {
			scene = new Scene(loading, 800, 720);
		}
		stage.setScene(scene);
	}

    //从登陆界面跳转到搜索酒店界面
    public void changeLoginToSearchHotel(){
    	guide = UserUIFXMLFactory.getUserUIFXMLFactory().getGuide();
    	GridPane gridPane = (GridPane)guide.getChildren().get(0);//单单导航栏界面的AnchorPane只有一个子
        searchHotel = UserUIFXMLFactory.getUserUIFXMLFactory().getSearchHotel();
        gridPane.add(searchHotel,0,1);//将搜索酒店界面添加到导航栏界面的gridpane里
        Scene scene = null;
        if(guide.getScene()==null){
            scene = new Scene(guide,800,720);
        }else {
            scene = guide.getScene();
        }
        stage.setScene(scene);
        //导航栏设置返回箭头不可点
        guideUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getGuideUIController();
        guideUIController.setBackImage(false);
    }

   
    //从导航栏点击退出跳转到到登陆界面
    public void changeGuideToLogin(){
        //将界面清空
        ((GridPane)guide.getChildren().get(0)).getChildren().remove(1);
        stage.setScene(roleChoose.getScene());
    }

    /**
     * 从登陆界面跳转到酒店主界面
     */
    public void changeLoginToHotelHomePage(){
        Parent root = null;
        try {
            root = HotelUIFXMLFactory.getInstance().getHotelHomepageUILoader().load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("hotel");
        stage.setScene(new Scene(root, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT));
    }

    //从注册界面返回到登陆界面
    public LoginUIController changeRegisterToLogin(){
        stage.setScene(roleChoose.getScene());
        return loginUIController;
    }

    //从登陆下拉界面跳转到注册界面
    public void changeLoginToRegister(){
        Scene scene = null;
        userRegister = UserUIFXMLFactory.getUserUIFXMLFactory().getUserRegister();
        if(userRegister.getScene()!=null){
            scene = userRegister.getScene();
        }else {
            scene = new Scene(userRegister,800,720);
        }
        stage.setScene(scene);
        UserUIFXMLFactory.getUserUIFXMLFactory().getUserRegisterUIController();//TODO 判断这句话是否可以删去
    }

    //在身份选择界面上添加登陆界面
    public LoginUIController addLogin(){
        login = UserUIFXMLFactory.getUserUIFXMLFactory().getLogin();
        //在身份选择界面添加登陆界面
        roleChoose.getChildren().add(login);
        //设置Login的位置
//        Locator.getLocator().setLocation(login,130.0,274.0,276.0,276.0);
        //返回loginuicontroller
        loginUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getLoginUIController();
        return loginUIController;
    }

    //删除登陆界面
    public void removeLogin(){
        int size = roleChoose.getChildren().size();
        roleChoose.getChildren().remove(size-1);//删除登陆界面
    }

    //从酒店浏览界面跳转到酒店详情界面
    public void changeBrowseHotelToHotelInfo(){
        GridPane gridPane =(GridPane) guide.getChildren().get(0);
        gridPane.getChildren().remove(1);//删除酒店浏览界面
        anchorPanes.push(browseHotel);
        hotelInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getHotelInfo();
        gridPane.add(hotelInfo,0,1);//增加酒店详情界面
        //在酒店详情界面中添加客房信息界面，并让客房信息界面显示在变迁下面
        GridPane gridPaneInHotelInfo = (GridPane)hotelInfo.getChildren().get(0);
        AnchorPane temp = (AnchorPane) gridPaneInHotelInfo.getChildren().get(1);
        gridPaneInHotelInfo.getChildren().remove(1);//
        roomInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getRoomInfo();
        gridPaneInHotelInfo.add(roomInfo,0,2);
        gridPaneInHotelInfo.add(temp,0,1);
    }

    //从酒店浏览界面跳转到筛选条件界面
    public void changeToSelectCondition(){
        selectionCondition = UserUIFXMLFactory.getUserUIFXMLFactory().getSelectionCondition();
        guide.getChildren().add(selectionCondition);
    }

    //直接关闭筛选条件界面，并重新初始化酒店浏览界面
    public void closeSelectCondition(){
 //   	browseHotelUIController.init();
        guide.getChildren().remove(guide.getChildren().size()-1);
        
    }

    //从酒店详情（展示客房信息）跳转到酒店详情（展示评价）
    public void changeToComment(){
        //在酒店详情界面中添加查看评价界面，并让查看评价界面显示在变迁下面
        GridPane gridPaneInHotelInfo = (GridPane)hotelInfo.getChildren().get(0);
        AnchorPane temp = (AnchorPane) gridPaneInHotelInfo.getChildren().get(2);
        gridPaneInHotelInfo.getChildren().remove(2);
        gridPaneInHotelInfo.getChildren().remove(1);//
        comment = UserUIFXMLFactory.getUserUIFXMLFactory().getComment();
        gridPaneInHotelInfo.add(comment,0,2);
        gridPaneInHotelInfo.add(temp,0,1);
    }

    //从酒店详情（展示评价）跳转到酒店详情（客房信息）
    public void changeToRoomInfo(){
        //在酒店详情界面中添加客房信息界面，并让客房信息界面显示在变迁下面
        GridPane gridPaneInHotelInfo = (GridPane)hotelInfo.getChildren().get(0);
        AnchorPane temp = (AnchorPane) gridPaneInHotelInfo.getChildren().get(2);
        gridPaneInHotelInfo.getChildren().remove(2);
        gridPaneInHotelInfo.getChildren().remove(1);//
        roomInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getRoomInfo();
        gridPaneInHotelInfo.add(roomInfo,0,2);
        gridPaneInHotelInfo.add(temp,0,1);
    }

    //在导航栏上点击返回箭头，返回到原来的界面
    public void back(){
        //删除当前界面
        GridPane gridPane = (GridPane)guide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        if(!anchorPanes.empty()){//将栈顶出栈，并set进guide里面
            AnchorPane anchorPane = anchorPanes.pop();
            if(anchorPane==searchHotel){
                guideUIController.setBackImage(false);
            }
            gridPane.add(anchorPane,0,1);
        }
    }
}
