package presentation.usercontroller;

/**
 * Created by john on 2016/12/6.
 */

import java.net.URL;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.ResourceBundle;

import constant.SortBy;
import constant.SortMethod;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import presentation.tools.ImageFactory;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import presentation.usercontrollertools.UserUIFXMLFactory;
import vo.HotelVO;
import vo.SelectConditionVO;

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
    private ComboBox<String> roomtypeCombobox;

    @FXML
    private TextField roomNumField;

    @FXML
    private TextField lowestGradeField;

    @FXML
    private TextField highestGradeField;

    @FXML
    private ComboBox<String> starLevelCombobox;
    @FXML
    private ComboBox<String> priceSortComBox;

    @FXML
    private ComboBox<String> starLevelSortComBox;

    @FXML
    private ComboBox<String> gradeSortComBox;


    @FXML
    private Button selectButton;

    @FXML
    private RadioButton reservedButton;

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
    	//筛选
		SelectConditionVO selectConditionVO = new SelectConditionVO();
		String roomType = roomtypeCombobox.getValue();
		if (!(roomType == null || roomType.equals(""))) {
			selectConditionVO.roomType = roomType;
		}
		if(!(lowestPriceField.getText().trim()==null||lowestPriceField.getText().trim().equals(""))){
			double lowestPrice = Double.parseDouble(lowestPriceField.getText().trim());
	    	selectConditionVO.lowestPrice = lowestPrice;
		}
		if(!(highestPriceField.getText().trim()==null||highestPriceField.getText().trim().equals(""))){
			double highestPrice = Double.parseDouble(highestPriceField.getText().trim());
			if(highestPrice>=selectConditionVO.lowestPrice){
				selectConditionVO.highestPrice = highestPrice;
			}
		}
    	
    	//将;ocaldate转换成date
		if(checkinTimePicker.getValue()!=null){
			ZonedDateTime startZonedTime = checkinTimePicker.getValue().atStartOfDay(ZoneId.systemDefault());
			Instant startInstant = Instant.from(startZonedTime);
			selectConditionVO.begin = Date.from(startInstant);
		}
		if(checkoutTimePicker.getValue()!=null){
			ZonedDateTime endZonedTime = checkoutTimePicker.getValue().atStartOfDay(ZoneId.systemDefault());
			Instant endInstant = Instant.from(endZonedTime);
			selectConditionVO.end = Date.from(endInstant);
		}
		if(!roomNumField.getText().equals("")){
			int roomNum = Integer.parseInt(roomNumField.getText().trim());
			selectConditionVO.roomNum = roomNum;
		}
		if(!lowestGradeField.getText().trim().equals("")){
			double lowestGrade = Double.parseDouble(lowestGradeField.getText().trim());
			selectConditionVO.lowestGrade = lowestGrade;
		}
		if(!highestGradeField.getText().trim().equals("")){
			double highestGrade = Double.parseDouble(highestGradeField.getText().trim());
			selectConditionVO.highestGrade = highestGrade;
		}
		String starLevel = starLevelCombobox.getValue();
		if(starLevel!=null){
			int star = Integer.parseInt(starLevelCombobox.getValue());
			selectConditionVO.level = star;
		}
		
		//如果用户选择了预定过，就是true,否则就是false
		if(reservedButton.isSelected()){
			selectConditionVO.reserved = true;
		}else{
			selectConditionVO.reserved = false;
		}
		BrowseHotelUIController browseHotelUIController = UserUIFXMLFactory.getUserUIFXMLFactory().getBrowseHotelUIController();
		//从酒店浏览界面得到当前的hotelvolist，并对其做筛选、排序等一系列处理
		ArrayList<HotelVO> hotelVOs = browseHotelUIController.getHotelVOsOfBrowsehotel();
		hotelVOs = UserInfoUtil.getInstance().selectHotel(hotelVOs,selectConditionVO);
		
		//TODO 判断有没有选择排序方式       排序
		if(priceSortComBox.getValue()!=null){
			SortMethod priceSortMethod = SortMethod.getSortMethod(priceSortComBox.getValue().substring(2));
			hotelVOs = UserInfoUtil.getInstance().sortHotel(hotelVOs,SortBy.price, priceSortMethod);
		}
		if(starLevelSortComBox.getValue()!=null){
			SortMethod levelSortMethod = SortMethod.getSortMethod(starLevelSortComBox.getValue().substring(2));
			hotelVOs = UserInfoUtil.getInstance().sortHotel(hotelVOs,SortBy.level, levelSortMethod);
		}
		if(gradeSortComBox.getValue()!=null){
			SortMethod gradeSortMethod = SortMethod.getSortMethod(gradeSortComBox.getValue().substring(2));
			hotelVOs = UserInfoUtil.getInstance().sortHotel(hotelVOs,SortBy.grade, gradeSortMethod);
		}
	
		
		//刷新酒店浏览界面的hotelvolist
		browseHotelUIController.refresh(hotelVOs);
		//关闭条件选择界面
        UIJumpTool.getUiJumpTool().closeSelectCondition();
    }
    
    public void init() {
        ArrayList<String> priceSortCondition = new ArrayList<String>();
        priceSortCondition.add("价格从高到低");
        priceSortCondition.add("价格从低到高");
        ObservableList<String> priceSortConditionList = FXCollections.observableArrayList(priceSortCondition);
        priceSortComBox.setItems(priceSortConditionList);
        ArrayList<String> gradeSortCondition = new ArrayList<String>();
        gradeSortCondition.add("评分从高到低");
        gradeSortCondition.add("评分从低到高");
        ObservableList<String> gradeSortConditionList = FXCollections.observableArrayList(gradeSortCondition);
        gradeSortComBox.setItems(gradeSortConditionList);
        ArrayList<String> starLevelSortCondition = new ArrayList<String>();
        starLevelSortCondition.add("星级从高到低");
        starLevelSortCondition.add("星级从低到高");
		ObservableList<String> starLevelSortConditionList = FXCollections.observableArrayList(starLevelSortCondition);
		starLevelSortComBox.setItems(starLevelSortConditionList);
		ObservableList<String> starLevelObservableList = FXCollections
				.observableArrayList(new ArrayList<String>(Arrays.asList(new String[] { "1","2","3","4","5","6" })));
		starLevelCombobox.setItems(starLevelObservableList);
		ObservableList<String> roomTypeList = FXCollections
				.observableArrayList(new ArrayList<String>(Arrays.asList(new String[] { "单人间", "标准间", "其他" })));
		roomtypeCombobox.setItems(roomTypeList);
		//设置入住时间的时间选择器只能从今天开始选起
		checkinTimePicker.setValue(LocalDate.now());
		Callback<DatePicker, DateCell> checkintimeCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(LocalDate.now())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		checkinTimePicker.setDayCellFactory(checkintimeCellFactory);
		//设置离开时间的时间选择器只能从预计入住时间开始选起
//		checkoutTimePicker.setValue(checkinTimePicker.getValue());
		Callback<DatePicker, DateCell> checkouttimeCellFactory = dp -> new DateCell() {
			@Override
			public void updateItem(LocalDate item, boolean empty) {
				super.updateItem(item, empty);

				if (item.isBefore(checkinTimePicker.getValue()) || item.isEqual(checkinTimePicker.getValue())) {
					setStyle("-fx-background-color: #ffc0cb;");
					Platform.runLater(() -> setDisable(true));
				}
			}
		};
		checkoutTimePicker.setDayCellFactory(checkouttimeCellFactory);

		
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
        assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert reservedButton != null : "fx:id=\"reservedButton\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert priceSortComBox != null : "fx:id=\"priceSortComBox\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert starLevelSortComBox != null : "fx:id=\"starLevelSortComBox\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert gradeSortComBox != null : "fx:id=\"gradeSortComBox\" was not injected: check your FXML file '筛选条件.fxml'.";
        init();
	}
}

