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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.tools.WebManagerUIFXMLFactory;

public class ManageHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridpaneFilledWithHotel;

    @FXML
    private Label lastPagelabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private TextField hotelIDField;

    @FXML
    private Button addHotelButton;

    @FXML
    private ImageView backImage;

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

    @FXML
    void changeToAddHotel(MouseEvent event) {

    }

    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToModifyHotelInfo(ActionEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToSpecificPage(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert gridpaneFilledWithHotel != null : "fx:id=\"gridpaneFilledWithHotel\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert hotelIDField != null : "fx:id=\"hotelIDField\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert addHotelButton != null : "fx:id=\"addHotelButton\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网管_管理酒店.fxml'.";

    }
}
