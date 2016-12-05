package presentation.tools;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.logincontroller.BelowLoginUIController;
import presentation.logincontroller.LoginUIController;
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
    private GuideUIController guideUIController = null;
    private AnchorPane guide = null;
    private AnchorPane roleChoose = null;
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

    //TODO 判断是否需要这个方法
    public void setGuideUIController(GuideUIController guideUIController) {
        this.guideUIController = guideUIController;
    }

    public void setGuide(AnchorPane guide) {
        this.guide = guide;
    }

    public void setRoleChoose(AnchorPane roleChoose) {
        this.roleChoose = roleChoose;
    }

    public Stage getStage(){return stage;}

    //从搜索酒店界面跳转到酒店浏览界面
    public void changeSearchHotelToBrowseHotel(){
        FXMLLoader loader = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotelLoader();
        AnchorPane browseHotel = null;
        try {
            browseHotel = loader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        GridPane gridPane = (GridPane)guide.getChildren().get(0);
        gridPane.getChildren().remove(1);
        gridPane.add(browseHotel,0,1);
    }

    //从登陆界面跳转到搜索酒店界面
    public void changeLoginToSearchHotel(){
        AnchorPane searchHotel = null;
        FXMLLoader guideLoader = UserUIFXMLFactory.getUserUIFXMLFactory().getGuideLoader();
        FXMLLoader searchHotelLoader = UserUIFXMLFactory.getUserUIFXMLFactory().getSearchHotelLoader();
        try {
            guide = guideLoader.load();
            searchHotel = searchHotelLoader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        GridPane gridPane = (GridPane)guide.getChildren().get(0);//单单导航栏界面的AnchorPane只有一个子女
        gridPane.add(searchHotel,0,1);//将搜索酒店界面添加到导航栏界面的gridpane里
        Scene scene = new Scene(guide,800,720);
        stage.setScene(scene);
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

    //从登陆界面跳转到注册界面
    public UserRegisterUIController changeLoginToRegister(){
        FXMLLoader loader = UserUIFXMLFactory.getUserUIFXMLFactory().getUserRegisterLoader();
        AnchorPane userRegister = null;
        try {
            userRegister = loader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        Scene scene = new Scene(userRegister,800,720);
        stage.setScene(scene);
        UserRegisterUIController userRegisterUIController = (UserRegisterUIController)loader.getController();
        return userRegisterUIController;
    }

    //在登陆界面上添加登陆下拉界面（以身份选择界面为背景）
    public BelowLoginUIController addLoginBelow(){
        //加载登陆下拉界面
        FXMLLoader loader = UserUIFXMLFactory.getUserUIFXMLFactory().getLoginBelowLoader();
        AnchorPane belowLogin = null;
        try {
            belowLogin = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //在身份选择界面添加登陆下拉界面
        AnchorPane temp =(AnchorPane) roleChoose.getChildren().get(roleChoose.getChildren().size()-1);
        roleChoose.getChildren().set(roleChoose.getChildren().size()-1,belowLogin);
        roleChoose.getChildren().add(temp);
        //设置登陆下拉在身份选择界面的位置
        Locator.getLocator().setLocation(belowLogin,446.0,223.0,276.0,276.0);
        //设置登陆下拉界面的身份属性
        BelowLoginUIController belowLoginUIController = (BelowLoginUIController)loader.getController();
        return belowLoginUIController;
    }

    //删除登陆下拉界面
    public void removeLoginBelow(){
        int size = roleChoose.getChildren().size();
        roleChoose.getChildren().remove(size-2);
    }

    //在身份选择界面上添加登陆界面
    public LoginUIController addLogin(){
        AnchorPane login = null;
        FXMLLoader loader = UserUIFXMLFactory.getUserUIFXMLFactory().getLoginLoader();
        try {
            login = loader.load();
        }catch (Exception e){
            e.printStackTrace();
        }
        //在身份选择界面添加登陆界面
        roleChoose.getChildren().add(login);
        //设置Login的位置
        Locator.getLocator().setLocation(login,130.0,274.0,276.0,276.0);
        //返回loginuicontroller
        LoginUIController loginUIController = (LoginUIController)loader.getController();
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



}
