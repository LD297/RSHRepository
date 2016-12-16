package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.WebManagerUIFXMLFactory;

/**
 * 管理网站营销人员界面
 * @author john
 *
 */
public class ManafeWebsalesmanUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lastPagelabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private TextField websalesmanIDField;

    @FXML
    private Button addWebSalesmanButton;

    @FXML
    private ImageView backImage;

    public AnchorPane getManageWebSalesman(){
    	return anchorPane;
    }
    
    @FXML
    void backToHomePage(MouseEvent event) {
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

    @FXML
    void changeToAddWebSalesman(MouseEvent event) {

    }

    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToModifyWebsalesman(ActionEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToSpecificPage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert websalesmanIDField != null : "fx:id=\"websalesmanIDField\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert addWebSalesmanButton != null : "fx:id=\"addWebSalesmanButton\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";

    }
}
