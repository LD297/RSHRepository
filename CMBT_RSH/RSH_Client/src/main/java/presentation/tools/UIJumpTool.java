package presentation.tools;

import bl.userserviceimpl.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.logincontroller.BelowLoginUIController;
import presentation.logincontroller.LoginUIController;
import presentation.usercontroller.BrowseHotelUIController;
import presentation.usercontroller.GuideUIController;
import presentation.usercontroller.UserRegisterUIController;

import java.io.IOException;
import java.util.Stack;

/**
 * Created by john on 2016/12/5.
 */
public class UIJumpTool {
    private static UIJumpTool uiJumpTool = null;
    private Stage stage = null;
    private Stack<AnchorPane> anchorPanes = new Stack<AnchorPane>();

    private AnchorPane guide = UserUIFXMLFactory.getUserUIFXMLFactory().getGuide();
    private AnchorPane searchHotel = UserUIFXMLFactory.getUserUIFXMLFactory().getSearchHotel();
    private AnchorPane browseHotel = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotel();
    private AnchorPane hotelInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getHotelInfo();
    private AnchorPane roomInfo = UserUIFXMLFactory.getUserUIFXMLFactory().getRoomInfo();
    private AnchorPane comment = UserUIFXMLFactory.getUserUIFXMLFactory().getComment();
    private AnchorPane selectionCondition = UserUIFXMLFactory.getUserUIFXMLFactory().getSelectionCondition();
    private AnchorPane login = UserUIFXMLFactory.getUserUIFXMLFactory().getLogin();
    private AnchorPane belowLogin = UserUIFXMLFactory.getUserUIFXMLFactory().getLoginBelow();
    private AnchorPane userRegister = UserUIFXMLFactory.getUserUIFXMLFactory().getUserRegister();

    private GuideUIController guideUIController = null;
    private BrowseHotelUIController browseHotelUIController = null;
    private LoginUIController loginUIController = null;
    private BelowLoginUIController belowLoginUIController = null;
    private UserRegisterUIController userRegisterUIController = null;

    private AnchorPane guidePrePane = null;
    private AnchorPane roleChoose = null;
    private boolean withLoginBelow = false;
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

    public void setGuidePrePane(AnchorPane guidePrePane){this.guidePrePane = guidePrePane;}

    public void setRoleChoose(AnchorPane roleChoose) {
        this.roleChoose = roleChoose;
    }

    public Stage getStage(){return stage;}

    //从搜索酒店界面跳转到酒店浏览界面
    public void changeSearchHotelToBrowseHotel(){
        GridPane gridPane = (GridPane)guide.getChildren().get(0);
        gridPane.getChildren().remove(1);//删除searchhotel
        anchorPanes.push(searchHotel);
        gridPane.add(browseHotel,0,1);
        //设置导航栏上的箭头可点
        if(guideUIController==null){
            guideUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getGuideUIController();
        }
        guideUIController.setBackImage(true);
        //上一个界面为搜索主界面
        guidePrePane = searchHotel;
    }

    //从登陆界面跳转到搜索酒店界面
    public void changeLoginToSearchHotel(){
        //先判断有没有登陆下拉界面,有就删除
        if(withLoginBelow){
            removeLoginBelow();
        }
       changeToSearchHotel();
        //导航栏设置返回箭头不可点
        if(guideUIController==null){
            guideUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getGuideUIController();
        }
        guideUIController.setBackImage(false);
    }

    //点击搜索框跳转到搜索酒店界面
    public AnchorPane changeToSearchHotel(){
        GridPane gridPane = (GridPane)guide.getChildren().get(0);//单单导航栏界面的AnchorPane只有一个子女
        gridPane.add(searchHotel,0,1);//将搜索酒店界面添加到导航栏界面的gridpane里
        Scene scene = null;
        if(guide.getScene()==null){
            scene = new Scene(guide,800,720);
        }else {
            scene = guide.getScene();
        }

        stage.setScene(scene);
        //TODO 设置光标
        return searchHotel;
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
            root = HotelUIFactory.getInstance().getHomepageUILoader().load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("hotel");
        stage.setScene(new Scene(root, HotelUIFactory.UI_WIDTH, HotelUIFactory.UI_HEIGHT));
    }

    //从注册界面返回到登陆界面
    public void changeRegisterToLogin(){
        stage.setScene(roleChoose.getScene());
    }

    //从登陆下拉界面跳转到注册界面
    public UserRegisterUIController changeLoginToRegister(){
        Scene scene = null;
        if(userRegister.getScene()!=null){
            scene = userRegister.getScene();
        }else {
            scene = new Scene(userRegister,800,720);
        }
        stage.setScene(scene);
        if(userRegisterUIController==null){
            userRegisterUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getUserRegisterUIController();
        }
        return userRegisterUIController;
    }

