package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/5.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import bl.hotelservice.HotelService;
import constant.HotelBasicInfoUIFeedback;
import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelBasicInfoUICheck;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import vo.HotelVO;

public class HotelBasicInfoUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextField addressTextField;

    @FXML
    private TextField businessAreaTextField;

    @FXML
    private TextField telTextField;

    @FXML
    private Button editButton;

    @FXML
    private Button backButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField levelTextField;

    @FXML
    private Label gradeLabel;

    @FXML
    private ImageView hotelImage;

    @FXML
    private TextField checkInDDLTextField;

    @FXML
    private Button changeImageButton;

    @FXML
    private TextArea introductionTextArea;

    @FXML
    private Button roomInfoButton;

    @FXML
    private Button confirmButton;

    @FXML
    private TextArea facilityTextArea;

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

    @FXML
    void editButtonClicked(MouseEvent event) {
        editable = true;
    }

    @FXML
    void editHotelName(MouseEvent event){
        if(!editable)
            nameTextField.setEditable(false);
        else
            nameTextField.setEditable(true);

    }

    @FXML
    void editHotelTel(MouseEvent event){
        if(!editable)
            telTextField.setEditable(false);
        else
            telTextField.setEditable(true);
    }

    @FXML
    void editCheckInDDL(MouseEvent event){
        if(!editable)
            checkInDDLTextField.setEditable(false);
        else
            checkInDDLTextField.setEditable(true);
    }

    @FXML
    void editLevel(MouseEvent event){
        if(!editable)
            levelTextField.setEditable(false);
        else
            levelTextField.setEditable(true);
    }

    @FXML
    void editAddress(MouseEvent event){
        if(!editable)
            addressTextField.setEditable(false);
        else
            addressTextField.setEditable(true);
    }

    @FXML
    void editBusinessArea(MouseEvent event){
        if(!editable)
            businessAreaTextField.setEditable(false);
        else
            businessAreaTextField.setEditable(true);
    }

    @FXML
    void editIntroduction(MouseEvent event){
        if(!editable)
            introductionTextArea.setEditable(false);
        else
            introductionTextArea.setEditable(true);
    }

    @FXML
    void editFacility(MouseEvent event){
        if(!editable)
            facilityTextArea.setEditable(false);
        else
            facilityTextArea.setEditable(true);
    }

    @FXML
    void changeImageButtonClicked(MouseEvent event) {
        // TODO
    }


    @FXML
    void changeToRoomInfoUI(MouseEvent event) {
        // 加载客房信息维护界面
        FXMLLoader loader = HotelUIFXMLFactory.getInstance().getRoomInfoUILoader();
        // 加载客房信息维护界面根结点
        if(roomInfoUIPane==null)
            try {
                roomInfoUIPane = (AnchorPane) loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
        // 得到客房信息维护界面控制器
        if(roomInfoUIController==null)
            roomInfoUIController = loader.getController();
        // 传入酒店信息维护界面根结点
        roomInfoUIController.setPrePane(anchorPane);
        // 配置hotelService
        roomInfoUIController.setHotelService(hotelService);
        roomInfoUIController.setHotelId(hotelId);
        roomInfoUIController.refreshPage();

        Scene scene = null;
        if(roomInfoUIPane.getScene()==null)
            scene = new Scene(roomInfoUIPane, HotelUIFXMLFactory.UI_WIDTH, HotelUIFXMLFactory.UI_HEIGHT);
        else
            scene = roomInfoUIPane.getScene();

        Stage stage = (Stage)anchorPane.getScene().getWindow();
        stage.setScene(scene);

    }

    @FXML
    void confimButtonClicked(MouseEvent event) {
        // TODO 处理信息
        String name = nameTextField.getText();
        String id = idLabel.getText();
        String tel = telTextField.getText();
        String latestCheckinTime = checkInDDLTextField.getText();
        String level = levelTextField.getText();
        String grade = gradeLabel.getText();
        String address = addressTextField.getText();
        String businessArea = businessAreaTextField.getText();
        String briefIntro = introductionTextArea.getText();
        String facility = facilityTextArea.getText();

        HotelVO newHotelVO = new HotelVO(id, tel, name,
                address, businessArea, briefIntro,
                facility,Integer.parseInt(level), Double.parseDouble(grade), latestCheckinTime);

        String[] feedback = HotelBasicInfoUICheck.checkHotelVO(newHotelVO);

        boolean isLegal = true;
        for(String eachItem:feedback){
            if(!eachItem.equals(HotelBasicInfoUIFeedback.LEGAL)){
                isLegal = false;
                // TODO 结合下面的弹出提示框
                System.out.println(eachItem);
            }
        }
        if(isLegal){
            ResultMessage rm = hotelService.updateHotel(newHotelVO);
            if(rm.equals(ResultMessage.succeed))
                // TODO 用的stub所以不会有反应
                System.out.println("成功保存");
        } else {
            // TODO 弹出提示框
        }

        refreshPage();
        editable = false;
    }

    @FXML
    void backButtonClicked(MouseEvent event){
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert gradeLabel != null : "fx:id=\"gradeLabel\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert addressTextField != null : "fx:id=\"addressTextField\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert businessAreaTextField != null : "fx:id=\"businessAreaTextField\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert hotelImage != null : "fx:id=\"hotelImage\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert levelTextField != null : "fx:id=\"levelTextField\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert checkInDDLTextField != null : "fx:id=\"checkInDDLTextField\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert introductionTextArea != null : "fx:id=\"introductionTextArea\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert changeImageButton != null : "fx:id=\"changeImageButton\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert idLabel != null : "fx:id=\"idLabel\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert editButton != null : "fx:id=\"editButton\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert telTextField != null : "fx:id=\"telTextField\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert roomInfoButton != null : "fx:id=\"roomInfoButton\" was not injected: check your FXML file '酒店信息维护.fxml'.";
        assert facilityTextArea != null : "fx:id=\"facilityTextArea\" was not injected: check your FXML file '酒店信息维护.fxml'.";

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
        setHotelVO();
        nameTextField.setText(hotelVO.name);
        idLabel.setText(hotelVO.hotelID);
        telTextField.setText(hotelVO.tel);
        checkInDDLTextField.setText(hotelVO.latestCheckinTime);
        levelTextField.setText(String.valueOf(hotelVO.level));
        gradeLabel.setText(String.valueOf(hotelVO.grade));
        addressTextField.setText(hotelVO.addr);
        businessAreaTextField.setText(hotelVO.district);
        introductionTextArea.setText(hotelVO.briefIntro);
        facilityTextArea.setText(hotelVO.facility);
    }

}
