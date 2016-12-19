package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.UserUIFXMLFactory;
import presentation.tools.WebManagerUIFXMLFactory;

/**
 * 网管首页
 * @author john
 *
 */
public class ManagerHomepageUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView manageHotelImage;

    @FXML
    private ImageView manageUserImage;

    @FXML
    private ImageView aboutUsImage;

    @FXML
    private ImageView modifyPasswordImage;

    @FXML
    private ImageView manageWebsalesmanImage;

    @FXML
    private ImageView logoutImage;
    
    @FXML
    private AnchorPane anchorPane;

    public AnchorPane getHomepageAnchorPane() {
		return anchorPane;
	}
    
    @FXML
    void changeToAboutUs(MouseEvent event) {
    	Stage stage = (Stage)logoutImage.getScene().getWindow();
    	AnchorPane aboutUs = WebManagerUIFXMLFactory.getInstance().getAboutUs();
    	Scene scene = null;
    	if(aboutUs.getScene()!=null){
    		scene = aboutUs.getScene();
    	}else {
			scene = new Scene(aboutUs,800,720);
		}
    	stage.setScene(scene);
    }

    @FXML
    void changeToManageHotel(MouseEvent event) {
    	Stage stage = (Stage)logoutImage.getScene().getWindow();
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	Scene scene = null;
    	if(manageHotel.getScene()!=null){
    		scene = manageHotel.getScene();
    	}else {
			scene = new Scene(manageHotel,800,720);
		}
    	ManageHotelUIController manageHotelUIController = WebManagerUIFXMLFactory.getInstance().getManageHotelUIController();
    	manageHotelUIController.init();
    	stage.setScene(scene);
    }

    @FXML
    void changeToManageUser(MouseEvent event) {
    	Stage stage = (Stage)logoutImage.getScene().getWindow();
    	AnchorPane manageUser = WebManagerUIFXMLFactory.getInstance().getManageUser();
    	ManageUserUIController manageUserUIController = WebManagerUIFXMLFactory.getInstance().getManageUserUIController();
    	manageUserUIController.init();
    	Scene scene = null;
    	if(manageUser.getScene()!=null){
    		scene = manageUser.getScene();
    	}else {
			scene = new Scene(manageUser,800,720);
		}
    	stage.setScene(scene);
    }

    @FXML
    void changeToManageWebsalesman(MouseEvent event) {
    	Stage stage = (Stage)logoutImage.getScene().getWindow();
    	AnchorPane manageWebsalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
    	ManafeWebsalesmanUIController manafeWebsalesmanUIController = WebManagerUIFXMLFactory.getInstance().getManafeWebsalesmanUIController();
    	manafeWebsalesmanUIController.init();
    	Scene scene = null;
    	if(manageWebsalesman.getScene()!=null){
    		scene = manageWebsalesman.getScene();
    	}else {
			scene = new Scene(manageWebsalesman,800,720);
		}
    	stage.setScene(scene);
    }

    @FXML
    void changeToModifyPassword(MouseEvent event) {
    	AnchorPane modifyOwnPassword = WebManagerUIFXMLFactory.getInstance().getModifyOwnPassword();
    	anchorPane.getChildren().add(modifyOwnPassword);
    }

    @FXML
    void logout(MouseEvent event) {
    	Stage stage  = (Stage)logoutImage.getScene().getWindow();
    	Scene scene = null;
    	AnchorPane roleChoose = UserUIFXMLFactory.getUserUIFXMLFactory().getRoleChoose();
    	if(roleChoose.getScene()!=null){
    		scene = roleChoose.getScene();
    	}else {
			scene = new Scene(roleChoose,800,720);
		}
    	stage.setScene(scene);
    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网管首页 .fxml'.";
    	assert manageHotelImage != null : "fx:id=\"manageHotelImage\" was not injected: check your FXML file '网管首页 .fxml'.";
        assert manageUserImage != null : "fx:id=\"manageUserImage\" was not injected: check your FXML file '网管首页 .fxml'.";
        assert aboutUsImage != null : "fx:id=\"aboutUsImage\" was not injected: check your FXML file '网管首页 .fxml'.";
        assert modifyPasswordImage != null : "fx:id=\"modifyPasswordImage\" was not injected: check your FXML file '网管首页 .fxml'.";
        assert manageWebsalesmanImage != null : "fx:id=\"manageWebsalesmanImage\" was not injected: check your FXML file '网管首页 .fxml'.";
        assert logoutImage != null : "fx:id=\"logoutImage\" was not injected: check your FXML file '网管首页 .fxml'.";
    }
}
