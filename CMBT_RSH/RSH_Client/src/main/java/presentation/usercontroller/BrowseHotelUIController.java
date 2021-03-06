package presentation.usercontroller;

/**
 * Created by john on 2016/12/5.
 */

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import presentation.usercontrollertools.UIJumpTool;
import presentation.usercontrollertools.UserInfoUtil;
import vo.HotelVO;
/**
 * 酒店浏览界面
 * @author john
 *
 */
public class BrowseHotelUIController {
	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button selectButton;

	@FXML
	private TextField searchNameField;

	@FXML
	private Button searchByNameButton;

	@FXML
	private Label lastPageLabel;

	@FXML
	private Label nextPageLable;

	@FXML
	private TextField pageField;

	@FXML
	private GridPane gridpaneFilledWithhotel;

	private ArrayList<HotelVO> hotelVOs = new ArrayList<HotelVO>();
	private int presentPage = 1;//当前页码
	private int hotelVOsPointer = -1;
	private int maxPages = 0;

	//点击搜索按钮跳转到酒店详情界面
	@FXML
	void changeToHotelInfo(MouseEvent event) {
		searchByName();
	}
	
	@FXML
	void changeToLastPage(MouseEvent event) {
		if(presentPage-1>=1){
			presentPage--;
			gridpaneFilledWithhotel.getChildren().clear();
			changeToSpecficPage(presentPage);
		}
	}

	
	
    @FXML
    void changeToNextPage(MouseEvent event) {
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridpaneFilledWithhotel.getChildren().clear();
    		changeToSpecficPage(presentPage);
    	}
    }

    @FXML
    void changeToReferedPage(ActionEvent event) {
    	int page = Integer.parseInt(pageField.getText().trim());
    	if(page>=1){
    		if(page>maxPages){
    			presentPage = maxPages;
    		}else {
				presentPage = page;
			}
    		gridpaneFilledWithhotel.getChildren().clear();
    		changeToSpecficPage(presentPage);
    	}else{
    		pageField.setText(String.valueOf(presentPage));
    	}
    }
    
    //跳转到指定的页数
	private void changeToSpecficPage(int page) {
		hotelVOsPointer = (page - 1) * 4;
		pageField.setText(String.valueOf(page));
		int count = 0;
		while (count < 4) {// 一个界面上有四个格子
			boolean left = false;
			if (count % 2 == 0) {
				left = true;
			}
			if(hotelVOsPointer==hotelVOs.size()){
				break;
			}
			BrowseHotelAnchorPane browseHotelAnchorPane = new BrowseHotelAnchorPane(hotelVOs.get(hotelVOsPointer), left);
			switch (count) {
			case 0:
				gridpaneFilledWithhotel.add(browseHotelAnchorPane, 0, 0);
				break;
			case 1:
				gridpaneFilledWithhotel.add(browseHotelAnchorPane, 1, 0);
				break;
			case 2:
				gridpaneFilledWithhotel.add(browseHotelAnchorPane, 0, 1);
				break;
			case 3:
				gridpaneFilledWithhotel.add(browseHotelAnchorPane, 1, 1);
				break;
			default:
				break;
			}
			
			hotelVOsPointer++;
			count ++;
		}
	}

    //点击筛选条件按钮，跳出筛选条件界面
    @FXML
    void changeToSelectCondition(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeToSelectCondition();
        
    }

    //在搜索框内通过酒店名字搜索
    @FXML
    void searchByName(ActionEvent event) {
    	searchByName();
    }
    
    //根据酒店名称搜索酒店，并跳转到具体的酒店详情界面
    private void searchByName(){
        String hotelName = searchNameField.getText().trim();
        boolean found  = false;
        for(int i=0;i<hotelVOs.size();i++){
        	if(hotelVOs.get(i).getHotelName().equals(hotelName)){
 //       		UserInfoUtil.getInstance().setHotelName(hotelName);
        		UserInfoUtil.getInstance().setHotelID(hotelVOs.get(i).getHotelID());
                UIJumpTool.getUiJumpTool().changeBrowseHotelToHotelInfo();
                found = true;
        	}
        }
        if(!found){
        	//TODO 未找到提示
        }
    }
    
    public ArrayList<HotelVO> getHotelVOsOfBrowsehotel() {
		return hotelVOs;
	}
    
    /**
     * 筛选条件界面调用，用于刷新酒店浏览界面
     * @param hotelVOs
     */
    public void refresh(ArrayList<HotelVO> hotelVOs) {
		this.hotelVOs = hotelVOs;
		gridpaneFilledWithhotel.getChildren().clear();
		presentPage = 1;
		if(hotelVOs.size()%4==0){
			maxPages = hotelVOs.size()/4;
		}else{
			maxPages = hotelVOs.size()/4 + 1;
		}
		changeToSpecficPage(presentPage);
	}
    
    public void init() {
    	UserInfoUtil userInfoUtil = UserInfoUtil.getInstance();
		hotelVOs = userInfoUtil.getHotelVOs();
		if(hotelVOs.size()%4==0){
			maxPages = hotelVOs.size()/4;
		}else{
			maxPages = hotelVOs.size()/4 + 1;
		}
		changeToSpecficPage(1);
	}

	@FXML
	void initialize() {
		assert selectButton != null : "fx:id=\"selectButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		assert searchNameField != null : "fx:id=\"searchNameField\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		assert searchByNameButton != null : "fx:id=\"searchByNameButton\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		assert lastPageLabel != null : "fx:id=\"lastPageLabel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		assert nextPageLable != null : "fx:id=\"nextPageLable\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		assert gridpaneFilledWithhotel != null : "fx:id=\"gridpaneFilledWithhotel\" was not injected: check your FXML file '酒店浏览（用户视角）.fxml'.";
		
		init();
	}
}
