package presentation.webmanagercontroller;

import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

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
import presentation.tools.WebManagerUIFXMLFactory;

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
    private ComboBox<?> provinceCombox;

    @FXML
    private ComboBox<?> districtCombox;

    @FXML
    private ComboBox<?> cityCombox;

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

    private Map<String ,ArrayList<String>> proToCityMap = new TreeMap<>();
    private Map<String, ArrayList<String>> cityToDistrictMap = new TreeMap<>();

    @FXML
    void ToSetDistrictCombox(ActionEvent event) {

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

    @FXML
    void finifshAddHotel(MouseEvent event) {
    	//TODO 添加酒店信息，reset 管理酒店界面
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
    	if(!rightInput){
    		messageLabel.setText("您有尚未填写的信息");
    	}
    	AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
    	manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
    	AnchorPane successAddHotel = WebManagerUIFXMLFactory.getInstance().getSuccessAddHotel();
    	manageHotel.getChildren().add(successAddHotel);
    }

    @FXML
    void toSetCityCombox(ActionEvent event) {

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

		ArrayList<String> cityInJiangsu = new ArrayList<>(
				Arrays.asList(new String[] { "南京", "苏州"}));
		ArrayList<String> cityInChejiang = new ArrayList<>(Arrays.asList(new String[] { "杭州",
				"宁波", }));
	
		ArrayList<String> disInNanjing = new ArrayList<>(Arrays.asList(new String[] { "栖霞区",
				"玄武区", "秦淮区", "鼓楼区", "江宁区", "六合区" }));
		ArrayList<String> disInSuzhou = new ArrayList<>(Arrays.asList(new String[] { "栖霞区",
				"玄武区", "秦淮区", "鼓楼区", "江宁区", "六合区" }));
	
    }
}
