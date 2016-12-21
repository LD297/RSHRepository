package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;

public class SuccessAddHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button iknowButton;

    @FXML
    private Label idLabel;

    @FXML
    private Label passwordLabel;

    @FXML
    void closeSuccessAdd(MouseEvent event) {
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
    	ManageHotelUIController manageHotelUIController = WebManagerUIFXMLFactory.getInstance().getManageHotelUIController();
    	manageHotelUIController.init();
    }
    
    public void init(String hotelID,String password) {
		idLabel.setText(hotelID);
		passwordLabel.setText(password);
	}

    @FXML
    void initialize() {
        assert iknowButton != null : "fx:id=\"iknowButton\" was not injected: check your FXML file '网管_添加成功.fxml'.";
        assert idLabel != null : "fx:id=\"idLabel\" was not injected: check your FXML file '网管_添加成功.fxml'.";
        assert passwordLabel != null : "fx:id=\"passwordLabel\" was not injected: check your FXML file '网管_添加成功.fxml'.";
       
    }
}
