package presentation.webmanagercontroller;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

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
import presentation.tools.WebManagerInfoUtil;
import presentation.tools.WebManagerUIFXMLFactory;
import vo.HotelVO;

/**
 * 网站管理人员添加酒店界面
 * @author john
 *
 */
public class AddHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hotelNameField;

    @FXML
    private ComboBox<String> provinceCombox;

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
    private Button finishAddHotel;

    @FXML
    private TextField passwordField;
    
    @FXML
    private Label messageLabel;


    @FXML
    void ToSetDistrictCombox(ActionEvent event) {
    	districtCombox.getItems().clear();
    	String province = provinceCombox.getValue();
    	String city = cityCombox.getValue();
    	if(province!=null&&city!=null){
    		ArrayList<String> districts = WebManagerInfoUtil.getInstance().getDistricts(province, city);
        	ObservableList<String> districtItems = FXCollections.observableArrayList(districts);
        	districtCombox.setItems(districtItems);
    	}
    	
    }

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
    	cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void closeAddHotel(MouseEvent event) {
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
    }

    //完成添加，检查是否有未输入的信息
    @FXML
    void finifshAddHotel(MouseEvent event) {
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
    	
    	String province = provinceCombox.getValue();
    	String city = cityCombox.getValue();
    	String district = districtCombox.getValue();
    	if(province==null||city==null||district==null){
    		rightInput = false;
    	}
    	
    	if(!rightInput){
    		messageLabel.setText("您有尚未填写的信息");
    	}else {
    		String hotelID = WebManagerInfoUtil.getInstance().getHotelID(province, city, district);
			HotelVO hotelVO = new HotelVO(hotelID, null, hotelName, hotelAddress, district,null, null, 0, 0, null);
			ResultMessage resultMessage = WebManagerInfoUtil.getInstance().addHotel(hotelVO);
			if(resultMessage==ResultMessage.succeed){//添加成功，弹出提示界面
				AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
		    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
		    	AnchorPane successAddHotel = WebManagerUIFXMLFactory.getInstance().getSuccessAddHotel();
		    	SuccessAddHotelUIController successAddHotelUIController = WebManagerUIFXMLFactory.getInstance().getSuccessAddHotelUIController();
		    	successAddHotelUIController.init(hotelID, password);
		    	manageHotel.getChildren().add(successAddHotel);
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

    public void init() {
    	ArrayList<String> provinces = WebManagerInfoUtil.getInstance().getProvinces();
		ObservableList<String> provinceItems = FXCollections.observableArrayList(provinces);
		provinceCombox.setItems(provinceItems);
	}
    
    @FXML
    void initialize() {
        assert hotelNameField != null : "fx:id=\"hotelNameField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert provinceCombox != null : "fx:id=\"provinceCombox\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert districtCombox != null : "fx:id=\"districtCombox\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert addressField != null : "fx:id=\"addressField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert finishAddHotel != null : "fx:id=\"finishAddHotel\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert passwordField != null : "fx:id=\"passwordField\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '网管_添加酒店.fxml'.";
        init();
    }
}
