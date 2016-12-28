package presentation.hotelcontroller;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import bl.hotelservice.HotelInfoService;
import bl.hotelservice.HotelService;
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
import presentation.hotelcontrollertools.HotelServiceFactory;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
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

    private PromotionUIController promotionUIController;
    // 逻辑层引用
    private HotelInfoService hotelInfoService;
    private PromotionService promotionService;


    // 制定促销策略需要的人员信息
    private WebSalesmanVO webSalesmanVO = null;
    private String setterId = "";
    // 每条促销策略涵盖的信息
    private String promotionID;
    private String reason;  // 促销策略名称，默认："大额满减"
    private LocalDate begin;
    private LocalDate end;
    private ScopeType scopeType;// 酒店工作人员默认："酒店"，可选"房间"； 网营默认："地区"
    private String scopeNum; // 酒店工作人员默认："hotelid"；网营默认："webstaffvo中的district"
    private String roomType; // 酒店工作人员选择"房间"后，需选择促销策略针对的房间类型
    private ConditionType conditionType  = ConditionType.SPECIALPERIOD; // 默认："特定时期入住"
    private double conditionNum = 0; // 默认："0"
    private DeductionType deductionType = DeductionType.DISCOUNT; // 默认："打折"
    private double deductionNum = 8.8; // 默认："8.8"

    // 适用人员单一选择
    private boolean isCommerce = false;
    private boolean isAllUser = false;
    // 生日特惠单一选择
    private boolean isBirth = false;
    private boolean notBirth = false;

    // 促销策略维护界面根节点
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

        reason = nameTextField.getText();
        begin = beginDate.getValue();
        end = endDate.getValue();
        Date beginDate = null;
        Date endDate = null;
        beginDate = MyDateFormat.getInstance().changeLocalDateToDate(begin);
        endDate = MyDateFormat.getInstance().changeLocalDateToDate(end);

        // 对应界面的"针对"选项
        if(webSalesmanVO==null){
            if(scopeChoiceBox.getValue().equals("指定房间"))
                scopeType = ScopeType.ROOM;
            else
                scopeType = ScopeType.HOTEL;
        }

        //  "针对"的数量（细节）
        if(webSalesmanVO!=null)
            scopeNum = webSalesmanVO.getDistrict();
        else
            scopeNum = setterId;

        //  房间类型
        if(webSalesmanVO!=null){
            if(scopeType.equals(ScopeType.ROOM))
                roomType = (String)roomTypeChoiceBox.getValue();
        }

        if(birthdayCheckBox.isSelected())
            conditionType = ConditionType.BIRTHDAY;
        else if(commerceCheckBox.isSelected())
            conditionType = ConditionType.COMMERCE;
        else if(memberCheckBox.isSelected()){
            conditionType = ConditionType.MEMBER;
            System.out.println(conditionType+"~~~"+conditionNum);

        }
        else if(!roomNumTextField.getText().equals("")){
            // 房间数量>=
            conditionType = ConditionType.ROOMNUM;
            conditionNum = Double.valueOf(roomNumTextField.getText());
        } else if(!totalTextField.getText().equals("")){
            // 消费总额>=
            conditionType = ConditionType.TOTAL;
            conditionNum = Double.valueOf(totalTextField.getText());
        }

        // 默认输折扣方式和折扣额度输入正确
        if(deductionTypeChoiceBox.getValue().equals("打折"))
            deductionNum = Double.valueOf(discountTextField.getText());
        else {
            deductionType = DeductionType.REDUCE;
            deductionNum = Double.valueOf(reduceTextField.getText());
        }
        PromotionVO thePromotion = new PromotionVO(setterId,promotionID, reason, beginDate, endDate,
                scopeType,scopeNum, roomType, conditionType, conditionNum, deductionType, deductionNum
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

        initializeController();
        initilizeService();
        setDeductionChoiceBox();

    }

    private void initializeController(){
        promotionUIController = HotelUIFXMLFactory.getInstance().getPromotionUIController();

    }

    private void initilizeService() {

        this.hotelInfoService = HotelServiceFactory.getInstance().getHotelInfoService();
        this.promotionService = HotelServiceFactory.getInstance().getPromotionService();
        this.promotionService = HotelServiceFactory.getInstance().getPromotionService();
    }

    private void setDeductionChoiceBox() {
        deductionTypeChoiceBox.setItems(FXCollections.observableArrayList(
                "打折",
                new Separator(),
                "减额"
        ));
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

    public void initializePageBySetter(){

        clearNodeContent();

        boolean isHotel = true;
        if(webSalesmanVO!=null)
            isHotel=false;

        // 促销策略编号自动生成，不可修改
        numberTextField.setText(promotionID);
        numberTextField.setEditable(false);
        reason = "大额满减";
        nameTextField.setPromptText(reason);
        // 默认促销策略有效期为：即日起，保持一年
        begin = LocalDate.now();
        end = begin.plusYears(1);
        beginDate.setValue(begin);
        endDate.setValue(end);

        if(isHotel) {
            scopeType = ScopeType.HOTEL;
            scopeNum = setterId;
        }
        else {
            scopeType = ScopeType.DISTRICT;
            scopeNum = null;
        }

        roomTypeLabel.setVisible(false);
        roomTypeChoiceBox.setVisible(false);
        if(webSalesmanVO==null) {
            // 酒店工作人员制定
            scopeChoiceBox.setItems(FXCollections.observableArrayList(
                    "所有房间",
                    new Separator(),
                    "指定房间"));

        } else {
            // 网站营销人员制定
            scopeChoiceBox.setItems(FXCollections.observableArrayList("地区"));
            System.out.println("!~!~!~");
        }

        scopeChoiceBox.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                if(scopeChoiceBox.getValue()!=null&&scopeChoiceBox.getValue().equals("指定房间")){
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

    private void clearNodeContent() {
        nameTextField.clear();
        scopeChoiceBox.setValue("");
        commerceCheckBox.setSelected(false);
        memberCheckBox.setSelected(false);
        birthdayCheckBox.setSelected(false);
        notBirthdayCheckBox.setSelected(false);
        roomNumTextField.clear();
        totalTextField.clear();
        beginDate.setValue(null);
        endDate.setValue(null);
        deductionTypeChoiceBox.setValue(null);
        discountTextField.clear();
        reduceTextField.clear();
    }
}
