package presentation.tools;

import javafx.fxml.FXMLLoader;

/**
 * Created by john on 2016/12/5.
 */
public class UserUIFXMLFactory {
    private static UserUIFXMLFactory userUIFXMLFactory = null;
    private UserUIFXMLFactory(){}

    public static UserUIFXMLFactory getUserUIFXMLFactory() {
        if(userUIFXMLFactory==null){
            userUIFXMLFactory = new UserUIFXMLFactory();
        }
        return userUIFXMLFactory;
    }

    public FXMLLoader getRoleChooseLoader(){return new FXMLLoader(getClass().getResource("/fxml/身份选择.fxml"));}

    public FXMLLoader getGuideLoader() {
        return new FXMLLoader(getClass().getResource("/fxml/导航栏.fxml"));
    }

    public FXMLLoader getSearchHotelLoader() {
        return new FXMLLoader(getClass().getResource("/fxml/搜索酒店.fxml"));
    }

    public FXMLLoader getLoginBelowLoader() {
        return new FXMLLoader(getClass().getResource("/fxml/登陆下拉.fxml"));
    }

    public FXMLLoader getBrowseHotelLoader() {
        return new FXMLLoader(getClass().getResource("/fxml/酒店浏览（用户视角）.fxml"));
    }

    public FXMLLoader getUserRegisterLoader() {
        return new FXMLLoader(getClass().getResource("/fxml/用户注册.fxml"));
    }

    public FXMLLoader getLoginLoader() {
        return new FXMLLoader(getClass().getResource("/fxml/登陆.fxml"));
    }

}
