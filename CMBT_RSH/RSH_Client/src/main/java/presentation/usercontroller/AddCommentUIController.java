package presentation.usercontroller;

/**
 * Created by john on 2016/12/7.
 */

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import presentation.tools.ImageFactory;
import presentation.tools.UIJumpTool;

public class AddCommentUIController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView addCommentImage;

    @FXML
    private Button addCommentButton;

    @FXML
    private TextArea commentTextarea;

    @FXML
    private ImageView cancelImage;

    @FXML
    private Button saveButton;

    @FXML
    void addComment(MouseEvent event) {
        commentTextarea.setEditable(true);
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

    @FXML
    void saveButtonClicked(MouseEvent event) {
        UIJumpTool.getUiJumpTool().changeAddCommentToUserOrder();
    }

    @FXML
    void initialize() {
        assert addCommentImage != null : "fx:id=\"addCommentImage\" was not injected: check your FXML file '添加评价.fxml'.";
        assert addCommentButton != null : "fx:id=\"addCommentButton\" was not injected: check your FXML file '添加评价.fxml'.";
        assert commentTextarea != null : "fx:id=\"commentTextarea\" was not injected: check your FXML file '添加评价.fxml'.";
        assert cancelImage != null : "fx:id=\"cancelImage\" was not injected: check your FXML file '添加评价.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file '添加评价.fxml'.";

    }
}
