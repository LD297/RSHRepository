package presentation.hotelcontroller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import bl.hotelservice.HotelInfoService;
import bl.promotionservice.PromotionService;
import bl.webstaffservice.WebStaffService;
import bl.webstaffserviceimpl.WebSalesman;
import constant.ConditionType;
import constant.DeductionType;
import constant.ScopeType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import presentation.tools.MyDateFormat;
import vo.PromotionVO;
import vo.RoomNormVO;
import vo.WebSalesmanVO;

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
    private Label roomTypeLabel;

    @FXML
    private ChoiceBox<Object> roomTypeChoiceBox;

    @FXML
    private ChoiceBox<Object> deductionTypeChoiceBox;

    private HotelInfoService hotelInfoService = null;
    private PromotionService promotionService = null;
    private PromotionUIController promotionUIController = null;

    private WebSalesmanVO webSalesmanVO = null;
    private String setterId = "";
    private String promotionID;

    private boolean isCommerce = false;
    private boolean isAllUser = false;

    private boolean isBirth = false;
    private boolean notBirth = false;

    private AnchorPane prePane;

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

        String reason = nameTextField.getText();

        LocalDate begin = beginDate.getValue();
        LocalDate end = endDate.getValue();
        Date beginDate = null;
        Date endDate = null;
        if(begin!=null)
            beginDate = MyDateFormat.getInstance().changeLocalDateToDate(begin);
        if(end!=null)
            endDate = MyDateFormat.getInstance().changeLocalDateToDate(end);

        // 对应界面的"针对"选项
        ScopeType scopeType = ScopeType.DISTRICT;
        if(webSalesmanVO==null){
            if(scopeChoiceBox.getValue().equals("房间"))
                scopeType = ScopeType.ROOM;
            else
                scopeType = ScopeType.HOTEL;
        }

        //  "针对"的数量（细节）
        String scopeNum = "";
        if(webSalesmanVO!=null)
            scopeNum = webSalesmanVO.getDistrict();
        else
            scopeNum = setterId;

        //  房间类型
        String roomType = "";
        if(webSalesmanVO!=null){
            if(scopeType.equals(ScopeType.ROOM))
                roomType = (String)roomTypeChoiceBox.getValue();
        }

        // 限制条件
        ConditionType conditionType = null;
        // 具体条件
        double conditionNum = 0;

        if(birthdayCheckBox.isSelected())
            conditionType = ConditionType.BIRTHDAY;
        else if(commerceCheckBox.isSelected())
            conditionType = ConditionType.COMMERCE;
        else if(memberCheckBox.isSelected())
            conditionType = ConditionType.MEMBER;
        else if(roomNumTextField.getText()!=null){
            // 房间数量>=
            conditionType = ConditionType.ROOMNUM;
            conditionNum = Double.valueOf(roomNumTextField.getText());
        }
        else{
            // 消费总额>=
            conditionType = ConditionType.TOTAL;
            conditionNum = Double.valueOf(totalTextField.getText());
        }

        // 折扣方式
        DeductionType deDuctionType = DeductionType.DISCOUNT;
        // 折扣额度
        double deductionNum = Double.valueOf(discountTextField.getText());
        if(deductionTypeChoiceBox.getValue().equals(DeductionType.
                getStringDeductionType(DeductionType.DISCOUNT))){
            deDuctionType = DeductionType.REDUCE;
            deductionNum = Double.valueOf(reduceTextField.getText());
        }

        PromotionVO thePromotion = new PromotionVO(setterId,promotionID, reason, beginDate, endDate,
                scopeType,scopeNum, roomType, conditionType, conditionNum, deDuctionType, deductionNum
                );
        promotionService.addPromotion(thePromotion);
        backButtonClicked(null);
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        int size = prePane.getChildren().size();
        prePane.getChildren().get(size-2).setVisible(false);
        promotionUIController.refreshPage();
        prePane.getChildren().remove(size-1);
    }

    @FXML
    void initialize() {
        assert memberCheckBox != null : "fx:id=\"memberCheckBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert roomTypeLabel != null : "fx:id=\"roomTypeLabel\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert endDate != null : "fx:id=\"endDate\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert nameTextField != null : "fx:id=\"nameTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert discountTextField != null : "fx:id=\"discountTextField\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert confirmButton != null : "fx:id=\"confirmButton\" was not injected: check your FXML file '添加促销策略.fxml'.";
        assert roomTypeChoiceBox != null : "fx:id=\"roomTypeChoiceBox\" was not injected: check your FXML file '添加促销策略.fxml'.";
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

        setDeductionChoiceBox();

    }

    private void setDeductionChoiceBox() {
        deductionTypeChoiceBox.setItems(FXCollections.observableArrayList(
                "打折",
                new Separator(),
                "减额"
        ));
    }

    public void setPromotionUIController(PromotionUIController promotionUIController){this.promotionUIController = promotionUIController;}

    public void setHotelInfoService(HotelInfoService hotelInfoService) {
        this.hotelInfoService = hotelInfoService;
    }

    public void setPromotionService(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    public void setWebSalesmanVO(WebSalesmanVO webSalesmanVO) {
        this.webSalesmanVO = webSalesmanVO;
    }
    public void setSetterId(String setterId){
        this.setterId = setterId;
    }
    public void setPromotionId(String promotionId){
        this.promotionID = promotionId;
    }

    public void setPrePane(AnchorPane prePane){
        this.prePane = prePane;
    }


    public void refreshPageBySetter(){

        numberTextField.setText(promotionID);
        numberTextField.setEditable(false);
        nameTextField.clear();
        roomNumTextField.clear();
        totalTextField.clear();
        beginDate.setValue(null);
        endDate.setValue(null);
        discountTextField.clear();
        reduceTextField.clear();

        roomTypeLabel.setVisible(false);
        roomTypeChoiceBox.setVisible(false);
        if(webSalesmanVO==null) {
            // 酒店工作人员制定
            scopeChoiceBox.setItems(FXCollections.observableArrayList(
                    "酒店",
                    new Separator(),
                    "房间"));

        } else {
            // 网站营销人员制定
            scopeChoiceBox.setItems(FXCollections.observableArrayList("地区"));
        }

        scopeChoiceBox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(scopeChoiceBox.getValue()!=null&&scopeChoiceBox.getValue().equals("房间")){
                    roomTypeLabel.setVisible(true);
                    roomTypeChoiceBox.setVisible(true);
                    ArrayList<RoomNormVO> roomNorm = hotelInfoService.getRoomNorm(setterId);
                    ArrayList<String> roomType = new ArrayList<>(roomNorm.size());
                    for(int i=0; i<roomNorm.size(); i++)
                        roomType.add(roomNorm.get(i).getRoomType());
                    for(int i=0; i<roomNorm.size(); i++)
                        roomTypeChoiceBox.setItems(FXCollections.observableArrayList(roomType));
                } else {
                    roomTypeLabel.setVisible(false);
                    roomTypeChoiceBox.setVisible(false);
                }
            }
        });
    }
}
