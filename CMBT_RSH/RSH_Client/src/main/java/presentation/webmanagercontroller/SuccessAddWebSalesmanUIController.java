package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.WebManagerUIFXMLFactory;

public class SuccessAddWebSalesmanUIController {

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
    	AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
    	manageWebSalesman.getChildren().remove(manageWebSalesman.getChildren().size()-1);
    	//刷新管理网站营销人员界面
    	ManageHotelUIController manageHotelUIController = WebManagerUIFXMLFactory.getInstance().getManageHotelUIController();
    	manageHotelUIController.init();
    }

    public void init(String id,String password) {
		idLabel.setText(id);
		passwordLabel.setText(password);
	}
    
    @FXML
    void initialize() {
        assert iknowButton != null : "fx:id=\"iknowButton\" was not injected: check your FXML file '网管_添加营销人员成功.fxml'.";
        assert idLabel != null : "fx:id=\"idLabel\" was not injected: check your FXML file '网管_添加营销人员成功.fxml'.";
        assert passwordLabel != null : "fx:id=\"passwordLabel\" was not injected: check your FXML file '网管_添加营销人员成功.fxml'.";

    }
}
