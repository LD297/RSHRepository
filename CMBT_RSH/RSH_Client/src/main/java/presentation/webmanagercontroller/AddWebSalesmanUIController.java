package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.tools.WebManagerUIFXMLFactory;

public class AddWebSalesmanUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button finishAddButon;

    @FXML
    private ImageView cancelImage;

    @FXML
    private TextField passwordField;

    @FXML
    private ComboBox<?> provinceCombox;

    @FXML
    private ComboBox<?> cityCombox;

    @FXML
    private ComboBox<?> districtCombox;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeAddWebsalesman(MouseEvent event) {
    	AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
    	manageWebSalesman.getChildren().remove(manageWebSalesman.getChildren().size()-1);
    }

    @FXML
    void finishAdd(MouseEvent event) {
    	//TODO 刷新管理网站营销人员界面
    	AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
    	manageWebSalesman.getChildren().remove(manageWebSalesman.getChildren().size()-1);
    	AnchorPane successAddWebSalesman = WebManagerUIFXMLFactory.getInstance().getSuccessAddWebSalesman();
    	manageWebSalesman.getChildren().add(successAddWebSalesman);
    }

    @FXML
    void toSetCityCombox(ActionEvent event) {

    }

    @FXML
    void toSetDistrict(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert finishAddButon != null : "fx:id=\"finishAddButon\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert provinceCombox != null : "fx:id=\"provinceCombox\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert districtCombox != null : "fx:id=\"districtCombox\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";

    }
}
