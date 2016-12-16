package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
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
    private Button backButton;

    @FXML
    private Button confirmButton;

    @FXML
    private CheckBox basicCheckBox;

    @FXML
    private CheckBox specialCheckBox;

    @FXML
    private TextField roomNumTextField;

    @FXML
    private TextField roomTypeTextField;

    @FXML
    private AnchorPane anchorPane;

    private AnchorPane prePane;

    private boolean isBasicSelectable = true;

    private boolean isSpecialSelectable = true;

    private boolean isBasic = false;

    private boolean isSpecial = false;

    private HotelService hotelService;

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    @FXML
    void basicCheckBoxListener(ActionEvent event){
        if(isBasicSelectable){
            if(basicCheckBox.isSelected()){
                basicCheckBox.setSelected(true);
                isBasic = true;
                isSpecialSelectable = false;
            } else {
                basicCheckBox.setSelected(false);
                isBasic = false;
                isSpecialSelectable = true;
            }
        } else
            basicCheckBox.setSelected(false);
    }

    @FXML
    void specialCheckBoxListener(ActionEvent event){
        if(isSpecialSelectable){
            if(specialCheckBox.isSelected()){
                specialCheckBox.setSelected(true);
                isSpecial = true;
                isBasicSelectable = false;
            } else {
                specialCheckBox.setSelected(false);
                isSpecial = false;
                isBasicSelectable = true;
            }
        } else
            specialCheckBox.setSelected(false);
    }
    @FXML
    void backButtonClicked(MouseEvent event) {
        // 这是什么方法？能用吗姐姐？
        ((Stage)anchorPane.getScene().getWindow()).close();
        prePane.getChildren().get(0).setVisible(false);
        ((Stage) prePane.getScene().getWindow()).setScene(prePane.getScene());
    }


    @FXML
    void confirmButtonClicked(MouseEvent event) {
        String type = roomTypeTextField.getText();
        String roomNum = roomNumTextField.getText();
        String roomPrice = roomPriceTextField.getText();

        int num = Integer.parseInt(roomNum);
        double price = Double.parseDouble(roomPrice);
        String property = "";

        if((type!=null&&num>0&&price>=0)&&(isBasic&&!isSpecial)||(!isBasic&&isSpecial)){
            if(isBasic)
                property = "基本";
            if(isSpecial)
                property = "特色";
            RoomVO newRoom = new RoomVO("", type, num, price, property);
            hotelService.addSpecialRoom(newRoom);
            backButtonClicked(null);
        }
    }

    @FXML
    void initialize() {
        assert roomPriceTextField != null : "fx:id=\"roomPriceTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert basicCheckBox != null : "fx:id=\"basicCheckBox\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert specialCheckBox != null : "fx:id=\"specialCheckBox\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomNumTextField != null : "fx:id=\"roomNumTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomTypeTextField != null : "fx:id=\"roomTypeTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '添加客房界面.fxml'.";

    }
}
