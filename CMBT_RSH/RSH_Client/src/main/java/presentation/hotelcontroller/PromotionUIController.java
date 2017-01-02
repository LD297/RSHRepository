package presentation.hotelcontroller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import bl.hotelservice.HotelInfoService;
import bl.promotionservice.PromotionService;
import bl_Stub.PromotionService_Stub;
import constant.ConditionType;
import constant.DeductionType;
import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelServiceFactory;
import presentation.hotelcontrollertools.HotelUIFXMLFactory;
import vo.PromotionVO;
import vo.WebSalesmanVO;

public class PromotionUIController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane showPane02;

    @FXML
    private AnchorPane showPane01;

    @FXML
    private AnchorPane showPane03;

    @FXML
    private ImageView plus;

    @FXML
    private Label greyLabel;

    @FXML
    private Button delete0;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private Button delete03;

    @FXML
    private Button delete02;

    @FXML
    private Button delete01;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private AnchorPane showPane0;

    @FXML
    private Label pageLabel;

    private PromotionService promotionService;
    private AnchorPane prePane;
    private String hotelId = "";
    private String setterId = "";
    private WebSalesmanVO webSalesmanVO = null;

    private AnchorPane addPromotionAnchorPane;
    private AddPromotionUIController addPromotionUIController;

    private static final int NUM_OF_ITEMS = 4;
    private static final int NUM_OF_PROS_SHOWN = 4;
    // 该酒店所有促销策略
    private ArrayList<PromotionVO> promotions ;
    private PromotionVO[] promotionOnShow = new PromotionVO[NUM_OF_PROS_SHOWN];
    private AnchorPane[] showPanes;
    private int currentPage = 0;
    private int fullPageNum = 0;
    private int remainderProNum = 0;

    private void setPromotions(){
        if(webSalesmanVO==null)
            promotions = promotionService.getPromotionOfHotel(setterId);
        else
            promotions = promotionService.getPromotionOfDistrict(webSalesmanVO.getDistrict());
    }
    private void initCurrentPage(){
        currentPage = 0;
    }
    private void setFullPageNum(){
        fullPageNum = promotions.size()/NUM_OF_PROS_SHOWN;
    }
    private void setRemainderProNum(){
        remainderProNum = promotions.size()%NUM_OF_PROS_SHOWN;
    }
    private void setPromotionOnShow(boolean isFullPage){
        if(isFullPage)
            for(int i=0; i<NUM_OF_PROS_SHOWN; i++)
                promotionOnShow[i] = promotions.get(currentPage*NUM_OF_PROS_SHOWN+i);
        else {
            for(int i=0; i<remainderProNum; i++)
                promotionOnShow[i] = promotions.get(currentPage*NUM_OF_PROS_SHOWN+i);
            for(int i=remainderProNum; i<NUM_OF_PROS_SHOWN; i++)
                promotionOnShow[i] = null;
        }
    }
    // 设置showPanes所有子女可见
    private void initShowPanes(){
        if(showPanes!=null){
            int size= 0;
            for(int i=0; i<NUM_OF_PROS_SHOWN; i++){
                size = showPanes[i].getChildren().size();
                for(int j=0; j<size; j++){
                    showPanes[i].getChildren().get(j).setVisible(true);
                }
            }
        }
    }
    // 设置该anchorPane所有子女不可见
    private void showBlank(AnchorPane theAnchorPane){
        int size = theAnchorPane.getChildren().size();
        for(int i=0; i<size; i++){
            theAnchorPane.getChildren().get(i).setVisible(false);
        }
    }
    private void showPromotionItems(AnchorPane theAnchorPane, PromotionVO thePromotion) {
        if (thePromotion != null) {
            ArrayList<Label> labels = new ArrayList<>(NUM_OF_ITEMS);
            for (int i = 0; i < NUM_OF_ITEMS; i++) {
                labels.add(i, (Label) theAnchorPane.getChildren().get(i));
            }

            String id = thePromotion.promotionID;
            String reason = thePromotion.reason;
            ConditionType conditionType = thePromotion.conditionType;
            String condition = "";
            condition = ConditionType.getStringConditionType(conditionType);

            // 如果有需要，显示折扣条件中的数量
            if(conditionType.equals(ConditionType.ROOMNUM)){
                condition += (int)thePromotion.conditionNum;
            } else if(conditionType.equals(ConditionType.TOTAL)){
                condition += thePromotion.conditionNum;
            }

            DeductionType deductionType = thePromotion.deductionType;
            String deduction = "";
            // 根据不同折扣方式，安排界面显示时，折扣力度（int）的位置
            if(deductionType.equals(DeductionType.DISCOUNT))
                // 界面显示"几折"
                deduction = "    "+thePromotion.deductionNum +
                    DeductionType.getStringDeductionType(deductionType);
            else
                // 界面显示"减几"
                deduction = "  "+DeductionType.getStringDeductionType(deductionType)
                        +(int)thePromotion.deductionNum;// 为了显示好看，可以求余确定数据类型

            String[] items = new String[] {id, reason, condition, deduction} ;

            Label eachLabel = null;
            for(int i=0; i<NUM_OF_ITEMS; i++){
                eachLabel = labels.get(i);
                eachLabel.setTextAlignment(TextAlignment.CENTER);
                eachLabel.setText(items[i]);
            }


        } else
            showBlank(theAnchorPane);
    }
    private void showPromotion(){
        for(int i=0; i<NUM_OF_PROS_SHOWN; i++){
            showPromotionItems(showPanes[i], promotionOnShow[i]);
        }
    }
    private void showPageNum(){
        pageLabel.setText(String.valueOf(currentPage+1));
    }
    private void showPage(){
        System.out.println(fullPageNum+"~"+remainderProNum+"~~~"+currentPage);
        if((currentPage>=0)&&(currentPage<fullPageNum))
            setPromotionOnShow(true);
        else if((fullPageNum==0&&remainderProNum==0)||(remainderProNum>0&&currentPage==fullPageNum))
            setPromotionOnShow(false);
        else if(currentPage<0){
            System.out.println("已是第一页！");
            currentPage++;
            return;
        } else {
            System.out.println("已是最后一页！");
            currentPage--;
            return;
        }
        initShowPanes();
        showPromotion();
        showPageNum();
    }
    private void delete(AnchorPane thePane){
        String promotionID = ((Label)thePane.getChildren().get(0)).getText();

        String setterID = "";
        if(webSalesmanVO==null)
            setterID = hotelId;
        else
            setterID = webSalesmanVO.getId();

        ResultMessage res = promotionService.delPromotion(setterID,  promotionID);
        if(res.equals(ResultMessage.succeed))
            refreshPage();
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void nextPageClicked(MouseEvent event){
        currentPage++;
        showPage();
    }

    @FXML
    void prePageClicked(MouseEvent event){
        currentPage--;
        showPage();
    }

    @FXML
    void delete0Clicked(MouseEvent event){
        delete(showPane0);
    }
    @FXML
    void delete01Clicked(MouseEvent event){
        delete(showPane01);
    }
    @FXML
    void delete02Clicked(MouseEvent event){
        delete(showPane02);
    }
    @FXML
    void delete03Clicked(MouseEvent event){
        delete(showPane03);
    }

    @FXML
    void addPromotion(MouseEvent event){
        addPromotionAnchorPane = HotelUIFXMLFactory.getInstance().getAddPromotionUIPane();
        addPromotionUIController = HotelUIFXMLFactory.getInstance().getAddPromotionUIController();

        addPromotionUIController.setPrePane(anchorPane);
        addPromotionUIController.setPromotionUIController(this);
        addPromotionUIController.setWebSalesmanVO(webSalesmanVO);
        addPromotionUIController.setSetterId(setterId);
        String promotionId = promotionService.getIDForNewPromotion(setterId);
        addPromotionUIController.setPromotionId(promotionId);
        // 根据制定人员不同身份初始化界面
        addPromotionUIController.initializePageBySetter();

        greyLabel.setVisible(true);

        AnchorPane.setTopAnchor(addPromotionAnchorPane,50.0);
        AnchorPane.setLeftAnchor(addPromotionAnchorPane,50.0);
        anchorPane.getChildren().add(addPromotionAnchorPane);
    }

    @FXML
    void initialize() {
        assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert showPane01 != null : "fx:id=\"showPane01\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert showPane03 != null : "fx:id=\"showPane03\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert plus != null : "fx:id=\"plus\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert greyLabel != null : "fx:id=\"greyLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert delete0 != null : "fx:id=\"delete0\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert delete03 != null : "fx:id=\"delete03\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert delete02 != null : "fx:id=\"delete02\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert delete01 != null : "fx:id=\"delete01\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";
        assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '酒店促销策略维护.fxml'.";

        initializeService();
        setShowPanes();
    }

    private void initializeService() {
        this.promotionService = HotelServiceFactory.getInstance().getPromotionService();
    }
    private void setShowPanes(){
        showPanes = new AnchorPane[]{showPane0, showPane01, showPane02, showPane03};
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
     */
    public  void refreshPage(){
        setPromotions();
        initCurrentPage();
        setFullPageNum();
        setRemainderProNum();
        showPage();
    }
    /**
     *
     * @param webSalesVO
     */
    public void setWebSalesVO(WebSalesmanVO webSalesVO) {
        this.webSalesmanVO = webSalesVO;
    }
    /**
     *
     * @param hotelId
     */
    public void setHotelId(String hotelId){
        this.hotelId = hotelId;
    }
    /**
     *
     */
    public void setSetterId(){
        if(webSalesmanVO!=null)
            this.setterId = webSalesmanVO.getId();
        else
            this.setterId = hotelId;
    }
}
