package presentation.hotelcontroller;

import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.HotelService_Stub;
import constant.HotelInputFeedback;
import constant.ResultMessage;
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
import presentation.hotelcontrollertools.HotelInputCheck;
import presentation.hotelcontrollertools.HotelServiceFactory;
import vo.RoomVO;

public class AddRoomUIController {



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView roomImage;

    @FXML
    private Label roomPricePrompt;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField roomNumTextField;

    @FXML
    private TextField roomPriceTextField;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label roomUrlPrompt;

    @FXML
    private TextField roomImageAddressTextField;

    @FXML
    private Label changeRoomImageLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label roomNumPrompt;

    @FXML
    private Label roomTypePrompt;

    @FXML
    private TextField roomTypeTextField;

    private RoomInfoUIController roomInfoUIController;

    private String hotelId;

    private Label[] prompts;

    private AnchorPane prePane;

    private HotelService hotelService;


    private void clearTextField() {
        roomTypeTextField.clear();
        roomNumTextField.clear();
        roomPriceTextField.clear();
        roomImageAddressTextField.clear();
    }


    @FXML
    void backButtonClicked(MouseEvent event) {
        clearTextField();
        promptsInvisible();
        roomImageAddressTextField.setVisible(false);

        int size = prePane.getChildren().size();
        prePane.getChildren().get(size-2).setVisible(false);
        roomInfoUIController.refreshPage();
        prePane.getChildren().remove(size-1);
    }

    private void showPrompt(String inputCheck, Label promt) {
        if (!inputCheck.equals(HotelInputFeedback.LEGAL)) {
            promt.setVisible(true);
            promt.setText(inputCheck);
        }
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {

        promptsInvisible();

        String type = roomTypeTextField.getText();
        String roomNum = roomNumTextField.getText();
        String roomPrice = roomPriceTextField.getText();

        String inputCheck = "";

        inputCheck = HotelInputCheck.checkRoomType(type);
        showPrompt(inputCheck, roomTypePrompt);

        inputCheck = HotelInputCheck.checkRoomNum(roomNum);
        showPrompt(inputCheck, roomNumPrompt);

        inputCheck = HotelInputCheck.checkPrice(roomPrice);
        showPrompt(inputCheck, roomPricePrompt);

        if(roomImageAddressTextField.isVisible()){
            String roomImageAddress = roomImageAddressTextField.getText();
            inputCheck = HotelInputCheck.checkURL(roomImageAddress);
            showPrompt(inputCheck, roomUrlPrompt);
        }

        int numOfInput = 3;
        if(roomImageAddressTextField.isVisible())
            numOfInput = 4;

        boolean isInputLegal = true;
        for(int i=0; i<numOfInput; i++){
            if(prompts[i].isVisible()){
                isInputLegal =false;
                break;
            }
        }
        if(isInputLegal){
            String roomImageAddress = "/images/默认房间图片.jpg";
            if(roomImageAddressTextField.isVisible()){
                 roomImageAddress = roomImageAddressTextField.getText().trim();
            }
            RoomVO newRoom = new RoomVO(hotelId, type, Integer.valueOf(roomNum),
                    Double.valueOf(roomPrice), roomImageAddress);
            ResultMessage rm = hotelService.addSpecialRoom(newRoom);
            if(!rm.equals(ResultMessage.succeed))
            promptsInvisible();
            backButtonClicked(null);
        } else
            return;
    }

    @FXML
    void changeRoomImage(MouseEvent event) {
        roomImageAddressTextField.setVisible(true);
    }

    @FXML
    void initialize() {
        assert roomImage != null : "fx:id=\"roomImage\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomPricePrompt != null : "fx:id=\"roomPricePrompt\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomNumTextField != null : "fx:id=\"roomNumTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomPriceTextField != null : "fx:id=\"roomPriceTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomUrlPrompt != null : "fx:id=\"roomUrlPrompt\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomImageAddressTextField != null : "fx:id=\"roomImageAddressTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert changeRoomImageLabel != null : "fx:id=\"changeRoomImageLabel\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomNumPrompt != null : "fx:id=\"roomNumPrompt\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomTypePrompt != null : "fx:id=\"roomTypePrompt\" was not injected: check your FXML file '添加客房界面.fxml'.";
        assert roomTypeTextField != null : "fx:id=\"roomTypeTextField\" was not injected: check your FXML file '添加客房界面.fxml'.";

        roomImageAddressTextField.setVisible(false);
        setPrompts();
        promptsInvisible();
        initializeService();
    }
    private void setPrompts(){
        prompts = new Label[]{roomTypePrompt, roomNumPrompt, roomPricePrompt, roomUrlPrompt};
    }
    private void promptsInvisible() {
        for(int i=0; i<prompts.length; i++)
            prompts[i].setVisible(false);
    }
    private void initializeService() {
        this.hotelService = HotelServiceFactory.getInstance().getHotelService();
    }

    /**
     *
     * @param roomInfoUIController
     */
    public void setRoomInfoUIController(RoomInfoUIController roomInfoUIController) {
        this.roomInfoUIController = roomInfoUIController;
    }

    /**
     *
     * @param prePane
     */
    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    /**
     *
     * @param hotelId
     */
    public void setHotelId(String hotelId){this.hotelId = hotelId;}

}
