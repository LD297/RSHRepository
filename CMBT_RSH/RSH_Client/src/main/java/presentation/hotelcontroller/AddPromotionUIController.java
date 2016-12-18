package presentation.hotelcontroller;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import vo.PromotionVO;

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
    private ChoiceBox<?> scopeChoiceBox;

    @FXML
    private Button backButton;

    @FXML
    private CheckBox birthdayCheckBox;

    @FXML
    private CheckBox notBirthdayCheckBox;

    @FXML
    private ChoiceBox<?> deductionTypeChoiceBox;

    private AnchorPane prePane;
    private String setterID;

    public void setSetterID(String setterID){
        this.setterID = setterID;
    }

    public void setPrePane(AnchorPane prePane){
        this.prePane = prePane;
    }

    @FXML
    void confirmButtonClicked(MouseEvent event) {

        String promotionID = numberTextField.getText();
        String reason = nameTextField.getText();
        // TODO scope的选项，deduction的选项，以及将单选的组件，分组
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

    private void setDeductionChoiceBox() {
        deductionTypeChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("打折",new Separator(),
                "减额"));
    }

    private void setScopeChoiceBox() {
        scopeChoiceBox = new ChoiceBox<>(FXCollections.observableArrayList("地区",new Separator(),
                "酒店",new Separator(),
                "房间"));
    }
}
