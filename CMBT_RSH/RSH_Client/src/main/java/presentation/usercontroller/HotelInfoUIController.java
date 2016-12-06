package presentation.usercontroller;

/**
 * Created by john on 2016/12/6.
 */


import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import presentation.tools.UIJumpTool;

public class HotelInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView hotelImage;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private Label addressLabel;

    @FXML
    private Label briefLabel;

    @FXML
    private ImageView wifiImage;

    @FXML
    private Label wifiLabel;

    @FXML
    private ImageView swimpoolImage;

    @FXML
    private Label swimLabel;

    @FXML
    private ImageView parkImage;

    @FXML
    private Label parkLabel;

    @FXML
    private ImageView diningroomImage;

    @FXML
    private Label diningroomLabel;

    @FXML
    private Button createOrderButton;

    @FXML
    private Label startLevelLabel;

    @FXML
    private Label gradeLabel;

    @FXML
    private Rectangle roomInfoEffect;

    @FXML
    private Rectangle commentEffect;

    @FXML
    private Button roonInfoButton;

    private boolean isRoomInfo = true;

    @FXML
    void changeToComment(MouseEvent event) {
        commentEffect.setVisible(false);
        isRoomInfo = false;
        roomInfoEffect.setVisible(true);
        UIJumpTool.getUiJumpTool().changeToComment();
    }

    @FXML
    void changeToRoomInfo(MouseEvent event) {
        roomInfoEffect.setVisible(false);
        isRoomInfo = true;
        commentEffect.setVisible(true);
        UIJumpTool.getUiJumpTool().changeToRoomInfo();
    }

    @FXML
    void commentEntered(MouseEvent event) {
        commentEffect.setVisible(false);
    }

    @FXML
    void commentExited(MouseEvent event) {
        if(isRoomInfo){
            commentEffect.setVisible(true);
        }
    }

    @FXML
    void roomInfoEntered(MouseEvent event) {
        roomInfoEffect.setVisible(false);
    }

    @FXML
    void roomInfoExited(MouseEvent event) {
        if(!isRoomInfo){
            roomInfoEffect.setVisible(true);
        }

    }

    @FXML
    void initialize() {
        assert hotelImage != null : "fx:id=\"hotelImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert hotelNameLabel != null : "fx:id=\"hotelNameLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert addressLabel != null : "fx:id=\"addressLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert briefLabel != null : "fx:id=\"briefLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert wifiImage != null : "fx:id=\"wifiImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert wifiLabel != null : "fx:id=\"wifiLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert swimpoolImage != null : "fx:id=\"swimpoolImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert swimLabel != null : "fx:id=\"swimLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert parkImage != null : "fx:id=\"parkImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert parkLabel != null : "fx:id=\"parkLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert diningroomImage != null : "fx:id=\"diningroomImage\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert diningroomLabel != null : "fx:id=\"diningroomLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert createOrderButton != null : "fx:id=\"createOrderButton\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert startLevelLabel != null : "fx:id=\"startLevelLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert gradeLabel != null : "fx:id=\"gradeLabel\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert roomInfoEffect != null : "fx:id=\"roomInfoEffect\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert commentEffect != null : "fx:id=\"commentEffect\" was not injected: check your FXML file '酒店详情.fxml'.";
        assert roonInfoButton != null : "fx:id=\"roonInfoButton\" was not injected: check your FXML file '酒店详情.fxml'.";

    }
}
