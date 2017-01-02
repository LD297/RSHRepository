package presentation.websalesmancontroller;

import bl.orderservice.OrderForWebsite;
import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.stage.Stage;
import presentation.websalesmancontrollertools.WebSalesmanServiceFactory;
import vo.OrderVO;

/**
 * Created by a297 on 16/12/18.
 */
public class ExceptionalOrderUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button revokeButton0;

    @FXML
    private TextField searchTextField;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private ImageView background;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private Button revokeButton02;

    @FXML
    private Label pageNumberLabel;

    @FXML
    private Button revokeButton01;

    @FXML
    private ImageView telescope;

    @FXML
    private TabPane tabPane;

    @FXML
    private AnchorPane showPane0;

    @FXML
    private AnchorPane showPane1;

    @FXML
    private AnchorPane showPane2;

    @FXML
    private CheckBox isHalfCheckBox;

    private AnchorPane prePane;
    private ArrayList<OrderVO> exceptionalOrder;
    private OrderForWebsite orderForWebsite;
    private static final int NUM_OF_ORDERS_SHOWN = 3;
    private OrderVO[] orderOnShow = new OrderVO[NUM_OF_ORDERS_SHOWN];

    private int currentPage;
    private int fullPageNum;
    private int remainderOrderNum;

    private AnchorPane[] aPanesForShow;

    public void refreshPage(){
        setExceptionalOrder();
        setFullPageNum();
        setRemainderOrderNum();

        initCurrentPage();
        showPage();
    }


    public void initCurrentPage() {
        currentPage=0;
    }

    private void setFullPageNum() {
        fullPageNum = exceptionalOrder.size()/NUM_OF_ORDERS_SHOWN;
    }

    private void setRemainderOrderNum() {
        remainderOrderNum = exceptionalOrder.size()%NUM_OF_ORDERS_SHOWN;
    }


    private void showPage(){
        // 流程：set当前页面要显示的order-> set要显示的anchorPanes->初始化容器->显示order
        if(currentPage>=0&&currentPage<fullPageNum)
            setOrderOnShow(true);
        else if((fullPageNum==0&&remainderOrderNum==0)||(remainderOrderNum>0&&currentPage==fullPageNum))
            setOrderOnShow(false);
        else if(currentPage<0){
            System.out.println("已是第一页！");
            currentPage++;
            return;
        } else {
            System.out.println("已是最后一页！");
            currentPage--;
            return;
        }
        initAPanesForShow();
        showOrder();
        showPageNumber();
    }
    private void showPageNumber() {
        if(pageNumberLabel!=null)
            pageNumberLabel.setText(String.valueOf(currentPage+1));
    }
    private void showOrderItems(AnchorPane theAnchorePane, OrderVO theOrder){

        if(theOrder!=null){
            String userID = theOrder.getUserID();
            String userName = theOrder.getUserName();
            String orderID = theOrder.getOrderID();
            String roomType = theOrder.getRoom().getRoomType();
            int roomNum = theOrder.getRoomNumber();
            double trueValue = theOrder.getTrueValue();
            Date checkIn = theOrder.getCheckIn();
            Date checkOut = theOrder.getCheckOut();
            Date generationDate = theOrder.getGenerationDate();
            ((Label)theAnchorePane.getChildren().get(0)).setText(userID+"("+userName+")");
            ((Label)theAnchorePane.getChildren().get(1)).setText(orderID);
            ((Label)theAnchorePane.getChildren().get(2)).setText(roomType);
            ((Label)theAnchorePane.getChildren().get(3)).setText(String.valueOf(roomNum));
            ((Label)theAnchorePane.getChildren().get(4)).setText("￥ "+String.valueOf(trueValue));
            ((Label)theAnchorePane.getChildren().get(5)).setText(String.valueOf(generationDate.getTime()));
            ((Label)theAnchorePane.getChildren().get(6)).setText(String.valueOf(checkIn.getTime()));
            ((Label)theAnchorePane.getChildren().get(7)).setText(String.valueOf(checkOut.getTime()));
        } else {
            showBlank(theAnchorePane);
        }
    }

    // 显示存放于orderOnShow[]的有限条订单
    private void showOrder() {
        for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
            showOrderItems(aPanesForShow[i], orderOnShow[i]);
        }
    }

    // 设置该条目anchorPane所有子女不可见
    private void showBlank(AnchorPane theAnchorPane) {
        int size = theAnchorPane.getChildren().size();
        for(int i=0; i<size; i++){
            theAnchorPane.getChildren().get(i).setVisible(false);
        }
    }

    // 初始化anchorPanes所有子女可见
    private void initAPanesForShow() {
        if(aPanesForShow!=null){
            int size = 0;
            for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++){
                size = aPanesForShow[i].getChildren().size();
                for(int j=0; j<size; j++){
                    aPanesForShow[i].getChildren().get(j).setVisible(true);
                }
            }
        }
    }

    private void setOrderOnShow(boolean isFullPage) {
        if(isFullPage)
            for(int i=0; i<NUM_OF_ORDERS_SHOWN; i++)
            /**
             * 根据当前页码获得当前页数的orders，并依次存入orderOnShow数组
             */
                orderOnShow[i] = exceptionalOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
        else {
            for(int i=0; i<remainderOrderNum; i++)
                orderOnShow[i] = exceptionalOrder.get(currentPage*NUM_OF_ORDERS_SHOWN+i);
            /**
             * 为防止前一页遗留，重置order on show时，缺省项用null补齐，并在显示时判断
             */
            for(int i=remainderOrderNum; i<NUM_OF_ORDERS_SHOWN; i++)
                orderOnShow[i] = null;
        }
    }

    private void setExceptionalOrder(){
        exceptionalOrder = orderForWebsite.browseAbnormal();
        System.out.println(exceptionalOrder.size()+"~~");
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void nextPageLabelClicked(MouseEvent event) {
        currentPage++;
        showPage();
    }

    @FXML
    void prePageLabelClicked(MouseEvent event) {
        currentPage--;
        showPage();
    }

    @FXML
    void searchOrderByID(MouseEvent event) {
        String id = searchTextField.getText();
        for(OrderVO orderVO:exceptionalOrder){
            if(orderVO.getOrderID().equals(id)){
                int index = exceptionalOrder.indexOf(orderVO);
                int page = index/NUM_OF_ORDERS_SHOWN;
                currentPage = page;
                showPage();
                return;
            }
        }
        System.out.println("当前类型不存在该订单");
    }

    private void revokeOrder(AnchorPane theAnchorPane){
        String orderID = ((Label)theAnchorPane.getChildren().get(1)).getText();
        ResultMessage rm = orderForWebsite.webCancelAbnormal(orderID, isHalfCheckBox.isSelected());
        if(rm.equals(ResultMessage.succeed))
            refreshPage();
        else
            System.out.println("撤销失败");
    }

    @FXML
    void revoke0(MouseEvent event){
        revokeOrder(showPane0);
    }
    @FXML
    void revoke01(MouseEvent event){
        revokeOrder(showPane1);

    }@FXML
    void revoke02(MouseEvent event){
        revokeOrder(showPane2);
    }

    @FXML
    void initialize() {
        assert revokeButton0 != null : "fx:id=\"revokeButton0\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert searchTextField != null : "fx:id=\"searchTextField\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert background != null : "fx:id=\"background\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert revokeButton02 != null : "fx:id=\"revokeButton02\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert pageNumberLabel != null : "fx:id=\"pageNumberLabel\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert revokeButton01 != null : "fx:id=\"revokeButton01\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert telescope != null : "fx:id=\"telescope\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert showPane2 != null : "fx:id=\"showPane2\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert showPane1 != null : "fx:id=\"showPane1\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert tabPane != null : "fx:id=\"tabPane\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";
        assert isHalfCheckBox != null : "fx:id=\"isHalfCheckBox\" was not injected: check your FXML file '网站营销人员浏览异常订单.fxml'.";

        setAPanesForShow();
        initializeService();
    }

    private void setAPanesForShow(){
        aPanesForShow = new AnchorPane[]{showPane0, showPane1, showPane2};
    }
    private void initializeService() {
        this.orderForWebsite = WebSalesmanServiceFactory.getInstance().getOrderForWebsite();
    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
}

