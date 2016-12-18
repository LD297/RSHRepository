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
import vo.WebSalesmanVO;

/**
 * 管理网站营销人员界面
 * @author john
 *
 */
public class ManafeWebsalesmanUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Label lastPagelabel;

    @FXML
    private Label nextPageLabel;

    @FXML
    private TextField pageField;

    @FXML
    private TextField websalesmanIDField;

    @FXML
    private Button addWebSalesmanButton;
    
    @FXML
    private GridPane gridpaneFilledWithWebSalesman;

    @FXML
    private ImageView backImage;
    private ArrayList<WebSalesmanVO> webSalesmanVOs = new ArrayList<>();
   	private int presentPage = 1;//当前页码
   	private int webSalesmanPointer = -1;
   	private int maxPages = 0;


    
    @FXML
    void backToHomePage(MouseEvent event) {
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
    void changeToAddWebSalesman(MouseEvent event) {
    	AnchorPane addWebSalesman = WebManagerUIFXMLFactory.getInstance().getAddWebSalesman();
    	anchorPane.getChildren().add(addWebSalesman);
    }

    @FXML
    void changeToLastPage(MouseEvent event) {
    	if(presentPage-1>=1){
			presentPage--;
			gridpaneFilledWithWebSalesman.getChildren().clear();
			changeToReferedPage(presentPage);
		}
    }

    @FXML
    void changeToModifyWebsalesman(ActionEvent event) {
    	AnchorPane modifyWebSalesman = WebManagerUIFXMLFactory.getInstance().getModifyWebSalesman();
    	anchorPane.getChildren().add(modifyWebSalesman);
    }

    @FXML
    void changeToNextPage(MouseEvent event) {
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridpaneFilledWithWebSalesman.getChildren().clear();
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
    		gridpaneFilledWithWebSalesman.getChildren().clear();
    		changeToReferedPage(presentPage);
    	}else{//page小于0,不予反应
    		pageField.setText(String.valueOf(presentPage));
    	}
    }

    
    private void changeToReferedPage(int page){
    	pageField.setText(String.valueOf(page));
		webSalesmanPointer = (page - 1) * 5;
		int count = 0;
		while (count < 5) {// 一个界面上有5个格子
			if (webSalesmanPointer == webSalesmanVOs.size()) {
				break;
			}
			SingleWebSalesmanAnchorPane singleWebSalesmanAnchorPane = new SingleWebSalesmanAnchorPane(webSalesmanVOs.get(webSalesmanPointer));
			gridpaneFilledWithWebSalesman.add(singleWebSalesmanAnchorPane, 0, count*2+1);
			webSalesmanPointer++;
			count++;
		}
    }
    
    public void init() {
		webSalesmanVOs = WebManagerInfoUtil.getInstance().getWebSalesmanVOs();
		maxPages = (webSalesmanVOs.size()+4)/5;
		changeToReferedPage(1);
	}
    
    @FXML
    void initialize() {
        assert anchorPane != null : "fx:id=\"anchorPane\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert websalesmanIDField != null : "fx:id=\"websalesmanIDField\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert addWebSalesmanButton != null : "fx:id=\"addWebSalesmanButton\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert backImage != null : "fx:id=\"backImage\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert gridpaneFilledWithWebSalesman != null : "fx:id=\"gridpaneFilledWithWebSalesman\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        assert lastPagelabel != null : "fx:id=\"lastPagelabel\" was not injected: check your FXML file '网管_管理营销人员.fxml'.";
        init();
    }
}
