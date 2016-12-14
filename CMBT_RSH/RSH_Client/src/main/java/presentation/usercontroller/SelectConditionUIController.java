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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import presentation.tools.UserInfoUtil;
import presentation.tools.UserUIFXMLFactory;
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

    @SuppressWarnings("null")
	@FXML
    void finishSelect(MouseEvent event) {
        //TODO 判断用户是否输入了这一项
    	//筛选
    	SelectConditionVO selectConditionVO = null;
    	String roomType = roomtypeCombobox.getValue();
    	selectConditionVO.roomType = roomType;
    	double lowestPrice = Double.parseDouble(lowestPriceField.getText().trim());
    	selectConditionVO.lowestPrice = lowestPrice;
    	double highestPrice = Double.parseDouble(highestPriceField.getText().trim());
    	selectConditionVO.highestPrice = highestPrice;
    	//将;ocaldate转换成date
		ZonedDateTime startZonedTime = checkinTimePicker.getValue().atStartOfDay(ZoneId.systemDefault());
		Instant startInstant = Instant.from(startZonedTime);
		selectConditionVO.begin = Date.from(startInstant);
		ZonedDateTime endZonedTime = checkoutTimePicker.getValue().atStartOfDay(ZoneId.systemDefault());
		Instant endInstant = Instant.from(endZonedTime);
		selectConditionVO.end = Date.from(endInstant);
		int roomNum = Integer.parseInt(roomNumField.getText().trim());
		selectConditionVO.roomNum = roomNum;
		double lowestGrade = Double.parseDouble(lowestGradeField.getText().trim());
		selectConditionVO.lowestGrade = lowestGrade;
		double highestGrade = Double.parseDouble(highestGradeField.getText().trim());
		selectConditionVO.highestGrade = highestGrade;
		int starLevel = Integer.parseInt(starLevelCombobox.getValue());
		selectConditionVO.level = starLevel;
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
		SortMethod priceSortMethod = SortMethod.getSortMethod(priceSortComBox.getValue().substring(2));
		hotelVOs = UserInfoUtil.getInstance().sortHotel(hotelVOs,SortBy.price, priceSortMethod);
		SortMethod levelSortMethod = SortMethod.getSortMethod(starLevelSortComBox.getValue().substring(2));
		hotelVOs = UserInfoUtil.getInstance().sortHotel(hotelVOs,SortBy.level, levelSortMethod);
		SortMethod gradeSortMethod = SortMethod.getSortMethod(gradeSortComBox.getValue().substring(2));
		hotelVOs = UserInfoUtil.getInstance().sortHotel(hotelVOs,SortBy.grade, gradeSortMethod);
		//刷新酒店浏览界面的hotelvolist
		browseHotelUIController.setHotelVOsOfBrowsehotel(hotelVOs);
		//关闭条件选择界面
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
        assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert reservedButton != null : "fx:id=\"reservedButton\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert priceSortComBox != null : "fx:id=\"priceSortComBox\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert starLevelSortComBox != null : "fx:id=\"starLevelSortComBox\" was not injected: check your FXML file '筛选条件.fxml'.";
        assert gradeSortComBox != null : "fx:id=\"gradeSortComBox\" was not injected: check your FXML file '筛选条件.fxml'.";

        //TODO combox的默认
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
				.observableArrayList(new ArrayList<String>(Arrays.asList(new String[] { "单人间", "双人间", "其他" })));
		roomtypeCombobox.setItems(roomTypeList);
	}
}

