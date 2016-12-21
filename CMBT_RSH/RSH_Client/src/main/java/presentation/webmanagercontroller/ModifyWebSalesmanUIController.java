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
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import presentation.tools.ImageFactory;
import presentation.webmanagercontrollertools.WebManagerInfoUtil;
import presentation.webmanagercontrollertools.WebManagerUIFXMLFactory;
import vo.WebSalesmanVO;

/**
 * 网站管理人员修改营销人员信息界面
 * @author john
 *
 */
public class ModifyWebSalesmanUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button finishModifyButton;

    @FXML
    private ImageView cancelImage;

    @FXML
    private ComboBox<String> provinceCombox;

    @FXML
    private ComboBox<String> cityCombox;

    @FXML
    private ComboBox<String> districtCombox;

    @FXML
    private Label messageLabel;
    
    @FXML
    private TextField nameField;

    private WebSalesmanVO webSalesmanVO = null;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeModifyWebSalesman(MouseEvent event) {
    	AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
    	manageWebSalesman.getChildren().remove(manageWebSalesman.getChildren().size()-1);
    }

    @FXML
    void finishModify(MouseEvent event) {
    	//TODO 更新信息，reset管理营销人员界面
    	boolean rightInput = true;
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
    	if(province!=null){
    		if(province.equals("所在省")){
    			rightInput = false;
    		}
    	}
    	if(city!=null){
    		if(city.equals("所在市")){
    			rightInput = false;
    		}
    	}
    	if(district!=null){
    		if(district.equals("所在区")){
    			rightInput = false;
    		}
    	}
    	if(!rightInput){
    		messageLabel.setText("您有尚未填写的信息");
    	}else {
    		webSalesmanVO.setDistrict(province, city, district);
    		webSalesmanVO.setName(name);
    		ResultMessage resultMessage = WebManagerInfoUtil.getInstance().modifyWebSalesman(webSalesmanVO);
			if(resultMessage==ResultMessage.succeed){
				AnchorPane manageWebSalesman = WebManagerUIFXMLFactory.getInstance().getManageWebSalesman();
				ManafeWebsalesmanUIController manafeWebsalesmanUIController = WebManagerUIFXMLFactory.getInstance().getManafeWebsalesmanUIController();
				manafeWebsalesmanUIController.init();
	        	manageWebSalesman.getChildren().remove(manageWebSalesman.getChildren().size()-1);
			}
    	}
    	

    }

    @FXML
    void toSetCityCombox(ActionEvent event) {
    	cityCombox.getItems().clear();
    	cityCombox.setValue("所在市");
    	districtCombox.getItems().clear();
    	districtCombox.setValue("所在区");
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
    	if(province!=null&&city!=null&&!province.equals("所在省")&&!city.equals("所在市")){
    		ArrayList<String> districts = WebManagerInfoUtil.getInstance().getDistricts(province, city);
        	ObservableList<String> districtItems = FXCollections.observableArrayList(districts);
        	districtCombox.setItems(districtItems);
    	}
    }

    public void init(WebSalesmanVO webSalesmanVO) {
    	this.webSalesmanVO = webSalesmanVO;
		provinceCombox.setValue(webSalesmanVO.getProvince());
		cityCombox.setValue(webSalesmanVO.getCity());
		districtCombox.setValue(webSalesmanVO.getArea());
		ArrayList<String> provinces = WebManagerInfoUtil.getInstance().getProvinces();
		ObservableList<String> provinceItems = FXCollections.observableArrayList(provinces);
		provinceCombox.setItems(provinceItems);
		nameField.setText(webSalesmanVO.getName());
	}
    
    @FXML
    void initialize() {
        assert finishModifyButton != null : "fx:id=\"finishModifyButton\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";
        assert provinceCombox != null : "fx:id=\"provinceCombox\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";
        assert districtCombox != null : "fx:id=\"districtCombox\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";
        assert nameField != null : "fx:id=\"nameField\" was not injected: check your FXML file '网管_修改营销人员信息.fxml'.";

    }
}
