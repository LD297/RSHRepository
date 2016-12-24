package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/5.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import constant.HotelInputFeedback;
import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelInputCheck;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import vo.HotelVO;

public class HotelBasicInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField hotelNameTextField;

    @FXML
    private Label checkInLabel;

    @FXML
    private TextField imageUrlTextField;

    @FXML
    private ImageView parkImage;

    @FXML
    private TextArea briefIntroTextArea;

    @FXML
    private CheckBox canteeCheckBox;

    @FXML
    private Label addressLabel;

    @FXML
    private ImageView wifiImage;

    @FXML
    private Button confirmButton;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox parkCheckBox;

    @FXML
    private Label hotelNameLabel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label startLevelLabel;

    @FXML
    private Label IDLabel;

    @FXML
    private CheckBox swimmingPoolCheckBox;

    @FXML
    private Label telLabel;

    @FXML
    private Label gradeLabel;

    @FXML
    private Text parkText;

    @FXML
    private ImageView hotelImage;

    @FXML
    private Text swimmingPoolText;

    @FXML
    private TextField levelTextField;

    @FXML
    private Label briefLabel;

    @FXML
    private ImageView diningroomImage;

    @FXML
    private Text canteenText;

    @FXML
    private Text roomInfoText;

    @FXML
    private TextField checkInTextField;

    @FXML
    private TextField priceTextField;

    @FXML
    private CheckBox wifiCheckBox;

    @FXML
    private Text wifiText;

    @FXML
    private ImageView swimpoolImage;

    @FXML
    private ImageView editImage;

    @FXML
    private Label hotelNamePrompt;

    @FXML
    private Label levelPrompt;

    @FXML
    private Label timePrompt;

    @FXML
    private Label pricePrompt;

    @FXML
    private Label urlPrompt;

    @FXML
    private Label briefIntroPrompt;


    private AnchorPane prePane;
    private HotelService hotelService;
    private String hotelId;
    // 从数据库加载的酒店原始信息
    private HotelVO hotelVO;
    // 客房信息维护界面根结点
    private AnchorPane roomInfoUIPane;
    // 客房信息维护界面控制器
    private RoomInfoUIController roomInfoUIController;
    // 该界面是否可编辑
    boolean editable = false;

    Text[] facilitiyText;
    CheckBox[] facilityCheckBox;
    Label[] prompts;

    private void promptsInvisible() {
        for (int i = 0; i < prompts.length; i++) {
            prompts[i].setVisible(false);
        }
    }

    @FXML
    void editHotelName(MouseEvent event) {
        if (!editable)
            hotelNameTextField.setEditable(false);
        else
            hotelNameTextField.setEditable(true);
    }

    @FXML
    void editLevel(MouseEvent event) {
        if (!editable)
            levelTextField.setEditable(false);
        else
            levelTextField.setEditable(true);
    }

    @FXML
    void editCheckIn(MouseEvent event) {
        if (!editable)
            checkInTextField.setEditable(false);
        else
            checkInTextField.setEditable(true);
    }

    @FXML
    void editBriefIntro(MouseEvent event) {
        if (!editable)
            briefIntroTextArea.setEditable(false);
        else
            briefIntroTextArea.setEditable(true);
    }

    @FXML
    void editWifi(MouseEvent event) {
        if (!editable) {
            if (!wifiCheckBox.isSelected())
                wifiCheckBox.setSelected(false);
            else
                wifiCheckBox.setSelected(true);
        }
    }

    @FXML
    void editSwimmingPool(MouseEvent event) {
        if (!editable) {
            if (!swimmingPoolCheckBox.isSelected())
                swimmingPoolCheckBox.setSelected(false);
            else
                swimmingPoolCheckBox.setSelected(true);
        }
    }

    @FXML
    void editPark(MouseEvent event) {
        if (!editable) {
            if (!parkCheckBox.isSelected())
                parkCheckBox.setSelected(false);
            else
                parkCheckBox.setSelected(true);
        }

    }

    @FXML
    void editCanteen(MouseEvent event) {
        if (!editable) {
            if (!canteeCheckBox.isSelected())
                canteeCheckBox.setSelected(false);
            else
                canteeCheckBox.setSelected(true);
        }

    }

    @FXML
    void editImageClicked(MouseEvent event) {
        promptsInvisible();
        editable = true;

    }

    private void showPrompt(String inputCheck, Label promt) {
        if (!inputCheck.equals(HotelInputFeedback.LEGAL)) {
            promt.setVisible(true);
            promt.setText(inputCheck);
        }
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {
        if(editable){
            promptsInvisible();
            String inputCheck = "";

            String name = hotelNameTextField.getText();
            inputCheck = HotelInputCheck.checkHotelName(name);
            showPrompt(inputCheck, hotelNamePrompt);

            String level = levelTextField.getText();
            inputCheck = HotelInputCheck.checkLevel(level);
            showPrompt(inputCheck, levelPrompt);

            String checkIn = checkInTextField.getText();
            inputCheck = HotelInputCheck.checkTime(checkIn);
            showPrompt(inputCheck, timePrompt);

            String price = priceTextField.getText();
            inputCheck = HotelInputCheck.checkPrice(price);
            showPrompt(inputCheck, pricePrompt);

            String url = imageUrlTextField.getText().trim();
            inputCheck = HotelInputCheck.checkURL(url);
            showPrompt(inputCheck, urlPrompt);

            String briefIntro = briefIntroTextArea.getText();
            inputCheck = HotelInputCheck.checkBriefIntro(briefIntro);
            showPrompt(inputCheck, briefIntroPrompt);

            boolean isInputLegal = true;
            for (int i = 0; i < prompts.length; i++) {
                if (prompts[i].isVisible()) {
                    isInputLegal = false;
                    break;
                }
            }
            if (isInputLegal) {
                String facility = "";
                for (int i = 0; i < facilityCheckBox.length; i++) {
                    if (facilityCheckBox[i].isSelected())
                        facility += 1;
                    else
                        facility += 0;
                }
                hotelVO.setName(name);
                hotelVO.setLevel(Integer.valueOf(level));
                hotelVO.setFacility(facility);
                hotelVO.setLatestCheckInTime(checkIn);
                hotelVO.setStandardRoomPrice(Double.valueOf(price));
                hotelVO.setImageAddress(url);
                hotelVO.setBriefIntro(briefIntro);
                ResultMessage resultMessage = hotelService.updateHotel(hotelVO);
                if (!resultMessage.equals(ResultMessage.succeed))
                    System.out.println("酒店信息更新失败！");
                refreshPage();
            } else {
                return;
            }
        }
    }

    @FXML
    void editImageUrl(MouseEvent event) {
        if (!editable)
            imageUrlTextField.setEditable(false);
        else
            imageUrlTextField.setEditable(true);
    }

    @FXML
    void editPrice(MouseEvent event) {
        if (!editable)
            priceTextField.setEditable(false);
        else
            priceTextField.setEditable(true);
    }

    @FXML
    void changeToRoomInfoUI(MouseEvent event) {
        // 加载客房信息维护界面
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getRoomInfoUILoader();
        // 加载客房信息维护界面根结点
        if (roomInfoUIPane == null)
            try {
                roomInfoUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到客房信息维护界面控制器
        if (roomInfoUIController == null)
            roomInfoUIController = loader.getController();
        roomInfoUIController.setRoomInfoUIController(roomInfoUIController);
        // 传入酒店信息维护界面根结点
        roomInfoUIController.setPrePane(anchorPane);
        // 配置hotelService
        roomInfoUIController.setHotelService(hotelService);
        roomInfoUIController.setHotelId(hotelId);
        roomInfoUIController.refreshPage();

        Scene scene = null;
        if (roomInfoUIPane.getScene() == null)
            scene = new Scene(roomInfoUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = roomInfoUIPane.getScene();

        Stage stage = (Stage) anchorPane.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        editable = false;
        ((Stage) anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert hotelNameTextField != null : "fx:id=\"hotelNameTextField\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert checkInLabel != null : "fx:id=\"checkInLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert imageUrlTextField != null : "fx:id=\"imageUrlTextField\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert parkImage != null : "fx:id=\"parkImage\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert canteeCheckBox != null : "fx:id=\"canteeCheckBox\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert briefIntroPrompt != null : "fx:id=\"briefIntroPrompt\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert addressLabel != null : "fx:id=\"addressLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert wifiImage != null : "fx:id=\"wifiImage\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert parkCheckBox != null : "fx:id=\"parkCheckBox\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert hotelNameLabel != null : "fx:id=\"hotelNameLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert startLevelLabel != null : "fx:id=\"startLevelLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert IDLabel != null : "fx:id=\"IDLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert urlPrompt != null : "fx:id=\"urlPrompt\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert priceTextField != null : "fx:id=\"priceTextField\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert swimmingPoolCheckBox != null : "fx:id=\"swimmingPoolCheckBox\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert telLabel != null : "fx:id=\"telLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert timePrompt != null : "fx:id=\"timePrompt\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert gradeLabel != null : "fx:id=\"gradeLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert parkText != null : "fx:id=\"parkText\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert roomInfoText != null : "fx:id=\"roomInfoText\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert hotelNamePrompt != null : "fx:id=\"hotelNamePrompt\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert hotelImage != null : "fx:id=\"hotelImage\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert swimmingPoolText != null : "fx:id=\"swimmingPoolText\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert levelTextField != null : "fx:id=\"levelTextField\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert briefLabel != null : "fx:id=\"briefLabel\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert diningroomImage != null : "fx:id=\"diningroomImage\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert canteenText != null : "fx:id=\"canteenText\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert pricePrompt != null : "fx:id=\"pricePrompt\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert checkInTextField != null : "fx:id=\"checkInTextField\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert wifiCheckBox != null : "fx:id=\"wifiCheckBox\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert wifiText != null : "fx:id=\"wifiText\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert swimpoolImage != null : "fx:id=\"swimpoolImage\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert editImage != null : "fx:id=\"editImage\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert levelPrompt != null : "fx:id=\"levelPrompt\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";
        assert briefIntroTextArea != null : "fx:id=\"briefIntroTextArea\" was not injected: check your FXML file '酒店信息维护界面.fxml'.";

        setFacilityText();
        setFacilityCheckBox();
        setPrompts();

    }

    private void setFacilityText() {
        facilitiyText = new Text[]{wifiText, swimmingPoolText, parkText, canteenText};

    }

    private void setFacilityCheckBox() {
        facilityCheckBox = new CheckBox[]{wifiCheckBox, swimmingPoolCheckBox,
                parkCheckBox, canteeCheckBox};
    }

    private void setPrompts() {
        prompts = new Label[]{hotelNamePrompt, levelPrompt, timePrompt, pricePrompt,
                urlPrompt, briefIntroPrompt};
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }

    public void setHotelService(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public void setHotelVO() {
        this.hotelVO = hotelService.getHotelInfo(hotelId);
    }

    public void refreshPage() {

        promptsInvisible();
        setHotelVO();

        Image image = new Image(hotelVO.getImageAddress());
        hotelImage.setImage(image);
        IDLabel.setText(hotelVO.getHotelID());

        hotelNameTextField.setText(hotelVO.getHotelName());
        hotelNameLabel.setText(hotelVO.getHotelName());

        startLevelLabel.setText(hotelVO.getLevel() + "");
        levelTextField.setText(hotelVO.getLevel() + "");

        gradeLabel.setText(hotelVO.getGrade() + "");
        addressLabel.setText(hotelVO.getFullAddress());

        for (int i = 0; i < facilitiyText.length; i++) {
            if (hotelVO.getFacility().charAt(i) == '0') {
                facilitiyText[i].setStrikethrough(true);
                facilityCheckBox[i].setSelected(false);
            } else {
                facilitiyText[i].setStrikethrough(false);
                facilityCheckBox[i].setSelected(true);
            }
        }

        checkInLabel.setText(hotelVO.getLatestCheckInTime());
        checkInTextField.setText(hotelVO.getLatestCheckInTime());

        briefLabel.setText(hotelVO.getBriefIntro());
        briefIntroTextArea.setText(hotelVO.getBriefIntro());

    }
}
