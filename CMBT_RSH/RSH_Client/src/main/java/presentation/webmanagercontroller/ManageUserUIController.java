package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

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
        assert gridpaneFilledWithUser != null : "fx:id=\"gridpaneFilledWithUser\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        init();
    }
}
