package presentation.webmanagercontroller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import presentation.tools.WebManagerInfoUtil;
import presentation.tools.WebManagerUIFXMLFactory;
import presentation.usercontroller.SingleCreditRecordAnchorPane;
import vo.UserVO;

/**
 * 网站管理人员管理用户信息
 * @author john
 *
 */
public class ManageUserUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridpaneFilledWithUser;

    @FXML
    private Label lastPagelabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private TextField idField;

    @FXML
    private ImageView backImage;

    @FXML
    private AnchorPane anchorPane;

    private ArrayList<UserVO> userVOs = new ArrayList<>();
	private int presentPage = 1;//当前页码
	private int userVOsPointer = -1;
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
    
    //在输入用户手机号之后按enter键定位到具体一个用户，查看该用户信息
    @FXML
    void changeToCheckUserInfo(ActionEvent event) {
    	AnchorPane checkUserInfo = WebManagerUIFXMLFactory.getInstance().getCheckUserInfo();
    	anchorPane.getChildren().add(checkUserInfo);
    }
    
    @FXML
    void changeToLastPage(MouseEvent event) {
    	if(presentPage-1>=1){
			presentPage--;
			gridpaneFilledWithUser.getChildren().clear();
			changeToReferedPage(presentPage);
		}
    }

    @FXML
    void changeToNextPage(MouseEvent event) {
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridpaneFilledWithUser.getChildren().clear();
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
    		gridpaneFilledWithUser.getChildren().clear();
    		changeToReferedPage(presentPage);
    	}else{//page小于0,不予反应
    		pageField.setText(String.valueOf(presentPage));
    	}
    }
    
    private void changeToReferedPage(int page){
    	pageField.setText(String.valueOf(page));
		userVOsPointer = (page - 1) * 4;
		int count = 0;
		while (count < 4) {// 一个界面上有4个格子
			if (userVOsPointer == userVOs.size()) {
				break;
			}
			SingleUserAnchorPane singleUserAnchorPane = new SingleUserAnchorPane(userVOs.get(userVOsPointer));
			gridpaneFilledWithUser.add(singleUserAnchorPane, 0, count*2+1);
			userVOsPointer++;
			count++;
		}
    }

    public void init() {
		userVOs = WebManagerInfoUtil.getInstance().getUserVOs();
		maxPages = (userVOs.size()+3)/4;
		changeToReferedPage(1);
	}
    
    
    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网管_管理用户.fxml'.";
    	assert gridpaneFilledWithUser != null : "fx:id=\"gridpaneFilledWithUser\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert idField != null : "fx:id=\"idField\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网站管理人员 。用户.fxml'.";
        init();
    }
}
