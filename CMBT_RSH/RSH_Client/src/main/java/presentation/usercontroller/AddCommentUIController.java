package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import constant.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;
import presentation.tools.UserInfoUtil;
import vo.OrderVO;

/**
 * 用户评价界面
 * @author john
 *
 */
public class AddCommentUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label noCommentLabel;

    @FXML
    private Label encourageLabel;


    @FXML
    private ImageView addCommentImage;

    @FXML
    private Button addCommentButton;

    @FXML
    private TextArea commentTextarea;

    @FXML
    private ImageView cancelImage;
    
    @FXML
    private TextField gradeField;

    @FXML
    private Button saveButton;
    
    @FXML
    private Label messageLabel;
    
//用户点击添加评价
    @FXML
    void addComment(MouseEvent event) {
    	addCommentImage.setVisible(false);
		addCommentButton.setVisible(false);
		noCommentLabel.setVisible(false);
		encourageLabel.setVisible(false);
		saveButton.setVisible(false);
		gradeField.setVisible(true);
		commentTextarea.setVisible(true);
		gradeField.setPromptText("请输入评分");
		commentTextarea.setPromptText("请输入评价");
		commentTextarea.setWrapText(true);
		gradeField.setDisable(false);
		commentTextarea.setDisable(false);
    }

    @FXML
    void changeCancelImageToRed(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_red());
    }

    @FXML
    void changeCancleImageToGray(MouseEvent event) {
        cancelImage.setImage(ImageFactory.getImageFactory().getCancel_gray());
    }

    @FXML
    void closeAddComment(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeAddCommentToUserOrder();
    }

    //用户保存评价
    @FXML
    void saveButtonClicked(MouseEvent event) {
    	String comment = commentTextarea.getText();
    	String grade = gradeField.getText().trim();
    	if(grade==""||grade=="请输入评分"||grade==null){
    		messageLabel.setVisible(true);
    	}else {
    		if(UserInfoUtil.getInstance().addComment(comment, grade)==ResultMessage.succeed){
        		UIJumpTool.getUiJumpTool().changeAddCommentToUserOrder();
        	}
		}
    }
    
    public void init(){
    	OrderVO orderVO = UserInfoUtil.getInstance().getOrderVO();
    	if(orderVO.getComment()==null||orderVO.getComment()==""){
    		//暂无评价界面
    		addCommentImage.setVisible(true);
    		addCommentButton.setVisible(true);
    		noCommentLabel.setVisible(true);
    		encourageLabel.setVisible(true);
    		gradeField.setVisible(false);
    		commentTextarea.setVisible(false);
    		saveButton.setVisible(false);
    		messageLabel.setVisible(false);
    	}else{
    		//查看评价界面
    		addCommentImage.setVisible(false);
    		addCommentButton.setVisible(false);
    		noCommentLabel.setVisible(false);
    		encourageLabel.setVisible(false);
    		saveButton.setVisible(false);
    		messageLabel.setVisible(false);
    		gradeField.setVisible(true);
    		commentTextarea.setVisible(true);
    		gradeField.setText(String.valueOf(orderVO.getGrade()));
    		commentTextarea.setText(orderVO.getComment());
    		commentTextarea.setWrapText(true);
    		gradeField.setDisable(true);
    		commentTextarea.setDisable(true);
    	}
    }

    @FXML
    void initialize() {
        assert addCommentImage != null : "fx:id=\"addCommentImage\" was not injected: check your FXML file '添加评价.fxml'.";
        assert addCommentButton != null : "fx:id=\"addCommentButton\" was not injected: check your FXML file '添加评价.fxml'.";
        assert commentTextarea != null : "fx:id=\"commentTextarea\" was not injected: check your FXML file '添加评价.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '添加评价.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '添加评价.fxml'.";
        assert noCommentLabel != null : "fx:id=\"noCommentLabel\" was not injected: check your FXML file '添加评价.fxml'.";
        assert encourageLabel != null : "fx:id=\"encourageLabel\" was not injected: check your FXML file '添加评价.fxml'.";
        assert gradeField != null : "fx:id=\"gradeField\" was not injected: check your FXML file '添加评价.fxml'.";
        assert messageLabel != null : "fx:id=\"messageLabel\" was not injected: check your FXML file '添加评价.fxml'.";
        init();
    }
}
