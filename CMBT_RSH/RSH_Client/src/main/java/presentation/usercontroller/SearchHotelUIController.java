package presentation.usercontroller;

/**
 * Created by john on 2016/12/4.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import constant.ResultMessage;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import presentation.tools.UserUIFXMLFactory;
import presentation.tools.WebManagerInfoUtil;
import vo.DistrictHelper;
import vo.HotelVO;

public class SearchHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button searchButton;

    @FXML
    private TextField addressField;

    @FXML
    private TextField areaField;
    
    @FXML
    private ComboBox<String> provinceCombox;

    @FXML
    private ComboBox<String> areaCombox;

    @FXML
    private ComboBox<String> cityCombox;
    
    @FXML
    private Label messageLabel;
    @FXML
    private AnchorPane loadingAnchorPane;
    @FXML
    private ImageView loadingImage;


    @FXML
    void toSetArea(ActionEvent event) {
    	areaCombox.getItems().clear();
    	String province = provinceCombox.getValue();
    	String city = cityCombox.getValue();
    	if(province!=null&&city!=null){
    		ArrayList<String> districts = WebManagerInfoUtil.getInstance().getDistricts(province, city);
        	ObservableList<String> districtItems = FXCollections.observableArrayList(districts);
        	areaCombox.setItems(districtItems);
    	}
    	
    }

    @FXML
    void toSetCity(ActionEvent event) {
    	cityCombox.getItems().clear();
    	areaCombox.getItems().clear();
    	String province = provinceCombox.getValue();
    	ArrayList<String> citys = WebManagerInfoUtil.getInstance().getCitys(province);
    	ObservableList<String> cityItems = FXCollections.observableArrayList(citys);
    	cityCombox.setItems(cityItems);
    }

    
    @FXML
    void changeToHotelBrowse(ActionEvent event) {
        myChangeToHotelBrowse();
    }

    @FXML
    void changeToHotelBrowseByButton(MouseEvent event) {
        myChangeToHotelBrowse();

    }

	private void myChangeToHotelBrowse() {
		messageLabel.setVisible(false);
		boolean rightInput = true;
		String province = provinceCombox.getValue();
    	String city = cityCombox.getValue();
    	String district = areaCombox.getValue();
    	if(province==null||city==null||district==null){
    		rightInput = false;
    	}
    	if(!rightInput){
    		messageLabel.setVisible(true);
    	}else {
    		messageLabel.setVisible(false);
    		loadingImage.setVisible(true);
    		UserInfoUtil.getInstance().setHotelAreaAndAddress(province,city,district);
    		//跳转到加载界面
    		UIJumpTool.getUiJumpTool().changeToLoading();
    		
//    		UIJumpTool.getUiJumpTool().changeSearchHotelToBrowseHotel();
		}
		
	}
	
	public void init() {
		ArrayList<String> provinces = DistrictHelper.getProvinces();
		ObservableList<String> provinceItems = FXCollections.observableArrayList(provinces);
		provinceCombox.setItems(provinceItems);
	}

    @FXML
    void initialize() {
        assert searchButton != null : "fx:id=\"searchButton\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert addressField != null : "fx:id=\"addressField\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert areaField != null : "fx:id=\"areaField\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert provinceCombox != null : "fx:id=\"provinceCombox\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert areaCombox != null : "fx:id=\"areaCombox\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert cityCombox != null : "fx:id=\"cityCombox\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '搜索酒店.fxml'.";
        assert loadingAnchorPane != null : "fx:id=\"loadingAnchorPane\" was not injected: check your FXML file '搜索酒店.fxml'.";
        init();
    }
}

