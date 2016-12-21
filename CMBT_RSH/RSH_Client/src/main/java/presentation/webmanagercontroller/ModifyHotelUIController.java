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
    private TextField phoneField;

    @FXML
    private ImageView cancelImage;

    @FXML
    private Button finishModifyButton;
    
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
    	
    	String phone = phoneField.getText().trim();
    	if(phone.equals("")){
    		rightInput = false;
    	}
    	
    	if(!rightInput){
    		messageLabel.setText("您有尚未填写的信息");
    	}else {
    		hotelVO.name  = hotelName;
    		hotelVO.tel = phone;
			ResultMessage resultMessage = WebManagerInfoUtil.getInstance().modifyHotel(hotelVO);
			if(resultMessage==ResultMessage.succeed){//修改成功，关闭修改信息界面
				AnchorPane manageHotel = WebManagerUIFXMLFactory.getInstance().getManageHotel();
				manageHotel.getChildren().remove(manageHotel.getChildren().size()-1);
				//刷新酒店浏览界面
		    	ManageHotelUIController manageHotelUIController = WebManagerUIFXMLFactory.getInstance().getManageHotelUIController();
		    	manageHotelUIController.init();
		    	
			}
		}
    	
    }

    
    public void init(HotelVO hotelVO) {
    	this.hotelVO = hotelVO;
		hotelNameField.setText(hotelVO.getHotelName());
		phoneField.setText(hotelVO.getTel());
	}

    @FXML
    void initialize() {
        assert hotelNameField != null : "fx:id=\"hotelNameField\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert phoneField != null : "fx:id=\"phoneField\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert finishModifyButton != null : "fx:id=\"finishModifyButton\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '网管_修改酒店信息.fxml'.";
    }
}
