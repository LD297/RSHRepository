package presentation.usercontroller;


import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import presentation.tools.UserInfoUtil;
import vo.HotelVO;
import vo.OrderVO;

public class CommentUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private GridPane gridPaneFilledWithComment;

    @FXML
    private TextField pageField;

    @FXML
    private Label lastPageLabel;

    @FXML
    private Label nextPageLabel;
    

	private ArrayList<OrderVO> orderVOs = null;
	private int presentPage = 1;//当前页码
	private int orderVOsPointer = -1;
	private int maxPages = 0;

    @FXML
    void changeToLastPage(MouseEvent event) {
    	if(presentPage-1>=1){
			presentPage--;
			gridPaneFilledWithComment.getChildren().clear();
			changeToSpecificPage(presentPage);
		}
    }

    @FXML
    void changeToNextPage(MouseEvent event) {
    	if(presentPage+1<=maxPages){
    		presentPage++;
    		gridPaneFilledWithComment.getChildren().clear();
    		changeToSpecificPage(presentPage);
    	}
    }

    @FXML
    void changeToReferedPage(ActionEvent event) {
    	int page = Integer.parseInt(pageField.getText().trim());
    	if(page>=1){
    		presentPage = page;
    		gridPaneFilledWithComment.getChildren().clear();
    		changeToSpecificPage(presentPage);
    	}else{//page小于0,不予反应
    		pageField.setText(String.valueOf(presentPage));
    	}
    }

    private void init(){
    	UserInfoUtil userInfoUtil = UserInfoUtil.getInstance();
		orderVOs = userInfoUtil.getOrderVOsWithComment();
		maxPages = (orderVOs.size()+1)/2;
		changeToSpecificPage(1);
    }
    
    //跳转到指定的页数
    private void changeToSpecificPage(int page) {
    	//直接跳转到最后一页
		if(page>=maxPages){
			orderVOsPointer = (maxPages-1)*2;
		}else{
			orderVOsPointer = (page-1)*2;
		}
		int count = 0;
		while(count<2){//一个界面上有2个格子
			if(orderVOsPointer==orderVOs.size()){
				break;
			}
			CommentAnchorPane commentAnchorPane = new CommentAnchorPane(orderVOs.get(orderVOsPointer));
			gridPaneFilledWithComment.add(commentAnchorPane, 0, count);
			orderVOsPointer++;
			count ++;
		}
	}
    
    
    @FXML
    void initialize() {
        assert gridPaneFilledWithComment != null : "fx:id=\"gridPaneFilledWithComment\" was not injected: check your FXML file '查看评价.fxml'.";
        assert pageField != null : "fx:id=\"pageField\" was not injected: check your FXML file '查看评价.fxml'.";
        assert lastPageLabel != null : "fx:id=\"lastPageLabel\" was not injected: check your FXML file '查看评价.fxml'.";
        assert nextPageLabel != null : "fx:id=\"nextPageLabel\" was not injected: check your FXML file '查看评价.fxml'.";
        init();
    }
}
