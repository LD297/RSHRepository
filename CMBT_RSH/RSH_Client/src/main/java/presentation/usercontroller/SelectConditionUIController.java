package presentation.usercontroller;

/**
 * Created by john on 2016/12/6.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;

public class SelectConditionUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView cancelImage;

    @FXML
    private DatePicker checkinTimePicker;

    @FXML
    private DatePicker checkoutTimePicker;

    @FXML
    private TextField lowestPriceField;

    @FXML
    private TextField highestPriceField;

    @FXML
    private ComboBox<?> roomtypeCombobox;

    @FXML
    private TextField roomNumField;

    @FXML
    private TextField lowestGradeField;

    @FXML
    private TextField highestGradeField;

    @FXML
    private ComboBox<?> starLevelCombobox;

    @FXML
    private RadioButton priceFromHighToLow;

    @FXML
    private RadioButton priceFromLowToHigh;

    @FXML
    private RadioButton gradeFromHighToLow;

    @FXML
    private RadioButton gradeFromLowToHigh;

    @FXML
    private Button selectButton;

    @FXML
    private RadioButton reservedButton;

    @FXML
    private RadioButton unreservedButton;

    private Image cancel_red = ImageFactory.getImageFactory().getCancel_red();
    private Image cancel_gray = ImageFactory.getImageFactory().getCancel_gray();

    @FXML
    void changeCancelImageToGray(MouseEvent event) {
        cancelImage.setImage(cancel_gray);
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(cancel_red);
    }

    //直接关闭筛选条件界面
    @FXML
    void closeSelectContion(MouseEvent event) {
        UIJumpTool.getUiJumpTool().closeSelectCondition();
    }

    @FXML
    void finishSelect(MouseEvent event) {
        //TODO 得到筛选条件
        UIJumpTool.getUiJumpTool().closeSelectCondition();
    }

    @FXML
    void initialize() {
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert checkinTimePicker != null : "fx:id=\"checkinTimePicker\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert checkoutTimePicker != null : "fx:id=\"checkoutTimePicker\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert lowestPriceField != null : "fx:id=\"lowestPriceField\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert highestPriceField != null : "fx:id=\"highestPriceField\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert roomtypeCombobox != null : "fx:id=\"roomtypeCombobox\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert roomNumField != null : "fx:id=\"roomNumField\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert lowestGradeField != null : "fx:id=\"lowestGradeField\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert highestGradeField != null : "fx:id=\"highestGradeField\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert starLevelCombobox != null : "fx:id=\"starLevelCombobox\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert priceFromHighToLow != null : "fx:id=\"priceFromHighToLow\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert priceFromLowToHigh != null : "fx:id=\"priceFromLowToHigh\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert gradeFromHighToLow != null : "fx:id=\"gradeFromHighToLow\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert gradeFromLowToHigh != null : "fx:id=\"gradeFromLowToHigh\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert reservedButton != null : "fx:id=\"reservedButton\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert unreservedButton != null : "fx:id=\"unreservedButton\" was not injected: check your FXML file '筛选条件.fxml'.";

    }
}

