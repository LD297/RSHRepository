package presentation.usercontroller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import presentation.tools.MyDateFormat;
import presentation.tools.UserInfoUtil;
import vo.CreditRecordVO;

public class UserCreditRecordUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label yearLabel;

    @FXML
    private Label dayOfTodayLabel;

    @FXML
    private Label monthdayOfTodayLabel;

    @FXML
    private Label weekOfTodayLabel;

    @FXML
    private Label lastPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private Label nextPageLabel;

    @FXML
    private GridPane gridPaneFilledWithCreditrecord;
    

	private ArrayList<CreditRecordVO> creditRecordVOs= new ArrayList<CreditRecordVO>();
	private int presentPage = 1;//当前页码
	private int creditRecordVOsPointer = -1;
	private int maxPages = 0;

    @FXML
    void changeToLastPage(MouseEvent event) {
    	if(presentPage-1>=1){
			presentPage--;
			gridPaneFilledWithCreditrecord.getChildren().clear();
			changeToSpecificPage(presentPage);
		}
    }

    @FXML
    void changeToNextPage(MouseEvent event) {
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridPaneFilledWithCreditrecord.getChildren().clear();
    		changeToSpecificPage(presentPage);
    	}
    }

    @FXML
    void changeToSpecficPage(ActionEvent event) {
    	int page = Integer.parseInt(pageField.getText().trim());
    	if(page>=1){
    		if(page>maxPages){
    			presentPage = maxPages;
    		}else {
				presentPage = page;
			}
    		gridPaneFilledWithCreditrecord.getChildren().clear();
    		changeToSpecificPage(presentPage);
    	}else{//page小于0,不予反应
    		pageField.setText(String.valueOf(presentPage));
    	}
    }
    
    //跳转到指定的页数
	private void changeToSpecificPage(int page) {
		pageField.setText(String.valueOf(page));
		creditRecordVOsPointer = (page - 1) * 5;
		int count = 0;
		while (count < 5) {// 一个界面上有2个格子
			if (creditRecordVOsPointer == creditRecordVOs.size()) {
				break;
			}
			SingleCreditRecordAnchorPane singleCreditRecordAnchorPane = new SingleCreditRecordAnchorPane(
					creditRecordVOs.get(creditRecordVOsPointer));
			gridPaneFilledWithCreditrecord.add(singleCreditRecordAnchorPane, 0, count);
			creditRecordVOsPointer++;
			count++;
		}
	}
    
    public void init(){
    	UserInfoUtil userInfoUtil = UserInfoUtil.getInstance();
		creditRecordVOs = userInfoUtil.getCreditRecordVOs();
		maxPages = (creditRecordVOs.size()+4)/5;
		changeToSpecificPage(1);
		// 初始化日历
		dayOfTodayLabel.setText(new SimpleDateFormat("dd").format(new Date()));
		monthdayOfTodayLabel.setText(new SimpleDateFormat("yyyy.MM").format(new Date()));
		weekOfTodayLabel.setText(MyDateFormat.getInstance().getWeek(new Date()));
    }

    @FXML
    void initialize() {
        assert yearLabel != null : "fx:id=\"yearLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert dayOfTodayLabel != null : "fx:id=\"dayOfTodayLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert monthdayOfTodayLabel != null : "fx:id=\"monthdayOfTodayLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert weekOfTodayLabel != null : "fx:id=\"weekOfTodayLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert lastPageLabel != null : "fx:id=\"lastPageLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '信用记录.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '信用记录.fxml'.";
        assert gridPaneFilledWithCreditrecord != null : "fx:id=\"gridPaneFilledWithCreditrecord\" was not injected: check your FXML file '信用记录.fxml'.";
        init();
    }
}
