package presentation.usercontroller;

/**
 * Created by john on 2016/12/5.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.UIJumpTool;

public class BrowseHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button selectButton;

    @FXML
    private TextField searchNameField;

    @FXML
    private Label maskLULabel;

    @FXML
    private ImageView lastImageLU;

    @FXML
    private ImageView nextImageLU;

    @FXML
    private Label hotelNameLULabel;

    @FXML
    private Button createOrderLUButton;

    @FXML
    private Label priceLULabel;

    @FXML
    private Label maskLDLabel;

    @FXML
    private ImageView lastImageLD;

    @FXML
    private ImageView nextImageLD;

    @FXML
    private Label hotelNameLDLabel;

    @FXML
    private Button createOrderLDButton;

    @FXML
    private Label priceLDLabel;

    @FXML
    private Label maskRULabel;

    @FXML
    private ImageView lastImageRU;

    @FXML
    private ImageView nextImageRU;

    @FXML
    private Label hotelNameRULabel;

    @FXML
    private Button createOrderRUButton;

    @FXML
    private Label priceRULabel;

    @FXML
    private Label maskRDLabel;

    @FXML
    private ImageView lastImageRD;

    @FXML
    private ImageView nextImageRD;

    @FXML
    private Label hotelNameRDLabel;

    @FXML
    private Button createOrderRDButton;

    @FXML
    private Button searchByNameButton;

    @FXML
    private Label priceRDLabel;

    @FXML
    private Label lastPageLabel;

    @FXML
    private Label nextPageLable;

    @FXML
    private TextField pageField;

    @FXML
    private Label maskLabel;


    //点击图片上蒙的label跳转到酒店详情界面
    @FXML
    void changeToHotelInfo(MouseEvent event) {
        Label label = (Label) event.getSource();
        String hotelName = "";
        if(label==maskLULabel){
            hotelName = hotelNameLULabel.getText().trim();
        }else if(label==maskLDLabel){
            hotelName = hotelNameLDLabel.getText().trim();
        }else if(label==maskRDLabel){
            hotelName = hotelNameRDLabel.getText().trim();
        }else {
            hotelName = hotelNameRULabel.getText().trim();
        }
        UIJumpTool.getUiJumpTool().changeBrowseHotelToHotelInfo(hotelName);
    }

    @FXML
    void changeToLastImage(MouseEvent event) {

    }

    @FXML
    void changeToLastPage(MouseEvent event) {

    }

    @FXML
    void changeToNextImage(MouseEvent event) {

    }

    @FXML
    void changeToNextPage(MouseEvent event) {

    }

    @FXML
    void changeToReferedPage(ActionEvent event) {

    }

    //点击筛选条件按钮，跳出筛选条件界面
    @FXML
    void changeToSelectCondition(MouseEvent event) {
        maskLabel.setVisible(true);
        UIJumpTool.getUiJumpTool().changeToSelectCondition();
    }

    //点击新建订单，跳转到新建订单界面
    @FXML
    void createOrder(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToCreateOrder();
    }

    @FXML
    void searchByName(ActionEvent event) {

    }

    public void setMaskLabel(boolean visible){maskLabel.setVisible(visible);}

    @FXML
    void initialize() {
        assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert searchNameField != null : "fx:id=\"searchNameField\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert searchByNameButton != null : "fx:id=\"searchByNameButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert maskLULabel != null : "fx:id=\"maskLULabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert lastImageLU != null : "fx:id=\"lastImageLU\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert nextImageLU != null : "fx:id=\"nextImageLU\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert hotelNameLULabel != null : "fx:id=\"hotelNameLULabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert createOrderLUButton != null : "fx:id=\"createOrderLUButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert priceLULabel != null : "fx:id=\"priceLULabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert maskLDLabel != null : "fx:id=\"maskLDLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert lastImageLD != null : "fx:id=\"lastImageLD\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert nextImageLD != null : "fx:id=\"nextImageLD\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert hotelNameLDLabel != null : "fx:id=\"hotelNameLDLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert createOrderLDButton != null : "fx:id=\"createOrderLDButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert priceLDLabel != null : "fx:id=\"priceLDLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert maskRULabel != null : "fx:id=\"maskRULabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert lastImageRU != null : "fx:id=\"lastImageRU\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert nextImageRU != null : "fx:id=\"nextImageRU\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert hotelNameRULabel != null : "fx:id=\"hotelNameRULabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert createOrderRUButton != null : "fx:id=\"createOrderRUButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert priceRULabel != null : "fx:id=\"priceRULabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert maskRDLabel != null : "fx:id=\"maskRDLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert lastImageRD != null : "fx:id=\"lastImageRD\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert nextImageRD != null : "fx:id=\"nextImageRD\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert hotelNameRDLabel != null : "fx:id=\"hotelNameRDLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert createOrderRDButton != null : "fx:id=\"createOrderRDButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert priceRDLabel != null : "fx:id=\"priceRDLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert lastPageLabel != null : "fx:id=\"lastPageLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert nextPageLable != null : "fx:id=\"nextPageLable\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
        assert maskLabel != null : "fx:id=\"maskLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
    }
}
