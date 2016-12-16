package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.WebManagerUIFXMLFactory;

public class AboutUsUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label backLabel;

    @FXML
    void backToHomepage(MouseEvent event) {
    	Stage stage = (Stage)backLabel.getScene().getWindow();
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
    void initialize() {
        assert backLabel != null : "fx:id=\"backLabel\" was not injected: check your FXML file '网管_关于我们.fxml'.";

    }
}
