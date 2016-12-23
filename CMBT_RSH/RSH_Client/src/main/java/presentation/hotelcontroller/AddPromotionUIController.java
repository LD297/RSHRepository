package presentation.hotelcontroller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.MyDateFormat;
import vo.PromotionVO;

import static javafx.collections.FXCollections.observableArrayList;

public class AddPromotionUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox memberCheckBox;

    @FXML
    private DatePicker endDate;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField discountTextField;

    @FXML
    private Button confirmButton;

    @FXML
    private TextField roomNumTextField;

    @FXML
    private TextField totalTextField;

    @FXML
    private DatePicker beginDate;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private CheckBox commerceCheckBox;

    @FXML
    private TextField reduceTextField;

    @FXML
    private TextField numberTextField;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox birthdayCheckBox;

    @FXML
    private CheckBox notBirthdayCheckBox;

    @FXML
    private ChoiceBox<Object> scopeChoiceBox;

    @FXML
    private ChoiceBox<Object> deductionTypeChoiceBox;

    private boolean isHotel;

    private boolean isCommerce = false;
    private boolean isAllUser = false;

    private boolean isBirth = false;
    private boolean notBirth = false;

    private AnchorPane prePane;
    private String setterID;

    public void setSetterID(String setterID){
        this.setterID = setterID;
    }

    public void setPrePane(AnchorPane prePane){
        this.prePane = prePane;
    }


    @FXML
    void chooseCommerce(MouseEvent event){
        if(isAllUser)
            commerceCheckBox.setSelected(false);
        else if(commerceCheckBox.isSelected())
            isCommerce = true;
        else
            isCommerce = false;
    }
    @FXML
    void chooseAllUser(MouseEvent event){
        if(isCommerce)
            memberCheckBox.setSelected(false);
        else if(memberCheckBox.isSelected())
            isAllUser = true;
        else
            isAllUser =false;
    }

    @FXML
    void isBirthday(MouseEvent event){
        if(notBirth)
            birthdayCheckBox.setSelected(false);
        else if(birthdayCheckBox.isSelected())
            isBirth = true;
        else
            isBirth = false;

    }

    @FXML
    void notBirthday(MouseEvent event){
        if(isBirth)
            notBirthdayCheckBox.setSelected(false);
        else if(notBirthdayCheckBox.isSelected())
            notBirth = true;
        else
            notBirth = false;
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {

        String promotionID = numberTextField.getText();
        String reason = nameTextField.getText();
        String scope = (String)scopeChoiceBox.getValue();
        LocalDate begin = beginDate.getValue();
        LocalDate end = endDate.getValue();
        Date beginDate = null;
        Date endDate = null;
        if(begin!=null)
            beginDate = MyDateFormat.getInstance().changeLocalDateToDate(begin);
        if(endDate!=null)
            endDate = MyDateFormat.getInstance().changeLocalDateToDate(end);

        ScopeType scopeType = ScopeType.DISTRICT;
        if(isHotel){
            if(scopeChoiceBox.getValue().equals("房间"))
                scopeType = ScopeType.HOTEL;
            else
                scopeType = ScopeType.ROOM;
        }
        
        PromotionVO thePromotion = new PromotionVO(setterID, promotionID, reason,
                new Date(), new Date(), ScopeType.DISTRICT, "", "",
                ConditionType.MEMBER, 0, DeductionType.DISCOUNT, 9);
        backButtonClicked(null);
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        int size = prePane.getChildren().size();
        prePane.getChildren().get(size-2).setVisible(false);
        prePane.getChildren().remove(size-1);
    }

    @FXML
    void initialize() {
        assert memberCheckBox != null : "fx:id=\"memberCheckBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert discountTextField != null : "fx:id=\"discountTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert roomNumTextField != null : "fx:id=\"roomNumTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert totalTextField != null : "fx:id=\"totalTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert beginDate != null : "fx:id=\"beginDate\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert commerceCheckBox != null : "fx:id=\"commerceCheckBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert reduceTextField != null : "fx:id=\"reduceTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert numberTextField != null : "fx:id=\"numberTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert scopeChoiceBox != null : "fx:id=\"scopeChoiceBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert birthdayCheckBox != null : "fx:id=\"birthdayCheckBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert notBirthdayCheckBox != null : "fx:id=\"notBirthdayCheckBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert deductionTypeChoiceBox != null : "fx:id=\"deductionTypeChoiceBox\" was not injected: check your FXML file '添加促销策略.fxml'.";

        setScopeChoiceBox();
        setDeductionChoiceBox();

    }

    public void setIsHotel(boolean isHotel){
        this.isHotel = isHotel;
    }

    private void setScopeChoiceBox() {
        if(isHotel)
        scopeChoiceBox.setItems(FXCollections.observableArrayList(
                "酒店",
                new Separator(),
                "房间"));
        else
            scopeChoiceBox.setItems(FXCollections.observableArrayList("地区"));

    }

    private void setDeductionChoiceBox() {
        deductionTypeChoiceBox.setItems(FXCollections.observableArrayList(
                "打折",
                new Separator(),
                "减额"
        ));
    }
}
