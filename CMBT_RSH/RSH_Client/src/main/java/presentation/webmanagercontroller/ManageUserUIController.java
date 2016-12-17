package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.tools.WebManagerUIFXMLFactory;

/**
 * 网站管理人员管理用户信息
 * @author john
 *
 */
public class ManageUserUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridpaneFilledWithUser;

    @FXML
    private Label lastPagelabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private TextField idField;

    @FXML
    private ImageView backImage;

    @FXML
    private AnchorPane anchorPane;

    
    @FXML
    void backToHomepage(MouseEvent event) {
    	Stage stage = (Stage)backImage.getScene().getWindow();
    	Scene scene = null;
    	AnchorPane homepageAnchorPane = WebManagerUIFXMLFactory.getInstance().getManageHomepage();
    	if(homepageAnchorPane.getScene()!=null){
    		scene = homepageAnchorPane.getScene();
    	}else {
			scene = new Scene(homepageAnchorPane,800,720);
		}
    	stage.setScene(scene);
    }
    
    //在输入用户手机号之后按enter键定位到具体一个用户，查看该用户信息
    @FXML
    void changeToCheckUserInfo(ActionEvent event) {
    	AnchorPane checkUserInfo = WebManagerUIFXMLFactory.getInstance().getCheckUserInfo();
    	anchorPane.getChildren().add(checkUserInfo);
    }
    
    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToSpecificPage(ActionEvent event) {

    }

    public void init() {
		
	}
    
    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网管_管理用户.fxml'.";
    	assert gridpaneFilledWithUser != null : "fx:id=\"gridpaneFilledWithUser\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        init();
    }
}
