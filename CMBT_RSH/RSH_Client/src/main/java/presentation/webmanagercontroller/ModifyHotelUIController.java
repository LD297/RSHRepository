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
import presentation.tools.WebManagerInfoUtil;
import presentation.tools.WebManagerUIFXMLFactory;
import vo.HotelVO;

/**
 * 网站管理人员修改酒店信息界面
 * @author john
 *
 */
public class ModifyHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hotelNameField;

    @FXML
    private ComboBox<String> provinceComboox;

    @FXML
    private ComboBox<String> districtCombox;

    @FXML
    private ComboBox<String> cityCombox;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneField;

    @FXML
    private ImageView cancelImage;

    @FXML
    private Button finishModifyButton;
    
    @FXML
    private PasswordField passwordField;
    @FXML
    private Label messageLabel;
    private HotelVO hotelVO = null;

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeModifyHotel(MouseEvent event) {
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
    }

    @FXML
    void finishModifyHotel(MouseEvent event) {
    	boolean rightInput = true;
    	String hotelName = hotelNameField.getText().trim();
    	if(hotelName.equals("")){
    		rightInput = false;
    	}
    	String hotelAddress = addressField.getText().trim();
    	if(hotelAddress.equals("")){
    		rightInput = false;
    	}
    	String password = passwordField.getText().trim();
    	if(password.equals("")){
    		rightInput = false;
    	}
    	String phone = phoneField.getText().trim();
    	if(phone.equals("")){
    		rightInput = false;
    	}
    	String province = provinceComboox.getValue();
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
    		hotelVO.addr = hotelAddress;
    		hotelVO.district = WebManagerInfoUtil.getInstance().getDistrictID(province, city, district);
    		hotelVO.name  = hotelName;
    		hotelVO.tel = phone;
    		hotelVO.setPassword(password);
			ResultMessage resultMessage = WebManagerInfoUtil.getInstance().modifyHotel(hotelVO);
			if(resultMessage==ResultMessage.succeed){//修改成功，关闭修改信息界面
				AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
				manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
		    	ManageHotelUIController manageHotelUIController = WebManagerUIFXMLFactory.getInstance().getManageHotelUIController();
		    	manageHotelUIController.init();
		    	
			}
		}
    	
    }

    @FXML
    void toSetCityCombox(ActionEvent event) {
    	cityCombox.setValue("所在市");
    	String province = provinceComboox.getValue();
    	ArrayList<String> citys = WebManagerInfoUtil.getInstance().getCitys(province);
    	ObservableList<String> cityItems = FXCollections.observableArrayList(citys);
    	cityCombox.setItems(cityItems);
    	if(districtCombox.getItems().size()!=0){
    		districtCombox.getItems().clear();
    	}else {
    		districtCombox.setValue("所在区");
		}
    }

    @FXML
    void toSetDistrictCombox(ActionEvent event) {
    	String province = provinceComboox.getValue();
    	String city = cityCombox.getValue();
    	ArrayList<String> districts = WebManagerInfoUtil.getInstance().getDistricts(province, city);
    	ObservableList<String> districtItems = FXCollections.observableArrayList(districts);
    	districtCombox.setItems(districtItems);
    }
    
    public void init(HotelVO hotelVO) {
    	this.hotelVO = hotelVO;
		hotelNameField.setText(hotelVO.getHotelName());
		ArrayList<String> pcd = WebManagerInfoUtil.getInstance().getPCD(hotelVO.getDistrict());
		provinceComboox.setValue(pcd.get(0));
		cityCombox.setValue(pcd.get(1));
		districtCombox.setValue(pcd.get(2));
		ArrayList<String> provinces = WebManagerInfoUtil.getInstance().getProvinces();
		ObservableList<String> provinceItems = FXCollections.observableArrayList(provinces);
		provinceComboox.setItems(provinceItems);
		addressField.setText(hotelVO.getDetailAddress());
		phoneField.setText(hotelVO.getTel());
		passwordField.setText(hotelVO.getPassword());
	}

    @FXML
    void initialize() {
        assert hotelNameField != null : "fx:id=\"hotelNameField\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert provinceComboox != null : "fx:id=\"provinceComboox\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert districtCombox != null : "fx:id=\"districtCombox\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert addressField != null : "fx:id=\"addressField\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert finishModifyButton != null : "fx:id=\"finishModifyButton\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
    }
}