    //在登陆界面上添加登陆下拉界面（以身份选择界面为背景）
    public BelowLoginUIController addLoginBelow(){
        //在身份选择界面添加登陆下拉界面
        AnchorPane temp =(AnchorPane) roleChoose.getChildren().get(roleChoose.getChildren().size()-1);
        roleChoose.getChildren().set(roleChoose.getChildren().size()-1,belowLogin);
        roleChoose.getChildren().add(temp);
        withLoginBelow = true;
        //设置登陆下拉在身份选择界面的位置
        Locator.getLocator().setLocation(belowLogin,446.0,223.0,276.0,276.0);
        //设置登陆下拉界面的身份属性
        if(belowLoginUIController==null){
            belowLoginUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getBelowLoginUIController();
        }
        return belowLoginUIController;
    }

    //删除登陆下拉界面
    public void removeLoginBelow(){
        int size = roleChoose.getChildren().size();
        roleChoose.getChildren().remove(size-2);
        withLoginBelow = false;
    }

    //在身份选择界面上添加登陆界面
    public LoginUIController addLogin(){
        //在身份选择界面添加登陆界面
        roleChoose.getChildren().add(login);
        //设置Login的位置
        Locator.getLocator().setLocation(login,130.0,274.0,276.0,276.0);
        //返回loginuicontroller
       if(loginUIController==null){
           loginUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getLoginUIController();
       }
        return loginUIController;
    }

    //删除登陆界面
    public void removeLogin(){
        int size = roleChoose.getChildren().size();
        roleChoose.getChildren().remove(size-1);//删除登陆界面
        size--;
        //将身份选择界面的蒙板去掉
        Label label = (Label)roleChoose.getChildren().get(size-1);
        label.setVisible(false);
    }


    //从酒店浏览界面跳转到酒店详情界面
    public void changeBrowseHotelToHotelInfo(String hotelName){
        GridPane gridPane =(GridPane) guide.getChildren().get(0);
        gridPane.getChildren().remove(1);//删除酒店浏览界面
        anchorPanes.push(browseHotel);
        gridPane.add(hotelInfo,0,1);//增加酒店详情界面
        //在酒店详情界面中添加客房信息界面，并让客房信息界面显示在变迁下面
        GridPane gridPaneInHotelInfo = (GridPane)hotelInfo.getChildren().get(0);
        AnchorPane temp = (AnchorPane) gridPaneInHotelInfo.getChildren().get(1);
        gridPaneInHotelInfo.getChildren().remove(1);//
        gridPaneInHotelInfo.add(roomInfo,0,2);
        gridPaneInHotelInfo.add(temp,0,1);
    }

    //从酒店浏览界面跳转到筛选条件界面
    public void changeToSelectCondition(){
        browseHotel.getChildren().add(selectionCondition);
        Locator.getLocator().setLocation(selectionCondition,114.0,156.0,150.0,150.0);
    }

    //直接关闭筛选条件界面
    public void closeSelectCondition(){
        browseHotel.getChildren().remove(browseHotel.getChildren().size()-1);
        browseHotelUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotelUIController();
        browseHotelUIController.setMaskLabel(false);

    }

    //TODO 从酒店浏览界面跳转到新建订单界面
    public void changeBrowseHotelToCreateOrder(){

    }

    //从酒店详情（展示客房信息）跳转到酒店详情（展示评价）
    public void changeToComment(){
        //在酒店详情界面中添加查看评价界面，并让查看评价界面显示在变迁下面
        GridPane gridPaneInHotelInfo = (GridPane)hotelInfo.getChildren().get(0);
        AnchorPane temp = (AnchorPane) gridPaneInHotelInfo.getChildren().get(2);
        gridPaneInHotelInfo.getChildren().remove(2);
        gridPaneInHotelInfo.getChildren().remove(1);//
        gridPaneInHotelInfo.add(comment,0,2);
        gridPaneInHotelInfo.add(temp,0,1);
    }

    //从酒店详情（展示评价）跳转到酒店详情（客房信息）
    public void changeToRoomInfo(){
        //在酒店详情界面中添加查看评价界面，并让查看评价界面显示在变迁下面
        GridPane gridPaneInHotelInfo = (GridPane)hotelInfo.getChildren().get(0);
        AnchorPane temp = (AnchorPane) gridPaneInHotelInfo.getChildren().get(2);
        gridPaneInHotelInfo.getChildren().remove(2);
        gridPaneInHotelInfo.getChildren().remove(1);//
        gridPaneInHotelInfo.add(roomInfo,0,2);
        gridPaneInHotelInfo.add(temp,0,1);
    }

    //在导航栏上点击返回箭头，返回到原来的界面
    public void back(){
        GridPane gridPane = (GridPane)guide.getChildren().get(0);
        AnchorPane presentAnchorPane = (AnchorPane) gridPane.getChildren().get(1);
        if(presentAnchorPane==hotelInfo){
            ((GridPane)hotelInfo.getChildren().get(0)).getChildren().remove(1);
        }
        gridPane.getChildren().remove(1);
        if(!anchorPanes.empty()){
            AnchorPane anchorPane = anchorPanes.pop();
            if(anchorPane==searchHotel){
                guideUIController.setBackImage(false);
            }
            gridPane.add(anchorPane,0,1);
        }

    }

}
