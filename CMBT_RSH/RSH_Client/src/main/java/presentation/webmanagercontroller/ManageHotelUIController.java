package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.tools.WebManagerInfoUtil;
import presentation.tools.WebManagerUIFXMLFactory;
import vo.HotelVO;

public class ManageHotelUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private GridPane gridpaneFilledWithHotel;

    @FXML
    private Label lastPagelabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private TextField hotelIDField;

    @FXML
    private Button addHotelButton;

    @FXML
    private ImageView backImage;
    
    private ArrayList<HotelVO> hotelVOs = new ArrayList<>();
   	private int presentPage = 1;//当前页码
   	private int hotelVOsPointer = -1;
   	private int maxPages = 0;

    @FXML
    void backToHomepage(MouseEvent event) {
    	Stage stage = (Stage)backImage.getScene().getWindow();
    	Scene scene = null;
    	AnchorPane homepageAnchorPane = WebManagerUIFXMLFactory.getInstance().getManageHomepage();
    	if(homepageAnchorPane.getScene()!=null){
    		scene = homepageAnchorPane.getScene();
    	}else {
			scene = new Scene(homepageAnchorPane,800,720);
		}
    	stage.setScene(scene);
    }

    @FXML
    void changeToAddHotel(MouseEvent event) {
    	AnchorPane addHotel = WebManagerUIFXMLFactory.getInstance().getAddHotel();
    	anchorPane.getChildren().add(addHotel);
    }

    @FXML
    void changeToLastPage(MouseEvent event) {
    	if(presentPage-1>=1){
			presentPage--;
			gridpaneFilledWithHotel.getChildren().clear();
			changeToReferedPage(presentPage);
		}
    }

    //在搜索框输入酒店id直接定位到一个具体的酒店，跳转到修改酒店信息界面
    @FXML
    void changeToModifyHotelInfo(ActionEvent event) {
    	boolean found = false;
    	String id = hotelIDField.getText().trim();
    	for (int i = 0; i < hotelVOs.size(); i++) {
			if(hotelVOs.get(i).hotelID.equals(id)){
				AnchorPane modifyHotel = WebManagerUIFXMLFactory.getInstance().getModifyHotel();
				ModifyHotelUIController modifyHotelUIController = WebManagerUIFXMLFactory.getInstance().getModifyHotelUIController();
				modifyHotelUIController.init(hotelVOs.get(i));
		    	anchorPane.getChildren().add(modifyHotel);
		    	found = true;
		    	break;
			}
		}
    	if(!found){
    		//TODO 没有找到该酒店的提示
    	}
    }

    @FXML
    void changeToNextPage(MouseEvent event) {
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridpaneFilledWithHotel.getChildren().clear();
    		changeToReferedPage(presentPage);
    	}
    }

    @FXML
    void changeToSpecificPage(ActionEvent event) {
    	int page = Integer.parseInt(pageField.getText().trim());
    	if(page>=1){
    		if(page>maxPages){
    			presentPage = maxPages;
    		}else {
				presentPage = page;
			}
    		gridpaneFilledWithHotel.getChildren().clear();
    		changeToReferedPage(presentPage);
    	}else{//page小于0,不予反应
    		pageField.setText(String.valueOf(presentPage));
    	}
    }
    private void changeToReferedPage(int page){
    	pageField.setText(String.valueOf(page));
		hotelVOsPointer = (page - 1) * 4;
		int count = 0;
		while (count < 4) {// 一个界面上有4个格子
			if (hotelVOsPointer == hotelVOs.size()) {
				break;
			}
			SingleHotelAnchorPane singleHotelAnchorPane = new SingleHotelAnchorPane(hotelVOs.get(hotelVOsPointer));
			gridpaneFilledWithHotel.add(singleHotelAnchorPane, 0, count*2+1);
			hotelVOsPointer++;
			count++;
		}
    }
    
    public void init() {
    	hotelIDField.setText("");
    	presentPage = 1;
    	pageField.setText(String.valueOf(presentPage));
    	hotelVOs = WebManagerInfoUtil.getInstance().getHotelVOs();
		maxPages = (hotelVOs.size()+3)/4;
		gridpaneFilledWithHotel.getChildren().clear();
		changeToReferedPage(presentPage);
	}

    @FXML
    void initialize() {
    	assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
    	assert gridpaneFilledWithHotel != null : "fx:id=\"gridpaneFilledWithHotel\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert hotelIDField != null : "fx:id=\"hotelIDField\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert addHotelButton != null : "fx:id=\"addHotelButton\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网管_管理酒店.fxml'.";
        init();
    }
}
