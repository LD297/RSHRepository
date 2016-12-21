package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelService_Stub;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vo.RoomVO;

public class AddRoomUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField roomPriceTextField;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField roomImageAddressTextField;

    @FXML
    private Label changeRoomImageLabel;

    @FXML
    private ImageView roomImage;

    @FXML
    private Button backButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField roomNumTextField;

    @FXML
    private TextField roomTypeTextField;

    private AnchorPane prePane;

    private HotelService hotelService = new HotelService_Stub();

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        int size = prePane.getChildren().size();
        prePane.getChildren().get(size-2).setVisible(false);
        prePane.getChildren().remove(size-1);
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {
        String type = roomTypeTextField.getText();
        String roomNum = roomNumTextField.getText();
        String roomPrice = roomPriceTextField.getText();

        int num = Integer.valueOf(roomNum);
        double price = Double.valueOf(roomPrice);
        String property = "";

        // 象征性检查一下
        if(type!=null&&num>0&&price>=0){
            if(roomImageAddressTextField.isVisible()){
                String roomImageAddress = roomImageAddressTextField.getText().trim();
            }
            RoomVO newRoom = new RoomVO("", type, num, price, property);
            hotelService.addSpecialRoom(newRoom);
            backButtonClicked(null);
        }
        roomImageAddressTextField.setVisible(false);
    }

    @FXML
    void changeRoomImage(MouseEvent event) {
        roomImageAddressTextField.setVisible(true);
    }

    @FXML
    void initialize() {
        assert roomPriceTextField != null : "fx:id=\"roomPriceTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomImageAddressTextField != null : "fx:id=\"roomImageAddressTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert changeRoomImageLabel != null : "fx:id=\"changeRoomImageLabel\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomImage != null : "fx:id=\"roomImage\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomNumTextField != null : "fx:id=\"roomNumTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomTypeTextField != null : "fx:id=\"roomTypeTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";

    }
}
