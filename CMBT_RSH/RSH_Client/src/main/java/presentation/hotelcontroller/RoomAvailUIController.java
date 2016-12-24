package presentation.hotelcontroller;

/**
 * Created by a297 on 16/12/5.
 */
import java.net.URL;
import java.sql.Time;
import java.time.Instant;
import java.time.LocalDate;
import java.util.*;

import bl.hotelservice.HotelService;
import bl.hotelserviceimpl.controller.HotelService_Stub;
import constant.ResultMessage;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import presentation.hotelcontrollertools.HotelServiceFactory;
import presentation.tools.MyDateFormat;
import vo.RoomAvailVO;

public class RoomAvailUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane showPane02;

    @FXML
    private AnchorPane showPane01;

    @FXML
    private ImageView minus01;

    @FXML
    private DatePicker datePicker;

    @FXML
    private ImageView plus0;

    @FXML
    private ImageView minus02;

    @FXML
    private Label greyLabel;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label prePageLabel;

    @FXML
    private Button backButton;

    @FXML
    private Label nextPageLabel;

    @FXML
    private AnchorPane showPane0;

    @FXML
    private ImageView minus0;

    @FXML
    private ImageView plus02;

    @FXML
    private ImageView plus01;

    @FXML
    private Label gotoDateLabel;

    @FXML
    private Label pageLabel;

    private static AnchorPane prePane;
    private HotelService hotelService;
    private String hotelId;
    // 当前入住日期
    private Date currentDate = new Date();

    private static final int NUM_OF_ITEMS = 3;
    private static final int NUM_OF_PANES_FOR_SHOW = 3;

    // 根据日期从数据库得到当天各种类型的可用数量
    private ArrayList<RoomAvailVO> currentRoomAvailList;
    // 存放当前页面显示的有限条房间信息
    private RoomAvailVO[] roomAvailOnShow = new RoomAvailVO[NUM_OF_PANES_FOR_SHOW];
    // 存放当前页用于展示的anchorPanes
    private AnchorPane[] showPanes = new AnchorPane[NUM_OF_PANES_FOR_SHOW];
    // （当前日期对应的）房间共几页
    private int fullPageNum = 0;
    // 最后剩下不满一页的房间有几条
    private int remainderRoomAvailNum = 0;
    // 当前页数，从0开始计，显示出来要加一
    private int currentPage=0;

    private void setCurrentRoomAvailList(Date checkIn){
        currentRoomAvailList = hotelService.getRoomAvailList(hotelId, checkIn);
    }

    private void initCurrentPage() {
        currentPage = 0;
    }

    private void setRemainderRoomAvailNum() {
        remainderRoomAvailNum = currentRoomAvailList.size()%NUM_OF_PANES_FOR_SHOW;
    }

    private void setFullPageNum() {
        fullPageNum = currentRoomAvailList.size()/NUM_OF_PANES_FOR_SHOW;
    }

    private void setRoomAvailOnShow(boolean isFullPage){
        if(isFullPage){
            for(int i=0; i<NUM_OF_PANES_FOR_SHOW; i++)
                roomAvailOnShow[i] = currentRoomAvailList.get(currentPage*NUM_OF_PANES_FOR_SHOW+i);
        } else {
            for(int i=0; i<remainderRoomAvailNum; i++)
                roomAvailOnShow[i] = currentRoomAvailList.get(currentPage*NUM_OF_PANES_FOR_SHOW+i);
            for(int i=remainderRoomAvailNum; i<NUM_OF_PANES_FOR_SHOW; i++)
                roomAvailOnShow[i] = null;
        }
    }
    private void initShowPanes(){
        // 初始化showPanes所有子女可见
        if(showPanes!=null){
            int size =0;
            for(int i=0; i<showPanes.length; i++){
                size = (showPanes[i].getChildren()).size();
                for(int j=0; j<size; j++)
                    showPanes[i].getChildren().get(j).setVisible(true);
            }
        }
    }
    private void showBlank(AnchorPane theAnchorPane) {
        // 设置改条目anchorPane所有子女不可见
        int size = theAnchorPane.getChildren().size();
        for(int i=0; i<size; i++){
            theAnchorPane.getChildren().get(i).setVisible(false);
        }
    }
    private void showRoomAvailItems(AnchorPane theAnchorPane, RoomAvailVO theRoomAvail){
        if(theRoomAvail!=null){
            // 显示房间图片
            Image roomImage = new Image(theRoomAvail.getImageAddress());
            ((ImageView)theAnchorPane.getChildren().get(0)).setImage(roomImage);

            ArrayList<Label> labels = new ArrayList<>(NUM_OF_ITEMS);
            for(int  i=0; i<NUM_OF_ITEMS; i++)
                labels.add((Label)theAnchorPane.getChildren().get(i+1));

            String type = theRoomAvail.getRoomType();
            String availNum = String.valueOf(theRoomAvail.getAmountAvail());
            String price = String.valueOf(theRoomAvail.getPrice());
            String[] items = new String[]{type, availNum, price};

            for(int i=0; i<NUM_OF_ITEMS; i++){
                labels.get(i).setTextAlignment(TextAlignment.CENTER);
                labels.get(i).setText(items[i]);
            }
        } else {
            showBlank(theAnchorPane);
        }
    }
    private void showRoomAvail(){
        for(int i=0; i<NUM_OF_PANES_FOR_SHOW; i++){
            showRoomAvailItems(showPanes[i], roomAvailOnShow[i]);
        }
    }
    private void showPage() {
        // 流程：set当前页的roomAvail->初始化showPanes->显示roomAvail
        if(currentPage>=0&&currentPage<fullPageNum){
            setRoomAvailOnShow(true);
        } else if((fullPageNum==0&&remainderRoomAvailNum==0)||(remainderRoomAvailNum>0&&currentPage==fullPageNum))
            setRoomAvailOnShow(false);
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
        showRoomAvail();
        showPageNum();
    }

    private void showPageNum(){
        if(pageLabel!=null)
            pageLabel.setText(String.valueOf(currentPage+1));
    }

    private void changeNum(AnchorPane thePane, int change){
        Label roomAvailNum = (Label)thePane.getChildren().get(2);
        int availNum = Integer.valueOf(roomAvailNum.getText());
        availNum+=change;
        // 房间数量非负
        if(availNum>=0){
            roomAvailNum.setText(String.valueOf(availNum));
            Label roomType = (Label)thePane.getChildren().get(0);
            currentDate = (Date)datePicker.getUserData();
            if(currentDate==null)
                currentDate = Date.from(Instant.now());
            // TODO 告诉逻辑实现，最后两个日期，任一为null；默认设为系统当前时间
            if(change==1)
                hotelService.plusRoomAvail(hotelId, roomType.getText(), availNum, currentDate, currentDate);
            else if(change==-1)
                hotelService.minusRoomAvail(hotelId, roomType.getText(), availNum, currentDate, currentDate);
        }
    }

    // 所有加号一个监听，响应时判断父节点
    @FXML
    void plus0Clicked(MouseEvent event){
        changeNum(showPane0, 1);
    }
    @FXML
    void plus01Clicked(MouseEvent event){
        changeNum(showPane01, 1);
    }
    @FXML
    void plus02Clicked(MouseEvent event){
        changeNum(showPane02, 1);
    }
    @FXML
    void minus0Clicked(MouseEvent event) {
        changeNum(showPane0, -1);
    }
    @FXML
    void minus01Clicked(MouseEvent event) {
        changeNum(showPane01, -1);
    }
    @FXML
    void minus02Clicked(MouseEvent event) {
        changeNum(showPane02, -1);
    }

    @FXML
    void prePageClicked(MouseEvent event) {
        // 只有确认当前页操作才能翻页
        currentPage--;
        showPage();
    }

    @FXML
    void nextPageClicked(MouseEvent event) {
        // 只有确认当前页操作才能翻页
        currentPage++;
        showPage();
    }

    @FXML
    void gotoDate(MouseEvent event) {
        LocalDate dateChosen = datePicker.getValue();
        if(dateChosen!=null)
            currentDate = MyDateFormat.getInstance().changeLocalDateToDate(dateChosen);
        refreshPage();
    }

    @FXML
    void backButtonClicked(MouseEvent event) {
        ((Stage)anchorPane.getScene().getWindow()).setScene(prePane.getScene());
    }

    @FXML
    void initialize() {
        assert showPane02 != null : "fx:id=\"showPane02\" was not injected: check your FXML file '可用客房.fxml'.";
        assert showPane01 != null : "fx:id=\"showPane01\" was not injected: check your FXML file '可用客房.fxml'.";
        assert minus01 != null : "fx:id=\"minus01\" was not injected: check your FXML file '可用客房.fxml'.";
        assert datePicker != null : "fx:id=\"datePicker\" was not injected: check your FXML file '可用客房.fxml'.";
        assert plus0 != null : "fx:id=\"plus0\" was not injected: check your FXML file '可用客房.fxml'.";
        assert minus02 != null : "fx:id=\"minus02\" was not injected: check your FXML file '可用客房.fxml'.";
        assert greyLabel != null : "fx:id=\"greyLabel\" was not injected: check your FXML file '可用客房.fxml'.";
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '可用客房.fxml'.";
        assert prePageLabel != null : "fx:id=\"prePageLabel\" was not injected: check your FXML file '可用客房.fxml'.";
        assert backButton != null : "fx:id=\"backButton\" was not injected: check your FXML file '可用客房.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '可用客房.fxml'.";
        assert showPane0 != null : "fx:id=\"showPane0\" was not injected: check your FXML file '可用客房.fxml'.";
        assert minus0 != null : "fx:id=\"minus0\" was not injected: check your FXML file '可用客房.fxml'.";
        assert plus02 != null : "fx:id=\"plus02\" was not injected: check your FXML file '可用客房.fxml'.";
        assert plus01 != null : "fx:id=\"plus01\" was not injected: check your FXML file '可用客房.fxml'.";
        assert gotoDateLabel != null : "fx:id=\"gotoDateLabel\" was not injected: check your FXML file '可用客房.fxml'.";
        assert pageLabel != null : "fx:id=\"pageLabel\" was not injected: check your FXML file '可用客房.fxml'.";

        setShowPanes();
        initializeService();
    }

    private void initializeService() {
        this.hotelService = HotelServiceFactory.getInstance().getHotelService();

    }

    public void setPrePane(AnchorPane prePane) {
        this.prePane = prePane;
    }
//    public void setHotelService(HotelService hotelService) {
//        this.hotelService = hotelService;
//    }
    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }
    private void setShowPanes(){
        showPanes[0] = showPane0;
        showPanes[1] = showPane01;
        showPanes[2] = showPane02;
    }
    public void refreshPage() {
        setCurrentRoomAvailList(currentDate);
        initCurrentPage();
        setFullPageNum();
        setRemainderRoomAvailNum();
        showPage();
    }
}

