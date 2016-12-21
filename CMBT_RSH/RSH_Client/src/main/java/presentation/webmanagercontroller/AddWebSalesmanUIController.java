package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import constant.ResultMessage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.webmanagercontrollertools.WebManagerInfoUtil;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
import vo.WebSalesmanVO;

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
    private Label messageLabel;

    @FXML
    private PasswordField passwordField;

    @FXML
    private ComboBox<String> provinceCombox;

    @FXML
    private ComboBox<String> cityCombox;

    @FXML
    private ComboBox<String> districtCombox;
    
    @FXML
    private TextField nameField;

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

  //完成添加，检查是否有未输入的信息
    @FXML
    void finishAdd(MouseEvent event) {
    	boolean rightInput = true;
    	String password = passwordField.getText().trim();
    	if(password.equals("")){
    		rightInput = false;
    	}
    	String name = nameField.getText().trim();
    	if(name.equals("")){
    		rightInput = false;
    	}
    	String province = provinceCombox.getValue();
    	String city = cityCombox.getValue();
    	String district = districtCombox.getValue();
    	if(province==null||city==null||district==null){
    		rightInput = false;
    	}
    
    	if(!rightInput){
    		messageLabel.setText("您有尚未填写的信息");
    	}else {
    		String id = WebManagerInfoUtil.getInstance().getWebSalesmanID();
    		WebSalesmanVO webSalesmanVO = new WebSalesmanVO(id, province, city, district, name);
    		ResultMessage resultMessage = WebManagerInfoUtil.getInstance().addWebSalesman(webSalesmanVO);
    		if(resultMessage==ResultMessage.succeed){//添加成功，弹出提示界面
    			AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
    	    	manageWebSalesman.getChildren().remove(manageWebSalesman.getChildren().size()-1);
    	    	AnchorPane successAddWebSalesman = WebManagerUIFXMLFactory.getInstance().getSuccessAddWebSalesman();
    	    	SuccessAddWebSalesmanUIController successAddWebSalesmanUIController = WebManagerUIFXMLFactory.getInstance().getSuccessAddWebSalesmanUIController();
    	    	successAddWebSalesmanUIController.init(id, password);
    	    	manageWebSalesman.getChildren().add(successAddWebSalesman);
    		}
    	}
    	
    	
    }

    @FXML
    void toSetCityCombox(ActionEvent event) {
    	cityCombox.getItems().clear();
    	districtCombox.getItems().clear();
    	String province = provinceCombox.getValue();
    	ArrayList<String> citys = WebManagerInfoUtil.getInstance().getCitys(province);
    	ObservableList<String> cityItems = FXCollections.observableArrayList(citys);
    	cityCombox.setItems(cityItems);
    }

    @FXML
    void toSetDistrict(ActionEvent event) {
    	districtCombox.getItems().clear();
    	String province = provinceCombox.getValue();
    	String city = cityCombox.getValue();
    	if(province!=null&&city!=null){
    		ArrayList<String> districts = WebManagerInfoUtil.getInstance().getDistricts(province, city);
        	ObservableList<String> districtItems = FXCollections.observableArrayList(districts);
        	districtCombox.setItems(districtItems);
    	}
    	
    }

    public void init() {
    	ArrayList<String> provinces = WebManagerInfoUtil.getInstance().getProvinces();
		ObservableList<String> provinceItems = FXCollections.observableArrayList(provinces);
		provinceCombox.setItems(provinceItems);
	}
    
    @FXML
    void initialize() {
        assert finishAddButon != null : "fx:id=\"finishAddButon\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert provinceCombox != null : "fx:id=\"provinceCombox\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        assert districtCombox != null : "fx:id=\"districtCombox\" was not injected: check your FXML file '网管_添加营销人员.fxml'.";
        init();
    }
}
